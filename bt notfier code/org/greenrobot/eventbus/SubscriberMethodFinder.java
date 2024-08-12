/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.greenrobot.eventbus.EventBusException
 *  org.greenrobot.eventbus.Subscribe
 *  org.greenrobot.eventbus.SubscriberMethod
 *  org.greenrobot.eventbus.SubscriberMethodFinder$FindState
 *  org.greenrobot.eventbus.ThreadMode
 *  org.greenrobot.eventbus.meta.SubscriberInfo
 *  org.greenrobot.eventbus.meta.SubscriberInfoIndex
 */
package org.greenrobot.eventbus;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.greenrobot.eventbus.EventBusException;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.SubscriberMethod;
import org.greenrobot.eventbus.SubscriberMethodFinder;
import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.eventbus.meta.SubscriberInfo;
import org.greenrobot.eventbus.meta.SubscriberInfoIndex;

class SubscriberMethodFinder {
    private static final int BRIDGE = 64;
    private static final FindState[] FIND_STATE_POOL;
    private static final Map<Class<?>, List<SubscriberMethod>> METHOD_CACHE;
    private static final int MODIFIERS_IGNORE = 5192;
    private static final int POOL_SIZE = 4;
    private static final int SYNTHETIC = 4096;
    private final boolean ignoreGeneratedIndex;
    private final boolean strictMethodVerification;
    private List<SubscriberInfoIndex> subscriberInfoIndexes;

    static {
        METHOD_CACHE = new ConcurrentHashMap();
        FIND_STATE_POOL = new FindState[4];
    }

    SubscriberMethodFinder(List<SubscriberInfoIndex> list, boolean bl, boolean bl2) {
        this.subscriberInfoIndexes = list;
        this.strictMethodVerification = bl;
        this.ignoreGeneratedIndex = bl2;
    }

    static void clearCaches() {
        METHOD_CACHE.clear();
    }

    private List<SubscriberMethod> findUsingInfo(Class<?> subscriberMethod2) {
        FindState findState = this.prepareFindState();
        findState.initForSubscriber(subscriberMethod2);
        while (findState.clazz != null) {
            findState.subscriberInfo = this.getSubscriberInfo(findState);
            if (findState.subscriberInfo != null) {
                for (SubscriberMethod subscriberMethod2 : findState.subscriberInfo.getSubscriberMethods()) {
                    if (!findState.checkAdd(subscriberMethod2.method, subscriberMethod2.eventType)) continue;
                    findState.subscriberMethods.add(subscriberMethod2);
                }
            } else {
                this.findUsingReflectionInSingleClass(findState);
            }
            findState.moveToSuperclass();
        }
        return this.getMethodsAndRelease(findState);
    }

    private List<SubscriberMethod> findUsingReflection(Class<?> clazz) {
        FindState findState = this.prepareFindState();
        findState.initForSubscriber(clazz);
        while (findState.clazz != null) {
            this.findUsingReflectionInSingleClass(findState);
            findState.moveToSuperclass();
        }
        return this.getMethodsAndRelease(findState);
    }

