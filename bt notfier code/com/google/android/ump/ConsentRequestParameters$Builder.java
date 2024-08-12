/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.ump.ConsentDebugSettings
 *  com.google.android.ump.ConsentRequestParameters
 */
package com.google.android.ump;

import com.google.android.ump.ConsentDebugSettings;
import com.google.android.ump.ConsentRequestParameters;

public static final class ConsentRequestParameters.Builder {
    private boolean zza;
    private int zzb = 0;
    private String zzc;
    private ConsentDebugSettings zzd;

    static /* synthetic */ boolean zza(ConsentRequestParameters.Builder builder) {
        return builder.zza;
    }

    static /* synthetic */ String zzb(ConsentRequestParameters.Builder builder) {
        return builder.zzc;
    }

    static /* synthetic */ ConsentDebugSettings zzc(ConsentRequestParameters.Builder builder) {
        return builder.zzd;
    }

    public final ConsentRequestParameters build() {
        return new ConsentRequestParameters(this, null);
    }

    public final ConsentRequestParameters.Builder setAdMobAppId(String string) {
        this.zzc = string;
        return this;
    }

    public final ConsentRequestParameters.Builder setConsentDebugSettings(ConsentDebugSettings consentDebugSettings) {
        this.zzd = consentDebugSettings;
        return this;
    }

    public final ConsentRequestParameters.Builder setTagForUnderAgeOfConsent(boolean bl) {
        this.zza = bl;
        return this;
    }
}
