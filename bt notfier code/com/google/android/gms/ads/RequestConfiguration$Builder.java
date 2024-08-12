/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.RequestConfiguration
 *  com.google.android.gms.internal.ads.zzcgt
 */
package com.google.android.gms.ads;

import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.internal.ads.zzcgt;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;

public static class RequestConfiguration.Builder {
    private int zza = -1;
    private int zzb = -1;
    @Nullable
    private String zzc = null;
    private final List<String> zzd = new ArrayList<String>();

    public RequestConfiguration build() {
        return new RequestConfiguration(this.zza, this.zzb, this.zzc, this.zzd, null);
    }

    public RequestConfiguration.Builder setMaxAdContentRating(@Nullable String string) {
        if (string != null && !"".equals(string)) {
            if (!("G".equals(string) || "PG".equals(string) || "T".equals(string) || "MA".equals(string))) {
                string = string.length() != 0 ? "Invalid value passed to setMaxAdContentRating: ".concat(string) : new String("Invalid value passed to setMaxAdContentRating: ");
                zzcgt.zzi((String)string);
            } else {
                this.zzc = string;
            }
        } else {
            this.zzc = null;
        }
        return this;
    }

    public RequestConfiguration.Builder setTagForChildDirectedTreatment(int n) {
        if (n != -1 && n != 0 && n != 1) {
            StringBuilder stringBuilder = new StringBuilder(68);
            stringBuilder.append("Invalid value passed to setTagForChildDirectedTreatment: ");
            stringBuilder.append(n);
            zzcgt.zzi((String)stringBuilder.toString());
        } else {
            this.zza = n;
        }
        return this;
    }

    public RequestConfiguration.Builder setTagForUnderAgeOfConsent(int n) {
        if (n != -1 && n != 0 && n != 1) {
            StringBuilder stringBuilder = new StringBuilder(63);
            stringBuilder.append("Invalid value passed to setTagForUnderAgeOfConsent: ");
            stringBuilder.append(n);
            zzcgt.zzi((String)stringBuilder.toString());
        } else {
            this.zzb = n;
        }
        return this;
    }

    public RequestConfiguration.Builder setTestDeviceIds(@Nullable List<String> list) {
        this.zzd.clear();
        if (list == null) return this;
        this.zzd.addAll(list);
        return this;
    }
}
