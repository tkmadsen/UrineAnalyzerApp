package com.au615584.urineanalyzerapp.Bluetooth;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.os.Build;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.au615584.urineanalyzerapp.Repositories.EPJRepository;
import com.au615584.urineanalyzerapp.UrineAnalyzerApplication;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Set;
import java.util.UUID;

// Bluetoothconnection is the client-side in the Bluetooth-communication between UrineAnalyzerApp and
//UrineAnalyzerController. This initiates the request and handles write and read methods.
public class BluetoothConnection implements IBluetoothConnection {
  private BluetoothAdapter btAdapter;
  private BluetoothDevice btDevice;
  private Set<BluetoothDevice> pairedDevices;
  private String readMessage = null;
  private MutableLiveData<String> btMessage;
  public MutableLiveData<Boolean> isBtConnected;
  public EPJRepository epjRepository;

  public BluetoothConnection() {
    btMessage = new MutableLiveData<>("");
    isBtConnected = new MutableLiveData<>(true);
    epjRepository = EPJRepository.getInstance();
  }

  public boolean isBluetoothEnabled() {
    btAdapter = BluetoothAdapter.getDefaultAdapter();

    if (btAdapter.isEnabled()) {
      return true;
    } else {
      return false;
    }
  }

  @SuppressLint("MissingPermission")
  public String findDeviceAddress() {
    //UrineAnalyzerController and tablet which runs UrineAnalyzerApp have to be paired once.
    ArrayList deviceList = new ArrayList();
    String address = null;
    pairedDevices = btAdapter.getBondedDevices();

    if (pairedDevices.size() < 1) {
      Toast.makeText(UrineAnalyzerApplication.getAppContext(), "No paired devices found", Toast.LENGTH_SHORT).show();
    } else {
      for (BluetoothDevice btDevice : pairedDevices) {
        //Hardcoded RPi MAC-adress. Should be moved to a database in an ideal project.
        if (btDevice.getAddress().equals("B8:27:EB:C5:3C:8F")) {
          address = btDevice.getAddress();
        }
      }
    }
    return address;
  }


  public void connectToRemoteDevice() {
    String deviceAddress = findDeviceAddress();
    final BluetoothDevice device = btAdapter.getRemoteDevice(deviceAddress);
    try {
      new ConnectThread(device).start();
    } catch (IOException e) {
      Log.e("BTConnection", "Fail in starting connectThread", e);
      isBtConnected.postValue(false);

    }
  }

  public class ConnectThread extends Thread {

    private final BluetoothSocket socket;
    private final InputStream mmInputStream;
    private final OutputStream mmOutputStream;


    //Thread creates input- and outputsockets, from which messages af read from and send through to
    //UrineAnalyzerController.
    //Is threaded to prevent the UI from freezing when creating connection and listenning on inputsocket.
    @SuppressLint("MissingPermission")
    private ConnectThread(BluetoothDevice device) throws IOException {
      BluetoothSocket tmp = null;
      InputStream tmpIn = null;
      OutputStream tmpOut = null;

      btDevice = device;

      try {
        UUID uuid = UUID.fromString("94f39d29-7d6d-437d-973b-fba39e49d4ee");
        Log.d("BTConnection", "Creating RfcommSocket");
        tmp = btDevice.createRfcommSocketToServiceRecord(uuid);
      } catch (IOException e) {
        Log.e("BTConnection", "Socket's create method failed", e);
        isBtConnected.postValue(false);
      }

      socket = tmp;
      btAdapter.cancelDiscovery();

      try {
        Log.d("BTConnection", "Creating connection to socket");
        socket.connect();
      } catch (IOException connectException) {
        Log.e("BTConnection", "Socket's connect method failed", connectException);
        isBtConnected.postValue(false);
      }


      try {
        tmpIn = socket.getInputStream();
        tmpOut = socket.getOutputStream();
      } catch (IOException e) {
        e.printStackTrace();
      }

      mmInputStream = tmpIn;
      mmOutputStream = tmpOut;
    }

    //Run is an asynchrone method that listens on the inputsocket at all times
    //Is a thread since this method would freeze the UI.
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void run(){
      byte[] buffer = new byte[1024];  // buffer store for the stream

      int bytes; // bytes returned from read()

      // Keep listening to the InputStream until an exception occurs
      while (true) {
        // Read from the InputStream
        try {
          bytes = mmInputStream.read(buffer);
          String incomingMessage = new String(buffer, 0, bytes);
          Log.d("BTConnection", "InputStream: " + incomingMessage);
          //saveIncoming(incomingMessage);
          btMessage.postValue(incomingMessage);
        } catch (IOException e) {
          Log.e("BTConnection", "write: Error reading Input Stream. " + e.getMessage() );
          isBtConnected.postValue(false);
          break;
        }
      }
    }

    public void write(String msg) throws IOException {
      OutputStream outputStream = socket.getOutputStream();
      outputStream.write(msg.getBytes());
    }
  }

//btMessage is used to update the rest of the app, when there is an incoming message
  public LiveData<String> btMessage() {
    if(btMessage == null) {
      btMessage = new MutableLiveData<>();
    }
    return btMessage;
  }

  //isBtConnected is used to update the rest of the app about whether bluetooth is connected or not.
  //If bluetooth is not connected or interrupted the fragment BtFailFragment will be shown to inform the user
  public LiveData<Boolean> isBtConnected() {
    if(isBtConnected == null) {
      isBtConnected = new MutableLiveData<>();
    }
    return isBtConnected;
  }

}
