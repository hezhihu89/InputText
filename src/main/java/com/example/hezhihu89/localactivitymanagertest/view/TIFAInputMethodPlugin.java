package com.example.hezhihu89.localactivitymanagertest.view;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.hezhihu89.localactivitymanagertest.MainActivity;
import com.example.hezhihu89.localactivitymanagertest.R;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * @项目名 ：GooglePlay
 * @包名 ：com.example.hezhihu89.localactivitymanagertest.view
 * @User ： hezhihu89 by：贺志虎
 * @创建时间 ：2015 年 12 月 29 日   09时 38分.
 * @类的描述 : TODO：
 */
public class TIFAInputMethodPlugin implements View.OnClickListener {

    Context mContext;
    MainActivity mainActivity;
    private final Dialog mDialog;
    private Window mWindow;
    private View mIputMothed;
    private Button cancle;
    private View contentView;
    private ArrayList<Button> mShowBox;
    private int[] but_id = {R.id.one, R.id.two, R.id.three, R.id.four,
            R.id.five, R.id.six, R.id.seven, R.id.eight, R.id.nine, R.id.zero, R.id.requse, R.id.cancel};

    private int[] shou_id = {R.id.sone, R.id.stwo, R.id.sthree, R.id.sfour, R.id.sfive, R.id.ssix};

