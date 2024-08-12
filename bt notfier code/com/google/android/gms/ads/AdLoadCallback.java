/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.LoadAdError
 */
package com.google.android.gms.ads;

import com.google.android.gms.ads.LoadAdError;

public abstract class AdLoadCallback<AdT> {
    public void onAdFailedToLoad(LoadAdError loadAdError) {
    }

    public void onAdLoaded(AdT AdT) {
    }
}
