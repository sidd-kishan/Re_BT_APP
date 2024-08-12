/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Parcel
 *  android.os.RemoteException
 *  com.google.android.gms.internal.ads.zzadk
 *  com.google.android.gms.internal.ads.zzbqn
 *  com.google.android.gms.internal.ads.zzbqp
 */
package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzadk;
import com.google.android.gms.internal.ads.zzbqn;
import com.google.android.gms.internal.ads.zzbqp;

public abstract class zzbqo
extends zzadk
implements zzbqp {
    public zzbqo() {
        super("com.google.android.gms.ads.internal.h5.client.IH5AdsManager");
    }

    public static zzbqp zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.h5.client.IH5AdsManager");
        if (!(iInterface instanceof zzbqp)) return new zzbqn(iBinder);
        return (zzbqp)iInterface;
    }

    protected final boolean zzbz(int n, Parcel parcel, Parcel parcel2, int n2) throws RemoteException {
        if (n != 1) {
            if (n != 2) {
                return false;
            }
            this.zzf();
        } else {
            this.zze(parcel.readString());
        }
        parcel2.writeNoException();
        return true;
    }
}
