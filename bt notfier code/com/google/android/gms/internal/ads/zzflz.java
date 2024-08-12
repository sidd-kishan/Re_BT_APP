/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzflk
 *  com.google.android.gms.internal.ads.zzflx
 *  com.google.android.gms.internal.ads.zzfma
 *  com.google.android.gms.internal.ads.zzfme
 *  com.google.android.gms.internal.ads.zzfmg
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzflk;
import com.google.android.gms.internal.ads.zzflx;
import com.google.android.gms.internal.ads.zzfma;
import com.google.android.gms.internal.ads.zzfme;
import com.google.android.gms.internal.ads.zzfmg;

final class zzflz
extends zzfme {
    final zzfma zza;

    zzflz(zzfma zzfma2, zzfmg zzfmg2, CharSequence charSequence) {
        this.zza = zzfma2;
        super(zzfmg2, charSequence);
    }

    final int zzc(int n) {
        zzflk zzflk2 = this.zza.zza;
        CharSequence charSequence = this.zzb;
        int n2 = charSequence.length();
        zzflx.zzf((int)n, (int)n2, (String)"index");
        while (true) {
            int n3;
            if (n >= n2) {
                n3 = -1;
                return n3;
            }
            n3 = n;
            if (zzflk2.zza(charSequence.charAt(n))) return n3;
            ++n;
        }
    }

    final int zzd(int n) {
        return n + 1;
    }
}
