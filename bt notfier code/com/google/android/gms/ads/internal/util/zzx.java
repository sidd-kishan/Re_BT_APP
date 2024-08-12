/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.webkit.CookieManager
 *  android.webkit.WebResourceResponse
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.ads.internal.util.zzw
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.internal.ads.zzazb
 *  com.google.android.gms.internal.ads.zzcml
 *  com.google.android.gms.internal.ads.zzcms
 *  com.google.android.gms.internal.ads.zzcnq
 */
package com.google.android.gms.ads.internal.util;

import android.content.Context;
import android.webkit.CookieManager;
import android.webkit.WebResourceResponse;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzw;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzazb;
import com.google.android.gms.internal.ads.zzcml;
import com.google.android.gms.internal.ads.zzcms;
import com.google.android.gms.internal.ads.zzcnq;
import java.io.InputStream;
import java.util.Map;

public class zzx
extends zzw {
    public final CookieManager zzk(Context context) {
        if (zzx.zzu()) {
            return null;
        }
        try {
            context = CookieManager.getInstance();
            return context;
        }
        catch (Throwable throwable) {
            zze.zzg((String)"Failed to obtain CookieManager.", (Throwable)throwable);
            zzt.zzg().zzk(throwable, "ApiLevelUtil.getCookieManager");
            return null;
        }
    }

    public final zzcms zzl(zzcml zzcml2, zzazb zzazb2, boolean bl) {
        return new zzcnq(zzcml2, zzazb2, bl);
    }

    public final int zzm() {
        return 16974374;
    }

    public final WebResourceResponse zzn(String string, String string2, int n, String string3, Map<String, String> map, InputStream inputStream) {
        return new WebResourceResponse(string, string2, n, string3, map, inputStream);
    }
}
