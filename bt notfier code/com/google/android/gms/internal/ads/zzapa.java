/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzaoa
 *  com.google.android.gms.internal.ads.zzaob
 *  com.google.android.gms.internal.ads.zzaoz
 *  com.google.android.gms.internal.ads.zzave
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzaoa;
import com.google.android.gms.internal.ads.zzaob;
import com.google.android.gms.internal.ads.zzaoz;
import com.google.android.gms.internal.ads.zzave;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;

public final class zzapa
implements zzaob {
    private int zzb = -1;
    private int zzc = -1;
    private zzaoz zzd;
    private float zze = 1.0f;
    private float zzf = 1.0f;
    private ByteBuffer zzg;
    private ShortBuffer zzh;
    private ByteBuffer zzi;
    private long zzj;
    private long zzk;
    private boolean zzl;

    public zzapa() {
        ByteBuffer byteBuffer;
        this.zzg = byteBuffer = zza;
        this.zzh = byteBuffer.asShortBuffer();
        this.zzi = zza;
    }

    public final boolean zza(int n, int n2, int n3) throws zzaoa {
        if (n3 != 2) throw new zzaoa(n, n2, n3);
        if (this.zzc == n && this.zzb == n2) {
            return false;
        }
        this.zzc = n;
        this.zzb = n2;
        return true;
    }

    public final boolean zzb() {
        if (Math.abs(this.zze - 1.0f) >= 0.01f) return true;
        if (!(Math.abs(this.zzf - 1.0f) >= 0.01f)) return false;
        return true;
    }

    public final int zzc() {
        return this.zzb;
    }

    public final int zzd() {
        return 2;
    }

    public final void zze(ByteBuffer byteBuffer) {
        int n;
        if (byteBuffer.hasRemaining()) {
            ShortBuffer shortBuffer = byteBuffer.asShortBuffer();
            n = byteBuffer.remaining();
            this.zzj += (long)n;
            this.zzd.zzc(shortBuffer);
            byteBuffer.position(byteBuffer.position() + n);
        }
        n = this.zzd.zzf() * this.zzb;
        if ((n += n) <= 0) return;
        if (this.zzg.capacity() < n) {
            this.zzg = byteBuffer = ByteBuffer.allocateDirect(n).order(ByteOrder.nativeOrder());
            this.zzh = byteBuffer.asShortBuffer();
        } else {
            this.zzg.clear();
            this.zzh.clear();
        }
        this.zzd.zzd(this.zzh);
        this.zzk += (long)n;
        this.zzg.limit(n);
        this.zzi = this.zzg;
    }

    public final void zzf() {
        this.zzd.zze();
        this.zzl = true;
    }

    public final ByteBuffer zzg() {
        ByteBuffer byteBuffer = this.zzi;
        this.zzi = zza;
        return byteBuffer;
    }

    public final boolean zzh() {
        boolean bl = this.zzl;
        boolean bl2 = true;
        if (bl) {
            zzaoz zzaoz2 = this.zzd;
            if (zzaoz2 == null) return bl2;
            if (zzaoz2.zzf() == 0) return true;
        }
        bl2 = false;
        return bl2;
    }

    public final void zzi() {
        zzaoz zzaoz2;
        this.zzd = zzaoz2 = new zzaoz(this.zzc, this.zzb);
        zzaoz2.zza(this.zze);
        this.zzd.zzb(this.zzf);
        this.zzi = zza;
        this.zzj = 0L;
        this.zzk = 0L;
        this.zzl = false;
    }

    public final void zzj() {
        ByteBuffer byteBuffer;
        this.zzd = null;
        this.zzg = byteBuffer = zza;
        this.zzh = byteBuffer.asShortBuffer();
        this.zzi = zza;
        this.zzb = -1;
        this.zzc = -1;
        this.zzj = 0L;
        this.zzk = 0L;
        this.zzl = false;
    }

    public final float zzk(float f) {
        this.zze = f = zzave.zzg((float)f, (float)0.1f, (float)8.0f);
        return f;
    }

    public final float zzl(float f) {
        this.zzf = zzave.zzg((float)1.0f, (float)0.1f, (float)8.0f);
        return 1.0f;
    }

    public final long zzm() {
        return this.zzj;
    }

    public final long zzn() {
        return this.zzk;
    }
}
