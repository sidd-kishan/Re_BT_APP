/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.DeprecationLevel
 *  kotlin.Metadata
 *  kotlin.ReplaceWith
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.InlineMarker
 *  kotlin.jvm.internal.Intrinsics
 *  okio.Buffer
 *  okio.Sink
 *  okio.Source
 *  okio.Timeout
 */
package okio;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.Sink;
import okio.Source;
import okio.Timeout;

@Metadata(d1={"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010!\u001a\u00020\"J\u000e\u0010#\u001a\u00020\"2\u0006\u0010\u0017\u001a\u00020\u0010J\r\u0010\u0017\u001a\u00020\u0010H\u0007\u00a2\u0006\u0002\b$J\r\u0010\u001b\u001a\u00020\u001cH\u0007\u00a2\u0006\u0002\b%J&\u0010&\u001a\u00020\"*\u00020\u00102\u0017\u0010'\u001a\u0013\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\"0(\u00a2\u0006\u0002\b)H\u0082\bR\u0014\u0010\u0005\u001a\u00020\u0006X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0017\u001a\u00020\u00108G\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u001a\u0010\u0018\u001a\u00020\nX\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u001a\u0010\u000eR\u0013\u0010\u001b\u001a\u00020\u001c8G\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\nX\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\f\"\u0004\b \u0010\u000e\u00a8\u0006*"}, d2={"Lokio/Pipe;", "", "maxBufferSize", "", "(J)V", "buffer", "Lokio/Buffer;", "getBuffer$okio", "()Lokio/Buffer;", "canceled", "", "getCanceled$okio", "()Z", "setCanceled$okio", "(Z)V", "foldedSink", "Lokio/Sink;", "getFoldedSink$okio", "()Lokio/Sink;", "setFoldedSink$okio", "(Lokio/Sink;)V", "getMaxBufferSize$okio", "()J", "sink", "sinkClosed", "getSinkClosed$okio", "setSinkClosed$okio", "source", "Lokio/Source;", "()Lokio/Source;", "sourceClosed", "getSourceClosed$okio", "setSourceClosed$okio", "cancel", "", "fold", "-deprecated_sink", "-deprecated_source", "forward", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "okio"}, k=1, mv={1, 5, 1}, xi=48)
public final class Pipe {
    private final Buffer buffer;
    private boolean canceled;
    private Sink foldedSink;
    private final long maxBufferSize;
    private final Sink sink;
    private boolean sinkClosed;
    private final Source source;
    private boolean sourceClosed;

    public Pipe(long l) {
        this.maxBufferSize = l;
        this.buffer = new Buffer();
        boolean bl = this.maxBufferSize >= 1L;
        if (!bl) throw (Throwable)new IllegalArgumentException(Intrinsics.stringPlus((String)"maxBufferSize < 1: ", (Object)this.getMaxBufferSize$okio()).toString());
        this.sink = (Sink)new /* Unavailable Anonymous Inner Class!! */;
        this.source = (Source)new /* Unavailable Anonymous Inner Class!! */;
    }

