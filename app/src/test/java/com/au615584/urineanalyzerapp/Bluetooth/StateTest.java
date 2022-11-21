package com.au615584.urineanalyzerapp.Bluetooth;

import static org.mockito.Mockito.mock;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;

import com.au615584.urineanalyzerapp.Controller;
import com.au615584.urineanalyzerapp.IController;

import org.junit.After;
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
    private IController mockController;
    @Before
    public void setUp() throws Exception {
        mockController=mock(Controller.class);
        state=new State(mockController);
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