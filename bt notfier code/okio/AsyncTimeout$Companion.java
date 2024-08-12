/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  okio.AsyncTimeout
 *  okio.AsyncTimeout$Watchdog
 */
package okio;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okio.AsyncTimeout;

/*
 * Exception performing whole class analysis ignored.
 */
@Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000f\u0010\n\u001a\u0004\u0018\u00010\tH\u0000\u00a2\u0006\u0002\b\u000bJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\tH\u0002J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\rH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2={"Lokio/AsyncTimeout$Companion;", "", "()V", "IDLE_TIMEOUT_MILLIS", "", "IDLE_TIMEOUT_NANOS", "TIMEOUT_WRITE_SIZE", "", "head", "Lokio/AsyncTimeout;", "awaitTimeout", "awaitTimeout$okio", "cancelScheduledTimeout", "", "node", "scheduleTimeout", "", "timeoutNanos", "hasDeadline", "okio"}, k=1, mv={1, 5, 1}, xi=48)
public static final class AsyncTimeout.Companion {
    private AsyncTimeout.Companion() {
    }

    public /* synthetic */ AsyncTimeout.Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public static final /* synthetic */ boolean access$cancelScheduledTimeout(AsyncTimeout.Companion companion, AsyncTimeout asyncTimeout) {
        return companion.cancelScheduledTimeout(asyncTimeout);
    }

    public static final /* synthetic */ void access$scheduleTimeout(AsyncTimeout.Companion companion, AsyncTimeout asyncTimeout, long l, boolean bl) {
        companion.scheduleTimeout(asyncTimeout, l, bl);
    }

    /*
     * Enabled force condition propagation
     */
    private final boolean cancelScheduledTimeout(AsyncTimeout asyncTimeout) {
        synchronized (AsyncTimeout.class) {
            boolean bl = AsyncTimeout.access$getInQueue$p((AsyncTimeout)asyncTimeout);
            if (!bl) {
                return false;
            }
            AsyncTimeout.access$setInQueue$p((AsyncTimeout)asyncTimeout, (boolean)false);
            AsyncTimeout asyncTimeout2 = AsyncTimeout.access$getHead$cp();
            while (asyncTimeout2 != null) {
                if (AsyncTimeout.access$getNext$p((AsyncTimeout)asyncTimeout2) == asyncTimeout) {
                    AsyncTimeout.access$setNext$p((AsyncTimeout)asyncTimeout2, (AsyncTimeout)AsyncTimeout.access$getNext$p((AsyncTimeout)asyncTimeout));
                    AsyncTimeout.access$setNext$p((AsyncTimeout)asyncTimeout, null);
                    return false;
                }
                asyncTimeout2 = AsyncTimeout.access$getNext$p((AsyncTimeout)asyncTimeout2);
            }
            return true;
        }
    }

