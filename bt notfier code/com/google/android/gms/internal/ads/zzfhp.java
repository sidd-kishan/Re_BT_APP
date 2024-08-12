/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfhu
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfhu;

final class zzfhp
implements Runnable {
    final zzfhu zza;

    zzfhp(zzfhu zzfhu2) {
        this.zza = zzfhu2;
    }

    @Override
    public final void run() {
        zzfhu.zzc((zzfhu)this.zza).zzc();
    }
}
