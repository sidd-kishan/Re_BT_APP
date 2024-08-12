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
 *  com.google.android.gms.internal.ads.zzbdg
 *  com.google.android.gms.internal.ads.zzbfg
 */
package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzadj;
import com.google.android.gms.internal.ads.zzadl;
import com.google.android.gms.internal.ads.zzbdg;
import com.google.android.gms.internal.ads.zzbfg;

public final class zzbfe
extends zzadj
implements zzbfg {
    zzbfe(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdLoader");
    }

    public final void zze(zzbdg zzbdg2) throws RemoteException {
        Parcel parcel = this.zza();
        zzadl.zzd((Parcel)parcel, (Parcelable)zzbdg2);
        this.zzbj(1, parcel);
    }

    public final String zzf() throws RemoteException {
        throw null;
    }

    public final boolean zzg() throws RemoteException {
        Parcel parcel = this.zzbi(3, this.zza());
        boolean bl = zzadl.zza((Parcel)parcel);
        parcel.recycle();
        return bl;
    }

    public final String zzh() throws RemoteException {
        throw null;
    }

    public final void zzi(zzbdg zzbdg2, int n) throws RemoteException {
        Parcel parcel = this.zza();
        zzadl.zzd((Parcel)parcel, (Parcelable)zzbdg2);
        parcel.writeInt(n);
        this.zzbj(5, parcel);
    }
}
