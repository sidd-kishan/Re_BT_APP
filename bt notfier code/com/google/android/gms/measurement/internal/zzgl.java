/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package com.google.android.gms.measurement.internal;

import android.os.Bundle;

public final class zzgl {
    public static void zza(Bundle bundle, Object object) {
        if (object instanceof Double) {
            bundle.putDouble("value", ((Double)object).doubleValue());
            return;
        }
        if (object instanceof Long) {
            bundle.putLong("value", ((Long)object).longValue());
            return;
        }
        bundle.putString("value", object.toString());
    }

    public static <T> T zzb(Bundle object, String string, Class<T> clazz, T t) {
        if ((object = object.get(string)) == null) {
            return t;
        }
        if (!clazz.isAssignableFrom(object.getClass())) throw new IllegalStateException(String.format("Invalid conditional user property field type. '%s' expected [%s] but was [%s]", string, clazz.getCanonicalName(), object.getClass().getCanonicalName()));
        return (T)object;
    }
}
