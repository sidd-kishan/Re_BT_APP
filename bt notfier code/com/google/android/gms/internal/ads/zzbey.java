/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.RemoteException
 *  com.google.android.gms.internal.ads.zzadj
 *  com.google.android.gms.internal.ads.zzadl
 *  com.google.android.gms.internal.ads.zzbcz
 *  com.google.android.gms.internal.ads.zzbfa
 */
package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzadj;
import com.google.android.gms.internal.ads.zzadl;
import com.google.android.gms.internal.ads.zzbcz;
import com.google.android.gms.internal.ads.zzbfa;

public final class zzbey
extends zzadj
implements zzbfa {
    zzbey(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdListener");
    }

    public final void zzb() throws RemoteException {
        this.zzbj(1, this.zza());
    }

    public final void zzc(int n) throws RemoteException {
        Parcel parcel = this.zza();
        parcel.writeInt(n);
        this.zzbj(2, parcel);
    }

    public final void zzd(zzbcz zzbcz2) throws RemoteException {
        Parcel parcel = this.zza();
        zzadl.zzd((Parcel)parcel, (Parcelable)zzbcz2);
        this.zzbj(8, parcel);
    }

    public final void zze() throws RemoteException {
        this.zzbj(3, this.zza());
    }

    public final void zzf() throws RemoteException {
        this.zzbj(4, this.zza());
    }

    public final void zzg() throws RemoteException {
        this.zzbj(5, this.zza());
    }

    public final void zzh() throws RemoteException {
        this.zzbj(6, this.zza());
    }

    public final void zzi() throws RemoteException {
        this.zzbj(7, this.zza());
    }
}
