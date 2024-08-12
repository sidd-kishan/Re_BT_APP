/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.drawable.Drawable
 *  android.os.RemoteException
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.dynamic.IObjectWrapper
 *  com.google.android.gms.dynamic.ObjectWrapper
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbhc
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzbmd
 *  com.google.android.gms.internal.ads.zzbnp
 *  com.google.android.gms.internal.ads.zzcnh
 *  com.google.android.gms.internal.ads.zzdmm
 */
package com.google.android.gms.internal.ads;

import android.graphics.drawable.Drawable;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbhc;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzbmd;
import com.google.android.gms.internal.ads.zzbnp;
import com.google.android.gms.internal.ads.zzcnh;
import com.google.android.gms.internal.ads.zzdmm;

public final class zzdly
extends zzbmd {
    private final zzdmm zza;
    private IObjectWrapper zzb;

    public zzdly(zzdmm zzdmm2) {
        this.zza = zzdmm2;
    }

    private static float zzb(IObjectWrapper iObjectWrapper) {
        float f = 0.0f;
        if (iObjectWrapper == null) {
            return 0.0f;
        }
        iObjectWrapper = (Drawable)ObjectWrapper.unwrap((IObjectWrapper)iObjectWrapper);
        float f2 = f;
        if (iObjectWrapper == null) return f2;
        f2 = f;
        if (iObjectWrapper.getIntrinsicWidth() == -1) return f2;
        f2 = f;
        if (iObjectWrapper.getIntrinsicHeight() == -1) return f2;
        f2 = (float)iObjectWrapper.getIntrinsicWidth() / (float)iObjectWrapper.getIntrinsicHeight();
        return f2;
    }

    public final float zze() throws RemoteException {
        zzbjd zzbjd2 = zzbjl.zzeA;
        boolean bl = (Boolean)zzbet.zzc().zzc(zzbjd2);
        float f = 0.0f;
        float f2 = 0.0f;
        if (!bl) {
            return 0.0f;
        }
        if (this.zza.zzW() != 0.0f) {
            return this.zza.zzW();
        }
        if (this.zza.zzw() != null) {
            try {
                f2 = f = this.zza.zzw().zzm();
            }
            catch (RemoteException remoteException) {
                zze.zzg((String)"Remote exception getting video controller aspect ratio.", (Throwable)remoteException);
            }
            return f2;
        }
        zzbjd2 = this.zzb;
        if (zzbjd2 != null) {
            f2 = zzdly.zzb((IObjectWrapper)zzbjd2);
        } else {
            zzbjd2 = this.zza.zzB();
            if (zzbjd2 == null) {
                f2 = f;
            } else {
                f2 = zzbjd2.zze() != -1 && zzbjd2.zzf() != -1 ? (float)zzbjd2.zze() / (float)zzbjd2.zzf() : 0.0f;
                if (f2 != 0.0f) return f2;
                return zzdly.zzb(zzbjd2.zzb());
            }
        }
        return f2;
    }

    public final void zzf(IObjectWrapper iObjectWrapper) {
        this.zzb = iObjectWrapper;
    }

    public final IObjectWrapper zzg() throws RemoteException {
        IObjectWrapper iObjectWrapper = this.zzb;
        if (iObjectWrapper != null) {
            return iObjectWrapper;
        }
        iObjectWrapper = this.zza.zzB();
        if (iObjectWrapper != null) return iObjectWrapper.zzb();
        return null;
    }

    public final float zzh() throws RemoteException {
        zzbjd zzbjd2 = zzbjl.zzeB;
        if (!((Boolean)zzbet.zzc().zzc(zzbjd2)).booleanValue()) {
            return 0.0f;
        }
        if (this.zza.zzw() == null) return 0.0f;
        return this.zza.zzw().zzj();
    }

    public final float zzi() throws RemoteException {
        zzbjd zzbjd2 = zzbjl.zzeB;
        if (!((Boolean)zzbet.zzc().zzc(zzbjd2)).booleanValue()) {
            return 0.0f;
        }
        if (this.zza.zzw() == null) return 0.0f;
        return this.zza.zzw().zzk();
    }

    public final zzbhc zzj() throws RemoteException {
        zzbjd zzbjd2 = zzbjl.zzeB;
        if ((Boolean)zzbet.zzc().zzc(zzbjd2) != false) return this.zza.zzw();
        return null;
    }

    public final boolean zzk() throws RemoteException {
        zzbjd zzbjd2 = zzbjl.zzeB;
        if (!((Boolean)zzbet.zzc().zzc(zzbjd2)).booleanValue()) {
            return false;
        }
        if (this.zza.zzw() == null) return false;
        return true;
    }

    public final void zzl(zzbnp zzbnp2) {
        zzbjd zzbjd2 = zzbjl.zzeB;
        if (!((Boolean)zzbet.zzc().zzc(zzbjd2)).booleanValue()) {
            return;
        }
        if (!(this.zza.zzw() instanceof zzcnh)) return;
        ((zzcnh)this.zza.zzw()).zzv(zzbnp2);
    }
}
