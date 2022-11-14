package com.au615584.urineanalyzerapp;

import com.au615584.urineanalyzerapp.Model.Observation.Observation;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;


public interface ObservationService {
    @POST("observations")
    Call<Observation> createObservation(@Body Observation observation);

    @FormUrlEncoded
    @POST("observations")
    Call<Observation> createObservation(@Field("patient") String patient, @Field("context") String context, @Field("datetime") String datetime,@Field("perfomer") String performer, @Field("result") String result);

    @FormUrlEncoded
    @POST("observations")
    Call<Observation> createObservation(@FieldMap Map<String, String> fields);

}
