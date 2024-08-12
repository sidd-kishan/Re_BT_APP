/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.greenrobot.eventbus.EventBusException
 *  org.greenrobot.eventbus.SubscriberMethod
 *  org.greenrobot.eventbus.ThreadMode
 *  org.greenrobot.eventbus.meta.SubscriberInfo
 */
package org.greenrobot.eventbus.meta;

import org.greenrobot.eventbus.EventBusException;
import org.greenrobot.eventbus.SubscriberMethod;
import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.eventbus.meta.SubscriberInfo;

public abstract class AbstractSubscriberInfo
implements SubscriberInfo {
    private final boolean shouldCheckSuperclass;
    private final Class subscriberClass;
    private final Class<? extends SubscriberInfo> superSubscriberInfoClass;

    protected AbstractSubscriberInfo(Class clazz, Class<? extends SubscriberInfo> clazz2, boolean bl) {
        this.subscriberClass = clazz;
        this.superSubscriberInfoClass = clazz2;
        this.shouldCheckSuperclass = bl;
    }

    protected SubscriberMethod createSubscriberMethod(String string, Class<?> clazz) {
        return this.createSubscriberMethod(string, clazz, ThreadMode.POSTING, 0, false);
    }

    protected SubscriberMethod createSubscriberMethod(String string, Class<?> clazz, ThreadMode threadMode) {
        return this.createSubscriberMethod(string, clazz, threadMode, 0, false);
    }

    protected SubscriberMethod createSubscriberMethod(String string, Class<?> serializable, ThreadMode threadMode, int n, boolean bl) {
        try {
            string = new SubscriberMethod(this.subscriberClass.getDeclaredMethod(string, new Class[]{serializable}), (Class)serializable, threadMode, n, bl);
            return string;
        }
        catch (NoSuchMethodException noSuchMethodException) {
            serializable = new StringBuilder();
            ((StringBuilder)serializable).append("Could not find subscriber method in ");
            ((StringBuilder)serializable).append(this.subscriberClass);
            ((StringBuilder)serializable).append(". Maybe a missing ProGuard rule?");
            throw new EventBusException(((StringBuilder)serializable).toString(), (Throwable)noSuchMethodException);
        }
    }

    public Class getSubscriberClass() {
        return this.subscriberClass;
    }

    public SubscriberInfo getSuperSubscriberInfo() {
        SubscriberInfo subscriberInfo = this.superSubscriberInfoClass;
        if (subscriberInfo == null) {
            return null;
        }
        try {
            subscriberInfo = subscriberInfo.newInstance();
            return subscriberInfo;
        }
        catch (IllegalAccessException illegalAccessException) {
            throw new RuntimeException(illegalAccessException);
        }
        catch (InstantiationException instantiationException) {
            throw new RuntimeException(instantiationException);
        }
    }

    public boolean shouldCheckSuperclass() {
        return this.shouldCheckSuperclass;
    }
}
