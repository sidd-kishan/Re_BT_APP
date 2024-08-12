/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.work.impl.utils.futures.AbstractFuture
 *  androidx.work.impl.utils.futures.AbstractFuture$Listener
 *  androidx.work.impl.utils.futures.AbstractFuture$Waiter
 */
package androidx.work.impl.utils.futures;

import androidx.work.impl.utils.futures.AbstractFuture;

private static abstract class AbstractFuture.AtomicHelper {
    private AbstractFuture.AtomicHelper() {
    }

    abstract boolean casListeners(AbstractFuture<?> var1, AbstractFuture.Listener var2, AbstractFuture.Listener var3);

    abstract boolean casValue(AbstractFuture<?> var1, Object var2, Object var3);

    abstract boolean casWaiters(AbstractFuture<?> var1, AbstractFuture.Waiter var2, AbstractFuture.Waiter var3);

    abstract void putNext(AbstractFuture.Waiter var1, AbstractFuture.Waiter var2);

    abstract void putThread(AbstractFuture.Waiter var1, Thread var2);
}
