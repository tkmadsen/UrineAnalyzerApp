package com.au615584.urineanalyzerapp.Repositories;

//Interface for EPJRepository
// This makes sure to comply with Dependency Inversion Principle and strategy-pattern
// with complies with Open Close principle. Therefore adding another concrete class implementing this interface
//Can allow the product to communicate with eg. Sundhedsplatformen instead of with Columna CIS
// without modifying the code
public interface IEPJRepository {

    boolean saveToLog(double glucosis, double albumin, String Cpr);
    boolean saveResultEPJ(double glucosis, double albumin, String Cpr);
    boolean saveObsEPJ(double glucosis, double albumin, String Cpr);
}
