/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzac
 *  com.google.android.gms.internal.ads.zzae
 *  com.google.android.gms.internal.ads.zzz
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzac;
import com.google.android.gms.internal.ads.zzae;
import com.google.android.gms.internal.ads.zzz;
import java.nio.ByteBuffer;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

public class zzaf
extends zzz {
    public final zzac zza = new zzac();
    public ByteBuffer zzb;
    public boolean zzc;
    public long zzd;
    public ByteBuffer zze;
    private final int zzf;

    public zzaf(int n, int n2) {
        this.zzf = n;
    }

    private final ByteBuffer zzl(int n) {
        int n2 = this.zzf;
        if (n2 == 1) {
            return ByteBuffer.allocate(n);
        }
        if (n2 == 2) {
            return ByteBuffer.allocateDirect(n);
        }
        ByteBuffer byteBuffer = this.zzb;
        n2 = byteBuffer == null ? 0 : byteBuffer.capacity();
        throw new zzae(n2, n);
    }

    public void zza() {
        super.zza();
        ByteBuffer byteBuffer = this.zzb;
        if (byteBuffer != null) {
            byteBuffer.clear();
        }
        if ((byteBuffer = this.zze) != null) {
            byteBuffer.clear();
        }
        this.zzc = false;
    }

    @EnsuresNonNull(value={"data"})
    public final void zzi(int n) {
        int n2;
        ByteBuffer byteBuffer = this.zzb;
        if (byteBuffer == null) {
            this.zzb = this.zzl(n);
            return;
        }
        int n3 = byteBuffer.capacity();
        if (n3 >= (n += (n2 = byteBuffer.position()))) {
            this.zzb = byteBuffer;
            return;
        }
        ByteBuffer byteBuffer2 = this.zzl(n);
        byteBuffer2.order(byteBuffer.order());
        if (n2 > 0) {
            byteBuffer.flip();
            byteBuffer2.put(byteBuffer);
        }
        this.zzb = byteBuffer2;
    }

    public final boolean zzj() {
        return this.zzh(0x40000000);
    }

    public final void zzk() {
        ByteBuffer byteBuffer = this.zzb;
        if (byteBuffer != null) {
            byteBuffer.flip();
        }
        if ((byteBuffer = this.zze) == null) return;
        byteBuffer.flip();
    }
}
