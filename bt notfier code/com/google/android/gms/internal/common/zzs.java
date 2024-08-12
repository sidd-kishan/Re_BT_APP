/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.common.zzn
 *  com.google.android.gms.internal.common.zzu
 */
package com.google.android.gms.internal.common;

import com.google.android.gms.internal.common.zzn;
import com.google.android.gms.internal.common.zzu;

final class zzs<E>
extends zzn<E> {
    private final zzu<E> zza;

    zzs(zzu<E> zzu2, int n) {
        super(zzu2.size(), n);
        this.zza = zzu2;
    }

    protected final E zza(int n) {
        return (E)this.zza.get(n);
    }
}