    private int[] buts = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0,};

    private ArrayList<Button> mButtons;
    private GridView mGridView;
    private View view;
    private EditText edit;
    private Handler handler;
    private StringBuffer sb;

    public TIFAInputMethodPlugin(Context context) {
        this.mContext = context;
        mDialog = new Dialog(mContext);
        mWindow = mDialog.getWindow();
        handler = new Handler();
        mWindow.requestFeature(Window.FEATURE_NO_TITLE);


    }

    /**
     * 创建dialog的界面
     */
    private void create() {
        //初始化界面
        mIputMothed = View.inflate(mContext, R.layout.input_layout, null);
        view = getContentView();

        if (edit != null) {
            sb = new StringBuffer(edit.getText().toString());
        } else {
            sb = new StringBuffer();
        }

        //给界面设置属性
        mGridView.setAdapter(new MyAdapter());
        mDialog.setContentView(view);
        WindowManager.LayoutParams params = mWindow.getAttributes();
        params.width = params.MATCH_PARENT;
        params.gravity = Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL;
        //设置背景透明不模糊
        // params.dimAmount = 0f;
        mWindow.setWindowAnimations(android.R.style.Animation_InputMethod);
        mWindow.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FFFFFF")));
        mWindow.setAttributes(params);
    }

    public TIFAInputMethodPlugin show() {
        create();
        mDialog.show();

        return this;
    }

    public TIFAInputMethodPlugin dismiss() {
        mDialog.dismiss();
        return this;
    }


    /**
     * @return 初始化布局
     */
    public View getContentView() {
        //键盘容器
        RelativeLayout container = new RelativeLayout(mContext);
        //键盘和密码window容器
        LinearLayout showInput = new LinearLayout(mContext);
        showInput.setBackgroundResource(R.color.trans);
        showInput.setOrientation(LinearLayout.VERTICAL);
        //输入框
        LinearLayout textBox = new LinearLayout(mContext);
        textBox.setOrientation(LinearLayout.HORIZONTAL);

        mShowBox = new ArrayList<Button>();
        for (int x = 0; x < 6; x++) {
            Button button = new Button(mContext);
            ViewGroup.LayoutParams params = button.getLayoutParams();
            button.setLayoutParams(new LinearLayout.LayoutParams(0, params.WRAP_CONTENT, 1));
            textBox.setId(shou_id[x]);
            textBox.addView(button);
            mShowBox.add(button);
        }

        mGridView = new GridView(mContext);

        mGridView.setNumColumns(3);
        mGridView.setVerticalSpacing(5);
        mGridView.setHorizontalSpacing(5);
        // android:numColumns="3"
        Button button = null;

        mButtons = new ArrayList<Button>();
        for (int x = 0; x < 12; x++) {
            button = new Button(mContext);
            if (x == 10) {
                button.setText("确认");
            } else if (x == 11) {
                button.setText("取消");
            } else if (x < 10) {
                button.setText(buts[x] + "");
            }

            button.setId(but_id[x]);
            button.setTextIsSelectable(false);
            button.setBackgroundResource(R.drawable.button_selector);
            button.setOnClickListener(this);
            mButtons.add(button);

        }
        container.addView(mGridView);
        showInput.addView(textBox);
        showInput.addView(container);

        return showInput;
    }

    public void show(EditText edit) {
        this.edit = edit;
        show();

    }


    @Override
    public void onClick(View v) {

    /*    if (edit == null) {
            return;
        }*/
        switch (v.getId()) {
            case R.id.cancel:

                TosetText(-1);
                Log.d("TAG", "取消");
                break;
            case R.id.one:
                TosetText(0);
                Log.d("TAG", " 1111111111111");
                break;
            case R.id.two:
                TosetText(1);

                Log.d("TAG", " 2222222222222222222222");
                break;
            case R.id.three:

                TosetText(2);
                Log.d("TAG", " 3333333333333");
                break;
            case R.id.four:
                TosetText(3);
                Log.d("TAG", " 444444444444");
                break;
            case R.id.five:
                TosetText(4);
                Log.d("TAG", " 55555555555555");
                break;
            case R.id.six:
                TosetText(5);
                Log.d("TAG", " 66666666666");
                break;
            case R.id.seven:
                TosetText(6);
                Log.d("TAG", " 7777777777777777");
                break;

            case R.id.eight:
                TosetText(7);
                Log.d("TAG", " 8888888888");
                break;
            case R.id.nine:
                TosetText(8);
                Log.d("TAG", " 99999999999");
                break;
            case R.id.zero:
                TosetText(9);
                Log.d("TAG", " 000000000000");
                break;
            case R.id.requse:
                Log.d("TAG", " 确认");
                if (!isNull()) {
                    Toast.makeText(mContext, "必须6位", Toast.LENGTH_LONG).show();
                } else {
                    dismiss();
                }
                break;

        }
    }


    private void TosetText(final int num) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                if (num == -1) {

                    Log.d("TAG", "------蛋疼--------------------");
                    for (int n = mShowBox.size(); n > 0; n--) {
                        Log.d("TAG", mShowBox.size() + "------蛋疼--------------------" + n);
                        if (!TextUtils.isEmpty(mShowBox.get(n - 1).getText().toString())) {
                            mShowBox.get(n - 1).setText("");
                            return;
                        }
                    }

                } else {

                    for (Button but : mShowBox) {
                        Log.d("TAG", sb.toString() + "--------------------------");
                        if (TextUtils.isEmpty(but.getText().toString())) {
                            if (num == 9) {
                                but.setText(0 + "");
                                return;
                            }
                            but.setText(num + 1 + "");
                            return;
                        }
                    }
                    Log.d("TAG", sb.toString());

                }

            }
        });

    }

    public boolean isNull() {
        int count = 0;
        for (Button but : mShowBox) {
            if (!TextUtils.isEmpty(but.getText().toString())) {

                count++;
            }
        }

        return isnulls(count);
    }

    public boolean isnulls(int count) {

        if (count < 6) {
            return false;
        }
        return true;
    }

    //----------------------------Adapter 适配器----------------------------------------------------
    private class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            if (mButtons != null) {
                return mButtons.size();
            }
            return 0;
        }

        @Override
        public Object getItem(int position) {
            if (mButtons != null) {
                mButtons.get(position);
            }
            return null;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Button mbutton = mButtons.get(position);

            return mbutton;
        }
    }
//------------------------------适配器---------------------------------------------------------
}
