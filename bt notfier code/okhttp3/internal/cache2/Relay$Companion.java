/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  okhttp3.internal.cache2.FileOperator
 *  okhttp3.internal.cache2.Relay
 *  okio.Buffer
 *  okio.ByteString
 *  okio.Source
 */
package okhttp3.internal.cache2;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.cache2.FileOperator;
import okhttp3.internal.cache2.Relay;
import okio.Buffer;
import okio.ByteString;
import okio.Source;

/*
 * Exception performing whole class analysis ignored.
 */
@Metadata(d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J&\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0004J\u000e\u0010\u0013\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2={"Lokhttp3/internal/cache2/Relay$Companion;", "", "()V", "FILE_HEADER_SIZE", "", "PREFIX_CLEAN", "Lokio/ByteString;", "PREFIX_DIRTY", "SOURCE_FILE", "", "SOURCE_UPSTREAM", "edit", "Lokhttp3/internal/cache2/Relay;", "file", "Ljava/io/File;", "upstream", "Lokio/Source;", "metadata", "bufferMaxSize", "read", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public static final class Relay.Companion {
    private Relay.Companion() {
    }

    public /* synthetic */ Relay.Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public final Relay edit(File object, Source source, ByteString byteString, long l) throws IOException {
        Intrinsics.checkNotNullParameter((Object)object, (String)"file");
        Intrinsics.checkNotNullParameter((Object)source, (String)"upstream");
        Intrinsics.checkNotNullParameter((Object)byteString, (String)"metadata");
        object = new RandomAccessFile((File)object, "rw");
        source = new Relay((RandomAccessFile)object, source, 0L, byteString, l, null);
        ((RandomAccessFile)object).setLength(0L);
        Relay.access$writeHeader((Relay)source, (ByteString)Relay.PREFIX_DIRTY, (long)-1L, (long)-1L);
        return source;
    }

    public final Relay read(File object) throws IOException {
        Intrinsics.checkNotNullParameter((Object)object, (String)"file");
        object = new RandomAccessFile((File)object, "rw");
        FileChannel fileChannel = ((RandomAccessFile)object).getChannel();
        Intrinsics.checkNotNullExpressionValue((Object)fileChannel, (String)"randomAccessFile.channel");
        fileChannel = new FileOperator(fileChannel);
        Buffer buffer = new Buffer();
        fileChannel.read(0L, buffer, 32L);
        if (!Intrinsics.areEqual((Object)buffer.readByteString((long)Relay.PREFIX_CLEAN.size()), (Object)Relay.PREFIX_CLEAN)) throw new IOException("unreadable cache file");
        long l = buffer.readLong();
        long l2 = buffer.readLong();
        buffer = new Buffer();
        fileChannel.read(l + 32L, buffer, l2);
        return new Relay((RandomAccessFile)object, null, l, buffer.readByteString(), 0L, null);
    }
}
