package com.au615584.urineanalyzerapp.Activities;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;

import com.au615584.urineanalyzerapp.Fragments.EpjFailureFragment;
import com.au615584.urineanalyzerapp.Fragments.GuideFragment;
import com.au615584.urineanalyzerapp.Fragments.ProcessingFragment;
import com.au615584.urineanalyzerapp.Fragments.ResultFragment;
import com.au615584.urineanalyzerapp.Fragments.TestFailureFragment;
import com.au615584.urineanalyzerapp.Fragments.WelcomeFragment;
import com.au615584.urineanalyzerapp.Fragments.btFailFragment;
import com.au615584.urineanalyzerapp.R;
import com.au615584.urineanalyzerapp.ViewModels.PatientViewModel;

//Patient activity maintains all the fragments concerning the user. These are welcome, guide, processing,
//result and the two error fragments: TestFailureFragment and EpjFailureFragment
public class PatientActivity extends AppCompatActivity {

    public String CPR="Default";
    private String btMessage="Default";
    private ImageButton btnPro;
    private ActivityResultLauncher<Intent> signInLauncher;
    private ActivityResultLauncher<Intent> bluetoothEnableLauncher;
    private PatientViewModel vm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient);
        btnPro=findViewById(R.id.proB);
        vm= new PatientViewModel();

        Log.d("onCreate Patient Activity", "Checking if bluetooth is enabled ");
        signInLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result ->  {
            if (result.getResultCode() == Activity.RESULT_OK) {
                Toast.makeText(this,"Professional view",Toast.LENGTH_SHORT).show();
            }
        });

        //Initialize fragment
        Fragment welcomeFragment=new WelcomeFragment();
        Fragment resultFragment=new ResultFragment();
        Fragment processingFragment=new ProcessingFragment();
        Fragment btFailFragment = new btFailFragment();
        Fragment testFailFragment = new TestFailureFragment();

        //Apply default fragment
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fraglist, welcomeFragment, "WELCOME_FRAGMENT")
                .commitNow();

        if(vm.isBluetoothEnabled()) {
            vm.connectToRemoteDevice();
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

        vm.isBtConnedted().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if(aBoolean == false) {
                    getSupportFragmentManager().
                            beginTransaction().replace(R.id.fraglist, btFailFragment, "BTFAIL_FRAGMENT")
                            .commit();
                }
            }
        });

        vm.btMessage().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                btMessage = s;
                vm.handleBtMessage(btMessage);
            }
        });

        //Updates the view and what fragment to show based on message received from
        // UrineAnalyzerController over Bluetooth.
        vm.state().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String state) {
                switch(state) {
                    case "Result":
                        Log.d("PatientActivity", "ChangeState(), Received Result");
                        getSupportFragmentManager()
                                .beginTransaction().replace(R.id.fraglist,resultFragment,"RESULT_FRAGMENT")
                                .commit();
                        break;
                    case "Guide":
                        Log.d("PatientActivity", "ChangeState(), Received Guide");
                        Fragment guideFragment = new GuideFragment(CPR);
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
                    case "Test Failure":
                        Log.d("PatientActivity", "ChangeState(), Received Test Failure");
                        getSupportFragmentManager()
                                .beginTransaction().replace(R.id.fraglist,testFailFragment, "TEST_FAILURE_FRAGMENT")
                                .commit();
                        break;
                    case "Result Failure":
                        Log.d("PatientActivity", "ChangeState(), Received Result Failure");
                        EpjFailureFragment epjFailureFragment = new EpjFailureFragment(btMessage);
                        Log.d("PatientActivity", btMessage);
                        getSupportFragmentManager()
                                .beginTransaction().replace(R.id.fraglist,epjFailureFragment, "EPJ_FAILURE_FRAGMENT")
                                .commit();
                        break;
                }
            }
        });

        btnPro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(PatientActivity.this, LoginActivity.class);
                signInLauncher.launch(myIntent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
    }
}