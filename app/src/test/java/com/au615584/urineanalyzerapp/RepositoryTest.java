package com.au615584.urineanalyzerapp;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.Observer;

import com.au615584.urineanalyzerapp.Repositories.EPJRepository;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public class RepositoryTest {
    /*
    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    private EPJRepository repository;
    private Observer<Boolean> mockObserver;
    private IFirebaseConnection mockFirebase;
    //private ProfessionalActivity mockProActivity;

    @Before
    public void setUp(){

        mockFirebase=mock(FirebaseConnection.class);
        repository=new EPJRepository(mockFirebase);

        mockObserver = mock(Observer.class);
        repository.isSignedIn().observeForever(mockObserver);
        //mockProActivity=mock(ProfessionalAcitivity.class);

    }


    @Test
    public void SignIn_correctPw_isSignedInIsTrue() {
        String input = "1234";
        Boolean output;
        boolean expected=true;
        repository.SignIn(input);
        output=repository.isSignedIn().getValue();
        assertEquals(expected, output);
    }

    @Test
    public void SignIn_wrongPw_isSignedInIsFalse() {
        String input = "1243";
        Boolean output;
        boolean expected=false;
        repository.SignIn(input);
        output=repository.isSignedIn().getValue();
        assertEquals(expected, output);
    }

    @Test
    public void SignOut_isCalled_isSignedInIsFalse() {
        String input = "1234";
        Boolean output;
        repository.SignIn(input);
        output=repository.isSignedIn().getValue();
        assertTrue(output);
        repository.SignOut();
        output=repository.isSignedIn().getValue();
        assertFalse(output);
    }

     */


}