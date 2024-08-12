/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  com.google.android.gms.internal.ads.zzaj
 *  com.google.android.gms.internal.ads.zzan
 *  com.google.android.gms.internal.ads.zzay
 *  com.google.android.gms.internal.ads.zzfon
 */
package com.google.android.gms.internal.ads;

import android.net.Uri;
import com.google.android.gms.internal.ads.zzaj;
import com.google.android.gms.internal.ads.zzan;
import com.google.android.gms.internal.ads.zzay;
import com.google.android.gms.internal.ads.zzfon;
import java.io.IOException;
import java.util.List;
import java.util.Map;

final class zzclq
implements zzaj {
    private final zzaj zza;
    private final long zzb;
    private final zzaj zzc;
    private long zzd;
    private Uri zze;

    zzclq(zzaj zzaj2, int n, zzaj zzaj3) {
        this.zza = zzaj2;
        this.zzb = n;
        this.zzc = zzaj3;
    }

    public final void zza(zzay zzay2) {
    }

    public final Map<String, List<String>> zzf() {
        return zzfon.zza();
    }

    public final int zzg(byte[] byArray, int n, int n2) throws IOException {
        int n3;
        long l = this.zzd;
        long l2 = this.zzb;
        if (l < l2) {
            l = Math.min((long)n2, l2 - l);
            n3 = this.zza.zzg(byArray, n, (int)l);
            this.zzd = l = this.zzd + (long)n3;
        } else {
            n3 = 0;
        }
        int n4 = n3;
        if (l < this.zzb) return n4;
        n = this.zzc.zzg(byArray, n + n3, n2 - n3);
        this.zzd += (long)n;
        n4 = n3 + n;
        return n4;
    }

    public final long zzh(zzan zzan2) throws IOException {
        long l;
        zzan zzan3;
        this.zze = zzan2.zza;
        long l2 = zzan2.zzf;
        long l3 = this.zzb;
        zzan zzan4 = null;
        if (l2 >= l3) {
            zzan3 = null;
        } else {
            l = zzan2.zzg;
            l = l != -1L ? Math.min(l, l3 - l2) : l3 - l2;
            zzan3 = new zzan(zzan2.zza, null, l2, l2, l, null, 0);
        }
        l = zzan2.zzg;
        if (l == -1L || zzan2.zzf + l > this.zzb) {
            l2 = Math.max(this.zzb, zzan2.zzf);
            l = zzan2.zzg;
            l = l != -1L ? Math.min(l, zzan2.zzf + l - this.zzb) : -1L;
            zzan4 = new zzan(zzan2.zza, null, l2, l2, l, null, 0);
        }
        l2 = 0L;
        l = zzan3 != null ? this.zza.zzh(zzan3) : 0L;
        if (zzan4 != null) {
            l2 = this.zzc.zzh(zzan4);
        }
        this.zzd = zzan2.zzf;
        if (l == -1L) return -1L;
        if (l2 != -1L) return l + l2;
        return -1L;
    }

    public final Uri zzi() {
        return this.zze;
    }

    public final void zzj() throws IOException {
        this.zza.zzj();
        this.zzc.zzj();
    }
}
