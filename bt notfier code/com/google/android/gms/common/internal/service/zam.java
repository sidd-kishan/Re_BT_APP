/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.common.api.internal.RemoteCall
 *  com.google.android.gms.common.internal.TelemetryData
 *  com.google.android.gms.common.internal.service.zai
 *  com.google.android.gms.common.internal.service.zao
 *  com.google.android.gms.common.internal.service.zap
 *  com.google.android.gms.tasks.TaskCompletionSource
 */
package com.google.android.gms.common.internal.service;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.internal.TelemetryData;
import com.google.android.gms.common.internal.service.zai;
import com.google.android.gms.common.internal.service.zao;
import com.google.android.gms.common.internal.service.zap;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zam
implements RemoteCall {
    private final TelemetryData zaa;

    zam(TelemetryData telemetryData) {
        this.zaa = telemetryData;
    }

    public final void accept(Object object, Object object2) {
        TelemetryData telemetryData = this.zaa;
        object = (zap)object;
        object2 = (TaskCompletionSource)object2;
        int n = zao.zab;
        ((zai)object.getService()).zae(telemetryData);
        object2.setResult(null);
    }
}
