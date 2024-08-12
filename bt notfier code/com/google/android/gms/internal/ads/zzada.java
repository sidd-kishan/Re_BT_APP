/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

public final class zzada<T> {
    private final Map<String, AtomicReference<T>> zza = new HashMap<String, AtomicReference<T>>();

    /*
     * Enabled unnecessary exception pruning
     */
    public final AtomicReference<T> zza(String string) {
        synchronized (this) {
            if (this.zza.containsKey(string)) return this.zza.get(string);
            AtomicReference atomicReference = new AtomicReference();
            this.zza.put(string, atomicReference);
            return this.zza.get(string);
        }
    }
}
