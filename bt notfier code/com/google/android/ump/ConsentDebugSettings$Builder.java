/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.google.android.gms.internal.consent_sdk.zzbz
 *  com.google.android.ump.ConsentDebugSettings
 */
package com.google.android.ump;

import android.content.Context;
import com.google.android.gms.internal.consent_sdk.zzbz;
import com.google.android.ump.ConsentDebugSettings;
import java.util.ArrayList;
import java.util.List;

public static class ConsentDebugSettings.Builder {
    private final List<String> zza = new ArrayList<String>();
    private final Context zzb;
    private int zzc = 0;
    private boolean zzd;

    public ConsentDebugSettings.Builder(Context context) {
        this.zzb = context.getApplicationContext();
    }

    static /* synthetic */ int zza(ConsentDebugSettings.Builder builder) {
        return builder.zzc;
    }

    public ConsentDebugSettings.Builder addTestDeviceHashedId(String string) {
        this.zza.add(string);
        return this;
    }

    public ConsentDebugSettings build() {
        Context context = this.zzb;
        List<String> list = this.zza;
        boolean bl = zzbz.zza();
        boolean bl2 = false;
        boolean bl3 = bl || list.contains(zzbz.zza((Context)context));
        if (!bl3) {
            if (!this.zzd) return new ConsentDebugSettings(bl2, this, null);
        }
        bl2 = true;
        return new ConsentDebugSettings(bl2, this, null);
    }

    public ConsentDebugSettings.Builder setDebugGeography(int n) {
        this.zzc = n;
        return this;
    }

    public ConsentDebugSettings.Builder setForceTesting(boolean bl) {
        this.zzd = bl;
        return this;
    }
}
