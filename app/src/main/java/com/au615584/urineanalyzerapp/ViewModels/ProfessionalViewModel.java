package com.au615584.urineanalyzerapp.ViewModels;

import android.app.Activity;

import com.au615584.urineanalyzerapp.FirebaseConnection;
import com.au615584.urineanalyzerapp.Repository;

public class ProfessionalViewModel {
    Repository repository;

    public ProfessionalViewModel() {
        repository = Repository.getInstance(new FirebaseConnection());
    }

    public void SetLocal(Activity activity, String langCode){
        repository.SetLocal(activity,langCode);
        //For test
        //repository.addPatientResult();
    }

}
