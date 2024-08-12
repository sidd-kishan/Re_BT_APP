/*
 * Decompiled with CFR 0.152.
 */
package com.qmuiteam.qmui.util;

import java.io.Closeable;
import java.io.IOException;
import java.util.Locale;

public class QMUILangHelper {
    public static void close(Closeable closeable) {
        if (closeable == null) return;
        try {
            closeable.close();
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }

    public static float constrain(float f, float f2, float f3) {
        if (f < f2) return f2;
        f2 = f;
        if (!(f > f3)) return f2;
        f2 = f3;
        return f2;
    }

    public static int constrain(int n, int n2, int n3) {
        if (n < n2) return n2;
        n2 = n;
        if (n <= n3) return n2;
        n2 = n3;
        return n2;
    }

    public static int getNumberDigits(int n) {
        if (n > 0) return (int)(Math.log10(n) + 1.0);
        return 0;
    }

    public static int getNumberDigits(long l) {
        if (l > 0L) return (int)(Math.log10(l) + 1.0);
        return 0;
    }

    public static boolean isNullOrEmpty(CharSequence charSequence) {
        boolean bl = charSequence == null || charSequence.length() == 0;
        return bl;
    }

    public static boolean objectEquals(Object object, Object object2) {
        boolean bl = object == object2 || object != null && object.equals(object2);
        return bl;
    }

    public static String regularizePrice(double d) {
        return String.format(Locale.CHINESE, "%.2f", d);
    }

    public static String regularizePrice(float f) {
        return String.format(Locale.CHINESE, "%.2f", Float.valueOf(f));
    }
}
