/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.DeadObjectException
 *  android.os.RemoteException
 *  com.google.android.gms.common.Feature
 *  com.google.android.gms.common.api.Api$AnyClient
 *  com.google.android.gms.common.api.Status
 *  com.google.android.gms.common.api.internal.StatusExceptionMapper
 *  com.google.android.gms.common.api.internal.TaskApiCall
 *  com.google.android.gms.common.api.internal.zaaa
 *  com.google.android.gms.common.api.internal.zabl
 *  com.google.android.gms.common.api.internal.zac
 *  com.google.android.gms.common.api.internal.zai
 *  com.google.android.gms.tasks.TaskCompletionSource
 */
package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.StatusExceptionMapper;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.api.internal.zaaa;
import com.google.android.gms.common.api.internal.zabl;
import com.google.android.gms.common.api.internal.zac;
import com.google.android.gms.common.api.internal.zai;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class zag<ResultT>
extends zac {
    private final TaskApiCall<Api.AnyClient, ResultT> zaa;
    private final TaskCompletionSource<ResultT> zab;
    private final StatusExceptionMapper zad;

    public zag(int n, TaskApiCall<Api.AnyClient, ResultT> taskApiCall, TaskCompletionSource<ResultT> taskCompletionSource, StatusExceptionMapper statusExceptionMapper) {
        super(n);
        this.zab = taskCompletionSource;
        this.zaa = taskApiCall;
        this.zad = statusExceptionMapper;
        if (n != 2) return;
        if (taskApiCall.shouldAutoResolveMissingFeatures()) throw new IllegalArgumentException("Best-effort write calls cannot pass methods that should auto-resolve missing features.");
    }

    public final Feature[] zaa(zabl<?> zabl2) {
        return this.zaa.zaa();
    }

    public final boolean zab(zabl<?> zabl2) {
        return this.zaa.shouldAutoResolveMissingFeatures();
    }

    public final void zac(Status status) {
        this.zab.trySetException(this.zad.getException(status));
    }

    public final void zad(Exception exception) {
        this.zab.trySetException(exception);
    }

    public final void zae(zaaa zaaa2, boolean bl) {
        zaaa2.zab(this.zab, bl);
    }

    public final void zaf(zabl<?> zabl2) throws DeadObjectException {
        try {
            this.zaa.doExecute((Api.AnyClient)zabl2.zaf(), this.zab);
            return;
        }
        catch (RuntimeException runtimeException) {
            this.zab.trySetException((Exception)runtimeException);
            return;
        }
        catch (RemoteException remoteException) {
            this.zac(zai.zah((RemoteException)remoteException));
            return;
        }
        catch (DeadObjectException deadObjectException) {
            throw deadObjectException;
        }
    }
}
