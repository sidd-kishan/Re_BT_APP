/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.location.Location
 *  com.google.android.gms.ads.mediation.MediationAdRequest
 */
package com.google.android.gms.internal.ads;

import android.location.Location;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import java.util.Date;
import java.util.Set;

public final class zzbvy
implements MediationAdRequest {
    private final Date zza;
    private final int zzb;
    private final Set<String> zzc;
    private final boolean zzd;
    private final Location zze;
    private final int zzf;
    private final boolean zzg;
    private final String zzh;

    public zzbvy(Date date, int n, Set<String> set, Location location, boolean bl, int n2, boolean bl2, int n3, String string) {
        this.zza = date;
        this.zzb = n;
        this.zzc = set;
        this.zze = location;
        this.zzd = bl;
        this.zzf = n2;
        this.zzg = bl2;
        this.zzh = string;
    }

    @Deprecated
    public final Date getBirthday() {
        return this.zza;
    }

    @Deprecated
    public final int getGender() {
        return this.zzb;
    }

    public final Set<String> getKeywords() {
        return this.zzc;
    }

    public final Location getLocation() {
        return this.zze;
    }

    @Deprecated
    public final boolean isDesignedForFamilies() {
        return this.zzg;
    }

    public final boolean isTesting() {
        return this.zzd;
    }

    public final int taggedForChildDirectedTreatment() {
        return this.zzf;
    }
}
