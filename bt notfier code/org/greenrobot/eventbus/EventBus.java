/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.greenrobot.eventbus.AsyncPoster
 *  org.greenrobot.eventbus.BackgroundPoster
 *  org.greenrobot.eventbus.EventBus$2
 *  org.greenrobot.eventbus.EventBus$PostingThreadState
 *  org.greenrobot.eventbus.EventBusBuilder
 *  org.greenrobot.eventbus.EventBusException
 *  org.greenrobot.eventbus.Logger
 *  org.greenrobot.eventbus.MainThreadSupport
 *  org.greenrobot.eventbus.NoSubscriberEvent
 *  org.greenrobot.eventbus.PendingPost
 *  org.greenrobot.eventbus.Poster
 *  org.greenrobot.eventbus.SubscriberExceptionEvent
 *  org.greenrobot.eventbus.SubscriberMethod
 *  org.greenrobot.eventbus.SubscriberMethodFinder
 *  org.greenrobot.eventbus.Subscription
 *  org.greenrobot.eventbus.ThreadMode
 */
package org.greenrobot.eventbus;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.logging.Level;
import org.greenrobot.eventbus.AsyncPoster;
import org.greenrobot.eventbus.BackgroundPoster;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.EventBusBuilder;
import org.greenrobot.eventbus.EventBusException;
import org.greenrobot.eventbus.Logger;
import org.greenrobot.eventbus.MainThreadSupport;
import org.greenrobot.eventbus.NoSubscriberEvent;
import org.greenrobot.eventbus.PendingPost;
import org.greenrobot.eventbus.Poster;
import org.greenrobot.eventbus.SubscriberExceptionEvent;
import org.greenrobot.eventbus.SubscriberMethod;
import org.greenrobot.eventbus.SubscriberMethodFinder;
import org.greenrobot.eventbus.Subscription;
import org.greenrobot.eventbus.ThreadMode;

public class EventBus {
    private static final EventBusBuilder DEFAULT_BUILDER = new EventBusBuilder();
    public static String TAG = "EventBus";
    static volatile EventBus defaultInstance;
    private static final Map<Class<?>, List<Class<?>>> eventTypesCache;
    private final AsyncPoster asyncPoster;
    private final BackgroundPoster backgroundPoster;
    private final ThreadLocal<PostingThreadState> currentPostingThreadState = new /* Unavailable Anonymous Inner Class!! */;
    private final boolean eventInheritance;
    private final ExecutorService executorService;
    private final int indexCount;
    private final boolean logNoSubscriberMessages;
    private final boolean logSubscriberExceptions;
    private final Logger logger;
    private final Poster mainThreadPoster;
    private final MainThreadSupport mainThreadSupport;
    private final boolean sendNoSubscriberEvent;
    private final boolean sendSubscriberExceptionEvent;
    private final Map<Class<?>, Object> stickyEvents;
    private final SubscriberMethodFinder subscriberMethodFinder;
    private final Map<Class<?>, CopyOnWriteArrayList<Subscription>> subscriptionsByEventType;
    private final boolean throwSubscriberException;
    private final Map<Object, List<Class<?>>> typesBySubscriber;

    static {
        eventTypesCache = new HashMap();
    }

    public EventBus() {
        this(DEFAULT_BUILDER);
    }

    EventBus(EventBusBuilder eventBusBuilder) {
        Object object;
        this.logger = eventBusBuilder.getLogger();
        this.subscriptionsByEventType = new HashMap();
        this.typesBySubscriber = new HashMap();
        this.stickyEvents = new ConcurrentHashMap();
        this.mainThreadSupport = object = eventBusBuilder.getMainThreadSupport();
        object = object != null ? object.createPoster(this) : null;
        this.mainThreadPoster = object;
        this.backgroundPoster = new BackgroundPoster(this);
        this.asyncPoster = new AsyncPoster(this);
        int n = eventBusBuilder.subscriberInfoIndexes != null ? eventBusBuilder.subscriberInfoIndexes.size() : 0;
        this.indexCount = n;
        this.subscriberMethodFinder = new SubscriberMethodFinder(eventBusBuilder.subscriberInfoIndexes, eventBusBuilder.strictMethodVerification, eventBusBuilder.ignoreGeneratedIndex);
        this.logSubscriberExceptions = eventBusBuilder.logSubscriberExceptions;
        this.logNoSubscriberMessages = eventBusBuilder.logNoSubscriberMessages;
        this.sendSubscriberExceptionEvent = eventBusBuilder.sendSubscriberExceptionEvent;
        this.sendNoSubscriberEvent = eventBusBuilder.sendNoSubscriberEvent;
        this.throwSubscriberException = eventBusBuilder.throwSubscriberException;
        this.eventInheritance = eventBusBuilder.eventInheritance;
        this.executorService = eventBusBuilder.executorService;
    }

