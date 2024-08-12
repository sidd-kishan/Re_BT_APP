/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Looper
 *  android.os.Message
 *  android.util.Log
 *  android.util.Pair
 *  com.google.android.gms.common.api.Result
 *  com.google.android.gms.common.api.ResultCallback
 *  com.google.android.gms.common.api.Status
 *  com.google.android.gms.common.api.internal.BasePendingResult
 *  com.google.android.gms.common.internal.Preconditions
 *  com.google.android.gms.internal.base.zap
 */
package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BasePendingResult;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.base.zap;

/*
 * Exception performing whole class analysis ignored.
 */
public static class BasePendingResult.CallbackHandler<R extends Result>
extends zap {
    public BasePendingResult.CallbackHandler() {
        super(Looper.getMainLooper());
    }

    public BasePendingResult.CallbackHandler(Looper looper) {
        super(looper);
    }

    public final void handleMessage(Message object) {
        int n = ((Message)object).what;
        if (n != 1) {
            if (n != 2) {
                n = ((Message)object).what;
                object = new StringBuilder(45);
                ((StringBuilder)object).append("Don't know how to handle message: ");
                ((StringBuilder)object).append(n);
                Log.wtf((String)"BasePendingResult", (String)((StringBuilder)object).toString(), (Throwable)new Exception());
                return;
            }
            ((BasePendingResult)((Message)object).obj).forceFailureUnlessReady(Status.RESULT_TIMEOUT);
            return;
        }
        object = (Pair)((Message)object).obj;
        ResultCallback resultCallback = (ResultCallback)((Pair)object).first;
        object = (Result)((Pair)object).second;
        try {
            resultCallback.onResult((Result)object);
            return;
        }
        catch (RuntimeException runtimeException) {
            BasePendingResult.zal((Result)object);
            throw runtimeException;
        }
    }

    public final void zaa(ResultCallback<? super R> resultCallback, R r) {
        int n = BasePendingResult.zad;
        this.sendMessage(this.obtainMessage(1, new Pair((Object)((ResultCallback)Preconditions.checkNotNull(resultCallback)), r)));
    }
}
