/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.ads.mediation;

public interface MediationAdCallback {
    public void onAdClosed();

    public void onAdOpened();

    public void reportAdClicked();

    public void reportAdImpression();
}
