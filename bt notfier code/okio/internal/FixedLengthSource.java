/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  okio.Buffer
 *  okio.ForwardingSource
 *  okio.Source
 */
package okio.internal;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.ForwardingSource;
import okio.Source;

@Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0018\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H\u0016J\u0014\u0010\u000e\u001a\u00020\u000f*\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0005H\u0002R\u000e\u0010\t\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2={"Lokio/internal/FixedLengthSource;", "Lokio/ForwardingSource;", "delegate", "Lokio/Source;", "size", "", "truncate", "", "(Lokio/Source;JZ)V", "bytesReceived", "read", "sink", "Lokio/Buffer;", "byteCount", "truncateToSize", "", "newSize", "okio"}, k=1, mv={1, 5, 1}, xi=48)
public final class FixedLengthSource
extends ForwardingSource {
    private long bytesReceived;
    private final long size;
    private final boolean truncate;

    public FixedLengthSource(Source source, long l, boolean bl) {
        Intrinsics.checkNotNullParameter((Object)source, (String)"delegate");
        super(source);
        this.size = l;
        this.truncate = bl;
    }

    private final void truncateToSize(Buffer buffer, long l) {
        Buffer buffer2 = new Buffer();
        buffer2.writeAll((Source)buffer);
        buffer.write(buffer2, l);
        buffer2.clear();
    }

    public long read(Buffer object, long l) {
        long l2;
        Intrinsics.checkNotNullParameter((Object)object, (String)"sink");
        long l3 = this.bytesReceived;
        long l4 = this.size;
        if (l3 > l4) {
            l2 = 0L;
        } else {
            l2 = l;
            if (this.truncate) {
                l2 = l4 - l3;
                if (l2 == 0L) {
                    return -1L;
                }
                l2 = Math.min(l, l2);
            }
        }
        l = super.read((Buffer)object, l2);
        if (l != -1L) {
            this.bytesReceived += l;
        }
        if (this.bytesReceived >= this.size || l != -1L) {
            if (this.bytesReceived <= this.size) return l;
        }
        if (l > 0L && this.bytesReceived > this.size) {
            this.truncateToSize((Buffer)object, object.size() - (this.bytesReceived - this.size));
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("expected ");
        ((StringBuilder)object).append(this.size);
        ((StringBuilder)object).append(" bytes but got ");
        ((StringBuilder)object).append(this.bytesReceived);
        throw new IOException(((StringBuilder)object).toString());
    }
}
