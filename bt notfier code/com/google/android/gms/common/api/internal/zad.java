/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.DeadObjectException
 *  android.os.RemoteException
 *  com.google.android.gms.common.api.ApiException
 *  com.google.android.gms.common.api.Status
 *  com.google.android.gms.common.api.internal.zaaa
 *  com.google.android.gms.common.api.internal.zabl
 *  com.google.android.gms.common.api.internal.zac
 *  com.google.android.gms.common.api.internal.zai
 *  com.google.android.gms.tasks.TaskCompletionSource
 */
package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zaaa;
import com.google.android.gms.common.api.internal.zabl;
import com.google.android.gms.common.api.internal.zac;
import com.google.android.gms.common.api.internal.zai;
import com.google.android.gms.tasks.TaskCompletionSource;

abstract class zad<T>
extends zac {
    protected final TaskCompletionSource<T> zaa;

    public zad(int n, TaskCompletionSource<T> taskCompletionSource) {
        super(n);
        this.zaa = taskCompletionSource;
    }

    public final void zac(Status status) {
        this.zaa.trySetException((Exception)new ApiException(status));
    }

    public final void zad(Exception exception) {
        this.zaa.trySetException(exception);
    }

    public void zae(zaaa zaaa2, boolean bl) {
    }

    public final void zaf(zabl<?> zabl2) throws DeadObjectException {
        try {
            this.zag(zabl2);
            return;
        }
        catch (RuntimeException runtimeException) {
            this.zaa.trySetException((Exception)runtimeException);
            return;
        }
        catch (RemoteException remoteException) {
            this.zac(zai.zah((RemoteException)remoteException));
            return;
        }
        catch (DeadObjectException deadObjectException) {
            this.zac(zai.zah((RemoteException)((Object)deadObjectException)));
            throw deadObjectException;
        }
    }

    protected abstract void zag(zabl<?> var1) throws RemoteException;
}
