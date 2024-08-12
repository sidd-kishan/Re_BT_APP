/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzadh
 *  com.google.android.gms.internal.ads.zzgex
 *  com.google.android.gms.internal.ads.zzgfm
 *  com.google.android.gms.internal.ads.zzgga
 *  com.google.android.gms.internal.ads.zzggm
 *  com.google.android.gms.internal.ads.zzghi
 *  com.google.android.gms.internal.ads.zzghj
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzadh;
import com.google.android.gms.internal.ads.zzgex;
import com.google.android.gms.internal.ads.zzgfm;
import com.google.android.gms.internal.ads.zzgga;
import com.google.android.gms.internal.ads.zzggm;
import com.google.android.gms.internal.ads.zzghi;
import com.google.android.gms.internal.ads.zzghj;

public final class zzadi
extends zzgga<zzadi, zzadh>
implements zzghj {
    private static final zzadi zzj;
    private int zzb;
    private String zze = "";
    private String zzf = "";
    private long zzg;
    private long zzh;
    private long zzi;

    static {
        zzadi zzadi2;
        zzj = zzadi2 = new zzadi();
        zzgga.zzay(zzadi.class, (zzgga)zzadi2);
    }

    private zzadi() {
    }

    public static zzadi zzg(zzgex zzgex2) throws zzggm {
        return (zzadi)zzgga.zzaH((zzgga)zzj, (zzgex)zzgex2);
    }

    public static zzadi zzh(zzgex zzgex2, zzgfm zzgfm2) throws zzggm {
        return (zzadi)zzgga.zzaI((zzgga)zzj, (zzgex)zzgex2, (zzgfm)zzgfm2);
    }

    public static zzadh zzi() {
        return (zzadh)zzj.zzas();
    }

    public static zzadi zzj() {
        return zzj;
    }

    static /* synthetic */ zzadi zzk() {
        return zzj;
    }

    static /* synthetic */ void zzl(zzadi zzadi2, String string) {
        string.getClass();
        zzadi2.zzb |= 1;
        zzadi2.zze = string;
    }

    static /* synthetic */ void zzm(zzadi zzadi2, String string) {
        string.getClass();
        zzadi2.zzb |= 2;
        zzadi2.zzf = string;
    }

    static /* synthetic */ void zzn(zzadi zzadi2, long l) {
        zzadi2.zzb |= 4;
        zzadi2.zzg = l;
    }

    static /* synthetic */ void zzo(zzadi zzadi2, long l) {
        zzadi2.zzb |= 8;
        zzadi2.zzh = l;
    }

    static /* synthetic */ void zzp(zzadi zzadi2, long l) {
        zzadi2.zzb |= 0x10;
        zzadi2.zzi = l;
    }

    public final String zza() {
        return this.zze;
    }

    protected final Object zzb(int n, Object object, Object object2) {
        if (--n == 0) return (byte)1;
        if (n == 2) return zzadi.zzaz((zzghi)zzj, (String)"\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001\u1008\u0000\u0002\u1008\u0001\u0003\u1003\u0002\u0004\u1003\u0003\u0005\u1003\u0004", (Object[])new Object[]{"zzb", "zze", "zzf", "zzg", "zzh", "zzi"});
        if (n == 3) return new zzadi();
        if (n == 4) return new zzadh(null);
        if (n == 5) return zzj;
        return null;
    }

    public final String zzc() {
        return this.zzf;
    }

    public final long zzd() {
        return this.zzg;
    }

    public final long zze() {
        return this.zzh;
    }

    public final long zzf() {
        return this.zzi;
    }
}
