/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.widget.Toast
 */
package com.luck.picture.lib.tools;

import android.content.Context;
import android.widget.Toast;

public final class ToastUtils {
    private static final long TIME = 1500L;
    private static long lastToastTime;

    public static boolean isShowToast() {
        long l = System.currentTimeMillis();
        if (l - lastToastTime < 1500L) {
            return true;
        }
        lastToastTime = l;
        return false;
    }

    public static void s(Context context, String string) {
        if (ToastUtils.isShowToast()) return;
        Toast.makeText((Context)context.getApplicationContext(), (CharSequence)string, (int)0).show();
    }
}
