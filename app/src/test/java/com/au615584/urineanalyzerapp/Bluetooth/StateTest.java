package com.au615584.urineanalyzerapp.Bluetooth;

import static org.mockito.Mockito.mock;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;

import com.au615584.urineanalyzerapp.Controller;
import com.au615584.urineanalyzerapp.IController;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

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
        mockController=mock(Controller.class);
        state=new State(mockController);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void changeState_input8_ExpectedDefault() {
        state.changeState("8234564343455");
        Assert.assertEquals("Welcome",state.state.getValue());
    }
    @Test
    public void changeState_Input1_ExpetedGuide() {

        state.changeState("1234564343455");
        Assert.assertEquals("Guide",state.state.getValue());

    }

    @Test
    public void changeState_Input2_ExpectedAnalyzing() {

        state.changeState("2234564343455");
        Assert.assertEquals("Analyzing",state.state.getValue());

    }

    @Test
    public void changeState_Input3_ExpectedResult() {
        state.changeState("S3234564343455");
        Assert.assertEquals("Result",state.state.getValue());

    }

    @Test
    public void changeState_Input4_ExpectedWelcome() {

        state.changeState("4234564343455");
        Assert.assertEquals("Welcome",state.state.getValue());
    }

    @Test
    public void changeState_InputF_ExpectedResultFailure() {
        state.changeState("F3234564343455");
        Assert.assertEquals("Result Failure",state.state.getValue());

    }

    @Test
    public void changeState_InputT_ExpectedTestFailure() {
        state.changeState("TF3234564343455");
        Assert.assertEquals("Test Failure",state.state.getValue());

    }

    @Test
    public void formatStateMessage_ExpectedT() {
        Character actual = state.formatStateMessage("Tshsjk");
        Character expected ='T';
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void formatStateMessage_Expected3() {
        Character actual = state.formatStateMessage("3kshsjk");
        Character expected ='3';
        Assert.assertEquals(expected,actual);
    }
}