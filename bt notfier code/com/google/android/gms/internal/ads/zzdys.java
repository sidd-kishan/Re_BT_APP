/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.webkit.CookieManager
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 */
package com.google.android.gms.internal.ads;

import android.webkit.CookieManager;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import java.util.concurrent.Callable;

final class zzdys
implements Callable {
    private final CookieManager zza;

    zzdys(CookieManager cookieManager) {
        this.zza = cookieManager;
    }

    public final Object call() {
        Object object = this.zza;
        if (object == null) {
            object = "";
        } else {
            zzbjd zzbjd2 = zzbjl.zzaz;
            object = object.getCookie((String)zzbet.zzc().zzc(zzbjd2));
        }
        return object;
    }
}
