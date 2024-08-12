/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.internal.ads;

class zzqx {
    public final int zzd;

    public zzqx(int n) {
        this.zzd = n;
    }

    public static int zze(int n) {
        return n >> 24 & 0xFF;
    }

    public static String zzf(int n) {
        StringBuilder stringBuilder = new StringBuilder(4);
        stringBuilder.append((char)(n >> 24 & 0xFF));
        stringBuilder.append((char)(n >> 16 & 0xFF));
        stringBuilder.append((char)(n >> 8 & 0xFF));
        stringBuilder.append((char)(n & 0xFF));
        return stringBuilder.toString();
    }

    public String toString() {
        return zzqx.zzf(this.zzd);
    }
}
