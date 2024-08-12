/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.internal.ads;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

final class zzww
extends FilterInputStream {
    private final long zza;
    private long zzb;

    zzww(InputStream inputStream, long l) {
        super(inputStream);
        this.zza = l;
    }

    @Override
    public final int read() throws IOException {
        int n = super.read();
        if (n == -1) return n;
        ++this.zzb;
        return n;
    }

    @Override
    public final int read(byte[] byArray, int n, int n2) throws IOException {
        if ((n = super.read(byArray, n, n2)) == -1) return n;
        this.zzb += (long)n;
        return n;
    }

    final long zza() {
        return this.zza - this.zzb;
    }
}
