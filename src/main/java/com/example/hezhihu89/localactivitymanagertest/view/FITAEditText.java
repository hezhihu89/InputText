package com.example.hezhihu89.localactivitymanagertest.view;

import android.content.Context;
import android.text.InputType;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;

/**
 * @项目名 ：GooglePlay
 * @包名 ：com.example.hezhihu89.localactivitymanagertest.view
 * @User ： hezhihu89 by：贺志虎
 * @创建时间 ：2015 年 12 月 29 日   15时 30分.
 * @类的描述 : TODO：
 */
public class FITAEditText extends EditText implements View.OnClickListener {

    private TIFAInputMethodPlugin input;

    public FITAEditText(Context context) {
        this(context, null);
    }

    public FITAEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        onCreate(context);
    }

    private void onCreate(final Context context) {

        this.setInputType(InputType.TYPE_NULL);

    }

    @Override
    public void onClick(View v) {

    }
}
