/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.collection.ArrayMap
 *  com.google.android.gms.common.ConnectionResult
 *  com.google.android.gms.common.api.AvailabilityException
 *  com.google.android.gms.common.api.HasApiKey
 *  com.google.android.gms.common.api.internal.ApiKey
 *  com.google.android.gms.tasks.Task
 *  com.google.android.gms.tasks.TaskCompletionSource
 */
package com.google.android.gms.common.api.internal;

import androidx.collection.ArrayMap;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.AvailabilityException;
import com.google.android.gms.common.api.HasApiKey;
import com.google.android.gms.common.api.internal.ApiKey;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Map;
import java.util.Set;

public final class zal {
    private final ArrayMap<ApiKey<?>, ConnectionResult> zaa;
    private final ArrayMap<ApiKey<?>, String> zab = new ArrayMap();
    private final TaskCompletionSource<Map<ApiKey<?>, String>> zac = new TaskCompletionSource();
    private int zad;
    private boolean zae = false;

    public zal(Iterable<? extends HasApiKey<?>> object) {
        this.zaa = new ArrayMap();
        object = object.iterator();
        while (true) {
            if (!object.hasNext()) {
                this.zad = this.zaa.keySet().size();
                return;
            }
            HasApiKey hasApiKey = (HasApiKey)object.next();
            this.zaa.put((Object)hasApiKey.getApiKey(), null);
        }
    }

    public final Set<ApiKey<?>> zaa() {
        return this.zaa.keySet();
    }

    public final Task<Map<ApiKey<?>, String>> zab() {
        return this.zac.getTask();
    }

    public final void zac(ApiKey<?> availabilityException, ConnectionResult connectionResult, String string) {
        this.zaa.put(availabilityException, (Object)connectionResult);
        this.zab.put(availabilityException, (Object)string);
        --this.zad;
        if (!connectionResult.isSuccess()) {
            this.zae = true;
        }
        if (this.zad != 0) return;
        if (this.zae) {
            availabilityException = new AvailabilityException(this.zaa);
            this.zac.setException((Exception)availabilityException);
            return;
        }
        this.zac.setResult(this.zab);
    }
}
