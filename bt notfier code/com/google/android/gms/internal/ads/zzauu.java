/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.internal.ads;

public final class zzauu {
    public static boolean zza(String string) {
        return "audio".equals(zzauu.zzc(string));
    }

    public static boolean zzb(String string) {
        return "video".equals(zzauu.zzc(string));
    }

    private static String zzc(String string) {
        if (string == null) {
            return null;
        }
        int n = string.indexOf(47);
        if (n != -1) return string.substring(0, n);
        string = string.length() != 0 ? "Invalid mime type: ".concat(string) : new String("Invalid mime type: ");
        throw new IllegalArgumentException(string);
    }
}
