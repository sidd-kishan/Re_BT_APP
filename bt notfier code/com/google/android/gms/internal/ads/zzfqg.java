/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfqh
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfqh;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Set;

abstract class zzfqg<E>
extends AbstractSet<E> {
    zzfqg() {
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        return zzfqh.zzc((Set)this, collection);
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        if (collection == null) throw null;
        return super.retainAll(collection);
    }
}
