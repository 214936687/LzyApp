package com.zhengyuli.lzyapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.android.volley.toolbox.Volley;
import com.zhengyuli.lzyapp.volley.activity.VolleyActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button volleyBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        volleyBtn = (Button)findViewById(R.id.btn_volley);
        volleyBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_volley:
                Intent intent = new Intent();
                intent.setClass(this, VolleyActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
