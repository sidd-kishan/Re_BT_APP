/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.internal.ads;

public final class zzecu {
    private int zza = 0;
    private long zzb = 0L;
    private long zzc = 0L;
    private long zzd = 0L;
    private final Object zze = new Object();
    private final Object zzf = new Object();
    private final Object zzg = new Object();
    private final Object zzh = new Object();

    public final void zza(int n) {
        Object object = this.zze;
        synchronized (object) {
            this.zza = n;
            return;
        }
    }

    public final int zzb() {
        Object object = this.zze;
        synchronized (object) {
            int n = this.zza;
            return n;
        }
    }

    public final void zzc(long l) {
        Object object = this.zzf;
        synchronized (object) {
            this.zzb = l;
            return;
        }
    }

    public final long zzd() {
        Object object = this.zzf;
        synchronized (object) {
            long l = this.zzb;
            return l;
        }
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public final void zze(long l) {
        synchronized (this) {
            Object object = this.zzg;
            synchronized (object) {
                this.zzc = l;
                return;
            }
        }
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public final long zzf() {
        synchronized (this) {
            Object object = this.zzg;
            synchronized (object) {
                return this.zzc;
            }
        }
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public final void zzg(long l) {
        synchronized (this) {
            Object object = this.zzh;
            synchronized (object) {
                this.zzd = l;
                return;
            }
        }
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public final long zzh() {
        synchronized (this) {
            Object object = this.zzh;
            synchronized (object) {
                return this.zzd;
            }
        }
    }
}
