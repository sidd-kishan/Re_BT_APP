/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Parcel
 *  android.os.RemoteException
 *  com.google.android.gms.dynamic.IObjectWrapper
 *  com.google.android.gms.dynamic.IObjectWrapper$Stub
 *  com.google.android.gms.internal.ads.zzadj
 *  com.google.android.gms.internal.ads.zzadl
 *  com.google.android.gms.internal.ads.zzbhb
 *  com.google.android.gms.internal.ads.zzbhc
 *  com.google.android.gms.internal.ads.zzbme
 *  com.google.android.gms.internal.ads.zzbnp
 */
package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzadj;
import com.google.android.gms.internal.ads.zzadl;
import com.google.android.gms.internal.ads.zzbhb;
import com.google.android.gms.internal.ads.zzbhc;
import com.google.android.gms.internal.ads.zzbme;
import com.google.android.gms.internal.ads.zzbnp;

public final class zzbmc
extends zzadj
implements zzbme {
    zzbmc(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IMediaContent");
    }

    public final float zze() throws RemoteException {
        Parcel parcel = this.zzbi(2, this.zza());
        float f = parcel.readFloat();
        parcel.recycle();
        return f;
    }

    public final void zzf(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcel = this.zza();
        zzadl.zzf((Parcel)parcel, (IInterface)iObjectWrapper);
        this.zzbj(3, parcel);
    }

    public final IObjectWrapper zzg() throws RemoteException {
        Parcel parcel = this.zzbi(4, this.zza());
        IObjectWrapper iObjectWrapper = IObjectWrapper.Stub.asInterface((IBinder)parcel.readStrongBinder());
        parcel.recycle();
        return iObjectWrapper;
    }

    public final float zzh() throws RemoteException {
        Parcel parcel = this.zzbi(5, this.zza());
        float f = parcel.readFloat();
        parcel.recycle();
        return f;
    }

    public final float zzi() throws RemoteException {
        Parcel parcel = this.zzbi(6, this.zza());
        float f = parcel.readFloat();
        parcel.recycle();
        return f;
    }

    public final zzbhc zzj() throws RemoteException {
        Parcel parcel = this.zzbi(7, this.zza());
        zzbhc zzbhc2 = zzbhb.zzb((IBinder)parcel.readStrongBinder());
        parcel.recycle();
        return zzbhc2;
    }

    public final boolean zzk() throws RemoteException {
        Parcel parcel = this.zzbi(8, this.zza());
        boolean bl = zzadl.zza((Parcel)parcel);
        parcel.recycle();
        return bl;
    }

    public final void zzl(zzbnp zzbnp2) throws RemoteException {
        throw null;
    }
}
