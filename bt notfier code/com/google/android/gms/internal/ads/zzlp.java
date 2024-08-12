/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  com.google.android.gms.internal.ads.zzaj
 *  com.google.android.gms.internal.ads.zzan
 *  com.google.android.gms.internal.ads.zzay
 */
package com.google.android.gms.internal.ads;

import android.net.Uri;
import com.google.android.gms.internal.ads.zzaj;
import com.google.android.gms.internal.ads.zzan;
import com.google.android.gms.internal.ads.zzay;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class zzlp
implements zzaj {
    private final zzaj zza;
    private long zzb;
    private Uri zzc;
    private Map<String, List<String>> zzd;

    public zzlp(zzaj zzaj2) {
        if (zzaj2 == null) throw null;
        this.zza = zzaj2;
        this.zzc = Uri.EMPTY;
        this.zzd = Collections.emptyMap();
    }

    public final void zza(zzay zzay2) {
        if (zzay2 == null) throw null;
        this.zza.zza(zzay2);
    }

    public final long zzb() {
        return this.zzb;
    }

    public final Uri zzc() {
        return this.zzc;
    }

    public final Map<String, List<String>> zzd() {
        return this.zzd;
    }

    public final Map<String, List<String>> zzf() {
        return this.zza.zzf();
    }

    public final int zzg(byte[] byArray, int n, int n2) throws IOException {
        if ((n = this.zza.zzg(byArray, n, n2)) == -1) return n;
        this.zzb += (long)n;
        return n;
    }

    public final long zzh(zzan zzan2) throws IOException {
        this.zzc = zzan2.zza;
        this.zzd = Collections.emptyMap();
        long l = this.zza.zzh(zzan2);
        zzan2 = this.zzi();
        if (zzan2 == null) throw null;
        this.zzc = zzan2;
        this.zzd = this.zzf();
        return l;
    }

    public final Uri zzi() {
        return this.zza.zzi();
    }

    public final void zzj() throws IOException {
        this.zza.zzj();
    }
}
