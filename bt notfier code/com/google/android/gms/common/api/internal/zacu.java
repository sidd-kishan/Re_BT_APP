/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Looper
 *  android.os.Message
 *  android.util.Log
 *  com.google.android.gms.common.api.PendingResult
 *  com.google.android.gms.common.api.Status
 *  com.google.android.gms.common.api.internal.zack
 *  com.google.android.gms.common.api.internal.zacv
 *  com.google.android.gms.common.internal.Preconditions
 *  com.google.android.gms.internal.base.zap
 */
package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zack;
import com.google.android.gms.common.api.internal.zacv;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.base.zap;

final class zacu
extends zap {
    final zacv zaa;

    public zacu(zacv zacv2, Looper looper) {
        this.zaa = zacv2;
        super(looper);
    }

    public final void handleMessage(Message object) {
        int n = ((Message)object).what;
        if (n != 0) {
            if (n != 1) {
                n = ((Message)object).what;
                object = new StringBuilder(70);
                ((StringBuilder)object).append("TransformationResultHandler received unknown message type: ");
                ((StringBuilder)object).append(n);
                Log.e((String)"TransformedResultImpl", (String)((StringBuilder)object).toString());
                return;
            }
            RuntimeException runtimeException = (RuntimeException)((Message)object).obj;
            object = String.valueOf(runtimeException.getMessage());
            object = ((String)object).length() != 0 ? "Runtime exception on the transformation worker thread: ".concat((String)object) : new String("Runtime exception on the transformation worker thread: ");
            Log.e((String)"TransformedResultImpl", (String)object);
            throw runtimeException;
        }
        PendingResult pendingResult = (PendingResult)((Message)object).obj;
        object = zacv.zag((zacv)this.zaa);
        synchronized (object) {
            zacv zacv2 = (zacv)Preconditions.checkNotNull((Object)zacv.zah((zacv)this.zaa));
            if (pendingResult == null) {
                pendingResult = new Status(13, "Transform returned null");
                zacv.zai((zacv)zacv2, (Status)pendingResult);
            } else if (pendingResult instanceof zack) {
                zacv.zai((zacv)zacv2, (Status)((zack)pendingResult).zaa());
            } else {
                zacv2.zaa(pendingResult);
            }
            return;
        }
    }
}
