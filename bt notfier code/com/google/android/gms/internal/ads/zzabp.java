/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.PackageInfo
 *  com.google.android.gms.internal.ads.zzabr
 *  com.google.android.gms.internal.ads.zzfiq
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.google.android.gms.internal.ads.zzabr;
import com.google.android.gms.internal.ads.zzfiq;

final class zzabp
implements Runnable {
    final int zza;
    final zzabr zzb;

    zzabp(zzabr zzabr2, int n, boolean bl) {
        this.zzb = zzabr2;
        this.zza = n;
    }

    @Override
    public final void run() {
        PackageInfo packageInfo;
        zzabr zzabr2 = this.zzb;
        int n = this.zza;
        if (n > 0) {
            long l = n * 1000;
            try {
                Thread.sleep(l);
            }
            catch (InterruptedException interruptedException) {}
        }
        try {
            packageInfo = zzabr2.zza.getPackageManager().getPackageInfo(zzabr2.zza.getPackageName(), 0);
            zzabr2 = zzabr2.zza;
            packageInfo = zzfiq.zza((Context)zzabr2, (String)zzabr2.getPackageName(), (String)Integer.toString(packageInfo.versionCode));
        }
        catch (Throwable throwable) {
            packageInfo = null;
        }
        zzabr.zza((zzabr)this.zzb, packageInfo);
        if (this.zza >= 4) return;
        if (packageInfo != null && packageInfo.zza() && !packageInfo.zzc().equals("0000000000000000000000000000000000000000000000000000000000000000") && packageInfo.zzf() && packageInfo.zzg().zza() && packageInfo.zzg().zzc() != -2L) return;
        this.zzb.zzs(this.zza + 1, true);
    }
}
