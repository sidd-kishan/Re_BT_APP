/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  com.google.android.gms.internal.ads.zzaj
 *  com.google.android.gms.internal.ads.zzakt
 *  com.google.android.gms.internal.ads.zzamf
 *  com.google.android.gms.internal.ads.zzan
 *  com.google.android.gms.internal.ads.zzay
 *  com.google.android.gms.internal.ads.zzgv
 */
package com.google.android.gms.internal.ads;

import android.net.Uri;
import com.google.android.gms.internal.ads.zzaj;
import com.google.android.gms.internal.ads.zzakt;
import com.google.android.gms.internal.ads.zzamf;
import com.google.android.gms.internal.ads.zzan;
import com.google.android.gms.internal.ads.zzay;
import com.google.android.gms.internal.ads.zzgv;
import java.io.IOException;
import java.util.List;
import java.util.Map;

final class zzgw
implements zzaj {
    private final zzaj zza;
    private final int zzb;
    private final zzgv zzc;
    private final byte[] zzd;
    private int zze;

    public zzgw(zzaj zzaj2, int n, zzgv zzgv2) {
        boolean bl = n > 0;
        zzakt.zza((boolean)bl);
        this.zza = zzaj2;
        this.zzb = n;
        this.zzc = zzgv2;
        this.zzd = new byte[1];
        this.zze = n;
    }

    public final void zza(zzay zzay2) {
        if (zzay2 == null) throw null;
        this.zza.zza(zzay2);
    }

    public final Map<String, List<String>> zzf() {
        return this.zza.zzf();
    }

    public final int zzg(byte[] byArray, int n, int n2) throws IOException {
        int n3;
        int n4 = n3 = this.zze;
        if (n3 == 0) {
            zzaj zzaj2 = this.zza;
            byte[] byArray2 = this.zzd;
            int n5 = 0;
            if (zzaj2.zzg(byArray2, 0, 1) == -1) {
                return -1;
            }
            n4 = (this.zzd[0] & 0xFF) << 4;
            if (n4 != 0) {
                int n6;
                byArray2 = new byte[n4];
                n3 = n4;
                while (true) {
                    n6 = n4;
                    if (n3 <= 0) break;
                    n6 = this.zza.zzg(byArray2, n5, n3);
                    if (n6 == -1) return -1;
                    n5 += n6;
                    n3 -= n6;
                }
                while (n6 > 0 && byArray2[n4 = n6 - 1] == 0) {
                    n6 = n4;
                }
                if (n6 > 0) {
                    this.zzc.zza(new zzamf(byArray2, n6));
                }
            }
            this.zze = n4 = this.zzb;
        }
        if ((n = this.zza.zzg(byArray, n, Math.min(n4, n2))) == -1) return n;
        this.zze -= n;
        return n;
    }

    public final long zzh(zzan zzan2) {
        throw new UnsupportedOperationException();
    }

    public final Uri zzi() {
        return this.zza.zzi();
    }

    public final void zzj() {
        throw new UnsupportedOperationException();
    }
}
