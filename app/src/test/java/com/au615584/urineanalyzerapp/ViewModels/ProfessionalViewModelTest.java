package com.au615584.urineanalyzerapp.ViewModels;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;

import com.au615584.urineanalyzerapp.Activities.ProfessionalActivity;
import com.au615584.urineanalyzerapp.Controller;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public class ProfessionalViewModelTest {
    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    private Controller mockController;
    private ProfessionalViewModel professionalViewModel;
    private ProfessionalActivity act;


    @Before
    public void setUp() throws Exception {
        act=mock(ProfessionalActivity.class);
        mockController= mock(Controller.class);
        professionalViewModel=new ProfessionalViewModel(mockController);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void setLocal() {
        professionalViewModel.SetLocal(act,"da");
        verify(mockController, times(1)).setLocal(act,"da");
    }


}