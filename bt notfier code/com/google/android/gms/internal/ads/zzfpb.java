/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfln
 *  com.google.android.gms.internal.ads.zzfni
 *  com.google.android.gms.internal.ads.zzfpa
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfln;
import com.google.android.gms.internal.ads.zzfni;
import com.google.android.gms.internal.ads.zzfpa;
import java.util.ArrayList;
import java.util.List;

public final class zzfpb {
    public static <E> ArrayList<E> zza(int n) {
        zzfni.zzb((int)n, (String)"initialArraySize");
        return new ArrayList(n);
    }

    public static <F, T> List<T> zzb(List<F> list, zzfln<? super F, ? extends T> zzfln2) {
        return new zzfpa(list, zzfln2);
    }
}
