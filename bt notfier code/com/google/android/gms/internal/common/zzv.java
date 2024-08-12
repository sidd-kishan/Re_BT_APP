/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.internal.common;

public final class zzv {
    static Object[] zza(Object[] object, int n) {
        int n2 = 0;
        while (n2 < n) {
            if (object[n2] == null) {
                object = new StringBuilder(20);
                ((StringBuilder)object).append("at index ");
                ((StringBuilder)object).append(n2);
                throw new NullPointerException(((StringBuilder)object).toString());
            }
            ++n2;
        }
        return object;
    }
}
