package com.au615584.urineanalyzerapp.ViewModels;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;

import com.au615584.urineanalyzerapp.Activities.PatientActivity;
import com.au615584.urineanalyzerapp.Controller;
import com.au615584.urineanalyzerapp.IController;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public class PatientViewModelTest {

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    private Controller mockController;
    private PatientViewModel patientViewModel;
    private PatientActivity act;

    @Before
    public void setUp() throws Exception {
        act=mock(PatientActivity.class);
        mockController= mock(Controller.class);
        patientViewModel=new PatientViewModel(mockController);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void connectToRemoteDevice() {
        patientViewModel.connectToRemoteDevice();
        verify(mockController, times(1)).connectToRemoteDevice();
    }

    @Test
    public void isBluetoothEnabled() {
        patientViewModel.isBluetoothEnabled();
        verify(mockController, times(1)).isBluetoothEnabled();
    }

    @Test
    public void state() {
        patientViewModel.state();
        verify(mockController, times(1)).state();
    }


}