/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.RemoteException
 *  com.google.android.gms.internal.ads.zzadj
 *  com.google.android.gms.internal.ads.zzadl
 *  com.google.android.gms.internal.ads.zzayd
 *  com.google.android.gms.internal.ads.zzbcz
 */
package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzadj;
import com.google.android.gms.internal.ads.zzadl;
import com.google.android.gms.internal.ads.zzayd;
import com.google.android.gms.internal.ads.zzbcz;

public final class zzayb
extends zzadj
implements zzayd {
    zzayb(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.appopen.client.IAppOpenFullScreenContentCallback");
    }

    public final void zzc() throws RemoteException {
        this.zzbj(1, this.zza());
    }

    public final void zzd() throws RemoteException {
        this.zzbj(2, this.zza());
    }

    public final void zze(zzbcz zzbcz2) throws RemoteException {
        Parcel parcel = this.zza();
        zzadl.zzd((Parcel)parcel, (Parcelable)zzbcz2);
        this.zzbj(3, parcel);
    }

    public final void zzf() throws RemoteException {
        this.zzbj(4, this.zza());
    }

    public final void zzg() throws RemoteException {
        this.zzbj(5, this.zza());
    }
}
