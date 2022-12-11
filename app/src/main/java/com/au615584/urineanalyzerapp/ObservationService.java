package com.au615584.urineanalyzerapp;

import com.au615584.urineanalyzerapp.Model.LoginEPJBody;
import com.au615584.urineanalyzerapp.Model.LoginEPJResponse;
import com.au615584.urineanalyzerapp.Model.Observation.Observation;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

//The interfaces that exposes REST API. Contains HTTP-post methods for Login and creation of observation
public interface ObservationService {
    //Reference: https://stackoverflow.com/questions/71316855/how-to-get-the-bearer-token-in-the-response-body-in-android-studio
    @Headers({ "Content-Type: application/json;charset=UTF-8"})
    @POST("/Observation/")
    Call<Observation> createObservation(@Header("Authorization") String authToken, @Header("Cookie") String columnaSession, @Body Observation observation);

    @Headers({ "Content-Type: application/json;charset=UTF-8"})
    @POST("/login")
    Call<LoginEPJResponse> login(@Body LoginEPJBody login);
}
