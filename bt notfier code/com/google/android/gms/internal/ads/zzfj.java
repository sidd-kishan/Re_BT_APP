/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzaf
 *  com.google.android.gms.internal.ads.zzakt
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzaf;
import com.google.android.gms.internal.ads.zzakt;
import java.nio.ByteBuffer;

final class zzfj
extends zzaf {
    private long zzf;
    private int zzg;
    private int zzh = 32;

    public zzfj() {
        super(2, 0);
    }

    public final void zza() {
        super.zza();
        this.zzg = 0;
    }

    public final void zzl(int n) {
        this.zzh = n;
    }

    public final long zzm() {
        return this.zzf;
    }

    public final int zzn() {
        return this.zzg;
    }

    public final boolean zzo() {
        if (this.zzg <= 0) return false;
        return true;
    }

    public final boolean zzp(zzaf zzaf2) {
        ByteBuffer byteBuffer;
        zzakt.zza((boolean)(zzaf2.zzh(0x40000000) ^ true));
        zzakt.zza((boolean)(zzaf2.zzh(0x10000000) ^ true));
        zzakt.zza((boolean)(zzaf2.zzh(4) ^ true));
        if (this.zzo()) {
            ByteBuffer byteBuffer2;
            if (this.zzg >= this.zzh) return false;
            if (zzaf2.zzh(Integer.MIN_VALUE) != this.zzh(Integer.MIN_VALUE)) return false;
            byteBuffer = zzaf2.zzb;
            if (byteBuffer != null && (byteBuffer2 = this.zzb) != null && byteBuffer2.position() + byteBuffer.remaining() > 0x2EE000) return false;
        }
        int n = this.zzg;
        this.zzg = n + 1;
        if (n == 0) {
            this.zzd = zzaf2.zzd;
            if (zzaf2.zzh(1)) {
                this.zzf(1);
            }
        }
        if (zzaf2.zzh(Integer.MIN_VALUE)) {
            this.zzf(Integer.MIN_VALUE);
        }
        if ((byteBuffer = zzaf2.zzb) != null) {
            this.zzi(byteBuffer.remaining());
            this.zzb.put(byteBuffer);
        }
        this.zzf = zzaf2.zzd;
        return true;
    }
}
