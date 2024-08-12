/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzafv
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzafv;

public final class zzdv
extends Exception {
    public final boolean zza;
    public final zzafv zzb;

    public zzdv(int n, zzafv zzafv2, boolean bl) {
        StringBuilder stringBuilder = new StringBuilder(36);
        stringBuilder.append("AudioTrack write failed: ");
        stringBuilder.append(n);
        super(stringBuilder.toString());
        this.zza = bl;
        this.zzb = zzafv2;
    }
}
