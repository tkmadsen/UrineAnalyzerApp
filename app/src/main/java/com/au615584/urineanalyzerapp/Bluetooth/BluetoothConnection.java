package com.au615584.urineanalyzerapp.Bluetooth;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.util.Log;
import android.widget.Toast;
import com.au615584.urineanalyzerapp.UrineAnalyzerApplication;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Set;
import java.util.UUID;

public class BluetoothConnection {

  private BluetoothAdapter btAdapter;
  private Set<BluetoothDevice> pairedDevices;
  private BluetoothDevice btDevice;
  public final static String EXTRA_ADRESS = null;
  BluetoothSocket socket;
  private Boolean deviceFound = false;
  private Boolean isConnected = false;
  private String readMessage;

  private ConnectThread mConnectThread;



  public Boolean isBluetoothEnabled() {
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
    Log.d("startConnection1", "Finding bonded devices");
    pairedDevices = btAdapter.getBondedDevices();

    Log.d("BTConnection", "before while in startConnection 1");
    //while (deviceFound ==  false) {
    Log.d("BTConnection", "in while in startConnection 2");
    for (BluetoothDevice btDevice : pairedDevices) {
      Log.d("BTConnection", "in for in startConnection 3");
      if (btDevice.getAddress().equals("B8:27:EB:43:01:2A")) {
        Log.d("BTConnection", "in if in startConnection 4");
        deviceList.add(btDevice.getName() + " " + btAdapter.getAddress());
        //Toast.makeText(UrineAnalyzerApplication.getAppContext(), "Found paired device", Toast.LENGTH_SHORT).show();
        Log.d("BTConnection Start", "Paired devices: " + btDevice.getName() + " " + btDevice.getAddress());
        deviceFound = true;
      }
    }
    //}
    Log.d("BTConnection", "before return in startConnection 5");
    return btAdapter.getAddress();
  }

  public void connectToRemoteDevice() {
    Log.d("BTConnection ConnectToRemoteDevice", "Starting connection");
    Log.d("BTConnection", "before startConnection in connectToRemoteDevice ");
    String address = findDeviceAddress();
    final BluetoothDevice device = btAdapter.getRemoteDevice(address);
    try {
      Log.d("BTConnection", "in try connectThread.start in connectToRemoteDevice ");
      new ConnectThread(device).start();
    } catch (IOException e) {
      Log.d("BTConnection", "in catch in connectToRemoteDevice ");
      e.printStackTrace();
    }
  }

  public void disconnectRemoteDevice() {
    try {
      socket.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }


  public class ConnectThread extends Thread {
    private final InputStream inputStream;
    private final OutputStream outputStream;

    @SuppressLint("MissingPermission")
    public ConnectThread(BluetoothDevice device) throws IOException {
      BluetoothSocket tmp = null;
      btDevice = device;
      InputStream tmpIn = null;
      OutputStream tmpOut = null;
      Log.d("BTConnection", "in ConnectThread ");

      try {
        UUID uuid = UUID.fromString("94f39d29-7d6d-437d-973b-fba39e49d4ee");
        Log.d("BTConnection", "in try createRfcomm in ConnectThread ");
        tmp = btDevice.createRfcommSocketToServiceRecord(uuid);
      } catch (IOException e) {
        Log.d("BTConnection", "in catch in ConnectThread ");
        Log.e("Connect Thread BT", "Sockets create() method failed", e);
      }

      socket = tmp;
      btAdapter.cancelDiscovery();

      try {
        Log.d("BTConnection", "in try socket.connect in ConnectThread ");
        socket.connect();
      } catch (IOException connectionException) {
        try {
          Log.d("BTConnection","2nd Attempt: trying fallback...");

          socket =(BluetoothSocket) device.getClass().getMethod("createRfcommSocket", new Class[] {int.class}).invoke(device,1);
          Log.d("BTConnection", "Creating new socket: " + socket);
          socket.connect();

          Log.d("BTConnection","2nd Attempt: Connected");
        }
        catch (Exception e) {
          Log.d("BTConnection", "2nd Attempt: Couldn't establish Bluetooth connection! "+ e);
        }
        Log.d("BTConnection", "in catch socket.connect in ConnectThread + e.msg " + connectionException);
        try {
          Log.d("BTConnection", "in try socket.close in ConnectThread ");
          socket.close();
        } catch (IOException closeException) {
          Log.d("BTConnection", "in catch socket.close in ConnectThread + e.msg " + closeException);
          Log.e("BTConnection", "socket close failed");
        }
      }

      try {
        Log.d("BTConnection", "in try getOutputStream in ConnectThread");
        tmpIn = socket.getInputStream();
        tmpOut = socket.getOutputStream();
      } catch (IOException e) {
        Log.d("BTConnection", "in catch getOutputStream in ConnectThread");
        e.printStackTrace();
      }
      inputStream = tmpIn;
      outputStream = tmpOut;

      isConnected = true;

      Log.d("BTConnection", "before write in ConnectThread");
      //write("Connection");
    }

    public void write(String msg) {
      OutputStream mmOutputStream = null;
      try {
        Log.d("BTConnection", "in try in getOutputStream");
        mmOutputStream = socket.getOutputStream();
      } catch (IOException e) {
        Log.d("BTConnection", "in catch in getOutputStream");
        e.printStackTrace();
      }
      try {
        mmOutputStream.write(msg.getBytes());
        Log.d("BTConnection", "in try in write + message " + msg );
      } catch (IOException e) {
        Log.d("BTConnection", "in catch in write " );
        e.printStackTrace();
      }
    }

    /*
    public String readMessage() {
      byte[] buffer = new byte[256];
      int bytes;
      String message = null;

      if(isConnected == true) {
      while(readMessage == null) {
          try {
            bytes = inputStream.read(buffer);
            message = new String(buffer, 0, bytes);
            Log.d("Receive", "Received: " + readMessage);

          } catch (IOException e) {
            Log.e("receive", "Problems occured");
            return null;
          }
        }
      }
      return message;
    }

    public String receive() {
      readMessage = null;
      readMessage = readMessage();

      return readMessage;
    }

     */
  }

  public void write(String out) {
    // Create temporary object
    ConnectThread r;

    // Synchronize a copy of the ConnectedThread
    Log.d("Unsyncronized Write", "write: Write Called.");
    //perform the write
    mConnectThread.write(out);
  }

  /*
  public String recive() {
    ConnectThread r;
     //Synchronize a copy of the ConnectedThread
    Log.d("Unsyncronized receive", "receive: receive Called.");

    String message = mConnectThread.receive();
    return message;
  }

   */
}
