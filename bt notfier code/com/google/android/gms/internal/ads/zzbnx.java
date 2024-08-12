/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Parcel
 *  android.os.RemoteException
 *  com.google.android.gms.dynamic.IObjectWrapper$Stub
 *  com.google.android.gms.internal.ads.zzadk
 *  com.google.android.gms.internal.ads.zzadl
 *  com.google.android.gms.internal.ads.zzbnw
 *  com.google.android.gms.internal.ads.zzbny
 */
package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzadk;
import com.google.android.gms.internal.ads.zzadl;
import com.google.android.gms.internal.ads.zzbnw;
import com.google.android.gms.internal.ads.zzbny;

public abstract class zzbnx
extends zzadk
implements zzbny {
    public zzbnx() {
        super("com.google.android.gms.ads.internal.formats.client.IShouldDelayBannerRenderingListener");
    }

    public static zzbny zzc(IBinder iBinder) {
        IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IShouldDelayBannerRenderingListener");
        if (!(iInterface instanceof zzbny)) return new zzbnw(iBinder);
        return (zzbny)iInterface;
    }

    protected final boolean zzbz(int n, Parcel parcel, Parcel parcel2, int n2) throws RemoteException {
        if (n != 2) return false;
        boolean bl = this.zzb(IObjectWrapper.Stub.asInterface((IBinder)parcel.readStrongBinder()));
        parcel2.writeNoException();
        zzadl.zzb((Parcel)parcel2, (boolean)bl);
        return true;
    }
}
