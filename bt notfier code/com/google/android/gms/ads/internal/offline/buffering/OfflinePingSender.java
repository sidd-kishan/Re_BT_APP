/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.RemoteException
 *  androidx.work.ListenableWorker$Result
 *  androidx.work.Worker
 *  androidx.work.WorkerParameters
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
import com.google.android.gms.internal.ads.zzber;
import com.google.android.gms.internal.ads.zzbvd;
import com.google.android.gms.internal.ads.zzbvg;
import com.google.android.gms.internal.ads.zzbze;

public class OfflinePingSender
extends Worker {
    private final zzbze zza;

    public OfflinePingSender(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        this.zza = zzber.zzb().zzr(context, (zzbvg)new zzbvd());
    }

    public final ListenableWorker.Result doWork() {
        try {
            this.zza.zzg();
            ListenableWorker.Result result = ListenableWorker.Result.success();
            return result;
        }
        catch (RemoteException remoteException) {
            return ListenableWorker.Result.failure();
        }
    }
}
