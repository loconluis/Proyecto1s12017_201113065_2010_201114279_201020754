package com.projects.loconluis.myapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    private Button bt_rent;
    private Button bt_devo;
    private Button bt_logout;
    String rname = null,
            rpass = null,
            rfact = null,
            rdept = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        bt_rent = (Button) findViewById(R.id.bt_rent);
        bt_devo = (Button) findViewById(R.id.bt_devo);
        bt_logout = (Button) findViewById(R.id.bt_logout);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        if(extras!=null){
            rname = (String)extras.get("user");
            rpass = (String)extras.get("pass");
            rfact = (String)extras.get("fact");
            rdept = (String)extras.get("dept");
        }


        bt_rent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(ListActivity.this, RentActitvity.class);
                in.putExtra("user", rname);
                in.putExtra("pass", rpass);
                in.putExtra("fact", rfact);
                in.putExtra("dept", rdept);
                startActivity(in);
                finish();
            }
        });

        bt_devo.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent in = new Intent(ListActivity.this, ListRent.class);
                startActivity(in);
                finish();
            }
        });

        bt_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Cerrando Sesion...", Toast.LENGTH_SHORT).show();
                Intent in = new Intent(ListActivity.this, LoginActivity.class);
                startActivity(in);
                finish();
            }
        });
    }
}
