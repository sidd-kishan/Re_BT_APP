/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.RemoteException
 *  com.google.android.gms.appset.zza
 *  com.google.android.gms.internal.appset.zza
 *  com.google.android.gms.internal.appset.zzc
 *  com.google.android.gms.internal.appset.zzf
 */
package com.google.android.gms.internal.appset;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.internal.appset.zza;
import com.google.android.gms.internal.appset.zzc;
import com.google.android.gms.internal.appset.zzf;

public final class zzg
extends zza
implements IInterface {
    zzg(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.appset.internal.IAppSetService");
    }

    public final void zzc(com.google.android.gms.appset.zza zza2, zzf zzf2) throws RemoteException {
        Parcel parcel = this.zza();
        zzc.zzb((Parcel)parcel, (Parcelable)zza2);
        zzc.zzc((Parcel)parcel, (IInterface)zzf2);
        this.zzb(1, parcel);
    }
}
