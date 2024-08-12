/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Looper
 *  org.greenrobot.eventbus.EventBus
 *  org.greenrobot.eventbus.EventBusException
 *  org.greenrobot.eventbus.Logger
 *  org.greenrobot.eventbus.Logger$AndroidLogger
 *  org.greenrobot.eventbus.Logger$SystemOutLogger
 *  org.greenrobot.eventbus.MainThreadSupport
 *  org.greenrobot.eventbus.MainThreadSupport$AndroidHandlerMainThreadSupport
 *  org.greenrobot.eventbus.meta.SubscriberInfoIndex
 */
package org.greenrobot.eventbus;

import android.os.Looper;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.EventBusException;
import org.greenrobot.eventbus.Logger;
import org.greenrobot.eventbus.MainThreadSupport;
import org.greenrobot.eventbus.meta.SubscriberInfoIndex;

public class EventBusBuilder {
    private static final ExecutorService DEFAULT_EXECUTOR_SERVICE = Executors.newCachedThreadPool();
    boolean eventInheritance = true;
    ExecutorService executorService = DEFAULT_EXECUTOR_SERVICE;
    boolean ignoreGeneratedIndex;
    boolean logNoSubscriberMessages = true;
    boolean logSubscriberExceptions = true;
    Logger logger;
    MainThreadSupport mainThreadSupport;
    boolean sendNoSubscriberEvent = true;
    boolean sendSubscriberExceptionEvent = true;
    List<Class<?>> skipMethodVerificationForClasses;
    boolean strictMethodVerification;
    List<SubscriberInfoIndex> subscriberInfoIndexes;
    boolean throwSubscriberException;

    EventBusBuilder() {
    }

    public EventBusBuilder addIndex(SubscriberInfoIndex subscriberInfoIndex) {
        if (this.subscriberInfoIndexes == null) {
            this.subscriberInfoIndexes = new ArrayList<SubscriberInfoIndex>();
        }
        this.subscriberInfoIndexes.add(subscriberInfoIndex);
        return this;
    }

    public EventBus build() {
        return new EventBus(this);
    }

    public EventBusBuilder eventInheritance(boolean bl) {
        this.eventInheritance = bl;
        return this;
    }

    public EventBusBuilder executorService(ExecutorService executorService) {
        this.executorService = executorService;
        return this;
    }

    Object getAndroidMainLooperOrNull() {
        try {
            Looper looper = Looper.getMainLooper();
            return looper;
        }
        catch (RuntimeException runtimeException) {
            return null;
        }
    }

    Logger getLogger() {
        Object object = this.logger;
        if (object != null) {
            return object;
        }
        object = Logger.AndroidLogger.isAndroidLogAvailable() && this.getAndroidMainLooperOrNull() != null ? new Logger.AndroidLogger("EventBus") : new Logger.SystemOutLogger();
        return object;
    }

    MainThreadSupport getMainThreadSupport() {
        Object object = this.mainThreadSupport;
        if (object != null) {
            return object;
        }
        boolean bl = Logger.AndroidLogger.isAndroidLogAvailable();
        Object var3_3 = null;
        object = var3_3;
        if (!bl) return object;
        object = this.getAndroidMainLooperOrNull();
        object = object == null ? var3_3 : new MainThreadSupport.AndroidHandlerMainThreadSupport((Looper)object);
        return object;
    }

    public EventBusBuilder ignoreGeneratedIndex(boolean bl) {
        this.ignoreGeneratedIndex = bl;
        return this;
    }

    public EventBus installDefaultEventBus() {
        synchronized (EventBus.class) {
            if (EventBus.defaultInstance == null) {
                EventBus eventBus = EventBus.defaultInstance = this.build();
                return eventBus;
            }
            EventBusException eventBusException = new EventBusException("Default instance already exists. It may be only set once before it's used the first time to ensure consistent behavior.");
            throw eventBusException;
        }
    }

    public EventBusBuilder logNoSubscriberMessages(boolean bl) {
        this.logNoSubscriberMessages = bl;
        return this;
    }

    public EventBusBuilder logSubscriberExceptions(boolean bl) {
        this.logSubscriberExceptions = bl;
        return this;
    }

    public EventBusBuilder logger(Logger logger) {
        this.logger = logger;
        return this;
    }

    public EventBusBuilder sendNoSubscriberEvent(boolean bl) {
        this.sendNoSubscriberEvent = bl;
        return this;
    }

    public EventBusBuilder sendSubscriberExceptionEvent(boolean bl) {
        this.sendSubscriberExceptionEvent = bl;
        return this;
    }

    public EventBusBuilder skipMethodVerificationFor(Class<?> clazz) {
        if (this.skipMethodVerificationForClasses == null) {
            this.skipMethodVerificationForClasses = new ArrayList();
        }
        this.skipMethodVerificationForClasses.add(clazz);
        return this;
    }

    public EventBusBuilder strictMethodVerification(boolean bl) {
        this.strictMethodVerification = bl;
        return this;
    }

    public EventBusBuilder throwSubscriberException(boolean bl) {
        this.throwSubscriberException = bl;
        return this;
    }
}
