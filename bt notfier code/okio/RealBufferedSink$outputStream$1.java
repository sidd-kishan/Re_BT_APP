/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  okio.RealBufferedSink
 */
package okio;

import java.io.IOException;
import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.RealBufferedSink;

@Metadata(d1={"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016J \u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000bH\u0016\u00a8\u0006\u000e"}, d2={"okio/RealBufferedSink$outputStream$1", "Ljava/io/OutputStream;", "close", "", "flush", "toString", "", "write", "data", "", "offset", "", "byteCount", "b", "okio"}, k=1, mv={1, 5, 1}, xi=48)
public static final class RealBufferedSink.outputStream.1
extends OutputStream {
    final RealBufferedSink this$0;

    RealBufferedSink.outputStream.1(RealBufferedSink realBufferedSink) {
        this.this$0 = realBufferedSink;
    }

    @Override
    public void close() {
        this.this$0.close();
    }

    @Override
    public void flush() {
        if (this.this$0.closed) return;
        this.this$0.flush();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.this$0);
        stringBuilder.append(".outputStream()");
        return stringBuilder.toString();
    }

    @Override
    public void write(int n) {
        if (this.this$0.closed) throw new IOException("closed");
        this.this$0.bufferField.writeByte((int)((byte)n));
        this.this$0.emitCompleteSegments();
    }

    @Override
    public void write(byte[] byArray, int n, int n2) {
        Intrinsics.checkNotNullParameter((Object)byArray, (String)"data");
        if (this.this$0.closed) throw new IOException("closed");
        this.this$0.bufferField.write(byArray, n, n2);
        this.this$0.emitCompleteSegments();
    }
}
