package com.projects.loconluis.myapp;

import android.os.AsyncTask;

import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.IOException;

/**
 * Created by luisl on 27/03/2017.
 */

public class Okhttp extends AsyncTask<String, Void, String>{
    OkHttpClient webclient = new OkHttpClient();
    String username, pass, e1, v1;

    public Okhttp(String username, String pass, String e1, String v1){
        this.username = username;
        this.pass = pass;
        this.e1 = e1;
        this.v1 = v1;
    }

    @Override
    protected String doInBackground(String... params) {
        RequestBody body = new FormEncodingBuilder()
                .add("user", username)
                .add("pass", pass)
                .add("fact", e1)
                .add("dept", v1)
                .build();
        Request request = new Request.Builder()
                .url(params[0]).post(body).build();
        try {
            Response r = webclient.newCall(request).execute();
            String response_string = r.body().string();
            return response_string;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
