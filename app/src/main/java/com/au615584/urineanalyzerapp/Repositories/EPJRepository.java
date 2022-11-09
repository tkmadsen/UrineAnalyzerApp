package com.au615584.urineanalyzerapp.Repositories;

import android.app.Activity;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.au615584.urineanalyzerapp.Bluetooth.BluetoothCommunication;
import com.au615584.urineanalyzerapp.Constants;
import com.au615584.urineanalyzerapp.IFirebaseConnection;
import com.au615584.urineanalyzerapp.Model.Observation;
import com.au615584.urineanalyzerapp.ObservationService;

import java.util.Locale;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class EPJRepository implements IEPJRepository {
    //Instance for Singleton pattern
    private static EPJRepository instance;
    IFirebaseConnection fireBaseCon;
    private ObservationService obsService;

    EPJRepository(IFirebaseConnection fireBaseCon) {
        this.fireBaseCon = fireBaseCon;

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("EPJ URL") //TODO JEG TROR DET ER HER, VI SKAL SÆTTE NOGET IND
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        obsService = retrofit.create(ObservationService.class);
    }

    public ObservationService getObsService(){
        return obsService;
    }

    //Singleton patten
    public static EPJRepository getInstance(IFirebaseConnection connection) {

        if (instance == null) {
            instance = new EPJRepository(connection);
        }
        return instance;
    }


    @Override
    public void saveToEPJ() {
        Observation obs = new Observation("Hans Hansen", "Urinprøve","01-01-2022","Gitte","GLU +1, PRO neg");

        instance.getObsService().createObservation(obs).enqueue(new Callback<Observation>() {

            @Override
            public void onResponse(Call<Observation> call, Response<Observation> response) {
                Log.d("EPJREP", "Observation"+response.body().getSubject());
            }

            @Override
            public void onFailure(Call<Observation> call, Throwable t) {
                Log.d("EPJREP", "Error creating Observation");

            }

        });
    }
}
