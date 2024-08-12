/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.formats.NativeAdOptions
 *  com.google.android.gms.ads.mediation.MediationAdRequest
 *  com.google.android.gms.ads.nativead.NativeAdOptions
 */
package com.google.android.gms.ads.mediation;

import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.nativead.NativeAdOptions;
import java.util.Map;

@Deprecated
public interface NativeMediationAdRequest
extends MediationAdRequest {
    public float getAdVolume();

    @Deprecated
    public com.google.android.gms.ads.formats.NativeAdOptions getNativeAdOptions();

    public NativeAdOptions getNativeAdRequestOptions();

    public boolean isAdMuted();

    public boolean isUnifiedNativeAdRequested();

    public boolean zza();

    public Map<String, Boolean> zzb();
}
