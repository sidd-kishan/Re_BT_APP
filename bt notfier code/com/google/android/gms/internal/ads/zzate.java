/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzanv
 *  com.google.android.gms.internal.ads.zzanw
 *  com.google.android.gms.internal.ads.zzanx
 *  com.google.android.gms.internal.ads.zzaup
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzanv;
import com.google.android.gms.internal.ads.zzanw;
import com.google.android.gms.internal.ads.zzanx;
import com.google.android.gms.internal.ads.zzaup;

public final class zzate
extends zzanx {
    private static final Object zzb = new Object();
    private final long zzc;
    private final long zzd;

    public zzate(long l, boolean bl) {
        this.zzc = l;
        this.zzd = l;
    }

    public final int zza() {
        return 1;
    }

    public final zzanw zzb(int n, zzanw zzanw2, boolean bl, long l) {
        zzaup.zzc((int)n, (int)0, (int)1);
        zzanw2.zza = this.zzd;
        return zzanw2;
    }

    public final int zzc() {
        return 1;
    }

    public final zzanv zzd(int n, zzanv zzanv2, boolean bl) {
        zzaup.zzc((int)n, (int)0, (int)1);
        Object object = bl ? zzb : null;
        long l = this.zzc;
        zzanv2.zza = object;
        zzanv2.zzb = object;
        zzanv2.zzc = l;
        return zzanv2;
    }

    public final int zze(Object object) {
        if (!zzb.equals(object)) return -1;
        return 0;
    }
}
