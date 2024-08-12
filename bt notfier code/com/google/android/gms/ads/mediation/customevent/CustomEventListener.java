/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.AdError
 */
package com.google.android.gms.ads.mediation.customevent;

import com.google.android.gms.ads.AdError;

public interface CustomEventListener {
    public void onAdClicked();

    public void onAdClosed();

    @Deprecated
    public void onAdFailedToLoad(int var1);

    public void onAdFailedToLoad(AdError var1);

    public void onAdLeftApplication();

    public void onAdOpened();
}
