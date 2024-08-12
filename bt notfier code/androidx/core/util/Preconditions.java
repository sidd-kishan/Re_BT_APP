/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package androidx.core.util;

import android.text.TextUtils;
import java.util.Locale;

public final class Preconditions {
    private Preconditions() {
    }

    public static void checkArgument(boolean bl) {
        if (!bl) throw new IllegalArgumentException();
    }

    public static void checkArgument(boolean bl, Object object) {
        if (!bl) throw new IllegalArgumentException(String.valueOf(object));
    }

    public static int checkArgumentInRange(int n, int n2, int n3, String string) {
        if (n < n2) {
            throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%d, %d] (too low)", string, n2, n3));
        }
        if (n > n3) throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%d, %d] (too high)", string, n2, n3));
        return n;
    }

    public static int checkArgumentNonnegative(int n) {
        if (n < 0) throw new IllegalArgumentException();
        return n;
    }

    public static int checkArgumentNonnegative(int n, String string) {
        if (n < 0) throw new IllegalArgumentException(string);
        return n;
    }

    public static int checkFlagsArgument(int n, int n2) {
        if ((n & n2) == n) {
            return n;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Requested flags 0x");
        stringBuilder.append(Integer.toHexString(n));
        stringBuilder.append(", but only 0x");
        stringBuilder.append(Integer.toHexString(n2));
        stringBuilder.append(" are allowed");
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public static <T> T checkNotNull(T t) {
        if (t == null) throw null;
        return t;
    }

    public static <T> T checkNotNull(T t, Object object) {
        if (t == null) throw new NullPointerException(String.valueOf(object));
        return t;
    }

    public static void checkState(boolean bl) {
        Preconditions.checkState(bl, null);
    }

    public static void checkState(boolean bl, String string) {
        if (!bl) throw new IllegalStateException(string);
    }

    public static <T extends CharSequence> T checkStringNotEmpty(T t) {
        if (TextUtils.isEmpty(t)) throw new IllegalArgumentException();
        return t;
    }

    public static <T extends CharSequence> T checkStringNotEmpty(T t, Object object) {
        if (TextUtils.isEmpty(t)) throw new IllegalArgumentException(String.valueOf(object));
        return t;
    }

    public static <T extends CharSequence> T checkStringNotEmpty(T t, String string, Object ... objectArray) {
        if (TextUtils.isEmpty(t)) throw new IllegalArgumentException(String.format(string, objectArray));
        return t;
    }
}
