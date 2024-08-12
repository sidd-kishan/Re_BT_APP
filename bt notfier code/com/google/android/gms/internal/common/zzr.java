/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.common.zzo
 */
package com.google.android.gms.internal.common;

import com.google.android.gms.internal.common.zzo;
import java.util.Iterator;

public final class zzr<E>
extends zzo<E> {
    public zzr() {
        super(4);
    }

    zzr(int n) {
        super(4);
    }

    public final zzr<E> zzb(E e) {
        super.zza(e);
        return this;
    }

    public final zzr<E> zzc(Iterator<? extends E> iterator) {
        while (iterator.hasNext()) {
            super.zza(iterator.next());
        }
        return this;
    }
}
