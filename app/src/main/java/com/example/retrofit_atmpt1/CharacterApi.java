package com.example.retrofit_atmpt1;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CharacterApi {
 @GET("demos/marvel")
    Call<List<Character>> getCharacters();


}
