/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzapb
 *  com.google.android.gms.internal.ads.zzape
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzapb;
import com.google.android.gms.internal.ads.zzape;
import java.nio.Buffer;
import java.nio.ByteBuffer;

public final class zzapg
extends zzapb {
    public final zzape zza = new zzape();
    public ByteBuffer zzb;
    public long zzc;

    public zzapg(int n) {
    }

    private final ByteBuffer zzj(int n) {
        Object object = this.zzb;
        int n2 = object == null ? 0 : ((Buffer)object).capacity();
        object = new StringBuilder(44);
        ((StringBuilder)object).append("Buffer too small (");
        ((StringBuilder)object).append(n2);
        ((StringBuilder)object).append(" < ");
        ((StringBuilder)object).append(n);
        ((StringBuilder)object).append(")");
        throw new IllegalStateException(((StringBuilder)object).toString());
    }

    public final void zza() {
        super.zza();
        ByteBuffer byteBuffer = this.zzb;
        if (byteBuffer == null) return;
        byteBuffer.clear();
    }

    public final void zzh(int n) throws IllegalStateException {
        int n2;
        ByteBuffer byteBuffer = this.zzb;
        if (byteBuffer == null) {
            this.zzb = this.zzj(n);
            return;
        }
        int n3 = byteBuffer.capacity();
        if (n3 >= (n += (n2 = this.zzb.position()))) {
            return;
        }
        byteBuffer = this.zzj(n);
        if (n2 > 0) {
            this.zzb.position(0);
            this.zzb.limit(n2);
            byteBuffer.put(this.zzb);
        }
        this.zzb = byteBuffer;
    }

    public final boolean zzi() {
        return this.zzg(0x40000000);
    }
}
