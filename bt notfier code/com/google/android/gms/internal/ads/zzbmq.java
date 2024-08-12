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
 *  com.google.android.gms.internal.ads.zzbmp
 *  com.google.android.gms.internal.ads.zzbmr
 */
package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzadk;
import com.google.android.gms.internal.ads.zzbmp;
import com.google.android.gms.internal.ads.zzbmr;

public abstract class zzbmq
extends zzadk
implements zzbmr {
    public zzbmq() {
        super("com.google.android.gms.ads.internal.formats.client.INativeAdViewHolderDelegate");
    }

    public static zzbmr zze(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdViewHolderDelegate");
        if (!(iInterface instanceof zzbmr)) return new zzbmp(iBinder);
        return (zzbmr)iInterface;
    }

    protected final boolean zzbz(int n, Parcel parcel, Parcel parcel2, int n2) throws RemoteException {
        if (n != 1) {
            if (n != 2) {
                if (n != 3) {
                    return false;
                }
                this.zzd(IObjectWrapper.Stub.asInterface((IBinder)parcel.readStrongBinder()));
            } else {
                this.zzc();
            }
        } else {
            this.zzb(IObjectWrapper.Stub.asInterface((IBinder)parcel.readStrongBinder()));
        }
        parcel2.writeNoException();
        return true;
    }
}
