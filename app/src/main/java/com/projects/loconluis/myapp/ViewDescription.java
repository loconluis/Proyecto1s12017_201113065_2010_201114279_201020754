package com.projects.loconluis.myapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ViewDescription extends AppCompatActivity {
    private TextView lb_no;
    private TextView lb_name2;
    private TextView lb_des2;
    private TextView lb_diasrenta;
    private Button bt_devolver;
    private Button bt_back2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_description);
        lb_no = (TextView) findViewById(R.id.lb_no);
        lb_name2 = (TextView) findViewById(R.id.lb_name2);
        lb_des2 = (TextView) findViewById(R.id.lb_des2);
        lb_diasrenta = (TextView) findViewById(R.id.lb_diasrenta);
        bt_devolver = (Button) findViewById(R.id.bt_devolver);
        bt_back2 = (Button) findViewById(R.id.bt_back2);

        bt_devolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        bt_back2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(ViewDescription.this, ListActivity.class);
                startActivity(in);
                finish();
            }
        });
    }
}