    static void addInterfaces(List<Class<?>> list, Class<?>[] classArray) {
        int n = classArray.length;
        int n2 = 0;
        while (n2 < n) {
            Class<?> clazz = classArray[n2];
            if (!list.contains(clazz)) {
                list.add(clazz);
                EventBus.addInterfaces(list, clazz.getInterfaces());
            }
            ++n2;
        }
    }

    public static EventBusBuilder builder() {
        return new EventBusBuilder();
    }

    private void checkPostStickyEventToSubscription(Subscription subscription, Object object) {
        if (object == null) return;
        this.postToSubscription(subscription, object, this.isMainThread());
    }

    public static void clearCaches() {
        SubscriberMethodFinder.clearCaches();
        eventTypesCache.clear();
    }

    public static EventBus getDefault() {
        if (defaultInstance != null) return defaultInstance;
        synchronized (EventBus.class) {
            EventBus eventBus;
            if (defaultInstance != null) return defaultInstance;
            defaultInstance = eventBus = new EventBus();
        }
        return defaultInstance;
    }

    private void handleSubscriberException(Subscription subscription, Object object, Throwable throwable) {
        if (object instanceof SubscriberExceptionEvent) {
            if (!this.logSubscriberExceptions) return;
            Logger logger = this.logger;
            Level level = Level.SEVERE;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("SubscriberExceptionEvent subscriber ");
            stringBuilder.append(subscription.subscriber.getClass());
            stringBuilder.append(" threw an exception");
            logger.log(level, stringBuilder.toString(), throwable);
            throwable = (SubscriberExceptionEvent)object;
            subscription = this.logger;
            object = Level.SEVERE;
            stringBuilder = new StringBuilder();
            stringBuilder.append("Initial event ");
            stringBuilder.append(((SubscriberExceptionEvent)throwable).causingEvent);
            stringBuilder.append(" caused exception in ");
            stringBuilder.append(((SubscriberExceptionEvent)throwable).causingSubscriber);
            subscription.log((Level)object, stringBuilder.toString(), ((SubscriberExceptionEvent)throwable).throwable);
        } else {
            if (this.throwSubscriberException) throw new EventBusException("Invoking subscriber failed", throwable);
            if (this.logSubscriberExceptions) {
                Logger logger = this.logger;
                Level level = Level.SEVERE;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Could not dispatch event: ");
                stringBuilder.append(object.getClass());
                stringBuilder.append(" to subscribing class ");
                stringBuilder.append(subscription.subscriber.getClass());
                logger.log(level, stringBuilder.toString(), throwable);
            }
            if (!this.sendSubscriberExceptionEvent) return;
            this.post(new SubscriberExceptionEvent(this, throwable, object, subscription.subscriber));
        }
    }

    private boolean isMainThread() {
        MainThreadSupport mainThreadSupport = this.mainThreadSupport;
        boolean bl = mainThreadSupport != null ? mainThreadSupport.isMainThread() : true;
        return bl;
    }

