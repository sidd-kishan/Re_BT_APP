/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.greenrobot.eventbus.SubscriberMethod
 *  org.greenrobot.eventbus.meta.AbstractSubscriberInfo
 *  org.greenrobot.eventbus.meta.SubscriberMethodInfo
 */
package org.greenrobot.eventbus.meta;

import org.greenrobot.eventbus.SubscriberMethod;
import org.greenrobot.eventbus.meta.AbstractSubscriberInfo;
import org.greenrobot.eventbus.meta.SubscriberMethodInfo;

public class SimpleSubscriberInfo
extends AbstractSubscriberInfo {
    private final SubscriberMethodInfo[] methodInfos;

    public SimpleSubscriberInfo(Class clazz, boolean bl, SubscriberMethodInfo[] subscriberMethodInfoArray) {
        super(clazz, null, bl);
        this.methodInfos = subscriberMethodInfoArray;
    }

    public SubscriberMethod[] getSubscriberMethods() {
        synchronized (this) {
            try {
                int n = this.methodInfos.length;
                SubscriberMethod[] subscriberMethodArray = new SubscriberMethod[n];
                int n2 = 0;
                while (n2 < n) {
                    SubscriberMethodInfo subscriberMethodInfo = this.methodInfos[n2];
                    subscriberMethodArray[n2] = this.createSubscriberMethod(subscriberMethodInfo.methodName, subscriberMethodInfo.eventType, subscriberMethodInfo.threadMode, subscriberMethodInfo.priority, subscriberMethodInfo.sticky);
                    ++n2;
                }
                return subscriberMethodArray;
            }
            catch (Throwable throwable) {
                throw throwable;
            }
        }
    }
}
