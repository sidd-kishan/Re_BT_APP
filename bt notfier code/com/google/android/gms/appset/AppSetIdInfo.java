/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.appset;

public class AppSetIdInfo {
    public static final int SCOPE_APP = 1;
    public static final int SCOPE_DEVELOPER = 2;
    private final String zza;
    private final int zzb;

    public AppSetIdInfo(String string, int n) {
        this.zza = string;
        this.zzb = n;
    }

    public String getId() {
        return this.zza;
    }

    public int getScope() {
        return this.zzb;
    }
}
