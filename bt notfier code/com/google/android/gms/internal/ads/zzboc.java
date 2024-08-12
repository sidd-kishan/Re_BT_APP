/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  android.os.RemoteException
 *  com.google.android.gms.dynamic.IObjectWrapper
 *  com.google.android.gms.dynamic.IObjectWrapper$Stub
 *  com.google.android.gms.internal.ads.zzadj
 *  com.google.android.gms.internal.ads.zzadl
 *  com.google.android.gms.internal.ads.zzbgi
 *  com.google.android.gms.internal.ads.zzbgm
 *  com.google.android.gms.internal.ads.zzbgw
 *  com.google.android.gms.internal.ads.zzbgy
 *  com.google.android.gms.internal.ads.zzbgz
 *  com.google.android.gms.internal.ads.zzbhb
 *  com.google.android.gms.internal.ads.zzbhc
 *  com.google.android.gms.internal.ads.zzblx
 *  com.google.android.gms.internal.ads.zzblz
 *  com.google.android.gms.internal.ads.zzbmc
 *  com.google.android.gms.internal.ads.zzbme
 *  com.google.android.gms.internal.ads.zzbmf
 *  com.google.android.gms.internal.ads.zzbmh
 *  com.google.android.gms.internal.ads.zzbob
 *  com.google.android.gms.internal.ads.zzboe
 */
package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzadj;
import com.google.android.gms.internal.ads.zzadl;
import com.google.android.gms.internal.ads.zzbgi;
import com.google.android.gms.internal.ads.zzbgm;
import com.google.android.gms.internal.ads.zzbgw;
import com.google.android.gms.internal.ads.zzbgy;
import com.google.android.gms.internal.ads.zzbgz;
import com.google.android.gms.internal.ads.zzbhb;
import com.google.android.gms.internal.ads.zzbhc;
import com.google.android.gms.internal.ads.zzblx;
import com.google.android.gms.internal.ads.zzblz;
import com.google.android.gms.internal.ads.zzbmc;
import com.google.android.gms.internal.ads.zzbme;
import com.google.android.gms.internal.ads.zzbmf;
import com.google.android.gms.internal.ads.zzbmh;
import com.google.android.gms.internal.ads.zzbob;
import com.google.android.gms.internal.ads.zzboe;
import java.util.ArrayList;
import java.util.List;

