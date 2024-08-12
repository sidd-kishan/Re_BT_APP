/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.RemoteException
 *  com.google.android.gms.internal.ads.zzbcz
 *  com.google.android.gms.internal.ads.zzbnb
 *  com.google.android.gms.internal.ads.zzbvl
 *  com.google.android.gms.internal.ads.zzbvm
 *  com.google.android.gms.internal.ads.zzccl
 *  com.google.android.gms.internal.ads.zzccp
 *  com.google.android.gms.internal.ads.zzdcl
 *  com.google.android.gms.internal.ads.zzdcm
 */
package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzbcz;
import com.google.android.gms.internal.ads.zzbnb;
import com.google.android.gms.internal.ads.zzbvl;
import com.google.android.gms.internal.ads.zzbvm;
import com.google.android.gms.internal.ads.zzccl;
import com.google.android.gms.internal.ads.zzccp;
import com.google.android.gms.internal.ads.zzdcl;
import com.google.android.gms.internal.ads.zzdcm;

public final class zzefy
extends zzbvl
implements zzdcm {
    private zzbvm zza;
    private zzdcl zzb;

    public final void zza(zzdcl zzdcl2) {
        synchronized (this) {
            this.zzb = zzdcl2;
            return;
        }
    }

    public final void zzc(zzbvm zzbvm2) {
        synchronized (this) {
            this.zza = zzbvm2;
            return;
        }
    }

    public final void zze() throws RemoteException {
        synchronized (this) {
            zzbvm zzbvm2 = this.zza;
            if (zzbvm2 == null) return;
            zzbvm2.zze();
            return;
        }
    }

    public final void zzf() throws RemoteException {
        synchronized (this) {
            zzbvm zzbvm2 = this.zza;
            if (zzbvm2 == null) return;
            zzbvm2.zzf();
            return;
        }
    }

    public final void zzg(int n) throws RemoteException {
        synchronized (this) {
            zzdcl zzdcl2 = this.zzb;
            if (zzdcl2 == null) return;
            zzdcl2.zzb(n);
            return;
        }
    }

    public final void zzh() throws RemoteException {
        synchronized (this) {
            zzbvm zzbvm2 = this.zza;
            if (zzbvm2 == null) return;
            zzbvm2.zzh();
            return;
        }
    }

    public final void zzi() throws RemoteException {
        synchronized (this) {
            zzbvm zzbvm2 = this.zza;
            if (zzbvm2 == null) return;
            zzbvm2.zzi();
            return;
        }
    }

    public final void zzj() throws RemoteException {
        synchronized (this) {
            zzbvm zzbvm2 = this.zza;
            if (zzbvm2 != null) {
                zzbvm2.zzj();
            }
            if ((zzbvm2 = this.zzb) == null) return;
            zzbvm2.zza();
            return;
        }
    }

    public final void zzk() throws RemoteException {
        synchronized (this) {
            zzbvm zzbvm2 = this.zza;
            if (zzbvm2 == null) return;
            zzbvm2.zzk();
            return;
        }
    }

    public final void zzl(String string, String string2) throws RemoteException {
        synchronized (this) {
            zzbvm zzbvm2 = this.zza;
            if (zzbvm2 == null) return;
            zzbvm2.zzl(string, string2);
            return;
        }
    }

    /*
     * Converted monitor instructions to comments
     */
    public final void zzm(zzbnb zzbnb2, String string) throws RemoteException {
        // MONITORENTER : this
        // MONITOREXIT : this
    }

    public final void zzn() throws RemoteException {
        synchronized (this) {
            zzbvm zzbvm2 = this.zza;
            if (zzbvm2 == null) return;
            zzbvm2.zzn();
            return;
        }
    }

    public final void zzo() throws RemoteException {
        synchronized (this) {
            zzbvm zzbvm2 = this.zza;
            if (zzbvm2 == null) return;
            zzbvm2.zzo();
            return;
        }
    }

    public final void zzp(zzccl zzccl2) throws RemoteException {
        synchronized (this) {
            zzbvm zzbvm2 = this.zza;
            if (zzbvm2 == null) return;
            zzbvm2.zzp(zzccl2);
            return;
        }
    }

    public final void zzq() throws RemoteException {
        synchronized (this) {
            zzbvm zzbvm2 = this.zza;
            if (zzbvm2 == null) return;
            zzbvm2.zzq();
            return;
        }
    }

    public final void zzr(zzccp zzccp2) throws RemoteException {
        synchronized (this) {
            zzbvm zzbvm2 = this.zza;
            if (zzbvm2 == null) return;
            zzbvm2.zzr(zzccp2);
            return;
        }
    }

    public final void zzs(int n) throws RemoteException {
        synchronized (this) {
            zzbvm zzbvm2 = this.zza;
            if (zzbvm2 == null) return;
            zzbvm2.zzs(n);
            return;
        }
    }

    public final void zzt() throws RemoteException {
        synchronized (this) {
            zzbvm zzbvm2 = this.zza;
            if (zzbvm2 == null) return;
            zzbvm2.zzt();
            return;
        }
    }

    public final void zzu() throws RemoteException {
        synchronized (this) {
            zzbvm zzbvm2 = this.zza;
            if (zzbvm2 == null) return;
            zzbvm2.zzu();
            return;
        }
    }

    public final void zzv(String string) throws RemoteException {
        synchronized (this) {
            zzbvm zzbvm2 = this.zza;
            if (zzbvm2 == null) return;
            zzbvm2.zzv(string);
            return;
        }
    }

    public final void zzw(int n, String string) throws RemoteException {
        synchronized (this) {
            zzdcl zzdcl2 = this.zzb;
            if (zzdcl2 == null) return;
            zzdcl2.zzc(n, string);
            return;
        }
    }

    public final void zzx(zzbcz zzbcz2) throws RemoteException {
        synchronized (this) {
            zzdcl zzdcl2 = this.zzb;
            if (zzdcl2 == null) return;
            zzdcl2.zzd(zzbcz2);
            return;
        }
    }

    public final void zzy(zzbcz zzbcz2) throws RemoteException {
        synchronized (this) {
            zzbvm zzbvm2 = this.zza;
            if (zzbvm2 == null) return;
            zzbvm2.zzy(zzbcz2);
            return;
        }
    }
}
