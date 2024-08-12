/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.lifecycle.ClassesInfoCache$CallbackInfo
 *  androidx.lifecycle.ClassesInfoCache$MethodReference
 *  androidx.lifecycle.Lifecycle$Event
 *  androidx.lifecycle.LifecycleOwner
 *  androidx.lifecycle.OnLifecycleEvent
 */
package androidx.lifecycle;

import androidx.lifecycle.ClassesInfoCache;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

final class ClassesInfoCache {
    private static final int CALL_TYPE_NO_ARG = 0;
    private static final int CALL_TYPE_PROVIDER = 1;
    private static final int CALL_TYPE_PROVIDER_WITH_EVENT = 2;
    static ClassesInfoCache sInstance = new ClassesInfoCache();
    private final Map<Class<?>, CallbackInfo> mCallbackMap = new HashMap();
    private final Map<Class<?>, Boolean> mHasLifecycleMethods = new HashMap();

    ClassesInfoCache() {
    }

    private CallbackInfo createInfo(Class<?> clazz, Method[] callbackInfo) {
        int n;
        Object object = clazz.getSuperclass();
        HashMap<MethodReference, Lifecycle.Event> hashMap = new HashMap<MethodReference, Lifecycle.Event>();
        if (object != null && (object = this.getInfo((Class<?>)object)) != null) {
            hashMap.putAll(((CallbackInfo)object).mHandlerToEvent);
        }
        object = clazz.getInterfaces();
        int n2 = ((CallbackInfo)object).length;
        for (n = 0; n < n2; ++n) {
            for (Map.Entry classArray : this.getInfo(object[n]).mHandlerToEvent.entrySet()) {
                this.verifyAndPutHandler(hashMap, (MethodReference)classArray.getKey(), (Lifecycle.Event)classArray.getValue(), clazz);
            }
        }
        if (callbackInfo == null) {
            callbackInfo = this.getDeclaredMethods(clazz);
        }
        int n3 = ((CallbackInfo)callbackInfo).length;
        n2 = 0;
        boolean bl = false;
        while (true) {
            if (n2 >= n3) {
                callbackInfo = new CallbackInfo(hashMap);
                this.mCallbackMap.put(clazz, callbackInfo);
                this.mHasLifecycleMethods.put(clazz, bl);
                return callbackInfo;
            }
            object = callbackInfo[n2];
            OnLifecycleEvent onLifecycleEvent = ((Method)object).getAnnotation(OnLifecycleEvent.class);
            if (onLifecycleEvent != null) {
                Class<?>[] classArray = ((Method)object).getParameterTypes();
                if (classArray.length > 0) {
                    if (!classArray[0].isAssignableFrom(LifecycleOwner.class)) throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
                    n = 1;
                } else {
                    n = 0;
                }
                onLifecycleEvent = onLifecycleEvent.value();
                if (classArray.length > 1) {
                    if (!classArray[1].isAssignableFrom(Lifecycle.Event.class)) throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
                    if (onLifecycleEvent != Lifecycle.Event.ON_ANY) throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
                    n = 2;
                }
                if (classArray.length > 2) throw new IllegalArgumentException("cannot have more than 2 params");
                this.verifyAndPutHandler(hashMap, new MethodReference(n, (Method)object), (Lifecycle.Event)onLifecycleEvent, clazz);
                bl = true;
            }
            ++n2;
        }
    }

    private Method[] getDeclaredMethods(Class<?> methodArray) {
        try {
            methodArray = methodArray.getDeclaredMethods();
            return methodArray;
        }
        catch (NoClassDefFoundError noClassDefFoundError) {
            throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", noClassDefFoundError);
        }
    }

    private void verifyAndPutHandler(Map<MethodReference, Lifecycle.Event> object, MethodReference object2, Lifecycle.Event event, Class<?> clazz) {
        Lifecycle.Event event2 = object.get(object2);
        if (event2 != null && event != event2) {
            object2 = ((MethodReference)object2).mMethod;
            object = new StringBuilder();
            ((StringBuilder)object).append("Method ");
            ((StringBuilder)object).append(((Method)object2).getName());
            ((StringBuilder)object).append(" in ");
            ((StringBuilder)object).append(clazz.getName());
            ((StringBuilder)object).append(" already declared with different @OnLifecycleEvent value: previous value ");
            ((StringBuilder)object).append(event2);
            ((StringBuilder)object).append(", new value ");
            ((StringBuilder)object).append(event);
            throw new IllegalArgumentException(((StringBuilder)object).toString());
        }
        if (event2 != null) return;
        object.put((MethodReference)object2, (Lifecycle.Event)event);
    }

    CallbackInfo getInfo(Class<?> clazz) {
        CallbackInfo callbackInfo = this.mCallbackMap.get(clazz);
        if (callbackInfo == null) return this.createInfo(clazz, null);
        return callbackInfo;
    }

    boolean hasLifecycleMethods(Class<?> clazz) {
        Method[] methodArray = this.mHasLifecycleMethods.get(clazz);
        if (methodArray != null) {
            return methodArray.booleanValue();
        }
        methodArray = this.getDeclaredMethods(clazz);
        int n = methodArray.length;
        int n2 = 0;
        while (true) {
            if (n2 >= n) {
                this.mHasLifecycleMethods.put(clazz, false);
                return false;
            }
            if (methodArray[n2].getAnnotation(OnLifecycleEvent.class) != null) {
                this.createInfo(clazz, methodArray);
                return true;
            }
            ++n2;
        }
    }
}
