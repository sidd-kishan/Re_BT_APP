/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  com.google.android.gms.common.internal.Preconditions
 *  com.google.android.gms.dynamic.IObjectWrapper
 *  com.google.android.gms.dynamic.IObjectWrapper$Stub
 */
package com.google.android.gms.dynamic;

import android.os.IBinder;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;

public final class ObjectWrapper<T>
extends IObjectWrapper.Stub {
    private final T zza;

    private ObjectWrapper(T t) {
        this.zza = t;
    }

    public static <T> T unwrap(IObjectWrapper object) {
        if (object instanceof ObjectWrapper) {
            return ((ObjectWrapper)((Object)object)).zza;
        }
        IBinder iBinder = object.asBinder();
        Field[] fieldArray = iBinder.getClass().getDeclaredFields();
        int n = fieldArray.length;
        object = null;
        int n2 = 0;
        for (int i = 0; i < n; ++i) {
            Field field = fieldArray[i];
            int n3 = n2;
            if (!field.isSynthetic()) {
                n3 = n2 + 1;
                object = field;
            }
            n2 = n3;
        }
        if (n2 != 1) {
            n2 = fieldArray.length;
            object = new StringBuilder(64);
            ((StringBuilder)object).append("Unexpected number of IObjectWrapper declared fields: ");
            ((StringBuilder)object).append(n2);
            object = new IllegalArgumentException(((StringBuilder)object).toString());
            throw object;
        }
        Preconditions.checkNotNull((Object)object);
        if (((AccessibleObject)object).isAccessible()) throw new IllegalArgumentException("IObjectWrapper declared field not private!");
        ((AccessibleObject)object).setAccessible(true);
        try {
            object = ((Field)object).get(iBinder);
        }
        catch (IllegalAccessException illegalAccessException) {
            throw new IllegalArgumentException("Could not access the field in remoteBinder.", illegalAccessException);
        }
        catch (NullPointerException nullPointerException) {
            throw new IllegalArgumentException("Binder object is null.", nullPointerException);
        }
        return (T)object;
    }

    public static <T> IObjectWrapper wrap(T t) {
        return new ObjectWrapper<T>(t);
    }
}
