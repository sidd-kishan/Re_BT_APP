/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.location.Location
 *  android.os.Bundle
 *  com.google.android.gms.ads.AdSize
 *  com.google.android.gms.ads.mediation.MediationAdConfiguration
 */
package com.google.android.gms.ads.mediation;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.mediation.MediationAdConfiguration;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public class MediationBannerAdConfiguration
extends MediationAdConfiguration {
    private final AdSize zza;

    public MediationBannerAdConfiguration(Context context, String string, Bundle bundle, Bundle bundle2, boolean bl, Location location, int n, int n2, String string2, AdSize adSize, String string3) {
        super(context, string, bundle, bundle2, bl, location, n, n2, string2, string3);
        this.zza = adSize;
    }

    public AdSize getAdSize() {
        return this.zza;
    }
}