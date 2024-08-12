/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.RemoteException
 *  androidx.work.ListenableWorker$Result
 *  androidx.work.Worker
 *  androidx.work.WorkerParameters
 *  com.google.android.gms.dynamic.ObjectWrapper
 *  com.google.android.gms.internal.ads.zzber
 *  com.google.android.gms.internal.ads.zzbvd
 *  com.google.android.gms.internal.ads.zzbvg
 *  com.google.android.gms.internal.ads.zzbze
 */
package com.google.android.gms.ads.internal.offline.buffering;

import android.content.Context;
import android.os.RemoteException;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzber;
import com.google.android.gms.internal.ads.zzbvd;
import com.google.android.gms.internal.ads.zzbvg;
import com.google.android.gms.internal.ads.zzbze;

public class OfflineNotificationPoster
extends Worker {
    private final zzbze zza;

    public OfflineNotificationPoster(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        this.zza = zzber.zzb().zzr(context, (zzbvg)new zzbvd());
    }

    public final ListenableWorker.Result doWork() {
        String string = this.getInputData().getString("uri");
        String string2 = this.getInputData().getString("gws_query_id");
        try {
            this.zza.zzf(ObjectWrapper.wrap((Object)this.getApplicationContext()), string, string2);
            string = ListenableWorker.Result.success();
            return string;
        }
        catch (RemoteException remoteException) {
            return ListenableWorker.Result.failure();
        }
    }
}
