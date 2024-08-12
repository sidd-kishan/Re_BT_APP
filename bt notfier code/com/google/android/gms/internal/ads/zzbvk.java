/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.RemoteException
 *  com.google.android.gms.internal.ads.zzadj
 *  com.google.android.gms.internal.ads.zzadl
 *  com.google.android.gms.internal.ads.zzbcz
 *  com.google.android.gms.internal.ads.zzbnb
 *  com.google.android.gms.internal.ads.zzbvm
 *  com.google.android.gms.internal.ads.zzccl
 *  com.google.android.gms.internal.ads.zzccp
 */
package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzadj;
import com.google.android.gms.internal.ads.zzadl;
import com.google.android.gms.internal.ads.zzbcz;
import com.google.android.gms.internal.ads.zzbnb;
import com.google.android.gms.internal.ads.zzbvm;
import com.google.android.gms.internal.ads.zzccl;
import com.google.android.gms.internal.ads.zzccp;

public final class zzbvk
extends zzadj
implements zzbvm {
    zzbvk(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
    }

    public final void zze() throws RemoteException {
        this.zzbj(1, this.zza());
    }

    public final void zzf() throws RemoteException {
        this.zzbj(2, this.zza());
    }

    public final void zzg(int n) throws RemoteException {
        Parcel parcel = this.zza();
        parcel.writeInt(n);
        this.zzbj(3, parcel);
    }

    public final void zzh() throws RemoteException {
        this.zzbj(4, this.zza());
    }

    public final void zzi() throws RemoteException {
        this.zzbj(5, this.zza());
    }

    public final void zzj() throws RemoteException {
        this.zzbj(6, this.zza());
    }

    public final void zzk() throws RemoteException {
        this.zzbj(8, this.zza());
    }

    public final void zzl(String string, String string2) throws RemoteException {
        Parcel parcel = this.zza();
        parcel.writeString(string);
        parcel.writeString(string2);
        this.zzbj(9, parcel);
    }

    public final void zzm(zzbnb zzbnb2, String string) throws RemoteException {
        Parcel parcel = this.zza();
        zzadl.zzf((Parcel)parcel, (IInterface)zzbnb2);
        parcel.writeString(string);
        this.zzbj(10, parcel);
    }

    public final void zzn() throws RemoteException {
        this.zzbj(11, this.zza());
    }

    public final void zzo() throws RemoteException {
        this.zzbj(13, this.zza());
    }

    public final void zzp(zzccl zzccl2) throws RemoteException {
        throw null;
    }

    public final void zzq() throws RemoteException {
        this.zzbj(15, this.zza());
    }

    public final void zzr(zzccp zzccp2) throws RemoteException {
        Parcel parcel = this.zza();
        zzadl.zzf((Parcel)parcel, (IInterface)zzccp2);
        this.zzbj(16, parcel);
    }

    public final void zzs(int n) throws RemoteException {
        throw null;
    }

    public final void zzt() throws RemoteException {
        this.zzbj(18, this.zza());
    }

    public final void zzu() throws RemoteException {
        this.zzbj(20, this.zza());
    }

    public final void zzv(String string) throws RemoteException {
        Parcel parcel = this.zza();
        parcel.writeString(string);
        this.zzbj(21, parcel);
    }

    public final void zzw(int n, String string) throws RemoteException {
        Parcel parcel = this.zza();
        parcel.writeInt(n);
        parcel.writeString(string);
        this.zzbj(22, parcel);
    }

    public final void zzx(zzbcz zzbcz2) throws RemoteException {
        Parcel parcel = this.zza();
        zzadl.zzd((Parcel)parcel, (Parcelable)zzbcz2);
        this.zzbj(23, parcel);
    }

    public final void zzy(zzbcz zzbcz2) throws RemoteException {
        Parcel parcel = this.zza();
        zzadl.zzd((Parcel)parcel, (Parcelable)zzbcz2);
        this.zzbj(24, parcel);
    }
}
