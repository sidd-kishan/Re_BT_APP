/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  okio.Buffer
 *  okio.Timeout
 */
package okio;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import kotlin.Metadata;
import okio.Buffer;
import okio.Timeout;

@Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\bf\u0018\u00002\u00020\u00012\u00020\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH&\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00a8\u0006\r\u00c0\u0006\u0001"}, d2={"Lokio/Sink;", "Ljava/io/Closeable;", "Ljava/io/Flushable;", "close", "", "flush", "timeout", "Lokio/Timeout;", "write", "source", "Lokio/Buffer;", "byteCount", "", "okio"}, k=1, mv={1, 5, 1}, xi=48)
public interface Sink
extends Closeable,
Flushable {
    @Override
    public void close() throws IOException;

    @Override
    public void flush() throws IOException;

    public Timeout timeout();

    public void write(Buffer var1, long var2) throws IOException;
}
