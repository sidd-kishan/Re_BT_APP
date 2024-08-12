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
 *  com.google.android.gms.internal.ads.zzaxz
 *  com.google.android.gms.internal.ads.zzbdg
 *  com.google.android.gms.internal.ads.zzbdl
 *  com.google.android.gms.internal.ads.zzbdr
 *  com.google.android.gms.internal.ads.zzbex
 *  com.google.android.gms.internal.ads.zzbey
 *  com.google.android.gms.internal.ads.zzbfa
 *  com.google.android.gms.internal.ads.zzbfd
 *  com.google.android.gms.internal.ads.zzbfn
 *  com.google.android.gms.internal.ads.zzbfr
 *  com.google.android.gms.internal.ads.zzbfs
 *  com.google.android.gms.internal.ads.zzbfu
 *  com.google.android.gms.internal.ads.zzbfy
 *  com.google.android.gms.internal.ads.zzbgb
 *  com.google.android.gms.internal.ads.zzbgw
 *  com.google.android.gms.internal.ads.zzbgx
 *  com.google.android.gms.internal.ads.zzbgz
 *  com.google.android.gms.internal.ads.zzbha
 *  com.google.android.gms.internal.ads.zzbhc
 *  com.google.android.gms.internal.ads.zzbhg
 *  com.google.android.gms.internal.ads.zzbis
 *  com.google.android.gms.internal.ads.zzbkg
 *  com.google.android.gms.internal.ads.zzbzz
 *  com.google.android.gms.internal.ads.zzcac
 *  com.google.android.gms.internal.ads.zzccf
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
import com.google.android.gms.internal.ads.zzaxz;
import com.google.android.gms.internal.ads.zzbdg;
import com.google.android.gms.internal.ads.zzbdl;
import com.google.android.gms.internal.ads.zzbdr;
import com.google.android.gms.internal.ads.zzbex;
import com.google.android.gms.internal.ads.zzbey;
import com.google.android.gms.internal.ads.zzbfa;
import com.google.android.gms.internal.ads.zzbfd;
import com.google.android.gms.internal.ads.zzbfn;
import com.google.android.gms.internal.ads.zzbfr;
import com.google.android.gms.internal.ads.zzbfs;
import com.google.android.gms.internal.ads.zzbfu;
import com.google.android.gms.internal.ads.zzbfy;
import com.google.android.gms.internal.ads.zzbgb;
import com.google.android.gms.internal.ads.zzbgw;
import com.google.android.gms.internal.ads.zzbgx;
import com.google.android.gms.internal.ads.zzbgz;
import com.google.android.gms.internal.ads.zzbha;
import com.google.android.gms.internal.ads.zzbhc;
import com.google.android.gms.internal.ads.zzbhg;
import com.google.android.gms.internal.ads.zzbis;
import com.google.android.gms.internal.ads.zzbkg;
import com.google.android.gms.internal.ads.zzbzz;
import com.google.android.gms.internal.ads.zzcac;
import com.google.android.gms.internal.ads.zzccf;

