/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzcbj
 *  com.google.android.gms.internal.ads.zzfll
 *  com.google.android.gms.internal.ads.zzfqo
 *  com.google.android.gms.internal.ads.zzfrk
 *  com.google.android.gms.internal.ads.zzfsd
 *  com.google.android.gms.internal.ads.zzfsm
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcbj;
import com.google.android.gms.internal.ads.zzfll;
import com.google.android.gms.internal.ads.zzfqo;
import com.google.android.gms.internal.ads.zzfrk;
import com.google.android.gms.internal.ads.zzfsd;
import com.google.android.gms.internal.ads.zzfsm;
import java.io.InputStream;

final class zzeas
implements zzfrk {
    private final zzcbj zza;

    zzeas(zzcbj zzcbj2) {
        this.zza = zzcbj2;
    }

    public final zzfsm zza(Object object) {
        zzcbj zzcbj2 = this.zza;
        zzcbj2.zzj = new String(zzfqo.zza((InputStream)((InputStream)object)), zzfll.zzc);
        return zzfsd.zza((Object)zzcbj2);
    }
}
