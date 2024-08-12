/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.location.Location
 *  android.os.Bundle
 *  com.google.android.gms.ads.mediation.MediationAdConfiguration
 *  com.google.android.gms.ads.nativead.NativeAdOptions
 *  com.google.android.gms.internal.ads.zzblv
 */
package com.google.android.gms.ads.mediation;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.android.gms.ads.mediation.MediationAdConfiguration;
import com.google.android.gms.ads.nativead.NativeAdOptions;
import com.google.android.gms.internal.ads.zzblv;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public class MediationNativeAdConfiguration
extends MediationAdConfiguration {
    private final zzblv zza;

    public MediationNativeAdConfiguration(Context context, String string, Bundle bundle, Bundle bundle2, boolean bl, Location location, int n, int n2, String string2, String string3, zzblv zzblv2) {
        super(context, string, bundle, bundle2, bl, location, n, n2, string2, string3);
        this.zza = zzblv2;
    }

    public NativeAdOptions getNativeAdOptions() {
        return zzblv.zza((zzblv)this.zza);
    }
}
