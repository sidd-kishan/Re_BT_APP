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
 */
package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzadj;
import com.google.android.gms.internal.ads.zzadl;

public final class zzfkl
extends zzadj
implements IInterface {
    zzfkl(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.gass.internal.clearcut.IGassClearcut");
    }

    public final void zze() throws RemoteException {
        this.zzbj(3, this.zza());
    }

    public final void zzf(int[] object) throws RemoteException {
        object = this.zza();
        object.writeIntArray(null);
        this.zzbj(4, (Parcel)object);
    }

    public final void zzg(byte[] byArray) throws RemoteException {
        Parcel parcel = this.zza();
        parcel.writeByteArray(byArray);
        this.zzbj(5, parcel);
    }

    public final void zzh(int n) throws RemoteException {
        Parcel parcel = this.zza();
        parcel.writeInt(n);
        this.zzbj(6, parcel);
    }

    public final void zzi(int n) throws RemoteException {
        Parcel parcel = this.zza();
        parcel.writeInt(n);
        this.zzbj(7, parcel);
    }

    public final void zzj(IObjectWrapper iObjectWrapper, String string, String string2) throws RemoteException {
        string2 = this.zza();
        zzadl.zzf((Parcel)string2, (IInterface)iObjectWrapper);
        string2.writeString(string);
        string2.writeString(null);
        this.zzbj(8, (Parcel)string2);
    }
}
