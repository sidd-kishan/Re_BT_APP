/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  androidx.work.Configuration
 *  androidx.work.Configuration$Builder
 *  androidx.work.Constraints
 *  androidx.work.Constraints$Builder
 *  androidx.work.Data
 *  androidx.work.Data$Builder
 *  androidx.work.NetworkType
 *  androidx.work.OneTimeWorkRequest
 *  androidx.work.OneTimeWorkRequest$Builder
 *  androidx.work.WorkManager
 *  androidx.work.WorkRequest
 *  com.google.android.gms.ads.internal.offline.buffering.OfflineNotificationPoster
 *  com.google.android.gms.ads.internal.offline.buffering.OfflinePingSender
 *  com.google.android.gms.ads.internal.util.zzbt
 *  com.google.android.gms.dynamic.IObjectWrapper
 *  com.google.android.gms.dynamic.ObjectWrapper
 *  com.google.android.gms.internal.ads.zzcgt
 */
package com.google.android.gms.ads.internal.util;

import android.content.Context;
import androidx.work.Configuration;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import androidx.work.WorkRequest;
import com.google.android.gms.ads.internal.offline.buffering.OfflineNotificationPoster;
import com.google.android.gms.ads.internal.offline.buffering.OfflinePingSender;
import com.google.android.gms.ads.internal.util.zzbt;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzcgt;

public class WorkManagerUtil
extends zzbt {
    /*
     * Enabled force condition propagation
     */
    private static void zzb(Context context) {
        try {
            context = context.getApplicationContext();
            Configuration.Builder builder = new Configuration.Builder();
            WorkManager.initialize((Context)context, (Configuration)builder.build());
            return;
        }
        catch (IllegalStateException illegalStateException) {
            return;
        }
    }

    public final boolean zze(IObjectWrapper iObjectWrapper, String string, String string2) {
        iObjectWrapper = (Context)ObjectWrapper.unwrap((IObjectWrapper)iObjectWrapper);
        WorkManagerUtil.zzb((Context)iObjectWrapper);
        Constraints constraints = new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build();
        string = new Data.Builder().putString("uri", string).putString("gws_query_id", string2).build();
        string = (OneTimeWorkRequest)((OneTimeWorkRequest.Builder)((OneTimeWorkRequest.Builder)((OneTimeWorkRequest.Builder)new OneTimeWorkRequest.Builder(OfflineNotificationPoster.class).setConstraints(constraints)).setInputData((Data)string)).addTag("offline_notification_work")).build();
        try {
            iObjectWrapper = WorkManager.getInstance((Context)iObjectWrapper);
        }
        catch (IllegalStateException illegalStateException) {
            zzcgt.zzj((String)"Failed to instantiate WorkManager.", (Throwable)illegalStateException);
            return false;
        }
        iObjectWrapper.enqueue((WorkRequest)string);
        return true;
    }

    public final void zzf(IObjectWrapper iObjectWrapper) {
        WorkManager workManager;
        iObjectWrapper = (Context)ObjectWrapper.unwrap((IObjectWrapper)iObjectWrapper);
        WorkManagerUtil.zzb((Context)iObjectWrapper);
        try {
            workManager = WorkManager.getInstance((Context)iObjectWrapper);
        }
        catch (IllegalStateException illegalStateException) {
            zzcgt.zzj((String)"Failed to instantiate WorkManager.", (Throwable)illegalStateException);
            return;
        }
        workManager.cancelAllWorkByTag("offline_ping_sender_work");
        iObjectWrapper = new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build();
        workManager.enqueue((WorkRequest)((OneTimeWorkRequest)((OneTimeWorkRequest.Builder)((OneTimeWorkRequest.Builder)new OneTimeWorkRequest.Builder(OfflinePingSender.class).setConstraints((Constraints)iObjectWrapper)).addTag("offline_ping_sender_work")).build()));
    }
}
