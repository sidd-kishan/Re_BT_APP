/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 */
package com.google.android.gms.common.util;

import android.os.Build;

public final class PlatformVersion {
    private PlatformVersion() {
    }

    public static boolean isAtLeastHoneycomb() {
        return true;
    }

    public static boolean isAtLeastHoneycombMR1() {
        return true;
    }

    public static boolean isAtLeastIceCreamSandwich() {
        return true;
    }

    public static boolean isAtLeastIceCreamSandwichMR1() {
        if (Build.VERSION.SDK_INT < 15) return false;
        return true;
    }

    public static boolean isAtLeastJellyBean() {
        if (Build.VERSION.SDK_INT < 16) return false;
        return true;
    }

    public static boolean isAtLeastJellyBeanMR1() {
        if (Build.VERSION.SDK_INT < 17) return false;
        return true;
    }

    public static boolean isAtLeastJellyBeanMR2() {
        if (Build.VERSION.SDK_INT < 18) return false;
        return true;
    }

    public static boolean isAtLeastKitKat() {
        if (Build.VERSION.SDK_INT < 19) return false;
        return true;
    }

    public static boolean isAtLeastKitKatWatch() {
        if (Build.VERSION.SDK_INT < 20) return false;
        return true;
    }

    public static boolean isAtLeastLollipop() {
        if (Build.VERSION.SDK_INT < 21) return false;
        return true;
    }

    public static boolean isAtLeastLollipopMR1() {
        if (Build.VERSION.SDK_INT < 22) return false;
        return true;
    }

    public static boolean isAtLeastM() {
        if (Build.VERSION.SDK_INT < 23) return false;
        return true;
    }

    public static boolean isAtLeastN() {
        if (Build.VERSION.SDK_INT < 24) return false;
        return true;
    }

    public static boolean isAtLeastO() {
        if (Build.VERSION.SDK_INT < 26) return false;
        return true;
    }

    public static boolean isAtLeastP() {
        if (Build.VERSION.SDK_INT < 28) return false;
        return true;
    }

    public static boolean isAtLeastQ() {
        if (Build.VERSION.SDK_INT < 29) return false;
        return true;
    }

    public static boolean isAtLeastR() {
        if (Build.VERSION.SDK_INT < 30) return false;
        return true;
    }

    public static boolean isAtLeastS() {
        if (!PlatformVersion.isAtLeastR()) {
            return false;
        }
        if (Build.VERSION.CODENAME.length() != 1) return false;
        if (Build.VERSION.CODENAME.charAt(0) < 'S') return false;
        if (Build.VERSION.CODENAME.charAt(0) > 'Z') return false;
        return true;
    }
}
