package com.au615584.urineanalyzerapp;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;

import com.au615584.urineanalyzerapp.Activities.ProfessionalActivity;
import com.au615584.urineanalyzerapp.Bluetooth.IState;
import com.au615584.urineanalyzerapp.Bluetooth.State;
import com.au615584.urineanalyzerapp.Repositories.BTRepository;
import com.au615584.urineanalyzerapp.Repositories.EPJRepository;
import com.au615584.urineanalyzerapp.Repositories.IBTRepository;
import com.au615584.urineanalyzerapp.Repositories.IEPJRepository;
import com.au615584.urineanalyzerapp.Repositories.IProRepository;
import com.au615584.urineanalyzerapp.Repositories.ProRepository;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ControllerTest {

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();
    private Controller controller;
    private IBTRepository mockBtRepo;
    private IEPJRepository mockEPJRepo;
    private IProRepository mockProRepo;
    private ProfessionalActivity mockProAct;
    private IState mockState;


    @Before
    public void setUp() throws Exception {
        mockBtRepo=mock(BTRepository.class);
        mockEPJRepo=mock(EPJRepository.class);
        mockProRepo=mock(ProRepository.class);
        mockProAct=mock(ProfessionalActivity.class);
        mockState=mock(State.class);
        controller = new Controller(mockState,mockProRepo,mockEPJRepo,mockBtRepo);

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void signIn() {
        controller.signIn("1234");
        verify(mockProRepo, times(1)).SignIn("1234");

    }

    @Test
    public void signOut() {
        controller.signOut();
        verify(mockProRepo, times(1)).SignOut();

    }

    @Test
    public void setLocal() {
        controller.setLocal(mockProAct,"Da");
        verify(mockProRepo, times(1)).SetLocal(mockProAct,"Da");

    }

    @Test
    public void setStixType() {
        controller.setStixType(mockProAct,"2");
        verify(mockProRepo,times(1)).setStixType(mockProAct,"2");
    }


    @Test
    public void connectToRemoteDevice() {
        controller.connectToRemoteDevice();
        verify(mockBtRepo, times(1)).connectToRemoteDevice();

    }

    @Test
    public void isBluetoothEnabled() {
        controller.isBluetoothEnabled();
        verify(mockBtRepo, times(1)).isBluetoothEnabled();

    }


    @Test
    public void handleBtMessage_Input1CPR_ChangestateCalled() {
        controller.handleBtMessage("11122331234");
        Assert.assertEquals("1122331234",controller.cpr.getValue());
        verify(mockState, times(1)).changeState("11122331234");

    }

    @Test
    public void handleBtMessage_Input3Result_ChangestateCalled() {
        controller.handleBtMessage("3glu: 0,pro: 0");
        Assert.assertEquals("Default Cpr",controller.cpr.getValue());
        verify(mockState, times(1)).changeState("F");
    }

    @Test
    public void handleBtMessage_Input1CPR_ChangestateCalledWithTestfejl() {
        controller.handleBtMessage("3Fejl på test");
        Assert.assertEquals("Default Cpr",controller.cpr.getValue());
        verify(mockState, times(1)).changeState("TestFejl");
    }

    @Test
    public void sendResultToEPJ() {
        controller.sendResultToEPJ("3glu: 0,pro: 0","1122331234");
        verify(mockEPJRepo, times(1)).saveToLog(0,0,"1122331234");
    }

    @Test
    public void sendResultToEPJ1() {
        controller.sendResultToEPJ("3glu: +2,pro: +3","1122331234");
        verify(mockEPJRepo, times(1)).saveToLog(2,3,"1122331234");
    }

    @Test
    public void sendResultToEPJ2() {
        controller.sendResultToEPJ("Fejl på test","1122331234");
        verify(mockEPJRepo, times(0)).saveToLog(2,3,"1122331234");
    }
}