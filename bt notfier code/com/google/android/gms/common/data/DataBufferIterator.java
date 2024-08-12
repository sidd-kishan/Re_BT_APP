/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.common.data.DataBuffer
 *  com.google.android.gms.common.internal.Preconditions
 */
package com.google.android.gms.common.data;

import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class DataBufferIterator<T>
implements Iterator<T> {
    protected final DataBuffer<T> zaa;
    protected int zab;

    public DataBufferIterator(DataBuffer<T> dataBuffer) {
        this.zaa = (DataBuffer)Preconditions.checkNotNull(dataBuffer);
        this.zab = -1;
    }

    @Override
    public final boolean hasNext() {
        if (this.zab >= this.zaa.getCount() - 1) return false;
        return true;
    }

    @Override
    public T next() {
        if (this.hasNext()) {
            int n;
            DataBuffer<T> dataBuffer = this.zaa;
            this.zab = n = this.zab + 1;
            return (T)dataBuffer.get(n);
        }
        int n = this.zab;
        StringBuilder stringBuilder = new StringBuilder(46);
        stringBuilder.append("Cannot advance the iterator beyond ");
        stringBuilder.append(n);
        throw new NoSuchElementException(stringBuilder.toString());
    }

    @Override
    public final void remove() {
        throw new UnsupportedOperationException("Cannot remove elements from a DataBufferIterator");
    }
}
