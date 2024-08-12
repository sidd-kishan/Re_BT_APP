/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfng
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfng;
import java.util.AbstractCollection;
import java.util.Iterator;
import javax.annotation.CheckForNull;

final class zzfnf
extends AbstractCollection {
    final zzfng zza;

    zzfnf(zzfng zzfng2) {
        this.zza = zzfng2;
    }

    @Override
    public final void clear() {
        this.zza.zzi();
    }

    @Override
    public final boolean contains(@CheckForNull Object object) {
        return this.zza.zzr(object);
    }

    @Override
    public final Iterator iterator() {
        return this.zza.zzo();
    }

    @Override
    public final int size() {
        return this.zza.zzg();
    }
}
