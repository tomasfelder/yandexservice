package com.example.yandex.service;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface YandexAPI {

  @GET("translate?key=trnsl.1.1.20180402T011548Z.116b6ca1e7cd0fe0.2cf143f2daa4b60534964872d06b5e906176f5c5" +
          "&lang=en-es&format=plain")
  Call<String> getTerm(@Query("text") String word);

}