    /*
     * WARNING - void declaration
     * Enabled unnecessary exception pruning
     */
    private final void scheduleTimeout(AsyncTimeout object, long l, boolean bl) {
        synchronized (AsyncTimeout.class) {
            block11: {
                block15: {
                    long l2;
                    long l3;
                    AsyncTimeout.Companion companion;
                    block13: {
                        void var4_7;
                        block14: {
                            block12: {
                                if (!(AsyncTimeout.access$getInQueue$p((AsyncTimeout)object) ^ true)) break block11;
                                AsyncTimeout.access$setInQueue$p((AsyncTimeout)object, (boolean)true);
                                if (AsyncTimeout.access$getHead$cp() == null) {
                                    companion = AsyncTimeout.Companion;
                                    companion = new AsyncTimeout();
                                    AsyncTimeout.access$setHead$cp((AsyncTimeout)companion);
                                    companion = new AsyncTimeout.Watchdog();
                                    companion.start();
                                }
                                l3 = System.nanoTime();
                                if (l2 == 0L || var4_7 == false) break block12;
                                AsyncTimeout.access$setTimeoutAt$p((AsyncTimeout)object, (long)(Math.min(l2, object.deadlineNanoTime() - l3) + l3));
                                break block13;
                            }
                            if (l2 == 0L) break block14;
                            AsyncTimeout.access$setTimeoutAt$p((AsyncTimeout)object, (long)(l2 + l3));
                            break block13;
                        }
                        if (var4_7 == false) break block15;
                        AsyncTimeout.access$setTimeoutAt$p((AsyncTimeout)object, (long)object.deadlineNanoTime());
                    }
                    l2 = AsyncTimeout.access$remainingNanos((AsyncTimeout)object, (long)l3);
                    companion = AsyncTimeout.access$getHead$cp();
                    Intrinsics.checkNotNull((Object)companion);
                    while (AsyncTimeout.access$getNext$p((AsyncTimeout)companion) != null) {
                        AsyncTimeout asyncTimeout = AsyncTimeout.access$getNext$p((AsyncTimeout)companion);
                        Intrinsics.checkNotNull((Object)asyncTimeout);
                        if (l2 < AsyncTimeout.access$remainingNanos((AsyncTimeout)asyncTimeout, (long)l3)) break;
                        companion = AsyncTimeout.access$getNext$p((AsyncTimeout)companion);
                        Intrinsics.checkNotNull((Object)companion);
                    }
                    AsyncTimeout.access$setNext$p((AsyncTimeout)object, (AsyncTimeout)AsyncTimeout.access$getNext$p((AsyncTimeout)companion));
                    AsyncTimeout.access$setNext$p((AsyncTimeout)companion, (AsyncTimeout)object);
                    if (companion == AsyncTimeout.access$getHead$cp()) {
                        ((Object)AsyncTimeout.class).notify();
                    }
                    Unit unit = Unit.INSTANCE;
                    return;
                }
                AssertionError assertionError = new AssertionError();
                throw assertionError;
            }
            IllegalStateException illegalStateException = new IllegalStateException("Unbalanced enter/exit".toString());
            throw (Throwable)illegalStateException;
        }
    }

    public final AsyncTimeout awaitTimeout$okio() throws InterruptedException {
        AsyncTimeout asyncTimeout = AsyncTimeout.access$getHead$cp();
        Intrinsics.checkNotNull((Object)asyncTimeout);
        AsyncTimeout asyncTimeout2 = AsyncTimeout.access$getNext$p((AsyncTimeout)asyncTimeout);
        if (asyncTimeout2 == null) {
            long l = System.nanoTime();
            ((Object)AsyncTimeout.class).wait(AsyncTimeout.access$getIDLE_TIMEOUT_MILLIS$cp());
            asyncTimeout = AsyncTimeout.access$getHead$cp();
            Intrinsics.checkNotNull((Object)asyncTimeout);
            asyncTimeout = AsyncTimeout.access$getNext$p((AsyncTimeout)asyncTimeout) == null && System.nanoTime() - l >= AsyncTimeout.access$getIDLE_TIMEOUT_NANOS$cp() ? AsyncTimeout.access$getHead$cp() : (AsyncTimeout)null;
            return asyncTimeout;
        }
        long l = AsyncTimeout.access$remainingNanos((AsyncTimeout)asyncTimeout2, (long)System.nanoTime());
        if (l > 0L) {
            long l2 = l / 1000000L;
            ((Object)AsyncTimeout.class).wait(l2, (int)(l - 1000000L * l2));
            return null;
        }
        asyncTimeout = AsyncTimeout.access$getHead$cp();
        Intrinsics.checkNotNull((Object)asyncTimeout);
        AsyncTimeout.access$setNext$p((AsyncTimeout)asyncTimeout, (AsyncTimeout)AsyncTimeout.access$getNext$p((AsyncTimeout)asyncTimeout2));
        AsyncTimeout.access$setNext$p((AsyncTimeout)asyncTimeout2, null);
        return asyncTimeout2;
    }
}
