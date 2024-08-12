/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.internal.ads;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.security.PrivilegedExceptionAction;
import sun.misc.Unsafe;

class zzfqw.zzk.1
implements PrivilegedExceptionAction<Unsafe> {
    zzfqw.zzk.1() {
    }

    public static final Unsafe zza() throws Exception {
        Object object = Unsafe.class.getDeclaredFields();
        int n = ((Field[])object).length;
        int n2 = 0;
        while (true) {
            if (n2 >= n) {
                object = new NoSuchFieldError("the Unsafe");
                throw object;
            }
            Object object2 = object[n2];
            ((AccessibleObject)object2).setAccessible(true);
            object2 = ((Field)object2).get(null);
            if (Unsafe.class.isInstance(object2)) {
                return (Unsafe)Unsafe.class.cast(object2);
            }
            ++n2;
        }
    }
}
