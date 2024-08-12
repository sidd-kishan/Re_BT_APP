/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.common.zzx
 */
package com.google.android.gms.internal.common;

import com.google.android.gms.internal.common.zzx;
import java.util.ListIterator;

public abstract class zzy<E>
extends zzx<E>
implements ListIterator<E> {
    protected zzy() {
    }

    @Override
    @Deprecated
    public final void add(E e) {
        throw new UnsupportedOperationException();
    }

    @Override
    @Deprecated
    public final void set(E e) {
        throw new UnsupportedOperationException();
    }
}
