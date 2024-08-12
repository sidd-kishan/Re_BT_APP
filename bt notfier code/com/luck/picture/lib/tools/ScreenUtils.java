/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.util.DisplayMetrics
 */
package com.luck.picture.lib.tools;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;

public class ScreenUtils {
    public static int dip2px(Context context, float f) {
        return (int)(f * context.getApplicationContext().getResources().getDisplayMetrics().density + 0.5f);
    }

    public static int getScreenHeight(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity)context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.heightPixels - ScreenUtils.getStatusBarHeight(context);
    }

    public static int getScreenWidth(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity)context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    public static int getStatusBarHeight(Context context) {
        int n = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        n = n > 0 ? context.getResources().getDimensionPixelSize(n) : 0;
        int n2 = n;
        if (n != 0) return n2;
        n2 = ScreenUtils.dip2px(context, 25.0f);
        return n2;
    }
}
