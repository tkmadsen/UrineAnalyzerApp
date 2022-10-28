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
  BluetoothSocket socket;
  private Set<BluetoothDevice> pairedDevices;
  private String readMessage = null;
  public MutableLiveData<String> state;

  public BluetoothCommunication() {
    state = new MutableLiveData<>("Welcome");
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
        if (btDevice.getAddress().equals("B8:27:EB:43:01:2A")) {
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
      new ConnectThread1(device).start();
    } catch (IOException e) {
      Log.e("BTConnection", "Fail in starting connectThread", e);
    }
  }

  public void changeState(String btMessage) {
    int rpiProtocol = btMessage.charAt(0);
    switch(rpiProtocol) {
      case 1:
        state.postValue("Guide");
        break;
      case 2:
        state.postValue("Guide"); //TODO evt lav en processing fragment
        break;
      case 3:
        state.postValue("Result");
        break;
      default:
        state.postValue("Welcome");
        break;
    }
  }

  public LiveData<String> fragmentState() {
    if(state == null) {
      state = new MutableLiveData<>();
    }
    return state;
  }

  public class ConnectThread1 extends Thread {

    @SuppressLint("MissingPermission")
    private ConnectThread1(BluetoothDevice device) throws IOException {
      BluetoothSocket tmp = null;
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
      //write();
      readMessage();
    }

    public void write() throws IOException {
      String msg = "Hej bac";
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
}
