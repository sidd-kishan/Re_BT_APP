/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.greenrobot.eventbus.EventBus
 *  org.greenrobot.eventbus.util.AsyncExecutor$Builder
 *  org.greenrobot.eventbus.util.AsyncExecutor$RunnableEx
 */
package org.greenrobot.eventbus.util;

import java.lang.reflect.Constructor;
import java.util.concurrent.Executor;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.util.AsyncExecutor;

public class AsyncExecutor {
    private final EventBus eventBus;
    private final Constructor<?> failureEventConstructor;
    private final Object scope;
    private final Executor threadPool;

    private AsyncExecutor(Executor executor, EventBus eventBus, Class<?> clazz, Object object) {
        this.threadPool = executor;
        this.eventBus = eventBus;
        this.scope = object;
        try {
            this.failureEventConstructor = clazz.getConstructor(Throwable.class);
            return;
        }
        catch (NoSuchMethodException noSuchMethodException) {
            throw new RuntimeException("Failure event class must have a constructor with one parameter of type Throwable", noSuchMethodException);
        }
    }

    static /* synthetic */ Constructor access$200(AsyncExecutor asyncExecutor) {
        return asyncExecutor.failureEventConstructor;
    }

    static /* synthetic */ EventBus access$300(AsyncExecutor asyncExecutor) {
        return asyncExecutor.eventBus;
    }

    static /* synthetic */ Object access$400(AsyncExecutor asyncExecutor) {
        return asyncExecutor.scope;
    }

    public static Builder builder() {
        return new Builder(null);
    }

    public static AsyncExecutor create() {
        return new Builder(null).build();
    }

    public void execute(RunnableEx runnableEx) {
        this.threadPool.execute((Runnable)new /* Unavailable Anonymous Inner Class!! */);
    }
}
