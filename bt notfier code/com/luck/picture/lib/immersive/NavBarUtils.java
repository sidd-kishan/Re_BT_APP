/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.os.Build$VERSION
 *  android.view.Window
 */
package com.luck.picture.lib.immersive;

import android.app.Activity;
import android.os.Build;
import android.view.Window;

public class NavBarUtils {
    public static void setNavBarColor(Activity activity, int n) {
        NavBarUtils.setNavBarColor(activity.getWindow(), n);
    }

    public static void setNavBarColor(Window window, int n) {
        if (Build.VERSION.SDK_INT < 21) return;
        window.setNavigationBarColor(n);
    }
}
