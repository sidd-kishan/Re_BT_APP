/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.internal.ads;

public final class zzfkf
extends Exception {
    private final int zza;

    public zzfkf(int n, String string) {
        super(string);
        this.zza = n;
    }

    public zzfkf(int n, Throwable throwable) {
        super(throwable);
        this.zza = n;
    }

    public final int zza() {
        return this.zza;
    }
}
