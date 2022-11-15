package com.au615584.urineanalyzerapp.Repositories;

import static org.junit.Assert.*;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;

import com.au615584.urineanalyzerapp.Activities.PatientActivity;
import com.au615584.urineanalyzerapp.Bluetooth.BluetoothCommunication;
import com.au615584.urineanalyzerapp.Bluetooth.IBluetoothCommunication;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class BTRepositoryTest {
    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    private BTRepository repository;
    private PatientActivity mockPatActivity;
    private IBluetoothCommunication mockBtCom;

    @Before
    public void setUp() throws Exception {
        mockBtCom=mock(BluetoothCommunication.class);
        repository=new BTRepository(mockBtCom);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void connectToRemoteDevice() {
        repository.connectToRemoteDevice();
        verify(mockBtCom, times(1)).connectToRemoteDevice();
    }

    @Test
    public void isBluetoothEnabled() {
        repository.isBluetoothEnabled();
        verify(mockBtCom, times(1)).isBluetoothEnabled();
        //assertEquals(repository.isBluetoothEnabled(), true);
    }

    @Test
    public void state() {
        mockBtCom.cprString();
        repository.state();
        verify(mockBtCom, times(1)).fragmentState();
    }

    @Test
    public void cpr() {
        repository.cpr();
        verify(mockBtCom, times(1)).cprString();
    }

    @Test
    public void result() {
        repository.result();
        verify(mockBtCom, times(1)).resultString();
    }
}