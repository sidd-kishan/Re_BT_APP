/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.greenrobot.eventbus.EventBus
 *  org.greenrobot.eventbus.util.AsyncExecutor
 *  org.greenrobot.eventbus.util.ThrowableFailureEvent
 */
package org.greenrobot.eventbus.util;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.util.AsyncExecutor;
import org.greenrobot.eventbus.util.ThrowableFailureEvent;

public static class AsyncExecutor.Builder {
    private EventBus eventBus;
    private Class<?> failureEventType;
    private Executor threadPool;

    private AsyncExecutor.Builder() {
    }

    public AsyncExecutor build() {
        return this.buildForScope(null);
    }

    public AsyncExecutor buildForScope(Object object) {
        if (this.eventBus == null) {
            this.eventBus = EventBus.getDefault();
        }
        if (this.threadPool == null) {
            this.threadPool = Executors.newCachedThreadPool();
        }
        if (this.failureEventType != null) return new AsyncExecutor(this.threadPool, this.eventBus, this.failureEventType, object, null);
        this.failureEventType = ThrowableFailureEvent.class;
        return new AsyncExecutor(this.threadPool, this.eventBus, this.failureEventType, object, null);
    }

    public AsyncExecutor.Builder eventBus(EventBus eventBus) {
        this.eventBus = eventBus;
        return this;
    }

    public AsyncExecutor.Builder failureEventType(Class<?> clazz) {
        this.failureEventType = clazz;
        return this;
    }

    public AsyncExecutor.Builder threadPool(Executor executor) {
        this.threadPool = executor;
        return this;
    }
}
