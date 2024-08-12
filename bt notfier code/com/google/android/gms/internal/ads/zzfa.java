/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  com.google.android.gms.internal.ads.zzez
 *  com.google.android.gms.internal.ads.zzfb
 *  com.google.android.gms.internal.ads.zzhf
 */
package com.google.android.gms.internal.ads;

import android.os.Handler;
import com.google.android.gms.internal.ads.zzez;
import com.google.android.gms.internal.ads.zzfb;
import com.google.android.gms.internal.ads.zzhf;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public final class zzfa {
    public final int zza;
    public final zzhf zzb;
    private final CopyOnWriteArrayList<zzez> zzc;

    public zzfa() {
        this(new CopyOnWriteArrayList<zzez>(), 0, null);
    }

    private zzfa(CopyOnWriteArrayList<zzez> copyOnWriteArrayList, int n, zzhf zzhf2) {
        this.zzc = copyOnWriteArrayList;
        this.zza = n;
        this.zzb = zzhf2;
    }

    public final zzfa zza(int n, zzhf zzhf2) {
        return new zzfa(this.zzc, n, zzhf2);
    }

    public final void zzb(Handler handler, zzfb zzfb2) {
        this.zzc.add(new zzez(handler, zzfb2));
    }

    public final void zzc(zzfb zzfb2) {
        Iterator<zzez> iterator = this.zzc.iterator();
        while (iterator.hasNext()) {
            zzez zzez2 = iterator.next();
            if (zzez2.zzb != zzfb2) continue;
            this.zzc.remove(zzez2);
        }
    }
}
