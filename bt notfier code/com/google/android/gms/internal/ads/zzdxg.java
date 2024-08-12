/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.internal.ads.zzchl
 *  com.google.android.gms.internal.ads.zzdxk
 */
package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzchl;
import com.google.android.gms.internal.ads.zzdxk;

final class zzdxg
implements Runnable {
    private final zzdxk zza;
    private final zzchl zzb;

    zzdxg(zzdxk zzdxk2, zzchl zzchl2) {
        this.zza = zzdxk2;
        this.zzb = zzchl2;
    }

    @Override
    public final void run() {
        zzchl zzchl2 = this.zzb;
        String string = zzt.zzg().zzp().zzn().zzd();
        if (!TextUtils.isEmpty((CharSequence)string)) {
            zzchl2.zzc((Object)string);
            return;
        }
        zzchl2.zzd((Throwable)new Exception());
    }
}
