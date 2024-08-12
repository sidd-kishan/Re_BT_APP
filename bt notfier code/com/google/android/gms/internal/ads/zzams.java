/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Parcel
 *  android.os.RemoteException
 *  com.google.android.gms.dynamic.IObjectWrapper
 *  com.google.android.gms.internal.ads.zzadj
 *  com.google.android.gms.internal.ads.zzadl
 *  com.google.android.gms.internal.ads.zzamu
 */
package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzadj;
import com.google.android.gms.internal.ads.zzadl;
import com.google.android.gms.internal.ads.zzamu;

public final class zzams
extends zzadj
implements zzamu {
    zzams(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.clearcut.IClearcut");
    }

    public final void zze(IObjectWrapper iObjectWrapper, String string) throws RemoteException {
        string = this.zza();
        zzadl.zzf((Parcel)string, (IInterface)iObjectWrapper);
        string.writeString("GMA_SDK");
        this.zzbj(2, (Parcel)string);
    }

    public final void zzf() throws RemoteException {
        this.zzbj(3, this.zza());
    }

    public final void zzg(int[] object) throws RemoteException {
        object = this.zza();
        object.writeIntArray(null);
        this.zzbj(4, (Parcel)object);
    }

    public final void zzh(byte[] byArray) throws RemoteException {
        Parcel parcel = this.zza();
        parcel.writeByteArray(byArray);
        this.zzbj(5, parcel);
    }

    public final void zzi(int n) throws RemoteException {
        Parcel parcel = this.zza();
        parcel.writeInt(0);
        this.zzbj(6, parcel);
    }

    public final void zzj(int n) throws RemoteException {
        Parcel parcel = this.zza();
        parcel.writeInt(n);
        this.zzbj(7, parcel);
    }
}
