/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.net.wifi.WifiManager
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.wifi.WifiManager;

final class zzais {
    private final WifiManager zza;

    public zzais(Context context) {
        this.zza = (WifiManager)context.getApplicationContext().getSystemService("wifi");
    }
}
