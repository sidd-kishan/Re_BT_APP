/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.ApplicationInfo
 *  com.google.android.gms.internal.ads.zzgla
 *  com.google.android.gms.internal.ads.zzgli
 *  com.google.android.gms.internal.ads.zzgln
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.google.android.gms.internal.ads.zzgla;
import com.google.android.gms.internal.ads.zzgli;
import com.google.android.gms.internal.ads.zzgln;

public final class zzdyy
implements zzgla<ApplicationInfo> {
    private final zzgln<Context> zza;

    public zzdyy(zzgln<Context> zzgln2) {
        this.zza = zzgln2;
    }

    public final ApplicationInfo zza() {
        ApplicationInfo applicationInfo = ((Context)this.zza.zzb()).getApplicationInfo();
        zzgli.zzb((Object)applicationInfo);
        return applicationInfo;
    }
}
