/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.greenrobot.eventbus.SubscriberMethod
 */
package org.greenrobot.eventbus.meta;

import org.greenrobot.eventbus.SubscriberMethod;

public interface SubscriberInfo {
    public Class<?> getSubscriberClass();

    public SubscriberMethod[] getSubscriberMethods();

    public SubscriberInfo getSuperSubscriberInfo();

    public boolean shouldCheckSuperclass();
}
