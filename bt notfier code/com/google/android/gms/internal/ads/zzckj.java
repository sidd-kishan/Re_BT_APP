/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  com.google.android.gms.internal.ads.zzatz
 *  com.google.android.gms.internal.ads.zzaub
 */
package com.google.android.gms.internal.ads;

import android.net.Uri;
import com.google.android.gms.internal.ads.zzatz;
import com.google.android.gms.internal.ads.zzaub;
import java.io.IOException;

final class zzckj
implements zzatz {
    private final zzatz zza;
    private final long zzb;
    private final zzatz zzc;
    private long zzd;
    private Uri zze;

    zzckj(zzatz zzatz2, int n, zzatz zzatz3) {
        this.zza = zzatz2;
        this.zzb = n;
        this.zzc = zzatz3;
    }

    public final long zza(zzaub zzaub2) throws IOException {
        long l;
        zzaub zzaub3;
        this.zze = zzaub2.zza;
        long l2 = zzaub2.zzc;
        long l3 = this.zzb;
        zzaub zzaub4 = null;
        if (l2 >= l3) {
            zzaub3 = null;
        } else {
            l = zzaub2.zzd;
            l = l != -1L ? Math.min(l, l3 - l2) : l3 - l2;
            zzaub3 = new zzaub(zzaub2.zza, null, l2, l2, l, null, 0);
        }
        l = zzaub2.zzd;
        if (l == -1L || zzaub2.zzc + l > this.zzb) {
            l2 = Math.max(this.zzb, zzaub2.zzc);
            l = zzaub2.zzd;
            l = l != -1L ? Math.min(l, zzaub2.zzc + l - this.zzb) : -1L;
            zzaub4 = new zzaub(zzaub2.zza, null, l2, l2, l, null, 0);
        }
        l2 = 0L;
        l = zzaub3 != null ? this.zza.zza(zzaub3) : 0L;
        if (zzaub4 != null) {
            l2 = this.zzc.zza(zzaub4);
        }
        this.zzd = zzaub2.zzc;
        if (l2 != -1L) return l + l2;
        return -1L;
    }

    public final int zzb(byte[] byArray, int n, int n2) throws IOException {
        int n3;
        long l = this.zzd;
        long l2 = this.zzb;
        if (l < l2) {
            l = Math.min((long)n2, l2 - l);
            n3 = this.zza.zzb(byArray, n, (int)l);
            this.zzd = l = this.zzd + (long)n3;
        } else {
            n3 = 0;
        }
        int n4 = n3;
        if (l < this.zzb) return n4;
        n = this.zzc.zzb(byArray, n + n3, n2 - n3);
        this.zzd += (long)n;
        n4 = n3 + n;
        return n4;
    }

    public final Uri zzc() {
        return this.zze;
    }

    public final void zzd() throws IOException {
        this.zza.zzd();
        this.zzc.zzd();
    }
}
