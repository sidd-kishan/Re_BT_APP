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
 *  com.google.android.gms.internal.ads.zzffy
 */
package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzadj;
import com.google.android.gms.internal.ads.zzadl;
import com.google.android.gms.internal.ads.zzffy;

public final class zzffw
extends zzadj
implements zzffy {
    zzffw(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.omid.IOmid");
    }

    public final boolean zze(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcel = this.zza();
        zzadl.zzf((Parcel)parcel, (IInterface)iObjectWrapper);
        iObjectWrapper = this.zzbi(2, parcel);
        boolean bl = zzadl.zza((Parcel)iObjectWrapper);
        iObjectWrapper.recycle();
        return bl;
    }

    public final void zzf(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcel = this.zza();
        zzadl.zzf((Parcel)parcel, (IInterface)iObjectWrapper);
        this.zzbj(4, parcel);
    }

    public final void zzg(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) throws RemoteException {
        Parcel parcel = this.zza();
        zzadl.zzf((Parcel)parcel, (IInterface)iObjectWrapper);
        zzadl.zzf((Parcel)parcel, (IInterface)iObjectWrapper2);
        this.zzbj(5, parcel);
    }

    public final String zzh() throws RemoteException {
        Parcel parcel = this.zzbi(6, this.zza());
        String string = parcel.readString();
        parcel.recycle();
        return string;
    }

    public final void zzi(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcel = this.zza();
        zzadl.zzf((Parcel)parcel, (IInterface)iObjectWrapper);
        this.zzbj(7, parcel);
    }

    public final void zzj(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) throws RemoteException {
        Parcel parcel = this.zza();
        zzadl.zzf((Parcel)parcel, (IInterface)iObjectWrapper);
        zzadl.zzf((Parcel)parcel, (IInterface)iObjectWrapper2);
        this.zzbj(8, parcel);
    }

    public final IObjectWrapper zzk(String string, IObjectWrapper iObjectWrapper, String string2, String string3, String string4, String string5, String string6, String string7, String string8) throws RemoteException {
        string2 = this.zza();
        string2.writeString(string);
        zzadl.zzf((Parcel)string2, (IInterface)iObjectWrapper);
        string2.writeString("");
        string2.writeString("javascript");
        string2.writeString(string4);
        string2.writeString(string5);
        string2.writeString(string6);
        string2.writeString(string7);
        string2.writeString(string8);
        string = this.zzbi(10, (Parcel)string2);
        iObjectWrapper = IObjectWrapper.Stub.asInterface((IBinder)string.readStrongBinder());
        string.recycle();
        return iObjectWrapper;
    }

    public final IObjectWrapper zzl(String string, IObjectWrapper iObjectWrapper, String string2, String string3, String string4, String string5, String string6, String string7, String string8) throws RemoteException {
        string2 = this.zza();
        string2.writeString(string);
        zzadl.zzf((Parcel)string2, (IInterface)iObjectWrapper);
        string2.writeString("");
        string2.writeString("javascript");
        string2.writeString(string4);
        string2.writeString("Google");
        string2.writeString(string6);
        string2.writeString(string7);
        string2.writeString(string8);
        iObjectWrapper = this.zzbi(11, (Parcel)string2);
        string = IObjectWrapper.Stub.asInterface((IBinder)iObjectWrapper.readStrongBinder());
        iObjectWrapper.recycle();
        return string;
    }
}
