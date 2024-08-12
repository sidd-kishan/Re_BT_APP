/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.IBinder
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.RemoteException
 *  com.google.android.gms.internal.ads.zzadj
 *  com.google.android.gms.internal.ads.zzadl
 *  com.google.android.gms.internal.ads.zzcfk
 */
package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzadj;
import com.google.android.gms.internal.ads.zzadl;
import com.google.android.gms.internal.ads.zzcfk;

public final class zzcfi
extends zzadj
implements zzcfk {
    zzcfi(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.signals.ISignalCallback");
    }

    public final void zzb(String string) throws RemoteException {
        Parcel parcel = this.zza();
        parcel.writeString(string);
        this.zzbj(2, parcel);
    }

    public final void zzc(String string, String string2, Bundle bundle) throws RemoteException {
        Parcel parcel = this.zza();
        parcel.writeString(string);
        parcel.writeString(string2);
        zzadl.zzd((Parcel)parcel, (Parcelable)bundle);
        this.zzbj(3, parcel);
    }
}
