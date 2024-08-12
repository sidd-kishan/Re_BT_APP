/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.greenrobot.eventbus.ThreadMode
 */
package org.greenrobot.eventbus.meta;

import org.greenrobot.eventbus.ThreadMode;

public class SubscriberMethodInfo {
    final Class<?> eventType;
    final String methodName;
    final int priority;
    final boolean sticky;
    final ThreadMode threadMode;

    public SubscriberMethodInfo(String string, Class<?> clazz) {
        this(string, clazz, ThreadMode.POSTING, 0, false);
    }

    public SubscriberMethodInfo(String string, Class<?> clazz, ThreadMode threadMode) {
        this(string, clazz, threadMode, 0, false);
    }

    public SubscriberMethodInfo(String string, Class<?> clazz, ThreadMode threadMode, int n, boolean bl) {
        this.methodName = string;
        this.threadMode = threadMode;
        this.eventType = clazz;
        this.priority = n;
        this.sticky = bl;
    }
}
