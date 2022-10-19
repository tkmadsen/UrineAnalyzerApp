package com.au615584.urineanalyzerapp;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;
import androidx.fragment.app.Fragment;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class PatientActivity extends AppCompatActivity {

    private Button btnTest;
    private ImageButton btnPro;
    private ActivityResultLauncher<Intent> signInLauncher;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient);
        btnTest=findViewById(R.id.testB);
        btnPro=findViewById(R.id.proB);
        signInLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result ->  {
            if (result.getResultCode() == Activity.RESULT_OK) {
                Toast.makeText(this,"Professional view",Toast.LENGTH_SHORT).show();
            }
        });

// Initialize fragment
        Fragment guideFragment=new GuideFragment();
        Fragment welcomeFragment=new WelcomeFragment();
        Fragment resultFragment=new ResultFragment();

        //Apply default fragment
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fraglist, welcomeFragment, "WELCOME_FRAGMENT")
                .commitNow();



        btnTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Open Result fragment: DENNE VIL SENERE SKULLE KALDES, NÅR BILLEDDATA MODTAGES
                if (guideFragment != null && guideFragment.isVisible()) {
                    getSupportFragmentManager()
                            .beginTransaction().replace(R.id.fraglist,resultFragment,"RESULT_FRAGMENT")
                            .commit();
                }
                // Open Guide fragment: DENNE VIL SENERE SKULLE KALDES, NÅR KORT SCANNES
                if (welcomeFragment != null && welcomeFragment.isVisible()) {
                    showDialouge();
                    getSupportFragmentManager()
                            .beginTransaction().replace(R.id.fraglist,guideFragment,"GUIDE_FRAGMENT")
                            .commit();
                }
                // Open Welcome fragment: DENNE SKAL SENERE BARE ÅBNES SOM DEFAULT OG STARTES IGEN, NÅR DATA ER UPLOADED
                if (resultFragment != null && resultFragment.isVisible()) {
                    getSupportFragmentManager()
                            .beginTransaction().replace(R.id.fraglist,welcomeFragment,"WELCOME_FRAGMENT")
                            .commit();
                }
            }
        });
        btnPro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(PatientActivity.this, LoginActivity.class);
                //myIntent.putExtra("key", value); //Optional parameters
                signInLauncher.launch(myIntent);
                finish();
            }
        });
    }
    public void showDialouge(){
        //create a dialogue popup - and show it
        final AlertDialog.Builder dialog = new AlertDialog.Builder(this).setTitle(R.string.welcome).setMessage(R.string.CPRdialog);
        final AlertDialog alert = dialog.create();
        alert.show();

        // Hide after some seconds
        final Handler handler  = new Handler();
        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                if (alert.isShowing()) {
                    alert.dismiss();
                }
            }
        };
        alert.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                handler.removeCallbacks(runnable);
            }
        });
        handler.postDelayed(runnable, 3000);
    }
}