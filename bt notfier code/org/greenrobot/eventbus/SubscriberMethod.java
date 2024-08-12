/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.greenrobot.eventbus.ThreadMode
 */
package org.greenrobot.eventbus;

import java.lang.reflect.Method;
import org.greenrobot.eventbus.ThreadMode;

public class SubscriberMethod {
    final Class<?> eventType;
    final Method method;
    String methodString;
    final int priority;
    final boolean sticky;
    final ThreadMode threadMode;

    public SubscriberMethod(Method method, Class<?> clazz, ThreadMode threadMode, int n, boolean bl) {
        this.method = method;
        this.threadMode = threadMode;
        this.eventType = clazz;
        this.priority = n;
        this.sticky = bl;
    }

    private void checkMethodString() {
        synchronized (this) {
            if (this.methodString != null) return;
            StringBuilder stringBuilder = new StringBuilder(64);
            stringBuilder.append(this.method.getDeclaringClass().getName());
            stringBuilder.append('#');
            stringBuilder.append(this.method.getName());
            stringBuilder.append('(');
            stringBuilder.append(this.eventType.getName());
            this.methodString = stringBuilder.toString();
            return;
        }
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof SubscriberMethod)) return false;
        this.checkMethodString();
        object = (SubscriberMethod)object;
        super.checkMethodString();
        return this.methodString.equals(((SubscriberMethod)object).methodString);
    }

    public int hashCode() {
        return this.method.hashCode();
    }
}
