/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  okio.Buffer
 */
package okhttp3.internal.cache2;

import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;

@Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bJ\u001e\u0010\f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2={"Lokhttp3/internal/cache2/FileOperator;", "", "fileChannel", "Ljava/nio/channels/FileChannel;", "(Ljava/nio/channels/FileChannel;)V", "read", "", "pos", "", "sink", "Lokio/Buffer;", "byteCount", "write", "source", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public final class FileOperator {
    private final FileChannel fileChannel;

    public FileOperator(FileChannel fileChannel) {
        Intrinsics.checkNotNullParameter((Object)fileChannel, (String)"fileChannel");
        this.fileChannel = fileChannel;
    }

    public final void read(long l, Buffer object, long l2) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"sink");
        if (l2 >= 0L) {
            while (l2 > 0L) {
                long l3 = this.fileChannel.transferTo(l, l2, (WritableByteChannel)object);
                l += l3;
                l2 -= l3;
            }
            return;
        }
        object = new IndexOutOfBoundsException();
        throw object;
    }

    public final void write(long l, Buffer object, long l2) throws IOException {
        Intrinsics.checkNotNullParameter((Object)object, (String)"source");
        if (l2 >= 0L && l2 <= object.size()) {
            long l3 = l;
            l = l2;
            while (l > 0L) {
                l2 = this.fileChannel.transferFrom((ReadableByteChannel)object, l3, l);
                l3 += l2;
                l -= l2;
            }
            return;
        }
        object = new IndexOutOfBoundsException();
        throw object;
    }
}
