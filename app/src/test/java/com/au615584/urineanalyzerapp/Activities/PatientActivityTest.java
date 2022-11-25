package com.au615584.urineanalyzerapp.Activities;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import androidx.lifecycle.LiveData;

import com.au615584.urineanalyzerapp.ViewModels.PatientViewModel;

import org.junit.Before;
import org.junit.Test;
import org.mockito.stubbing.OngoingStubbing;

public class PatientActivityTest {
    private PatientActivity act;
    private PatientViewModel mockVM;

    @Before
    public void setUp() throws Exception {
        mockVM=mock(PatientViewModel.class);
        act= new PatientActivity();
    }

    @Test
    public void onCreate() {
        when(mockVM.cpr().getValue()).thenReturn("123454342");
        String expected;
        expected=mockVM.cpr().getValue();
        assertEquals(expected, act.CPR);
    }

    @Test
    public void showDialogue() {
    }
}