/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Parcel
 *  android.os.RemoteException
 *  com.google.android.gms.internal.ads.zzadk
 *  com.google.android.gms.internal.ads.zzbrn
 *  com.google.android.gms.internal.ads.zzbrp
 */
package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzadk;
import com.google.android.gms.internal.ads.zzbrn;
import com.google.android.gms.internal.ads.zzbrp;

public abstract class zzbro
extends zzadk
implements zzbrp {
    public zzbro() {
        super("com.google.android.gms.ads.internal.initialization.IAdapterInitializationCallback");
    }

    public static zzbrp zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.initialization.IAdapterInitializationCallback");
        if (!(iInterface instanceof zzbrp)) return new zzbrn(iBinder);
        return (zzbrp)iInterface;
    }

    protected final boolean zzbz(int n, Parcel parcel, Parcel parcel2, int n2) throws RemoteException {
        if (n != 2) {
            if (n != 3) {
                return false;
            }
            this.zzf(parcel.readString());
        } else {
            this.zze();
        }
        parcel2.writeNoException();
        return true;
    }
}
