/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzaft
 *  com.google.android.gms.internal.ads.zzafv
 *  com.google.android.gms.internal.ads.zzakt
 *  com.google.android.gms.internal.ads.zzamf
 *  com.google.android.gms.internal.ads.zznm
 *  com.google.android.gms.internal.ads.zznx
 *  com.google.android.gms.internal.ads.zzox
 *  com.google.android.gms.internal.ads.zzun
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzaft;
import com.google.android.gms.internal.ads.zzafv;
import com.google.android.gms.internal.ads.zzakt;
import com.google.android.gms.internal.ads.zzamf;
import com.google.android.gms.internal.ads.zznm;
import com.google.android.gms.internal.ads.zznx;
import com.google.android.gms.internal.ads.zzox;
import com.google.android.gms.internal.ads.zzun;
import java.util.List;

public final class zzuc {
    private final List<zzafv> zza;
    private final zzox[] zzb;

    public zzuc(List<zzafv> list) {
        this.zza = list;
        this.zzb = new zzox[list.size()];
    }

    public final void zza(zznx zznx2, zzun zzun2) {
        int n = 0;
        while (n < this.zzb.length) {
            String string;
            String string2;
            boolean bl;
            zzun2.zza();
            zzox zzox2 = zznx2.zzB(zzun2.zzb(), 3);
            zzafv zzafv2 = this.zza.get(n);
            String string3 = zzafv2.zzl;
            boolean bl2 = "application/cea-608".equals(string3);
            boolean bl3 = bl = true;
            if (!bl2) {
                bl3 = "application/cea-708".equals(string3) ? bl : false;
            }
            string2 = (string2 = String.valueOf(string3)).length() != 0 ? "Invalid closed caption mime type provided: ".concat(string2) : new String("Invalid closed caption mime type provided: ");
            zzakt.zzb((boolean)bl3, (Object)string2);
            string2 = string = zzafv2.zza;
            if (string == null) {
                string2 = zzun2.zzc();
            }
            string = new zzaft();
            string.zzD(string2);
            string.zzN(string3);
            string.zzH(zzafv2.zzd);
            string.zzG(zzafv2.zzc);
            string.zzaf(zzafv2.zzD);
            string.zzP(zzafv2.zzn);
            zzox2.zzs(string.zzah());
            this.zzb[n] = zzox2;
            ++n;
        }
    }

    public final void zzb(long l, zzamf zzamf2) {
        zznm.zza((long)l, (zzamf)zzamf2, (zzox[])this.zzb);
    }
}
