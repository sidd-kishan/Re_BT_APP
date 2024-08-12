/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  com.google.android.gms.internal.ads.zzan
 */
package com.google.android.gms.internal.ads;

import android.net.Uri;
import com.google.android.gms.internal.ads.zzan;
import java.util.Collections;
import java.util.Map;

public final class zzal {
    private Uri zza;
    private final int zzb;
    private Map<String, String> zzc = Collections.emptyMap();
    private long zzd;
    private int zze;

    public zzal() {
        this.zzb = 1;
    }

    public final zzal zza(Uri uri) {
        this.zza = uri;
        return this;
    }

    public final zzal zzb(Map<String, String> map) {
        this.zzc = map;
        return this;
    }

    public final zzal zzc(long l) {
        this.zzd = l;
        return this;
    }

    public final zzal zzd(int n) {
        this.zze = 6;
        return this;
    }

    public final zzan zze() {
        Uri uri = this.zza;
        if (uri == null) throw new IllegalStateException("The uri must be set.");
        return new zzan(uri, 0L, 1, null, this.zzc, this.zzd, -1L, null, this.zze, null, null);
    }
}
