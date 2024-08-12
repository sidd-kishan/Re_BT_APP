/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzdrw
 *  com.google.android.gms.internal.ads.zzelx
 *  com.google.android.gms.internal.ads.zzezw
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdrw;
import com.google.android.gms.internal.ads.zzelx;
import com.google.android.gms.internal.ads.zzezw;

final class zzezu
implements zzelx<zzdrw> {
    final zzezw zza;

    zzezu(zzezw zzezw2) {
        this.zza = zzezw2;
    }

    public final void zza() {
        zzezw zzezw2 = this.zza;
        synchronized (zzezw2) {
            zzezw.zzv((zzezw)this.zza, null);
            return;
        }
    }
}
