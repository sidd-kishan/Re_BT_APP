/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  com.google.android.gms.ads.AdSize
 *  com.google.android.gms.ads.mediation.MediationConfiguration
 */
package com.google.android.gms.ads.mediation.rtb;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.mediation.MediationConfiguration;
import java.util.List;

public class RtbSignalData {
    private final Context zza;
    private final List<MediationConfiguration> zzb;
    private final Bundle zzc;
    private final AdSize zzd;

    public RtbSignalData(Context context, List<MediationConfiguration> list, Bundle bundle, AdSize adSize) {
        this.zza = context;
        this.zzb = list;
        this.zzc = bundle;
        this.zzd = adSize;
    }

    public AdSize getAdSize() {
        return this.zzd;
    }

    @Deprecated
    public MediationConfiguration getConfiguration() {
        List<MediationConfiguration> list = this.zzb;
        if (list == null) return null;
        if (list.size() <= 0) return null;
        return this.zzb.get(0);
    }

    public List<MediationConfiguration> getConfigurations() {
        return this.zzb;
    }

    public Context getContext() {
        return this.zza;
    }

    public Bundle getNetworkExtras() {
        return this.zzc;
    }
}
