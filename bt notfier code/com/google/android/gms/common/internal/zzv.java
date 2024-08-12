/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.RemoteException
 *  com.google.android.gms.common.internal.ICancelToken
 *  com.google.android.gms.internal.common.zza
 */
package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.internal.ICancelToken;
import com.google.android.gms.internal.common.zza;

public final class zzv
extends zza
implements ICancelToken {
    zzv(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.ICancelToken");
    }

    public final void cancel() throws RemoteException {
        this.zzC(2, this.zza());
    }
}
