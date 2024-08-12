/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.bumptech.glide.util.Util
 */
package com.bumptech.glide.util;

import com.bumptech.glide.util.Util;
import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;

public class ExceptionCatchingInputStream
extends InputStream {
    private static final Queue<ExceptionCatchingInputStream> QUEUE = Util.createQueue((int)0);
    private IOException exception;
    private InputStream wrapped;

    ExceptionCatchingInputStream() {
    }

    static void clearQueue() {
        while (!QUEUE.isEmpty()) {
            QUEUE.remove();
        }
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public static ExceptionCatchingInputStream obtain(InputStream inputStream) {
        ExceptionCatchingInputStream exceptionCatchingInputStream;
        Object object = QUEUE;
        synchronized (object) {
            exceptionCatchingInputStream = QUEUE.poll();
        }
        object = exceptionCatchingInputStream;
        if (exceptionCatchingInputStream == null) {
            object = new ExceptionCatchingInputStream();
        }
        ((ExceptionCatchingInputStream)object).setInputStream(inputStream);
        return object;
    }

    @Override
    public int available() throws IOException {
        return this.wrapped.available();
    }

    @Override
    public void close() throws IOException {
        this.wrapped.close();
    }

    public IOException getException() {
        return this.exception;
    }

    @Override
    public void mark(int n) {
        this.wrapped.mark(n);
    }

    @Override
    public boolean markSupported() {
        return this.wrapped.markSupported();
    }

    @Override
    public int read() {
        int n;
        try {
            n = this.wrapped.read();
        }
        catch (IOException iOException) {
            this.exception = iOException;
            n = -1;
        }
        return n;
    }

    @Override
    public int read(byte[] byArray) {
        int n;
        try {
            n = this.wrapped.read(byArray);
        }
        catch (IOException iOException) {
            this.exception = iOException;
            n = -1;
        }
        return n;
    }

    @Override
    public int read(byte[] byArray, int n, int n2) {
        try {
            n = this.wrapped.read(byArray, n, n2);
        }
        catch (IOException iOException) {
            this.exception = iOException;
            n = -1;
        }
        return n;
    }

    public void release() {
        this.exception = null;
        this.wrapped = null;
        Queue<ExceptionCatchingInputStream> queue = QUEUE;
        synchronized (queue) {
            QUEUE.offer(this);
            return;
        }
    }

    @Override
    public void reset() throws IOException {
        synchronized (this) {
            this.wrapped.reset();
            return;
        }
    }

    void setInputStream(InputStream inputStream) {
        this.wrapped = inputStream;
    }

    @Override
    public long skip(long l) {
        try {
            l = this.wrapped.skip(l);
        }
        catch (IOException iOException) {
            this.exception = iOException;
            l = 0L;
        }
        return l;
    }
}
