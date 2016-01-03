package com.example.hezhihu89.localactivitymanagertest;

import android.app.Activity;
import android.app.ActivityGroup;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.hezhihu89.localactivitymanagertest.view.FITAEditText;
import com.example.hezhihu89.localactivitymanagertest.view.TIFAInputMethodPlugin;

public class MainActivity extends Activity implements View.OnClickListener {

    private Button but;
    private SwipeRefreshLayout refresh;
    private Handler handler;
    private FITAEditText edit;
    private TIFAInputMethodPlugin mDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // getWindow().requestFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_main);
        handler = new Handler();
        but = (Button) findViewById(R.id.but);
        edit = (FITAEditText) findViewById(R.id.tv_me);

        mDialog = new TIFAInputMethodPlugin(MainActivity.this);
        /*refresh = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh);
        refresh.setColorSchemeResources(android.R.color.holo_blue_light, android.R.color.holo_red_light, android.R.color.holo_orange_light, android.R.color.holo_green_light);
        */
        //设置点击事件监听器 -----测试
        but.setOnClickListener(this);
        edit.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.but:
                mDialog.show();
                break;
            case R.id.tv_me:
                Log.d("TAG", "弹出来了");
                mDialog.show(edit);
        }
    }
}
