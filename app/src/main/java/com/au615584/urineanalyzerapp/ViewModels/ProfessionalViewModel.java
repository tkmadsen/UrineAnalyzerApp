package com.au615584.urineanalyzerapp.ViewModels;

import android.app.Activity;

import com.au615584.urineanalyzerapp.FirebaseConnection;
import com.au615584.urineanalyzerapp.IFirebaseConnection;
import com.au615584.urineanalyzerapp.IRepository;
import com.au615584.urineanalyzerapp.Repository;

public class ProfessionalViewModel {
    IRepository repository;

    public ProfessionalViewModel() {
        repository = Repository.getInstance(new FirebaseConnection());
    }
    public ProfessionalViewModel(IRepository repo, IFirebaseConnection connection) {
        repository=repo;
    }

    public void SetLocal(Activity activity, String langCode){
        repository.SetLocal(activity,langCode);
        //For test
        //repository.addPatientResult();
    }

}
