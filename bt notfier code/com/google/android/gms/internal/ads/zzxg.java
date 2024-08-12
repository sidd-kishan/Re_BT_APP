/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzwt
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzwt;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public final class zzxg
extends ByteArrayOutputStream {
    private final zzwt zza;

    public zzxg(zzwt zzwt2, int n) {
        this.zza = zzwt2;
        this.buf = zzwt2.zza(Math.max(n, 256));
    }

    private final void zza(int n) {
        if (this.count + n <= this.buf.length) {
            return;
        }
        Object object = this.zza;
        n = this.count + n;
        object = object.zza(n + n);
        System.arraycopy(this.buf, 0, object, 0, this.count);
        this.zza.zzb(this.buf);
        this.buf = (byte[])object;
    }

    @Override
    public final void close() throws IOException {
        this.zza.zzb(this.buf);
        this.buf = null;
        super.close();
    }

    public final void finalize() {
        this.zza.zzb(this.buf);
    }

    @Override
    public final void write(int n) {
        synchronized (this) {
            this.zza(1);
            super.write(n);
            return;
        }
    }

    @Override
    public final void write(byte[] byArray, int n, int n2) {
        synchronized (this) {
            this.zza(n2);
            super.write(byArray, n, n2);
            return;
        }
    }
}
