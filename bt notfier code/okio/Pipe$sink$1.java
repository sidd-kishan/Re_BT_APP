/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.internal.Intrinsics
 *  okio.Buffer
 *  okio.Pipe
 *  okio.Sink
 *  okio.Timeout
 */
package okio;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.Pipe;
import okio.Sink;
import okio.Timeout;

@Metadata(d1={"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2={"okio/Pipe$sink$1", "Lokio/Sink;", "timeout", "Lokio/Timeout;", "close", "", "flush", "write", "source", "Lokio/Buffer;", "byteCount", "", "okio"}, k=1, mv={1, 5, 1}, xi=48)
public static final class Pipe.sink.1
implements Sink {
    final Pipe this$0;
    private final Timeout timeout;

    Pipe.sink.1(Pipe pipe) {
        this.this$0 = pipe;
        this.timeout = new Timeout();
    }

    /*
     * WARNING - void declaration
     * Enabled unnecessary exception pruning
     * Converted monitor instructions to comments
     */
    public void close() {
        void var6_8;
        Sink sink2;
        Buffer buffer = this.this$0.getBuffer$okio();
        Pipe pipe = this.this$0;
        // MONITORENTER : buffer
        boolean bl = pipe.getSinkClosed$okio();
        if (bl) {
            // MONITOREXIT : buffer
            return;
        }
        Sink sink3 = sink2 = pipe.getFoldedSink$okio();
        if (sink2 == null) {
            if (pipe.getSourceClosed$okio() && pipe.getBuffer$okio().size() > 0L) {
                IOException iOException = new IOException("source is closed");
                throw iOException;
            }
            pipe.setSinkClosed$okio(true);
            ((Object)pipe.getBuffer$okio()).notifyAll();
            Object var6_7 = null;
        }
        sink2 = Unit.INSTANCE;
        // MONITOREXIT : buffer
        if (var6_8 == null) {
            return;
        }
        buffer = this.this$0;
        sink2 = var6_8.timeout();
        buffer = buffer.sink().timeout();
        long l = sink2.timeoutNanos();
        sink2.timeout(Timeout.Companion.minTimeout(buffer.timeoutNanos(), sink2.timeoutNanos()), TimeUnit.NANOSECONDS);
        if (sink2.hasDeadline()) {
            long l2 = sink2.deadlineNanoTime();
            if (buffer.hasDeadline()) {
                sink2.deadlineNanoTime(Math.min(sink2.deadlineNanoTime(), buffer.deadlineNanoTime()));
            }
            try {
                var6_8.close();
                Unit unit = Unit.INSTANCE;
                return;
            }
            finally {
                sink2.timeout(l, TimeUnit.NANOSECONDS);
                if (buffer.hasDeadline()) {
                    sink2.deadlineNanoTime(l2);
                }
            }
        }
        if (buffer.hasDeadline()) {
            sink2.deadlineNanoTime(buffer.deadlineNanoTime());
        }
        try {
            var6_8.close();
            Unit unit = Unit.INSTANCE;
            return;
        }
        finally {
            sink2.timeout(l, TimeUnit.NANOSECONDS);
            if (buffer.hasDeadline()) {
                sink2.clearDeadline();
            }
        }
    }

    /*
     * Enabled unnecessary exception pruning
     * Converted monitor instructions to comments
     */
    public void flush() {
        Sink sink2;
        Buffer buffer = this.this$0.getBuffer$okio();
        Pipe pipe = this.this$0;
        // MONITORENTER : buffer
        if (!(pipe.getSinkClosed$okio() ^ true)) {
            IllegalStateException illegalStateException = new IllegalStateException("closed".toString());
            throw (Throwable)illegalStateException;
        }
        if (pipe.getCanceled$okio()) {
            IOException iOException = new IOException("canceled");
            throw iOException;
        }
        Object object = sink2 = pipe.getFoldedSink$okio();
        if (sink2 == null) {
            if (pipe.getSourceClosed$okio() && pipe.getBuffer$okio().size() > 0L) {
                object = new IOException("source is closed");
                throw object;
            }
            object = null;
        }
        sink2 = Unit.INSTANCE;
        // MONITOREXIT : buffer
        if (object == null) {
            return;
        }
        buffer = this.this$0;
        sink2 = object.timeout();
        buffer = buffer.sink().timeout();
        long l = sink2.timeoutNanos();
        sink2.timeout(Timeout.Companion.minTimeout(buffer.timeoutNanos(), sink2.timeoutNanos()), TimeUnit.NANOSECONDS);
        if (sink2.hasDeadline()) {
            long l2 = sink2.deadlineNanoTime();
            if (buffer.hasDeadline()) {
                sink2.deadlineNanoTime(Math.min(sink2.deadlineNanoTime(), buffer.deadlineNanoTime()));
            }
            try {
                object.flush();
                object = Unit.INSTANCE;
                return;
            }
            finally {
                sink2.timeout(l, TimeUnit.NANOSECONDS);
                if (buffer.hasDeadline()) {
                    sink2.deadlineNanoTime(l2);
                }
            }
        }
        if (buffer.hasDeadline()) {
            sink2.deadlineNanoTime(buffer.deadlineNanoTime());
        }
        try {
            object.flush();
            object = Unit.INSTANCE;
            return;
        }
        finally {
            sink2.timeout(l, TimeUnit.NANOSECONDS);
            if (buffer.hasDeadline()) {
                sink2.clearDeadline();
            }
        }
    }

    public Timeout timeout() {
        return this.timeout;
    }

    /*
     * Enabled unnecessary exception pruning
     * Converted monitor instructions to comments
     */
    public void write(Buffer object, long l) {
        long l2;
        Sink sink2;
        Sink sink3;
        Buffer buffer;
        block24: {
            Intrinsics.checkNotNullParameter((Object)object, (String)"source");
            buffer = this.this$0.getBuffer$okio();
            Pipe pipe = this.this$0;
            // MONITORENTER : buffer
            if (pipe.getSinkClosed$okio() ^ true) {
                if (pipe.getCanceled$okio()) {
                    object = new IOException("canceled");
                    throw object;
                }
            } else {
                object = new IllegalStateException("closed".toString());
                throw (Throwable)object;
            }
            while (l > 0L) {
                sink2 = sink3 = pipe.getFoldedSink$okio();
                if (sink3 == null) {
                    if (!pipe.getSourceClosed$okio()) {
                        l2 = pipe.getMaxBufferSize$okio() - pipe.getBuffer$okio().size();
                        if (l2 == 0L) {
                            this.timeout.waitUntilNotified((Object)pipe.getBuffer$okio());
                            if (!pipe.getCanceled$okio()) continue;
                            object = new IOException("canceled");
                            throw object;
                        }
                        l2 = Math.min(l2, l);
                        pipe.getBuffer$okio().write((Buffer)object, l2);
                        l -= l2;
                        ((Object)pipe.getBuffer$okio()).notifyAll();
                        continue;
                    }
                    object = new IOException("source is closed");
                    throw object;
                }
                break block24;
            }
            sink2 = null;
        }
        sink3 = Unit.INSTANCE;
        // MONITOREXIT : buffer
        if (sink2 == null) {
            return;
        }
        buffer = this.this$0;
        sink3 = sink2.timeout();
        buffer = buffer.sink().timeout();
        long l3 = sink3.timeoutNanos();
        sink3.timeout(Timeout.Companion.minTimeout(buffer.timeoutNanos(), sink3.timeoutNanos()), TimeUnit.NANOSECONDS);
        if (sink3.hasDeadline()) {
            l2 = sink3.deadlineNanoTime();
            if (buffer.hasDeadline()) {
                sink3.deadlineNanoTime(Math.min(sink3.deadlineNanoTime(), buffer.deadlineNanoTime()));
            }
            try {
                sink2.write((Buffer)object, l);
                object = Unit.INSTANCE;
                return;
            }
            finally {
                sink3.timeout(l3, TimeUnit.NANOSECONDS);
                if (buffer.hasDeadline()) {
                    sink3.deadlineNanoTime(l2);
                }
            }
        }
        if (buffer.hasDeadline()) {
            sink3.deadlineNanoTime(buffer.deadlineNanoTime());
        }
        try {
            sink2.write((Buffer)object, l);
            object = Unit.INSTANCE;
            return;
        }
        finally {
            sink3.timeout(l3, TimeUnit.NANOSECONDS);
            if (buffer.hasDeadline()) {
                sink3.clearDeadline();
            }
        }
    }
}
