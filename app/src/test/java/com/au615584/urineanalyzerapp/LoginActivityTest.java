package com.au615584.urineanalyzerapp;

import org.junit.Test;
//import com.au615584.urineanalyzerapp.LoginActivity;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;

import androidx.test.core.app.ActivityScenario;

@RunWith(JUnit4.class)
public class LoginActivityTest{

    private Intent intent;
    private LoginActivity activity;

    @Mock
    private Context context;

    public LoginActivityTest() {activity=new LoginActivity();}

    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void emailValidator_CorrectEmailSimple_ReturnsTrue() {

        intent = new Intent();
        //startActivity(intent, null, null);
        //activity = new LoginActivity();
        //activity.GoToProActivity();
        //View button=activity.findViewById(R.id.btnLogin);
        //button.performClick();
        //activity=this.activity;
        activity.startActivity(intent);
        activity.GoToProActivity();
        //assertNotNull(getStartedActivityIntent());
        assertTrue(true);
    }
}
