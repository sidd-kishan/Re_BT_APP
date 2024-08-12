/*
 * Decompiled with CFR 0.152.
 */
package com.luck.picture.lib.tools;

public class DoubleUtils {
    private static final long TIME = 800L;
    private static long lastClickTime;

    public static boolean isFastDoubleClick() {
        long l = System.currentTimeMillis();
        if (l - lastClickTime < 800L) {
            return true;
        }
        lastClickTime = l;
        return false;
    }
}
