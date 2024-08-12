/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.internal.Intrinsics
 *  okio.AsyncTimeout
 *  okio.Buffer
 *  okio.Source
 */
package okio;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import okio.AsyncTimeout;
import okio.Buffer;
import okio.Source;

@Metadata(d1={"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016\u00a8\u0006\r"}, d2={"okio/AsyncTimeout$source$1", "Lokio/Source;", "close", "", "read", "", "sink", "Lokio/Buffer;", "byteCount", "timeout", "Lokio/AsyncTimeout;", "toString", "", "okio"}, k=1, mv={1, 5, 1}, xi=48)
public static final class AsyncTimeout.source.1
implements Source {
    final Source $source;
    final AsyncTimeout this$0;

    AsyncTimeout.source.1(AsyncTimeout asyncTimeout, Source source2) {
        this.this$0 = asyncTimeout;
        this.$source = source2;
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
            Source source2 = this.$source;
            asyncTimeout.enter();
            source2.close();
            source2 = Unit.INSTANCE;
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
    public long read(Buffer buffer, long l) {
        Throwable throwable2222222;
        AsyncTimeout asyncTimeout;
        block5: {
            Intrinsics.checkNotNullParameter((Object)buffer, (String)"sink");
            asyncTimeout = this.this$0;
            Source source2 = this.$source;
            asyncTimeout.enter();
            l = source2.read(buffer, l);
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
            return l;
        }
        asyncTimeout.exit();
        throw throwable2222222;
    }

    public AsyncTimeout timeout() {
        return this.this$0;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("AsyncTimeout.source(");
        stringBuilder.append(this.$source);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}
