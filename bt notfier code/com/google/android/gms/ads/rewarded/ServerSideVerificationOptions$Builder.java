/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.rewarded.ServerSideVerificationOptions
 */
package com.google.android.gms.ads.rewarded;

import com.google.android.gms.ads.rewarded.ServerSideVerificationOptions;

public static final class ServerSideVerificationOptions.Builder {
    private String zza = "";
    private String zzb = "";

    static /* synthetic */ String zza(ServerSideVerificationOptions.Builder builder) {
        return builder.zza;
    }

    static /* synthetic */ String zzb(ServerSideVerificationOptions.Builder builder) {
        return builder.zzb;
    }

    public ServerSideVerificationOptions build() {
        return new ServerSideVerificationOptions(this, null);
    }

    public ServerSideVerificationOptions.Builder setCustomData(String string) {
        this.zzb = string;
        return this;
    }

    public ServerSideVerificationOptions.Builder setUserId(String string) {
        this.zza = string;
        return this;
    }
}
