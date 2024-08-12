/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Parcel
 *  android.os.RemoteException
 *  com.google.android.gms.internal.ads.zzadk
 *  com.google.android.gms.internal.ads.zzbrl
 *  com.google.android.gms.internal.ads.zzbrq
 *  com.google.android.gms.internal.ads.zzbrs
 */
package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzadk;
import com.google.android.gms.internal.ads.zzbrl;
import com.google.android.gms.internal.ads.zzbrq;
import com.google.android.gms.internal.ads.zzbrs;

public abstract class zzbrr
extends zzadk
implements zzbrs {
    public zzbrr() {
        super("com.google.android.gms.ads.internal.initialization.IInitializationCallback");
    }

    public static zzbrs zzc(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.initialization.IInitializationCallback");
        if (!(iInterface instanceof zzbrs)) return new zzbrq(iBinder);
        return (zzbrs)iInterface;
    }

    protected final boolean zzbz(int n, Parcel parcel, Parcel parcel2, int n2) throws RemoteException {
        if (n != 1) return false;
        this.zzb(parcel.createTypedArrayList(zzbrl.CREATOR));
        parcel2.writeNoException();
        return true;
    }
}