    private final void forward(Sink sink2, Function1<? super Sink, Unit> function1) {
        Timeout timeout = sink2.timeout();
        Timeout timeout2 = this.sink().timeout();
        long l = timeout.timeoutNanos();
        timeout.timeout(Timeout.Companion.minTimeout(timeout2.timeoutNanos(), timeout.timeoutNanos()), TimeUnit.NANOSECONDS);
        if (timeout.hasDeadline()) {
            long l2 = timeout.deadlineNanoTime();
            if (timeout2.hasDeadline()) {
                timeout.deadlineNanoTime(Math.min(timeout.deadlineNanoTime(), timeout2.deadlineNanoTime()));
            }
            try {
                function1.invoke((Object)sink2);
                sink2 = Unit.INSTANCE;
            }
            finally {
                InlineMarker.finallyStart((int)1);
                timeout.timeout(l, TimeUnit.NANOSECONDS);
                if (timeout2.hasDeadline()) {
                    timeout.deadlineNanoTime(l2);
                }
                InlineMarker.finallyEnd((int)1);
            }
        } else {
            if (timeout2.hasDeadline()) {
                timeout.deadlineNanoTime(timeout2.deadlineNanoTime());
            }
            function1.invoke((Object)sink2);
            sink2 = Unit.INSTANCE;
        }
        return;
        finally {
            InlineMarker.finallyStart((int)1);
            timeout.timeout(l, TimeUnit.NANOSECONDS);
            if (timeout2.hasDeadline()) {
                timeout.clearDeadline();
            }
            InlineMarker.finallyEnd((int)1);
        }
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="sink", imports={}))
    public final Sink _deprecated_sink() {
        return this.sink;
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="source", imports={}))
    public final Source _deprecated_source() {
        return this.source;
    }

    public final void cancel() {
        Buffer buffer = this.buffer;
        synchronized (buffer) {
            this.setCanceled$okio(true);
            this.getBuffer$okio().clear();
            ((Object)this.getBuffer$okio()).notifyAll();
            Unit unit = Unit.INSTANCE;
            return;
        }
    }

    /*
     * Unable to fully structure code
     * Enabled unnecessary exception pruning
     */
    public final void fold(Sink var1_1) throws IOException {
        Intrinsics.checkNotNullParameter((Object)var1_1 /* !! */ , (String)"sink");
        while (true) {
            var4_5 = this.buffer;
            synchronized (var4_5) {
                var2_3 = this.getFoldedSink$okio() == null;
                if (!var2_3) ** GOTO lbl37
                if (this.getCanceled$okio()) break;
                if (this.getBuffer$okio().exhausted()) {
                    this.setSourceClosed$okio(true);
                    this.setFoldedSink$okio(var1_1 /* !! */ );
                    return;
                }
                var3_4 = this.getSinkClosed$okio();
                var6_8 = new Buffer();
                var6_8.write(this.getBuffer$okio(), this.getBuffer$okio().size());
                ((Object)this.getBuffer$okio()).notifyAll();
                var5_6 = Unit.INSTANCE;
            }
            try {
                var1_1 /* !! */ .write(var6_8, var6_8.size());
                if (var3_4) {
                    var1_1 /* !! */ .close();
                    continue;
                }
                var1_1 /* !! */ .flush();
            }
            catch (Throwable var5_7) {
                var1_1 /* !! */  = this.buffer;
                synchronized (var1_1 /* !! */ ) {
                    this.setSourceClosed$okio(true);
                    ((Object)this.getBuffer$okio()).notifyAll();
                    var4_5 = Unit.INSTANCE;
                    throw var5_7;
                }
            }
        }
        {
            this.setFoldedSink$okio(var1_1 /* !! */ );
            var1_1 /* !! */  = new IOException("canceled");
            throw var1_1 /* !! */ ;
lbl37:
            // 1 sources

            var1_1 /* !! */  = new IllegalStateException("sink already folded".toString());
            throw (Throwable)var1_1 /* !! */ ;
        }
    }

    public final Buffer getBuffer$okio() {
        return this.buffer;
    }

    public final boolean getCanceled$okio() {
        return this.canceled;
    }

    public final Sink getFoldedSink$okio() {
        return this.foldedSink;
    }

    public final long getMaxBufferSize$okio() {
        return this.maxBufferSize;
    }

    public final boolean getSinkClosed$okio() {
        return this.sinkClosed;
    }

    public final boolean getSourceClosed$okio() {
        return this.sourceClosed;
    }

    public final void setCanceled$okio(boolean bl) {
        this.canceled = bl;
    }

    public final void setFoldedSink$okio(Sink sink2) {
        this.foldedSink = sink2;
    }

    public final void setSinkClosed$okio(boolean bl) {
        this.sinkClosed = bl;
    }

    public final void setSourceClosed$okio(boolean bl) {
        this.sourceClosed = bl;
    }

    public final Sink sink() {
        return this.sink;
    }

    public final Source source() {
        return this.source;
    }
}
