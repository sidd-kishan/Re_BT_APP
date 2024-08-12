/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfml
 *  com.google.android.gms.internal.ads.zzfoj
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfml;
import com.google.android.gms.internal.ads.zzfoj;

final class zzfoh<E>
extends zzfml<E> {
    private final zzfoj<E> zza;

    zzfoh(zzfoj<E> zzfoj2, int n) {
        super(zzfoj2.size(), n);
        this.zza = zzfoj2;
    }

    protected final E zza(int n) {
        return (E)this.zza.get(n);
    }
}
