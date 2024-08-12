/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.RemoteException
 *  com.google.android.gms.common.api.Status
 *  com.google.android.gms.common.api.internal.BaseImplementation$ResultHolder
 *  com.google.android.gms.common.internal.service.zaa
 */
package com.google.android.gms.common.internal.service;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.service.zaa;

final class zad
extends zaa {
    private final BaseImplementation.ResultHolder<Status> zaa;

    public zad(BaseImplementation.ResultHolder<Status> resultHolder) {
        this.zaa = resultHolder;
    }

    public final void zab(int n) throws RemoteException {
        this.zaa.setResult((Object)new Status(n));
    }
}
