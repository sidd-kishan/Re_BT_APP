/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.internal.ads;

import java.io.IOException;

public class zzaha
extends IOException {
    public final boolean zzb;
    public final int zzc;

    protected zzaha(String string, Throwable throwable, boolean bl, int n) {
        super(string, throwable);
        this.zzb = bl;
        this.zzc = n;
    }

    public static zzaha zza(String string, Throwable throwable) {
        return new zzaha(string, throwable, true, 0);
    }

    public static zzaha zzb(String string, Throwable throwable) {
        return new zzaha(string, throwable, true, 1);
    }

    public static zzaha zzc(String string) {
        return new zzaha(string, null, false, 1);
    }
}
