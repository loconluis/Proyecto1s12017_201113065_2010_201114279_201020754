package com.projects.loconluis.myapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class RentActitvity extends AppCompatActivity {
    //Declaracion de variables
    private Spinner cmb_id;
    private TextView lb_name;
    private TextView lb_des;
    private NumberPicker np_dias = null;
    private Button bt_valid;
    private Button bt_back;

    String rname = null,
            rpass = null,
            rfact = null,
            rdept = null;

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
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();



        if(extras!=null){
            rname = (String)extras.get("user");
            rpass = (String)extras.get("pass");
            rfact = (String)extras.get("fact");
            rdept = (String)extras.get("dept");
        }
        //PARA DEVOLVER CODIGOS
        OkhttpCode manejador = new OkhttpCode(rname, rfact, rdept);

        String result = null;

        try {
            result = manejador.execute("https://trtplttjim.localtunnel.me/codigo").get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        //El que splitea los codigos
        //String codes[] = result.split("~");

        String prueba = "001~002~003~004";
        String codigo[] = prueba.split("~");

        //ARRAY que agregar el split al Spinner
        ArrayAdapter<String> ad = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, codigo);
        ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        cmb_id.setAdapter(ad);


        //Setup Numberpicker
        np_dias.setMaxValue(100);
        np_dias.setMinValue(0);

        //CUANDO SE HACE CLICK EN ALGUN DATO DEL SPINNER
        cmb_id.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String seleccion = cmb_id.getSelectedItem().toString();
                //METODO QUE VA A TRAER LOS DATOS DEL OBJETO QUE SE SELECCIONO EN EL SPINNER
                //OkhttpRentSearch oks = new OkhttpRentSearch(rname, rpass, rfact, rdept, seleccion);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        //EL BOTON DE ENVIO DE DATOS DE RENTA
        bt_valid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ENVIAR AL SERVIDOR DE ASP
            }
        });
        //EL BOTON QUE HACE EL REGRESO
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
