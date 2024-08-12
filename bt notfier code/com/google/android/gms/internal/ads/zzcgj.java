/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzcgk
 *  com.google.android.gms.internal.ads.zzcgy
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcgk;
import com.google.android.gms.internal.ads.zzcgy;

final class zzcgj
extends Thread {
    final String zza;

    zzcgj(zzcgk zzcgk2, String string) {
        this.zza = string;
    }

    @Override
    public final void run() {
        new zzcgy(null).zza(this.zza);
    }
}
