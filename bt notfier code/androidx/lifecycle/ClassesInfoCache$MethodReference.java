/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.lifecycle.Lifecycle$Event
 *  androidx.lifecycle.LifecycleOwner
 */
package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

static final class ClassesInfoCache.MethodReference {
    final int mCallType;
    final Method mMethod;

    ClassesInfoCache.MethodReference(int n, Method method) {
        this.mCallType = n;
        this.mMethod = method;
        method.setAccessible(true);
    }

    public boolean equals(Object object) {
        boolean bl = true;
        if (this == object) {
            return true;
        }
        if (!(object instanceof ClassesInfoCache.MethodReference)) {
            return false;
        }
        object = (ClassesInfoCache.MethodReference)object;
        if (this.mCallType == ((ClassesInfoCache.MethodReference)object).mCallType && this.mMethod.getName().equals(((ClassesInfoCache.MethodReference)object).mMethod.getName())) return bl;
        bl = false;
        return bl;
    }

    public int hashCode() {
        return this.mCallType * 31 + this.mMethod.getName().hashCode();
    }

    void invokeCallback(LifecycleOwner lifecycleOwner, Lifecycle.Event event, Object object) {
        try {
            int n = this.mCallType;
            if (n != 0) {
                if (n != 1) {
                    if (n != 2) return;
                    this.mMethod.invoke(object, lifecycleOwner, event);
                } else {
                    this.mMethod.invoke(object, lifecycleOwner);
                }
            } else {
                this.mMethod.invoke(object, new Object[0]);
            }
            return;
        }
        catch (IllegalAccessException illegalAccessException) {
            throw new RuntimeException(illegalAccessException);
        }
        catch (InvocationTargetException invocationTargetException) {
            throw new RuntimeException("Failed to call observer method", invocationTargetException.getCause());
        }
    }
}
