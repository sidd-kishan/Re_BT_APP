/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.rewarded.ServerSideVerificationOptions$Builder
 *  com.google.android.gms.ads.rewarded.zzb
 */
package com.google.android.gms.ads.rewarded;

import com.google.android.gms.ads.rewarded.ServerSideVerificationOptions;
import com.google.android.gms.ads.rewarded.zzb;

/*
 * Exception performing whole class analysis ignored.
 */
public class ServerSideVerificationOptions {
    private final String zza;
    private final String zzb;

    /* synthetic */ ServerSideVerificationOptions(Builder builder, zzb zzb2) {
        this.zza = Builder.zza((Builder)builder);
        this.zzb = Builder.zzb((Builder)builder);
    }

    public String getCustomData() {
        return this.zzb;
    }

    public String getUserId() {
        return this.zza;
    }
}
