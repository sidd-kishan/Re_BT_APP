/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.RemoteException
 *  com.google.android.gms.common.internal.service.zak
 *  com.google.android.gms.internal.base.zab
 */
package com.google.android.gms.common.internal.service;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.internal.service.zak;
import com.google.android.gms.internal.base.zab;

public abstract class zaj
extends zab
implements zak {
    public zaj() {
        super("com.google.android.gms.common.internal.service.ICommonCallbacks");
    }

    protected final boolean zaa(int n, Parcel parcel, Parcel parcel2, int n2) throws RemoteException {
        if (n != 1) return false;
        this.zab(parcel.readInt());
        parcel2.writeNoException();
        return true;
    }
}
