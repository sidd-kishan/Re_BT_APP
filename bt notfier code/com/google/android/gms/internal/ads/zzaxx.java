/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.RemoteException
 *  com.google.android.gms.internal.ads.zzadj
 *  com.google.android.gms.internal.ads.zzadl
 *  com.google.android.gms.internal.ads.zzaxw
 *  com.google.android.gms.internal.ads.zzaxz
 *  com.google.android.gms.internal.ads.zzbcz
 */
package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzadj;
import com.google.android.gms.internal.ads.zzadl;
import com.google.android.gms.internal.ads.zzaxw;
import com.google.android.gms.internal.ads.zzaxz;
import com.google.android.gms.internal.ads.zzbcz;

public final class zzaxx
extends zzadj
implements zzaxz {
    zzaxx(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.appopen.client.IAppOpenAdLoadCallback");
    }

    public final void zzb(zzaxw zzaxw2) throws RemoteException {
        Parcel parcel = this.zza();
        zzadl.zzf((Parcel)parcel, (IInterface)zzaxw2);
        this.zzbj(1, parcel);
    }

    public final void zzc(int n) throws RemoteException {
        Parcel parcel = this.zza();
        parcel.writeInt(n);
        this.zzbj(2, parcel);
    }

    public final void zzd(zzbcz zzbcz2) throws RemoteException {
        Parcel parcel = this.zza();
        zzadl.zzd((Parcel)parcel, (Parcelable)zzbcz2);
        this.zzbj(3, parcel);
    }
}
