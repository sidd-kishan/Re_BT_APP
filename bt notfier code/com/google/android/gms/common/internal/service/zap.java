/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  android.os.Looper
 *  com.google.android.gms.common.Feature
 *  com.google.android.gms.common.api.internal.ConnectionCallbacks
 *  com.google.android.gms.common.api.internal.OnConnectionFailedListener
 *  com.google.android.gms.common.internal.ClientSettings
 *  com.google.android.gms.common.internal.GmsClient
 *  com.google.android.gms.common.internal.TelemetryLoggingOptions
 *  com.google.android.gms.common.internal.service.zai
 *  com.google.android.gms.internal.base.zad
 */
package com.google.android.gms.common.internal.service;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.internal.ConnectionCallbacks;
import com.google.android.gms.common.api.internal.OnConnectionFailedListener;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;
import com.google.android.gms.common.internal.TelemetryLoggingOptions;
import com.google.android.gms.common.internal.service.zai;
import com.google.android.gms.internal.base.zad;

public final class zap
extends GmsClient<zai> {
    private final TelemetryLoggingOptions zaa;

    public zap(Context context, Looper looper, ClientSettings clientSettings, TelemetryLoggingOptions telemetryLoggingOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 270, clientSettings, connectionCallbacks, onConnectionFailedListener);
        this.zaa = telemetryLoggingOptions;
    }

    public final Feature[] getApiFeatures() {
        return zad.zab;
    }

    protected final Bundle getGetServiceRequestExtraArgs() {
        return this.zaa.zaa();
    }

    public final int getMinApkVersion() {
        return 203390000;
    }

    protected final String getServiceDescriptor() {
        return "com.google.android.gms.common.internal.service.IClientTelemetryService";
    }

    protected final String getStartServiceAction() {
        return "com.google.android.gms.common.telemetry.service.START";
    }

    protected final boolean getUseDynamicLookup() {
        return true;
    }
}
