package com.au615584.urineanalyzerapp.ViewModels;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.Observer;

import com.au615584.urineanalyzerapp.Activities.ProfessionalAcitivity;
import com.au615584.urineanalyzerapp.FirebaseConnection;
import com.au615584.urineanalyzerapp.IFirebaseConnection;
import com.au615584.urineanalyzerapp.Repositories.IEPJRepository;
import com.au615584.urineanalyzerapp.Repositories.EPJRepository;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public class ProfessionalViewModelTest {
    /*
    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    private IEPJRepository mockRepository;
    private Observer<Boolean> mockObserver;
    private IFirebaseConnection mockFirebase;
    private ProfessionalViewModel professionalViewModel;
    private ProfessionalAcitivity act;


    @Before
    public void setUp() throws Exception {
        mockFirebase=mock(FirebaseConnection.class);
        act=mock(ProfessionalAcitivity.class);
        mockRepository= mock(EPJRepository.class);
        professionalViewModel=new ProfessionalViewModel(mockRepository,mockFirebase);
        mockObserver = mock(Observer.class);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void setLocal() {
        professionalViewModel.SetLocal(act,"da");
        verify(mockRepository, times(1)).SetLocal(act,"da");
    }

     */
}