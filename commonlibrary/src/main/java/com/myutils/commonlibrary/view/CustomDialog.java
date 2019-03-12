package com.myutils.commonlibrary.view;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.TextView;

import com.myutils.commonlibrary.R;

/**
 * Created by xu on 2018/7/31.
 */

public class CustomDialog extends ProgressDialog {
    TextView tv_load_dialog;

    public CustomDialog(Context context) {
        super(context);
    }

    public CustomDialog(Context context, int theme) {
        super(context, theme);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        init(getContext());
    }

    private void init(Context context) {
        //设置不可取消，点击其他区域不能取消，实际中可以抽出去封装供外包设置
        setCancelable(false);
        setCanceledOnTouchOutside(false);

        setContentView(R.layout.load_dialog);
//        tv_load_dialog = findViewById(R.id.tv_load_dialog);
        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.width = WindowManager.LayoutParams.WRAP_CONTENT;
        params.height = WindowManager.LayoutParams.WRAP_CONTENT;
        getWindow().setAttributes(params);
    }

//    @Override
//    public void setMessage(CharSequence message) {
//        super.setMessage(message);
//        tv_load_dialog.setText(message);
//    }

    @Override
    public void show() {
        super.show();
    }
}
