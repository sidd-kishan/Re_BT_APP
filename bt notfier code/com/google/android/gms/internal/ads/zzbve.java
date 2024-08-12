/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.Parcel
 *  android.os.RemoteException
 *  com.google.android.gms.internal.ads.zzadj
 *  com.google.android.gms.internal.ads.zzadl
 *  com.google.android.gms.internal.ads.zzbvg
 *  com.google.android.gms.internal.ads.zzbvh
 *  com.google.android.gms.internal.ads.zzbvj
 *  com.google.android.gms.internal.ads.zzbxm
 *  com.google.android.gms.internal.ads.zzbxn
 */
package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzadj;
import com.google.android.gms.internal.ads.zzadl;
import com.google.android.gms.internal.ads.zzbvg;
import com.google.android.gms.internal.ads.zzbvh;
import com.google.android.gms.internal.ads.zzbvj;
import com.google.android.gms.internal.ads.zzbxm;
import com.google.android.gms.internal.ads.zzbxn;

public final class zzbve
extends zzadj
implements zzbvg {
    zzbve(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
    }

    public final zzbvj zzb(String object) throws RemoteException {
        Parcel parcel = this.zza();
        parcel.writeString((String)object);
        parcel = this.zzbi(1, parcel);
        IBinder iBinder = parcel.readStrongBinder();
        object = iBinder == null ? null : ((object = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter")) instanceof zzbvj ? (zzbvj)object : new zzbvh(iBinder));
        parcel.recycle();
        return object;
    }

    public final boolean zzc(String string) throws RemoteException {
        Parcel parcel = this.zza();
        parcel.writeString(string);
        string = this.zzbi(2, parcel);
        boolean bl = zzadl.zza((Parcel)string);
        string.recycle();
        return bl;
    }

    public final boolean zzd(String string) throws RemoteException {
        Parcel parcel = this.zza();
        parcel.writeString(string);
        string = this.zzbi(4, parcel);
        boolean bl = zzadl.zza((Parcel)string);
        string.recycle();
        return bl;
    }

    public final zzbxn zzf(String string) throws RemoteException {
        Parcel parcel = this.zza();
        parcel.writeString(string);
        string = this.zzbi(3, parcel);
        parcel = zzbxm.zzb((IBinder)string.readStrongBinder());
        string.recycle();
        return parcel;
    }
}
