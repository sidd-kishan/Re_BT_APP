/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.RemoteException
 *  com.google.android.gms.common.api.Status
 *  com.google.android.gms.common.api.internal.IStatusCallback
 *  com.google.android.gms.internal.base.zaa
 */
package com.google.android.gms.common.api.internal;

import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.IStatusCallback;
import com.google.android.gms.internal.base.zaa;

public final class zabs
extends zaa
implements IStatusCallback {
    zabs(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.api.internal.IStatusCallback");
    }

    public final void onResult(Status status) throws RemoteException {
        throw null;
    }
}
