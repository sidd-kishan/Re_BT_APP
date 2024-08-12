/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  com.google.android.gms.internal.ads.zzke
 *  com.google.android.gms.internal.ads.zzkf
 *  com.google.android.gms.internal.ads.zzkh
 */
package com.google.android.gms.internal.ads;

import android.os.Handler;
import com.google.android.gms.internal.ads.zzke;
import com.google.android.gms.internal.ads.zzkf;
import com.google.android.gms.internal.ads.zzkh;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public final class zzkg {
    private final CopyOnWriteArrayList<zzkf> zza = new CopyOnWriteArrayList();

    public final void zza(Handler handler, zzkh zzkh2) {
        this.zzb(zzkh2);
        this.zza.add(new zzkf(handler, zzkh2));
    }

    public final void zzb(zzkh zzkh2) {
        Iterator<zzkf> iterator = this.zza.iterator();
        while (iterator.hasNext()) {
            zzkf zzkf2 = iterator.next();
            if (zzkf.zzb((zzkf)zzkf2) != zzkh2) continue;
            zzkf2.zzd();
            this.zza.remove(zzkf2);
        }
    }

    public final void zzc(int n, long l, long l2) {
        Iterator<zzkf> iterator = this.zza.iterator();
        while (iterator.hasNext()) {
            zzkf zzkf2 = iterator.next();
            if (zzkf.zzc((zzkf)zzkf2)) continue;
            zzkf.zza((zzkf)zzkf2).post((Runnable)new zzke(zzkf2, n, l, l2));
        }
    }
}
