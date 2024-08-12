/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.location.Location
 *  com.google.ads.AdRequest$Gender
 */
package com.google.ads.mediation;

import android.location.Location;
import com.google.ads.AdRequest;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;

@Deprecated
public class MediationAdRequest {
    private final Date zza;
    private final AdRequest.Gender zzb;
    private final Set<String> zzc;
    private final boolean zzd;
    private final Location zze;

    public MediationAdRequest(Date date, AdRequest.Gender gender, Set<String> set, boolean bl, Location location) {
        this.zza = date;
        this.zzb = gender;
        this.zzc = set;
        this.zzd = bl;
        this.zze = location;
    }

    public Integer getAgeInYears() {
        if (this.zza == null) return null;
        Calendar calendar = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        calendar.setTime(this.zza);
        Integer n = calendar2.get(1) - calendar.get(1);
        if (calendar2.get(2) < calendar.get(2)) return n - 1;
        if (calendar2.get(2) != calendar.get(2)) return n;
        if (calendar2.get(5) >= calendar.get(5)) return n;
        return n - 1;
    }

    public Date getBirthday() {
        return this.zza;
    }

    public AdRequest.Gender getGender() {
        return this.zzb;
    }

    public Set<String> getKeywords() {
        return this.zzc;
    }

    public Location getLocation() {
        return this.zze;
    }

    public boolean isTesting() {
        return this.zzd;
    }
}
