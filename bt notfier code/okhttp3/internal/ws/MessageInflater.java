/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  okio.Buffer
 *  okio.InflaterSource
 *  okio.Source
 */
package okhttp3.internal.ws;

import java.io.Closeable;
import java.io.IOException;
import java.util.zip.Inflater;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.InflaterSource;
import okio.Source;

@Metadata(d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u000b\u001a\u00020\fH\u0016J\u000e\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0006R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2={"Lokhttp3/internal/ws/MessageInflater;", "Ljava/io/Closeable;", "noContextTakeover", "", "(Z)V", "deflatedBytes", "Lokio/Buffer;", "inflater", "Ljava/util/zip/Inflater;", "inflaterSource", "Lokio/InflaterSource;", "close", "", "inflate", "buffer", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public final class MessageInflater
implements Closeable {
    private final Buffer deflatedBytes;
    private final Inflater inflater;
    private final InflaterSource inflaterSource;
    private final boolean noContextTakeover;

    public MessageInflater(boolean bl) {
        Inflater inflater;
        this.noContextTakeover = bl;
        this.deflatedBytes = new Buffer();
        this.inflater = inflater = new Inflater(true);
        this.inflaterSource = new InflaterSource((Source)this.deflatedBytes, inflater);
    }

    @Override
    public void close() throws IOException {
        this.inflaterSource.close();
    }

    public final void inflate(Buffer object) throws IOException {
        Intrinsics.checkNotNullParameter((Object)object, (String)"buffer");
        boolean bl = this.deflatedBytes.size() == 0L;
        if (!bl) {
            object = new IllegalArgumentException("Failed requirement.".toString());
            throw object;
        }
        if (this.noContextTakeover) {
            this.inflater.reset();
        }
        this.deflatedBytes.writeAll((Source)object);
        this.deflatedBytes.writeInt(65535);
        long l = this.inflater.getBytesRead();
        long l2 = this.deflatedBytes.size();
        do {
            this.inflaterSource.readOrInflate(object, Long.MAX_VALUE);
        } while (this.inflater.getBytesRead() < l + l2);
    }
}
