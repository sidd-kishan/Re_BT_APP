/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  com.google.android.gms.internal.ads.zzaft
 *  com.google.android.gms.internal.ads.zzakt
 *  com.google.android.gms.internal.ads.zzamf
 *  com.google.android.gms.internal.ads.zznx
 *  com.google.android.gms.internal.ads.zzov
 *  com.google.android.gms.internal.ads.zzox
 *  com.google.android.gms.internal.ads.zztb
 *  com.google.android.gms.internal.ads.zzun
 */
package com.google.android.gms.internal.ads;

import android.util.Log;
import com.google.android.gms.internal.ads.zzaft;
import com.google.android.gms.internal.ads.zzakt;
import com.google.android.gms.internal.ads.zzamf;
import com.google.android.gms.internal.ads.zznx;
import com.google.android.gms.internal.ads.zzov;
import com.google.android.gms.internal.ads.zzox;
import com.google.android.gms.internal.ads.zztb;
import com.google.android.gms.internal.ads.zzun;

public final class zztn
implements zztb {
    private final zzamf zza = new zzamf(10);
    private zzox zzb;
    private boolean zzc;
    private long zzd = -9223372036854775807L;
    private int zze;
    private int zzf;

    public final void zza() {
        this.zzc = false;
        this.zzd = -9223372036854775807L;
    }

    public final void zzb(zznx zznx2, zzun zzun2) {
        zzun2.zza();
        zznx2 = zznx2.zzB(zzun2.zzb(), 5);
        this.zzb = zznx2;
        zzaft zzaft2 = new zzaft();
        zzaft2.zzD(zzun2.zzc());
        zzaft2.zzN("application/id3");
        zznx2.zzs(zzaft2.zzah());
    }

    public final void zzc(long l, int n) {
        if ((n & 4) == 0) {
            return;
        }
        this.zzc = true;
        if (l != -9223372036854775807L) {
            this.zzd = l;
        }
        this.zze = 0;
        this.zzf = 0;
    }

    public final void zzd(zzamf zzamf2) {
        zzakt.zze((Object)this.zzb);
        if (!this.zzc) {
            return;
        }
        int n = zzamf2.zzd();
        int n2 = this.zzf;
        if (n2 < 10) {
            n2 = Math.min(n, 10 - n2);
            System.arraycopy(zzamf2.zzi(), zzamf2.zzg(), this.zza.zzi(), this.zzf, n2);
            if (this.zzf + n2 == 10) {
                this.zza.zzh(0);
                if (this.zza.zzn() == 73 && this.zza.zzn() == 68 && this.zza.zzn() == 51) {
                    this.zza.zzk(3);
                    this.zze = this.zza.zzA() + 10;
                } else {
                    Log.w((String)"Id3Reader", (String)"Discarding invalid ID3 tag");
                    this.zzc = false;
                    return;
                }
            }
        }
        n = Math.min(n, this.zze - this.zzf);
        zzov.zzb((zzox)this.zzb, (zzamf)zzamf2, (int)n);
        this.zzf += n;
    }

    public final void zze() {
        zzakt.zze((Object)this.zzb);
        if (!this.zzc) return;
        int n = this.zze;
        if (n == 0) return;
        if (this.zzf != n) return;
        long l = this.zzd;
        if (l != -9223372036854775807L) {
            this.zzb.zzv(l, 1, n, 0, null);
        }
        this.zzc = false;
    }
}
