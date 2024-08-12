/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzgkm
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgkm;
import java.io.IOException;
import java.nio.ByteBuffer;

final class zzckk
implements zzgkm {
    private final ByteBuffer zza;

    zzckk(ByteBuffer byteBuffer) {
        this.zza = byteBuffer.duplicate();
    }

    public final void close() throws IOException {
    }

    public final int zza(ByteBuffer byteBuffer) throws IOException {
        if (this.zza.remaining() == 0 && byteBuffer.remaining() > 0) {
            return -1;
        }
        int n = Math.min(byteBuffer.remaining(), this.zza.remaining());
        byte[] byArray = new byte[n];
        this.zza.get(byArray);
        byteBuffer.put(byArray);
        return n;
    }

    public final long zzb() throws IOException {
        return this.zza.limit();
    }

    public final long zzc() throws IOException {
        return this.zza.position();
    }

    public final void zzd(long l) throws IOException {
        this.zza.position((int)l);
    }

    public final ByteBuffer zze(long l, long l2) throws IOException {
        int n = this.zza.position();
        this.zza.position((int)l);
        ByteBuffer byteBuffer = this.zza.slice();
        byteBuffer.limit((int)l2);
        this.zza.position(n);
        return byteBuffer;
    }
}
