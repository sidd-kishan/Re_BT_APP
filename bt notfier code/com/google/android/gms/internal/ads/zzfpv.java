/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.internal.ads;

import javax.annotation.CheckForNull;

public final class zzfpv {
    static Object[] zza(Object[] objectArray, int n) {
        int n2 = 0;
        while (n2 < n) {
            zzfpv.zzb(objectArray[n2], n2);
            ++n2;
        }
        return objectArray;
    }

    static Object zzb(@CheckForNull Object object, int n) {
        if (object != null) {
            return object;
        }
        object = new StringBuilder(20);
        ((StringBuilder)object).append("at index ");
        ((StringBuilder)object).append(n);
        throw new NullPointerException(((StringBuilder)object).toString());
    }
}
