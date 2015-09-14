package com.zhengyuli.lzyapp.volley.activity;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

import com.zhengyuli.lzyapp.R;

/**
 * author: zhengyu.li
 * description:
 * date: 2015/9/1
 */
public class VolleyActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volley);

        customerActionBar();
    }

    private void customerActionBar(){
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
            actionBar.setCustomView(R.layout.actionbar_volley);// 自定义ActionBar布局
            //findViewById(R.id.btn_back).setOnClickListener(this);
        }
    }
}
