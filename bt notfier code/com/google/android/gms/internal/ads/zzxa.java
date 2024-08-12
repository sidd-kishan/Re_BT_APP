/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzvu
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzvu;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

public final class zzxa {
    private final int zza;
    private final List<zzvu> zzb;
    private final int zzc;
    private final InputStream zzd;

    public zzxa(int n, List<zzvu> list, int n2, InputStream inputStream) {
        this.zza = n;
        this.zzb = list;
        this.zzc = n2;
        this.zzd = inputStream;
    }

    public final int zza() {
        return this.zza;
    }

    public final List<zzvu> zzb() {
        return Collections.unmodifiableList(this.zzb);
    }

    public final int zzc() {
        return this.zzc;
    }

    public final InputStream zzd() {
        InputStream inputStream = this.zzd;
        if (inputStream == null) return null;
        return inputStream;
    }
}
