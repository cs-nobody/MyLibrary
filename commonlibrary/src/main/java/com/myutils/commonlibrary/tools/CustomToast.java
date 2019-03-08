package com.myutils.commonlibrary.tools;

import android.content.Context;
import android.widget.Toast;

public class CustomToast {
    private static Toast mToast = null;
    private static long oneTime = 0;
    private static long twoTime = 0;
    private static String oldMsg;

    public static void showToast(Context mContext, String text) {

        if (mToast != null) {
            twoTime = System.currentTimeMillis();
            if (text.equals(oldMsg)) {
                if ((twoTime - oneTime) > Toast.LENGTH_SHORT) {
                    mToast.show();
                }
            } else {
                oldMsg = text;
                mToast.setText(text);
                mToast.show();
            }
        } else {
            mToast = Toast.makeText(mContext, text, Toast.LENGTH_SHORT);
            oneTime = System.currentTimeMillis();
            mToast.show();
        }
        oneTime = twoTime;
    }

    public static void showToast(Context mContext, int resId, int duration) {
        showToast(mContext, mContext.getResources().getString(resId));
    }
}
