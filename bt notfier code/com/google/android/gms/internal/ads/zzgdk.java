/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.internal.ads;

public final class zzgdk {
    private final byte[] zza;

    private zzgdk(byte[] byArray, int n, int n2) {
        byte[] byArray2 = new byte[n2];
        this.zza = byArray2;
        System.arraycopy(byArray, 0, byArray2, 0, n2);
    }

    public static zzgdk zza(byte[] byArray, int n, int n2) {
        return new zzgdk(byArray, 0, n2);
    }

    public final byte[] zzb() {
        byte[] byArray = this.zza;
        int n = byArray.length;
        byte[] byArray2 = new byte[n];
        System.arraycopy(byArray, 0, byArray2, 0, n);
        return byArray2;
    }
}
