/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzame
 *  com.google.android.gms.internal.ads.zzamf
 *  com.google.android.gms.internal.ads.zzamn
 *  com.google.android.gms.internal.ads.zznx
 *  com.google.android.gms.internal.ads.zzua
 *  com.google.android.gms.internal.ads.zzub
 *  com.google.android.gms.internal.ads.zzui
 *  com.google.android.gms.internal.ads.zzuj
 *  com.google.android.gms.internal.ads.zzun
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzame;
import com.google.android.gms.internal.ads.zzamf;
import com.google.android.gms.internal.ads.zzamn;
import com.google.android.gms.internal.ads.zznx;
import com.google.android.gms.internal.ads.zzua;
import com.google.android.gms.internal.ads.zzub;
import com.google.android.gms.internal.ads.zzui;
import com.google.android.gms.internal.ads.zzuj;
import com.google.android.gms.internal.ads.zzun;

final class zzuh
implements zzua {
    final zzuj zza;
    private final zzame zzb;

    public zzuh(zzuj zzuj2) {
        this.zza = zzuj2;
        this.zzb = new zzame(new byte[4], 4);
    }

    public final void zza(zzamn zzamn2, zznx zznx2, zzun zzun2) {
    }

    public final void zzb(zzamf zzamf2) {
        if (zzamf2.zzn() != 0) {
            return;
        }
        if ((zzamf2.zzn() & 0x80) == 0) {
            return;
        }
        zzamf2.zzk(6);
        int n = zzamf2.zzd() / 4;
        int n2 = 0;
        while (true) {
            if (n2 >= n) {
                zzuj.zzg((zzuj)this.zza).remove(0);
                return;
            }
            zzamf2.zzl(this.zzb, 4);
            int n3 = this.zzb.zzh(16);
            this.zzb.zzf(3);
            if (n3 == 0) {
                this.zzb.zzf(13);
            } else {
                n3 = this.zzb.zzh(13);
                if (zzuj.zzg((zzuj)this.zza).get(n3) == null) {
                    zzuj.zzg((zzuj)this.zza).put(n3, (Object)new zzub((zzua)new zzui(this.zza, n3)));
                    zzuj zzuj2 = this.zza;
                    zzuj.zzl((zzuj)zzuj2, (int)(zzuj.zzk((zzuj)zzuj2) + 1));
                }
            }
            ++n2;
        }
    }
}
