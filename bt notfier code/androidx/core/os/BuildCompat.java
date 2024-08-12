/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 */
package androidx.core.os;

import android.os.Build;

public class BuildCompat {
    private BuildCompat() {
    }

    @Deprecated
    public static boolean isAtLeastN() {
        boolean bl = Build.VERSION.SDK_INT >= 24;
        return bl;
    }

    @Deprecated
    public static boolean isAtLeastNMR1() {
        boolean bl = Build.VERSION.SDK_INT >= 25;
        return bl;
    }

    @Deprecated
    public static boolean isAtLeastO() {
        boolean bl = Build.VERSION.SDK_INT >= 26;
        return bl;
    }

    @Deprecated
    public static boolean isAtLeastOMR1() {
        boolean bl = Build.VERSION.SDK_INT >= 27;
        return bl;
    }

    @Deprecated
    public static boolean isAtLeastP() {
        boolean bl = Build.VERSION.SDK_INT >= 28;
        return bl;
    }

    protected static boolean isAtLeastPreReleaseCodename(String string, String string2) {
        boolean bl = "REL".equals(string2);
        boolean bl2 = false;
        if (bl) {
            return false;
        }
        if (string2.compareTo(string) < 0) return bl2;
        bl2 = true;
        return bl2;
    }

    @Deprecated
    public static boolean isAtLeastQ() {
        boolean bl = Build.VERSION.SDK_INT >= 29;
        return bl;
    }

    @Deprecated
    public static boolean isAtLeastR() {
        boolean bl = Build.VERSION.SDK_INT >= 30;
        return bl;
    }

    public static boolean isAtLeastS() {
        boolean bl = Build.VERSION.SDK_INT >= 31 || BuildCompat.isAtLeastPreReleaseCodename("S", Build.VERSION.CODENAME);
        return bl;
    }

    public static boolean isAtLeastT() {
        return BuildCompat.isAtLeastPreReleaseCodename("T", Build.VERSION.CODENAME);
    }
}
