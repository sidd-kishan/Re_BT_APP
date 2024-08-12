/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.work.impl.utils.futures.AbstractFuture$AtomicHelper
 *  androidx.work.impl.utils.futures.AbstractFuture$Cancellation
 *  androidx.work.impl.utils.futures.AbstractFuture$Failure
 *  androidx.work.impl.utils.futures.AbstractFuture$Listener
 *  androidx.work.impl.utils.futures.AbstractFuture$SafeAtomicHelper
 *  androidx.work.impl.utils.futures.AbstractFuture$SetFuture
 *  androidx.work.impl.utils.futures.AbstractFuture$SynchronizedHelper
 *  androidx.work.impl.utils.futures.AbstractFuture$Waiter
 *  androidx.work.impl.utils.futures.DirectExecutor
 */
package androidx.work.impl.utils.futures;

import androidx.work.impl.utils.futures.AbstractFuture;
import androidx.work.impl.utils.futures.DirectExecutor;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class AbstractFuture<V>
implements ListenableFuture<V> {
    static final AtomicHelper ATOMIC_HELPER;
    static final boolean GENERATE_CANCELLATION_CAUSES;
    private static final Object NULL;
    private static final long SPIN_THRESHOLD_NANOS = 1000L;
    private static final Logger log;
    volatile Listener listeners;
    volatile Object value;
    volatile Waiter waiters;

    static {
        Object var0_1;
        SafeAtomicHelper safeAtomicHelper;
        GENERATE_CANCELLATION_CAUSES = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));
        log = Logger.getLogger(AbstractFuture.class.getName());
        try {
            safeAtomicHelper = new SafeAtomicHelper(AtomicReferenceFieldUpdater.newUpdater(Waiter.class, Thread.class, "thread"), AtomicReferenceFieldUpdater.newUpdater(Waiter.class, Waiter.class, "next"), AtomicReferenceFieldUpdater.newUpdater(AbstractFuture.class, Waiter.class, "waiters"), AtomicReferenceFieldUpdater.newUpdater(AbstractFuture.class, Listener.class, "listeners"), AtomicReferenceFieldUpdater.newUpdater(AbstractFuture.class, Object.class, "value"));
            var0_1 = null;
        }
        catch (Throwable throwable) {
            safeAtomicHelper = new SynchronizedHelper();
        }
        ATOMIC_HELPER = safeAtomicHelper;
        if (var0_1 != null) {
            log.log(Level.SEVERE, "SafeAtomicHelper is broken!", (Throwable)var0_1);
        }
        NULL = new Object();
    }

    protected AbstractFuture() {
    }

    private void addDoneString(StringBuilder stringBuilder) {
        try {
            V v = AbstractFuture.getUninterruptibly(this);
            stringBuilder.append("SUCCESS, result=[");
            stringBuilder.append(this.userObjectToString(v));
            stringBuilder.append("]");
        }
        catch (RuntimeException runtimeException) {
            stringBuilder.append("UNKNOWN, cause=[");
            stringBuilder.append(runtimeException.getClass());
            stringBuilder.append(" thrown from get()]");
        }
        catch (CancellationException cancellationException) {
            stringBuilder.append("CANCELLED");
        }
        catch (ExecutionException executionException) {
            stringBuilder.append("FAILURE, cause=[");
            stringBuilder.append(executionException.getCause());
            stringBuilder.append("]");
        }
    }

    private static CancellationException cancellationExceptionWithCause(String object, Throwable throwable) {
        object = new CancellationException((String)object);
        ((Throwable)object).initCause(throwable);
        return object;
    }

    static <T> T checkNotNull(T t) {
        if (t == null) throw null;
        return t;
    }

    private Listener clearListeners(Listener listener) {
        Listener listener2;
        while (!ATOMIC_HELPER.casListeners(this, listener2 = this.listeners, Listener.TOMBSTONE)) {
        }
        Listener listener3 = listener;
        listener = listener2;
        while (listener != null) {
            listener2 = listener.next;
            listener.next = listener3;
            listener3 = listener;
            listener = listener2;
        }
        return listener3;
    }

    static void complete(AbstractFuture<?> object) {
        Object object2 = null;
        block0: while (true) {
            super.releaseWaiters();
            object.afterDone();
            object2 = super.clearListeners((Listener)object2);
            while (object2 != null) {
                object = object2.next;
                Object object3 = object2.task;
                if (object3 instanceof SetFuture) {
                    SetFuture setFuture = (SetFuture)object3;
                    object3 = setFuture.owner;
                    if (((AbstractFuture)object3).value == setFuture && ATOMIC_HELPER.casValue((AbstractFuture)object3, (Object)setFuture, object2 = AbstractFuture.getFutureValue(setFuture.future))) {
                        object2 = object;
                        object = object3;
                        continue block0;
                    }
                } else {
                    AbstractFuture.executeListener((Runnable)object3, object2.executor);
                }
                object2 = object;
            }
            return;
        }
    }

    private static void executeListener(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        }
        catch (RuntimeException runtimeException) {
            Logger logger = log;
            Level level = Level.SEVERE;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("RuntimeException while executing runnable ");
            stringBuilder.append(runnable);
            stringBuilder.append(" with executor ");
            stringBuilder.append(executor);
            logger.log(level, stringBuilder.toString(), runtimeException);
        }
    }

    private V getDoneValue(Object object) throws ExecutionException {
        if (object instanceof Cancellation) throw AbstractFuture.cancellationExceptionWithCause("Task was cancelled.", ((Cancellation)object).cause);
        if (object instanceof Failure) throw new ExecutionException(((Failure)object).exception);
        Object object2 = object;
        if (object != NULL) return (V)object2;
        object2 = null;
        return (V)object2;
    }

    static Object getFutureValue(ListenableFuture<?> object) {
        if (object instanceof AbstractFuture) {
            Object object2;
            object = object2 = ((AbstractFuture)object).value;
            if (!(object2 instanceof Cancellation)) return object;
            Cancellation cancellation = (Cancellation)object2;
            object = object2;
            if (!cancellation.wasInterrupted) return object;
            object = cancellation.cause != null ? new Cancellation(false, cancellation.cause) : Cancellation.CAUSELESS_CANCELLED;
            return object;
        }
        boolean bl = object.isCancelled();
        if ((GENERATE_CANCELLATION_CAUSES ^ true) & bl) {
            return Cancellation.CAUSELESS_CANCELLED;
        }
        try {
            Object v;
            Object object3 = v = AbstractFuture.getUninterruptibly(object);
            if (v != null) return object3;
            object3 = NULL;
            return object3;
        }
        catch (Throwable throwable) {
            return new Failure(throwable);
        }
        catch (CancellationException cancellationException) {
            if (bl) return new Cancellation(false, (Throwable)cancellationException);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("get() threw CancellationException, despite reporting isCancelled() == false: ");
            stringBuilder.append(object);
            return new Failure((Throwable)new IllegalArgumentException(stringBuilder.toString(), cancellationException));
        }
        catch (ExecutionException executionException) {
            return new Failure(executionException.getCause());
        }
    }

    private static <V> V getUninterruptibly(Future<V> future) throws ExecutionException {
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

    private void releaseWaiters() {
        Waiter waiter;
        while (!ATOMIC_HELPER.casWaiters(this, waiter = this.waiters, Waiter.TOMBSTONE)) {
        }
        while (waiter != null) {
            waiter.unpark();
            waiter = waiter.next;
        }
    }

    /*
     * Unable to fully structure code
     */
    private void removeWaiter(Waiter var1_1) {
        var1_1.thread = null;
        block0: while (true) {
            if ((var1_1 = this.waiters) == Waiter.TOMBSTONE) {
                return;
            }
            var2_2 = null;
            while (var1_1 != null) {
                var4_4 = var1_1.next;
                if (var1_1.thread != null) {
                    var3_3 = var1_1;
                } else if (var2_2 != null) {
                    var2_2.next = var4_4;
                    var3_3 = var2_2;
                    if (var2_2.thread == null) {
                        continue block0;
                    }
                } else {
                    var3_3 = var2_2;
                    if (AbstractFuture.ATOMIC_HELPER.casWaiters(this, var1_1, var4_4)) ** break;
                    continue block0;
                }
                var1_1 = var4_4;
                var2_2 = var3_3;
            }
            return;
        }
    }

    private String userObjectToString(Object object) {
        if (object != this) return String.valueOf(object);
        return "this future";
    }

    @Override
    public final void addListener(Runnable runnable, Executor executor) {
        AbstractFuture.checkNotNull(runnable);
        AbstractFuture.checkNotNull(executor);
        Listener listener = this.listeners;
        if (listener != Listener.TOMBSTONE) {
            Listener listener2;
            Listener listener3 = new Listener(runnable, executor);
            do {
                listener3.next = listener;
                if (ATOMIC_HELPER.casListeners(this, listener, listener3)) {
                    return;
                }
                listener = listener2 = this.listeners;
            } while (listener2 != Listener.TOMBSTONE);
        }
        AbstractFuture.executeListener(runnable, executor);
    }

    protected void afterDone() {
    }

    @Override
    public final boolean cancel(boolean bl) {
        boolean bl2;
        Object object = this.value;
        boolean bl3 = true;
        boolean bl4 = object == null;
        if (!(bl4 | object instanceof SetFuture)) {
            bl2 = false;
        } else {
            Cancellation cancellation = GENERATE_CANCELLATION_CAUSES ? new Cancellation(bl, (Throwable)new CancellationException("Future.cancel() was called.")) : (bl ? Cancellation.CAUSELESS_INTERRUPTED : Cancellation.CAUSELESS_CANCELLED);
            bl2 = false;
            AbstractFuture abstractFuture = this;
            while (true) {
                Object object2;
                if (ATOMIC_HELPER.casValue(abstractFuture, object, (Object)cancellation)) {
                    if (bl) {
                        abstractFuture.interruptTask();
                    }
                    AbstractFuture.complete(abstractFuture);
                    bl2 = bl3;
                    if (!(object instanceof SetFuture)) return bl2;
                    object = ((SetFuture)object).future;
                    if (object instanceof AbstractFuture) {
                        abstractFuture = (AbstractFuture)object;
                        object = abstractFuture.value;
                        bl4 = object == null;
                        bl2 = bl3;
                        if (!(bl4 | object instanceof SetFuture)) return bl2;
                        bl2 = true;
                        continue;
                    }
                    object.cancel(bl);
                    bl2 = bl3;
                    break;
                }
                object = object2 = abstractFuture.value;
                if (!(object2 instanceof SetFuture)) return bl2;
            }
        }
        return bl2;
    }

    @Override
    public final V get() throws InterruptedException, ExecutionException {
        Waiter waiter;
        boolean bl;
        Object object;
        block4: {
            Waiter waiter2;
            if (Thread.interrupted()) {
                InterruptedException interruptedException = new InterruptedException();
                throw interruptedException;
            }
            object = this.value;
            bl = object != null;
            if (bl & (object instanceof SetFuture ^ true)) {
                return this.getDoneValue(object);
            }
            object = this.waiters;
            if (object == Waiter.TOMBSTONE) return this.getDoneValue(this.value);
            waiter = new Waiter();
            do {
                waiter.setNext((Waiter)object);
                if (ATOMIC_HELPER.casWaiters(this, (Waiter)object, waiter)) break block4;
                waiter2 = this.waiters;
                object = waiter2;
            } while (waiter2 != Waiter.TOMBSTONE);
            return this.getDoneValue(this.value);
        }
        do {
            LockSupport.park(this);
            if (!Thread.interrupted()) continue;
            this.removeWaiter(waiter);
            throw new InterruptedException();
        } while (!((bl = (object = this.value) != null) & (object instanceof SetFuture ^ true)));
        return this.getDoneValue(object);
    }

    @Override
    public final V get(long l, TimeUnit object) throws InterruptedException, TimeoutException, ExecutionException {
        Object object2;
        String string;
        long l2 = ((TimeUnit)((Object)object)).toNanos(l);
        if (Thread.interrupted()) {
            object = new InterruptedException();
            throw object;
        }
        Object object3 = this.value;
        boolean bl = object3 != null;
        if (bl & (object3 instanceof SetFuture ^ true)) {
            return this.getDoneValue(object3);
        }
        long l3 = l2 > 0L ? System.nanoTime() + l2 : 0L;
        long l4 = l2;
        if (l2 >= 1000L) {
            block14: {
                object3 = this.waiters;
                if (object3 == Waiter.TOMBSTONE) return this.getDoneValue(this.value);
                string = new Waiter();
                do {
                    string.setNext((Waiter)object3);
                    if (ATOMIC_HELPER.casWaiters(this, (Waiter)object3, (Waiter)string)) break block14;
                    object2 = this.waiters;
                    object3 = object2;
                } while (object2 != Waiter.TOMBSTONE);
                return this.getDoneValue(this.value);
            }
            do {
                LockSupport.parkNanos(this, l2);
                if (Thread.interrupted()) {
                    this.removeWaiter((Waiter)string);
                    throw new InterruptedException();
                }
                object3 = this.value;
                bl = object3 != null;
                if (bl & (object3 instanceof SetFuture ^ true)) {
                    return this.getDoneValue(object3);
                }
                l2 = l4 = l3 - System.nanoTime();
            } while (l4 >= 1000L);
            this.removeWaiter((Waiter)string);
        }
        while (l4 > 0L) {
            object3 = this.value;
            bl = object3 != null;
            if (bl & (object3 instanceof SetFuture ^ true)) {
                return this.getDoneValue(object3);
            }
            if (Thread.interrupted()) throw new InterruptedException();
            l4 = l3 - System.nanoTime();
        }
        string = this.toString();
        String string2 = ((Enum)object).toString().toLowerCase(Locale.ROOT);
        object3 = new StringBuilder();
        ((StringBuilder)object3).append("Waited ");
        ((StringBuilder)object3).append(l);
        ((StringBuilder)object3).append(" ");
        ((StringBuilder)object3).append(((Enum)object).toString().toLowerCase(Locale.ROOT));
        object2 = ((StringBuilder)object3).toString();
        object3 = object2;
        if (l4 + 1000L < 0L) {
            object3 = new StringBuilder();
            ((StringBuilder)object3).append((String)object2);
            ((StringBuilder)object3).append(" (plus ");
            object3 = ((StringBuilder)object3).toString();
            l4 = -l4;
            l = ((TimeUnit)((Object)object)).convert(l4, TimeUnit.NANOSECONDS);
            bl = l == 0L || (l4 -= ((TimeUnit)((Object)object)).toNanos(l)) > 1000L;
            object = object3;
            if (l > 0L) {
                object = new StringBuilder();
                ((StringBuilder)object).append((String)object3);
                ((StringBuilder)object).append(l);
                ((StringBuilder)object).append(" ");
                ((StringBuilder)object).append(string2);
                object = object3 = ((StringBuilder)object).toString();
                if (bl) {
                    object = new StringBuilder();
                    ((StringBuilder)object).append((String)object3);
                    ((StringBuilder)object).append(",");
                    object = ((StringBuilder)object).toString();
                }
                object3 = new StringBuilder();
                ((StringBuilder)object3).append((String)object);
                ((StringBuilder)object3).append(" ");
                object = ((StringBuilder)object3).toString();
            }
            object3 = object;
            if (bl) {
                object3 = new StringBuilder();
                ((StringBuilder)object3).append((String)object);
                ((StringBuilder)object3).append(l4);
                ((StringBuilder)object3).append(" nanoseconds ");
                object3 = ((StringBuilder)object3).toString();
            }
            object = new StringBuilder();
            ((StringBuilder)object).append((String)object3);
            ((StringBuilder)object).append("delay)");
            object3 = ((StringBuilder)object).toString();
        }
        if (this.isDone()) {
            object = new StringBuilder();
            ((StringBuilder)object).append((String)object3);
            ((StringBuilder)object).append(" but future completed as timeout expired");
            throw new TimeoutException(((StringBuilder)object).toString());
        }
        object = new StringBuilder();
        ((StringBuilder)object).append((String)object3);
        ((StringBuilder)object).append(" for ");
        ((StringBuilder)object).append(string);
        throw new TimeoutException(((StringBuilder)object).toString());
    }

    protected void interruptTask() {
    }

    @Override
    public final boolean isCancelled() {
        return this.value instanceof Cancellation;
    }

    @Override
    public final boolean isDone() {
        Object object = this.value;
        boolean bl = object != null;
        return (object instanceof SetFuture ^ true) & bl;
    }

    final void maybePropagateCancellationTo(Future<?> future) {
        boolean bl = future != null;
        if (!(bl & this.isCancelled())) return;
        future.cancel(this.wasInterrupted());
    }

    protected String pendingToString() {
        Object object = this.value;
        if (object instanceof SetFuture) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("setFuture=[");
            stringBuilder.append(this.userObjectToString(((SetFuture)object).future));
            stringBuilder.append("]");
            return stringBuilder.toString();
        }
        if (!(this instanceof ScheduledFuture)) return null;
        object = new StringBuilder();
        ((StringBuilder)object).append("remaining delay=[");
        ((StringBuilder)object).append(((ScheduledFuture)((Object)this)).getDelay(TimeUnit.MILLISECONDS));
        ((StringBuilder)object).append(" ms]");
        return ((StringBuilder)object).toString();
    }

    protected boolean set(V v) {
        Object object = v;
        if (v == null) {
            object = NULL;
        }
        if (!ATOMIC_HELPER.casValue(this, null, object)) return false;
        AbstractFuture.complete(this);
        return true;
    }

    protected boolean setException(Throwable throwable) {
        if (!ATOMIC_HELPER.casValue(this, null, (Object)(throwable = new Failure(AbstractFuture.checkNotNull(throwable))))) return false;
        AbstractFuture.complete(this);
        return true;
    }

    protected boolean setFuture(ListenableFuture<? extends V> object) {
        Object object2;
        AbstractFuture.checkNotNull(object);
        Object object3 = object2 = this.value;
        if (object2 == null) {
            if (object.isDone()) {
                if (!ATOMIC_HELPER.casValue(this, null, object = AbstractFuture.getFutureValue(object))) return false;
                AbstractFuture.complete(this);
                return true;
            }
            object3 = new SetFuture(this, (ListenableFuture)object);
            if (ATOMIC_HELPER.casValue(this, null, object3)) {
                try {
                    object.addListener((Runnable)object3, (Executor)DirectExecutor.INSTANCE);
                }
                catch (Throwable throwable) {
                    try {
                        object = new Failure(throwable);
                    }
                    catch (Throwable throwable2) {
                        object = Failure.FALLBACK_INSTANCE;
                    }
                    ATOMIC_HELPER.casValue(this, object3, object);
                }
                return true;
            }
            object3 = this.value;
        }
        if (!(object3 instanceof Cancellation)) return false;
        object.cancel(((Cancellation)object3).wasInterrupted);
        return false;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.toString());
        stringBuilder.append("[status=");
        if (this.isCancelled()) {
            stringBuilder.append("CANCELLED");
        } else if (this.isDone()) {
            this.addDoneString(stringBuilder);
        } else {
            CharSequence charSequence;
            try {
                charSequence = this.pendingToString();
            }
            catch (RuntimeException runtimeException) {
                charSequence = new StringBuilder();
                ((StringBuilder)charSequence).append("Exception thrown from implementation: ");
                ((StringBuilder)charSequence).append(runtimeException.getClass());
                charSequence = ((StringBuilder)charSequence).toString();
            }
            if (charSequence != null && !((String)charSequence).isEmpty()) {
                stringBuilder.append("PENDING, info=[");
                stringBuilder.append((String)charSequence);
                stringBuilder.append("]");
            } else if (this.isDone()) {
                this.addDoneString(stringBuilder);
            } else {
                stringBuilder.append("PENDING");
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    protected final boolean wasInterrupted() {
        Object object = this.value;
        boolean bl = object instanceof Cancellation && ((Cancellation)object).wasInterrupted;
        return bl;
    }
}
