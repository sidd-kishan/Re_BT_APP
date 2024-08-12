/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  com.google.android.gms.ads.mediation.MediationAdapter
 *  com.google.android.gms.ads.mediation.MediationNativeListener
 *  com.google.android.gms.ads.mediation.NativeMediationAdRequest
 */
package com.google.android.gms.ads.mediation;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.MediationNativeListener;
import com.google.android.gms.ads.mediation.NativeMediationAdRequest;

@Deprecated
public interface MediationNativeAdapter
extends MediationAdapter {
    public void requestNativeAd(Context var1, MediationNativeListener var2, Bundle var3, NativeMediationAdRequest var4, Bundle var5);
}
