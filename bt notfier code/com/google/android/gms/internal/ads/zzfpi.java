/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.internal.ads;

import java.util.Map;
import javax.annotation.CheckForNull;

public final class zzfpi {
    @CheckForNull
    static <V> V zza(Map<?, V> map, @CheckForNull Object object) {
        if (map == null) throw null;
        try {
            map = map.get(object);
        }
        catch (ClassCastException | NullPointerException runtimeException) {
            return null;
        }
        return (V)map;
    }
}
