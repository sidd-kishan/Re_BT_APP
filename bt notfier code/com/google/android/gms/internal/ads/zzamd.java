/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.IntentFilter
 *  android.os.Handler
 *  android.os.Looper
 *  com.google.android.gms.internal.ads.zzalx
 *  com.google.android.gms.internal.ads.zzalz
 *  com.google.android.gms.internal.ads.zzamb
 */
package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.internal.ads.zzalx;
import com.google.android.gms.internal.ads.zzalz;
import com.google.android.gms.internal.ads.zzamb;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public final class zzamd {
    private static zzamd zza;
    private final Handler zzb = new Handler(Looper.getMainLooper());
    private final CopyOnWriteArrayList<WeakReference<zzalz>> zzc = new CopyOnWriteArrayList();
    private final Object zzd = new Object();
    private int zze = 0;

    private zzamd(Context context) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        context.registerReceiver((BroadcastReceiver)new zzamb(this, null), intentFilter);
    }

    public static zzamd zza(Context object) {
        synchronized (zzamd.class) {
            if (zza == null) {
                zzamd zzamd2;
                zza = zzamd2 = new zzamd((Context)object);
            }
            object = zza;
            return object;
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled unnecessary exception pruning
     */
    static /* synthetic */ void zzd(zzamd zzamd2, int n) {
        Iterator<WeakReference<zzalz>> iterator = zzamd2.zzd;
        synchronized (iterator) {
            if (zzamd2.zze == n) {
                return;
            }
            zzamd2.zze = n;
            // MONITOREXIT @DISABLED, blocks:[0, 2] lbl8 : MonitorExitStatement: MONITOREXIT : var2_3
            iterator = zzamd2.zzc.iterator();
            {
                catch (Throwable throwable) {}
                {
                    throw throwable;
                }
            }
        }
        while (iterator.hasNext()) {
            WeakReference<zzalz> weakReference = iterator.next();
            zzalz zzalz2 = (zzalz)weakReference.get();
            if (zzalz2 != null) {
                zzalz2.zza(n);
                continue;
            }
            zzamd2.zzc.remove(weakReference);
        }
    }

    public final void zzb(zzalz zzalz2) {
        Iterator<WeakReference<zzalz>> iterator = this.zzc.iterator();
        while (true) {
            if (!iterator.hasNext()) {
                this.zzc.add(new WeakReference<zzalz>(zzalz2));
                this.zzb.post((Runnable)new zzalx(this, zzalz2));
                return;
            }
            WeakReference<zzalz> weakReference = iterator.next();
            if (weakReference.get() != null) continue;
            this.zzc.remove(weakReference);
        }
    }

    public final int zzc() {
        Object object = this.zzd;
        synchronized (object) {
            int n = this.zze;
            return n;
        }
    }
}
