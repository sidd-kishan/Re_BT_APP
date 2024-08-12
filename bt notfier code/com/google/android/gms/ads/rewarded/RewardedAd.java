/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.os.Bundle
 *  com.google.android.gms.ads.AdRequest
 *  com.google.android.gms.ads.FullScreenContentCallback
 *  com.google.android.gms.ads.OnPaidEventListener
 *  com.google.android.gms.ads.OnUserEarnedRewardListener
 *  com.google.android.gms.ads.ResponseInfo
 *  com.google.android.gms.ads.admanager.AdManagerAdRequest
 *  com.google.android.gms.ads.rewarded.OnAdMetadataChangedListener
 *  com.google.android.gms.ads.rewarded.RewardItem
 *  com.google.android.gms.ads.rewarded.RewardedAdLoadCallback
 *  com.google.android.gms.ads.rewarded.ServerSideVerificationOptions
 *  com.google.android.gms.common.internal.Preconditions
 *  com.google.android.gms.internal.ads.zzcdb
 */
package com.google.android.gms.ads.rewarded;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.ads.OnUserEarnedRewardListener;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.admanager.AdManagerAdRequest;
import com.google.android.gms.ads.rewarded.OnAdMetadataChangedListener;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;
import com.google.android.gms.ads.rewarded.ServerSideVerificationOptions;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzcdb;

public abstract class RewardedAd {
    public static void load(Context context, String string, AdRequest adRequest, RewardedAdLoadCallback rewardedAdLoadCallback) {
        Preconditions.checkNotNull((Object)context, (Object)"Context cannot be null.");
        Preconditions.checkNotNull((Object)string, (Object)"AdUnitId cannot be null.");
        Preconditions.checkNotNull((Object)adRequest, (Object)"AdRequest cannot be null.");
        Preconditions.checkNotNull((Object)rewardedAdLoadCallback, (Object)"LoadCallback cannot be null.");
        new zzcdb(context, string).zza(adRequest.zza(), rewardedAdLoadCallback);
    }

    public static void load(Context context, String string, AdManagerAdRequest adManagerAdRequest, RewardedAdLoadCallback rewardedAdLoadCallback) {
        Preconditions.checkNotNull((Object)context, (Object)"Context cannot be null.");
        Preconditions.checkNotNull((Object)string, (Object)"AdUnitId cannot be null.");
        Preconditions.checkNotNull((Object)adManagerAdRequest, (Object)"AdManagerAdRequest cannot be null.");
        Preconditions.checkNotNull((Object)rewardedAdLoadCallback, (Object)"LoadCallback cannot be null.");
        new zzcdb(context, string).zza(adManagerAdRequest.zza(), rewardedAdLoadCallback);
    }

    public abstract Bundle getAdMetadata();

    public abstract String getAdUnitId();

    public abstract FullScreenContentCallback getFullScreenContentCallback();

    public abstract OnAdMetadataChangedListener getOnAdMetadataChangedListener();

    public abstract OnPaidEventListener getOnPaidEventListener();

    public abstract ResponseInfo getResponseInfo();

    public abstract RewardItem getRewardItem();

    public abstract void setFullScreenContentCallback(FullScreenContentCallback var1);

    public abstract void setImmersiveMode(boolean var1);

    public abstract void setOnAdMetadataChangedListener(OnAdMetadataChangedListener var1);

    public abstract void setOnPaidEventListener(OnPaidEventListener var1);

    public abstract void setServerSideVerificationOptions(ServerSideVerificationOptions var1);

    public abstract void show(Activity var1, OnUserEarnedRewardListener var2);
}
