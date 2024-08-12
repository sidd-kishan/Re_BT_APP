/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Parcel
 *  android.os.RemoteException
 *  com.google.android.gms.internal.ads.zzadk
 *  com.google.android.gms.internal.ads.zzccn
 *  com.google.android.gms.internal.ads.zzccp
 */
package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzadk;
import com.google.android.gms.internal.ads.zzccn;
import com.google.android.gms.internal.ads.zzccp;

public abstract class zzcco
extends zzadk
implements zzccp {
    public zzcco() {
        super("com.google.android.gms.ads.internal.rewarded.client.IRewardItem");
    }

    public static zzccp zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardItem");
        if (!(iInterface instanceof zzccp)) return new zzccn(iBinder);
        return (zzccp)iInterface;
    }

    protected final boolean zzbz(int n, Parcel object, Parcel parcel, int n2) throws RemoteException {
        if (n != 1) {
            if (n != 2) {
                return false;
            }
            n = this.zzf();
            parcel.writeNoException();
            parcel.writeInt(n);
        } else {
            object = this.zze();
            parcel.writeNoException();
            parcel.writeString((String)object);
        }
        return true;
    }
}
