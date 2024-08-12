/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.RemoteException
 *  com.google.android.gms.dynamic.IObjectWrapper
 *  com.google.android.gms.internal.ads.zzadj
 *  com.google.android.gms.internal.ads.zzadl
 *  com.google.android.gms.internal.ads.zzcaf
 *  com.google.android.gms.internal.ads.zzcam
 *  com.google.android.gms.internal.ads.zzcfk
 *  com.google.android.gms.internal.ads.zzcfn
 *  com.google.android.gms.internal.ads.zzcfr
 */
package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzadj;
import com.google.android.gms.internal.ads.zzadl;
import com.google.android.gms.internal.ads.zzcaf;
import com.google.android.gms.internal.ads.zzcam;
import com.google.android.gms.internal.ads.zzcfk;
import com.google.android.gms.internal.ads.zzcfn;
import com.google.android.gms.internal.ads.zzcfr;
import java.util.List;

public final class zzcfl
extends zzadj
implements zzcfn {
    zzcfl(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.signals.ISignalGenerator");
    }

    public final void zze(IObjectWrapper iObjectWrapper, zzcfr zzcfr2, zzcfk zzcfk2) throws RemoteException {
        Parcel parcel = this.zza();
        zzadl.zzf((Parcel)parcel, (IInterface)iObjectWrapper);
        zzadl.zzd((Parcel)parcel, (Parcelable)zzcfr2);
        zzadl.zzf((Parcel)parcel, (IInterface)zzcfk2);
        this.zzbj(1, parcel);
    }

    public final void zzf(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcel = this.zza();
        zzadl.zzf((Parcel)parcel, (IInterface)iObjectWrapper);
        this.zzbj(2, parcel);
    }

    public final void zzg(List<Uri> list, IObjectWrapper iObjectWrapper, zzcaf zzcaf2) throws RemoteException {
        Parcel parcel = this.zza();
        parcel.writeTypedList(list);
        zzadl.zzf((Parcel)parcel, (IInterface)iObjectWrapper);
        zzadl.zzf((Parcel)parcel, (IInterface)zzcaf2);
        this.zzbj(5, parcel);
    }

    public final void zzh(List<Uri> list, IObjectWrapper iObjectWrapper, zzcaf zzcaf2) throws RemoteException {
        Parcel parcel = this.zza();
        parcel.writeTypedList(list);
        zzadl.zzf((Parcel)parcel, (IInterface)iObjectWrapper);
        zzadl.zzf((Parcel)parcel, (IInterface)zzcaf2);
        this.zzbj(6, parcel);
    }

    public final void zzi(zzcam zzcam2) throws RemoteException {
        Parcel parcel = this.zza();
        zzadl.zzd((Parcel)parcel, (Parcelable)zzcam2);
        this.zzbj(7, parcel);
    }

    public final void zzj(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcel = this.zza();
        zzadl.zzf((Parcel)parcel, (IInterface)iObjectWrapper);
        this.zzbj(8, parcel);
    }
}
