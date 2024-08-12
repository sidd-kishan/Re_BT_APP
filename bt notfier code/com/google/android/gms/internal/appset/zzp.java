/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.google.android.gms.appset.AppSetIdClient
 *  com.google.android.gms.appset.AppSetIdInfo
 *  com.google.android.gms.appset.zze
 *  com.google.android.gms.common.Feature
 *  com.google.android.gms.common.GoogleApiAvailabilityLight
 *  com.google.android.gms.common.api.Api
 *  com.google.android.gms.common.api.Api$AbstractClientBuilder
 *  com.google.android.gms.common.api.Api$ApiOptions
 *  com.google.android.gms.common.api.Api$ApiOptions$NoOptions
 *  com.google.android.gms.common.api.Api$ClientKey
 *  com.google.android.gms.common.api.ApiException
 *  com.google.android.gms.common.api.GoogleApi
 *  com.google.android.gms.common.api.GoogleApi$Settings
 *  com.google.android.gms.common.api.Status
 *  com.google.android.gms.common.api.internal.RemoteCall
 *  com.google.android.gms.common.api.internal.TaskApiCall
 *  com.google.android.gms.internal.appset.zzd
 *  com.google.android.gms.internal.appset.zzm
 *  com.google.android.gms.internal.appset.zzn
 *  com.google.android.gms.tasks.Task
 *  com.google.android.gms.tasks.Tasks
 */
package com.google.android.gms.internal.appset;

import android.content.Context;
import com.google.android.gms.appset.AppSetIdClient;
import com.google.android.gms.appset.AppSetIdInfo;
import com.google.android.gms.appset.zze;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.internal.appset.zzd;
import com.google.android.gms.internal.appset.zzm;
import com.google.android.gms.internal.appset.zzn;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;

public final class zzp
extends GoogleApi<Api.ApiOptions.NoOptions>
implements AppSetIdClient {
    private static final Api.ClientKey<zzd> zza;
    private static final Api.AbstractClientBuilder<zzd, Api.ApiOptions.NoOptions> zzb;
    private static final Api<Api.ApiOptions.NoOptions> zzc;
    private final Context zzd;
    private final GoogleApiAvailabilityLight zze;

    static {
        zzn zzn2;
        zza = new Api.ClientKey();
        zzb = zzn2 = new zzn();
        zzc = new Api("AppSet.API", (Api.AbstractClientBuilder)zzn2, zza);
    }

    zzp(Context context, GoogleApiAvailabilityLight googleApiAvailabilityLight) {
        super(context, zzc, (Api.ApiOptions)Api.ApiOptions.NO_OPTIONS, GoogleApi.Settings.DEFAULT_SETTINGS);
        this.zzd = context;
        this.zze = googleApiAvailabilityLight;
    }

    public final Task<AppSetIdInfo> getAppSetIdInfo() {
        if (this.zze.isGooglePlayServicesAvailable(this.zzd, 212800000) != 0) return Tasks.forException((Exception)new ApiException(new Status(17)));
        return this.doRead(TaskApiCall.builder().setFeatures(new Feature[]{com.google.android.gms.appset.zze.zza}).run((RemoteCall)new zzm(this)).setAutoResolveMissingFeatures(false).setMethodKey(27601).build());
    }
}
