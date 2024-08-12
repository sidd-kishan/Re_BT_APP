/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  com.google.android.gms.common.data.DataBuffer
 *  com.google.android.gms.common.data.DataBufferIterator
 *  com.google.android.gms.common.data.DataHolder
 *  com.google.android.gms.common.data.SingleRefDataBufferIterator
 */
package com.google.android.gms.common.data;

import android.os.Bundle;
import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.common.data.DataBufferIterator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.SingleRefDataBufferIterator;
import java.util.Iterator;

public abstract class AbstractDataBuffer<T>
implements DataBuffer<T> {
    protected final DataHolder mDataHolder;

    protected AbstractDataBuffer(DataHolder dataHolder) {
        this.mDataHolder = dataHolder;
    }

    public final void close() {
        this.release();
    }

    public abstract T get(int var1);

    public int getCount() {
        DataHolder dataHolder = this.mDataHolder;
        if (dataHolder != null) return dataHolder.getCount();
        return 0;
    }

    public final Bundle getMetadata() {
        DataHolder dataHolder = this.mDataHolder;
        if (dataHolder != null) return dataHolder.getMetadata();
        return null;
    }

    @Deprecated
    public boolean isClosed() {
        DataHolder dataHolder = this.mDataHolder;
        if (dataHolder == null) return true;
        if (!dataHolder.isClosed()) return false;
        return true;
    }

    public Iterator<T> iterator() {
        return new DataBufferIterator((DataBuffer)this);
    }

    public void release() {
        DataHolder dataHolder = this.mDataHolder;
        if (dataHolder == null) return;
        dataHolder.close();
    }

    public Iterator<T> singleRefIterator() {
        return new SingleRefDataBufferIterator((DataBuffer)this);
    }
}
