/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  okio.Buffer
 */
package okio;

import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;

@Metadata(d1={"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016J \u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0003H\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016\u00a8\u0006\r"}, d2={"okio/Buffer$inputStream$1", "Ljava/io/InputStream;", "available", "", "close", "", "read", "sink", "", "offset", "byteCount", "toString", "", "okio"}, k=1, mv={1, 5, 1}, xi=48)
public static final class Buffer.inputStream.1
extends InputStream {
    final Buffer this$0;

    Buffer.inputStream.1(Buffer buffer) {
        this.this$0 = buffer;
    }

    @Override
    public int available() {
        return (int)Math.min(this.this$0.size(), (long)Integer.MAX_VALUE);
    }

    @Override
    public void close() {
    }

    @Override
    public int read() {
        int n = this.this$0.size() > 0L ? this.this$0.readByte() & 0xFF : -1;
        return n;
    }

    @Override
    public int read(byte[] byArray, int n, int n2) {
        Intrinsics.checkNotNullParameter((Object)byArray, (String)"sink");
        return this.this$0.read(byArray, n, n2);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.this$0);
        stringBuilder.append(".inputStream()");
        return stringBuilder.toString();
    }
}
