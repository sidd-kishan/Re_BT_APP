/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.RemoteException
 *  com.google.android.gms.dynamic.IObjectWrapper
 *  com.google.android.gms.internal.ads.zzadj
 *  com.google.android.gms.internal.ads.zzadl
 *  com.google.android.gms.internal.ads.zzbdl
 *  com.google.android.gms.internal.ads.zzbfh
 *  com.google.android.gms.internal.ads.zzbfj
 *  com.google.android.gms.internal.ads.zzbfl
 *  com.google.android.gms.internal.ads.zzbfn
 *  com.google.android.gms.internal.ads.zzbfx
 *  com.google.android.gms.internal.ads.zzbgc
 *  com.google.android.gms.internal.ads.zzbge
 *  com.google.android.gms.internal.ads.zzbmk
 *  com.google.android.gms.internal.ads.zzbml
 *  com.google.android.gms.internal.ads.zzbmq
 *  com.google.android.gms.internal.ads.zzbmr
 *  com.google.android.gms.internal.ads.zzbqm
 *  com.google.android.gms.internal.ads.zzbqo
 *  com.google.android.gms.internal.ads.zzbqp
 *  com.google.android.gms.internal.ads.zzbvg
 *  com.google.android.gms.internal.ads.zzbzd
 *  com.google.android.gms.internal.ads.zzbze
 *  com.google.android.gms.internal.ads.zzbzp
 *  com.google.android.gms.internal.ads.zzbzq
 *  com.google.android.gms.internal.ads.zzccc
 *  com.google.android.gms.internal.ads.zzccr
 *  com.google.android.gms.internal.ads.zzccs
 *  com.google.android.gms.internal.ads.zzcfm
 *  com.google.android.gms.internal.ads.zzcfn
 */
package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzadj;
import com.google.android.gms.internal.ads.zzadl;
import com.google.android.gms.internal.ads.zzbdl;
import com.google.android.gms.internal.ads.zzbfh;
import com.google.android.gms.internal.ads.zzbfj;
import com.google.android.gms.internal.ads.zzbfl;
import com.google.android.gms.internal.ads.zzbfn;
import com.google.android.gms.internal.ads.zzbfx;
import com.google.android.gms.internal.ads.zzbgc;
import com.google.android.gms.internal.ads.zzbge;
import com.google.android.gms.internal.ads.zzbmk;
import com.google.android.gms.internal.ads.zzbml;
import com.google.android.gms.internal.ads.zzbmq;
import com.google.android.gms.internal.ads.zzbmr;
import com.google.android.gms.internal.ads.zzbqm;
import com.google.android.gms.internal.ads.zzbqo;
import com.google.android.gms.internal.ads.zzbqp;
import com.google.android.gms.internal.ads.zzbvg;
import com.google.android.gms.internal.ads.zzbzd;
import com.google.android.gms.internal.ads.zzbze;
import com.google.android.gms.internal.ads.zzbzp;
import com.google.android.gms.internal.ads.zzbzq;
import com.google.android.gms.internal.ads.zzccc;
import com.google.android.gms.internal.ads.zzccr;
import com.google.android.gms.internal.ads.zzccs;
import com.google.android.gms.internal.ads.zzcfm;
import com.google.android.gms.internal.ads.zzcfn;

