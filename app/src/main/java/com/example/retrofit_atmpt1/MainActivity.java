package com.example.retrofit_atmpt1;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rv_characters;
    private List<Character> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv_characters = findViewById(R.id.rv_characters);

        list  = new ArrayList<>();

        //retrofit builder
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://simplifiedcoding.net/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        CharacterApi characterApi = retrofit.create(CharacterApi.class);
        Call<List<Character>> call = characterApi.getCharacters();
        call.enqueue(new Callback<List<Character>>() {
            @Override
            public void onResponse(Call<List<Character>> call, Response<List<Character>> response) {
                if(response.code() != 200){
                    // handle the error & display it

                }

                List<Character> characters = response.body();

                for( Character character: characters){

                     //getting data

                    list.add(character);

                    /*String responseTest = "";
                    responseTest += character.getName();
                    Log.d("#####", "onResponse: " + responseTest);
                 */
                }

                PutDataIntoRv(  list);

            }

            @Override
            public void onFailure(Call<List<Character>> call, Throwable t) {

            }


        });





    }

    private void PutDataIntoRv(List<Character> list) {

        MyAdapter myAdapter = new MyAdapter(this,list);
        rv_characters.setLayoutManager(new LinearLayoutManager(this));
        rv_characters.setAdapter(myAdapter);

    }
}