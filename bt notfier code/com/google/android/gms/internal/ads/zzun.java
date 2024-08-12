/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.internal.ads;

public final class zzun {
    private final String zza;
    private final int zzb;
    private final int zzc;
    private int zzd;
    private String zze;

    public zzun(int n, int n2, int n3) {
        CharSequence charSequence;
        if (n != Integer.MIN_VALUE) {
            charSequence = new StringBuilder(12);
            ((StringBuilder)charSequence).append(n);
            ((StringBuilder)charSequence).append("/");
            charSequence = ((StringBuilder)charSequence).toString();
        } else {
            charSequence = "";
        }
        this.zza = charSequence;
        this.zzb = n2;
        this.zzc = n3;
        this.zzd = Integer.MIN_VALUE;
        this.zze = "";
    }

    private final void zzd() {
        if (this.zzd == Integer.MIN_VALUE) throw new IllegalStateException("generateNewId() must be called before retrieving ids.");
    }

    public final void zza() {
        int n = this.zzd;
        n = n == Integer.MIN_VALUE ? this.zzb : (n += this.zzc);
        this.zzd = n;
        String string = this.zza;
        StringBuilder stringBuilder = new StringBuilder(string.length() + 11);
        stringBuilder.append(string);
        stringBuilder.append(n);
        this.zze = stringBuilder.toString();
    }

    public final int zzb() {
        this.zzd();
        return this.zzd;
    }

    public final String zzc() {
        this.zzd();
        return this.zze;
    }
}
