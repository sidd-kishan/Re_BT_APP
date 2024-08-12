/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Parcel
 *  android.os.RemoteException
 *  com.google.android.gms.internal.ads.zzadj
 *  com.google.android.gms.internal.ads.zzadl
 *  com.google.android.gms.internal.ads.zzcbz
 *  com.google.android.gms.internal.ads.zzccf
 */
package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzadj;
import com.google.android.gms.internal.ads.zzadl;
import com.google.android.gms.internal.ads.zzcbz;
import com.google.android.gms.internal.ads.zzccf;

public final class zzccd
extends zzadj
implements zzccf {
    zzccd(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.reward.client.IRewardedVideoAdListener");
    }

    public final void zze() throws RemoteException {
        this.zzbj(1, this.zza());
    }

    public final void zzf() throws RemoteException {
        this.zzbj(2, this.zza());
    }

    public final void zzg() throws RemoteException {
        this.zzbj(3, this.zza());
    }

    public final void zzh() throws RemoteException {
        this.zzbj(4, this.zza());
    }

    public final void zzi(zzcbz zzcbz2) throws RemoteException {
        Parcel parcel = this.zza();
        zzadl.zzf((Parcel)parcel, (IInterface)zzcbz2);
        this.zzbj(5, parcel);
    }

    public final void zzj() throws RemoteException {
        this.zzbj(6, this.zza());
    }

    public final void zzk(int n) throws RemoteException {
        Parcel parcel = this.zza();
        parcel.writeInt(n);
        this.zzbj(7, parcel);
    }

    public final void zzl() throws RemoteException {
        this.zzbj(8, this.zza());
    }
}
