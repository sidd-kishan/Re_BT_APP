/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.AdError
 *  com.google.android.gms.ads.mediation.MediationAdCallback
 *  com.google.android.gms.ads.rewarded.RewardItem
 */
package com.google.android.gms.ads.mediation;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.MediationAdCallback;
import com.google.android.gms.ads.rewarded.RewardItem;

public interface MediationRewardedAdCallback
extends MediationAdCallback {
    public void onAdFailedToShow(AdError var1);

    @Deprecated
    public void onAdFailedToShow(String var1);

    public void onUserEarnedReward(RewardItem var1);

    public void onVideoComplete();

    public void onVideoStart();
}
