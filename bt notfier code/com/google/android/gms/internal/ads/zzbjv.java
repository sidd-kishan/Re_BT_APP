/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  com.google.android.gms.internal.ads.zzbjw
 */
package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.internal.ads.zzbjw;

final class zzbjv
extends zzbjw {
    zzbjv() {
    }

    private static final String zzb(String string) {
        int n;
        if (TextUtils.isEmpty((CharSequence)string)) {
            return string;
        }
        int n2 = string.length();
        int n3 = 0;
        int n4 = 0;
        while (true) {
            n = n2;
            if (n4 >= string.length()) break;
            n = n2;
            if (string.charAt(n4) != ',') break;
            ++n4;
        }
        while (n > 0 && string.charAt(n2 = n - 1) == ',') {
            n = n2;
        }
        if (n < n4) {
            return null;
        }
        if (n4 != 0) return string.substring(n4, n);
        if (n == string.length()) return string;
        n4 = n3;
        return string.substring(n4, n);
    }

    public final String zza(String string, String string2) {
        string = zzbjv.zzb(string);
        string2 = zzbjv.zzb(string2);
        if (TextUtils.isEmpty((CharSequence)string)) {
            return string2;
        }
        if (TextUtils.isEmpty((CharSequence)string2)) {
            return string;
        }
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(string).length() + 1 + String.valueOf(string2).length());
        stringBuilder.append(string);
        stringBuilder.append(",");
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }
}
