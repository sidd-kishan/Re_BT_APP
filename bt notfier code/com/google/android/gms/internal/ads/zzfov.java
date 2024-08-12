/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfml
 *  com.google.android.gms.internal.ads.zzfqm
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfml;
import com.google.android.gms.internal.ads.zzfqm;

final class zzfov<T>
extends zzfml<T> {
    static final zzfqm<Object> zza = new zzfov<Object>(new Object[0], 0, 0, 0);
    private final T[] zzb;

    zzfov(T[] TArray, int n, int n2, int n3) {
        super(0, 0);
        this.zzb = TArray;
    }

    protected final T zza(int n) {
        return this.zzb[n];
    }
}
