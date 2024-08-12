/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfnl
 *  com.google.android.gms.internal.ads.zzfns
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfnl;
import com.google.android.gms.internal.ads.zzfns;
import java.util.AbstractCollection;
import java.util.Iterator;

final class zzfnr
extends AbstractCollection {
    final zzfns zza;

    zzfnr(zzfns zzfns2) {
        this.zza = zzfns2;
    }

    @Override
    public final void clear() {
        this.zza.clear();
    }

    @Override
    public final Iterator iterator() {
        zzfns zzfns2 = this.zza;
        Object object = zzfns2.zzg();
        object = object != null ? object.values().iterator() : new zzfnl(zzfns2);
        return object;
    }

    @Override
    public final int size() {
        return this.zza.size();
    }
}
