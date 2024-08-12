/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.IBinder
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.RemoteException
 *  com.google.android.gms.internal.measurement.zza
 *  com.google.android.gms.internal.measurement.zzc
 *  com.google.android.gms.internal.measurement.zzt
 */
package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zza;
import com.google.android.gms.internal.measurement.zzc;
import com.google.android.gms.internal.measurement.zzt;

public final class zzr
extends zza
implements zzt {
    zzr(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.api.internal.IBundleReceiver");
    }

    public final void zzb(Bundle bundle) throws RemoteException {
        Parcel parcel = this.zza();
        zzc.zzd((Parcel)parcel, (Parcelable)bundle);
        this.zzc(1, parcel);
    }
}
