/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 *  android.os.Bundle
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.RemoteException
 *  com.google.android.gms.dynamic.IObjectWrapper
 *  com.google.android.gms.internal.ads.zzadj
 *  com.google.android.gms.internal.ads.zzadl
 *  com.google.android.gms.internal.ads.zzbzq
 */
package com.google.android.gms.internal.ads;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzadj;
import com.google.android.gms.internal.ads.zzadl;
import com.google.android.gms.internal.ads.zzbzq;

public final class zzbzo
extends zzadj
implements zzbzq {
    zzbzo(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
    }

    public final void zze() throws RemoteException {
        this.zzbj(10, this.zza());
    }

    public final void zzf() throws RemoteException {
        this.zzbj(14, this.zza());
    }

    public final boolean zzg() throws RemoteException {
        Parcel parcel = this.zzbi(11, this.zza());
        boolean bl = zzadl.zza((Parcel)parcel);
        parcel.recycle();
        return bl;
    }

    public final void zzh(Bundle bundle) throws RemoteException {
        Parcel parcel = this.zza();
        zzadl.zzd((Parcel)parcel, (Parcelable)bundle);
        this.zzbj(1, parcel);
    }

    public final void zzi() throws RemoteException {
        this.zzbj(2, this.zza());
    }

    public final void zzj() throws RemoteException {
        this.zzbj(3, this.zza());
    }

    public final void zzk() throws RemoteException {
        this.zzbj(4, this.zza());
    }

    public final void zzl() throws RemoteException {
        this.zzbj(5, this.zza());
    }

    public final void zzm(int n, int n2, Intent intent) throws RemoteException {
        Parcel parcel = this.zza();
        parcel.writeInt(n);
        parcel.writeInt(n2);
        zzadl.zzd((Parcel)parcel, (Parcelable)intent);
        this.zzbj(12, parcel);
    }

    public final void zzn(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcel = this.zza();
        zzadl.zzf((Parcel)parcel, (IInterface)iObjectWrapper);
        this.zzbj(13, parcel);
    }

    public final void zzo(Bundle bundle) throws RemoteException {
        Parcel parcel = this.zza();
        zzadl.zzd((Parcel)parcel, (Parcelable)bundle);
        parcel = this.zzbi(6, parcel);
        if (parcel.readInt() != 0) {
            bundle.readFromParcel(parcel);
        }
        parcel.recycle();
    }

    public final void zzp() throws RemoteException {
        this.zzbj(7, this.zza());
    }

    public final void zzq() throws RemoteException {
        this.zzbj(8, this.zza());
    }

    public final void zzs() throws RemoteException {
        this.zzbj(9, this.zza());
    }
}
