/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.webkit.WebView
 *  com.google.android.gms.internal.consent_sdk.zzbe
 *  com.google.android.gms.internal.consent_sdk.zzch
 */
package com.google.android.gms.internal.consent_sdk;

import android.webkit.WebView;
import com.google.android.gms.internal.consent_sdk.zzbe;
import com.google.android.gms.internal.consent_sdk.zzch;

final class zzbd
implements Runnable {
    private final zzbe zza;
    private final String zzb;

    zzbd(zzbe zzbe2, String string) {
        this.zza = zzbe2;
        this.zzb = string;
    }

    @Override
    public final void run() {
        zzch.zza((WebView)this.zza, (String)this.zzb);
    }
}
