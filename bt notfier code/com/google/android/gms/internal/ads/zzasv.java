/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzanc
 *  com.google.android.gms.internal.ads.zzanw
 *  com.google.android.gms.internal.ads.zzanx
 *  com.google.android.gms.internal.ads.zzasp
 *  com.google.android.gms.internal.ads.zzasq
 *  com.google.android.gms.internal.ads.zzasr
 *  com.google.android.gms.internal.ads.zzass
 *  com.google.android.gms.internal.ads.zzast
 *  com.google.android.gms.internal.ads.zzasu
 *  com.google.android.gms.internal.ads.zzauc
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzanc;
import com.google.android.gms.internal.ads.zzanw;
import com.google.android.gms.internal.ads.zzanx;
import com.google.android.gms.internal.ads.zzasp;
import com.google.android.gms.internal.ads.zzasq;
import com.google.android.gms.internal.ads.zzasr;
import com.google.android.gms.internal.ads.zzass;
import com.google.android.gms.internal.ads.zzast;
import com.google.android.gms.internal.ads.zzasu;
import com.google.android.gms.internal.ads.zzauc;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public final class zzasv
implements zzasr {
    private final zzasr[] zza;
    private final ArrayList<zzasr> zzb;
    private final zzanw zzc;
    private zzasq zzd;
    private zzanx zze;
    private int zzf;
    private zzasu zzg;

    public zzasv(zzasr ... zzasrArray) {
        this.zza = zzasrArray;
        this.zzb = new ArrayList<zzasr>(Arrays.asList(zzasrArray));
        this.zzc = new zzanw();
        this.zzf = -1;
    }

    /*
     * Unable to fully structure code
     */
    static /* synthetic */ void zzf(zzasv var0, int var1_1, zzanx var2_2, Object var3_3) {
        block4: {
            block5: {
                if (var0.zzg != null) break block4;
                for (var4_4 = 0; var4_4 <= 0; ++var4_4) {
                    var2_2.zzg(var4_4, var0.zzc, false);
                }
                var4_4 = var0.zzf;
                if (var4_4 != -1) break block5;
                var0.zzf = 1;
                ** GOTO lbl-1000
            }
            if (var4_4 != 1) {
                var3_3 = new zzasu(1);
            } else lbl-1000:
            // 2 sources

            {
                var3_3 = null;
            }
            var0.zzg = var3_3;
        }
        if (var0.zzg != null) return;
        var0.zzb.remove(var0.zza[var1_1]);
        if (var1_1 == 0) {
            var0.zze = var2_2;
        }
        if (var0.zzb.isEmpty() == false) return;
        var0.zzd.zzi(var0.zze, null);
    }

    public final void zza(zzanc zzanc2, boolean bl, zzasq zzasrArray) {
        this.zzd = zzasrArray;
        int n = 0;
        while (n < (zzasrArray = this.zza).length) {
            zzasrArray[n].zza(zzanc2, false, (zzasq)new zzast(this, n));
            ++n;
        }
    }

    public final void zzb() throws IOException {
        zzasr[] zzasrArray = this.zzg;
        if (zzasrArray != null) throw zzasrArray;
        zzasrArray = this.zza;
        int n = zzasrArray.length;
        int n2 = 0;
        while (n2 < n) {
            zzasrArray[n2].zzb();
            ++n2;
        }
    }

    public final void zzc(zzasp zzasp2) {
        zzasr[] zzasrArray;
        zzasp2 = (zzass)zzasp2;
        int n = 0;
        while (n < (zzasrArray = this.zza).length) {
            zzasrArray[n].zzc(zzasp2.zza[n]);
            ++n;
        }
    }

    public final void zzd() {
        zzasr[] zzasrArray = this.zza;
        int n = zzasrArray.length;
        int n2 = 0;
        while (n2 < n) {
            zzasrArray[n2].zzd();
            ++n2;
        }
    }

    public final zzasp zze(int n, zzauc zzauc2) {
        int n2 = this.zza.length;
        zzasp[] zzaspArray = new zzasp[n2];
        int n3 = 0;
        while (n3 < n2) {
            zzaspArray[n3] = this.zza[n3].zze(n, zzauc2);
            ++n3;
        }
        return new zzass(zzaspArray);
    }
}
