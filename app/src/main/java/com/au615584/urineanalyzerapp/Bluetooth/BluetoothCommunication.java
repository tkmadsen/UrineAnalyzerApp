package com.au615584.urineanalyzerapp.Bluetooth;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.util.Log;
import android.widget.Toast;

import com.au615584.urineanalyzerapp.UrineAnalyzerApplication;

import org.checkerframework.checker.units.qual.A;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Set;
import java.util.UUID;

public class BluetoothCommunication {
  private BluetoothAdapter btAdapter;
  private BluetoothDevice btDevice;
  BluetoothSocket socket;
  private Set<BluetoothDevice> pairedDevices;

  public boolean isBluetoothEnabled() {
    btAdapter = BluetoothAdapter.getDefaultAdapter();

    if(btAdapter.isEnabled()) {
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

    if(pairedDevices.size() < 1) {
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
    } catch(IOException e) {
      Log.e("BTConnection", "Fail in starting connectThread", e);
    }
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
      } catch(IOException e) {
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
      write();
    }

    public void write() throws IOException {
      String msg = "Hej bac";
      OutputStream outputStream = socket.getOutputStream();
      outputStream.write(msg.getBytes());
    }
  }
}
