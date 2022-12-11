package com.au615584.urineanalyzerapp.Repositories;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class proRepositoryTest {
    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    private ProRepository proRepository;
    @Before
    public void setUp() throws Exception {
        proRepository=new ProRepository();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void signIn_Correctinput_ExpectedTrue() {
        proRepository.SignIn("1234");
        Boolean expected = true;
        Boolean actual = proRepository.isUserSignedIn.getValue();
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void signIn_WrongInput_ExpectedFalse() {
        proRepository.SignIn("2234");
        Boolean expected = false;
        Boolean actual = proRepository.isUserSignedIn.getValue();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void isSignedIn() {
        Boolean expected=proRepository.isUserSignedIn.getValue();
        Boolean actual=proRepository.isSignedIn().getValue();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void signOut() {
        proRepository.SignOut();
        Boolean expected = false;
        Boolean actual = proRepository.isUserSignedIn.getValue();
        Assert.assertEquals(expected,actual);
    }


}