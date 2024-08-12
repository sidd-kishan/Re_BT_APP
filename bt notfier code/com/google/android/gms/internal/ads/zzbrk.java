/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Binder
 *  android.os.ParcelFileDescriptor
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.common.internal.BaseGmsClient$BaseConnectionCallbacks
 *  com.google.android.gms.common.internal.BaseGmsClient$BaseOnConnectionFailedListener
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzbqx
 *  com.google.android.gms.internal.ads.zzbqy
 *  com.google.android.gms.internal.ads.zzbra
 *  com.google.android.gms.internal.ads.zzbrg
 *  com.google.android.gms.internal.ads.zzbrh
 *  com.google.android.gms.internal.ads.zzbri
 *  com.google.android.gms.internal.ads.zzbrj
 *  com.google.android.gms.internal.ads.zzcbh
 *  com.google.android.gms.internal.ads.zzchg
 *  com.google.android.gms.internal.ads.zzchl
 *  com.google.android.gms.internal.ads.zzfrk
 *  com.google.android.gms.internal.ads.zzfsd
 *  com.google.android.gms.internal.ads.zzfsm
 *  com.google.android.gms.internal.ads.zzvv
 *  com.google.android.gms.internal.ads.zzvy
 *  com.google.android.gms.internal.ads.zzwc
 *  com.google.android.gms.internal.ads.zzwl
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import android.os.ParcelFileDescriptor;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzbqx;
import com.google.android.gms.internal.ads.zzbqy;
import com.google.android.gms.internal.ads.zzbra;
import com.google.android.gms.internal.ads.zzbrg;
import com.google.android.gms.internal.ads.zzbrh;
import com.google.android.gms.internal.ads.zzbri;
import com.google.android.gms.internal.ads.zzbrj;
import com.google.android.gms.internal.ads.zzcbh;
import com.google.android.gms.internal.ads.zzchg;
import com.google.android.gms.internal.ads.zzchl;
import com.google.android.gms.internal.ads.zzfrk;
import com.google.android.gms.internal.ads.zzfsd;
import com.google.android.gms.internal.ads.zzfsm;
import com.google.android.gms.internal.ads.zzvv;
import com.google.android.gms.internal.ads.zzvy;
import com.google.android.gms.internal.ads.zzwc;
import com.google.android.gms.internal.ads.zzwl;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public final class zzbrk
implements zzvv {
    private volatile zzbqx zza;
    private final Context zzb;

    public zzbrk(Context context) {
        this.zzb = context;
    }

    static /* synthetic */ zzbqx zzb(zzbrk zzbrk2) {
        return zzbrk2.zza;
    }

    static /* synthetic */ void zzc(zzbrk zzbrk2) {
        if (zzbrk2.zza == null) {
            return;
        }
        zzbrk2.zza.disconnect();
        Binder.flushPendingCommands();
    }

    public final zzvy zza(zzwc<?> object) throws zzwl {
        Object object2 = zzbqy.CREATOR;
        Object object3 = object.zzn();
        int n = object3.size();
        object2 = new String[n];
        Object object4 = new String[n];
        zzbrj zzbrj2 = object3.entrySet().iterator();
        int n2 = 0;
        n = 0;
        while (zzbrj2.hasNext()) {
            object3 = zzbrj2.next();
            object2[n] = (String)object3.getKey();
            object4[n] = (String)object3.getValue();
            ++n;
        }
        object2 = new zzbqy(object.zzi(), (String[])object2, (String[])object4);
        long l = zzt.zzj().elapsedRealtime();
        object = null;
        try {
            zzbqx zzbqx2;
            object4 = new zzchl();
            object3 = new zzbri(this, (zzchl)object4);
            zzbrj2 = new zzbrj(this, (zzchl)object4);
            this.zza = zzbqx2 = new zzbqx(this.zzb, zzt.zzq().zza(), (BaseGmsClient.BaseConnectionCallbacks)object3, (BaseGmsClient.BaseOnConnectionFailedListener)zzbrj2);
            this.zza.checkAvailabilityAndConnect();
            object3 = new zzbrg(this, (zzbqy)object2);
            object4 = zzfsd.zzi((zzfsm)object4, (zzfrk)object3, (Executor)zzchg.zza);
            object2 = zzbjl.zzcS;
            object4 = zzfsd.zzh((zzfsm)object4, (long)((Integer)zzbet.zzc().zzc((zzbjd)object2)).intValue(), (TimeUnit)TimeUnit.MILLISECONDS, (ScheduledExecutorService)zzchg.zzd);
            object2 = new zzbrh(this);
            object4.zze((Runnable)object2, (Executor)zzchg.zza);
            object4 = (ParcelFileDescriptor)object4.get();
            object2 = (zzbra)new zzcbh((ParcelFileDescriptor)object4).zza(zzbra.CREATOR);
            if (object2 == null) {
                return null;
            }
            if (((zzbra)object2).zza) throw new zzwl(((zzbra)object2).zzb);
        }
        catch (InterruptedException | ExecutionException exception) {
            return null;
        }
        if (((zzbra)object2).zze.length != ((zzbra)object2).zzf.length) return object;
        object4 = new HashMap();
        for (n = n2; n < ((Object)(object = ((zzbra)object2).zze)).length; ++n) {
            ((HashMap)object4).put(object[n], ((zzbra)object2).zzf[n]);
        }
        object = new zzvy(((zzbra)object2).zzc, ((zzbra)object2).zzd, (Map)object4, ((zzbra)object2).zzg, ((zzbra)object2).zzh);
        return object;
        finally {
            long l2 = zzt.zzj().elapsedRealtime();
            object2 = new StringBuilder(52);
            ((StringBuilder)object2).append("Http assets remote cache took ");
            ((StringBuilder)object2).append(l2 - l);
            ((StringBuilder)object2).append("ms");
            zze.zza((String)((StringBuilder)object2).toString());
        }
    }
}
