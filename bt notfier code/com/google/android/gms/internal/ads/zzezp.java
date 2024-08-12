/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzdrw
 *  com.google.android.gms.internal.ads.zzelx
 *  com.google.android.gms.internal.ads.zzezq
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdrw;
import com.google.android.gms.internal.ads.zzelx;
import com.google.android.gms.internal.ads.zzezq;

final class zzezp
implements zzelx<zzdrw> {
    final zzezq zza;

    zzezp(zzezq zzezq2) {
        this.zza = zzezq2;
    }

    public final void zza() {
        zzezq zzezq2 = this.zza;
        synchronized (zzezq2) {
            zzezq.zzs((zzezq)this.zza, null);
            return;
        }
    }
}
