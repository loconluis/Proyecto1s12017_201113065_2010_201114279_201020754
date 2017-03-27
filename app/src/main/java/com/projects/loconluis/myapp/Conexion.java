package com.projects.loconluis.myapp;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;


/**
 * Created by luisl on 26/03/2017.
 */

public class Conexion {
    public static OkHttpClient webClient = new OkHttpClient();

    public String getString(String metodo, RequestBody formBody) throws IOException {
        try {
            URL url = new URL("https://cffgxyapon.localtunnel.me/"+metodo);
            Request request = new Request.Builder().url(url).post(formBody).build();
            Response response = webClient.newCall(request).execute();
            String response_string = response.body().string();
            return response_string;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
