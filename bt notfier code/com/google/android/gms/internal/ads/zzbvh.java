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
 *  com.google.android.gms.internal.ads.zzbdg
 *  com.google.android.gms.internal.ads.zzbdl
 *  com.google.android.gms.internal.ads.zzbhb
 *  com.google.android.gms.internal.ads.zzbhc
 *  com.google.android.gms.internal.ads.zzblv
 *  com.google.android.gms.internal.ads.zzbnb
 *  com.google.android.gms.internal.ads.zzbrp
 *  com.google.android.gms.internal.ads.zzbrv
 *  com.google.android.gms.internal.ads.zzbvj
 *  com.google.android.gms.internal.ads.zzbvm
 *  com.google.android.gms.internal.ads.zzbvn
 *  com.google.android.gms.internal.ads.zzbvp
 *  com.google.android.gms.internal.ads.zzbvr
 *  com.google.android.gms.internal.ads.zzbvs
 *  com.google.android.gms.internal.ads.zzbvt
 *  com.google.android.gms.internal.ads.zzbvv
 *  com.google.android.gms.internal.ads.zzbya
 *  com.google.android.gms.internal.ads.zzcck
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
import com.google.android.gms.internal.ads.zzbdg;
import com.google.android.gms.internal.ads.zzbdl;
import com.google.android.gms.internal.ads.zzbhb;
import com.google.android.gms.internal.ads.zzbhc;
import com.google.android.gms.internal.ads.zzblv;
import com.google.android.gms.internal.ads.zzbnb;
import com.google.android.gms.internal.ads.zzbrp;
import com.google.android.gms.internal.ads.zzbrv;
import com.google.android.gms.internal.ads.zzbvj;
import com.google.android.gms.internal.ads.zzbvm;
import com.google.android.gms.internal.ads.zzbvn;
import com.google.android.gms.internal.ads.zzbvp;
import com.google.android.gms.internal.ads.zzbvr;
import com.google.android.gms.internal.ads.zzbvs;
import com.google.android.gms.internal.ads.zzbvt;
import com.google.android.gms.internal.ads.zzbvv;
import com.google.android.gms.internal.ads.zzbya;
import com.google.android.gms.internal.ads.zzcck;
import java.util.List;

