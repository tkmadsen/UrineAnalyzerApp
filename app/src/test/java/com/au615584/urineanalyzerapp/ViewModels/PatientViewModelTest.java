package com.au615584.urineanalyzerapp.ViewModels;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.Observer;

import com.au615584.urineanalyzerapp.Activities.LoginActivity;
import com.au615584.urineanalyzerapp.Activities.PatientActivity;
import com.au615584.urineanalyzerapp.FirebaseConnection;
import com.au615584.urineanalyzerapp.IFirebaseConnection;
import com.au615584.urineanalyzerapp.IRepository;
import com.au615584.urineanalyzerapp.Repository;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public class PatientViewModelTest {
    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    private IRepository mockRepository;
    private Observer<Boolean> mockObserver;
    private IFirebaseConnection mockFirebase;
    private PatientViewModel patientViewModel;
    private PatientActivity act;

    @Before
    public void setUp() throws Exception {
        mockFirebase=mock(FirebaseConnection.class);
        act=mock(PatientActivity.class);
        mockRepository= mock(Repository.class);
        patientViewModel=new PatientViewModel(mockRepository,mockFirebase);
        mockObserver = mock(Observer.class);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void connectToRemoteDevice() {
        patientViewModel.connectToRemoteDevice();
        verify(mockRepository, times(1)).connectToRemoteDevice();
    }

    @Test
    public void isBluetoothEnabled() {
        patientViewModel.isBluetoothEnabled();
        verify(mockRepository, times(1)).isBluetoothEnabled();
    }

    @Test
    public void state() {
        patientViewModel.state();
        verify(mockRepository, times(1)).state();
    }
}