package com.au615584.urineanalyzerapp.ViewModels;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.Observer;

import com.au615584.urineanalyzerapp.Activities.LoginActivity;
import com.au615584.urineanalyzerapp.Repositories.IEPJRepository;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class LoginViewModelTest {

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    private IEPJRepository mockRepository;
    private Observer<Boolean> mockObserver;
    private LoginViewModel loginViewModel;
    private LoginActivity act;


    @Before
    public void setUp() throws Exception {
        //mockFirebase=mock(FirebaseConnection.class);
        //act=mock(LoginActivity.class);
        //mockRepository= mock(EPJRepository.class);
        //loginViewModel=new LoginViewModel(mockRepository,mockFirebase);
        //mockObserver = mock(Observer.class);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void signIn() {
        //loginViewModel.SignIn("1234", act);
        //verify(mockRepository, times(1)).SignIn("1234");
    }

    @Test
    public void signOut() {
        //loginViewModel.SignOut();
        //verify(mockRepository, times(1)).SignOut();
    }


}