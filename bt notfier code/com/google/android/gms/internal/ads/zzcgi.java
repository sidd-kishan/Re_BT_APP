/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  com.google.android.gms.ads.internal.util.zzg
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.common.util.Clock
 *  com.google.android.gms.internal.ads.zzaww
 *  com.google.android.gms.internal.ads.zzbdg
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzcfy
 *  com.google.android.gms.internal.ads.zzcgf
 *  com.google.android.gms.internal.ads.zzcgg
 *  com.google.android.gms.internal.ads.zzcgh
 *  com.google.android.gms.internal.ads.zzfbr
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.internal.util.zzg;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.ads.zzaww;
import com.google.android.gms.internal.ads.zzbdg;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzcfy;
import com.google.android.gms.internal.ads.zzcgf;
import com.google.android.gms.internal.ads.zzcgg;
import com.google.android.gms.internal.ads.zzcgh;
import com.google.android.gms.internal.ads.zzfbr;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public final class zzcgi
implements zzaww {
    final zzcgf zza;
    final HashSet<zzcfy> zzb;
    final HashSet<zzcgh> zzc;
    private final Object zzd = new Object();
    private final zzg zze;
    private final zzcgg zzf;
    private boolean zzg = false;

    public zzcgi(String string, zzg zzg2) {
        this.zzb = new HashSet();
        this.zzc = new HashSet();
        this.zza = new zzcgf(string, zzg2);
        this.zze = zzg2;
        this.zzf = new zzcgg();
    }

    public final void zza(boolean bl) {
        long l = zzt.zzj().currentTimeMillis();
        if (!bl) {
            this.zze.zzq(l);
            this.zze.zzs(this.zza.zzd);
            return;
        }
        long l2 = this.zze.zzr();
        zzbjd zzbjd2 = zzbjl.zzaE;
        this.zza.zzd = l - l2 > (Long)zzbet.zzc().zzc(zzbjd2) ? -1 : this.zze.zzt();
        this.zzg = true;
    }

    public final void zzb(zzcfy zzcfy2) {
        Object object = this.zzd;
        synchronized (object) {
            this.zzb.add(zzcfy2);
            return;
        }
    }

    public final void zzc(HashSet<zzcfy> hashSet) {
        Object object = this.zzd;
        synchronized (object) {
            this.zzb.addAll(hashSet);
            return;
        }
    }

    public final void zzd() {
        Object object = this.zzd;
        synchronized (object) {
            this.zza.zza();
            return;
        }
    }

    public final void zze() {
        Object object = this.zzd;
        synchronized (object) {
            this.zza.zzb();
            return;
        }
    }

    public final void zzf(zzbdg zzbdg2, long l) {
        Object object = this.zzd;
        synchronized (object) {
            this.zza.zzc(zzbdg2, l);
            return;
        }
    }

    public final void zzg() {
        Object object = this.zzd;
        synchronized (object) {
            this.zza.zzd();
            return;
        }
    }

    public final void zzh() {
        Object object = this.zzd;
        synchronized (object) {
            this.zza.zze();
            return;
        }
    }

    public final zzcfy zzi(Clock clock, String string) {
        return new zzcfy(clock, this, this.zzf.zza(), string);
    }

    public final boolean zzj() {
        return this.zzg;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled unnecessary exception pruning
     */
    public final Bundle zzk(Context object, zzfbr zzfbr2) {
        HashSet<zzcfy> hashSet = new HashSet<zzcfy>();
        Object object2 = this.zzd;
        synchronized (object2) {
            hashSet.addAll(this.zzb);
            this.zzb.clear();
            {
                catch (Throwable throwable) {}
                {
                    throw throwable;
                }
            }
        }
        object2 = new Bundle();
        object2.putBundle("app", this.zza.zzf((Context)object, this.zzf.zzb()));
        object = new Bundle();
        Iterator<Object> iterator = this.zzc.iterator();
        if (iterator.hasNext()) {
            object = iterator.next();
            throw null;
        }
        object2.putBundle("slots", (Bundle)object);
        object = new ArrayList();
        iterator = hashSet.iterator();
        while (true) {
            if (!iterator.hasNext()) {
                object2.putParcelableArrayList("ads", (ArrayList)object);
                zzfbr2.zzb(hashSet);
                return object2;
            }
            ((ArrayList)object).add(((zzcfy)iterator.next()).zzj());
        }
    }
}