    private void findUsingReflectionInSingleClass(FindState object) {
        Object object2;
        try {
            object2 = ((FindState)object).clazz.getDeclaredMethods();
        }
        catch (Throwable throwable) {
            object2 = ((FindState)object).clazz.getMethods();
            ((FindState)object).skipSuperClasses = true;
        }
        int n = ((Method[])object2).length;
        int n2 = 0;
        while (n2 < n) {
            Method method = object2[n2];
            int n3 = method.getModifiers();
            if ((n3 & 1) != 0 && (n3 & 0x1448) == 0) {
                Object object3 = method.getParameterTypes();
                if (((Class<?>[])object3).length == 1) {
                    Subscribe subscribe = method.getAnnotation(Subscribe.class);
                    if (subscribe != null && object.checkAdd(method, object3 = object3[0])) {
                        ThreadMode threadMode = subscribe.threadMode();
                        ((FindState)object).subscriberMethods.add(new SubscriberMethod(method, object3, threadMode, subscribe.priority(), subscribe.sticky()));
                    }
                } else if (this.strictMethodVerification && method.isAnnotationPresent(Subscribe.class)) {
                    object = new StringBuilder();
                    ((StringBuilder)object).append(method.getDeclaringClass().getName());
                    ((StringBuilder)object).append(".");
                    ((StringBuilder)object).append(method.getName());
                    object2 = ((StringBuilder)object).toString();
                    object = new StringBuilder();
                    ((StringBuilder)object).append("@Subscribe method ");
                    ((StringBuilder)object).append((String)object2);
                    ((StringBuilder)object).append("must have exactly 1 parameter but has ");
                    ((StringBuilder)object).append(((Class<?>[])object3).length);
                    throw new EventBusException(((StringBuilder)object).toString());
                }
            } else if (this.strictMethodVerification && method.isAnnotationPresent(Subscribe.class)) {
                object = new StringBuilder();
                ((StringBuilder)object).append(method.getDeclaringClass().getName());
                ((StringBuilder)object).append(".");
                ((StringBuilder)object).append(method.getName());
                object = ((StringBuilder)object).toString();
                object2 = new StringBuilder();
                ((StringBuilder)object2).append((String)object);
                ((StringBuilder)object2).append(" is a illegal @Subscribe method: must be public, non-static, and non-abstract");
                throw new EventBusException(((StringBuilder)object2).toString());
            }
            ++n2;
        }
    }

    /*
     * Unable to fully structure code
     * Enabled unnecessary exception pruning
     */
    private List<SubscriberMethod> getMethodsAndRelease(FindState var1_1) {
        var4_3 = new ArrayList<SubscriberMethod>(var1_1.subscriberMethods);
        var1_1.recycle();
        var3_4 = SubscriberMethodFinder.FIND_STATE_POOL;
        synchronized (var3_4) {
            var2_5 = 0;
            while (var2_5 < 4) {
                if (SubscriberMethodFinder.FIND_STATE_POOL[var2_5] != null) {
                    ++var2_5;
                    continue;
                }
                ** break block6
            }
            return var4_3;
lbl-1000:
            // 1 sources

            {
                SubscriberMethodFinder.FIND_STATE_POOL[var2_5] = var1_1;
                return var4_3;
            }
            catch (Throwable var1_2) {
                throw var1_2;
            }
        }
    }

    private SubscriberInfo getSubscriberInfo(FindState findState) {
        SubscriberInfo subscriberInfo;
        if (findState.subscriberInfo != null && findState.subscriberInfo.getSuperSubscriberInfo() != null && findState.clazz == (subscriberInfo = findState.subscriberInfo.getSuperSubscriberInfo()).getSubscriberClass()) {
            return subscriberInfo;
        }
        subscriberInfo = this.subscriberInfoIndexes;
        if (subscriberInfo == null) return null;
        Iterator<SubscriberInfoIndex> iterator = subscriberInfo.iterator();
        do {
            if (!iterator.hasNext()) return null;
        } while ((subscriberInfo = iterator.next().getSubscriberInfo(findState.clazz)) == null);
        return subscriberInfo;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled unnecessary exception pruning
     */
    private FindState prepareFindState() {
        FindState[] findStateArray = FIND_STATE_POOL;
        synchronized (findStateArray) {
            int n = 0;
            while (n < 4) {
                FindState findState = FIND_STATE_POOL[n];
                if (findState != null) {
                    SubscriberMethodFinder.FIND_STATE_POOL[n] = null;
                    return findState;
                }
                ++n;
                continue;
                {
                    catch (Throwable throwable) {}
                    {
                        throw throwable;
                    }
                }
            }
            return new FindState();
        }
    }

    List<SubscriberMethod> findSubscriberMethods(Class<?> clazz) {
        List<SubscriberMethod> list = METHOD_CACHE.get(clazz);
        if (list != null) {
            return list;
        }
        list = this.ignoreGeneratedIndex ? this.findUsingReflection(clazz) : this.findUsingInfo(clazz);
        if (!list.isEmpty()) {
            METHOD_CACHE.put(clazz, list);
            return list;
        }
        list = new StringBuilder();
        ((StringBuilder)((Object)list)).append("Subscriber ");
        ((StringBuilder)((Object)list)).append(clazz);
        ((StringBuilder)((Object)list)).append(" and its super classes have no public methods with the @Subscribe annotation");
        throw new EventBusException(((StringBuilder)((Object)list)).toString());
    }
}
