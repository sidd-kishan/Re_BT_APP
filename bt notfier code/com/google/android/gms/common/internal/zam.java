/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.RemoteException
 *  com.google.android.gms.common.internal.zax
 *  com.google.android.gms.dynamic.IObjectWrapper
 *  com.google.android.gms.dynamic.IObjectWrapper$Stub
 *  com.google.android.gms.internal.base.zaa
 *  com.google.android.gms.internal.base.zac
 */
package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.common.internal.zax;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.base.zaa;
import com.google.android.gms.internal.base.zac;

public final class zam
extends zaa
implements IInterface {
    zam(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.ISignInButtonCreator");
    }

    public final IObjectWrapper zae(IObjectWrapper iObjectWrapper, zax zax2) throws RemoteException {
        Parcel parcel = this.zaa();
        zac.zad((Parcel)parcel, (IInterface)iObjectWrapper);
        zac.zac((Parcel)parcel, (Parcelable)zax2);
        iObjectWrapper = this.zab(2, parcel);
        zax2 = IObjectWrapper.Stub.asInterface((IBinder)iObjectWrapper.readStrongBinder());
        iObjectWrapper.recycle();
        return zax2;
    }
}
