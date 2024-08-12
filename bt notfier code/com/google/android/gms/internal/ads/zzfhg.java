/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.webkit.WebView
 *  com.google.android.gms.internal.ads.zzfhh
 */
package com.google.android.gms.internal.ads;

import android.webkit.WebView;
import com.google.android.gms.internal.ads.zzfhh;

final class zzfhg
implements Runnable {
    final zzfhh zza;
    private final WebView zzb;

    zzfhg(zzfhh zzfhh2) {
        this.zza = zzfhh2;
        this.zzb = zzfhh.zzl((zzfhh)this.zza);
    }

    @Override
    public final void run() {
        this.zzb.destroy();
    }
}
