/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  com.google.android.gms.internal.ads.zzanm
 *  com.google.android.gms.internal.ads.zzaoc
 *  com.google.android.gms.internal.ads.zzaod
 *  com.google.android.gms.internal.ads.zzaoe
 *  com.google.android.gms.internal.ads.zzaof
 *  com.google.android.gms.internal.ads.zzaog
 *  com.google.android.gms.internal.ads.zzaoh
 *  com.google.android.gms.internal.ads.zzaoj
 *  com.google.android.gms.internal.ads.zzapf
 */
package com.google.android.gms.internal.ads;

import android.os.Handler;
import com.google.android.gms.internal.ads.zzanm;
import com.google.android.gms.internal.ads.zzaoc;
import com.google.android.gms.internal.ads.zzaod;
import com.google.android.gms.internal.ads.zzaoe;
import com.google.android.gms.internal.ads.zzaof;
import com.google.android.gms.internal.ads.zzaog;
import com.google.android.gms.internal.ads.zzaoh;
import com.google.android.gms.internal.ads.zzaoj;
import com.google.android.gms.internal.ads.zzapf;

public final class zzaoi {
    private final Handler zza;
    private final zzaoj zzb;

    public zzaoi(Handler handler, zzaoj zzaoj2) {
        if (handler == null) throw null;
        this.zza = handler;
        this.zzb = zzaoj2;
    }

    static /* synthetic */ zzaoj zza(zzaoi zzaoi2) {
        return zzaoi2.zzb;
    }

    public final void zzb(zzapf zzapf2) {
        this.zza.post((Runnable)new zzaoc(this, zzapf2));
    }

    public final void zzc(String string, long l, long l2) {
        this.zza.post((Runnable)new zzaod(this, string, l, l2));
    }

    public final void zzd(zzanm zzanm2) {
        this.zza.post((Runnable)new zzaoe(this, zzanm2));
    }

    public final void zze(int n, long l, long l2) {
        this.zza.post((Runnable)new zzaof(this, n, l, l2));
    }

    public final void zzf(zzapf zzapf2) {
        this.zza.post((Runnable)new zzaog(this, zzapf2));
    }

    public final void zzg(int n) {
        this.zza.post((Runnable)new zzaoh(this, n));
    }
}
