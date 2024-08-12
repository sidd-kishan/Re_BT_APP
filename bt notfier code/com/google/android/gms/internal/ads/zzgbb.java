/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzgar
 *  com.google.android.gms.internal.ads.zzgba
 *  com.google.android.gms.internal.ads.zzgbv
 *  com.google.android.gms.internal.ads.zzgga
 *  com.google.android.gms.internal.ads.zzghi
 *  com.google.android.gms.internal.ads.zzghj
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgar;
import com.google.android.gms.internal.ads.zzgba;
import com.google.android.gms.internal.ads.zzgbv;
import com.google.android.gms.internal.ads.zzgga;
import com.google.android.gms.internal.ads.zzghi;
import com.google.android.gms.internal.ads.zzghj;

public final class zzgbb
extends zzgga<zzgbb, zzgba>
implements zzghj {
    private static final zzgbb zzh;
    private zzgar zzb;
    private int zze;
    private int zzf;
    private int zzg;

    static {
        zzgbb zzgbb2;
        zzh = zzgbb2 = new zzgbb();
        zzgga.zzay(zzgbb.class, (zzgga)zzgbb2);
    }

    private zzgbb() {
    }

    static /* synthetic */ zzgbb zze() {
        return zzh;
    }

    public final boolean zza() {
        if (this.zzb == null) return false;
        return true;
    }

    protected final Object zzb(int n, Object object, Object object2) {
        if (--n == 0) return (byte)1;
        if (n == 2) return zzgbb.zzaz((zzghi)zzh, (String)"\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\t\u0002\f\u0003\u000b\u0004\f", (Object[])new Object[]{"zzb", "zze", "zzf", "zzg"});
        if (n == 3) return new zzgbb();
        if (n == 4) return new zzgba(null);
        if (n == 5) return zzh;
        return null;
    }

    public final zzgar zzc() {
        zzgar zzgar2;
        zzgar zzgar3 = zzgar2 = this.zzb;
        if (zzgar2 != null) return zzgar3;
        zzgar3 = zzgar.zze();
        return zzgar3;
    }

    public final int zzd() {
        return this.zzf;
    }

    public final int zzf() {
        int n = this.zze;
        int n2 = 3;
        if (n != 0) {
            if (n != 1) {
                n2 = n != 2 ? (n != 3 ? 0 : 5) : 4;
            }
        } else {
            n2 = 2;
        }
        if (n2 != 0) return n2;
        return 1;
    }

    public final int zzg() {
        int n;
        int n2 = n = zzgbv.zzb((int)this.zzg);
        if (n != 0) return n2;
        n2 = 1;
        return n2;
    }
}
