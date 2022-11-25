package com.au615584.urineanalyzerapp.Bluetooth;

import static org.junit.Assert.*;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.stubbing.OngoingStubbing;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.au615584.urineanalyzerapp.Controller;
import com.au615584.urineanalyzerapp.IController;

import java.util.Observable;

@RunWith(JUnit4.class)
public class StateTest {
    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    private State state;
    private IBluetoothConnection mockbtCon;
    private String cpr = "123456789";
    private IController mockController;
    @Before
    public void setUp() throws Exception {
        mockbtCon=mock(BluetoothConnection.class);
        //state=new State();
        mockController=mock(Controller.class);
        state=new State(mockController);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void changeState() {
        state.changeState("8234564343455");
        Assert.assertEquals("Welcome",state.state.getValue());
    }
    @Test
    public void changeState1() {

        state.changeState("1234564343455");
        Assert.assertEquals("Guide",state.state.getValue());

    }

    @Test
    public void changeState2() {

        state.changeState("2234564343455");
        Assert.assertEquals("Analyzing",state.state.getValue());

    }

    @Test
    public void changeState3() {
        state.changeState("3234564343455");
        Assert.assertEquals("Result",state.state.getValue());

    }

    @Test
    public void changeState4() {

        state.changeState("4234564343455");
        Assert.assertEquals("Welcome",state.state.getValue());
    }

    @Test
    public void lState() {
    }
}