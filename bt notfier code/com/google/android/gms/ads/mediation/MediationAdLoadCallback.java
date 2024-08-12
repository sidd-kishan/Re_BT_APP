/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.AdError
 */
package com.google.android.gms.ads.mediation;

import com.google.android.gms.ads.AdError;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public interface MediationAdLoadCallback<MediationAdT, MediationAdCallbackT> {
    public void onFailure(AdError var1);

    @Deprecated
    public void onFailure(String var1);

    public MediationAdCallbackT onSuccess(MediationAdT var1);
}
