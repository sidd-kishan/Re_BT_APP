/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzcnh
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcnh;
import java.util.Map;

final class zzcnf
implements Runnable {
    private final zzcnh zza;
    private final Map zzb;

    zzcnf(zzcnh zzcnh2, Map map) {
        this.zza = zzcnh2;
        this.zzb = map;
    }

    @Override
    public final void run() {
        this.zza.zzu(this.zzb);
    }
}
