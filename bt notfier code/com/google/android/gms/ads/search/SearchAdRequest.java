/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.location.Location
 *  android.os.Bundle
 *  com.google.android.gms.ads.mediation.MediationAdapter
 *  com.google.android.gms.ads.mediation.NetworkExtras
 *  com.google.android.gms.ads.mediation.customevent.CustomEvent
 *  com.google.android.gms.ads.search.zzb
 *  com.google.android.gms.ads.search.zzc
 *  com.google.android.gms.internal.ads.zzbhj
 */
package com.google.android.gms.ads.search;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.ads.search.zzb;
import com.google.android.gms.ads.search.zzc;
import com.google.android.gms.internal.ads.zzbhj;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;

@Deprecated
public final class SearchAdRequest {
    public static final int BORDER_TYPE_DASHED = 1;
    public static final int BORDER_TYPE_DOTTED = 2;
    public static final int BORDER_TYPE_NONE = 0;
    public static final int BORDER_TYPE_SOLID = 3;
    public static final int CALL_BUTTON_COLOR_DARK = 2;
    public static final int CALL_BUTTON_COLOR_LIGHT = 0;
    public static final int CALL_BUTTON_COLOR_MEDIUM = 1;
    public static final String DEVICE_ID_EMULATOR = "B3EEABB8EE11C2BE770B684D95219ECB";
    public static final int ERROR_CODE_INTERNAL_ERROR = 0;
    public static final int ERROR_CODE_INVALID_REQUEST = 1;
    public static final int ERROR_CODE_NETWORK_ERROR = 2;
    public static final int ERROR_CODE_NO_FILL = 3;
    @NotOnlyInitialized
    private final zzbhj zza;
    private final String zzb;

    /* synthetic */ SearchAdRequest(zzb zzb2, zzc zzc2) {
        this.zzb = com.google.android.gms.ads.search.zzb.zzb((zzb)zzb2);
        this.zza = new zzbhj(com.google.android.gms.ads.search.zzb.zza((zzb)zzb2), this);
    }

    @Deprecated
    public int getAnchorTextColor() {
        return 0;
    }

    @Deprecated
    public int getBackgroundColor() {
        return 0;
    }

    @Deprecated
    public int getBackgroundGradientBottom() {
        return 0;
    }

    @Deprecated
    public int getBackgroundGradientTop() {
        return 0;
    }

    @Deprecated
    public int getBorderColor() {
        return 0;
    }

    @Deprecated
    public int getBorderThickness() {
        return 0;
    }

    @Deprecated
    public int getBorderType() {
        return 0;
    }

    @Deprecated
    public int getCallButtonColor() {
        return 0;
    }

    @Deprecated
    public String getCustomChannels() {
        return null;
    }

    public <T extends CustomEvent> Bundle getCustomEventExtrasBundle(Class<T> clazz) {
        return this.zza.zzi(clazz);
    }

    @Deprecated
    public int getDescriptionTextColor() {
        return 0;
    }

    @Deprecated
    public String getFontFace() {
        return null;
    }

    @Deprecated
    public int getHeaderTextColor() {
        return 0;
    }

    @Deprecated
    public int getHeaderTextSize() {
        return 0;
    }

    public Location getLocation() {
        return this.zza.zzf();
    }

    @Deprecated
    public <T extends NetworkExtras> T getNetworkExtras(Class<T> clazz) {
        return (T)this.zza.zzg(clazz);
    }

    public <T extends MediationAdapter> Bundle getNetworkExtrasBundle(Class<T> clazz) {
        return this.zza.zzh(clazz);
    }

    public String getQuery() {
        return this.zzb;
    }

    public boolean isTestDevice(Context context) {
        return this.zza.zzm(context);
    }

    final zzbhj zza() {
        return this.zza;
    }
}