    private static List<Class<?>> lookupAllEventTypes(Class<?> clazz) {
        Map<Class<?>, List<Class<?>>> map = eventTypesCache;
        synchronized (map) {
            try {
                ArrayList arrayList = eventTypesCache.get(clazz);
                Serializable serializable = arrayList;
                if (arrayList != null) return serializable;
                arrayList = new ArrayList();
                serializable = clazz;
                while (true) {
                    if (serializable == null) {
                        eventTypesCache.put(clazz, arrayList);
                        serializable = arrayList;
                        return serializable;
                    }
                    arrayList.add((Class<?>)serializable);
                    EventBus.addInterfaces(arrayList, ((Class)serializable).getInterfaces());
                    serializable = ((Class)serializable).getSuperclass();
                }
            }
            catch (Throwable throwable) {
                throw throwable;
            }
        }
    }

    private void postSingleEvent(Object object, PostingThreadState object2) throws Error {
        boolean bl;
        Logger logger;
        Class<?> clazz = object.getClass();
        if (this.eventInheritance) {
            logger = EventBus.lookupAllEventTypes(clazz);
            int n = logger.size();
            int n2 = 0;
            boolean bl2 = false;
            while (true) {
                bl = bl2;
                if (n2 < n) {
                    bl2 |= this.postSingleEventForEventType(object, (PostingThreadState)object2, (Class)logger.get(n2));
                    ++n2;
                    continue;
                }
                break;
            }
        } else {
            bl = this.postSingleEventForEventType(object, (PostingThreadState)object2, clazz);
        }
        if (bl) return;
        if (this.logNoSubscriberMessages) {
            logger = this.logger;
            Level level = Level.FINE;
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("No subscribers registered for event ");
            ((StringBuilder)object2).append(clazz);
            logger.log(level, ((StringBuilder)object2).toString());
        }
        if (!this.sendNoSubscriberEvent) return;
        if (clazz == NoSubscriberEvent.class) return;
        if (clazz == SubscriberExceptionEvent.class) return;
        this.post(new NoSubscriberEvent(this, object));
    }

