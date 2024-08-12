/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.concurrent.futures.AbstractResolvableFuture
 *  androidx.concurrent.futures.AbstractResolvableFuture$Listener
 *  androidx.concurrent.futures.AbstractResolvableFuture$Waiter
 */
package androidx.concurrent.futures;

import androidx.concurrent.futures.AbstractResolvableFuture;

private static abstract class AbstractResolvableFuture.AtomicHelper {
    private AbstractResolvableFuture.AtomicHelper() {
    }

    abstract boolean casListeners(AbstractResolvableFuture<?> var1, AbstractResolvableFuture.Listener var2, AbstractResolvableFuture.Listener var3);

    abstract boolean casValue(AbstractResolvableFuture<?> var1, Object var2, Object var3);

    abstract boolean casWaiters(AbstractResolvableFuture<?> var1, AbstractResolvableFuture.Waiter var2, AbstractResolvableFuture.Waiter var3);

    abstract void putNext(AbstractResolvableFuture.Waiter var1, AbstractResolvableFuture.Waiter var2);

    abstract void putThread(AbstractResolvableFuture.Waiter var1, Thread var2);
}
