/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.mediation.UnifiedNativeAdMapper
 *  com.google.android.gms.ads.mediation.customevent.CustomEventListener
 */
package com.google.android.gms.ads.mediation.customevent;

import com.google.android.gms.ads.mediation.UnifiedNativeAdMapper;
import com.google.android.gms.ads.mediation.customevent.CustomEventListener;

public interface CustomEventNativeListener
extends CustomEventListener {
    public void onAdImpression();

    public void onAdLoaded(UnifiedNativeAdMapper var1);
}
