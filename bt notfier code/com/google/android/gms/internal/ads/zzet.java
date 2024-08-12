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

public final class zzet
extends zzeb {
    private int zzd;
    private boolean zze;
    private byte[] zzf = zzamq.zzf;
    private byte[] zzg = zzamq.zzf;
    private int zzh;
    private int zzi;
    private int zzj;
    private boolean zzk;
    private long zzl;

    private final void zzq(byte[] byArray, int n) {
        this.zzi(n).put(byArray, 0, n).flip();
        if (n <= 0) return;
        this.zzk = true;
    }

    private final void zzr(ByteBuffer byteBuffer, byte[] byArray, int n) {
        int n2 = Math.min(byteBuffer.remaining(), this.zzj);
        int n3 = this.zzj - n2;
        System.arraycopy(byArray, n - n3, this.zzg, 0, n3);
        byteBuffer.position(byteBuffer.limit() - n2);
        byteBuffer.get(this.zzg, n3, n2);
    }

    private final int zzs(long l) {
        return (int)(l * (long)this.zzb.zzb / 1000000L);
    }

    private final int zzt(ByteBuffer byteBuffer) {
        int n = byteBuffer.position();
        while (n < byteBuffer.limit()) {
            if (Math.abs(byteBuffer.getShort(n)) > 1024) {
                int n2 = this.zzd;
                return n2 * (n / n2);
            }
            n += 2;
        }
        return byteBuffer.limit();
    }

    public final boolean zzb() {
        return this.zze;
    }

    public final void zzc(ByteBuffer byteBuffer) {
        while (byteBuffer.hasRemaining()) {
            int n;
            int n2;
            block11: {
                int n3;
                if (this.zzj()) return;
                n2 = this.zzh;
                if (n2 != 0) {
                    if (n2 != 1) {
                        n3 = byteBuffer.limit();
                        n2 = this.zzt(byteBuffer);
                        byteBuffer.limit(n2);
                        this.zzl += (long)(byteBuffer.remaining() / this.zzd);
                        this.zzr(byteBuffer, this.zzg, this.zzj);
                        if (n2 >= n3) continue;
                        this.zzq(this.zzg, this.zzj);
                        this.zzh = 0;
                        byteBuffer.limit(n3);
                        continue;
                    }
                    n3 = byteBuffer.limit();
                    n2 = this.zzt(byteBuffer);
                    n = n2 - byteBuffer.position();
                    byte[] byArray = this.zzf;
                    int n4 = byArray.length;
                    int n5 = this.zzi;
                    if (n2 < n3 && n < (n4 -= n5)) {
                        this.zzq(byArray, n5);
                        this.zzi = 0;
                        this.zzh = 0;
                        continue;
                    }
                    n2 = Math.min(n, n4);
                    byteBuffer.limit(byteBuffer.position() + n2);
                    byteBuffer.get(this.zzf, this.zzi, n2);
                    this.zzi = n2 = this.zzi + n2;
                    byArray = this.zzf;
                    if (n2 == byArray.length) {
                        if (this.zzk) {
                            this.zzq(byArray, this.zzj);
                            long l = this.zzl;
                            n2 = this.zzi;
                            n = this.zzj;
                            this.zzl = l + (long)((n2 - (n + n)) / this.zzd);
                        } else {
                            this.zzl += (long)((n2 - this.zzj) / this.zzd);
                        }
                        this.zzr(byteBuffer, this.zzf, n2);
                        this.zzi = 0;
                        this.zzh = 2;
                    }
                    byteBuffer.limit(n3);
                    continue;
                }
                n = byteBuffer.limit();
                byteBuffer.limit(Math.min(n, byteBuffer.position() + this.zzf.length));
                n2 = byteBuffer.limit();
                while ((n3 = n2 - 2) >= byteBuffer.position()) {
                    n2 = n3;
                    if (Math.abs(byteBuffer.getShort(n3)) <= 1024) continue;
                    n2 = this.zzd;
                    n2 = n3 / n2 * n2 + n2;
                    break block11;
                }
                n2 = byteBuffer.position();
            }
            if (n2 == byteBuffer.position()) {
                this.zzh = 1;
            } else {
                byteBuffer.limit(n2);
                n2 = byteBuffer.remaining();
                this.zzi(n2).put(byteBuffer).flip();
                if (n2 > 0) {
                    this.zzk = true;
                }
            }
            byteBuffer.limit(n);
        }
    }

    public final zzdc zzk(zzdc zzdc2) throws zzdd {
        if (zzdc2.zzd != 2) throw new zzdd(zzdc2);
        if (!this.zze) return zzdc.zza;
        return zzdc2;
    }

    protected final void zzl() {
        int n = this.zzi;
        if (n > 0) {
            this.zzq(this.zzf, n);
        }
        if (this.zzk) return;
        this.zzl += (long)(this.zzj / this.zzd);
    }

    protected final void zzm() {
        if (this.zze) {
            this.zzd = this.zzb.zze;
            int n = this.zzs(150000L) * this.zzd;
            if (this.zzf.length != n) {
                this.zzf = new byte[n];
            }
            this.zzj = n = this.zzs(20000L) * this.zzd;
            if (this.zzg.length != n) {
                this.zzg = new byte[n];
            }
        }
        this.zzh = 0;
        this.zzl = 0L;
        this.zzi = 0;
        this.zzk = false;
    }

    protected final void zzn() {
        this.zze = false;
        this.zzj = 0;
        this.zzf = zzamq.zzf;
        this.zzg = zzamq.zzf;
    }

    public final void zzo(boolean bl) {
        this.zze = bl;
    }

    public final long zzp() {
        return this.zzl;
    }
}
