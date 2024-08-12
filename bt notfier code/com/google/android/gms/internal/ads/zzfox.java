/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.internal.ads;

import java.util.Iterator;
import javax.annotation.CheckForNull;

public final class zzfox {
    @CheckForNull
    static <T> T zza(Iterator<T> iterator) {
        if (!iterator.hasNext()) return null;
        T t = iterator.next();
        iterator.remove();
        return t;
    }

    static void zzb(Iterator<?> iterator) {
        if (iterator == null) throw null;
        while (iterator.hasNext()) {
            iterator.next();
            iterator.remove();
        }
    }
}
