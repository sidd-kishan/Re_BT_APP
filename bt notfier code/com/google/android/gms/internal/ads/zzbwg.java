/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.mediation.MediationInterscrollerAd
 *  com.google.android.gms.dynamic.IObjectWrapper
 *  com.google.android.gms.dynamic.ObjectWrapper
 *  com.google.android.gms.internal.ads.zzbvo
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.mediation.MediationInterscrollerAd;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbvo;

public final class zzbwg
extends zzbvo {
    private final MediationInterscrollerAd zza;

    public zzbwg(MediationInterscrollerAd mediationInterscrollerAd) {
        this.zza = mediationInterscrollerAd;
    }

    public final IObjectWrapper zze() {
        return ObjectWrapper.wrap((Object)this.zza.getView());
    }

    public final boolean zzf() {
        return this.zza.shouldDelegateInterscrollerEffect();
    }
}
