/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.InlineMarker
 *  kotlin.jvm.internal.Intrinsics
 *  okio.Timeout$Companion
 */
package okio;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import okio.Timeout;

@Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\b\u001a\u00020\u0000H\u0016J\b\u0010\t\u001a\u00020\u0000H\u0016J\u0016\u0010\n\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rJ\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0010\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016J-\u0010\u000e\u001a\u0002H\u000f\"\u0004\b\u0000\u0010\u000f2\u0006\u0010\u0010\u001a\u00020\u00002\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u0012H\u0086\b\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0013J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u0018\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\u000e\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0001R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006\u001a"}, d2={"Lokio/Timeout;", "", "()V", "deadlineNanoTime", "", "hasDeadline", "", "timeoutNanos", "clearDeadline", "clearTimeout", "deadline", "duration", "unit", "Ljava/util/concurrent/TimeUnit;", "intersectWith", "T", "other", "block", "Lkotlin/Function0;", "(Lokio/Timeout;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "throwIfReached", "", "timeout", "waitUntilNotified", "monitor", "Companion", "okio"}, k=1, mv={1, 5, 1}, xi=48)
public class Timeout {
    public static final Companion Companion = new Companion(null);
    public static final Timeout NONE = (Timeout)new /* Unavailable Anonymous Inner Class!! */;
    private long deadlineNanoTime;
    private boolean hasDeadline;
    private long timeoutNanos;

    public Timeout clearDeadline() {
        this.hasDeadline = false;
        return this;
    }

    public Timeout clearTimeout() {
        this.timeoutNanos = 0L;
        return this;
    }

    public final Timeout deadline(long l, TimeUnit timeUnit) {
        Intrinsics.checkNotNullParameter((Object)((Object)timeUnit), (String)"unit");
        boolean bl = l > 0L;
        if (!bl) throw (Throwable)new IllegalArgumentException(Intrinsics.stringPlus((String)"duration <= 0: ", (Object)l).toString());
        return this.deadlineNanoTime(System.nanoTime() + timeUnit.toNanos(l));
    }

    public long deadlineNanoTime() {
        if (!this.hasDeadline) throw (Throwable)new IllegalStateException("No deadline".toString());
        return this.deadlineNanoTime;
    }

    public Timeout deadlineNanoTime(long l) {
        this.hasDeadline = true;
        this.deadlineNanoTime = l;
        return this;
    }

    public boolean hasDeadline() {
        return this.hasDeadline;
    }

    public final <T> T intersectWith(Timeout timeout, Function0<? extends T> object) {
        Intrinsics.checkNotNullParameter((Object)timeout, (String)"other");
        Intrinsics.checkNotNullParameter(object, (String)"block");
        long l = this.timeoutNanos();
        this.timeout(Companion.minTimeout(timeout.timeoutNanos(), this.timeoutNanos()), TimeUnit.NANOSECONDS);
        if (this.hasDeadline()) {
            long l2 = this.deadlineNanoTime();
            if (timeout.hasDeadline()) {
                this.deadlineNanoTime(Math.min(this.deadlineNanoTime(), timeout.deadlineNanoTime()));
            }
            try {
                object = object.invoke();
                return (T)object;
            }
            finally {
                InlineMarker.finallyStart((int)1);
                this.timeout(l, TimeUnit.NANOSECONDS);
                if (timeout.hasDeadline()) {
                    this.deadlineNanoTime(l2);
                }
                InlineMarker.finallyEnd((int)1);
            }
        }
        if (timeout.hasDeadline()) {
            this.deadlineNanoTime(timeout.deadlineNanoTime());
        }
        try {
            object = object.invoke();
            return (T)object;
        }
        finally {
            InlineMarker.finallyStart((int)1);
            this.timeout(l, TimeUnit.NANOSECONDS);
            if (timeout.hasDeadline()) {
                this.clearDeadline();
            }
            InlineMarker.finallyEnd((int)1);
        }
    }

    public void throwIfReached() throws IOException {
        if (Thread.currentThread().isInterrupted()) throw new InterruptedIOException("interrupted");
        if (!this.hasDeadline) return;
        if (this.deadlineNanoTime - System.nanoTime() <= 0L) throw new InterruptedIOException("deadline reached");
    }

    public Timeout timeout(long l, TimeUnit timeUnit) {
        Intrinsics.checkNotNullParameter((Object)((Object)timeUnit), (String)"unit");
        boolean bl = l >= 0L;
        if (!bl) throw (Throwable)new IllegalArgumentException(Intrinsics.stringPlus((String)"timeout < 0: ", (Object)l).toString());
        this.timeoutNanos = timeUnit.toNanos(l);
        return this;
    }

    public long timeoutNanos() {
        return this.timeoutNanos;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     */
    public final void waitUntilNotified(Object var1_1) throws InterruptedIOException {
        Intrinsics.checkNotNullParameter((Object)var1_1, (String)"monitor");
        try {
            var3_3 = this.hasDeadline();
            var4_4 = this.timeoutNanos();
            var6_5 = 0L;
            if (!var3_3 && var4_4 == 0L) {
                var1_1.wait();
                return;
            }
            var8_6 = System.nanoTime();
            if (var3_3 && var4_4 != 0L) {
                var4_4 = Math.min(var4_4, this.deadlineNanoTime() - var8_6);
            } else if (var3_3) {
                var4_4 = this.deadlineNanoTime() - var8_6;
            }
            if (var4_4 > 0L) {
                var6_5 = var4_4 / 1000000L;
            }
            ** GOTO lbl27
        }
        catch (InterruptedException var1_2) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException("interrupted");
        }
        Long.signum(var6_5);
        var2_7 = (int)(var4_4 - 1000000L * var6_5);
        {
            var1_1.wait(var6_5, var2_7);
            var6_5 = System.nanoTime() - var8_6;
lbl27:
            // 2 sources

            if (var6_5 < var4_4) {
                return;
            }
            var1_1 = new InterruptedIOException("timeout");
            throw var1_1;
        }
    }
}
