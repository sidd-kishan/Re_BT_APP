/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  com.google.android.gms.internal.ads.zzaiq
 *  com.google.android.gms.internal.ads.zzakt
 *  com.google.android.gms.internal.ads.zzamq
 *  com.google.android.gms.internal.ads.zzay
 *  com.google.android.gms.internal.ads.zzfb
 *  com.google.android.gms.internal.ads.zzgi
 *  com.google.android.gms.internal.ads.zzgn
 *  com.google.android.gms.internal.ads.zzgo
 *  com.google.android.gms.internal.ads.zzgp
 *  com.google.android.gms.internal.ads.zzhf
 *  com.google.android.gms.internal.ads.zzhg
 *  com.google.android.gms.internal.ads.zzhh
 *  com.google.android.gms.internal.ads.zzhp
 */
package com.google.android.gms.internal.ads;

import android.os.Handler;
import com.google.android.gms.internal.ads.zzaiq;
import com.google.android.gms.internal.ads.zzakt;
import com.google.android.gms.internal.ads.zzamq;
import com.google.android.gms.internal.ads.zzay;
import com.google.android.gms.internal.ads.zzfb;
import com.google.android.gms.internal.ads.zzgi;
import com.google.android.gms.internal.ads.zzgn;
import com.google.android.gms.internal.ads.zzgo;
import com.google.android.gms.internal.ads.zzgp;
import com.google.android.gms.internal.ads.zzhf;
import com.google.android.gms.internal.ads.zzhg;
import com.google.android.gms.internal.ads.zzhh;
import com.google.android.gms.internal.ads.zzhp;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

public abstract class zzgq<T>
extends zzgi {
    private final HashMap<T, zzgp<T>> zza = new HashMap();
    private Handler zzb;
    private zzay zzc;

    protected zzgq() {
    }

    protected final void zzF() {
        Iterator<zzgp<T>> iterator = this.zza.values().iterator();
        while (iterator.hasNext()) {
            zzgp<T> zzgp2 = iterator.next();
            zzgp2.zza.zzp(zzgp2.zzb);
        }
    }

    protected void zza(zzay zzay2) {
        this.zzc = zzay2;
        this.zzb = zzamq.zzh(null);
    }

    protected final void zzc() {
        Iterator<zzgp<T>> iterator = this.zza.values().iterator();
        while (iterator.hasNext()) {
            zzgp<T> zzgp2 = iterator.next();
            zzgp2.zza.zzq(zzgp2.zzb);
        }
    }

    protected void zzd() {
        Iterator<zzgp<T>> iterator = this.zza.values().iterator();
        while (true) {
            if (!iterator.hasNext()) {
                this.zza.clear();
                return;
            }
            zzgp<T> zzgp2 = iterator.next();
            zzgp2.zza.zzr(zzgp2.zzb);
            zzgp2.zza.zzl((zzhp)zzgp2.zzc);
            zzgp2.zza.zzn((zzfb)zzgp2.zzc);
        }
    }

    public void zzu() throws IOException {
        Iterator<zzgp<T>> iterator = this.zza.values().iterator();
        while (iterator.hasNext()) {
            iterator.next().zza.zzu();
        }
    }

    protected abstract void zzv(T var1, zzhh var2, zzaiq var3);

    protected final void zzw(T object, zzhh zzhh2) {
        zzakt.zza((boolean)(this.zza.containsKey(object) ^ true));
        zzgn zzgn2 = new zzgn(this, object);
        zzgo zzgo2 = new zzgo(this, object);
        this.zza.put(object, new zzgp(zzhh2, (zzhg)zzgn2, zzgo2));
        object = this.zzb;
        if (object == null) throw null;
        zzhh2.zzk(object, (zzhp)zzgo2);
        object = this.zzb;
        if (object == null) throw null;
        zzhh2.zzm(object, (zzfb)zzgo2);
        zzhh2.zzo((zzhg)zzgn2, this.zzc);
        if (this.zzj()) return;
        zzhh2.zzq((zzhg)zzgn2);
    }

    protected zzhf zzx(T t, zzhf zzhf2) {
        throw null;
    }
}
