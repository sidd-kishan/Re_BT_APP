/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzuk
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzuk;
import java.util.Collections;
import java.util.List;

public final class zzul {
    public final int zza;
    public final String zzb;
    public final List<zzuk> zzc;
    public final byte[] zzd;

    public zzul(int n, String list, List<zzuk> list2, byte[] byArray) {
        this.zza = n;
        this.zzb = list;
        list = list2 == null ? Collections.emptyList() : Collections.unmodifiableList(list2);
        this.zzc = list;
        this.zzd = byArray;
    }
}
