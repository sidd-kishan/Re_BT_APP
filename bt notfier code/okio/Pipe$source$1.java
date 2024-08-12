/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.internal.Intrinsics
 *  okio.Buffer
 *  okio.Pipe
 *  okio.Source
 *  okio.Timeout
 */
package okio;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.Pipe;
import okio.Source;
import okio.Timeout;

@Metadata(d1={"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007H\u0016J\b\u0010\u0002\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2={"okio/Pipe$source$1", "Lokio/Source;", "timeout", "Lokio/Timeout;", "close", "", "read", "", "sink", "Lokio/Buffer;", "byteCount", "okio"}, k=1, mv={1, 5, 1}, xi=48)
public static final class Pipe.source.1
implements Source {
    final Pipe this$0;
    private final Timeout timeout;

    Pipe.source.1(Pipe pipe) {
        this.this$0 = pipe;
        this.timeout = new Timeout();
    }

    public void close() {
        Buffer buffer = this.this$0.getBuffer$okio();
        Pipe pipe = this.this$0;
        synchronized (buffer) {
            pipe.setSourceClosed$okio(true);
            ((Object)pipe.getBuffer$okio()).notifyAll();
            pipe = Unit.INSTANCE;
            return;
        }
    }

    /*
     * Enabled force condition propagation
     */
    public long read(Buffer object, long l) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"sink");
        Buffer buffer = this.this$0.getBuffer$okio();
        Pipe pipe = this.this$0;
        synchronized (buffer) {
            if (pipe.getSourceClosed$okio() ^ true) {
                if (!pipe.getCanceled$okio()) {
                    while (pipe.getBuffer$okio().size() == 0L) {
                        boolean bl = pipe.getSinkClosed$okio();
                        if (bl) {
                            return -1L;
                        }
                        this.timeout.waitUntilNotified((Object)pipe.getBuffer$okio());
                        if (!pipe.getCanceled$okio()) continue;
                        object = new IOException("canceled");
                        throw object;
                    }
                    l = pipe.getBuffer$okio().read(object, l);
                    ((Object)pipe.getBuffer$okio()).notifyAll();
                    return l;
                }
                object = new IOException("canceled");
                throw object;
            }
            object = new IllegalStateException("closed".toString());
            throw (Throwable)object;
        }
    }

    public Timeout timeout() {
        return this.timeout;
    }
}
