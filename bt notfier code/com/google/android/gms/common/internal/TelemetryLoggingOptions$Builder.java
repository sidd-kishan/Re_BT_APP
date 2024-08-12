/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.common.internal.TelemetryLoggingOptions
 *  com.google.android.gms.common.internal.zaac
 */
package com.google.android.gms.common.internal;

import com.google.android.gms.common.internal.TelemetryLoggingOptions;
import com.google.android.gms.common.internal.zaac;

public static class TelemetryLoggingOptions.Builder {
    private String zaa;

    private TelemetryLoggingOptions.Builder() {
    }

    /* synthetic */ TelemetryLoggingOptions.Builder(zaac zaac2) {
    }

    public TelemetryLoggingOptions build() {
        return new TelemetryLoggingOptions(this.zaa, null);
    }

    public TelemetryLoggingOptions.Builder setApi(String string) {
        this.zaa = string;
        return this;
    }
}
