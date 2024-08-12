/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.internal.ads;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public final class zzftd {
    public static <V> V zza(Future<V> future) throws ExecutionException {
        V v;
        boolean bl = false;
        while (true) {
            try {
                v = future.get();
                if (!bl) return v;
                Thread.currentThread().interrupt();
            }
            catch (Throwable throwable) {
                if (!bl) throw throwable;
                Thread.currentThread().interrupt();
                throw throwable;
            }
            catch (InterruptedException interruptedException) {
                bl = true;
                continue;
            }
            break;
        }
        return v;
    }
}
