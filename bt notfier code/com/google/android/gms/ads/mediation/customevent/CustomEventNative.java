/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  com.google.android.gms.ads.mediation.NativeMediationAdRequest
 *  com.google.android.gms.ads.mediation.customevent.CustomEvent
 *  com.google.android.gms.ads.mediation.customevent.CustomEventNativeListener
 */
package com.google.android.gms.ads.mediation.customevent;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.mediation.NativeMediationAdRequest;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.ads.mediation.customevent.CustomEventNativeListener;

public interface CustomEventNative
extends CustomEvent {
    public void requestNativeAd(Context var1, CustomEventNativeListener var2, String var3, NativeMediationAdRequest var4, Bundle var5);
}