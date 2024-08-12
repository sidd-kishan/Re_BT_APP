/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.media.AudioTrack
 *  com.google.android.gms.internal.ads.zzamq
 *  com.google.android.gms.internal.ads.zzdx
 */
package com.google.android.gms.internal.ads;

import android.media.AudioTrack;
import com.google.android.gms.internal.ads.zzamq;
import com.google.android.gms.internal.ads.zzdx;

final class zzdy {
    private final zzdx zza;
    private int zzb;
    private long zzc;
    private long zzd;
    private long zze;
    private long zzf;

    public zzdy(AudioTrack audioTrack) {
        if (zzamq.zza >= 19) {
            this.zza = new zzdx(audioTrack);
            this.zze();
            return;
        }
        this.zza = null;
        this.zzh(3);
    }

    private final void zzh(int n) {
        this.zzb = n;
        long l = 10000L;
        if (n != 0) {
            if (n == 1) {
                this.zzd = 10000L;
                return;
            }
            l = n != 2 && n != 3 ? 500000L : 10000000L;
        } else {
            this.zze = 0L;
            this.zzf = -1L;
            this.zzc = System.nanoTime() / 1000L;
        }
        this.zzd = l;
    }

    public final boolean zza(long l) {
        block10: {
            boolean bl;
            block8: {
                block9: {
                    boolean bl2;
                    block7: {
                        zzdx zzdx2 = this.zza;
                        bl2 = false;
                        if (zzdx2 == null) return false;
                        if (l - this.zze < this.zzd) return false;
                        this.zze = l;
                        bl = zzdx2.zza();
                        int n = this.zzb;
                        if (n == 0) break block7;
                        if (n != 1) {
                            if (n != 2) {
                                if (n != 3) return bl;
                                if (!bl) return bl;
                                this.zze();
                                return true;
                            }
                            if (bl) return bl;
                            this.zze();
                            return false;
                        }
                        if (bl) {
                            if (this.zza.zzc() <= this.zzf) return bl;
                            this.zzh(2);
                            return true;
                        }
                        this.zze();
                        break block8;
                    }
                    if (!bl) break block9;
                    if (this.zza.zzb() >= this.zzc) {
                        this.zzf = this.zza.zzc();
                        this.zzh(1);
                        return true;
                    }
                    bl = bl2;
                    break block8;
                }
                if (l - this.zzc > 500000L) break block10;
            }
            return bl;
        }
        this.zzh(3);
        return false;
    }

    public final void zzb() {
        this.zzh(4);
    }

    public final void zzc() {
        if (this.zzb != 4) return;
        this.zze();
    }

    public final boolean zzd() {
        if (this.zzb != 2) return false;
        return true;
    }

    public final void zze() {
        if (this.zza == null) return;
        this.zzh(0);
    }

    public final long zzf() {
        zzdx zzdx2 = this.zza;
        if (zzdx2 == null) return -9223372036854775807L;
        return zzdx2.zzb();
    }

    public final long zzg() {
        zzdx zzdx2 = this.zza;
        if (zzdx2 == null) return -1L;
        return zzdx2.zzc();
    }
}
