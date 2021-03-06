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

public class OkhttpRentSearch extends AsyncTask<String, Void, String> {
    OkHttpClient webclient = new OkHttpClient();
    String username, pass, fact, depto, codigo;

    public OkhttpRentSearch(String user, String pass, String e1, String v1, String code){
        this.username = user;
        this.pass = pass;
        this.fact = e1;
        this.depto = v1;
        this.codigo = code;
    }


    @Override
    protected String doInBackground(String... params) {
        RequestBody body = new FormEncodingBuilder()
                .add("user", username)
                .add("pass", pass)
                .add("fact", fact)
                .add("dept", depto)
                .add("code", codigo)
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
