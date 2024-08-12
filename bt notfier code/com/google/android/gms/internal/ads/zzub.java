/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzamf
 *  com.google.android.gms.internal.ads.zzamn
 *  com.google.android.gms.internal.ads.zzamq
 *  com.google.android.gms.internal.ads.zznx
 *  com.google.android.gms.internal.ads.zzua
 *  com.google.android.gms.internal.ads.zzun
 *  com.google.android.gms.internal.ads.zzuo
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzamf;
import com.google.android.gms.internal.ads.zzamn;
import com.google.android.gms.internal.ads.zzamq;
import com.google.android.gms.internal.ads.zznx;
import com.google.android.gms.internal.ads.zzua;
import com.google.android.gms.internal.ads.zzun;
import com.google.android.gms.internal.ads.zzuo;

public final class zzub
implements zzuo {
    private final zzua zza;
    private final zzamf zzb;
    private int zzc;
    private int zzd;
    private boolean zze;
    private boolean zzf;

    public zzub(zzua zzua2) {
        this.zza = zzua2;
        this.zzb = new zzamf(32);
    }

    public final void zza(zzamn zzamn2, zznx zznx2, zzun zzun2) {
        this.zza.zza(zzamn2, zznx2, zzun2);
        this.zzf = true;
    }

    public final void zzb() {
        this.zzf = true;
    }

    public final void zzc(zzamf zzamf2, int n) {
        int n2 = n & 1;
        if (n2 != 0) {
            n = zzamf2.zzn();
            n = zzamf2.zzg() + n;
        } else {
            n = -1;
        }
        if (this.zzf) {
            if (n2 == 0) {
                return;
            }
            this.zzf = false;
            zzamf2.zzh(n);
            this.zzd = 0;
        }
        while (zzamf2.zzd() > 0) {
            n = this.zzd;
            if (n < 3) {
                if (n == 0) {
                    n = zzamf2.zzn();
                    zzamf2.zzh(zzamf2.zzg() - 1);
                    if (n == 255) {
                        this.zzf = true;
                        return;
                    }
                }
                n = Math.min(zzamf2.zzd(), 3 - this.zzd);
                zzamf2.zzm(this.zzb.zzi(), this.zzd, n);
                this.zzd = n = this.zzd + n;
                if (n != 3) continue;
                this.zzb.zzh(0);
                this.zzb.zzf(3);
                this.zzb.zzk(1);
                n2 = this.zzb.zzn();
                n = this.zzb.zzn();
                boolean bl = (n2 & 0x80) != 0;
                this.zze = bl;
                this.zzc = ((n2 & 0xF) << 8 | n) + 3;
                n2 = this.zzb.zzj();
                if (n2 >= (n = this.zzc)) continue;
                n2 = this.zzb.zzj();
                n = Math.min(4098, Math.max(n, n2 + n2));
                this.zzb.zzc(n);
                continue;
            }
            n = Math.min(zzamf2.zzd(), this.zzc - this.zzd);
            zzamf2.zzm(this.zzb.zzi(), this.zzd, n);
            this.zzd = n = this.zzd + n;
            n2 = this.zzc;
            if (n != n2) continue;
            if (this.zze) {
                if (zzamq.zzV((byte[])this.zzb.zzi(), (int)0, (int)this.zzc, (int)-1) != 0) {
                    this.zzf = true;
                    return;
                }
                this.zzb.zzf(this.zzc - 4);
            } else {
                this.zzb.zzf(n2);
            }
            this.zzb.zzh(0);
            this.zza.zzb(this.zzb);
            this.zzd = 0;
        }
    }
}
