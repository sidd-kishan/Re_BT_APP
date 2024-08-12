/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.common.internal.RootTelemetryConfiguration
 */
package com.google.android.gms.common.internal;

import com.google.android.gms.common.internal.RootTelemetryConfiguration;

public final class RootTelemetryConfigManager {
    private static RootTelemetryConfigManager zza;
    private static final RootTelemetryConfiguration zzb;
    private RootTelemetryConfiguration zzc;

    static {
        zzb = new RootTelemetryConfiguration(0, false, false, 0, 0);
    }

    private RootTelemetryConfigManager() {
    }

    public static RootTelemetryConfigManager getInstance() {
        synchronized (RootTelemetryConfigManager.class) {
            RootTelemetryConfigManager rootTelemetryConfigManager;
            if (zza == null) {
                zza = rootTelemetryConfigManager = new RootTelemetryConfigManager();
            }
            rootTelemetryConfigManager = zza;
            return rootTelemetryConfigManager;
        }
    }

    public RootTelemetryConfiguration getConfig() {
        return this.zzc;
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public final void zza(RootTelemetryConfiguration rootTelemetryConfiguration) {
        synchronized (this) {
            if (rootTelemetryConfiguration == null) {
                this.zzc = zzb;
                return;
            }
            RootTelemetryConfiguration rootTelemetryConfiguration2 = this.zzc;
            if (rootTelemetryConfiguration2 != null) {
                int n;
                int n2 = rootTelemetryConfiguration2.getVersion();
                if (n2 >= (n = rootTelemetryConfiguration.getVersion())) return;
            }
            this.zzc = rootTelemetryConfiguration;
            return;
        }
    }
}
