/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  com.google.android.gms.common.api.Response
 *  com.google.android.gms.common.data.AbstractDataBuffer
 *  com.google.android.gms.common.data.DataBuffer
 */
package com.google.android.gms.common.api;

import android.os.Bundle;
import com.google.android.gms.common.api.Response;
import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataBuffer;
import java.util.Iterator;

public class DataBufferResponse<T, R extends AbstractDataBuffer<T>>
extends Response<R>
implements DataBuffer<T> {
    public DataBufferResponse() {
    }

    public DataBufferResponse(R r) {
        super(r);
    }

    public final void close() {
        ((AbstractDataBuffer)this.getResult()).close();
    }

    public final T get(int n) {
        return (T)((AbstractDataBuffer)this.getResult()).get(n);
    }

    public final int getCount() {
        return ((AbstractDataBuffer)this.getResult()).getCount();
    }

    public final Bundle getMetadata() {
        return ((AbstractDataBuffer)this.getResult()).getMetadata();
    }

    public final boolean isClosed() {
        return ((AbstractDataBuffer)this.getResult()).isClosed();
    }

    public final Iterator<T> iterator() {
        return ((AbstractDataBuffer)this.getResult()).iterator();
    }

    public final void release() {
        ((AbstractDataBuffer)this.getResult()).release();
    }

    public final Iterator<T> singleRefIterator() {
        return ((AbstractDataBuffer)this.getResult()).singleRefIterator();
    }
}
