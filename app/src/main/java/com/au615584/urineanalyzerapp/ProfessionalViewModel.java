package com.au615584.urineanalyzerapp;

import android.app.Activity;

public class ProfessionalViewModel {
    Repository repository;

    public ProfessionalViewModel() {
        repository = Repository.getInstance();
    }

    public void SetLocal(Activity activity, String langCode){
        repository.SetLocal(activity,langCode);
        //For test
        //repository.addPatientResult();
    }

}
