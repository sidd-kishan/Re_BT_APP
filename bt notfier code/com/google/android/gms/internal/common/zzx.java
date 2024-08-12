/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.internal.common;

import java.util.Iterator;

public abstract class zzx<E>
implements Iterator<E> {
    protected zzx() {
    }

    @Override
    @Deprecated
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
