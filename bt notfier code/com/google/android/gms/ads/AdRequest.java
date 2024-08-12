/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.location.Location
 *  android.os.Bundle
 *  com.google.android.gms.ads.AdRequest$Builder
 *  com.google.android.gms.ads.mediation.MediationExtrasReceiver
 *  com.google.android.gms.ads.mediation.customevent.CustomEvent
 *  com.google.android.gms.internal.ads.zzbhj
 */
package com.google.android.gms.ads;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.mediation.MediationExtrasReceiver;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.internal.ads.zzbhj;
import java.util.List;
import java.util.Set;

public class AdRequest {
    public static final String DEVICE_ID_EMULATOR = "B3EEABB8EE11C2BE770B684D95219ECB";
    public static final int ERROR_CODE_APP_ID_MISSING = 8;
    public static final int ERROR_CODE_INTERNAL_ERROR = 0;
    public static final int ERROR_CODE_INVALID_AD_STRING = 11;
    public static final int ERROR_CODE_INVALID_REQUEST = 1;
    public static final int ERROR_CODE_MEDIATION_NO_FILL = 9;
    public static final int ERROR_CODE_NETWORK_ERROR = 2;
    public static final int ERROR_CODE_NO_FILL = 3;
    public static final int ERROR_CODE_REQUEST_ID_MISMATCH = 10;
    public static final int GENDER_FEMALE = 2;
    public static final int GENDER_MALE = 1;
    public static final int GENDER_UNKNOWN = 0;
    public static final int MAX_CONTENT_URL_LENGTH = 512;
    protected final zzbhj zza;

    protected AdRequest(Builder builder) {
        this.zza = new zzbhj(builder.zza, null);
    }

    public String getContentUrl() {
        return this.zza.zzb();
    }

    public <T extends CustomEvent> Bundle getCustomEventExtrasBundle(Class<T> clazz) {
        return this.zza.zzi(clazz);
    }

    public Bundle getCustomTargeting() {
        return this.zza.zzq();
    }

    public Set<String> getKeywords() {
        return this.zza.zze();
    }

    public Location getLocation() {
        return this.zza.zzf();
    }

    public List<String> getNeighboringContentUrls() {
        return this.zza.zzc();
    }

    public <T extends MediationExtrasReceiver> Bundle getNetworkExtrasBundle(Class<T> clazz) {
        return this.zza.zzh(clazz);
    }

    public boolean isTestDevice(Context context) {
        return this.zza.zzm(context);
    }

    public zzbhj zza() {
        return this.zza;
    }
}
