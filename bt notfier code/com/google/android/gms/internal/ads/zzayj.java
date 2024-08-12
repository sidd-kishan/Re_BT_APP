/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Binder
 *  android.os.RemoteException
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.ads.internal.util.zzs
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.common.internal.BaseGmsClient$BaseConnectionCallbacks
 *  com.google.android.gms.common.internal.BaseGmsClient$BaseOnConnectionFailedListener
 *  com.google.android.gms.internal.ads.zzaww
 *  com.google.android.gms.internal.ads.zzayf
 *  com.google.android.gms.internal.ads.zzayg
 *  com.google.android.gms.internal.ads.zzayh
 *  com.google.android.gms.internal.ads.zzayi
 *  com.google.android.gms.internal.ads.zzayk
 *  com.google.android.gms.internal.ads.zzaym
 *  com.google.android.gms.internal.ads.zzayn
 *  com.google.android.gms.internal.ads.zzayp
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzfla
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.internal.ads.zzaww;
import com.google.android.gms.internal.ads.zzayf;
import com.google.android.gms.internal.ads.zzayg;
import com.google.android.gms.internal.ads.zzayh;
import com.google.android.gms.internal.ads.zzayi;
import com.google.android.gms.internal.ads.zzayk;
import com.google.android.gms.internal.ads.zzaym;
import com.google.android.gms.internal.ads.zzayn;
import com.google.android.gms.internal.ads.zzayp;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzfla;

public final class zzayj {
    private final Runnable zza = new zzayf(this);
    private final Object zzb = new Object();
    private zzaym zzc;
    private Context zzd;
    private zzayp zze;

    static /* synthetic */ Object zza(zzayj zzayj2) {
        return zzayj2.zzb;
    }

    static /* synthetic */ zzaym zzb(zzayj zzayj2) {
        return zzayj2.zzc;
    }

    static /* synthetic */ zzaym zzc(zzayj zzayj2, zzaym zzaym2) {
        zzayj2.zzc = null;
        return null;
    }

    static /* synthetic */ void zzh(zzayj zzayj2) {
        zzayj2.zzl();
    }

    static /* synthetic */ void zzj(zzayj zzayj2) {
        Object object = zzayj2.zzb;
        synchronized (object) {
            zzaym zzaym2 = zzayj2.zzc;
            if (zzaym2 == null) {
                return;
            }
            if (zzaym2.isConnected() || zzayj2.zzc.isConnecting()) {
                zzayj2.zzc.disconnect();
            }
            zzayj2.zzc = null;
            zzayj2.zze = null;
            Binder.flushPendingCommands();
            return;
        }
    }

    static /* synthetic */ zzayp zzk(zzayj zzayj2, zzayp zzayp2) {
        zzayj2.zze = zzayp2;
        return zzayp2;
    }

    private final void zzl() {
        Object object = this.zzb;
        synchronized (object) {
            if (this.zzd == null) return;
            if (this.zzc != null) {
                return;
            }
            zzayh zzayh2 = new zzayh(this);
            zzayi zzayi2 = new zzayi(this);
            zzayi2 = this.zzi((BaseGmsClient.BaseConnectionCallbacks)zzayh2, (BaseGmsClient.BaseOnConnectionFailedListener)zzayi2);
            this.zzc = zzayi2;
            zzayi2.checkAvailabilityAndConnect();
            return;
        }
    }

    public final void zzd(Context context) {
        if (context == null) {
            return;
        }
        Object object = this.zzb;
        synchronized (object) {
            if (this.zzd != null) {
                return;
            }
            this.zzd = context.getApplicationContext();
            context = zzbjl.zzcE;
            if (((Boolean)zzbet.zzc().zzc((zzbjd)context)).booleanValue()) {
                this.zzl();
            } else {
                context = zzbjl.zzcD;
                if ((Boolean)zzbet.zzc().zzc((zzbjd)context) == false) return;
                context = new zzayg(this);
                zzt.zzf().zzb((zzaww)context);
            }
            return;
        }
    }

    public final void zze() {
        Object object = zzbjl.zzcF;
        if ((Boolean)zzbet.zzc().zzc(object) == false) return;
        object = this.zzb;
        synchronized (object) {
            this.zzl();
            zzs.zza.removeCallbacks(this.zza);
            zzfla zzfla2 = zzs.zza;
            Runnable runnable = this.zza;
            zzbjd zzbjd2 = zzbjl.zzcG;
            zzfla2.postDelayed(runnable, ((Long)zzbet.zzc().zzc(zzbjd2)).longValue());
            return;
        }
    }

    public final zzayk zzf(zzayn zzayn2) {
        Object object = this.zzb;
        synchronized (object) {
            if (this.zze == null) {
                zzayn2 = new zzayk();
                return zzayn2;
            }
            try {
                if (this.zzc.zzp()) {
                    zzayn2 = this.zze.zzf(zzayn2);
                    return zzayn2;
                }
                zzayn2 = this.zze.zze(zzayn2);
                return zzayn2;
            }
            catch (RemoteException remoteException) {
                com.google.android.gms.ads.internal.util.zze.zzg((String)"Unable to call into cache service.", (Throwable)remoteException);
                zzayk zzayk2 = new zzayk();
                return zzayk2;
            }
        }
    }

    public final long zzg(zzayn zzayn2) {
        Object object = this.zzb;
        synchronized (object) {
            if (this.zze == null) {
                return -2L;
            }
            boolean bl = this.zzc.zzp();
            if (!bl) return -2L;
            try {
                long l = this.zze.zzg(zzayn2);
                return l;
            }
            catch (RemoteException remoteException) {
                com.google.android.gms.ads.internal.util.zze.zzg((String)"Unable to call into cache service.", (Throwable)remoteException);
            }
            return -2L;
        }
    }

    protected final zzaym zzi(BaseGmsClient.BaseConnectionCallbacks baseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener baseOnConnectionFailedListener) {
        synchronized (this) {
            baseConnectionCallbacks = new zzaym(this.zzd, zzt.zzq().zza(), baseConnectionCallbacks, baseOnConnectionFailedListener);
            return baseConnectionCallbacks;
        }
    }
}
