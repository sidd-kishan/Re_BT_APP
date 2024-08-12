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
 *  com.google.android.gms.internal.ads.zzayk
 *  com.google.android.gms.internal.ads.zzayn
 */
package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzadj;
import com.google.android.gms.internal.ads.zzadl;
import com.google.android.gms.internal.ads.zzayk;
import com.google.android.gms.internal.ads.zzayn;

public final class zzayp
extends zzadj
implements IInterface {
    zzayp(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.cache.ICacheService");
    }

    public final zzayk zze(zzayn zzayn2) throws RemoteException {
        Parcel parcel = this.zza();
        zzadl.zzd((Parcel)parcel, (Parcelable)zzayn2);
        parcel = this.zzbi(1, parcel);
        zzayn2 = (zzayk)zzadl.zzc((Parcel)parcel, (Parcelable.Creator)zzayk.CREATOR);
        parcel.recycle();
        return zzayn2;
    }

    public final zzayk zzf(zzayn zzayn2) throws RemoteException {
        Parcel parcel = this.zza();
        zzadl.zzd((Parcel)parcel, (Parcelable)zzayn2);
        zzayn2 = this.zzbi(2, parcel);
        parcel = (zzayk)zzadl.zzc((Parcel)zzayn2, (Parcelable.Creator)zzayk.CREATOR);
        zzayn2.recycle();
        return parcel;
    }

    public final long zzg(zzayn zzayn2) throws RemoteException {
        Parcel parcel = this.zza();
        zzadl.zzd((Parcel)parcel, (Parcelable)zzayn2);
        zzayn2 = this.zzbi(3, parcel);
        long l = zzayn2.readLong();
        zzayn2.recycle();
        return l;
    }
}
