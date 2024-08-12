/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.InlineMarker
 *  kotlin.jvm.internal.Intrinsics
 *  okio.AsyncTimeout$Companion
 *  okio.Sink
 *  okio.Source
 *  okio.Timeout
 */
package okio;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import okio.AsyncTimeout;
import okio.Sink;
import okio.Source;
import okio.Timeout;

/*
 * Exception performing whole class analysis ignored.
 */
@Metadata(d1={"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u0000 \u001b2\u00020\u0001:\u0002\u001b\u001cB\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0001J\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\r\u001a\u00020\u0004J\u0012\u0010\u000e\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0014J\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0007H\u0002J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0014J\b\u0010\u0015\u001a\u00020\fH\u0014J%\u0010\u0016\u001a\u0002H\u0017\"\u0004\b\u0000\u0010\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00170\u0019H\u0086\b\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001aR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0000X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006\u001d"}, d2={"Lokio/AsyncTimeout;", "Lokio/Timeout;", "()V", "inQueue", "", "next", "timeoutAt", "", "access$newTimeoutException", "Ljava/io/IOException;", "cause", "enter", "", "exit", "newTimeoutException", "remainingNanos", "now", "sink", "Lokio/Sink;", "source", "Lokio/Source;", "timedOut", "withTimeout", "T", "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "Companion", "Watchdog", "okio"}, k=1, mv={1, 5, 1}, xi=48)
public class AsyncTimeout
extends Timeout {
    public static final Companion Companion = new Companion(null);
    private static final long IDLE_TIMEOUT_MILLIS = TimeUnit.SECONDS.toMillis(60L);
    private static final long IDLE_TIMEOUT_NANOS = TimeUnit.MILLISECONDS.toNanos(IDLE_TIMEOUT_MILLIS);
    private static final int TIMEOUT_WRITE_SIZE = 65536;
    private static AsyncTimeout head;
    private boolean inQueue;
    private AsyncTimeout next;
    private long timeoutAt;

    public static final /* synthetic */ AsyncTimeout access$getHead$cp() {
        return head;
    }

    public static final /* synthetic */ long access$getIDLE_TIMEOUT_MILLIS$cp() {
        return IDLE_TIMEOUT_MILLIS;
    }

    public static final /* synthetic */ long access$getIDLE_TIMEOUT_NANOS$cp() {
        return IDLE_TIMEOUT_NANOS;
    }

    public static final /* synthetic */ boolean access$getInQueue$p(AsyncTimeout asyncTimeout) {
        return asyncTimeout.inQueue;
    }

    public static final /* synthetic */ AsyncTimeout access$getNext$p(AsyncTimeout asyncTimeout) {
        return asyncTimeout.next;
    }

    public static final /* synthetic */ long access$remainingNanos(AsyncTimeout asyncTimeout, long l) {
        return asyncTimeout.remainingNanos(l);
    }

    public static final /* synthetic */ void access$setHead$cp(AsyncTimeout asyncTimeout) {
        head = asyncTimeout;
    }

    public static final /* synthetic */ void access$setInQueue$p(AsyncTimeout asyncTimeout, boolean bl) {
        asyncTimeout.inQueue = bl;
    }

    public static final /* synthetic */ void access$setNext$p(AsyncTimeout asyncTimeout, AsyncTimeout asyncTimeout2) {
        asyncTimeout.next = asyncTimeout2;
    }

    public static final /* synthetic */ void access$setTimeoutAt$p(AsyncTimeout asyncTimeout, long l) {
        asyncTimeout.timeoutAt = l;
    }

    private final long remainingNanos(long l) {
        return this.timeoutAt - l;
    }

    public final IOException access$newTimeoutException(IOException iOException) {
        return this.newTimeoutException(iOException);
    }

    public final void enter() {
        long l = this.timeoutNanos();
        boolean bl = this.hasDeadline();
        if (l == 0L && !bl) {
            return;
        }
        okio.AsyncTimeout$Companion.access$scheduleTimeout((Companion)Companion, (AsyncTimeout)this, (long)l, (boolean)bl);
    }

    public final boolean exit() {
        return okio.AsyncTimeout$Companion.access$cancelScheduledTimeout((Companion)Companion, (AsyncTimeout)this);
    }

    protected IOException newTimeoutException(IOException iOException) {
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException == null) return interruptedIOException;
        interruptedIOException.initCause(iOException);
        return interruptedIOException;
    }

    public final Sink sink(Sink sink2) {
        Intrinsics.checkNotNullParameter((Object)sink2, (String)"sink");
        return (Sink)new /* Unavailable Anonymous Inner Class!! */;
    }

    public final Source source(Source source2) {
        Intrinsics.checkNotNullParameter((Object)source2, (String)"source");
        return (Source)new /* Unavailable Anonymous Inner Class!! */;
    }

    protected void timedOut() {
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled unnecessary exception pruning
     */
    public final <T> T withTimeout(Function0<? extends T> object) {
        Throwable throwable2222222;
        block5: {
            Intrinsics.checkNotNullParameter(object, (String)"block");
            this.enter();
            object = object.invoke();
            {
                catch (Throwable throwable2222222) {
                    break block5;
                }
                catch (IOException iOException) {}
                {
                    Throwable throwable3;
                    if (this.exit()) {
                        throwable3 = this.access$newTimeoutException(iOException);
                    }
                    throwable3 = throwable3;
                    throw throwable3;
                }
            }
            InlineMarker.finallyStart((int)1);
            if (this.exit()) throw this.access$newTimeoutException(null);
            InlineMarker.finallyEnd((int)1);
            return (T)object;
        }
        InlineMarker.finallyStart((int)1);
        this.exit();
        InlineMarker.finallyEnd((int)1);
        throw throwable2222222;
    }
}