public final class zzbvh
extends zzadj
implements zzbvj {
    zzbvh(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
    }

    public final void zzA(boolean bl) throws RemoteException {
        Parcel parcel = this.zza();
        zzadl.zzb((Parcel)parcel, (boolean)bl);
        this.zzbj(25, parcel);
    }

    public final zzbhc zzB() throws RemoteException {
        Parcel parcel = this.zzbi(26, this.zza());
        zzbhc zzbhc2 = zzbhb.zzb((IBinder)parcel.readStrongBinder());
        parcel.recycle();
        return zzbhc2;
    }

    public final zzbvv zzC() throws RemoteException {
        IInterface iInterface;
        Parcel parcel = this.zzbi(27, this.zza());
        Object object = parcel.readStrongBinder();
        object = object == null ? null : ((iInterface = object.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IUnifiedNativeAdMapper")) instanceof zzbvv ? (zzbvv)iInterface : new zzbvt(object));
        parcel.recycle();
        return object;
    }

    public final void zzD(IObjectWrapper iObjectWrapper, zzbdg zzbdg2, String string, zzbvm zzbvm2) throws RemoteException {
        Parcel parcel = this.zza();
        zzadl.zzf((Parcel)parcel, (IInterface)iObjectWrapper);
        zzadl.zzd((Parcel)parcel, (Parcelable)zzbdg2);
        parcel.writeString(string);
        zzadl.zzf((Parcel)parcel, (IInterface)zzbvm2);
        this.zzbj(28, parcel);
    }

    public final void zzE(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcel = this.zza();
        zzadl.zzf((Parcel)parcel, (IInterface)iObjectWrapper);
        this.zzbj(30, parcel);
    }

    public final void zzF(IObjectWrapper iObjectWrapper, zzbrp zzbrp2, List<zzbrv> list) throws RemoteException {
        Parcel parcel = this.zza();
        zzadl.zzf((Parcel)parcel, (IInterface)iObjectWrapper);
        zzadl.zzf((Parcel)parcel, (IInterface)zzbrp2);
        parcel.writeTypedList(list);
        this.zzbj(31, parcel);
    }

    public final void zzG(IObjectWrapper iObjectWrapper, zzbdg zzbdg2, String string, zzbvm zzbvm2) throws RemoteException {
        Parcel parcel = this.zza();
        zzadl.zzf((Parcel)parcel, (IInterface)iObjectWrapper);
        zzadl.zzd((Parcel)parcel, (Parcelable)zzbdg2);
        parcel.writeString(string);
        zzadl.zzf((Parcel)parcel, (IInterface)zzbvm2);
        this.zzbj(32, parcel);
    }

    public final zzbya zzH() throws RemoteException {
        Parcel parcel = this.zzbi(33, this.zza());
        zzbya zzbya2 = (zzbya)zzadl.zzc((Parcel)parcel, (Parcelable.Creator)zzbya.CREATOR);
        parcel.recycle();
        return zzbya2;
    }

    public final zzbya zzI() throws RemoteException {
        Parcel parcel = this.zzbi(34, this.zza());
        zzbya zzbya2 = (zzbya)zzadl.zzc((Parcel)parcel, (Parcelable.Creator)zzbya.CREATOR);
        parcel.recycle();
        return zzbya2;
    }

    public final void zzJ(IObjectWrapper iObjectWrapper, zzbdl zzbdl2, zzbdg zzbdg2, String string, String string2, zzbvm zzbvm2) throws RemoteException {
        Parcel parcel = this.zza();
        zzadl.zzf((Parcel)parcel, (IInterface)iObjectWrapper);
        zzadl.zzd((Parcel)parcel, (Parcelable)zzbdl2);
        zzadl.zzd((Parcel)parcel, (Parcelable)zzbdg2);
        parcel.writeString(string);
        parcel.writeString(string2);
        zzadl.zzf((Parcel)parcel, (IInterface)zzbvm2);
        this.zzbj(35, parcel);
    }

    public final zzbvp zzK() throws RemoteException {
        Object object;
        Parcel parcel = this.zzbi(36, this.zza());
        IBinder iBinder = parcel.readStrongBinder();
        object = iBinder == null ? null : ((object = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationInterscrollerAd")) instanceof zzbvp ? (zzbvp)object : new zzbvn(iBinder));
        parcel.recycle();
        return object;
    }

    public final void zzL(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcel = this.zza();
        zzadl.zzf((Parcel)parcel, (IInterface)iObjectWrapper);
        this.zzbj(37, parcel);
    }

    public final zzbvr zzM() throws RemoteException {
        Object object;
        Parcel parcel = this.zzbi(15, this.zza());
        IBinder iBinder = parcel.readStrongBinder();
        object = iBinder == null ? null : ((object = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper")) instanceof zzbvr ? (zzbvr)object : new zzbvr(iBinder));
        parcel.recycle();
        return object;
    }

    public final zzbvs zzN() throws RemoteException {
        IInterface iInterface;
        Parcel parcel = this.zzbi(16, this.zza());
        Object object = parcel.readStrongBinder();
        object = object == null ? null : ((iInterface = object.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.INativeContentAdMapper")) instanceof zzbvs ? (zzbvs)iInterface : new zzbvs(object));
        parcel.recycle();
        return object;
    }

    public final void zze(IObjectWrapper iObjectWrapper, zzbdl zzbdl2, zzbdg zzbdg2, String string, zzbvm zzbvm2) throws RemoteException {
        throw null;
    }

    public final IObjectWrapper zzf() throws RemoteException {
        Parcel parcel = this.zzbi(2, this.zza());
        IObjectWrapper iObjectWrapper = IObjectWrapper.Stub.asInterface((IBinder)parcel.readStrongBinder());
        parcel.recycle();
        return iObjectWrapper;
    }

    public final void zzg(IObjectWrapper iObjectWrapper, zzbdg zzbdg2, String string, zzbvm zzbvm2) throws RemoteException {
        throw null;
    }

    public final void zzh() throws RemoteException {
        this.zzbj(4, this.zza());
    }

    public final void zzi() throws RemoteException {
        this.zzbj(5, this.zza());
    }

    public final void zzj(IObjectWrapper iObjectWrapper, zzbdl zzbdl2, zzbdg zzbdg2, String string, String string2, zzbvm zzbvm2) throws RemoteException {
        Parcel parcel = this.zza();
        zzadl.zzf((Parcel)parcel, (IInterface)iObjectWrapper);
        zzadl.zzd((Parcel)parcel, (Parcelable)zzbdl2);
        zzadl.zzd((Parcel)parcel, (Parcelable)zzbdg2);
        parcel.writeString(string);
        parcel.writeString(string2);
        zzadl.zzf((Parcel)parcel, (IInterface)zzbvm2);
        this.zzbj(6, parcel);
    }

    public final void zzk(IObjectWrapper iObjectWrapper, zzbdg zzbdg2, String string, String string2, zzbvm zzbvm2) throws RemoteException {
        Parcel parcel = this.zza();
        zzadl.zzf((Parcel)parcel, (IInterface)iObjectWrapper);
        zzadl.zzd((Parcel)parcel, (Parcelable)zzbdg2);
        parcel.writeString(string);
        parcel.writeString(string2);
        zzadl.zzf((Parcel)parcel, (IInterface)zzbvm2);
        this.zzbj(7, parcel);
    }

    public final void zzl() throws RemoteException {
        this.zzbj(8, this.zza());
    }

    public final void zzm() throws RemoteException {
        this.zzbj(9, this.zza());
    }

    public final void zzn(IObjectWrapper iObjectWrapper, zzbdg zzbdg2, String string, zzcck zzcck2, String string2) throws RemoteException {
        string = this.zza();
        zzadl.zzf((Parcel)string, (IInterface)iObjectWrapper);
        zzadl.zzd((Parcel)string, (Parcelable)zzbdg2);
        string.writeString(null);
        zzadl.zzf((Parcel)string, (IInterface)zzcck2);
        string.writeString(string2);
        this.zzbj(10, (Parcel)string);
    }

    public final void zzo(zzbdg zzbdg2, String string) throws RemoteException {
        Parcel parcel = this.zza();
        zzadl.zzd((Parcel)parcel, (Parcelable)zzbdg2);
        parcel.writeString(string);
        this.zzbj(11, parcel);
    }

    public final void zzp() throws RemoteException {
        this.zzbj(12, this.zza());
    }

    public final boolean zzq() throws RemoteException {
        Parcel parcel = this.zzbi(13, this.zza());
        boolean bl = zzadl.zza((Parcel)parcel);
        parcel.recycle();
        return bl;
    }

    public final void zzr(IObjectWrapper iObjectWrapper, zzbdg zzbdg2, String string, String string2, zzbvm zzbvm2, zzblv zzblv2, List<String> list) throws RemoteException {
        Parcel parcel = this.zza();
        zzadl.zzf((Parcel)parcel, (IInterface)iObjectWrapper);
        zzadl.zzd((Parcel)parcel, (Parcelable)zzbdg2);
        parcel.writeString(string);
        parcel.writeString(string2);
        zzadl.zzf((Parcel)parcel, (IInterface)zzbvm2);
        zzadl.zzd((Parcel)parcel, (Parcelable)zzblv2);
        parcel.writeStringList(list);
        this.zzbj(14, parcel);
    }

    public final Bundle zzs() throws RemoteException {
        throw null;
    }

    public final Bundle zzt() throws RemoteException {
        throw null;
    }

    public final Bundle zzu() throws RemoteException {
        throw null;
    }

    public final void zzv(zzbdg zzbdg2, String string, String string2) throws RemoteException {
        throw null;
    }

    public final void zzw(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcel = this.zza();
        zzadl.zzf((Parcel)parcel, (IInterface)iObjectWrapper);
        this.zzbj(21, parcel);
    }

    public final boolean zzx() throws RemoteException {
        Parcel parcel = this.zzbi(22, this.zza());
        boolean bl = zzadl.zza((Parcel)parcel);
        parcel.recycle();
        return bl;
    }

    public final void zzy(IObjectWrapper iObjectWrapper, zzcck zzcck2, List<String> list) throws RemoteException {
        Parcel parcel = this.zza();
        zzadl.zzf((Parcel)parcel, (IInterface)iObjectWrapper);
        zzadl.zzf((Parcel)parcel, (IInterface)zzcck2);
        parcel.writeStringList(list);
        this.zzbj(23, parcel);
    }

    public final zzbnb zzz() throws RemoteException {
        throw null;
    }
}
