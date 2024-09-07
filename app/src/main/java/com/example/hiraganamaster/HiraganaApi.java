package com.example.hiraganamaster;

import java.util.List;

import okhttp3.Response;
import retrofit2.Call;
import retrofit2.http.GET;

public interface HiraganaApi {

    @GET("/images")
    Call<List<HiraganaQuestion>> getQuestions();
}
