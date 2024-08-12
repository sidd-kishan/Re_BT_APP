/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 *  android.os.RemoteException
 *  com.google.android.gms.common.internal.IGmsCallbacks
 *  com.google.android.gms.common.internal.zzi
 *  com.google.android.gms.internal.common.zzb
 *  com.google.android.gms.internal.common.zzc
 */
package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.common.internal.IGmsCallbacks;
import com.google.android.gms.common.internal.zzi;
import com.google.android.gms.internal.common.zzb;
import com.google.android.gms.internal.common.zzc;

public abstract class zzaa
extends zzb
implements IGmsCallbacks {
    public zzaa() {
        super("com.google.android.gms.common.internal.IGmsCallbacks");
    }

    protected final boolean zza(int n, Parcel parcel, Parcel parcel2, int n2) throws RemoteException {
        if (n != 1) {
            if (n != 2) {
                if (n != 3) {
                    return false;
                }
                this.zzc(parcel.readInt(), parcel.readStrongBinder(), (zzi)zzc.zzc((Parcel)parcel, (Parcelable.Creator)zzi.CREATOR));
            } else {
                this.zzb(parcel.readInt(), (Bundle)zzc.zzc((Parcel)parcel, (Parcelable.Creator)Bundle.CREATOR));
            }
        } else {
            this.onPostInitComplete(parcel.readInt(), parcel.readStrongBinder(), (Bundle)zzc.zzc((Parcel)parcel, (Parcelable.Creator)Bundle.CREATOR));
        }
        parcel2.writeNoException();
        return true;
    }
}
