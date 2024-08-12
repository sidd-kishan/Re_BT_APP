/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  com.google.android.gms.common.api.Releasable
 *  com.google.android.gms.common.api.Result
 *  com.google.android.gms.common.api.ResultCallback
 *  com.google.android.gms.common.api.Status
 */
package com.google.android.gms.common.api;

import android.util.Log;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;

public abstract class ResultCallbacks<R extends Result>
implements ResultCallback<R> {
    public abstract void onFailure(Status var1);

    public final void onResult(R object) {
        Status status = object.getStatus();
        if (status.isSuccess()) {
            this.onSuccess(object);
            return;
        }
        this.onFailure(status);
        if (!(object instanceof Releasable)) return;
        try {
            ((Releasable)object).release();
            return;
        }
        catch (RuntimeException runtimeException) {
            String string = String.valueOf(object);
            object = new StringBuilder(String.valueOf(string).length() + 18);
            ((StringBuilder)object).append("Unable to release ");
            ((StringBuilder)object).append(string);
            Log.w((String)"ResultCallbacks", (String)((StringBuilder)object).toString(), (Throwable)runtimeException);
        }
    }

    public abstract void onSuccess(R var1);
}
