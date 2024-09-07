package com.example.hiraganamaster;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {
    private static Retrofit retrofit = null;

    // Base URL for your API
    private static final String BASE_URL = "https://api.yourservice.com/";

    // Private constructor to prevent instantiation
    private RetrofitInstance() {
    }

    // Public method to provide access to the single instance
    public static Retrofit getClient() {
        if (retrofit == null) {
            synchronized (RetrofitInstance.class) {
                if (retrofit == null) {
                    retrofit = new Retrofit.Builder()
                            .baseUrl(BASE_URL)
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();
                }
            }
        }
        return retrofit;
    }
}
