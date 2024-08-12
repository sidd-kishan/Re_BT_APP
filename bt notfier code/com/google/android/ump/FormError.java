/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.ump;

public class FormError {
    private final int zza;
    private final String zzb;

    public FormError(int n, String string) {
        this.zza = n;
        this.zzb = string;
    }

    public int getErrorCode() {
        return this.zza;
    }

    public String getMessage() {
        return this.zzb;
    }
}
