/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Color
 */
package com.qmuiteam.qmui.util;

import android.graphics.Color;

public class QMUIColorHelper {
    public static String colorToString(int n) {
        return String.format("#%08X", n);
    }

    public static int computeColor(int n, int n2, float f) {
        f = Math.max(Math.min(f, 1.0f), 0.0f);
        int n3 = Color.alpha((int)n);
        int n4 = (int)((float)(Color.alpha((int)n2) - n3) * f);
        int n5 = Color.red((int)n);
        int n6 = (int)((float)(Color.red((int)n2) - n5) * f);
        int n7 = Color.green((int)n);
        int n8 = (int)((float)(Color.green((int)n2) - n7) * f);
        n = Color.blue((int)n);
        return Color.argb((int)(n4 + n3), (int)(n6 + n5), (int)(n8 + n7), (int)((int)((float)(Color.blue((int)n2) - n) * f) + n));
    }

    public static int setColorAlpha(int n, float f) {
        return QMUIColorHelper.setColorAlpha(n, f, true);
    }

    public static int setColorAlpha(int n, float f, boolean bl) {
        int n2 = 255;
        if (bl) return n & 0xFFFFFF | (int)(f * (float)n2) << 24;
        n2 = 0xFF & n >> 24;
        return n & 0xFFFFFF | (int)(f * (float)n2) << 24;
    }
}
