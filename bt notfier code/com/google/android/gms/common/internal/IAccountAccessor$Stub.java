/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.RemoteException
 *  com.google.android.gms.common.internal.IAccountAccessor
 *  com.google.android.gms.common.internal.zzu
 *  com.google.android.gms.internal.common.zzb
 *  com.google.android.gms.internal.common.zzc
 */
package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.internal.common.zzb;
import com.google.android.gms.internal.common.zzc;

public static abstract class IAccountAccessor.Stub
extends zzb
implements IAccountAccessor {
    public IAccountAccessor.Stub() {
        super("com.google.android.gms.common.internal.IAccountAccessor");
    }

    public static IAccountAccessor asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
        if (!(iInterface instanceof IAccountAccessor)) return new zzu(iBinder);
        return (IAccountAccessor)iInterface;
    }

    protected final boolean zza(int n, Parcel parcel, Parcel parcel2, int n2) throws RemoteException {
        if (n != 2) return false;
        parcel = this.zzb();
        parcel2.writeNoException();
        zzc.zze((Parcel)parcel2, (Parcelable)parcel);
        return true;
    }
}
