/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzddo
 *  com.google.android.gms.internal.ads.zzddp
 *  com.google.android.gms.internal.ads.zzddr
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzddo;
import com.google.android.gms.internal.ads.zzddp;
import com.google.android.gms.internal.ads.zzddr;
import java.lang.ref.WeakReference;

final class zzddq
implements Runnable {
    private final WeakReference<zzddr> zza;

    /* synthetic */ zzddq(zzddr zzddr2, zzddp zzddp2) {
        this.zza = new WeakReference<zzddr>(zzddr2);
    }

    @Override
    public final void run() {
        zzddr zzddr2 = (zzddr)this.zza.get();
        if (zzddr2 == null) return;
        zzddr2.zzk(zzddo.zza);
    }
}
