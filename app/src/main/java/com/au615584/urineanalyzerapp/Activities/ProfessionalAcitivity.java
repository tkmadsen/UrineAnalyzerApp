package com.au615584.urineanalyzerapp.Activities;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.au615584.urineanalyzerapp.Adapters.AnalysisTypeAdapter;
import com.au615584.urineanalyzerapp.Adapters.LanguageAdapter;
import com.au615584.urineanalyzerapp.Model.AnalysisType;
import com.au615584.urineanalyzerapp.Model.Language;
import com.au615584.urineanalyzerapp.R;
import com.au615584.urineanalyzerapp.ViewModels.ProfessionalViewModel;

import java.util.ArrayList;

public class ProfessionalAcitivity extends AppCompatActivity implements LanguageAdapter.ILanguageItemClickedListener, AnalysisTypeAdapter.IAnalysisTypeItemClickedListener {
    //data (should probably come from a ViewModel)
    private ArrayList<Language> languages;
    private ArrayList<AnalysisType> types;
    private RecyclerView rcvLanList, rcvTypeList;
    private LanguageAdapter lanAdapter;
    private AnalysisTypeAdapter typeAdapter;
    private ProfessionalViewModel vm;
    private Button backBtn;
    private ActivityResultLauncher<Intent> patientLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_professional);

        vm=new ProfessionalViewModel();

        backBtn=findViewById(R.id.backBtn);

        //set up recyclerview with adapter and layout manager
        lanAdapter = new LanguageAdapter(this);
        rcvLanList=findViewById(R.id.RcvLan);
        rcvLanList.setLayoutManager(new LinearLayoutManager(this));
        rcvLanList.setAdapter(lanAdapter);

        typeAdapter = new AnalysisTypeAdapter(this);
        rcvTypeList=findViewById(R.id.rcvTypes);
        rcvTypeList.setLayoutManager(new LinearLayoutManager(this));
        rcvTypeList.setAdapter(typeAdapter);

        //create data and update adapter/recyclerview
        createLanData();
        lanAdapter.updateLanguageList(languages);
        createTypeData();
        typeAdapter.updateAnalysisTypeList(types);
        patientLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result ->  {
            if (result.getResultCode() == Activity.RESULT_OK) {
                Toast.makeText(this,"Patient view",Toast.LENGTH_SHORT).show();
            }
        });
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToPatinet();
            }
        });

    }

    public void goToPatinet(){
        Intent intent = new Intent(this, PatientActivity.class);
        patientLauncher.launch(intent);
    }

    private void createTypeData() {
        types=new ArrayList<AnalysisType>();
        types.add(new AnalysisType("Simens Multistix 2"));
        types.add(new AnalysisType("Simens Multistix 10"));
    }

    //create list of Language objects
    private void createLanData(){
        languages = new ArrayList<Language>();
        languages.add(new Language("Dansk ", 0,"da"));
        languages.add(new Language("English ", 1,"en"));
    }
    @Override
    public void onLanguageClicked(int index) {
        setLocal(this,languages.get(index));
    }

    @Override
    public void ChooseLanguage(Language language) {
        setLocal(this,language);
    }

    //Set locale and restart activity to update
    //ref: https://stackoverflow.com/questions/1397361/how-to-restart-activity-in-android
    private void setLocal(Activity activity,Language language){
        vm.SetLocal(activity,language.langCode);
        Intent intent=new Intent();
        intent.setClass(activity, activity.getClass());
        activity.startActivity(intent);
        activity.finish();
    }


    @Override
    public void onAnalysisItemClicked(int index) {
        setAnalysisType(types.get(index));
    }

    private void setAnalysisType(AnalysisType analysisType) {
        //create a dialogue popup - and show it
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setMessage("You clicked on " + analysisType.name + "\nWell done!")
                .setTitle(analysisType.name);
        builder.create().show();
    }

    @Override
    public void ChooseAnalysisType(AnalysisType analysisType) {
        setAnalysisType(analysisType);
    }




}