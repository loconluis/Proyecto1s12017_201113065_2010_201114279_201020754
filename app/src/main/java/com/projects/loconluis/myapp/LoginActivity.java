package com.projects.loconluis.myapp;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class LoginActivity extends AppCompatActivity {

    private EditText txt_name;
    private EditText txt_pass;
    private EditText txt_factory;
    private EditText txt_depto;
    private Button bt_login;

    //Conexion cn = new Conexion();

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        if (android.os.Build.VERSION.SDK_INT > 9)
        {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        //final Conexion cn = new Conexion();

        txt_name = (EditText) findViewById(R.id.txt_name);
        txt_pass = (EditText) findViewById(R.id.txt_pass);
        txt_depto = (EditText) findViewById(R.id.txt_depto);
        txt_factory = (EditText) findViewById(R.id.txt_factory);
        bt_login = (Button) findViewById(R.id.bt_login);





        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = txt_name.getText().toString().trim();
                String pass = txt_pass.getText().toString().trim();
                String fact = txt_factory.getText().toString().trim();
                String depto = txt_depto.getText().toString().trim();



                Okhttp manejador = new Okhttp(username, pass, fact, depto);

                String result = null;

                try {
                    result = manejador.execute("https://trtplttjim.localtunnel.me/login").get();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
                //Comienza la validacion para dejar entrar
                if(result.equals("1")){
                    Toast.makeText(getApplicationContext(), "Bienvenido", Toast.LENGTH_SHORT).show();
                    Intent in = new Intent(LoginActivity.this, ListActivity.class);
                    in.putExtra("user", username);
                    in.putExtra("pass", pass);
                    in.putExtra("fact", fact);
                    in.putExtra("dept", depto);
                    startActivity(in);
                    finish();
                }else{
                    Toast.makeText(getApplicationContext(), "Algun dato fue invalido", Toast.LENGTH_SHORT).show();
                }


            }
        });


    }
}
