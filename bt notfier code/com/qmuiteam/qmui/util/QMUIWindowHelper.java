/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.view.WindowManager$LayoutParams
 */
package com.qmuiteam.qmui.util;

import android.os.Build;
import android.view.WindowManager;

public class QMUIWindowHelper {
    public static void setWindowType(WindowManager.LayoutParams layoutParams) {
        layoutParams.type = Build.VERSION.SDK_INT >= 19 ? 2005 : 2002;
    }
}
