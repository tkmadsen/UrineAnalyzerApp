package com.au615584.urineanalyzerapp.ViewModels;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import android.content.Context;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.Observer;
import androidx.test.platform.app.InstrumentationRegistry;

import com.au615584.urineanalyzerapp.Activities.LoginActivity;
import com.au615584.urineanalyzerapp.FirebaseConnection;
import com.au615584.urineanalyzerapp.IFirebaseConnection;
import com.au615584.urineanalyzerapp.IRepository;
import com.au615584.urineanalyzerapp.Repository;
import com.au615584.urineanalyzerapp.ViewModels.LoginViewModel;
import com.google.firebase.FirebaseApp;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mockito;
import org.robolectric.RobolectricTestRunner;

@RunWith(JUnit4.class)
public class LoginViewModelTest {
    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    private IRepository mockRepository;
    private Observer<Boolean> mockObserver;
    private IFirebaseConnection mockFirebase;
    private LoginViewModel loginViewModel;
    private LoginActivity act;


    @Before
    public void setUp() throws Exception {
        mockFirebase=mock(FirebaseConnection.class);
        act=mock(LoginActivity.class);
        mockRepository= mock(Repository.class);
        loginViewModel=new LoginViewModel(mockRepository,mockFirebase);
        mockObserver = mock(Observer.class);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void signIn() {
        loginViewModel.SignIn("1234", act);
        verify(mockRepository, times(1)).SignIn("1234");
    }

    @Test
    public void signOut() {
        loginViewModel.SignOut();
        verify(mockRepository, times(1)).SignOut();
    }
}