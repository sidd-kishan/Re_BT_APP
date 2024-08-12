/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.internal.ads;

public final class zzamn {
    private long zza;
    private long zzb;
    private long zzc;
    private final ThreadLocal<Long> zzd = new ThreadLocal();

    public zzamn(long l) {
        this.zzd(0L);
    }

    public final long zza() {
        synchronized (this) {
            long l = this.zza;
            if (l == Long.MAX_VALUE) return -9223372036854775807L;
            if (l != 0x7FFFFFFFFFFFFFFEL) return l;
            return -9223372036854775807L;
        }
    }

    public final long zzb() {
        synchronized (this) {
            long l = this.zzc;
            l = l != -9223372036854775807L ? (l += this.zzb) : this.zza();
            return l;
        }
    }

    public final long zzc() {
        synchronized (this) {
            long l = this.zzb;
            return l;
        }
    }

    public final void zzd(long l) {
        synchronized (this) {
            this.zza = l;
            l = l == Long.MAX_VALUE ? 0L : -9223372036854775807L;
            this.zzb = l;
            this.zzc = -9223372036854775807L;
            return;
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled force condition propagation
     */
    public final long zze(long l) {
        synchronized (this) {
            if (l == -9223372036854775807L) {
                return -9223372036854775807L;
            }
            long l2 = this.zzc;
            long l3 = l;
            if (l2 == -9223372036854775807L) return this.zzf(l3 * 1000000L / 90000L);
            long l4 = l2 * 90000L / 1000000L;
            l3 = (0x100000000L + l4) / 0x200000000L;
            l2 = (-1L + l3) * 0x200000000L + l;
            l += l3 * 0x200000000L;
            l3 = l;
            {
                if (Math.abs(l2 - l4) >= Math.abs(l - l4)) return this.zzf(l3 * 1000000L / 90000L);
                l3 = l2;
                return this.zzf(l3 * 1000000L / 90000L);
            }
        }
    }

    public final long zzf(long l) {
        synchronized (this) {
            long l2;
            if (this.zzb == -9223372036854775807L) {
                long l3;
                l2 = l3 = this.zza;
                if (l3 == 0x7FFFFFFFFFFFFFFEL) {
                    Long l4 = this.zzd.get();
                    if (l4 == null) throw null;
                    l2 = l4;
                }
                this.zzb = l2 - l;
                this.notifyAll();
            }
            this.zzc = l;
            l2 = this.zzb;
            return l + l2;
        }
    }
}
