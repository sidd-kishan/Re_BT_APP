/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.RemoteException
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.dynamic.IObjectWrapper
 *  com.google.android.gms.internal.ads.zzccj
 *  com.google.android.gms.internal.ads.zzcck
 *  com.google.android.gms.internal.ads.zzccl
 *  com.google.android.gms.internal.ads.zzdcl
 *  com.google.android.gms.internal.ads.zzdcm
 *  com.google.android.gms.internal.ads.zzdiz
 *  com.google.android.gms.internal.ads.zzeef
 *  com.google.android.gms.internal.ads.zzeiq
 *  com.google.android.gms.internal.ads.zzeir
 *  com.google.android.gms.internal.ads.zzeis
 *  com.google.android.gms.internal.ads.zzeit
 *  com.google.android.gms.internal.ads.zzezz
 *  com.google.android.gms.internal.ads.zzfal
 */
package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzccj;
import com.google.android.gms.internal.ads.zzcck;
import com.google.android.gms.internal.ads.zzccl;
import com.google.android.gms.internal.ads.zzdcl;
import com.google.android.gms.internal.ads.zzdcm;
import com.google.android.gms.internal.ads.zzdiz;
import com.google.android.gms.internal.ads.zzeef;
import com.google.android.gms.internal.ads.zzeiq;
import com.google.android.gms.internal.ads.zzeir;
import com.google.android.gms.internal.ads.zzeis;
import com.google.android.gms.internal.ads.zzeit;
import com.google.android.gms.internal.ads.zzezz;
import com.google.android.gms.internal.ads.zzfal;
import java.util.concurrent.Executor;

public final class zzefz
extends zzccj
implements zzdcm {
    private zzcck zza;
    private zzdcl zzb;
    private zzdiz zzc;

    public final void zza(zzdcl zzdcl2) {
        synchronized (this) {
            this.zzb = zzdcl2;
            return;
        }
    }

    public final void zzc(zzcck zzcck2) {
        synchronized (this) {
            this.zza = zzcck2;
            return;
        }
    }

    public final void zzd(zzdiz zzdiz2) {
        synchronized (this) {
            this.zzc = zzdiz2;
            return;
        }
    }

    public final void zze(IObjectWrapper iObjectWrapper) throws RemoteException {
        synchronized (this) {
            zzdiz zzdiz2 = this.zzc;
            if (zzdiz2 == null) return;
            Executor executor = zzeit.zzc((zzeit)((zzeir)zzdiz2).zzd);
            zzfal zzfal2 = ((zzeir)zzdiz2).zza;
            iObjectWrapper = ((zzeir)zzdiz2).zzb;
            zzeef zzeef2 = ((zzeir)zzdiz2).zzc;
            zzeiq zzeiq2 = new zzeiq((zzeir)zzdiz2, zzfal2, (zzezz)iObjectWrapper, zzeef2);
            executor.execute((Runnable)zzeiq2);
            return;
        }
    }

    public final void zzf(IObjectWrapper object, int n) throws RemoteException {
        synchronized (this) {
            object = this.zzc;
            if (object == null) return;
            object = String.valueOf(((zzeir)object).zzc.zza);
            object = ((String)object).length() != 0 ? "Fail to initialize adapter ".concat((String)object) : new String("Fail to initialize adapter ");
            zze.zzi((String)object);
            return;
        }
    }

    public final void zzg(IObjectWrapper iObjectWrapper) throws RemoteException {
        synchronized (this) {
            iObjectWrapper = this.zzb;
            if (iObjectWrapper == null) return;
            iObjectWrapper.zza();
            return;
        }
    }

    public final void zzh(IObjectWrapper iObjectWrapper) throws RemoteException {
        synchronized (this) {
            iObjectWrapper = this.zza;
            if (iObjectWrapper == null) return;
            ((zzeis)iObjectWrapper).zza.zzbp();
            return;
        }
    }

    public final void zzi(IObjectWrapper iObjectWrapper) throws RemoteException {
        synchronized (this) {
            iObjectWrapper = this.zza;
            if (iObjectWrapper == null) return;
            ((zzeis)iObjectWrapper).zzd.zza();
            return;
        }
    }

    public final void zzj(IObjectWrapper iObjectWrapper) throws RemoteException {
        synchronized (this) {
            zzcck zzcck2 = this.zza;
            if (zzcck2 == null) return;
            zzcck2.zzj(iObjectWrapper);
            return;
        }
    }

    public final void zzk(IObjectWrapper iObjectWrapper, zzccl zzccl2) throws RemoteException {
        synchronized (this) {
            iObjectWrapper = this.zza;
            if (iObjectWrapper == null) return;
            ((zzeis)iObjectWrapper).zzd.zzb(zzccl2);
            return;
        }
    }

    public final void zzl(IObjectWrapper iObjectWrapper) throws RemoteException {
        synchronized (this) {
            iObjectWrapper = this.zza;
            if (iObjectWrapper == null) return;
            ((zzeis)iObjectWrapper).zzb.onAdClicked();
            return;
        }
    }

    public final void zzm(IObjectWrapper iObjectWrapper, int n) throws RemoteException {
        synchronized (this) {
            iObjectWrapper = this.zzb;
            if (iObjectWrapper == null) return;
            iObjectWrapper.zzb(n);
            return;
        }
    }

    public final void zzn(IObjectWrapper iObjectWrapper) throws RemoteException {
        synchronized (this) {
            iObjectWrapper = this.zza;
            if (iObjectWrapper == null) return;
            ((zzeis)iObjectWrapper).zzc.zzb();
            return;
        }
    }

    public final void zzo(IObjectWrapper iObjectWrapper) throws RemoteException {
        synchronized (this) {
            iObjectWrapper = this.zza;
            if (iObjectWrapper == null) return;
            ((zzeis)iObjectWrapper).zzc.zzf();
            return;
        }
    }
}
