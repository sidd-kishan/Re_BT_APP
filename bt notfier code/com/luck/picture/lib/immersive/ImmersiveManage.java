/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.os.Build$VERSION
 *  android.view.Window
 *  androidx.appcompat.app.AppCompatActivity
 *  com.luck.picture.lib.immersive.LightStatusBarUtils
 */
package com.luck.picture.lib.immersive;

import android.app.Activity;
import android.os.Build;
import android.view.Window;
import androidx.appcompat.app.AppCompatActivity;
import com.luck.picture.lib.immersive.LightStatusBarUtils;

public class ImmersiveManage {
    public static void immersiveAboveAPI23(AppCompatActivity appCompatActivity, int n, int n2, boolean bl) {
        if (Build.VERSION.SDK_INT < 23) return;
        ImmersiveManage.immersiveAboveAPI23(appCompatActivity, false, false, n, n2, bl);
    }

    /*
     * Enabled force condition propagation
     */
    public static void immersiveAboveAPI23(AppCompatActivity appCompatActivity, boolean bl, boolean bl2, int n, int n2, boolean bl3) {
        try {
            Window window = appCompatActivity.getWindow();
            if (Build.VERSION.SDK_INT >= 19 && Build.VERSION.SDK_INT < 21) {
                window.setFlags(0x4000000, 0x4000000);
                return;
            }
            if (Build.VERSION.SDK_INT < 21) return;
            boolean bl4 = false;
            boolean bl5 = true;
            if (bl && bl2) {
                window.clearFlags(0xC000000);
                bl = bl4;
                if (n == 0) {
                    bl = true;
                }
                LightStatusBarUtils.setLightStatusBar((Activity)appCompatActivity, (boolean)true, (boolean)true, (boolean)bl, (boolean)bl3);
                window.addFlags(Integer.MIN_VALUE);
            } else if (!bl && !bl2) {
                window.requestFeature(1);
                window.clearFlags(0xC000000);
                bl = n == 0 ? bl5 : false;
                LightStatusBarUtils.setLightStatusBar((Activity)appCompatActivity, (boolean)false, (boolean)false, (boolean)bl, (boolean)bl3);
                window.addFlags(Integer.MIN_VALUE);
            } else {
                if (bl) return;
                window.requestFeature(1);
                window.clearFlags(0xC000000);
                bl = n == 0;
                LightStatusBarUtils.setLightStatusBar((Activity)appCompatActivity, (boolean)false, (boolean)true, (boolean)bl, (boolean)bl3);
                window.addFlags(Integer.MIN_VALUE);
            }
            window.setStatusBarColor(n);
            window.setNavigationBarColor(n2);
            return;
        }
        catch (Exception exception) {
            return;
        }
    }
}
