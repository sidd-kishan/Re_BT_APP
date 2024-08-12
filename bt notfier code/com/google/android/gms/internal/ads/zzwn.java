/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.SystemClock
 *  com.google.android.gms.internal.ads.zzwm
 *  com.google.android.gms.internal.ads.zzwo
 */
package com.google.android.gms.internal.ads;

import android.os.SystemClock;
import com.google.android.gms.internal.ads.zzwm;
import com.google.android.gms.internal.ads.zzwo;
import java.util.ArrayList;
import java.util.List;

final class zzwn {
    public static final boolean zza = zzwo.zzb;
    private final List<zzwm> zzb = new ArrayList<zzwm>();
    private boolean zzc = false;

    zzwn() {
    }

    protected final void finalize() throws Throwable {
        if (this.zzc) return;
        this.zzb("Request on the loose");
        zzwo.zzc((String)"Marker log finalized without finish() - uncaught exit point for request", (Object[])new Object[0]);
    }

    public final void zza(String object, long l) {
        synchronized (this) {
            if (!this.zzc) {
                List<zzwm> list = this.zzb;
                zzwm zzwm2 = new zzwm((String)object, l, SystemClock.elapsedRealtime());
                list.add(zzwm2);
                return;
            }
            object = new IllegalStateException("Marker added to finished log");
            throw object;
        }
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public final void zzb(String string) {
        synchronized (this) {
            long l;
            Object object;
            long l2;
            this.zzc = true;
            if (this.zzb.size() == 0) {
                l2 = 0L;
            } else {
                l2 = this.zzb.get((int)0).zzc;
                object = this.zzb;
                l = object.get((int)(object.size() - 1)).zzc;
                l2 = l - l2;
            }
            if (l2 <= 0L) {
                return;
            }
            l = this.zzb.get((int)0).zzc;
            zzwo.zzb((String)"(%-4d ms) %s", (Object[])new Object[]{l2, string});
            object = this.zzb.iterator();
            l2 = l;
            while (object.hasNext()) {
                string = (zzwm)object.next();
                l = ((zzwm)string).zzc;
                zzwo.zzb((String)"(+%-4d) [%2d] %s", (Object[])new Object[]{l - l2, ((zzwm)string).zzb, ((zzwm)string).zza});
                l2 = l;
            }
            return;
        }
    }
}
