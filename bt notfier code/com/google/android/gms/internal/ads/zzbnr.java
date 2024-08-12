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
 *  com.google.android.gms.internal.ads.zzbfm
 *  com.google.android.gms.internal.ads.zzbnq
 *  com.google.android.gms.internal.ads.zzbns
 */
package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzadk;
import com.google.android.gms.internal.ads.zzbfm;
import com.google.android.gms.internal.ads.zzbnq;
import com.google.android.gms.internal.ads.zzbns;

public abstract class zzbnr
extends zzadk
implements zzbns {
    public zzbnr() {
        super("com.google.android.gms.ads.internal.formats.client.IOnPublisherAdViewLoadedListener");
    }

    public static zzbns zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IOnPublisherAdViewLoadedListener");
        if (!(iInterface instanceof zzbns)) return new zzbnq(iBinder);
        return (zzbns)iInterface;
    }

    protected final boolean zzbz(int n, Parcel parcel, Parcel parcel2, int n2) throws RemoteException {
        if (n != 1) return false;
        this.zze(zzbfm.zzac((IBinder)parcel.readStrongBinder()), IObjectWrapper.Stub.asInterface((IBinder)parcel.readStrongBinder()));
        parcel2.writeNoException();
        return true;
    }
}
