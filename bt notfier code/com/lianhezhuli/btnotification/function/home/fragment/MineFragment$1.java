/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  com.google.android.gms.ads.LoadAdError
 *  com.google.android.gms.ads.interstitial.InterstitialAd
 *  com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback
 *  com.lianhezhuli.btnotification.function.home.fragment.MineFragment
 *  com.lianhezhuli.btnotification.network.request.RequestUtils
 *  com.orhanobut.logger.Logger
 */
package com.lianhezhuli.btnotification.function.home.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.lianhezhuli.btnotification.function.home.fragment.MineFragment;
import com.lianhezhuli.btnotification.network.request.RequestUtils;
import com.orhanobut.logger.Logger;

/*
 * Exception performing whole class analysis ignored.
 */
class MineFragment.1
extends InterstitialAdLoadCallback {
    final MineFragment this$0;

    MineFragment.1(MineFragment mineFragment) {
        this.this$0 = mineFragment;
    }

    public void onAdFailedToLoad(LoadAdError loadAdError) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onAdFailedToLoad: ");
        stringBuilder.append(loadAdError.getCode());
        stringBuilder.append("  msg: ");
        stringBuilder.append(loadAdError.getMessage());
        Logger.d((Object)stringBuilder.toString());
        MineFragment.access$300((MineFragment)this.this$0).dismiss();
        this.this$0.startActivity(new Intent((Context)MineFragment.access$400((MineFragment)this.this$0), MineFragment.access$500((MineFragment)this.this$0)));
        Logger.i((String)loadAdError.getMessage(), (Object[])new Object[0]);
        MineFragment.access$002((MineFragment)this.this$0, null);
        int n = MineFragment.access$600((MineFragment)this.this$0);
        int n2 = MineFragment.access$700((MineFragment)this.this$0);
        String string = MineFragment.access$800((MineFragment)this.this$0);
        stringBuilder = new StringBuilder();
        stringBuilder.append("code: ");
        stringBuilder.append(loadAdError.getCode());
        stringBuilder.append(" msg: ");
        stringBuilder.append(loadAdError.getMessage());
        RequestUtils.postAdvertError((int)n, (int)n2, (String)"6", (String)"3", (String)string, (String)stringBuilder.toString());
    }

    public void onAdLoaded(InterstitialAd interstitialAd) {
        MineFragment.access$002((MineFragment)this.this$0, (InterstitialAd)interstitialAd);
        MineFragment.access$000((MineFragment)this.this$0).setFullScreenContentCallback(MineFragment.access$100((MineFragment)this.this$0));
        MineFragment.access$000((MineFragment)this.this$0).show((Activity)MineFragment.access$200((MineFragment)this.this$0));
    }
}