public final class zzboc
extends zzadj
implements zzboe {
    zzboc(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IUnifiedNativeAd");
    }

    public final boolean zzA() throws RemoteException {
        Parcel parcel = this.zzbi(24, this.zza());
        boolean bl = zzadl.zza((Parcel)parcel);
        parcel.recycle();
        return bl;
    }

    public final void zzB(zzbgm zzbgm2) throws RemoteException {
        Parcel parcel = this.zza();
        zzadl.zzf((Parcel)parcel, (IInterface)zzbgm2);
        this.zzbj(25, parcel);
    }

    public final void zzC(zzbgi zzbgi2) throws RemoteException {
        Parcel parcel = this.zza();
        zzadl.zzf((Parcel)parcel, (IInterface)zzbgi2);
        this.zzbj(26, parcel);
    }

    public final void zzD() throws RemoteException {
        this.zzbj(27, this.zza());
    }

    public final void zzE() throws RemoteException {
        this.zzbj(28, this.zza());
    }

    public final zzbme zzF() throws RemoteException {
        IInterface iInterface;
        Parcel parcel = this.zzbi(29, this.zza());
        Object object = parcel.readStrongBinder();
        object = object == null ? null : ((iInterface = object.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IMediaContent")) instanceof zzbme ? (zzbme)iInterface : new zzbmc(object));
        parcel.recycle();
        return object;
    }

    public final boolean zzG() throws RemoteException {
        Parcel parcel = this.zzbi(30, this.zza());
        boolean bl = zzadl.zza((Parcel)parcel);
        parcel.recycle();
        return bl;
    }

    public final zzbgz zzH() throws RemoteException {
        Parcel parcel = this.zzbi(31, this.zza());
        zzbgz zzbgz2 = zzbgy.zzb((IBinder)parcel.readStrongBinder());
        parcel.recycle();
        return zzbgz2;
    }

    public final void zzI(zzbgw zzbgw2) throws RemoteException {
        Parcel parcel = this.zza();
        zzadl.zzf((Parcel)parcel, (IInterface)zzbgw2);
        this.zzbj(32, parcel);
    }

    public final String zze() throws RemoteException {
        Parcel parcel = this.zzbi(2, this.zza());
        String string = parcel.readString();
        parcel.recycle();
        return string;
    }

    public final List zzf() throws RemoteException {
        Parcel parcel = this.zzbi(3, this.zza());
        ArrayList arrayList = zzadl.zzg((Parcel)parcel);
        parcel.recycle();
        return arrayList;
    }

    public final String zzg() throws RemoteException {
        Parcel parcel = this.zzbi(4, this.zza());
        String string = parcel.readString();
        parcel.recycle();
        return string;
    }

    public final zzbmh zzh() throws RemoteException {
        IInterface iInterface;
        Parcel parcel = this.zzbi(5, this.zza());
        Object object = parcel.readStrongBinder();
        object = object == null ? null : ((iInterface = object.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdImage")) instanceof zzbmh ? (zzbmh)iInterface : new zzbmf(object));
        parcel.recycle();
        return object;
    }

    public final String zzi() throws RemoteException {
        Parcel parcel = this.zzbi(6, this.zza());
        String string = parcel.readString();
        parcel.recycle();
        return string;
    }

    public final String zzj() throws RemoteException {
        Parcel parcel = this.zzbi(7, this.zza());
        String string = parcel.readString();
        parcel.recycle();
        return string;
    }

    public final double zzk() throws RemoteException {
        Parcel parcel = this.zzbi(8, this.zza());
        double d = parcel.readDouble();
        parcel.recycle();
        return d;
    }

    public final String zzl() throws RemoteException {
        Parcel parcel = this.zzbi(9, this.zza());
        String string = parcel.readString();
        parcel.recycle();
        return string;
    }

    public final String zzm() throws RemoteException {
        Parcel parcel = this.zzbi(10, this.zza());
        String string = parcel.readString();
        parcel.recycle();
        return string;
    }

    public final zzbhc zzn() throws RemoteException {
        Parcel parcel = this.zzbi(11, this.zza());
        zzbhc zzbhc2 = zzbhb.zzb((IBinder)parcel.readStrongBinder());
        parcel.recycle();
        return zzbhc2;
    }

    public final String zzo() throws RemoteException {
        Parcel parcel = this.zzbi(12, this.zza());
        String string = parcel.readString();
        parcel.recycle();
        return string;
    }

    public final void zzp() throws RemoteException {
        this.zzbj(13, this.zza());
    }

    public final zzblz zzq() throws RemoteException {
        IInterface iInterface;
        Parcel parcel = this.zzbi(14, this.zza());
        Object object = parcel.readStrongBinder();
        object = object == null ? null : ((iInterface = object.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IAttributionInfo")) instanceof zzblz ? (zzblz)iInterface : new zzblx(object));
        parcel.recycle();
        return object;
    }

    public final void zzr(Bundle bundle) throws RemoteException {
        Parcel parcel = this.zza();
        zzadl.zzd((Parcel)parcel, (Parcelable)bundle);
        this.zzbj(15, parcel);
    }

    public final boolean zzs(Bundle bundle) throws RemoteException {
        Parcel parcel = this.zza();
        zzadl.zzd((Parcel)parcel, (Parcelable)bundle);
        bundle = this.zzbi(16, parcel);
        boolean bl = zzadl.zza((Parcel)bundle);
        bundle.recycle();
        return bl;
    }

    public final void zzt(Bundle bundle) throws RemoteException {
        Parcel parcel = this.zza();
        zzadl.zzd((Parcel)parcel, (Parcelable)bundle);
        this.zzbj(17, parcel);
    }

    public final IObjectWrapper zzu() throws RemoteException {
        Parcel parcel = this.zzbi(18, this.zza());
        IObjectWrapper iObjectWrapper = IObjectWrapper.Stub.asInterface((IBinder)parcel.readStrongBinder());
        parcel.recycle();
        return iObjectWrapper;
    }

    public final IObjectWrapper zzv() throws RemoteException {
        Parcel parcel = this.zzbi(19, this.zza());
        IObjectWrapper iObjectWrapper = IObjectWrapper.Stub.asInterface((IBinder)parcel.readStrongBinder());
        parcel.recycle();
        return iObjectWrapper;
    }

    public final Bundle zzw() throws RemoteException {
        Parcel parcel = this.zzbi(20, this.zza());
        Bundle bundle = (Bundle)zzadl.zzc((Parcel)parcel, (Parcelable.Creator)Bundle.CREATOR);
        parcel.recycle();
        return bundle;
    }

    public final void zzx(zzbob zzbob2) throws RemoteException {
        Parcel parcel = this.zza();
        zzadl.zzf((Parcel)parcel, (IInterface)zzbob2);
        this.zzbj(21, parcel);
    }

    public final void zzy() throws RemoteException {
        this.zzbj(22, this.zza());
    }

    public final List zzz() throws RemoteException {
        Parcel parcel = this.zzbi(23, this.zza());
        ArrayList arrayList = zzadl.zzg((Parcel)parcel);
        parcel.recycle();
        return arrayList;
    }
}
