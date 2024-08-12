/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package com.bumptech.glide.util;

import android.text.TextUtils;
import java.util.Collection;

public final class Preconditions {
    private Preconditions() {
    }

    public static void checkArgument(boolean bl, String string) {
        if (!bl) throw new IllegalArgumentException(string);
    }

    public static String checkNotEmpty(String string) {
        if (TextUtils.isEmpty((CharSequence)string)) throw new IllegalArgumentException("Must not be null or empty");
        return string;
    }

    public static <T extends Collection<Y>, Y> T checkNotEmpty(T t) {
        if (t.isEmpty()) throw new IllegalArgumentException("Must not be empty.");
        return t;
    }

    public static <T> T checkNotNull(T t) {
        return Preconditions.checkNotNull(t, "Argument must not be null");
    }

    public static <T> T checkNotNull(T t, String string) {
        if (t == null) throw new NullPointerException(string);
        return t;
    }
}
