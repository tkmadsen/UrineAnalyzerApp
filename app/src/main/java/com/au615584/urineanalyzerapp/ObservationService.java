package com.au615584.urineanalyzerapp;

import com.au615584.urineanalyzerapp.Model.LoginEPJBody;
import com.au615584.urineanalyzerapp.Model.LoginEPJResponse;
import com.au615584.urineanalyzerapp.Model.Observation.Observation;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;


public interface ObservationService {
    //Reference: https://stackoverflow.com/questions/71316855/how-to-get-the-bearer-token-in-the-response-body-in-android-studio
    @Headers({ "Content-Type: application/json;charset=UTF-8"})
    @POST("/columna/fhir/Observation/") //TODO tjek bearer
    Call<Observation> createObservation(@Header("Authorization") String authToken, @Header("Cookie") String columnaSession, @Body Observation observation);

    @FormUrlEncoded
    @POST("observations")
    Call<Observation> createObservation(@Field("patient") String patient, @Field("context") String context, @Field("datetime") String datetime,@Field("perfomer") String performer, @Field("result") String result);

    @FormUrlEncoded
    @POST("observations")
    Call<Observation> createObservation(@FieldMap Map<String, String> fields);

    @Headers({ "Content-Type: application/json;charset=UTF-8"})
    @POST("/columna/platform/ws/auth/login")
    Call<LoginEPJResponse> login(@Body LoginEPJBody login);
}
