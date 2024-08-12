/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.view.Surface
 *  com.google.android.gms.internal.ads.zzanm
 *  com.google.android.gms.internal.ads.zzapf
 *  com.google.android.gms.internal.ads.zzavq
 *  com.google.android.gms.internal.ads.zzavr
 *  com.google.android.gms.internal.ads.zzavs
 *  com.google.android.gms.internal.ads.zzavt
 *  com.google.android.gms.internal.ads.zzavu
 *  com.google.android.gms.internal.ads.zzavv
 *  com.google.android.gms.internal.ads.zzavw
 *  com.google.android.gms.internal.ads.zzavy
 */
package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.view.Surface;
import com.google.android.gms.internal.ads.zzanm;
import com.google.android.gms.internal.ads.zzapf;
import com.google.android.gms.internal.ads.zzavq;
import com.google.android.gms.internal.ads.zzavr;
import com.google.android.gms.internal.ads.zzavs;
import com.google.android.gms.internal.ads.zzavt;
import com.google.android.gms.internal.ads.zzavu;
import com.google.android.gms.internal.ads.zzavv;
import com.google.android.gms.internal.ads.zzavw;
import com.google.android.gms.internal.ads.zzavy;

public final class zzavx {
    private final Handler zza;
    private final zzavy zzb;

    public zzavx(Handler handler, zzavy zzavy2) {
        if (handler == null) throw null;
        this.zza = handler;
        this.zzb = zzavy2;
    }

    static /* synthetic */ zzavy zza(zzavx zzavx2) {
        return zzavx2.zzb;
    }

    public final void zzb(zzapf zzapf2) {
        this.zza.post((Runnable)new zzavq(this, zzapf2));
    }

    public final void zzc(String string, long l, long l2) {
        this.zza.post((Runnable)new zzavr(this, string, l, l2));
    }

    public final void zzd(zzanm zzanm2) {
        this.zza.post((Runnable)new zzavs(this, zzanm2));
    }

    public final void zze(int n, long l) {
        this.zza.post((Runnable)new zzavt(this, n, l));
    }

    public final void zzf(int n, int n2, int n3, float f) {
        this.zza.post((Runnable)new zzavu(this, n, n2, n3, f));
    }

    public final void zzg(Surface surface) {
        this.zza.post((Runnable)new zzavv(this, surface));
    }

    public final void zzh(zzapf zzapf2) {
        this.zza.post((Runnable)new zzavw(this, zzapf2));
    }
}
