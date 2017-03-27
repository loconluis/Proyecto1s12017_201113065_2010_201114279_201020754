package com.projects.loconluis.myapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;

import java.io.IOException;

public class LoginActivity extends AppCompatActivity {

    private EditText txt_name;
    private EditText txt_pass;
    private EditText txt_factory;
    private EditText txt_depto;
    private Button bt_login;

    Conexion cn = new Conexion();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
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

                //Todo lo de OKHTTP
                RequestBody formbody = new FormEncodingBuilder()
                        .add("user", username)
                        .add("pass", pass)
                        .add("fact", fact)
                        .add("dept", depto)
                        .build();
                String r= "";
                try {
                    r = cn.getString("login", formbody);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                if (r == "1"){
                    Intent in = new Intent(LoginActivity.this, ListActivity.class);
                    startActivity(in);
                    finish();
                    Toast.makeText(v.getContext(), "Bienvenido", Toast.LENGTH_SHORT).show();
                }else if(r=="0"){
                    Toast.makeText(v.getContext(), "Usuario o contraseña invalida", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
