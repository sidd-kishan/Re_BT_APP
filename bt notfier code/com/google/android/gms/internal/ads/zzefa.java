/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzcml
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcml;

final class zzefa
implements Runnable {
    private final zzcml zza;

    private zzefa(zzcml zzcml2) {
        this.zza = zzcml2;
    }

    static Runnable zza(zzcml zzcml2) {
        return new zzefa(zzcml2);
    }

    @Override
    public final void run() {
        this.zza.zzau();
    }
}
