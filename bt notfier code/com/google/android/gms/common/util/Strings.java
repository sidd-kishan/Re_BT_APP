/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package com.google.android.gms.common.util;

import android.text.TextUtils;
import java.util.regex.Pattern;

public class Strings {
    private static final Pattern zza = Pattern.compile("\\$\\{(.*?)\\}");

    private Strings() {
    }

    public static String emptyToNull(String string) {
        String string2 = string;
        if (!TextUtils.isEmpty((CharSequence)string)) return string2;
        string2 = null;
        return string2;
    }

    public static boolean isEmptyOrWhitespace(String string) {
        if (string == null) return true;
        if (!string.trim().isEmpty()) return false;
        return true;
    }
}
