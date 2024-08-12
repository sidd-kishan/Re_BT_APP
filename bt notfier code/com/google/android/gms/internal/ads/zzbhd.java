/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.Parcel
 *  android.os.RemoteException
 *  com.google.android.gms.internal.ads.zzadj
 *  com.google.android.gms.internal.ads.zzadl
 *  com.google.android.gms.internal.ads.zzbhf
 */
package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzadj;
import com.google.android.gms.internal.ads.zzadl;
import com.google.android.gms.internal.ads.zzbhf;

public final class zzbhd
extends zzadj
implements zzbhf {
    zzbhd(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IVideoLifecycleCallbacks");
    }

    public final void zze() throws RemoteException {
        this.zzbj(1, this.zza());
    }

    public final void zzf() throws RemoteException {
        this.zzbj(2, this.zza());
    }

    public final void zzg() throws RemoteException {
        this.zzbj(3, this.zza());
    }

    public final void zzh() throws RemoteException {
        this.zzbj(4, this.zza());
    }

    public final void zzi(boolean bl) throws RemoteException {
        Parcel parcel = this.zza();
        zzadl.zzb((Parcel)parcel, (boolean)bl);
        this.zzbj(5, parcel);
    }
}
