/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.common.api.ApiException
 *  com.google.android.gms.common.api.PendingResult$StatusListener
 *  com.google.android.gms.common.api.Result
 *  com.google.android.gms.common.api.Status
 *  com.google.android.gms.common.api.internal.BasePendingResult
 *  com.google.android.gms.common.api.internal.GoogleApiManager
 *  com.google.android.gms.common.api.internal.zay
 *  com.google.android.gms.common.api.internal.zaz
 *  com.google.android.gms.tasks.OnCompleteListener
 *  com.google.android.gms.tasks.TaskCompletionSource
 */
package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BasePendingResult;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.common.api.internal.zay;
import com.google.android.gms.common.api.internal.zaz;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

public final class zaaa {
    private final Map<BasePendingResult<?>, Boolean> zaa = Collections.synchronizedMap(new WeakHashMap());
    private final Map<TaskCompletionSource<?>, Boolean> zab = Collections.synchronizedMap(new WeakHashMap());

    static /* synthetic */ Map zaf(zaaa zaaa2) {
        return zaaa2.zaa;
    }

    static /* synthetic */ Map zag(zaaa zaaa2) {
        return zaaa2.zab;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled unnecessary exception pruning
     * Converted monitor instructions to comments
     */
    private final void zah(boolean bl, Status status) {
        Object object2 = this.zaa;
        // MONITORENTER : object2
        Iterator iterator = new Iterator(this.zaa);
        // MONITOREXIT : object2
        Object object32 = this.zab;
        object2 = new HashMap(this.zab);
        for (Object object32 : iterator.entrySet()) {
            if (!bl && !((Boolean)object32.getValue()).booleanValue()) continue;
            ((BasePendingResult)object32.getKey()).forceFailureUnlessReady(status);
        }
        iterator = object2.entrySet().iterator();
        while (iterator.hasNext()) {
            object2 = iterator.next();
            if (!bl && !((Boolean)object2.getValue()).booleanValue()) continue;
            ((TaskCompletionSource)object2.getKey()).trySetException((Exception)new ApiException(status));
        }
        return;
        finally {
            // MONITORENTER : object32
        }
    }

    final void zaa(BasePendingResult<? extends Result> basePendingResult, boolean bl) {
        this.zaa.put(basePendingResult, bl);
        basePendingResult.addStatusListener((PendingResult.StatusListener)new zay(this, basePendingResult));
    }

    final <TResult> void zab(TaskCompletionSource<TResult> taskCompletionSource, boolean bl) {
        this.zab.put(taskCompletionSource, bl);
        taskCompletionSource.getTask().addOnCompleteListener((OnCompleteListener)new zaz(this, taskCompletionSource));
    }

    final boolean zac() {
        if (!this.zaa.isEmpty()) return true;
        if (this.zab.isEmpty()) return false;
        return true;
    }

    public final void zad() {
        this.zah(false, GoogleApiManager.zaa);
    }

    final void zae(int n, String string) {
        StringBuilder stringBuilder = new StringBuilder("The connection to Google Play services was lost");
        if (n == 1) {
            stringBuilder.append(" due to service disconnection.");
        } else if (n == 3) {
            stringBuilder.append(" due to dead object exception.");
        }
        if (string != null) {
            stringBuilder.append(" Last reason for disconnect: ");
            stringBuilder.append(string);
        }
        this.zah(true, new Status(20, stringBuilder.toString()));
    }
}
