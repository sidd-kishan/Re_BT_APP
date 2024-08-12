/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.pm.ApplicationInfo
 *  android.content.pm.PackageInfo
 *  android.os.Bundle
 *  com.google.android.gms.internal.ads.zzerx
 *  com.google.android.gms.internal.ads.zzery
 *  com.google.android.gms.internal.ads.zzfsd
 *  com.google.android.gms.internal.ads.zzfsm
 */
package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import com.google.android.gms.internal.ads.zzerx;
import com.google.android.gms.internal.ads.zzery;
import com.google.android.gms.internal.ads.zzfsd;
import com.google.android.gms.internal.ads.zzfsm;

public final class zzeqj
implements zzery,
zzerx {
    private final ApplicationInfo zza;
    private final PackageInfo zzb;

    zzeqj(ApplicationInfo applicationInfo, PackageInfo packageInfo) {
        this.zza = applicationInfo;
        this.zzb = packageInfo;
    }

    public final zzfsm<zzerx<Bundle>> zza() {
        return zzfsd.zza((Object)this);
    }
}
