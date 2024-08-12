/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  com.google.android.gms.ads.AdRequest$Builder
 *  com.google.android.gms.ads.admanager.AdManagerAdRequest
 *  com.google.android.gms.ads.query.AdInfo
 */
package com.google.android.gms.ads.admanager;

import android.text.TextUtils;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.admanager.AdManagerAdRequest;
import com.google.android.gms.ads.query.AdInfo;
import java.util.List;

public static final class AdManagerAdRequest.Builder
extends AdRequest.Builder {
    public AdManagerAdRequest.Builder addCategoryExclusion(String string) {
        this.zza.zzH(string);
        return this;
    }

    public AdManagerAdRequest.Builder addCustomTargeting(String string, String string2) {
        this.zza.zzG(string, string2);
        return this;
    }

    public AdManagerAdRequest.Builder addCustomTargeting(String string, List<String> list) {
        if (list == null) return this;
        this.zza.zzG(string, TextUtils.join((CharSequence)",", list));
        return this;
    }

    public AdManagerAdRequest build() {
        return new AdManagerAdRequest(this, null);
    }

    @Deprecated
    public AdManagerAdRequest.Builder setAdInfo(AdInfo adInfo) {
        this.zza.zzJ(adInfo);
        return this;
    }

    public AdManagerAdRequest.Builder setAdString(String string) {
        this.zza.zzK(string);
        return this;
    }

    public AdManagerAdRequest.Builder setPublisherProvidedId(String string) {
        this.zza.zzD(string);
        return this;
    }
}
