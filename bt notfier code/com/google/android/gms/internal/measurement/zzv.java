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
 *  com.google.android.gms.internal.measurement.zzw
 */
package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzb;
import com.google.android.gms.internal.measurement.zzc;
import com.google.android.gms.internal.measurement.zzw;

public abstract class zzv
extends zzb
implements zzw {
    public zzv() {
        super("com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
    }

    protected final boolean zza(int n, Parcel parcel, Parcel parcel2, int n2) throws RemoteException {
        if (n != 1) {
            if (n != 2) {
                return false;
            }
            n = this.zze();
            parcel2.writeNoException();
            parcel2.writeInt(n);
        } else {
            this.zzd(parcel.readString(), parcel.readString(), (Bundle)zzc.zzc((Parcel)parcel, (Parcelable.Creator)Bundle.CREATOR), parcel.readLong());
            parcel2.writeNoException();
        }
        return true;
    }
}
