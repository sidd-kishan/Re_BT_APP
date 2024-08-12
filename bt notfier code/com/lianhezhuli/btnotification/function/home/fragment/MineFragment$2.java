/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  com.google.android.gms.ads.AdError
 *  com.google.android.gms.ads.FullScreenContentCallback
 *  com.lianhezhuli.btnotification.advert.AdHelper
 *  com.lianhezhuli.btnotification.function.home.fragment.MineFragment
 *  com.lianhezhuli.btnotification.network.bean.AdvertConfigBean$ConfigBean$AdvertLimitDTO$LimitDTO$LimitItemDTO
 *  com.lianhezhuli.btnotification.network.request.RequestUtils
 *  com.orhanobut.logger.Logger
 */
package com.lianhezhuli.btnotification.function.home.fragment;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.lianhezhuli.btnotification.advert.AdHelper;
import com.lianhezhuli.btnotification.function.home.fragment.MineFragment;
import com.lianhezhuli.btnotification.network.bean.AdvertConfigBean;
import com.lianhezhuli.btnotification.network.request.RequestUtils;
import com.orhanobut.logger.Logger;

/*
 * Exception performing whole class analysis ignored.
 */
class MineFragment.2
extends FullScreenContentCallback {
    final MineFragment this$0;

    MineFragment.2(MineFragment mineFragment) {
        this.this$0 = mineFragment;
    }

    public void onAdClicked() {
        super.onAdClicked();
        Logger.d((Object)"onAdClicked ==== onAdClicked");
        AdvertConfigBean.ConfigBean.AdvertLimitDTO.LimitDTO.LimitItemDTO limitItemDTO = AdHelper.getInstance().getAdvertLimit(3, "6");
        if (limitItemDTO != null && limitItemDTO.getAffectPosition() != null) {
            AdHelper.getInstance().setNextLimit(limitItemDTO);
        }
        RequestUtils.postAdvertClick((int)MineFragment.access$600((MineFragment)this.this$0), (int)MineFragment.access$700((MineFragment)this.this$0), (String)"6", (String)"3", (String)MineFragment.access$800((MineFragment)this.this$0));
    }

    public void onAdDismissedFullScreenContent() {
        Logger.d((Object)"The ad was dismissed.");
        MineFragment.access$300((MineFragment)this.this$0).dismiss();
        this.this$0.startActivity(new Intent((Context)MineFragment.access$900((MineFragment)this.this$0), MineFragment.access$500((MineFragment)this.this$0)));
    }

    public void onAdFailedToShowFullScreenContent(AdError adError) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onAdFailedToShowFullScreenContent: ");
        stringBuilder.append(adError.getCode());
        stringBuilder.append("  msg: ");
        stringBuilder.append(adError.getMessage());
        Logger.d((Object)stringBuilder.toString());
        MineFragment.access$002((MineFragment)this.this$0, null);
        MineFragment.access$300((MineFragment)this.this$0).dismiss();
        this.this$0.startActivity(new Intent((Context)MineFragment.access$1000((MineFragment)this.this$0), MineFragment.access$500((MineFragment)this.this$0)));
        int n = MineFragment.access$600((MineFragment)this.this$0);
        int n2 = MineFragment.access$700((MineFragment)this.this$0);
        String string = MineFragment.access$800((MineFragment)this.this$0);
        stringBuilder = new StringBuilder();
        stringBuilder.append("code: ");
        stringBuilder.append(adError.getCode());
        stringBuilder.append(" msg: ");
        stringBuilder.append(adError.getMessage());
        RequestUtils.postAdvertError((int)n, (int)n2, (String)"6", (String)"3", (String)string, (String)stringBuilder.toString());
    }

    public void onAdImpression() {
        Logger.d((Object)"onAdImpression ============== onAdImpression");
    }

    public void onAdShowedFullScreenContent() {
        MineFragment.access$002((MineFragment)this.this$0, null);
        Logger.d((Object)"The ad was shown.");
        AdvertConfigBean.ConfigBean.AdvertLimitDTO.LimitDTO.LimitItemDTO limitItemDTO = AdHelper.getInstance().getAdvertLimit(2, "6");
        if (limitItemDTO != null && limitItemDTO.getAffectPosition() != null) {
            AdHelper.getInstance().setNextLimit(limitItemDTO);
        }
        RequestUtils.postAdvertShow((int)MineFragment.access$600((MineFragment)this.this$0), (int)MineFragment.access$700((MineFragment)this.this$0), (String)"6", (String)"3", (String)MineFragment.access$800((MineFragment)this.this$0), (String)"");
    }
}
