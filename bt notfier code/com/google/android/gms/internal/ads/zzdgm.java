/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzdgk
 *  com.google.android.gms.internal.ads.zzdgl
 *  com.google.android.gms.internal.ads.zzdih
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdgk;
import com.google.android.gms.internal.ads.zzdgl;
import com.google.android.gms.internal.ads.zzdih;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;

public class zzdgm<ListenerT> {
    protected final Map<ListenerT, Executor> zza = new HashMap<ListenerT, Executor>();

    protected zzdgm(Set<zzdih<ListenerT>> set) {
        this.zzj(set);
    }

    public final void zzh(zzdih<ListenerT> zzdih2) {
        synchronized (this) {
            this.zzi(zzdih2.zza, zzdih2.zzb);
            return;
        }
    }

    public final void zzi(ListenerT ListenerT, Executor executor) {
        synchronized (this) {
            this.zza.put(ListenerT, executor);
            return;
        }
    }

    public final void zzj(Set<zzdih<ListenerT>> object) {
        synchronized (this) {
            try {
                object = object.iterator();
                while (object.hasNext()) {
                    this.zzh((zzdih)object.next());
                }
                return;
            }
            catch (Throwable throwable) {
                throw throwable;
            }
        }
    }

    protected final void zzk(zzdgl<ListenerT> zzdgl2) {
        synchronized (this) {
            try {
                Iterator<Map.Entry<ListenerT, Executor>> iterator = this.zza.entrySet().iterator();
                while (iterator.hasNext()) {
                    Object object = iterator.next();
                    ListenerT ListenerT = object.getKey();
                    object = object.getValue();
                    zzdgk zzdgk2 = new zzdgk(zzdgl2, ListenerT);
                    object.execute((Runnable)zzdgk2);
                }
                return;
            }
            catch (Throwable throwable) {
                throw throwable;
            }
        }
    }
}
