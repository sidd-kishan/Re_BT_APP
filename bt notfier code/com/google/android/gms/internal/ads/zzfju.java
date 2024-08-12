/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  android.os.RemoteException
 *  com.google.android.gms.internal.ads.zzadj
 *  com.google.android.gms.internal.ads.zzadl
 *  com.google.android.gms.internal.ads.zzfjn
 *  com.google.android.gms.internal.ads.zzfjq
 *  com.google.android.gms.internal.ads.zzfjs
 *  com.google.android.gms.internal.ads.zzfjz
 *  com.google.android.gms.internal.ads.zzfkb
 */
package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzadj;
import com.google.android.gms.internal.ads.zzadl;
import com.google.android.gms.internal.ads.zzfjn;
import com.google.android.gms.internal.ads.zzfjq;
import com.google.android.gms.internal.ads.zzfjs;
import com.google.android.gms.internal.ads.zzfjz;
import com.google.android.gms.internal.ads.zzfkb;

public final class zzfju
extends zzadj
implements IInterface {
    zzfju(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.gass.internal.IGassService");
    }

    public final zzfjs zze(zzfjq zzfjq2) throws RemoteException {
        Parcel parcel = this.zza();
        zzadl.zzd((Parcel)parcel, (Parcelable)zzfjq2);
        parcel = this.zzbi(1, parcel);
        zzfjq2 = (zzfjs)zzadl.zzc((Parcel)parcel, (Parcelable.Creator)zzfjs.CREATOR);
        parcel.recycle();
        return zzfjq2;
    }

    public final void zzf(zzfjn zzfjn2) throws RemoteException {
        Parcel parcel = this.zza();
        zzadl.zzd((Parcel)parcel, (Parcelable)zzfjn2);
        this.zzbj(2, parcel);
    }

    public final zzfkb zzg(zzfjz zzfjz2) throws RemoteException {
        Parcel parcel = this.zza();
        zzadl.zzd((Parcel)parcel, (Parcelable)zzfjz2);
        zzfjz2 = this.zzbi(3, parcel);
        parcel = (zzfkb)zzadl.zzc((Parcel)zzfjz2, (Parcelable.Creator)zzfkb.CREATOR);
        zzfjz2.recycle();
        return parcel;
    }
}
