/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.google.android.gms.ads.internal.overlay.zzo
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.common.util.Clock
 *  com.google.android.gms.internal.ads.zzawc
 *  com.google.android.gms.internal.ads.zzawd
 *  com.google.android.gms.internal.ads.zzbty
 *  com.google.android.gms.internal.ads.zzbtz
 *  com.google.android.gms.internal.ads.zzbud
 *  com.google.android.gms.internal.ads.zzbup
 *  com.google.android.gms.internal.ads.zzbus
 *  com.google.android.gms.internal.ads.zzchj
 *  com.google.android.gms.internal.ads.zzcml
 *  com.google.android.gms.internal.ads.zzctl
 *  com.google.android.gms.internal.ads.zzctm
 *  com.google.android.gms.internal.ads.zzcto
 *  com.google.android.gms.internal.ads.zzctp
 *  com.google.android.gms.internal.ads.zzdbw
 *  com.google.android.gms.internal.ads.zzdbx
 *  com.google.android.gms.internal.ads.zzfsm
 *  org.json.JSONObject
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.overlay.zzo;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.ads.zzawc;
import com.google.android.gms.internal.ads.zzawd;
import com.google.android.gms.internal.ads.zzbty;
import com.google.android.gms.internal.ads.zzbtz;
import com.google.android.gms.internal.ads.zzbud;
import com.google.android.gms.internal.ads.zzbup;
import com.google.android.gms.internal.ads.zzbus;
import com.google.android.gms.internal.ads.zzchj;
import com.google.android.gms.internal.ads.zzcml;
import com.google.android.gms.internal.ads.zzctl;
import com.google.android.gms.internal.ads.zzctm;
import com.google.android.gms.internal.ads.zzcto;
import com.google.android.gms.internal.ads.zzctp;
import com.google.android.gms.internal.ads.zzdbw;
import com.google.android.gms.internal.ads.zzdbx;
import com.google.android.gms.internal.ads.zzfsm;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public final class zzctq
implements zzawd,
zzdbx,
zzo,
zzdbw {
    private final zzctl zza;
    private final zzctm zzb;
    private final Set<zzcml> zzc = new HashSet<zzcml>();
    private final zzbus<JSONObject, JSONObject> zzd;
    private final Executor zze;
    private final Clock zzf;
    private final AtomicBoolean zzg = new AtomicBoolean(false);
    private final zzctp zzh = new zzctp();
    private boolean zzi = false;
    private WeakReference<?> zzj = new WeakReference<zzctq>(this);

    public zzctq(zzbup zzbup2, zzctm zzctm2, Executor executor, zzctl zzctl2, Clock clock) {
        this.zza = zzctl2;
        this.zzd = zzbup2.zza("google.afma.activeView.handleUpdate", (zzbtz)zzbud.zza, (zzbty)zzbud.zza);
        this.zzb = zzctm2;
        this.zze = executor;
        this.zzf = clock;
    }

    private final void zzl() {
        Iterator<zzcml> iterator = this.zzc.iterator();
        while (true) {
            if (!iterator.hasNext()) {
                this.zza.zzf();
                return;
            }
            zzcml zzcml2 = iterator.next();
            this.zza.zze(zzcml2);
        }
    }

    public final void zza(Context context) {
        synchronized (this) {
            this.zzh.zzb = true;
            this.zzh();
            return;
        }
    }

    public final void zzb(Context context) {
        synchronized (this) {
            this.zzh.zzb = false;
            this.zzh();
            return;
        }
    }

    public final void zzbo(Context context) {
        synchronized (this) {
            this.zzh.zze = "u";
            this.zzh();
            this.zzl();
            this.zzi = true;
            return;
        }
    }

    public final void zzbp() {
    }

    public final void zzbq() {
        synchronized (this) {
            this.zzh.zzb = true;
            this.zzh();
            return;
        }
    }

    public final void zzbr() {
        synchronized (this) {
            this.zzh.zzb = false;
            this.zzh();
            return;
        }
    }

    public final void zzbs(int n) {
    }

    public final void zzc(zzawc zzawc2) {
        synchronized (this) {
            zzctp zzctp2 = this.zzh;
            zzctp2.zza = zzawc2.zzj;
            zzctp2.zzf = zzawc2;
            this.zzh();
            return;
        }
    }

    public final void zzd() {
    }

    public final void zze() {
    }

    public final void zzg() {
        synchronized (this) {
            if (!this.zzg.compareAndSet(false, true)) return;
            this.zza.zzc(this);
            this.zzh();
            return;
        }
    }

    public final void zzh() {
        synchronized (this) {
            try {
                if (this.zzj.get() == null) {
                    this.zzi();
                    return;
                }
                if (this.zzi) return;
                boolean bl = this.zzg.get();
                if (!bl) return;
                try {
                    this.zzh.zzd = this.zzf.elapsedRealtime();
                    JSONObject jSONObject = this.zzb.zza(this.zzh);
                    Iterator<zzcml> iterator = this.zzc.iterator();
                    while (true) {
                        if (!iterator.hasNext()) {
                            zzchj.zzb((zzfsm)this.zzd.zzb((Object)jSONObject), (String)"ActiveViewListener.callActiveViewJs");
                            return;
                        }
                        zzcml zzcml2 = iterator.next();
                        Executor executor = this.zze;
                        zzcto zzcto2 = new zzcto(zzcml2, jSONObject);
                        executor.execute((Runnable)zzcto2);
                    }
                }
                catch (Exception exception) {
                    com.google.android.gms.ads.internal.util.zze.zzb((String)"Failed to call ActiveViewJS", (Throwable)exception);
                    return;
                }
            }
            catch (Throwable throwable) {
                throw throwable;
            }
        }
    }

    public final void zzi() {
        synchronized (this) {
            this.zzl();
            this.zzi = true;
            return;
        }
    }

    public final void zzj(zzcml zzcml2) {
        synchronized (this) {
            this.zzc.add(zzcml2);
            this.zza.zzd(zzcml2);
            return;
        }
    }

    public final void zzk(Object object) {
        this.zzj = new WeakReference<Object>(object);
    }
}
