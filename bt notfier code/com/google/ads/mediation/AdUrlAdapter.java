/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  com.google.ads.mediation.AbstractAdViewAdapter
 *  com.google.android.gms.ads.mediation.MediationBannerAdapter
 *  com.google.android.gms.ads.mediation.MediationInterstitialAdapter
 *  com.google.android.gms.ads.mediation.MediationNativeAdapter
 */
package com.google.ads.mediation;

import android.os.Bundle;
import com.google.ads.mediation.AbstractAdViewAdapter;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;

@Deprecated
public final class AdUrlAdapter
extends AbstractAdViewAdapter
implements MediationBannerAdapter,
MediationInterstitialAdapter,
MediationNativeAdapter {
    private static final String AD_URL_AD_UNIT_ID = "adurl";

    protected Bundle buildExtrasBundle(Bundle bundle, Bundle bundle2) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putBundle("sdk_less_server_data", bundle2);
        bundle.putBoolean("_noRefresh", true);
        return bundle;
    }

    public String getAdUnitId(Bundle bundle) {
        return AD_URL_AD_UNIT_ID;
    }
}
