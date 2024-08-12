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
 *  com.google.android.gms.common.internal.zzae
 *  com.google.android.gms.common.zzn
 *  com.google.android.gms.common.zzq
 *  com.google.android.gms.common.zzs
 *  com.google.android.gms.dynamic.IObjectWrapper
 *  com.google.android.gms.internal.common.zza
 *  com.google.android.gms.internal.common.zzc
 */
package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.common.internal.zzae;
import com.google.android.gms.common.zzn;
import com.google.android.gms.common.zzq;
import com.google.android.gms.common.zzs;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.common.zza;
import com.google.android.gms.internal.common.zzc;

public final class zzac
extends zza
implements zzae {
    zzac(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.IGoogleCertificatesApi");
    }

    public final boolean zze(zzs zzs2, IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcel = this.zza();
        zzc.zzd((Parcel)parcel, (Parcelable)zzs2);
        zzc.zzf((Parcel)parcel, (IInterface)iObjectWrapper);
        zzs2 = this.zzB(5, parcel);
        boolean bl = zzc.zza((Parcel)zzs2);
        zzs2.recycle();
        return bl;
    }

    public final zzq zzf(zzn zzn2) throws RemoteException {
        Parcel parcel = this.zza();
        zzc.zzd((Parcel)parcel, (Parcelable)zzn2);
        zzn2 = this.zzB(6, parcel);
        parcel = (zzq)zzc.zzc((Parcel)zzn2, (Parcelable.Creator)zzq.CREATOR);
        zzn2.recycle();
        return parcel;
    }

    public final boolean zzg() throws RemoteException {
        Parcel parcel = this.zzB(7, this.zza());
        boolean bl = zzc.zza((Parcel)parcel);
        parcel.recycle();
        return bl;
    }
}
