/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.location.Location
 *  android.os.Bundle
 */
package com.google.android.gms.ads.mediation;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public class MediationAdConfiguration {
    public static final int TAG_FOR_CHILD_DIRECTED_TREATMENT_FALSE = 0;
    public static final int TAG_FOR_CHILD_DIRECTED_TREATMENT_TRUE = 1;
    public static final int TAG_FOR_CHILD_DIRECTED_TREATMENT_UNSPECIFIED = -1;
    private final String zza;
    private final Bundle zzb;
    private final Bundle zzc;
    private final Context zzd;
    private final boolean zze;
    private final Location zzf;
    private final int zzg;
    private final int zzh;
    private final String zzi;
    private final String zzj;

    public MediationAdConfiguration(Context context, String string, Bundle bundle, Bundle bundle2, boolean bl, Location location, int n, int n2, String string2, String string3) {
        this.zza = string;
        this.zzb = bundle;
        this.zzc = bundle2;
        this.zzd = context;
        this.zze = bl;
        this.zzf = location;
        this.zzg = n;
        this.zzh = n2;
        this.zzi = string2;
        this.zzj = string3;
    }

    public String getBidResponse() {
        return this.zza;
    }

    public Context getContext() {
        return this.zzd;
    }

    public Location getLocation() {
        return this.zzf;
    }

    public String getMaxAdContentRating() {
        return this.zzi;
    }

    public Bundle getMediationExtras() {
        return this.zzc;
    }

    public Bundle getServerParameters() {
        return this.zzb;
    }

    public String getWatermark() {
        return this.zzj;
    }

    public boolean isTestRequest() {
        return this.zze;
    }

    public int taggedForChildDirectedTreatment() {
        return this.zzg;
    }

    public int taggedForUnderAgeTreatment() {
        return this.zzh;
    }
}
