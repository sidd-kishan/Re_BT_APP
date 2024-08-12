/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Parcel
 *  android.os.RemoteException
 *  com.google.android.gms.internal.ads.zzadk
 *  com.google.android.gms.internal.ads.zzbnt
 *  com.google.android.gms.internal.ads.zzbnv
 *  com.google.android.gms.internal.ads.zzboc
 *  com.google.android.gms.internal.ads.zzboe
 */
package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzadk;
import com.google.android.gms.internal.ads.zzbnt;
import com.google.android.gms.internal.ads.zzbnv;
import com.google.android.gms.internal.ads.zzboc;
import com.google.android.gms.internal.ads.zzboe;

public abstract class zzbnu
extends zzadk
implements zzbnv {
    public zzbnu() {
        super("com.google.android.gms.ads.internal.formats.client.IOnUnifiedNativeAdLoadedListener");
    }

    public static zzbnv zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IOnUnifiedNativeAdLoadedListener");
        if (!(iInterface instanceof zzbnv)) return new zzbnt(iBinder);
        return (zzbnv)iInterface;
    }

    protected final boolean zzbz(int n, Parcel object, Parcel parcel, int n2) throws RemoteException {
        IInterface iInterface;
        if (n != 1) return false;
        object = (object = object.readStrongBinder()) == null ? null : ((iInterface = object.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IUnifiedNativeAd")) instanceof zzboe ? (zzboe)iInterface : new zzboc((IBinder)object));
        this.zze((zzboe)object);
        parcel.writeNoException();
        return true;
    }
}
