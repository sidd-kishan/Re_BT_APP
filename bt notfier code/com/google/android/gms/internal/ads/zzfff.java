/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzffb
 *  com.google.android.gms.internal.ads.zzffc
 *  com.google.android.gms.internal.ads.zzffe
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzffb;
import com.google.android.gms.internal.ads.zzffc;
import com.google.android.gms.internal.ads.zzffe;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

final class zzfff
implements zzffc {
    private final zzffc zza;
    private final Queue<zzffb> zzb;
    private final int zzc;
    private final AtomicBoolean zzd;

    public zzfff(zzffc zzffc2, ScheduledExecutorService scheduledExecutorService) {
        this.zza = zzffc2;
        this.zzb = new LinkedBlockingQueue<zzffb>();
        zzffc2 = zzbjl.zzgl;
        this.zzc = (Integer)zzbet.zzc().zzc((zzbjd)zzffc2);
        this.zzd = new AtomicBoolean(false);
        zzffc2 = zzbjl.zzgk;
        int n = (Integer)zzbet.zzc().zzc((zzbjd)zzffc2);
        zzffc2 = new zzffe(this);
        long l = n;
        scheduledExecutorService.scheduleAtFixedRate((Runnable)zzffc2, l, l, TimeUnit.MILLISECONDS);
    }

    public final void zza(zzffb object) {
        if (this.zzb.size() < this.zzc) {
            this.zzb.offer((zzffb)object);
            return;
        }
        if (this.zzd.getAndSet(true)) return;
        Queue<zzffb> queue = this.zzb;
        zzffb zzffb2 = zzffb.zza((String)"dropped_event");
        if ((object = object.zzj()).containsKey("action")) {
            zzffb2.zzc("dropped_action", (String)object.get("action"));
        }
        queue.offer(zzffb2);
    }

    public final String zzb(zzffb zzffb2) {
        return this.zza.zzb(zzffb2);
    }
}
