/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 *  android.os.RemoteException
 *  com.google.android.gms.appset.zzc
 *  com.google.android.gms.common.api.Status
 *  com.google.android.gms.internal.appset.zzb
 *  com.google.android.gms.internal.appset.zzc
 *  com.google.android.gms.internal.appset.zzf
 */
package com.google.android.gms.internal.appset;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.appset.zzb;
import com.google.android.gms.internal.appset.zzc;
import com.google.android.gms.internal.appset.zzf;

public abstract class zze
extends zzb
implements zzf {
    public zze() {
        super("com.google.android.gms.appset.internal.IAppSetIdCallback");
    }

    protected final boolean zza(int n, Parcel parcel, Parcel parcel2, int n2) throws RemoteException {
        if (n != 1) return false;
        this.zzb((Status)zzc.zza((Parcel)parcel, (Parcelable.Creator)Status.CREATOR), (com.google.android.gms.appset.zzc)zzc.zza((Parcel)parcel, (Parcelable.Creator)com.google.android.gms.appset.zzc.CREATOR));
        return true;
    }
}
