/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzamq
 *  com.google.android.gms.internal.ads.zzdc
 *  com.google.android.gms.internal.ads.zzdd
 *  com.google.android.gms.internal.ads.zzeb
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzamq;
import com.google.android.gms.internal.ads.zzdc;
import com.google.android.gms.internal.ads.zzdd;
import com.google.android.gms.internal.ads.zzeb;
import java.nio.ByteBuffer;

final class zzew
extends zzeb {
    private int zzd;
    private int zze;
    private boolean zzf;
    private int zzg;
    private byte[] zzh = zzamq.zzf;
    private int zzi;
    private long zzj;

    public final void zzc(ByteBuffer byteBuffer) {
        int n = byteBuffer.position();
        int n2 = byteBuffer.limit();
        int n3 = n2 - n;
        if (n3 == 0) {
            return;
        }
        int n4 = Math.min(n3, this.zzg);
        this.zzj += (long)(n4 / this.zzb.zze);
        this.zzg -= n4;
        byteBuffer.position(n + n4);
        if (this.zzg > 0) {
            return;
        }
        n4 = n3 - n4;
        n = this.zzi + n4 - this.zzh.length;
        ByteBuffer byteBuffer2 = this.zzi(n);
        n3 = zzamq.zzx((int)n, (int)0, (int)this.zzi);
        byteBuffer2.put(this.zzh, 0, n3);
        n = zzamq.zzx((int)(n - n3), (int)0, (int)n4);
        byteBuffer.limit(byteBuffer.position() + n);
        byteBuffer2.put(byteBuffer);
        byteBuffer.limit(n2);
        n2 = n4 - n;
        this.zzi = n4 = this.zzi - n3;
        byte[] byArray = this.zzh;
        System.arraycopy(byArray, n3, byArray, 0, n4);
        byteBuffer.get(this.zzh, this.zzi, n2);
        this.zzi += n2;
        byteBuffer2.flip();
    }

    public final ByteBuffer zze() {
        if (!super.zzf()) return super.zze();
        int n = this.zzi;
        if (n <= 0) return super.zze();
        this.zzi(n).put(this.zzh, 0, this.zzi).flip();
        this.zzi = 0;
        return super.zze();
    }

    public final boolean zzf() {
        if (!super.zzf()) return false;
        if (this.zzi != 0) return false;
        return true;
    }

    public final zzdc zzk(zzdc zzdc2) throws zzdd {
        if (zzdc2.zzd != 2) throw new zzdd(zzdc2);
        this.zzf = true;
        zzdc zzdc3 = zzdc2;
        if (this.zzd != 0) return zzdc3;
        zzdc3 = this.zze != 0 ? zzdc2 : zzdc.zza;
        return zzdc3;
    }

    protected final void zzl() {
        if (!this.zzf) return;
        int n = this.zzi;
        if (n > 0) {
            this.zzj += (long)(n / this.zzb.zze);
        }
        this.zzi = 0;
    }

    protected final void zzm() {
        if (this.zzf) {
            this.zzf = false;
            int n = this.zze;
            int n2 = this.zzb.zze;
            this.zzh = new byte[n * n2];
            this.zzg = this.zzd * n2;
        }
        this.zzi = 0;
    }

    protected final void zzn() {
        this.zzh = zzamq.zzf;
    }

    public final void zzo(int n, int n2) {
        this.zzd = n;
        this.zze = n2;
    }

    public final void zzp() {
        this.zzj = 0L;
    }

    public final long zzq() {
        return this.zzj;
    }
}
