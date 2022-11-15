package com.au615584.urineanalyzerapp.ViewModels;

import android.app.Activity;

import com.au615584.urineanalyzerapp.Controller;
import com.au615584.urineanalyzerapp.IController;

public class ProfessionalViewModel {
    IController controller;

    public ProfessionalViewModel() {
        controller = Controller.getInstance();
    }
    public ProfessionalViewModel(Controller control) {
        controller=control;
    }

    public void SetLocal(Activity activity, String langCode){
        controller.setLocal(activity,langCode);
        //For test
        //repository.addPatientResult();
    }

}
