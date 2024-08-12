/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.Parcel
 *  android.os.RemoteException
 *  com.google.android.gms.internal.ads_identifier.zza
 *  com.google.android.gms.internal.ads_identifier.zzc
 *  com.google.android.gms.internal.ads_identifier.zze
 */
package com.google.android.gms.internal.ads_identifier;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.ads_identifier.zza;
import com.google.android.gms.internal.ads_identifier.zzc;
import com.google.android.gms.internal.ads_identifier.zze;

public final class zzg
extends zza
implements zze {
    zzg(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
    }

    public final String getId() throws RemoteException {
        Parcel parcel = this.transactAndReadException(1, this.obtainAndWriteInterfaceToken());
        String string = parcel.readString();
        parcel.recycle();
        return string;
    }

    public final boolean zzb(boolean bl) throws RemoteException {
        Parcel parcel = this.obtainAndWriteInterfaceToken();
        zzc.zza((Parcel)parcel, (boolean)true);
        parcel = this.transactAndReadException(2, parcel);
        bl = zzc.zza((Parcel)parcel);
        parcel.recycle();
        return bl;
    }

    public final boolean zzc() throws RemoteException {
        Parcel parcel = this.transactAndReadException(6, this.obtainAndWriteInterfaceToken());
        boolean bl = zzc.zza((Parcel)parcel);
        parcel.recycle();
        return bl;
    }
}
