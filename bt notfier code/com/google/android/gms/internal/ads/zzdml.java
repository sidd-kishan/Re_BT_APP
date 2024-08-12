/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.RemoteException
 *  com.google.android.gms.internal.ads.zzbhb
 *  com.google.android.gms.internal.ads.zzbhc
 *  com.google.android.gms.internal.ads.zzbhf
 *  com.google.android.gms.internal.ads.zzbvv
 */
package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzbhb;
import com.google.android.gms.internal.ads.zzbhc;
import com.google.android.gms.internal.ads.zzbhf;
import com.google.android.gms.internal.ads.zzbvv;
import javax.annotation.Nullable;

public final class zzdml
extends zzbhb {
    private final Object zza = new Object();
    @Nullable
    private final zzbhc zzb;
    @Nullable
    private final zzbvv zzc;

    public zzdml(@Nullable zzbhc zzbhc2, @Nullable zzbvv zzbvv2) {
        this.zzb = zzbhc2;
        this.zzc = zzbvv2;
    }

    public final void zze() throws RemoteException {
        throw new RemoteException();
    }

    public final void zzf() throws RemoteException {
        throw new RemoteException();
    }

    public final void zzg(boolean bl) throws RemoteException {
        throw new RemoteException();
    }

    public final boolean zzh() throws RemoteException {
        throw new RemoteException();
    }

    public final int zzi() throws RemoteException {
        throw new RemoteException();
    }

    public final float zzj() throws RemoteException {
        zzbvv zzbvv2 = this.zzc;
        if (zzbvv2 == null) return 0.0f;
        return zzbvv2.zzA();
    }

    public final float zzk() throws RemoteException {
        zzbvv zzbvv2 = this.zzc;
        if (zzbvv2 == null) return 0.0f;
        return zzbvv2.zzB();
    }

    public final void zzl(zzbhf zzbhf2) throws RemoteException {
        Object object = this.zza;
        synchronized (object) {
            zzbhc zzbhc2 = this.zzb;
            if (zzbhc2 == null) return;
            zzbhc2.zzl(zzbhf2);
            return;
        }
    }

    public final float zzm() throws RemoteException {
        throw new RemoteException();
    }

    public final boolean zzn() throws RemoteException {
        throw new RemoteException();
    }

    public final zzbhf zzo() throws RemoteException {
        Object object = this.zza;
        synchronized (object) {
            zzbhc zzbhc2 = this.zzb;
            if (zzbhc2 == null) return null;
            zzbhc2 = zzbhc2.zzo();
            return zzbhc2;
        }
    }

    public final boolean zzp() throws RemoteException {
        throw new RemoteException();
    }

    public final void zzq() throws RemoteException {
        throw new RemoteException();
    }
}
