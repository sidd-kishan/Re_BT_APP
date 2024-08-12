/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Parcel
 *  android.os.RemoteException
 *  com.google.android.gms.common.internal.ICancelToken
 *  com.google.android.gms.common.internal.zzv
 *  com.google.android.gms.internal.common.zzb
 */
package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.internal.ICancelToken;
import com.google.android.gms.common.internal.zzv;
import com.google.android.gms.internal.common.zzb;

public static abstract class ICancelToken.Stub
extends zzb
implements ICancelToken {
    public ICancelToken.Stub() {
        super("com.google.android.gms.common.internal.ICancelToken");
    }

    public static ICancelToken asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.ICancelToken");
        if (!(iInterface instanceof ICancelToken)) return new zzv(iBinder);
        return (ICancelToken)iInterface;
    }

    protected final boolean zza(int n, Parcel parcel, Parcel parcel2, int n2) throws RemoteException {
        if (n != 2) return false;
        this.cancel();
        return true;
    }
}
