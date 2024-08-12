/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.greenrobot.eventbus.SubscriberMethod
 *  org.greenrobot.eventbus.meta.SubscriberInfo
 */
package org.greenrobot.eventbus;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.greenrobot.eventbus.SubscriberMethod;
import org.greenrobot.eventbus.meta.SubscriberInfo;

static class SubscriberMethodFinder.FindState {
    final Map<Class, Object> anyMethodByEventType;
    Class<?> clazz;
    final StringBuilder methodKeyBuilder;
    boolean skipSuperClasses;
    Class<?> subscriberClass;
    final Map<String, Class> subscriberClassByMethodKey;
    SubscriberInfo subscriberInfo;
    final List<SubscriberMethod> subscriberMethods = new ArrayList<SubscriberMethod>();

    SubscriberMethodFinder.FindState() {
        this.anyMethodByEventType = new HashMap<Class, Object>();
        this.subscriberClassByMethodKey = new HashMap<String, Class>();
        this.methodKeyBuilder = new StringBuilder(128);
    }

    private boolean checkAddWithMethodSignature(Method genericDeclaration, Class<?> object) {
        this.methodKeyBuilder.setLength(0);
        this.methodKeyBuilder.append(genericDeclaration.getName());
        Serializable serializable = this.methodKeyBuilder;
        ((StringBuilder)serializable).append('>');
        ((StringBuilder)serializable).append(((Class)object).getName());
        object = this.methodKeyBuilder.toString();
        genericDeclaration = genericDeclaration.getDeclaringClass();
        serializable = this.subscriberClassByMethodKey.put((String)object, (Class)genericDeclaration);
        if (serializable == null) return true;
        if (((Class)serializable).isAssignableFrom((Class<?>)genericDeclaration)) {
            return true;
        }
        this.subscriberClassByMethodKey.put((String)object, (Class)serializable);
        return false;
    }

    boolean checkAdd(Method method, Class<?> clazz) {
        Object object = this.anyMethodByEventType.put(clazz, method);
        if (object == null) {
            return true;
        }
        if (!(object instanceof Method)) return this.checkAddWithMethodSignature(method, clazz);
        if (!this.checkAddWithMethodSignature((Method)object, clazz)) throw new IllegalStateException();
        this.anyMethodByEventType.put(clazz, this);
        return this.checkAddWithMethodSignature(method, clazz);
    }

    void initForSubscriber(Class<?> clazz) {
        this.clazz = clazz;
        this.subscriberClass = clazz;
        this.skipSuperClasses = false;
        this.subscriberInfo = null;
    }

    void moveToSuperclass() {
        if (this.skipSuperClasses) {
            this.clazz = null;
        } else {
            Object object = this.clazz.getSuperclass();
            this.clazz = object;
            if (!((String)(object = ((Class)object).getName())).startsWith("java.") && !((String)object).startsWith("javax.")) {
                if (!((String)object).startsWith("android.")) return;
            }
            this.clazz = null;
        }
    }

    void recycle() {
        this.subscriberMethods.clear();
        this.anyMethodByEventType.clear();
        this.subscriberClassByMethodKey.clear();
        this.methodKeyBuilder.setLength(0);
        this.subscriberClass = null;
        this.clazz = null;
        this.skipSuperClasses = false;
        this.subscriberInfo = null;
    }
}
