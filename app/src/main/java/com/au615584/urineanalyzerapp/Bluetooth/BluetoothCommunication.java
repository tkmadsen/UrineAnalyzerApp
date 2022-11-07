package com.au615584.urineanalyzerapp.Bluetooth;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.au615584.urineanalyzerapp.UrineAnalyzerApplication;

import org.checkerframework.checker.units.qual.A;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Set;
import java.util.UUID;

public class BluetoothCommunication {
  private BluetoothAdapter btAdapter;
  private BluetoothDevice btDevice;
  private Set<BluetoothDevice> pairedDevices;
  private String readMessage = null;
  public MutableLiveData<String> state;
  public MutableLiveData<String> cpr;
  private MutableLiveData<String> result;

  public BluetoothCommunication() {
    state = new MutableLiveData<>("Welcome");
    cpr= new MutableLiveData<>("CPRdefault");
    result= new MutableLiveData<>("resultDefault");
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
    ArrayList deviceList = new ArrayList();
    String address = null;
    pairedDevices = btAdapter.getBondedDevices();

    if (pairedDevices.size() < 1) {
      Toast.makeText(UrineAnalyzerApplication.getAppContext(), "No paired devices found", Toast.LENGTH_SHORT).show();
    } else {
      for (BluetoothDevice btDevice : pairedDevices) {
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
    }
  }

  public void changeState(String btMessage) {
    Log.d("BTConnection", "Reached changeState()");
    Character rpiProtocol = btMessage.charAt(0);
    Log.d("BTConnection", "btMessage: " + btMessage);
    Log.d("BTConnection", "int for RpiProtocol: " + rpiProtocol);
    switch(rpiProtocol) {
      case '1':
        state.postValue("Guide");
        Log.d("BTConnection", "ChangeState(), Received 1");
        break;
      case '2':
        state.postValue("Analyzing");
        Log.d("BTConnection", "ChangeState(), Received 2");
        break;
      case '3':
        state.postValue("Result");
        Log.d("BTConnection", "ChangeState(), Received 3");
        break;
      case '4':
        state.postValue("Welcome");
        Log.d("BTConnection", "ChangeState(), Received 5");
        break;
      default:
        state.postValue("Welcome");
        Log.d("BTConnection", "ChangeState(), default");

    }
  }

  public LiveData<String> fragmentState() {
    if(state == null) {
      state = new MutableLiveData<>();
    }
    return state;
  }

  public class ConnectThread extends Thread {

    private final BluetoothSocket socket;
    private final InputStream mmInputStream;
    private final OutputStream mmOutputStream;


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
      }

      socket = tmp;
      btAdapter.cancelDiscovery();

      try {
        Log.d("BTConnection", "Creating connection to socket");
        socket.connect();
      } catch (IOException connectException) {
        Log.e("BTConnection", "Socket's connect method failed", connectException);
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
          saveIncoming(incomingMessage);
          changeState(incomingMessage);
        } catch (IOException e) {
          Log.e("BTConnection", "write: Error reading Input Stream. " + e.getMessage() );
          break;
        }
      }
    }

    public void write(String msg) throws IOException {
      OutputStream outputStream = socket.getOutputStream();
      outputStream.write(msg.getBytes());
    }

    public void readMessage() throws IOException {
      String readMessage1 = null;
      while(readMessage1 == null) {
        InputStream mmInputStream = socket.getInputStream();
        byte[] buffer = new byte[1048];
        int bytes;

        try {
          bytes = mmInputStream.read(buffer);
          readMessage1 = new String(buffer, 0, bytes);
          Log.d("BTConnection", "Received: " + readMessage1);
          changeState(readMessage1);
        } catch (IOException e) {
          Log.e("BTConnection", "Problems occurred!");
        }
      }

    }

    public String receive() throws IOException {
      readMessage = null;
      //readMessage = readMessage();

      return readMessage;
    }
  }

  private void saveIncoming(String incomingMessage) {
    if(incomingMessage.charAt(0)=='1'){
      cpr.postValue(incomingMessage.substring(1));
      Log.d("BTConnection", "saveCPR: "+cpr);
    } else if (incomingMessage.charAt(0) == '3'){
      result.postValue(incomingMessage.substring(1));
      Log.d("BTConnection", "saveResult: " + result );
    }
    /*
    else if (incomingMessage.charAt(0)==X){
      result.postValue(incomingMessage.substring(1));
      Log.d("BTConnection", "saveCPR: "+result);
    }
     */
  }

  public LiveData<String> cprString() {
    if(cpr == null) {
      cpr = new MutableLiveData<>();
    }
    return cpr;
  }
  public LiveData<String> resultString() {
    if(result == null) {
      result = new MutableLiveData<>();
    }
    return result;
  }
}
