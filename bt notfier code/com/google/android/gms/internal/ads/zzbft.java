/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Parcel
 *  android.os.RemoteException
 *  com.google.android.gms.internal.ads.zzadk
 *  com.google.android.gms.internal.ads.zzbfs
 *  com.google.android.gms.internal.ads.zzbfu
 */
package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzadk;
import com.google.android.gms.internal.ads.zzbfs;
import com.google.android.gms.internal.ads.zzbfu;

public abstract class zzbft
extends zzadk
implements zzbfu {
    public zzbft() {
        super("com.google.android.gms.ads.internal.client.IAppEventListener");
    }

    public static zzbfu zzd(IBinder iBinder) {
        IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAppEventListener");
        if (!(iInterface instanceof zzbfu)) return new zzbfs(iBinder);
        return (zzbfu)iInterface;
    }

    protected final boolean zzbz(int n, Parcel parcel, Parcel parcel2, int n2) throws RemoteException {
        if (n != 1) return false;
        this.zzb(parcel.readString(), parcel.readString());
        parcel2.writeNoException();
        return true;
    }
}
