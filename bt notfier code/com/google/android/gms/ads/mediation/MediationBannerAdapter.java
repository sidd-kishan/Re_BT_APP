/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  android.view.View
 *  com.google.android.gms.ads.AdSize
 *  com.google.android.gms.ads.mediation.MediationAdRequest
 *  com.google.android.gms.ads.mediation.MediationAdapter
 *  com.google.android.gms.ads.mediation.MediationBannerListener
 */
package com.google.android.gms.ads.mediation;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;

@Deprecated
public interface MediationBannerAdapter
extends MediationAdapter {
    public View getBannerView();

    public void requestBannerAd(Context var1, MediationBannerListener var2, Bundle var3, AdSize var4, MediationAdRequest var5, Bundle var6);
}
