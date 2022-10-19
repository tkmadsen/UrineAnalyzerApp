package com.au615584.urineanalyzerapp;

import android.app.Activity;

public class ProfessionalViewModel {
    Repository repository;

    public ProfessionalViewModel() {
        repository = Repository.getInstance();
    }

    public void SetLocal(Activity acticity, String langCode){
        repository.SetLocal(acticity,langCode);

    }

}
