/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.Parcel
 *  android.os.RemoteException
 *  com.google.android.gms.ads.internal.util.zzbu
 *  com.google.android.gms.dynamic.IObjectWrapper$Stub
 *  com.google.android.gms.internal.ads.zzadk
 *  com.google.android.gms.internal.ads.zzadl
 */
package com.google.android.gms.ads.internal.util;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.zzbu;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzadk;
import com.google.android.gms.internal.ads.zzadl;

public abstract class zzbt
extends zzadk
implements zzbu {
    public zzbt() {
        super("com.google.android.gms.ads.internal.util.IWorkManagerUtil");
    }

    protected final boolean zzbz(int n, Parcel parcel, Parcel parcel2, int n2) throws RemoteException {
        if (n != 1) {
            if (n != 2) {
                return false;
            }
            this.zzf(IObjectWrapper.Stub.asInterface((IBinder)parcel.readStrongBinder()));
            parcel2.writeNoException();
        } else {
            boolean bl = this.zze(IObjectWrapper.Stub.asInterface((IBinder)parcel.readStrongBinder()), parcel.readString(), parcel.readString());
            parcel2.writeNoException();
            zzadl.zzb((Parcel)parcel2, (boolean)bl);
        }
        return true;
    }
}
