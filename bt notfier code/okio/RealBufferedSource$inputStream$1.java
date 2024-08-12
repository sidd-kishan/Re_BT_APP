/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  okio.RealBufferedSource
 *  okio._UtilKt
 */
package okio;

import java.io.IOException;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.RealBufferedSource;
import okio._UtilKt;

@Metadata(d1={"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016J \u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0003H\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016\u00a8\u0006\r"}, d2={"okio/RealBufferedSource$inputStream$1", "Ljava/io/InputStream;", "available", "", "close", "", "read", "data", "", "offset", "byteCount", "toString", "", "okio"}, k=1, mv={1, 5, 1}, xi=48)
public static final class RealBufferedSource.inputStream.1
extends InputStream {
    final RealBufferedSource this$0;

    RealBufferedSource.inputStream.1(RealBufferedSource realBufferedSource) {
        this.this$0 = realBufferedSource;
    }

    @Override
    public int available() {
        if (this.this$0.closed) throw new IOException("closed");
        return (int)Math.min(this.this$0.bufferField.size(), (long)Integer.MAX_VALUE);
    }

    @Override
    public void close() {
        this.this$0.close();
    }

    @Override
    public int read() {
        if (this.this$0.closed) throw new IOException("closed");
        if (this.this$0.bufferField.size() != 0L) return this.this$0.bufferField.readByte() & 0xFF;
        if (this.this$0.source.read(this.this$0.bufferField, 8192L) != -1L) return this.this$0.bufferField.readByte() & 0xFF;
        return -1;
    }

    @Override
    public int read(byte[] byArray, int n, int n2) {
        Intrinsics.checkNotNullParameter((Object)byArray, (String)"data");
        if (this.this$0.closed) throw new IOException("closed");
        _UtilKt.checkOffsetAndCount((long)byArray.length, (long)n, (long)n2);
        if (this.this$0.bufferField.size() != 0L) return this.this$0.bufferField.read(byArray, n, n2);
        if (this.this$0.source.read(this.this$0.bufferField, 8192L) != -1L) return this.this$0.bufferField.read(byArray, n, n2);
        return -1;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.this$0);
        stringBuilder.append(".inputStream()");
        return stringBuilder.toString();
    }
}
