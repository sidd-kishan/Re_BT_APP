/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.internal.schedulers.RxThreadFactory$RxCustomThread
 */
package io.reactivex.internal.schedulers;

import io.reactivex.internal.schedulers.RxThreadFactory;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

public final class RxThreadFactory
extends AtomicLong
implements ThreadFactory {
    private static final long serialVersionUID = -7789753024099756196L;
    final boolean nonBlocking;
    final String prefix;
    final int priority;

    public RxThreadFactory(String string) {
        this(string, 5, false);
    }

    public RxThreadFactory(String string, int n) {
        this(string, n, false);
    }

    public RxThreadFactory(String string, int n, boolean bl) {
        this.prefix = string;
        this.priority = n;
        this.nonBlocking = bl;
    }

    @Override
    public Thread newThread(Runnable runnable) {
        CharSequence charSequence = new StringBuilder(this.prefix);
        charSequence.append('-');
        charSequence.append(this.incrementAndGet());
        charSequence = charSequence.toString();
        runnable = this.nonBlocking ? new RxCustomThread(runnable, (String)charSequence) : new Thread(runnable, (String)charSequence);
        ((Thread)runnable).setPriority(this.priority);
        ((Thread)runnable).setDaemon(true);
        return runnable;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("RxThreadFactory[");
        stringBuilder.append(this.prefix);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
