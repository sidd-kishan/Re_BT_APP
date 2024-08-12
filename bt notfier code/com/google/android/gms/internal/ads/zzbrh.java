/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzbrk
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbrk;

final class zzbrh
implements Runnable {
    final zzbrk zza;

    zzbrh(zzbrk zzbrk2) {
        this.zza = zzbrk2;
    }

    @Override
    public final void run() {
        zzbrk.zzc((zzbrk)this.zza);
    }
}
