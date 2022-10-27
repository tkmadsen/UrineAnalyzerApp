package com.au615584.urineanalyzerapp.Activities;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.au615584.urineanalyzerapp.R;
import com.au615584.urineanalyzerapp.ViewModels.LoginViewModel;

public class LoginActivity extends AppCompatActivity {
    private Button loginBtn;
    private EditText pw;
    private TextView loginTxt;
    private LoginViewModel loginViewModel;
    private ActivityResultLauncher<Intent>  proLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginBtn=findViewById(R.id.btnLogin);
        pw=findViewById(R.id.editTextTextPassword);
        loginTxt=findViewById(R.id.txtLogin);

        loginViewModel=new LoginViewModel();

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pw.setError(null);
                Login();
            }
        });

        proLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result ->  {
            if (result.getResultCode() == Activity.RESULT_OK) {
                Toast.makeText(this,"Professional view",Toast.LENGTH_SHORT).show();
            }
        });

        loginViewModel.isSignedIn().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean isSignedIn) {
                if (isSignedIn){
                    GoToProActivity();
                }
                else {

                }
            }
        });
    }

    private void GoToProActivity() {
        Intent intent = new Intent(this, ProfessionalAcitivity.class);
        proLauncher.launch(intent);
        finish();
        loginViewModel.SignOut();
    }

    private void Login(){
        String password = pw.getText().toString();
        if(password == null || password.length()<1||!password.equals("1234")){
            //pw.setError(getString(R.string.errorInvalidPassword));
            pw.setError(getString(R.string.errorUserSignIn));
        }
        else {
            loginViewModel.SignIn(password,this);
        }
    }


}