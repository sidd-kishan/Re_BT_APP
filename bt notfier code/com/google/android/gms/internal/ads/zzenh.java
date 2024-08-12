/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzcgi
 *  com.google.android.gms.internal.ads.zzcgz
 *  com.google.android.gms.internal.ads.zzeng
 *  com.google.android.gms.internal.ads.zzeni
 *  com.google.android.gms.internal.ads.zzery
 *  com.google.android.gms.internal.ads.zzfar
 *  com.google.android.gms.internal.ads.zzfsm
 *  com.google.android.gms.internal.ads.zzfsn
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcgi;
import com.google.android.gms.internal.ads.zzcgz;
import com.google.android.gms.internal.ads.zzeng;
import com.google.android.gms.internal.ads.zzeni;
import com.google.android.gms.internal.ads.zzery;
import com.google.android.gms.internal.ads.zzfar;
import com.google.android.gms.internal.ads.zzfsm;
import com.google.android.gms.internal.ads.zzfsn;
import java.util.concurrent.Callable;

public final class zzenh
implements zzery<zzeni> {
    private final zzfsn zza;
    private final zzfar zzb;
    private final zzcgz zzc;
    private final zzcgi zzd;

    public zzenh(zzfsn zzfsn2, zzfar zzfar2, zzcgz zzcgz2, zzcgi zzcgi2) {
        this.zza = zzfsn2;
        this.zzb = zzfar2;
        this.zzc = zzcgz2;
        this.zzd = zzcgi2;
    }

    public final zzfsm<zzeni> zza() {
        return this.zza.zzb((Callable)new zzeng(this));
    }

    final /* synthetic */ zzeni zzb() throws Exception {
        return new zzeni(this.zzb.zzj, this.zzc, this.zzd.zzj());
    }
}
