/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.RemoteException
 *  com.google.android.gms.internal.ads.zzadj
 *  com.google.android.gms.internal.ads.zzadl
 *  com.google.android.gms.internal.ads.zzbcz
 *  com.google.android.gms.internal.ads.zzccp
 *  com.google.android.gms.internal.ads.zzccv
 */
package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzadj;
import com.google.android.gms.internal.ads.zzadl;
import com.google.android.gms.internal.ads.zzbcz;
import com.google.android.gms.internal.ads.zzccp;
import com.google.android.gms.internal.ads.zzccv;

public final class zzcct
extends zzadj
implements zzccv {
    zzcct(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.rewarded.client.IRewardedAdCallback");
    }

    public final void zze() throws RemoteException {
        this.zzbj(1, this.zza());
    }

    public final void zzf() throws RemoteException {
        this.zzbj(2, this.zza());
    }

    public final void zzg(zzccp zzccp2) throws RemoteException {
        Parcel parcel = this.zza();
        zzadl.zzf((Parcel)parcel, (IInterface)zzccp2);
        this.zzbj(3, parcel);
    }

    public final void zzh(int n) throws RemoteException {
        Parcel parcel = this.zza();
        parcel.writeInt(n);
        this.zzbj(4, parcel);
    }

    public final void zzi(zzbcz zzbcz2) throws RemoteException {
        Parcel parcel = this.zza();
        zzadl.zzd((Parcel)parcel, (Parcelable)zzbcz2);
        this.zzbj(5, parcel);
    }

    public final void zzj() throws RemoteException {
        this.zzbj(6, this.zza());
    }

    public final void zzk() throws RemoteException {
        this.zzbj(7, this.zza());
    }
}
