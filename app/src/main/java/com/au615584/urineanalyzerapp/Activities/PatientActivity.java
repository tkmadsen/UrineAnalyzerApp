package com.au615584.urineanalyzerapp.Activities;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.au615584.urineanalyzerapp.Bluetooth.BluetoothCommunication;
import com.au615584.urineanalyzerapp.Bluetooth.BluetoothConnection;
import com.au615584.urineanalyzerapp.Fragments.GuideFragment;
import com.au615584.urineanalyzerapp.Fragments.ProcessingFragment;
import com.au615584.urineanalyzerapp.Fragments.ResultFragment;
import com.au615584.urineanalyzerapp.Fragments.WelcomeFragment;
import com.au615584.urineanalyzerapp.R;
import com.au615584.urineanalyzerapp.UrineAnalyzerApplication;
import com.au615584.urineanalyzerapp.ViewModels.PatientViewModel;

public class PatientActivity extends AppCompatActivity {

    private Button btnTest;
    private String CPR="Default";
    private ImageButton btnPro;
    private ActivityResultLauncher<Intent> signInLauncher;
    private ActivityResultLauncher<Intent> bluetoothEnableLauncher;
    private PatientViewModel vm;
    //private BluetoothCommunication btConnection;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient);
        btnTest=findViewById(R.id.testB);
        btnPro=findViewById(R.id.proB);
        vm= new PatientViewModel();

        Log.d("onCreate1 Patient Activity", "Checking if bluetooth is enabled ");
        /*
        if(vm.isBluetoothEnabled() == true) {
            Log.d("onCreate2 Patient Activity", "Bluetooth is enabled");
            vm.connectToRemoteDevice();
        }*/

        /*
        while (vm.isBluetoothEnabled() == false) {
            Log.d("onCreate2 Patient Activity", "Bluetooth not enabled connected");
            Intent turnOn = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            bluetoothEnableLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result ->  {
                if (result.getResultCode() == 0) {
                    Toast.makeText(this,"Turn on Bluetooth",Toast.LENGTH_SHORT).show();
                }
            });
        }*/



        signInLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result ->  {
            if (result.getResultCode() == Activity.RESULT_OK) {
                Toast.makeText(this,"Professional view",Toast.LENGTH_SHORT).show();
            }
        });

        //Initialize fragment
        Fragment guideFragment=new GuideFragment();
        Fragment welcomeFragment=new WelcomeFragment();
        Fragment resultFragment=new ResultFragment();
        Fragment processingFragment=new ProcessingFragment();

        //Apply default fragment
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fraglist, welcomeFragment, "WELCOME_FRAGMENT")
                .commitNow();


        if(vm.isBluetoothEnabled()) {
            vm.connectToRemoteDevice();
            //btConnection.write("Hej RPi");
        } else {
            Log.d("onCreate2 Patient Activity", "Bluetooth not enabled connected");
            Intent turnOn = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            bluetoothEnableLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result ->  {
                if (result.getResultCode() == 0) {
                    Toast.makeText(this,"Turn on Bluetooth",Toast.LENGTH_SHORT).show();
                }
            });
        }

        vm.cpr().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                CPR=s;
            }
        });

        vm.state().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String state) {
                // TODO Open Result fragment: DENNE VIL SENERE SKULLE KALDES, NÅR BILLEDDATA MODTAGES
                switch(state) {
                    case "Result":
                        Log.d("PatientActivity", "ChangeState(), Received Result");
                        getSupportFragmentManager()
                                .beginTransaction().replace(R.id.fraglist,resultFragment,"RESULT_FRAGMENT")
                                .commit();
                        break;
                    case "Guide":
                        Log.d("PatientActivity", "ChangeState(), Received Guide");
                        showDialogue();
                        getSupportFragmentManager()
                                .beginTransaction().replace(R.id.fraglist,guideFragment,"GUIDE_FRAGMENT")
                                .commit();
                        break;
                    case "Welcome":
                        Log.d("PatientActivity", "ChangeState(), Received welcome");
                        getSupportFragmentManager()
                                .beginTransaction().replace(R.id.fraglist,welcomeFragment,"WELCOME_FRAGMENT")
                                .commit();
                        break;
                    case "Analyzing":
                        Log.d("PatientActivity", "ChangeState(), Received analyzing");
                        getSupportFragmentManager()
                                .beginTransaction().replace(R.id.fraglist,processingFragment, "PROCESSING_FRAGMENT")
                                .commit();
                        break;
                }
            }
        });
        /*
        btnTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO Open Result fragment: DENNE VIL SENERE SKULLE KALDES, NÅR BILLEDDATA MODTAGES
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
        */
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
    public void showDialogue(){
        //create a dialogue popup - and show it
        final AlertDialog.Builder dialog = new AlertDialog.Builder(this).setTitle(R.string.welcome).setMessage(CPR);
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