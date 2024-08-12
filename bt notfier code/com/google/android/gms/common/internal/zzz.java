/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.IBinder
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.RemoteException
 *  com.google.android.gms.common.internal.IGmsCallbacks
 *  com.google.android.gms.common.internal.zzi
 *  com.google.android.gms.internal.common.zza
 *  com.google.android.gms.internal.common.zzc
 */
package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.common.internal.IGmsCallbacks;
import com.google.android.gms.common.internal.zzi;
import com.google.android.gms.internal.common.zza;
import com.google.android.gms.internal.common.zzc;

public final class zzz
extends zza
implements IGmsCallbacks {
    zzz(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.IGmsCallbacks");
    }

    public final void onPostInitComplete(int n, IBinder iBinder, Bundle bundle) throws RemoteException {
        Parcel parcel = this.zza();
        parcel.writeInt(n);
        parcel.writeStrongBinder(iBinder);
        zzc.zzd((Parcel)parcel, (Parcelable)bundle);
        this.zzD(1, parcel);
    }

    public final void zzb(int n, Bundle bundle) throws RemoteException {
        throw null;
    }

    public final void zzc(int n, IBinder iBinder, zzi zzi2) throws RemoteException {
        throw null;
    }
}
