/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  android.os.IBinder
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 *  android.os.RemoteException
 *  com.google.android.gms.dynamic.IObjectWrapper
 *  com.google.android.gms.dynamic.IObjectWrapper$Stub
 *  com.google.android.gms.internal.ads.zzadj
 *  com.google.android.gms.internal.ads.zzadl
 *  com.google.android.gms.internal.ads.zzbmh
 */
package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzadj;
import com.google.android.gms.internal.ads.zzadl;
import com.google.android.gms.internal.ads.zzbmh;

public final class zzbmf
extends zzadj
implements zzbmh {
    zzbmf(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.INativeAdImage");
    }

    public final IObjectWrapper zzb() throws RemoteException {
        Parcel parcel = this.zzbi(1, this.zza());
        IObjectWrapper iObjectWrapper = IObjectWrapper.Stub.asInterface((IBinder)parcel.readStrongBinder());
        parcel.recycle();
        return iObjectWrapper;
    }

    public final Uri zzc() throws RemoteException {
        Parcel parcel = this.zzbi(2, this.zza());
        Uri uri = (Uri)zzadl.zzc((Parcel)parcel, (Parcelable.Creator)Uri.CREATOR);
        parcel.recycle();
        return uri;
    }

    public final double zzd() throws RemoteException {
        Parcel parcel = this.zzbi(3, this.zza());
        double d = parcel.readDouble();
        parcel.recycle();
        return d;
    }

    public final int zze() throws RemoteException {
        Parcel parcel = this.zzbi(4, this.zza());
        int n = parcel.readInt();
        parcel.recycle();
        return n;
    }

    public final int zzf() throws RemoteException {
        Parcel parcel = this.zzbi(5, this.zza());
        int n = parcel.readInt();
        parcel.recycle();
        return n;
    }
}
