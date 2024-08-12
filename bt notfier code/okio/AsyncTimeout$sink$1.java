/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.internal.Intrinsics
 *  okio.AsyncTimeout
 *  okio.Buffer
 *  okio.Segment
 *  okio.Sink
 *  okio._UtilKt
 */
package okio;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import okio.AsyncTimeout;
import okio.Buffer;
import okio.Segment;
import okio.Sink;
import okio._UtilKt;

@Metadata(d1={"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016\u00a8\u0006\u000e"}, d2={"okio/AsyncTimeout$sink$1", "Lokio/Sink;", "close", "", "flush", "timeout", "Lokio/AsyncTimeout;", "toString", "", "write", "source", "Lokio/Buffer;", "byteCount", "", "okio"}, k=1, mv={1, 5, 1}, xi=48)
public static final class AsyncTimeout.sink.1
implements Sink {
    final Sink $sink;
    final AsyncTimeout this$0;

    AsyncTimeout.sink.1(AsyncTimeout asyncTimeout, Sink sink2) {
        this.this$0 = asyncTimeout;
        this.$sink = sink2;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled unnecessary exception pruning
     */
    public void close() {
        Throwable throwable2222222;
        AsyncTimeout asyncTimeout;
        block5: {
            asyncTimeout = this.this$0;
            Sink sink2 = this.$sink;
            asyncTimeout.enter();
            sink2.close();
            sink2 = Unit.INSTANCE;
            {
                catch (Throwable throwable2222222) {
                    break block5;
                }
                catch (IOException iOException) {}
                {
                    Throwable throwable3;
                    if (asyncTimeout.exit()) {
                        throwable3 = asyncTimeout.access$newTimeoutException(iOException);
                    }
                    throwable3 = throwable3;
                    throw throwable3;
                }
            }
            if (asyncTimeout.exit()) throw asyncTimeout.access$newTimeoutException(null);
            return;
        }
        asyncTimeout.exit();
        throw throwable2222222;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled unnecessary exception pruning
     */
    public void flush() {
        Throwable throwable2222222;
        AsyncTimeout asyncTimeout;
        block5: {
            asyncTimeout = this.this$0;
            Sink sink2 = this.$sink;
            asyncTimeout.enter();
            sink2.flush();
            sink2 = Unit.INSTANCE;
            {
                catch (Throwable throwable2222222) {
                    break block5;
                }
                catch (IOException iOException) {}
                {
                    Throwable throwable3;
                    if (asyncTimeout.exit()) {
                        throwable3 = asyncTimeout.access$newTimeoutException(iOException);
                    }
                    throwable3 = throwable3;
                    throw throwable3;
                }
            }
            if (asyncTimeout.exit()) throw asyncTimeout.access$newTimeoutException(null);
            return;
        }
        asyncTimeout.exit();
        throw throwable2222222;
    }

    public AsyncTimeout timeout() {
        return this.this$0;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("AsyncTimeout.sink(");
        stringBuilder.append(this.$sink);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled unnecessary exception pruning
     */
    public void write(Buffer buffer, long l) {
        Throwable throwable2222222;
        Segment segment;
        Intrinsics.checkNotNullParameter((Object)buffer, (String)"source");
        _UtilKt.checkOffsetAndCount((long)buffer.size(), (long)0L, (long)l);
        while (true) {
            long l2;
            long l3 = 0L;
            if (l <= 0L) return;
            segment = buffer.head;
            Intrinsics.checkNotNull((Object)segment);
            while (true) {
                l2 = l3;
                if (l3 >= 65536L) break;
                if ((l3 += (long)(segment.limit - segment.pos)) >= l) {
                    l2 = l;
                    break;
                }
                segment = segment.next;
                Intrinsics.checkNotNull((Object)segment);
            }
            segment = this.this$0;
            Sink sink2 = this.$sink;
            segment.enter();
            sink2.write(buffer, l2);
            sink2 = Unit.INSTANCE;
            {
                catch (Throwable throwable2222222) {
                    break;
                }
                catch (IOException iOException) {}
                {
                    Throwable throwable3;
                    if (segment.exit()) {
                        throwable3 = segment.access$newTimeoutException(iOException);
                    }
                    throwable3 = throwable3;
                    throw throwable3;
                }
            }
            if (segment.exit()) throw segment.access$newTimeoutException(null);
            l -= l2;
        }
        segment.exit();
        throw throwable2222222;
    }
}
