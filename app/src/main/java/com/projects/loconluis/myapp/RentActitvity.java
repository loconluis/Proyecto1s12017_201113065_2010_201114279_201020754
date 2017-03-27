package com.projects.loconluis.myapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.Spinner;
import android.widget.TextView;

import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.RequestBody;

import java.io.IOException;

import static android.R.attr.data;
import static android.R.attr.finishOnCloseSystemDialogs;

public class RentActitvity extends AppCompatActivity {
    //Declaracion de variables
    private Spinner cmb_id;
    private TextView lb_name;
    private TextView lb_des;
    private NumberPicker np_dias = null;
    private Button bt_valid;
    private Button bt_back;

    Conexion cn = new Conexion();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rent);
        cmb_id = (Spinner) findViewById(R.id.cmb_id);
        lb_name = (TextView) findViewById(R.id.lb_name);
        lb_des = (TextView) findViewById(R.id.lb_des);
        np_dias = (NumberPicker) findViewById(R.id.np_dias);
        bt_valid = (Button) findViewById(R.id.bt_valid);
        bt_back = (Button) findViewById(R.id.bt_back);
        //Todo lo de OKHTTP
                /*RequestBody formbody = new FormEncodingBuilder()
                        .add("user", username)
                        .add("pass", pass)
                        .add("fact", fact)
                        .add("depto", depto)
                        .build();
                try {
                    String r = cn.getString("login", formbody);
                } catch (IOException e) {
                    e.printStackTrace();
                }*/

        //list[] = r.split("~");

        String prueba = "001~002~003~004";
        final String codigo[] = prueba.split("~");

        ArrayAdapter ad = new ArrayAdapter(this, android.R.layout.simple_spinner_item, codigo);
        ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        cmb_id.setAdapter(ad);


        //Setup Numberpicker
        np_dias.setMaxValue(100);
        np_dias.setMinValue(0);

        cmb_id.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //METODOS PARA BUSCAR EN EL SERVIDOR
                /*String seleccion = cmb_id.getSelectedItem().toString();
                RequestBody requestSelection = new FormEncodingBuilder()
                        .add("dato", seleccion)
                        .build();
                try {
                    String data = cn.getString("/articulo/buscar", requestSelection);
                    String info[] = data.split("~");
                    lb_name.setText(info[0]);
                    lb_des.setText(info[1]);
                } catch (IOException e) {
                    e.printStackTrace();
                }*/
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



        bt_valid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        bt_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(RentActitvity.this, ListActivity.class);
                startActivity(in);
                finish();
            }
        });
    }


}
