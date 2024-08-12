/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzasj
 *  com.google.android.gms.internal.ads.zzasl
 *  com.google.android.gms.internal.ads.zzata
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzasj;
import com.google.android.gms.internal.ads.zzasl;
import com.google.android.gms.internal.ads.zzata;

final class zzasg
implements Runnable {
    final zzasj zza;
    final zzasl zzb;

    zzasg(zzasl zzasl2, zzasj zzasj2) {
        this.zzb = zzasl2;
        this.zza = zzasj2;
    }

    @Override
    public final void run() {
        this.zza.zza();
        int n = zzasl.zzh((zzasl)this.zzb).size();
        int n2 = 0;
        while (n2 < n) {
            ((zzata)zzasl.zzh((zzasl)this.zzb).valueAt(n2)).zzg();
            ++n2;
        }
    }
}
