/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.google.android.gms.common.Feature
 *  com.google.android.gms.common.api.Api
 *  com.google.android.gms.common.api.Api$AbstractClientBuilder
 *  com.google.android.gms.common.api.Api$ApiOptions
 *  com.google.android.gms.common.api.Api$ClientKey
 *  com.google.android.gms.common.api.GoogleApi
 *  com.google.android.gms.common.api.GoogleApi$Settings
 *  com.google.android.gms.common.api.internal.RemoteCall
 *  com.google.android.gms.common.api.internal.TaskApiCall
 *  com.google.android.gms.common.api.internal.TaskApiCall$Builder
 *  com.google.android.gms.common.internal.TelemetryData
 *  com.google.android.gms.common.internal.TelemetryLoggingClient
 *  com.google.android.gms.common.internal.TelemetryLoggingOptions
 *  com.google.android.gms.common.internal.service.zam
 *  com.google.android.gms.common.internal.service.zan
 *  com.google.android.gms.common.internal.service.zap
 *  com.google.android.gms.internal.base.zad
 *  com.google.android.gms.tasks.Task
 */
package com.google.android.gms.common.internal.service;

import android.content.Context;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.internal.TelemetryData;
import com.google.android.gms.common.internal.TelemetryLoggingClient;
import com.google.android.gms.common.internal.TelemetryLoggingOptions;
import com.google.android.gms.common.internal.service.zam;
import com.google.android.gms.common.internal.service.zan;
import com.google.android.gms.common.internal.service.zap;
import com.google.android.gms.internal.base.zad;
import com.google.android.gms.tasks.Task;

public final class zao
extends GoogleApi<TelemetryLoggingOptions>
implements TelemetryLoggingClient {
    public static final int zab = 0;
    private static final Api.ClientKey<zap> zac;
    private static final Api.AbstractClientBuilder<zap, TelemetryLoggingOptions> zad;
    private static final Api<TelemetryLoggingOptions> zae;

    static {
        zan zan2;
        zac = new Api.ClientKey();
        zad = zan2 = new zan();
        zae = new Api("ClientTelemetry.API", (Api.AbstractClientBuilder)zan2, zac);
    }

    public zao(Context context, TelemetryLoggingOptions telemetryLoggingOptions) {
        super(context, zae, (Api.ApiOptions)telemetryLoggingOptions, GoogleApi.Settings.DEFAULT_SETTINGS);
    }

    public final Task<Void> log(TelemetryData telemetryData) {
        TaskApiCall.Builder builder = TaskApiCall.builder();
        builder.setFeatures(new Feature[]{com.google.android.gms.internal.base.zad.zaa});
        builder.setAutoResolveMissingFeatures(false);
        builder.run((RemoteCall)new zam(telemetryData));
        return this.doBestEffortWrite(builder.build());
    }
}
