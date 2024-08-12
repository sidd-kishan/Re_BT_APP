/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzamq
 *  com.google.android.gms.internal.ads.zzdc
 *  com.google.android.gms.internal.ads.zzdd
 *  com.google.android.gms.internal.ads.zzde
 *  com.google.android.gms.internal.ads.zzeu
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzamq;
import com.google.android.gms.internal.ads.zzdc;
import com.google.android.gms.internal.ads.zzdd;
import com.google.android.gms.internal.ads.zzde;
import com.google.android.gms.internal.ads.zzeu;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;

public final class zzev
implements zzde {
    private int zzb;
    private float zzc = 1.0f;
    private float zzd = 1.0f;
    private zzdc zze = zzdc.zza;
    private zzdc zzf = zzdc.zza;
    private zzdc zzg = zzdc.zza;
    private zzdc zzh = zzdc.zza;
    private boolean zzi;
    private zzeu zzj;
    private ByteBuffer zzk;
    private ShortBuffer zzl;
    private ByteBuffer zzm;
    private long zzn;
    private long zzo;
    private boolean zzp;

    public zzev() {
        ByteBuffer byteBuffer;
        this.zzk = byteBuffer = zza;
        this.zzl = byteBuffer.asShortBuffer();
        this.zzm = zza;
        this.zzb = -1;
    }

    public final zzdc zza(zzdc zzdc2) throws zzdd {
        int n;
        if (zzdc2.zzd != 2) throw new zzdd(zzdc2);
        int n2 = n = this.zzb;
        if (n == -1) {
            n2 = zzdc2.zzb;
        }
        this.zze = zzdc2;
        this.zzf = zzdc2 = new zzdc(n2, zzdc2.zzc, 2);
        this.zzi = true;
        return zzdc2;
    }

    public final boolean zzb() {
        boolean bl;
        int n = this.zzf.zzb;
        boolean bl2 = bl = false;
        if (n == -1) return bl2;
        if (!(Math.abs(this.zzc - 1.0f) >= 1.0E-4f) && !(Math.abs(this.zzd - 1.0f) >= 1.0E-4f)) {
            if (this.zzf.zzb != this.zze.zzb) return true;
            bl2 = bl;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    public final void zzc(ByteBuffer byteBuffer) {
        if (!byteBuffer.hasRemaining()) {
            return;
        }
        zzeu zzeu2 = this.zzj;
        if (zzeu2 == null) throw null;
        ShortBuffer shortBuffer = byteBuffer.asShortBuffer();
        int n = byteBuffer.remaining();
        this.zzn += (long)n;
        zzeu2.zzb(shortBuffer);
        byteBuffer.position(byteBuffer.position() + n);
    }

    public final void zzd() {
        zzeu zzeu2 = this.zzj;
        if (zzeu2 != null) {
            zzeu2.zzd();
        }
        this.zzp = true;
    }

    public final ByteBuffer zze() {
        int n;
        Object object = this.zzj;
        if (object != null && (n = object.zzf()) > 0) {
            if (this.zzk.capacity() < n) {
                ByteBuffer byteBuffer;
                this.zzk = byteBuffer = ByteBuffer.allocateDirect(n).order(ByteOrder.nativeOrder());
                this.zzl = byteBuffer.asShortBuffer();
            } else {
                this.zzk.clear();
                this.zzl.clear();
            }
            object.zzc(this.zzl);
            this.zzo += (long)n;
            this.zzk.limit(n);
            this.zzm = this.zzk;
        }
        object = this.zzm;
        this.zzm = zza;
        return object;
    }

    public final boolean zzf() {
        boolean bl = this.zzp;
        boolean bl2 = true;
        if (bl) {
            zzeu zzeu2 = this.zzj;
            if (zzeu2 == null) return bl2;
            if (zzeu2.zzf() == 0) return true;
        }
        bl2 = false;
        return bl2;
    }

    public final void zzg() {
        if (this.zzb()) {
            zzdc zzdc2;
            this.zzg = zzdc2 = this.zze;
            this.zzh = this.zzf;
            if (this.zzi) {
                this.zzj = new zzeu(zzdc2.zzb, zzdc2.zzc, this.zzc, this.zzd, this.zzh.zzb);
            } else {
                zzdc2 = this.zzj;
                if (zzdc2 != null) {
                    zzdc2.zze();
                }
            }
        }
        this.zzm = zza;
        this.zzn = 0L;
        this.zzo = 0L;
        this.zzp = false;
    }

    public final void zzh() {
        ByteBuffer byteBuffer;
        this.zzc = 1.0f;
        this.zzd = 1.0f;
        this.zze = zzdc.zza;
        this.zzf = zzdc.zza;
        this.zzg = zzdc.zza;
        this.zzh = zzdc.zza;
        this.zzk = byteBuffer = zza;
        this.zzl = byteBuffer.asShortBuffer();
        this.zzm = zza;
        this.zzb = -1;
        this.zzi = false;
        this.zzj = null;
        this.zzn = 0L;
        this.zzo = 0L;
        this.zzp = false;
    }

    public final void zzi(float f) {
        if (this.zzc == f) return;
        this.zzc = f;
        this.zzi = true;
    }

    public final void zzj(float f) {
        if (this.zzd == f) return;
        this.zzd = f;
        this.zzi = true;
    }

    public final long zzk(long l) {
        if (this.zzo < 1024L) {
            double d = this.zzc;
            double d2 = l;
            Double.isNaN(d);
            Double.isNaN(d2);
            return (long)(d * d2);
        }
        long l2 = this.zzn;
        zzeu zzeu2 = this.zzj;
        if (zzeu2 == null) throw null;
        int n = this.zzh.zzb;
        int n2 = this.zzg.zzb;
        l = n == n2 ? zzamq.zzH((long)l, (long)l2, (long)this.zzo) : zzamq.zzH((long)l, (long)((l2 -= (long)zzeu2.zza()) * (long)n), (long)(this.zzo * (long)n2));
        return l;
    }
}
