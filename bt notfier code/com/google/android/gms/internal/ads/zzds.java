/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzafv
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzafv;

public final class zzds
extends Exception {
    public final boolean zza;
    public final zzafv zzb;

    public zzds(int n, int n2, int n3, int n4, zzafv zzafv2, boolean bl, Exception exception) {
        StringBuilder stringBuilder = new StringBuilder(80);
        stringBuilder.append("AudioTrack init failed ");
        stringBuilder.append(n);
        stringBuilder.append(" Config(");
        stringBuilder.append(n2);
        stringBuilder.append(", ");
        stringBuilder.append(n3);
        stringBuilder.append(", ");
        stringBuilder.append(n4);
        stringBuilder.append(")");
        stringBuilder.append("");
        super(stringBuilder.toString(), exception);
        this.zza = false;
        this.zzb = zzafv2;
    }
}
