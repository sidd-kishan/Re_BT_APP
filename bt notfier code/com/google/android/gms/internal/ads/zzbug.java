/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.google.android.gms.ads.internal.util.zzbe
 *  com.google.android.gms.internal.ads.zzbsn
 *  com.google.android.gms.internal.ads.zzbts
 *  com.google.android.gms.internal.ads.zzbtw
 *  com.google.android.gms.internal.ads.zzbty
 *  com.google.android.gms.internal.ads.zzbtz
 *  com.google.android.gms.internal.ads.zzbue
 *  com.google.android.gms.internal.ads.zzbuf
 *  com.google.android.gms.internal.ads.zzbuk
 *  com.google.android.gms.internal.ads.zzbup
 *  com.google.android.gms.internal.ads.zzcgz
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zzbe;
import com.google.android.gms.internal.ads.zzbsn;
import com.google.android.gms.internal.ads.zzbts;
import com.google.android.gms.internal.ads.zzbtw;
import com.google.android.gms.internal.ads.zzbty;
import com.google.android.gms.internal.ads.zzbtz;
import com.google.android.gms.internal.ads.zzbue;
import com.google.android.gms.internal.ads.zzbuf;
import com.google.android.gms.internal.ads.zzbuk;
import com.google.android.gms.internal.ads.zzbup;
import com.google.android.gms.internal.ads.zzcgz;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public final class zzbug {
    static final zzbe<zzbsn> zza = new zzbue();
    static final zzbe<zzbsn> zzb = new zzbuf();
    private final zzbts zzc;

    public zzbug(Context context, zzcgz zzcgz2, String string) {
        this.zzc = new zzbts(context, zzcgz2, string, zza, zzb);
    }

    public final <I, O> zzbtw<I, O> zza(String string, zzbtz<I> zzbtz2, zzbty<O> zzbty2) {
        return new zzbuk(this.zzc, string, zzbtz2, zzbty2);
    }

    public final zzbup zzb() {
        return new zzbup(this.zzc);
    }
}
