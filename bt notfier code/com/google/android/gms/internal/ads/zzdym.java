/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.internal.ads;

public class zzdym
extends Exception {
    private final int zza;

    public zzdym(int n) {
        this.zza = n;
    }

    public zzdym(int n, String string) {
        super(string);
        this.zza = n;
    }

    public zzdym(int n, String string, Throwable throwable) {
        super(string, throwable);
        this.zza = 1;
    }

    public final int zza() {
        return this.zza;
    }
}
