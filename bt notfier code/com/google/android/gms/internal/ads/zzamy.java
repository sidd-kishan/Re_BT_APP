/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.internal.ads;

import java.io.IOException;

public final class zzamy
extends Exception {
    private zzamy(int n, String string, Throwable throwable, int n2) {
        super(null, throwable);
    }

    public static zzamy zza(Exception exception, int n) {
        return new zzamy(1, null, exception, n);
    }

    public static zzamy zzb(IOException iOException) {
        return new zzamy(0, null, iOException, -1);
    }

    static zzamy zzc(RuntimeException runtimeException) {
        return new zzamy(2, null, runtimeException, -1);
    }
}