public final class zzbfv
extends zzadj
implements zzbfx {
    zzbfv(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IClientApi");
    }

    public final zzbfn zzb(IObjectWrapper object, zzbdl zzbdl2, String string, zzbvg zzbvg2, int n) throws RemoteException {
        Parcel parcel = this.zza();
        zzadl.zzf((Parcel)parcel, (IInterface)object);
        zzadl.zzd((Parcel)parcel, (Parcelable)zzbdl2);
        parcel.writeString(string);
        zzadl.zzf((Parcel)parcel, (IInterface)zzbvg2);
        parcel.writeInt(213806000);
        zzbdl2 = this.zzbi(1, parcel);
        string = zzbdl2.readStrongBinder();
        object = string == null ? null : ((object = string.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager")) instanceof zzbfn ? (zzbfn)object : new zzbfl((IBinder)string));
        zzbdl2.recycle();
        return object;
    }

    public final zzbfn zzc(IObjectWrapper object, zzbdl zzbdl2, String string, zzbvg zzbvg2, int n) throws RemoteException {
        Parcel parcel = this.zza();
        zzadl.zzf((Parcel)parcel, (IInterface)object);
        zzadl.zzd((Parcel)parcel, (Parcelable)zzbdl2);
        parcel.writeString(string);
        zzadl.zzf((Parcel)parcel, (IInterface)zzbvg2);
        parcel.writeInt(213806000);
        zzbdl2 = this.zzbi(2, parcel);
        string = zzbdl2.readStrongBinder();
        object = string == null ? null : ((object = string.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager")) instanceof zzbfn ? (zzbfn)object : new zzbfl((IBinder)string));
        zzbdl2.recycle();
        return object;
    }

    public final zzbfj zzd(IObjectWrapper object, String string, zzbvg zzbvg2, int n) throws RemoteException {
        Parcel parcel = this.zza();
        zzadl.zzf((Parcel)parcel, (IInterface)object);
        parcel.writeString(string);
        zzadl.zzf((Parcel)parcel, (IInterface)zzbvg2);
        parcel.writeInt(213806000);
        string = this.zzbi(3, parcel);
        object = string.readStrongBinder();
        object = object == null ? null : ((zzbvg2 = object.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilder")) instanceof zzbfj ? (zzbfj)zzbvg2 : new zzbfh((IBinder)object));
        string.recycle();
        return object;
    }

    public final zzbml zze(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) throws RemoteException {
        Parcel parcel = this.zza();
        zzadl.zzf((Parcel)parcel, (IInterface)iObjectWrapper);
        zzadl.zzf((Parcel)parcel, (IInterface)iObjectWrapper2);
        iObjectWrapper2 = this.zzbi(5, parcel);
        iObjectWrapper = zzbmk.zzby((IBinder)iObjectWrapper2.readStrongBinder());
        iObjectWrapper2.recycle();
        return iObjectWrapper;
    }

    public final zzccc zzf(IObjectWrapper iObjectWrapper, zzbvg zzbvg2, int n) throws RemoteException {
        throw null;
    }

    public final zzbzq zzg(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcel = this.zza();
        zzadl.zzf((Parcel)parcel, (IInterface)iObjectWrapper);
        parcel = this.zzbi(8, parcel);
        iObjectWrapper = zzbzp.zzF((IBinder)parcel.readStrongBinder());
        parcel.recycle();
        return iObjectWrapper;
    }

    public final zzbge zzh(IObjectWrapper object, int n) throws RemoteException {
        Parcel parcel = this.zza();
        zzadl.zzf((Parcel)parcel, (IInterface)object);
        parcel.writeInt(213806000);
        parcel = this.zzbi(9, parcel);
        IBinder iBinder = parcel.readStrongBinder();
        object = iBinder == null ? null : ((object = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IMobileAdsSettingManager")) instanceof zzbge ? (zzbge)object : new zzbgc(iBinder));
        parcel.recycle();
        return object;
    }

    public final zzbfn zzi(IObjectWrapper object, zzbdl zzbdl2, String string, int n) throws RemoteException {
        Parcel parcel = this.zza();
        zzadl.zzf((Parcel)parcel, (IInterface)object);
        zzadl.zzd((Parcel)parcel, (Parcelable)zzbdl2);
        parcel.writeString(string);
        parcel.writeInt(213806000);
        zzbdl2 = this.zzbi(10, parcel);
        object = zzbdl2.readStrongBinder();
        object = object == null ? null : ((string = object.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager")) instanceof zzbfn ? (zzbfn)string : new zzbfl((IBinder)object));
        zzbdl2.recycle();
        return object;
    }

    public final zzbmr zzj(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) throws RemoteException {
        Parcel parcel = this.zza();
        zzadl.zzf((Parcel)parcel, (IInterface)iObjectWrapper);
        zzadl.zzf((Parcel)parcel, (IInterface)iObjectWrapper2);
        zzadl.zzf((Parcel)parcel, (IInterface)iObjectWrapper3);
        iObjectWrapper2 = this.zzbi(11, parcel);
        iObjectWrapper = zzbmq.zze((IBinder)iObjectWrapper2.readStrongBinder());
        iObjectWrapper2.recycle();
        return iObjectWrapper;
    }

    public final zzccs zzk(IObjectWrapper iObjectWrapper, String string, zzbvg zzbvg2, int n) throws RemoteException {
        Parcel parcel = this.zza();
        zzadl.zzf((Parcel)parcel, (IInterface)iObjectWrapper);
        parcel.writeString(string);
        zzadl.zzf((Parcel)parcel, (IInterface)zzbvg2);
        parcel.writeInt(213806000);
        iObjectWrapper = this.zzbi(12, parcel);
        string = zzccr.zzq((IBinder)iObjectWrapper.readStrongBinder());
        iObjectWrapper.recycle();
        return string;
    }

    public final zzbfn zzl(IObjectWrapper object, zzbdl zzbdl2, String string, zzbvg zzbvg2, int n) throws RemoteException {
        Parcel parcel = this.zza();
        zzadl.zzf((Parcel)parcel, (IInterface)object);
        zzadl.zzd((Parcel)parcel, (Parcelable)zzbdl2);
        parcel.writeString(string);
        zzadl.zzf((Parcel)parcel, (IInterface)zzbvg2);
        parcel.writeInt(213806000);
        zzbdl2 = this.zzbi(13, parcel);
        string = zzbdl2.readStrongBinder();
        object = string == null ? null : ((object = string.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager")) instanceof zzbfn ? (zzbfn)object : new zzbfl((IBinder)string));
        zzbdl2.recycle();
        return object;
    }

    public final zzcfn zzm(IObjectWrapper iObjectWrapper, zzbvg zzbvg2, int n) throws RemoteException {
        Parcel parcel = this.zza();
        zzadl.zzf((Parcel)parcel, (IInterface)iObjectWrapper);
        zzadl.zzf((Parcel)parcel, (IInterface)zzbvg2);
        parcel.writeInt(213806000);
        zzbvg2 = this.zzbi(14, parcel);
        iObjectWrapper = zzcfm.zzb((IBinder)zzbvg2.readStrongBinder());
        zzbvg2.recycle();
        return iObjectWrapper;
    }

    public final zzbze zzn(IObjectWrapper iObjectWrapper, zzbvg zzbvg2, int n) throws RemoteException {
        Parcel parcel = this.zza();
        zzadl.zzf((Parcel)parcel, (IInterface)iObjectWrapper);
        zzadl.zzf((Parcel)parcel, (IInterface)zzbvg2);
        parcel.writeInt(213806000);
        iObjectWrapper = this.zzbi(15, parcel);
        zzbvg2 = zzbzd.zzb((IBinder)iObjectWrapper.readStrongBinder());
        iObjectWrapper.recycle();
        return zzbvg2;
    }

    public final zzbqp zzo(IObjectWrapper iObjectWrapper, zzbvg zzbvg2, int n, zzbqm zzbqm2) throws RemoteException {
        Parcel parcel = this.zza();
        zzadl.zzf((Parcel)parcel, (IInterface)iObjectWrapper);
        zzadl.zzf((Parcel)parcel, (IInterface)zzbvg2);
        parcel.writeInt(213806000);
        zzadl.zzf((Parcel)parcel, (IInterface)zzbqm2);
        iObjectWrapper = this.zzbi(16, parcel);
        zzbvg2 = zzbqo.zzb((IBinder)iObjectWrapper.readStrongBinder());
        iObjectWrapper.recycle();
        return zzbvg2;
    }
}
