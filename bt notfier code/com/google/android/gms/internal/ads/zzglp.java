/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  androidx.browser.customtabs.CustomTabsClient
 *  androidx.browser.customtabs.CustomTabsServiceConnection
 *  com.google.android.gms.internal.ads.zzbkj
 */
package com.google.android.gms.internal.ads;

import android.content.ComponentName;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.browser.customtabs.CustomTabsServiceConnection;
import com.google.android.gms.internal.ads.zzbkj;
import java.lang.ref.WeakReference;

public final class zzglp
extends CustomTabsServiceConnection {
    private final WeakReference<zzbkj> zza;

    public zzglp(zzbkj zzbkj2, byte[] byArray) {
        this.zza = new WeakReference<zzbkj>(zzbkj2);
    }

    public final void onCustomTabsServiceConnected(ComponentName componentName, CustomTabsClient customTabsClient) {
        componentName = (zzbkj)this.zza.get();
        if (componentName == null) return;
        componentName.zzf(customTabsClient);
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        componentName = (zzbkj)this.zza.get();
        if (componentName == null) return;
        componentName.zzg();
    }
}