public final class zzbfl
extends zzadj
implements zzbfn {
    zzbfl(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdManager");
    }

    public final zzbgz zzA() throws RemoteException {
        IInterface iInterface;
        Parcel parcel = this.zzbi(41, this.zza());
        Object object = parcel.readStrongBinder();
        object = object == null ? null : ((iInterface = object.queryLocalInterface("com.google.android.gms.ads.internal.client.IResponseInfo")) instanceof zzbgz ? (zzbgz)iInterface : new zzbgx(object));
        parcel.recycle();
        return object;
    }

    public final String zzB() throws RemoteException {
        Parcel parcel = this.zzbi(31, this.zza());
        String string = parcel.readString();
        parcel.recycle();
        return string;
    }

    public final zzbfu zzC() throws RemoteException {
        IInterface iInterface;
        Parcel parcel = this.zzbi(32, this.zza());
        Object object = parcel.readStrongBinder();
        object = object == null ? null : ((iInterface = object.queryLocalInterface("com.google.android.gms.ads.internal.client.IAppEventListener")) instanceof zzbfu ? (zzbfu)iInterface : new zzbfs(object));
        parcel.recycle();
        return object;
    }

    public final zzbfa zzD() throws RemoteException {
        IInterface iInterface;
        Parcel parcel = this.zzbi(33, this.zza());
        Object object = parcel.readStrongBinder();
        object = object == null ? null : ((iInterface = object.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdListener")) instanceof zzbfa ? (zzbfa)iInterface : new zzbey(object));
        parcel.recycle();
        return object;
    }

    public final void zzE(zzbkg zzbkg2) throws RemoteException {
        throw null;
    }

    public final void zzF(zzbex zzbex2) throws RemoteException {
        Parcel parcel = this.zza();
        zzadl.zzf((Parcel)parcel, (IInterface)zzbex2);
        this.zzbj(20, parcel);
    }

    public final void zzG(boolean bl) throws RemoteException {
        Parcel parcel = this.zza();
        zzadl.zzb((Parcel)parcel, (boolean)bl);
        this.zzbj(22, parcel);
    }

    public final boolean zzH() throws RemoteException {
        Parcel parcel = this.zzbi(23, this.zza());
        boolean bl = zzadl.zza((Parcel)parcel);
        parcel.recycle();
        return bl;
    }

    public final void zzI(zzccf zzccf2) throws RemoteException {
        throw null;
    }

    public final void zzJ(String string) throws RemoteException {
        throw null;
    }

    public final void zzK(String string) throws RemoteException {
        throw null;
    }

    public final zzbhc zzL() throws RemoteException {
        Object object;
        Parcel parcel = this.zzbi(26, this.zza());
        IBinder iBinder = parcel.readStrongBinder();
        object = iBinder == null ? null : ((object = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IVideoController")) instanceof zzbhc ? (zzbhc)object : new zzbha(iBinder));
        parcel.recycle();
        return object;
    }

    public final void zzM(zzbis zzbis2) throws RemoteException {
        Parcel parcel = this.zza();
        zzadl.zzd((Parcel)parcel, (Parcelable)zzbis2);
        this.zzbj(29, parcel);
    }

    public final void zzN(zzbhg zzbhg2) throws RemoteException {
        throw null;
    }

    public final void zzO(zzbdr zzbdr2) throws RemoteException {
        Parcel parcel = this.zza();
        zzadl.zzd((Parcel)parcel, (Parcelable)zzbdr2);
        this.zzbj(39, parcel);
    }

    public final void zzP(zzaxz zzaxz2) throws RemoteException {
        Parcel parcel = this.zza();
        zzadl.zzf((Parcel)parcel, (IInterface)zzaxz2);
        this.zzbj(40, parcel);
    }

    public final void zzQ(boolean bl) throws RemoteException {
        Parcel parcel = this.zza();
        zzadl.zzb((Parcel)parcel, (boolean)bl);
        this.zzbj(34, parcel);
    }

    public final void zzX(zzbgw zzbgw2) throws RemoteException {
        Parcel parcel = this.zza();
        zzadl.zzf((Parcel)parcel, (IInterface)zzbgw2);
        this.zzbj(42, parcel);
    }

    public final void zzY(zzbdg zzbdg2, zzbfd zzbfd2) throws RemoteException {
        Parcel parcel = this.zza();
        zzadl.zzd((Parcel)parcel, (Parcelable)zzbdg2);
        zzadl.zzf((Parcel)parcel, (IInterface)zzbfd2);
        this.zzbj(43, parcel);
    }

    public final void zzZ(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcel = this.zza();
        zzadl.zzf((Parcel)parcel, (IInterface)iObjectWrapper);
        this.zzbj(44, parcel);
    }

    public final void zzaa(zzbgb zzbgb2) throws RemoteException {
        Parcel parcel = this.zza();
        zzadl.zzf((Parcel)parcel, (IInterface)zzbgb2);
        this.zzbj(45, parcel);
    }

    public final void zzab(zzbfy zzbfy2) throws RemoteException {
        throw null;
    }

    public final IObjectWrapper zzi() throws RemoteException {
        Parcel parcel = this.zzbi(1, this.zza());
        IObjectWrapper iObjectWrapper = IObjectWrapper.Stub.asInterface((IBinder)parcel.readStrongBinder());
        parcel.recycle();
        return iObjectWrapper;
    }

    public final void zzj() throws RemoteException {
        this.zzbj(2, this.zza());
    }

    public final boolean zzk() throws RemoteException {
        throw null;
    }

    public final boolean zzl(zzbdg zzbdg2) throws RemoteException {
        Parcel parcel = this.zza();
        zzadl.zzd((Parcel)parcel, (Parcelable)zzbdg2);
        zzbdg2 = this.zzbi(4, parcel);
        boolean bl = zzadl.zza((Parcel)zzbdg2);
        zzbdg2.recycle();
        return bl;
    }

    public final void zzm() throws RemoteException {
        this.zzbj(5, this.zza());
    }

    public final void zzn() throws RemoteException {
        this.zzbj(6, this.zza());
    }

    public final void zzo(zzbfa zzbfa2) throws RemoteException {
        Parcel parcel = this.zza();
        zzadl.zzf((Parcel)parcel, (IInterface)zzbfa2);
        this.zzbj(7, parcel);
    }

    public final void zzp(zzbfu zzbfu2) throws RemoteException {
        Parcel parcel = this.zza();
        zzadl.zzf((Parcel)parcel, (IInterface)zzbfu2);
        this.zzbj(8, parcel);
    }

    public final void zzq(zzbfr zzbfr2) throws RemoteException {
        throw null;
    }

    public final Bundle zzr() throws RemoteException {
        throw null;
    }

    public final void zzs() throws RemoteException {
        throw null;
    }

    public final void zzt() throws RemoteException {
        this.zzbj(11, this.zza());
    }

    public final zzbdl zzu() throws RemoteException {
        Parcel parcel = this.zzbi(12, this.zza());
        zzbdl zzbdl2 = (zzbdl)zzadl.zzc((Parcel)parcel, (Parcelable.Creator)zzbdl.CREATOR);
        parcel.recycle();
        return zzbdl2;
    }

    public final void zzv(zzbdl zzbdl2) throws RemoteException {
        Parcel parcel = this.zza();
        zzadl.zzd((Parcel)parcel, (Parcelable)zzbdl2);
        this.zzbj(13, parcel);
    }

    public final void zzw(zzbzz zzbzz2) throws RemoteException {
        throw null;
    }

    public final void zzx(zzcac zzcac2, String string) throws RemoteException {
        throw null;
    }

    public final String zzy() throws RemoteException {
        throw null;
    }

    public final String zzz() throws RemoteException {
        throw null;
    }
}
