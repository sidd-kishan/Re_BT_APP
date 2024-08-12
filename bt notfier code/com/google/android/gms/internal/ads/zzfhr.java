/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfhu
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfhu;

final class zzfhr
implements Runnable {
    zzfhr() {
    }

    @Override
    public final void run() {
        if (zzfhu.zzb() == null) return;
        zzfhu.zzb().post(zzfhu.zzd());
        zzfhu.zzb().postDelayed(zzfhu.zze(), 200L);
    }
}
