/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.google.android.gms.appset.AppSetIdClient
 *  com.google.android.gms.appset.AppSetIdInfo
 *  com.google.android.gms.common.GoogleApiAvailabilityLight
 *  com.google.android.gms.common.api.ApiException
 *  com.google.android.gms.internal.appset.zzl
 *  com.google.android.gms.internal.appset.zzp
 *  com.google.android.gms.internal.appset.zzq
 *  com.google.android.gms.tasks.Continuation
 *  com.google.android.gms.tasks.Task
 *  com.google.android.gms.tasks.Tasks
 */
package com.google.android.gms.internal.appset;

import android.content.Context;
import com.google.android.gms.appset.AppSetIdClient;
import com.google.android.gms.appset.AppSetIdInfo;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.internal.appset.zzl;
import com.google.android.gms.internal.appset.zzp;
import com.google.android.gms.internal.appset.zzq;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;

public final class zzr
implements AppSetIdClient {
    private final AppSetIdClient zza;
    private final AppSetIdClient zzb;

    public zzr(Context context) {
        GoogleApiAvailabilityLight googleApiAvailabilityLight = GoogleApiAvailabilityLight.getInstance();
        this.zza = new zzp(context, googleApiAvailabilityLight);
        this.zzb = zzl.zzc((Context)context);
    }

    public static /* synthetic */ Task zza(zzr zzr2, Task task) {
        Task task2 = task;
        if (task.isSuccessful()) return task2;
        if (task.isCanceled()) {
            task2 = task;
        } else {
            Exception exception = task.getException();
            task2 = task;
            if (!(exception instanceof ApiException)) return task2;
            int n = ((ApiException)exception).getStatusCode();
            if (n != 43001 && n != 43002 && n != 43003 && n != 17) {
                if (n == 43000) {
                    task2 = Tasks.forException((Exception)new Exception("Failed to get app set ID due to an internal error. Please try again later."));
                } else {
                    if (n == 15) return Tasks.forException((Exception)new Exception("The operation to get app set ID timed out. Please try again later."));
                    task2 = task;
                }
            } else {
                task2 = zzr2.zzb.getAppSetIdInfo();
            }
        }
        return task2;
    }

    public final Task<AppSetIdInfo> getAppSetIdInfo() {
        return this.zza.getAppSetIdInfo().continueWithTask((Continuation)new zzq(this));
    }
}
