/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Parcel
 *  android.os.RemoteException
 *  com.google.android.gms.internal.ads.zzadj
 *  com.google.android.gms.internal.ads.zzadl
 *  com.google.android.gms.internal.ads.zzbhc
 *  com.google.android.gms.internal.ads.zzbhd
 *  com.google.android.gms.internal.ads.zzbhf
 */
package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzadj;
import com.google.android.gms.internal.ads.zzadl;
import com.google.android.gms.internal.ads.zzbhc;
import com.google.android.gms.internal.ads.zzbhd;
import com.google.android.gms.internal.ads.zzbhf;

public final class zzbha
extends zzadj
implements zzbhc {
    zzbha(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IVideoController");
    }

    public final void zze() throws RemoteException {
        this.zzbj(1, this.zza());
    }

    public final void zzf() throws RemoteException {
        this.zzbj(2, this.zza());
    }

    public final void zzg(boolean bl) throws RemoteException {
        Parcel parcel = this.zza();
        zzadl.zzb((Parcel)parcel, (boolean)bl);
        this.zzbj(3, parcel);
    }

    public final boolean zzh() throws RemoteException {
        Parcel parcel = this.zzbi(4, this.zza());
        boolean bl = zzadl.zza((Parcel)parcel);
        parcel.recycle();
        return bl;
    }

    public final int zzi() throws RemoteException {
        Parcel parcel = this.zzbi(5, this.zza());
        int n = parcel.readInt();
        parcel.recycle();
        return n;
    }

    public final float zzj() throws RemoteException {
        throw null;
    }

    public final float zzk() throws RemoteException {
        throw null;
    }

    public final void zzl(zzbhf zzbhf2) throws RemoteException {
        Parcel parcel = this.zza();
        zzadl.zzf((Parcel)parcel, (IInterface)zzbhf2);
        this.zzbj(8, parcel);
    }

    public final float zzm() throws RemoteException {
        throw null;
    }

    public final boolean zzn() throws RemoteException {
        Parcel parcel = this.zzbi(10, this.zza());
        boolean bl = zzadl.zza((Parcel)parcel);
        parcel.recycle();
        return bl;
    }

    public final zzbhf zzo() throws RemoteException {
        IInterface iInterface;
        Parcel parcel = this.zzbi(11, this.zza());
        Object object = parcel.readStrongBinder();
        object = object == null ? null : ((iInterface = object.queryLocalInterface("com.google.android.gms.ads.internal.client.IVideoLifecycleCallbacks")) instanceof zzbhf ? (zzbhf)iInterface : new zzbhd(object));
        parcel.recycle();
        return object;
    }

    public final boolean zzp() throws RemoteException {
        Parcel parcel = this.zzbi(12, this.zza());
        boolean bl = zzadl.zza((Parcel)parcel);
        parcel.recycle();
        return bl;
    }

    public final void zzq() throws RemoteException {
        this.zzbj(13, this.zza());
    }
}
