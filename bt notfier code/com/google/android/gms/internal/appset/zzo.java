/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.appset.AppSetIdInfo
 *  com.google.android.gms.appset.zzc
 *  com.google.android.gms.common.api.Status
 *  com.google.android.gms.common.api.internal.TaskUtil
 *  com.google.android.gms.internal.appset.zze
 *  com.google.android.gms.internal.appset.zzp
 *  com.google.android.gms.tasks.TaskCompletionSource
 */
package com.google.android.gms.internal.appset;

import com.google.android.gms.appset.AppSetIdInfo;
import com.google.android.gms.appset.zzc;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.internal.appset.zze;
import com.google.android.gms.internal.appset.zzp;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzo
extends zze {
    final TaskCompletionSource zza;

    zzo(zzp zzp2, TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    public final void zzb(Status status, zzc object) {
        object = object != null ? new AppSetIdInfo(object.zzb(), object.zza()) : null;
        TaskUtil.setResultOrApiException((Status)status, (Object)object, (TaskCompletionSource)this.zza);
    }
}
