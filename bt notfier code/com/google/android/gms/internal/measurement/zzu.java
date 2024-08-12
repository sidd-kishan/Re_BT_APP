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
 *  com.google.android.gms.internal.measurement.zzw
 */
package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zza;
import com.google.android.gms.internal.measurement.zzc;
import com.google.android.gms.internal.measurement.zzw;

public final class zzu
extends zza
implements zzw {
    zzu(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
    }

    public final void zzd(String string, String string2, Bundle bundle, long l) throws RemoteException {
        Parcel parcel = this.zza();
        parcel.writeString(string);
        parcel.writeString(string2);
        zzc.zzd((Parcel)parcel, (Parcelable)bundle);
        parcel.writeLong(l);
        this.zzc(1, parcel);
    }

    public final int zze() throws RemoteException {
        Parcel parcel = this.zzz(2, this.zza());
        int n = parcel.readInt();
        parcel.recycle();
        return n;
    }
}
