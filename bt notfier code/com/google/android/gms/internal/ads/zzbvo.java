/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Parcel
 *  android.os.RemoteException
 *  com.google.android.gms.internal.ads.zzadk
 *  com.google.android.gms.internal.ads.zzadl
 *  com.google.android.gms.internal.ads.zzbvn
 *  com.google.android.gms.internal.ads.zzbvp
 */
package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzadk;
import com.google.android.gms.internal.ads.zzadl;
import com.google.android.gms.internal.ads.zzbvn;
import com.google.android.gms.internal.ads.zzbvp;

public abstract class zzbvo
extends zzadk
implements zzbvp {
    public zzbvo() {
        super("com.google.android.gms.ads.internal.mediation.client.IMediationInterscrollerAd");
    }

    public static zzbvp zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationInterscrollerAd");
        if (!(iInterface instanceof zzbvp)) return new zzbvn(iBinder);
        return (zzbvp)iInterface;
    }

    protected final boolean zzbz(int n, Parcel parcel, Parcel parcel2, int n2) throws RemoteException {
        if (n != 1) {
            if (n != 2) {
                return false;
            }
            boolean bl = this.zzf();
            parcel2.writeNoException();
            zzadl.zzb((Parcel)parcel2, (boolean)bl);
        } else {
            parcel = this.zze();
            parcel2.writeNoException();
            zzadl.zzf((Parcel)parcel2, (IInterface)parcel);
        }
        return true;
    }
}
