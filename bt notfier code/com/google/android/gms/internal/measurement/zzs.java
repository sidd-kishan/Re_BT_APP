/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 *  android.os.RemoteException
 *  com.google.android.gms.internal.measurement.zzb
 *  com.google.android.gms.internal.measurement.zzc
 *  com.google.android.gms.internal.measurement.zzt
 */
package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzb;
import com.google.android.gms.internal.measurement.zzc;
import com.google.android.gms.internal.measurement.zzt;

public abstract class zzs
extends zzb
implements zzt {
    public zzs() {
        super("com.google.android.gms.measurement.api.internal.IBundleReceiver");
    }

    protected final boolean zza(int n, Parcel parcel, Parcel parcel2, int n2) throws RemoteException {
        if (n != 1) return false;
        this.zzb((Bundle)zzc.zzc((Parcel)parcel, (Parcelable.Creator)Bundle.CREATOR));
        parcel2.writeNoException();
        return true;
    }
}
