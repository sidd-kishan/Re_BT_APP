/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.widget.Toast
 */
package com.lianhezhuli.btnotification.utils;

import android.content.Context;
import android.widget.Toast;

public class ToastUtils {
    private static Toast toast;

    public static void showLong(Context context, int n) {
        if (context == null) return;
        context = Toast.makeText((Context)context, (int)n, (int)1);
        toast = context;
        context.show();
    }

    public static void showLong(Context context, String string) {
        if (context == null) return;
        context = Toast.makeText((Context)context, (CharSequence)string, (int)1);
        toast = context;
        context.show();
    }

    public static void showLongCenter(Context context, int n) {
        if (context == null) return;
        context = Toast.makeText((Context)context, (int)n, (int)1);
        toast = context;
        context.setGravity(17, 0, 0);
        toast.show();
    }

    public static void showLongCenter(Context context, String string) {
        if (context == null) return;
        context = Toast.makeText((Context)context, (CharSequence)string, (int)1);
        toast = context;
        context.setGravity(17, 0, 0);
        toast.show();
    }

    public static void showShort(Context context, int n) {
        if (context == null) return;
        context = Toast.makeText((Context)context, (int)n, (int)0);
        toast = context;
        context.show();
    }

    public static void showShort(Context context, String string) {
        if (context == null) return;
        context = Toast.makeText((Context)context, (CharSequence)string, (int)0);
        toast = context;
        context.show();
    }

    public static void showShortCenter(Context context, int n) {
        if (context == null) return;
        context = Toast.makeText((Context)context, (int)n, (int)0);
        toast = context;
        context.setGravity(17, 0, 0);
        toast.show();
    }

    public static void showShortCenter(Context context, String string) {
        if (context == null) return;
        context = Toast.makeText((Context)context, (CharSequence)string, (int)0);
        toast = context;
        context.setGravity(17, 0, 0);
        toast.show();
    }
}
