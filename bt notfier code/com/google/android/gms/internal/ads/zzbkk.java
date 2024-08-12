/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.MotionEvent
 *  com.google.android.gms.internal.ads.zzbkm
 *  com.google.android.gms.internal.ads.zzbkx
 *  com.google.android.gms.internal.ads.zzfru
 *  com.google.android.gms.internal.ads.zzfsd
 *  com.google.android.gms.internal.ads.zzfsm
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.MotionEvent;
import com.google.android.gms.internal.ads.zzbkm;
import com.google.android.gms.internal.ads.zzbkx;
import com.google.android.gms.internal.ads.zzfru;
import com.google.android.gms.internal.ads.zzfsd;
import com.google.android.gms.internal.ads.zzfsm;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public final class zzbkk {
    private MotionEvent zza = MotionEvent.obtain((long)0L, (long)0L, (int)1, (float)0.0f, (float)0.0f, (int)0);
    private MotionEvent zzb = MotionEvent.obtain((long)0L, (long)0L, (int)0, (float)0.0f, (float)0.0f, (int)0);
    private final Context zzc;
    private final ScheduledExecutorService zzd;
    private final zzbkm zze;

    public zzbkk(Context context, ScheduledExecutorService scheduledExecutorService, zzbkm zzbkm2, byte[] byArray) {
        this.zzc = context;
        this.zzd = scheduledExecutorService;
        this.zze = zzbkm2;
    }

    public final void zza(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1 && motionEvent.getEventTime() > this.zza.getEventTime()) {
            this.zza = MotionEvent.obtain((MotionEvent)motionEvent);
            return;
        }
        if (motionEvent.getAction() != 0) return;
        if (motionEvent.getEventTime() <= this.zzb.getEventTime()) return;
        this.zzb = MotionEvent.obtain((MotionEvent)motionEvent);
    }

    public final zzfsm<String> zzb() {
        return (zzfru)zzfsd.zzh((zzfsm)zzfru.zzw((zzfsm)zzfsd.zza(null)), (long)((Long)zzbkx.zzc.zze()), (TimeUnit)TimeUnit.MILLISECONDS, (ScheduledExecutorService)this.zzd);
    }
}
