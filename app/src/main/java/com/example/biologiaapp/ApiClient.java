package com.example.biologiaapp;

import com.google.gson.Gson;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
        public static String BASE_URL ="http://velmm.com/apis/";
        private static Retrofit retrofit;

        public static Retrofit getClient(){
            if(retrofit == null){
                retrofit = new Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create(new Gson()))
                        .build();
            }
            return retrofit;
        }
}