    /*
     * Exception decompiling
     */
    private boolean postSingleEventForEventType(Object var1_1, PostingThreadState var2_4, Class<?> var3_5) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 2[TRYBLOCK] [2 : 128->133)] java.lang.Throwable
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs.insertExceptionBlocks(Op02WithProcessedDataAndRefs.java:2283)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:415)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
         *     at org.benf.cfr.reader.Driver.doClass(Driver.java:84)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:78)
         *     at the.bytecode.club.bytecodeviewer.decompilers.impl.CFRDecompiler.decompile(CFRDecompiler.java:91)
         *     at the.bytecode.club.bytecodeviewer.decompilers.impl.CFRDecompiler.decompileToZip(CFRDecompiler.java:122)
         *     at the.bytecode.club.bytecodeviewer.resources.ResourceDecompiling.decompileSaveAll(ResourceDecompiling.java:262)
         *     at the.bytecode.club.bytecodeviewer.resources.ResourceDecompiling.lambda$decompileSaveAll$0(ResourceDecompiling.java:127)
         *     at java.lang.Thread.run(Unknown Source)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    private void postToSubscription(Subscription subscription, Object object, boolean bl) {
        int n = 2.$SwitchMap$org$greenrobot$eventbus$ThreadMode[subscription.subscriberMethod.threadMode.ordinal()];
        if (n != 1) {
            if (n != 2) {
                if (n != 3) {
                    if (n != 4) {
                        if (n != 5) {
                            object = new StringBuilder();
                            ((StringBuilder)object).append("Unknown thread mode: ");
                            ((StringBuilder)object).append(subscription.subscriberMethod.threadMode);
                            throw new IllegalStateException(((StringBuilder)object).toString());
                        }
                        this.asyncPoster.enqueue(subscription, object);
                    } else if (bl) {
                        this.backgroundPoster.enqueue(subscription, object);
                    } else {
                        this.invokeSubscriber(subscription, object);
                    }
                } else {
                    Poster poster = this.mainThreadPoster;
                    if (poster != null) {
                        poster.enqueue(subscription, object);
                    } else {
                        this.invokeSubscriber(subscription, object);
                    }
                }
            } else if (bl) {
                this.invokeSubscriber(subscription, object);
            } else {
                this.mainThreadPoster.enqueue(subscription, object);
            }
        } else {
            this.invokeSubscriber(subscription, object);
        }
    }

    private void subscribe(Object iterator, SubscriberMethod object) {
        Class clazz = ((SubscriberMethod)object).eventType;
        Subscription subscription = new Subscription((Object)iterator, (SubscriberMethod)object);
        List<Object> list = this.subscriptionsByEventType.get(clazz);
        if (list == null) {
            list = new CopyOnWriteArrayList();
            this.subscriptionsByEventType.put(clazz, (CopyOnWriteArrayList<Subscription>)list);
        } else if (((CopyOnWriteArrayList)list).contains(subscription)) {
            object = new StringBuilder();
            ((StringBuilder)object).append("Subscriber ");
            ((StringBuilder)object).append(iterator.getClass());
            ((StringBuilder)object).append(" already registered to event ");
            ((StringBuilder)object).append(clazz);
            iterator = new EventBusException(((StringBuilder)object).toString());
            throw iterator;
        }
        int n = ((CopyOnWriteArrayList)list).size();
        for (int i = 0; i <= n; ++i) {
            if (i != n && ((SubscriberMethod)object).priority <= ((Subscription)((CopyOnWriteArrayList)list).get((int)i)).subscriberMethod.priority) {
                continue;
            }
            ((CopyOnWriteArrayList)list).add(i, subscription);
            break;
        }
        List<Class<?>> list2 = this.typesBySubscriber.get(iterator);
        list = list2;
        if (list2 == null) {
            list = new ArrayList();
            this.typesBySubscriber.put(iterator, list);
        }
        list.add((Subscription)clazz);
        if (!((SubscriberMethod)object).sticky) return;
        if (!this.eventInheritance) {
            this.checkPostStickyEventToSubscription(subscription, this.stickyEvents.get(clazz));
            return;
        }
        iterator = this.stickyEvents.entrySet().iterator();
        while (iterator.hasNext()) {
            object = iterator.next();
            if (!clazz.isAssignableFrom((Class)object.getKey())) continue;
            this.checkPostStickyEventToSubscription(subscription, object.getValue());
        }
    }

    private void unsubscribeByEventType(Object object, Class<?> object2) {
        if ((object2 = (List)this.subscriptionsByEventType.get(object2)) == null) return;
        int n = object2.size();
        int n2 = 0;
        while (n2 < n) {
            Subscription subscription = (Subscription)object2.get(n2);
            int n3 = n;
            int n4 = n2;
            if (subscription.subscriber == object) {
                subscription.active = false;
                object2.remove(n2);
                n4 = n2 - 1;
                n3 = n - 1;
            }
            n2 = n4 + 1;
            n = n3;
        }
    }

    public void cancelEventDelivery(Object object) {
        PostingThreadState postingThreadState = this.currentPostingThreadState.get();
        if (!postingThreadState.isPosting) throw new EventBusException("This method may only be called from inside event handling methods on the posting thread");
        if (object == null) throw new EventBusException("Event may not be null");
        if (postingThreadState.event != object) throw new EventBusException("Only the currently handled event may be aborted");
        if (postingThreadState.subscription.subscriberMethod.threadMode != ThreadMode.POSTING) throw new EventBusException(" event handlers may only abort the incoming event");
        postingThreadState.canceled = true;
    }

    ExecutorService getExecutorService() {
        return this.executorService;
    }

    public Logger getLogger() {
        return this.logger;
    }

    public <T> T getStickyEvent(Class<T> clazz) {
        Map<Class<?>, Object> map = this.stickyEvents;
        synchronized (map) {
            clazz = clazz.cast(this.stickyEvents.get(clazz));
            return (T)clazz;
        }
    }

    /*
     * Enabled unnecessary exception pruning
     * Converted monitor instructions to comments
     */
    public boolean hasSubscriberForEvent(Class<?> list) {
        if ((list = EventBus.lookupAllEventTypes(list)) == null) return false;
        int n = list.size();
        int n2 = 0;
        while (n2 < n) {
            Serializable serializable = list.get(n2);
            // MONITORENTER : this
            serializable = this.subscriptionsByEventType.get(serializable);
            // MONITOREXIT : this
            if (serializable != null && !((CopyOnWriteArrayList)serializable).isEmpty()) {
                return true;
            }
            ++n2;
        }
        return false;
    }

    void invokeSubscriber(PendingPost pendingPost) {
        Object object = pendingPost.event;
        Subscription subscription = pendingPost.subscription;
        PendingPost.releasePendingPost((PendingPost)pendingPost);
        if (!subscription.active) return;
        this.invokeSubscriber(subscription, object);
    }

    void invokeSubscriber(Subscription subscription, Object object) {
        try {
            subscription.subscriberMethod.method.invoke(subscription.subscriber, object);
        }
        catch (IllegalAccessException illegalAccessException) {
            throw new IllegalStateException("Unexpected exception", illegalAccessException);
        }
        catch (InvocationTargetException invocationTargetException) {
            this.handleSubscriberException(subscription, object, invocationTargetException.getCause());
        }
    }

    public boolean isRegistered(Object object) {
        synchronized (this) {
            boolean bl = this.typesBySubscriber.containsKey(object);
            return bl;
        }
    }

    public void post(Object object) {
        PostingThreadState postingThreadState = this.currentPostingThreadState.get();
        List list = postingThreadState.eventQueue;
        list.add(object);
        if (postingThreadState.isPosting) return;
        postingThreadState.isMainThread = this.isMainThread();
        postingThreadState.isPosting = true;
        if (postingThreadState.canceled) throw new EventBusException("Internal error. Abort state was not reset");
        try {
            while (!list.isEmpty()) {
                this.postSingleEvent(list.remove(0), postingThreadState);
            }
            return;
        }
        finally {
            postingThreadState.isPosting = false;
            postingThreadState.isMainThread = false;
        }
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public void postSticky(Object object) {
        Map<Class<?>, Object> map = this.stickyEvents;
        synchronized (map) {
            this.stickyEvents.put(object.getClass(), object);
        }
        this.post(object);
    }

    public void register(Object object) {
        Iterator iterator = object.getClass();
        iterator = this.subscriberMethodFinder.findSubscriberMethods(iterator);
        synchronized (this) {
            try {
                iterator = iterator.iterator();
                while (iterator.hasNext()) {
                    this.subscribe(object, (SubscriberMethod)iterator.next());
                }
                return;
            }
            catch (Throwable throwable) {
                throw throwable;
            }
        }
    }

    public void removeAllStickyEvents() {
        Map<Class<?>, Object> map = this.stickyEvents;
        synchronized (map) {
            this.stickyEvents.clear();
            return;
        }
    }

    public <T> T removeStickyEvent(Class<T> clazz) {
        Map<Class<?>, Object> map = this.stickyEvents;
        synchronized (map) {
            clazz = clazz.cast(this.stickyEvents.remove(clazz));
            return (T)clazz;
        }
    }

    public boolean removeStickyEvent(Object object) {
        Map<Class<?>, Object> map = this.stickyEvents;
        synchronized (map) {
            Class<?> clazz = object.getClass();
            if (!object.equals(this.stickyEvents.get(clazz))) return false;
            this.stickyEvents.remove(clazz);
            return true;
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("EventBus[indexCount=");
        stringBuilder.append(this.indexCount);
        stringBuilder.append(", eventInheritance=");
        stringBuilder.append(this.eventInheritance);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public void unregister(Object object) {
        synchronized (this) {
            try {
                Object object2 = this.typesBySubscriber.get(object);
                if (object2 != null) {
                    object2 = object2.iterator();
                    while (object2.hasNext()) {
                        this.unsubscribeByEventType(object, (Class)object2.next());
                    }
                    this.typesBySubscriber.remove(object);
                } else {
                    Logger logger = this.logger;
                    Level level = Level.WARNING;
                    object2 = new StringBuilder();
                    ((StringBuilder)object2).append("Subscriber to unregister was not registered before: ");
                    ((StringBuilder)object2).append(object.getClass());
                    logger.log(level, ((StringBuilder)object2).toString());
                }
                return;
            }
            catch (Throwable throwable) {
                throw throwable;
            }
        }
    }
}
