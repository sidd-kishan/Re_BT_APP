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
 *  com.google.android.gms.internal.ads.zzbmf
 *  com.google.android.gms.internal.ads.zzbmh
 *  com.google.android.gms.internal.ads.zzbnb
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
import com.google.android.gms.internal.ads.zzbmf;
import com.google.android.gms.internal.ads.zzbmh;
import com.google.android.gms.internal.ads.zzbnb;
import java.util.ArrayList;
import java.util.List;

public final class zzbmz
extends zzadj
implements zzbnb {
    zzbmz(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.INativeCustomTemplateAd");
    }

    public final String zze(String string) throws RemoteException {
        Parcel parcel = this.zza();
        parcel.writeString(string);
        parcel = this.zzbi(1, parcel);
        string = parcel.readString();
        parcel.recycle();
        return string;
    }

    public final zzbmh zzf(String object) throws RemoteException {
        IInterface iInterface;
        Parcel parcel = this.zza();
        parcel.writeString((String)object);
        parcel = this.zzbi(2, parcel);
        object = parcel.readStrongBinder();
        object = object == null ? null : ((iInterface = object.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdImage")) instanceof zzbmh ? (zzbmh)iInterface : new zzbmf((IBinder)object));
        parcel.recycle();
        return object;
    }

    public final List<String> zzg() throws RemoteException {
        Parcel parcel = this.zzbi(3, this.zza());
        ArrayList arrayList = parcel.createStringArrayList();
        parcel.recycle();
        return arrayList;
    }

    public final String zzh() throws RemoteException {
        Parcel parcel = this.zzbi(4, this.zza());
        String string = parcel.readString();
        parcel.recycle();
        return string;
    }

    public final void zzi(String string) throws RemoteException {
        Parcel parcel = this.zza();
        parcel.writeString(string);
        this.zzbj(5, parcel);
    }

    public final void zzj() throws RemoteException {
        this.zzbj(6, this.zza());
    }

    public final zzbhc zzk() throws RemoteException {
        Parcel parcel = this.zzbi(7, this.zza());
        zzbhc zzbhc2 = zzbhb.zzb((IBinder)parcel.readStrongBinder());
        parcel.recycle();
        return zzbhc2;
    }

    public final void zzl() throws RemoteException {
        this.zzbj(8, this.zza());
    }

    public final IObjectWrapper zzm() throws RemoteException {
        Parcel parcel = this.zzbi(9, this.zza());
        IObjectWrapper iObjectWrapper = IObjectWrapper.Stub.asInterface((IBinder)parcel.readStrongBinder());
        parcel.recycle();
        return iObjectWrapper;
    }

    public final boolean zzn(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcel = this.zza();
        zzadl.zzf((Parcel)parcel, (IInterface)iObjectWrapper);
        iObjectWrapper = this.zzbi(10, parcel);
        boolean bl = zzadl.zza((Parcel)iObjectWrapper);
        iObjectWrapper.recycle();
        return bl;
    }

    public final boolean zzo() throws RemoteException {
        Parcel parcel = this.zzbi(12, this.zza());
        boolean bl = zzadl.zza((Parcel)parcel);
        parcel.recycle();
        return bl;
    }

    public final boolean zzp() throws RemoteException {
        Parcel parcel = this.zzbi(13, this.zza());
        boolean bl = zzadl.zza((Parcel)parcel);
        parcel.recycle();
        return bl;
    }

    public final void zzq(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcel = this.zza();
        zzadl.zzf((Parcel)parcel, (IInterface)iObjectWrapper);
        this.zzbj(14, parcel);
    }

    public final void zzr() throws RemoteException {
        this.zzbj(15, this.zza());
    }
}
