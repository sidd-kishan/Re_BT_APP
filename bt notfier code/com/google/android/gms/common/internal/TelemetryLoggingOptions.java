/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  com.google.android.gms.common.api.Api$ApiOptions$Optional
 *  com.google.android.gms.common.internal.Objects
 *  com.google.android.gms.common.internal.TelemetryLoggingOptions$Builder
 *  com.google.android.gms.common.internal.zaac
 */
package com.google.android.gms.common.internal;

import android.os.Bundle;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.TelemetryLoggingOptions;
import com.google.android.gms.common.internal.zaac;

public class TelemetryLoggingOptions
implements Api.ApiOptions.Optional {
    public static final TelemetryLoggingOptions zaa = TelemetryLoggingOptions.builder().build();
    private final String zab;

    /* synthetic */ TelemetryLoggingOptions(String string, zaac zaac2) {
        this.zab = string;
    }

    public static Builder builder() {
        return new Builder(null);
    }

    public final boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof TelemetryLoggingOptions)) {
            return false;
        }
        object = (TelemetryLoggingOptions)object;
        return Objects.equal((Object)this.zab, (Object)((TelemetryLoggingOptions)object).zab);
    }

    public final int hashCode() {
        return Objects.hashCode((Object[])new Object[]{this.zab});
    }

    public final Bundle zaa() {
        Bundle bundle = new Bundle();
        String string = this.zab;
        if (string == null) return bundle;
        bundle.putString("api", string);
        return bundle;
    }
}
