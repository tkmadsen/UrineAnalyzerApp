package com.au615584.urineanalyzerapp.Repositories;

public interface IEPJRepository {

    boolean saveToLog(double glucosis, double albumin, String Cpr);
    boolean saveResultEPJ(double glucosis, double albumin, String Cpr);
    boolean saveObsEPJ(double glucosis, double albumin, String Cpr);
}
