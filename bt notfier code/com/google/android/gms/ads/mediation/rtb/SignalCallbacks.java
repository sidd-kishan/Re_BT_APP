/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.AdError
 */
package com.google.android.gms.ads.mediation.rtb;

import com.google.android.gms.ads.AdError;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public interface SignalCallbacks {
    public void onFailure(AdError var1);

    @Deprecated
    public void onFailure(String var1);

    public void onSuccess(String var1);
}
