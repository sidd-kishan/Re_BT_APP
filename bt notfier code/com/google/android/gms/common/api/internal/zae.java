/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.DeadObjectException
 *  android.util.Log
 *  com.google.android.gms.common.api.Api$AnyClient
 *  com.google.android.gms.common.api.Result
 *  com.google.android.gms.common.api.Status
 *  com.google.android.gms.common.api.internal.BaseImplementation$ApiMethodImpl
 *  com.google.android.gms.common.api.internal.zaaa
 *  com.google.android.gms.common.api.internal.zabl
 *  com.google.android.gms.common.api.internal.zai
 *  com.google.android.gms.common.internal.Preconditions
 */
package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.util.Log;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.api.internal.zaaa;
import com.google.android.gms.common.api.internal.zabl;
import com.google.android.gms.common.api.internal.zai;
import com.google.android.gms.common.internal.Preconditions;

public final class zae<A extends BaseImplementation.ApiMethodImpl<? extends Result, Api.AnyClient>>
extends zai {
    protected final A zaa;

    public zae(int n, A a) {
        super(n);
        this.zaa = (BaseImplementation.ApiMethodImpl)Preconditions.checkNotNull(a, (Object)"Null methods are not runnable.");
    }

    public final void zac(Status status) {
        try {
            this.zaa.setFailedResult(status);
            return;
        }
        catch (IllegalStateException illegalStateException) {
            Log.w((String)"ApiCallRunner", (String)"Exception reporting failure", (Throwable)illegalStateException);
            return;
        }
    }

    public final void zad(Exception serializable) {
        String string = serializable.getClass().getSimpleName();
        String string2 = ((Throwable)serializable).getLocalizedMessage();
        serializable = new StringBuilder(String.valueOf(string).length() + 2 + String.valueOf(string2).length());
        ((StringBuilder)serializable).append(string);
        ((StringBuilder)serializable).append(": ");
        ((StringBuilder)serializable).append(string2);
        serializable = new Status(10, ((StringBuilder)serializable).toString());
        try {
            this.zaa.setFailedResult((Status)serializable);
            return;
        }
        catch (IllegalStateException illegalStateException) {
            Log.w((String)"ApiCallRunner", (String)"Exception reporting failure", (Throwable)illegalStateException);
            return;
        }
    }

    public final void zae(zaaa zaaa2, boolean bl) {
        zaaa2.zaa(this.zaa, bl);
    }

    public final void zaf(zabl<?> zabl2) throws DeadObjectException {
        try {
            this.zaa.run((Api.AnyClient)zabl2.zaf());
            return;
        }
        catch (RuntimeException runtimeException) {
            this.zad(runtimeException);
            return;
        }
    }
}
