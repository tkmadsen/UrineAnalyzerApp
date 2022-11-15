package com.au615584.urineanalyzerapp.Bluetooth;

import static org.junit.Assert.*;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(JUnit4.class)
public class StateTest {
    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    private State state;
    private IBluetoothConnection mockbtCon;
    @Before
    public void setUp() throws Exception {
        mockbtCon=mock(BluetoothConnection.class);
        state=new State(mockbtCon);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void changeState() {
        //when(mockbtCon.cprString().thenReturn("1234567890"));
    }

    @Test
    public void lState() {
    }
}