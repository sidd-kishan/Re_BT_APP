/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Base64
 */
package com.google.android.gms.internal.ads;

import android.util.Base64;

public final class zzzo {
    public static String zza(byte[] byArray, boolean bl) {
        int n = true != bl ? 2 : 11;
        return Base64.encodeToString((byte[])byArray, (int)n);
    }

    public static byte[] zzb(String string, boolean bl) throws IllegalArgumentException {
        int n = true != bl ? 2 : 11;
        byte[] byArray = Base64.decode((String)string, (int)n);
        if (byArray.length != 0) return byArray;
        if (string.length() <= 0) return byArray;
        string = (string = String.valueOf(string)).length() != 0 ? "Unable to decode ".concat(string) : new String("Unable to decode ");
        throw new IllegalArgumentException(string);
    }
}
