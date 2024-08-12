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
 *  com.google.android.gms.internal.ads.zzbge
 *  com.google.android.gms.internal.ads.zzbgq
 *  com.google.android.gms.internal.ads.zzbim
 *  com.google.android.gms.internal.ads.zzbrl
 *  com.google.android.gms.internal.ads.zzbrs
 *  com.google.android.gms.internal.ads.zzbvg
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
import com.google.android.gms.internal.ads.zzbge;
import com.google.android.gms.internal.ads.zzbgq;
import com.google.android.gms.internal.ads.zzbim;
import com.google.android.gms.internal.ads.zzbrl;
import com.google.android.gms.internal.ads.zzbrs;
import com.google.android.gms.internal.ads.zzbvg;
import java.util.ArrayList;
import java.util.List;

public final class zzbgc
extends zzadj
implements zzbge {
    zzbgc(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IMobileAdsSettingManager");
    }

    public final void zze() throws RemoteException {
        this.zzbj(1, this.zza());
    }

    public final void zzf(float f) throws RemoteException {
        Parcel parcel = this.zza();
        parcel.writeFloat(f);
        this.zzbj(2, parcel);
    }

    public final void zzg(String string) throws RemoteException {
        throw null;
    }

    public final void zzh(boolean bl) throws RemoteException {
        Parcel parcel = this.zza();
        zzadl.zzb((Parcel)parcel, (boolean)bl);
        this.zzbj(4, parcel);
    }

    public final void zzi(IObjectWrapper iObjectWrapper, String string) throws RemoteException {
        Parcel parcel = this.zza();
        zzadl.zzf((Parcel)parcel, (IInterface)iObjectWrapper);
        parcel.writeString(string);
        this.zzbj(5, parcel);
    }

    public final void zzj(String string, IObjectWrapper iObjectWrapper) throws RemoteException {
        string = this.zza();
        string.writeString(null);
        zzadl.zzf((Parcel)string, (IInterface)iObjectWrapper);
        this.zzbj(6, (Parcel)string);
    }

    public final float zzk() throws RemoteException {
        Parcel parcel = this.zzbi(7, this.zza());
        float f = parcel.readFloat();
        parcel.recycle();
        return f;
    }

    public final boolean zzl() throws RemoteException {
        Parcel parcel = this.zzbi(8, this.zza());
        boolean bl = zzadl.zza((Parcel)parcel);
        parcel.recycle();
        return bl;
    }

    public final String zzm() throws RemoteException {
        Parcel parcel = this.zzbi(9, this.zza());
        String string = parcel.readString();
        parcel.recycle();
        return string;
    }

    public final void zzn(String string) throws RemoteException {
        Parcel parcel = this.zza();
        parcel.writeString(string);
        this.zzbj(10, parcel);
    }

    public final void zzo(zzbvg zzbvg2) throws RemoteException {
        Parcel parcel = this.zza();
        zzadl.zzf((Parcel)parcel, (IInterface)zzbvg2);
        this.zzbj(11, parcel);
    }

    public final void zzp(zzbrs zzbrs2) throws RemoteException {
        Parcel parcel = this.zza();
        zzadl.zzf((Parcel)parcel, (IInterface)zzbrs2);
        this.zzbj(12, parcel);
    }

    public final List<zzbrl> zzq() throws RemoteException {
        Parcel parcel = this.zzbi(13, this.zza());
        ArrayList arrayList = parcel.createTypedArrayList(zzbrl.CREATOR);
        parcel.recycle();
        return arrayList;
    }

    public final void zzr(zzbim zzbim2) throws RemoteException {
        Parcel parcel = this.zza();
        zzadl.zzd((Parcel)parcel, (Parcelable)zzbim2);
        this.zzbj(14, parcel);
    }

    public final void zzs() throws RemoteException {
        this.zzbj(15, this.zza());
    }

    public final void zzt(zzbgq zzbgq2) throws RemoteException {
        Parcel parcel = this.zza();
        zzadl.zzf((Parcel)parcel, (IInterface)zzbgq2);
        this.zzbj(16, parcel);
    }
}
