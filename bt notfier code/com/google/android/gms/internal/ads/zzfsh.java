/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzflx
 *  com.google.android.gms.internal.ads.zzfsm
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzflx;
import com.google.android.gms.internal.ads.zzfsm;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

final class zzfsh<V>
implements zzfsm<V> {
    static final zzfsm<?> zza = new zzfsh<Object>(null);
    private static final Logger zzb = Logger.getLogger(zzfsh.class.getName());
    private final V zzc;

    zzfsh(V v) {
        this.zzc = v;
    }

    public final boolean cancel(boolean bl) {
        return false;
    }

    public final V get() {
        return this.zzc;
    }

    public final V get(long l, TimeUnit timeUnit) throws ExecutionException {
        if (timeUnit == null) throw null;
        return this.zzc;
    }

    public final boolean isCancelled() {
        return false;
    }

    public final boolean isDone() {
        return true;
    }

    public final String toString() {
        String string = super.toString();
        String string2 = String.valueOf(this.zzc);
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(string).length() + 27 + String.valueOf(string2).length());
        stringBuilder.append(string);
        stringBuilder.append("[status=SUCCESS, result=[");
        stringBuilder.append(string2);
        stringBuilder.append("]]");
        return stringBuilder.toString();
    }

    public final void zze(Runnable object, Executor object2) {
        zzflx.zzc((Object)object, (Object)"Runnable was null.");
        zzflx.zzc((Object)object2, (Object)"Executor was null.");
        try {
            object2.execute((Runnable)object);
            return;
        }
        catch (RuntimeException runtimeException) {
            Logger logger = zzb;
            Level level = Level.SEVERE;
            object = String.valueOf(object);
            String string = String.valueOf(object2);
            object2 = new StringBuilder(String.valueOf(object).length() + 57 + String.valueOf(string).length());
            ((StringBuilder)object2).append("RuntimeException while executing runnable ");
            ((StringBuilder)object2).append((String)object);
            ((StringBuilder)object2).append(" with executor ");
            ((StringBuilder)object2).append(string);
            logger.logp(level, "com.google.common.util.concurrent.ImmediateFuture", "addListener", ((StringBuilder)object2).toString(), runtimeException);
            return;
        }
    }
}
