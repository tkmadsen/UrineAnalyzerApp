package com.au615584.urineanalyzerapp.Bluetooth;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class BluetoothConnectionTest {
    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();
    private BluetoothConnection btCon;

    @Before
    public void setUp() throws Exception {
        btCon=new BluetoothConnection();

    }

    @After
    public void tearDown() throws Exception {
    }


    @Test
    public void isBluetoothEnabled() {
    }

    @Test
    public void findDeviceAddress() {
    }

    @Test
    public void connectToRemoteDevice() {
    }

    @Test
    public void fragmentState() {
    }

    @Test
    public void cprString() {
    }

    @Test
    public void resultString() {
    }

    @Test
    public void isBtConnected() {
    }
}