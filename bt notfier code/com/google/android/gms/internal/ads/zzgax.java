/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzgaw
 *  com.google.android.gms.internal.ads.zzgga
 *  com.google.android.gms.internal.ads.zzghi
 *  com.google.android.gms.internal.ads.zzghj
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgaw;
import com.google.android.gms.internal.ads.zzgga;
import com.google.android.gms.internal.ads.zzghi;
import com.google.android.gms.internal.ads.zzghj;

@Deprecated
public final class zzgax
extends zzgga<zzgax, zzgaw>
implements zzghj {
    private static final zzgax zzi;
    private String zzb = "";
    private String zze = "";
    private int zzf;
    private boolean zzg;
    private String zzh = "";

    static {
        zzgax zzgax2;
        zzi = zzgax2 = new zzgax();
        zzgga.zzay(zzgax.class, (zzgga)zzgax2);
    }

    private zzgax() {
    }

    static /* synthetic */ zzgax zzg() {
        return zzi;
    }

    public final String zza() {
        return this.zzb;
    }

    protected final Object zzb(int n, Object object, Object object2) {
        if (--n == 0) return (byte)1;
        if (n == 2) return zzgax.zzaz((zzghi)zzi, (String)"\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0000\u0000\u0001\u0208\u0002\u0208\u0003\u000b\u0004\u0007\u0005\u0208", (Object[])new Object[]{"zzb", "zze", "zzf", "zzg", "zzh"});
        if (n == 3) return new zzgax();
        if (n == 4) return new zzgaw(null);
        if (n == 5) return zzi;
        return null;
    }

    public final String zzc() {
        return this.zze;
    }

    public final int zzd() {
        return this.zzf;
    }

    public final boolean zze() {
        return this.zzg;
    }

    public final String zzf() {
        return this.zzh;
    }
}
