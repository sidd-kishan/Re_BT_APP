/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.internal.measurement;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.security.PrivilegedExceptionAction;
import sun.misc.Unsafe;

final class zzkb
implements PrivilegedExceptionAction<Unsafe> {
    zzkb() {
    }

    public static final Unsafe zza() throws Exception {
        Field[] fieldArray = Unsafe.class.getDeclaredFields();
        int n = fieldArray.length;
        int n2 = 0;
        while (n2 < n) {
            Object object = fieldArray[n2];
            ((AccessibleObject)object).setAccessible(true);
            object = ((Field)object).get(null);
            if (Unsafe.class.isInstance(object)) {
                return (Unsafe)Unsafe.class.cast(object);
            }
            ++n2;
        }
        return null;
    }
}
