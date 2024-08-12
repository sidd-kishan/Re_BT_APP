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
 *  com.google.android.gms.internal.ads.zzcbb
 *  com.google.android.gms.internal.ads.zzcbf
 *  com.google.android.gms.internal.ads.zzcbj
 */
package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzadj;
import com.google.android.gms.internal.ads.zzadl;
import com.google.android.gms.internal.ads.zzcbb;
import com.google.android.gms.internal.ads.zzcbf;
import com.google.android.gms.internal.ads.zzcbj;

public final class zzcaz
extends zzadj
implements zzcbb {
    zzcaz(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.request.IAdRequestService");
    }

    public final void zze(zzcbj zzcbj2, zzcbf zzcbf2) throws RemoteException {
        Parcel parcel = this.zza();
        zzadl.zzd((Parcel)parcel, (Parcelable)zzcbj2);
        zzadl.zzf((Parcel)parcel, (IInterface)zzcbf2);
        this.zzbj(4, parcel);
    }

    public final void zzf(zzcbj zzcbj2, zzcbf zzcbf2) throws RemoteException {
        Parcel parcel = this.zza();
        zzadl.zzd((Parcel)parcel, (Parcelable)zzcbj2);
        zzadl.zzf((Parcel)parcel, (IInterface)zzcbf2);
        this.zzbj(5, parcel);
    }

    public final void zzg(zzcbj zzcbj2, zzcbf zzcbf2) throws RemoteException {
        Parcel parcel = this.zza();
        zzadl.zzd((Parcel)parcel, (Parcelable)zzcbj2);
        zzadl.zzf((Parcel)parcel, (IInterface)zzcbf2);
        this.zzbj(6, parcel);
    }

    public final void zzh(String string, zzcbf zzcbf2) throws RemoteException {
        Parcel parcel = this.zza();
        parcel.writeString(string);
        zzadl.zzf((Parcel)parcel, (IInterface)zzcbf2);
        this.zzbj(7, parcel);
    }
}
