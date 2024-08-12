/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 *  android.os.RemoteException
 *  com.google.android.gms.internal.ads.zzadk
 *  com.google.android.gms.internal.ads.zzadl
 *  com.google.android.gms.internal.ads.zzbdn
 *  com.google.android.gms.internal.ads.zzbgu
 *  com.google.android.gms.internal.ads.zzbgw
 */
package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzadk;
import com.google.android.gms.internal.ads.zzadl;
import com.google.android.gms.internal.ads.zzbdn;
import com.google.android.gms.internal.ads.zzbgu;
import com.google.android.gms.internal.ads.zzbgw;

public abstract class zzbgv
extends zzadk
implements zzbgw {
    public zzbgv() {
        super("com.google.android.gms.ads.internal.client.IOnPaidEventListener");
    }

    public static zzbgw zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IOnPaidEventListener");
        if (!(iInterface instanceof zzbgw)) return new zzbgu(iBinder);
        return (zzbgw)iInterface;
    }

    protected final boolean zzbz(int n, Parcel parcel, Parcel parcel2, int n2) throws RemoteException {
        if (n != 1) return false;
        this.zze((zzbdn)zzadl.zzc((Parcel)parcel, (Parcelable.Creator)zzbdn.CREATOR));
        parcel2.writeNoException();
        return true;
    }
}
