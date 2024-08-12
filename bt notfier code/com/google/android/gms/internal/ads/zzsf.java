/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzamf
 *  com.google.android.gms.internal.ads.zznv
 *  com.google.android.gms.internal.ads.zzny
 *  com.google.android.gms.internal.ads.zzsg
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzamf;
import com.google.android.gms.internal.ads.zznv;
import com.google.android.gms.internal.ads.zzny;
import com.google.android.gms.internal.ads.zzsg;
import java.io.IOException;
import java.util.Arrays;

final class zzsf {
    private final zzsg zza = new zzsg();
    private final zzamf zzb = new zzamf(new byte[65025], 0);
    private int zzc = -1;
    private int zzd;
    private boolean zze;

    zzsf() {
    }

    private final int zzf(int n) {
        int n2;
        Object object;
        int n3 = 0;
        this.zzd = 0;
        do {
            object = this.zzd;
            int n4 = n + object;
            Object object2 = this.zza;
            n2 = n3;
            if (n4 >= object2.zzc) return n2;
            object2 = object2.zzf;
            this.zzd = object + 1;
            object = object2[n4];
            n3 = n2 = n3 + object;
        } while (object == 255);
        return n2;
    }

    public final void zza() {
        this.zza.zza();
        this.zzb.zza(0);
        this.zzc = -1;
        this.zze = false;
    }

    public final boolean zzb(zznv zznv2) throws IOException {
        if (this.zze) {
            this.zze = false;
            this.zzb.zza(0);
        }
        while (true) {
            zzsg zzsg2;
            int n;
            boolean bl = this.zze;
            boolean bl2 = true;
            if (bl) return true;
            int n2 = n = this.zzc;
            if (n < 0) {
                if (!this.zza.zzb(zznv2, -1L)) return false;
                if (!this.zza.zzc(zznv2, true)) {
                    return false;
                }
                zzsg2 = this.zza;
                n = zzsg2.zzd;
                if ((zzsg2.zza & 1) == 1 && this.zzb.zze() == 0) {
                    n += this.zzf(0);
                    n2 = this.zzd;
                } else {
                    n2 = 0;
                }
                if (!zzny.zzd((zznv)zznv2, (int)n)) {
                    return false;
                }
                this.zzc = n2;
            }
            n2 = this.zzf(n2);
            n = this.zzc + this.zzd;
            if (n2 > 0) {
                zzsg2 = this.zzb;
                zzsg2.zzc(zzsg2.zze() + n2);
                if (!zzny.zzc((zznv)zznv2, (byte[])this.zzb.zzi(), (int)this.zzb.zze(), (int)n2)) {
                    return false;
                }
                zzsg2 = this.zzb;
                zzsg2.zzf(zzsg2.zze() + n2);
                if (this.zza.zzf[n - 1] == 255) {
                    bl2 = false;
                }
                this.zze = bl2;
            }
            n2 = n;
            if (n == this.zza.zzc) {
                n2 = -1;
            }
            this.zzc = n2;
        }
    }

    public final zzsg zzc() {
        return this.zza;
    }

    public final zzamf zzd() {
        return this.zzb;
    }

    public final void zze() {
        if (this.zzb.zzi().length == 65025) {
            return;
        }
        zzamf zzamf2 = this.zzb;
        zzamf2.zzb(Arrays.copyOf(zzamf2.zzi(), Math.max(65025, this.zzb.zze())), this.zzb.zze());
    }
}
