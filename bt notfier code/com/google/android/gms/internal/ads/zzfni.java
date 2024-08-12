/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.internal.ads;

final class zzfni {
    static void zza(Object object, Object object2) {
        if (object == null) {
            object = String.valueOf(object2);
            String.valueOf(object).length();
            throw new NullPointerException("null key in entry: null=".concat(String.valueOf(object)));
        }
        if (object2 != null) {
            return;
        }
        object = object.toString();
        object2 = new StringBuilder(((String)object).length() + 26);
        ((StringBuilder)object2).append("null value in entry: ");
        ((StringBuilder)object2).append((String)object);
        ((StringBuilder)object2).append("=null");
        throw new NullPointerException(((StringBuilder)object2).toString());
    }

    static int zzb(int n, String string) {
        if (n >= 0) {
            return n;
        }
        StringBuilder stringBuilder = new StringBuilder(string.length() + 40);
        stringBuilder.append(string);
        stringBuilder.append(" cannot be negative but was: ");
        stringBuilder.append(n);
        throw new IllegalArgumentException(stringBuilder.toString());
    }
}
