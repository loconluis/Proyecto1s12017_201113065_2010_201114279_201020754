package com.projects.loconluis.myapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ListRent extends AppCompatActivity {
    private Button bt_lrback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_rent);
        bt_lrback = (Button) findViewById(R.id.bt_lrback);

        bt_lrback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(ListRent.this, ListActivity.class);
                startActivity(in);
                finish();
            }
        });
    }
}
