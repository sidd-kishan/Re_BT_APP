/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 *  android.os.RemoteException
 *  com.google.android.gms.common.api.Status
 *  com.google.android.gms.common.api.internal.IStatusCallback
 *  com.google.android.gms.common.api.internal.zabs
 *  com.google.android.gms.internal.base.zab
 *  com.google.android.gms.internal.base.zac
 */
package com.google.android.gms.common.api.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.IStatusCallback;
import com.google.android.gms.common.api.internal.zabs;
import com.google.android.gms.internal.base.zab;
import com.google.android.gms.internal.base.zac;

public static abstract class IStatusCallback.Stub
extends zab
implements IStatusCallback {
    public IStatusCallback.Stub() {
        super("com.google.android.gms.common.api.internal.IStatusCallback");
    }

    public static IStatusCallback asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.common.api.internal.IStatusCallback");
        if (!(iInterface instanceof IStatusCallback)) return new zabs(iBinder);
        return (IStatusCallback)iInterface;
    }

    protected final boolean zaa(int n, Parcel parcel, Parcel parcel2, int n2) throws RemoteException {
        if (n != 1) return false;
        this.onResult((Status)zac.zab((Parcel)parcel, (Parcelable.Creator)Status.CREATOR));
        return true;
    }
}
