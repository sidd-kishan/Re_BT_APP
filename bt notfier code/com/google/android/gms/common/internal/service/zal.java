/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Parcel
 *  android.os.RemoteException
 *  com.google.android.gms.common.internal.service.zak
 *  com.google.android.gms.internal.base.zaa
 *  com.google.android.gms.internal.base.zac
 */
package com.google.android.gms.common.internal.service;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.internal.service.zak;
import com.google.android.gms.internal.base.zaa;
import com.google.android.gms.internal.base.zac;

public final class zal
extends zaa
implements IInterface {
    zal(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.service.ICommonService");
    }

    public final void zae(zak zak2) throws RemoteException {
        Parcel parcel = this.zaa();
        zac.zad((Parcel)parcel, (IInterface)zak2);
        this.zad(1, parcel);
    }
}
