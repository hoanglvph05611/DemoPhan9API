package com.lvh.demophan9api;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void btnPost(View view) {
        Intent intent = new Intent(this,PostAcitivity.class);
        startActivity(intent);
    }

    public void btnHttpURL(View view) {
    }

    public void btnUpdateView(View view) {
        Intent intent = new Intent(this,UpdateViewActivity.class);
        startActivity(intent);
    }
}
