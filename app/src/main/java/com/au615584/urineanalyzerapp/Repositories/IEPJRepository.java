package com.au615584.urineanalyzerapp.Repositories;

public interface IEPJRepository {

    void saveToEPJ(double Glukose, double Albumin, String Cpr);
    void saveToLog(double Glukose, double Albumin, String Cpr);
}
