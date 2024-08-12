/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzvo
 *  com.google.android.gms.internal.ads.zzvt
 *  com.google.android.gms.internal.ads.zzwb
 *  com.google.android.gms.internal.ads.zzwc
 *  com.google.android.gms.internal.ads.zzwi
 *  com.google.android.gms.internal.ads.zzwo
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzvo;
import com.google.android.gms.internal.ads.zzvt;
import com.google.android.gms.internal.ads.zzwb;
import com.google.android.gms.internal.ads.zzwc;
import com.google.android.gms.internal.ads.zzwi;
import com.google.android.gms.internal.ads.zzwo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;

final class zzwp
implements zzwb {
    private final Map<String, List<zzwc<?>>> zza = new HashMap();
    private final zzvo zzb;
    private final BlockingQueue<zzwc<?>> zzc;
    private final zzvt zzd;

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    zzwp(zzvo zzvo2, BlockingQueue blockingQueue, zzvt zzvt2, byte[] byArray) {
        this.zzd = zzvt2;
        this.zzb = zzvo2;
        this.zzc = blockingQueue;
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public final void zza(zzwc<?> zzwc2, zzwi<?> zzwi2) {
        Object object = zzwi2.zzb;
        if (object != null && !object.zza(System.currentTimeMillis())) {
            zzwc2 = zzwc2.zzj();
            synchronized (this) {
                object = this.zza.remove(zzwc2);
            }
            if (object == null) return;
            if (zzwo.zzb) {
                zzwo.zza((String)"Releasing %d waiting requests for cacheKey=%s.", (Object[])new Object[]{object.size(), zzwc2});
            }
            object = object.iterator();
            while (object.hasNext()) {
                zzwc2 = (zzwc)object.next();
                this.zzd.zza(zzwc2, zzwi2, null);
            }
            return;
        }
        this.zzb(zzwc2);
    }

    public final void zzb(zzwc<?> object) {
        synchronized (this) {
            object = object.zzj();
            List<zzwc<?>> list = this.zza.remove(object);
            if (list == null) return;
            if (list.isEmpty()) return;
            if (zzwo.zzb) {
                zzwo.zza((String)"%d waiting requests for cacheKey=%s; resend to network", (Object[])new Object[]{list.size(), object});
            }
            zzwc<?> zzwc2 = list.remove(0);
            this.zza.put((String)object, list);
            zzwc2.zzv((zzwb)this);
            try {
                this.zzc.put(zzwc2);
                return;
            }
            catch (InterruptedException interruptedException) {
                zzwo.zzc((String)"Couldn't add request to queue. %s", (Object[])new Object[]{interruptedException.toString()});
                Thread.currentThread().interrupt();
                this.zzb.zzb();
                return;
            }
        }
    }

    final boolean zzc(zzwc<?> zzwc2) {
        synchronized (this) {
            ArrayList arrayList;
            String string = zzwc2.zzj();
            if (!this.zza.containsKey(string)) {
                this.zza.put(string, null);
                zzwc2.zzv((zzwb)this);
                if (!zzwo.zzb) return false;
                zzwo.zzb((String)"new request, sending to network %s", (Object[])new Object[]{string});
                return false;
            }
            ArrayList arrayList2 = arrayList = this.zza.get(string);
            if (arrayList == null) {
                arrayList2 = new ArrayList();
            }
            zzwc2.zzd("waiting-for-response");
            arrayList2.add(zzwc2);
            this.zza.put(string, arrayList2);
            if (!zzwo.zzb) return true;
            zzwo.zzb((String)"Request for cacheKey=%s is in flight, putting on hold.", (Object[])new Object[]{string});
            return true;
        }
    }
}
