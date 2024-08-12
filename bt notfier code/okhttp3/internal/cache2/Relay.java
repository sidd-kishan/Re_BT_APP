/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  okhttp3.internal.Util
 *  okhttp3.internal.cache2.FileOperator
 *  okhttp3.internal.cache2.Relay$Companion
 *  okhttp3.internal.cache2.Relay$RelaySource
 *  okio.Buffer
 *  okio.ByteString
 *  okio.Source
 */
package okhttp3.internal.cache2;

import java.io.Closeable;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;
import okhttp3.internal.cache2.FileOperator;
import okhttp3.internal.cache2.Relay;
import okio.Buffer;
import okio.ByteString;
import okio.Source;

@Metadata(d1={"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u0000 :2\u00020\u0001:\u0002:;B3\b\u0002\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\u000bJ\u000e\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\u0007J\u0006\u0010\b\u001a\u00020\tJ\b\u00105\u001a\u0004\u0018\u00010\u0005J \u00106\u001a\u0002032\u0006\u00107\u001a\u00020\t2\u0006\u00104\u001a\u00020\u00072\u0006\u00108\u001a\u00020\u0007H\u0002J\u0010\u00109\u001a\u0002032\u0006\u00104\u001a\u00020\u0007H\u0002R\u0011\u0010\f\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\n\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0011\u0010\u001c\u001a\u00020\u00138F\u00a2\u0006\u0006\u001a\u0004\b\u001c\u0010\u0015R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u001d\u001a\u00020\u001eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0011\u0010'\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010\u000fR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0011\"\u0004\b*\u0010+R\u001c\u0010,\u001a\u0004\u0018\u00010-X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101\u00a8\u0006<"}, d2={"Lokhttp3/internal/cache2/Relay;", "", "file", "Ljava/io/RandomAccessFile;", "upstream", "Lokio/Source;", "upstreamPos", "", "metadata", "Lokio/ByteString;", "bufferMaxSize", "(Ljava/io/RandomAccessFile;Lokio/Source;JLokio/ByteString;J)V", "buffer", "Lokio/Buffer;", "getBuffer", "()Lokio/Buffer;", "getBufferMaxSize", "()J", "complete", "", "getComplete", "()Z", "setComplete", "(Z)V", "getFile", "()Ljava/io/RandomAccessFile;", "setFile", "(Ljava/io/RandomAccessFile;)V", "isClosed", "sourceCount", "", "getSourceCount", "()I", "setSourceCount", "(I)V", "getUpstream", "()Lokio/Source;", "setUpstream", "(Lokio/Source;)V", "upstreamBuffer", "getUpstreamBuffer", "getUpstreamPos", "setUpstreamPos", "(J)V", "upstreamReader", "Ljava/lang/Thread;", "getUpstreamReader", "()Ljava/lang/Thread;", "setUpstreamReader", "(Ljava/lang/Thread;)V", "commit", "", "upstreamSize", "newSource", "writeHeader", "prefix", "metadataSize", "writeMetadata", "Companion", "RelaySource", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public final class Relay {
    public static final Companion Companion = new Companion(null);
    private static final long FILE_HEADER_SIZE = 32L;
    public static final ByteString PREFIX_CLEAN = ByteString.Companion.encodeUtf8("OkHttp cache v1\n");
    public static final ByteString PREFIX_DIRTY = ByteString.Companion.encodeUtf8("OkHttp DIRTY :(\n");
    private static final int SOURCE_FILE = 2;
    private static final int SOURCE_UPSTREAM = 1;
    private final Buffer buffer;
    private final long bufferMaxSize;
    private boolean complete;
    private RandomAccessFile file;
    private final ByteString metadata;
    private int sourceCount;
    private Source upstream;
    private final Buffer upstreamBuffer;
    private long upstreamPos;
    private Thread upstreamReader;

    private Relay(RandomAccessFile randomAccessFile, Source source, long l, ByteString byteString, long l2) {
        this.file = randomAccessFile;
        this.upstream = source;
        this.upstreamPos = l;
        this.metadata = byteString;
        this.bufferMaxSize = l2;
        this.upstreamBuffer = new Buffer();
        boolean bl = this.upstream == null;
        this.complete = bl;
        this.buffer = new Buffer();
    }

    public /* synthetic */ Relay(RandomAccessFile randomAccessFile, Source source, long l, ByteString byteString, long l2, DefaultConstructorMarker defaultConstructorMarker) {
        this(randomAccessFile, source, l, byteString, l2);
    }

    public static final /* synthetic */ void access$writeHeader(Relay relay, ByteString byteString, long l, long l2) {
        relay.writeHeader(byteString, l, l2);
    }

    private final void writeHeader(ByteString object, long l, long l2) throws IOException {
        Buffer buffer = new Buffer();
        buffer.write((ByteString)object);
        buffer.writeLong(l);
        buffer.writeLong(l2);
        boolean bl = buffer.size() == 32L;
        if (!bl) throw (Throwable)new IllegalArgumentException("Failed requirement.".toString());
        object = this.file;
        Intrinsics.checkNotNull((Object)object);
        object = ((RandomAccessFile)object).getChannel();
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"file!!.channel");
        new FileOperator((FileChannel)object).write(0L, buffer, 32L);
    }

    private final void writeMetadata(long l) throws IOException {
        Buffer buffer = new Buffer();
        buffer.write(this.metadata);
        Closeable closeable = this.file;
        Intrinsics.checkNotNull((Object)closeable);
        closeable = closeable.getChannel();
        Intrinsics.checkNotNullExpressionValue((Object)closeable, (String)"file!!.channel");
        new FileOperator((FileChannel)closeable).write(32L + l, buffer, (long)this.metadata.size());
    }

    public final void commit(long l) throws IOException {
        block4: {
            RandomAccessFile randomAccessFile;
            block3: {
                this.writeMetadata(l);
                randomAccessFile = this.file;
                Intrinsics.checkNotNull((Object)randomAccessFile);
                randomAccessFile.getChannel().force(false);
                this.writeHeader(PREFIX_CLEAN, l, this.metadata.size());
                randomAccessFile = this.file;
                Intrinsics.checkNotNull((Object)randomAccessFile);
                randomAccessFile.getChannel().force(false);
                synchronized (this) {
                    this.setComplete(true);
                    randomAccessFile = Unit.INSTANCE;
                    // MONITOREXIT @DISABLED, blocks:[0, 1] lbl13 : MonitorExitStatement: MONITOREXIT : this
                    randomAccessFile = this.upstream;
                    if (randomAccessFile != null) break block3;
                    break block4;
                }
            }
            Util.closeQuietly((Closeable)randomAccessFile);
        }
        this.upstream = null;
    }

    public final Buffer getBuffer() {
        return this.buffer;
    }

    public final long getBufferMaxSize() {
        return this.bufferMaxSize;
    }

    public final boolean getComplete() {
        return this.complete;
    }

    public final RandomAccessFile getFile() {
        return this.file;
    }

    public final int getSourceCount() {
        return this.sourceCount;
    }

    public final Source getUpstream() {
        return this.upstream;
    }

    public final Buffer getUpstreamBuffer() {
        return this.upstreamBuffer;
    }

    public final long getUpstreamPos() {
        return this.upstreamPos;
    }

    public final Thread getUpstreamReader() {
        return this.upstreamReader;
    }

    public final boolean isClosed() {
        boolean bl = this.file == null;
        return bl;
    }

    public final ByteString metadata() {
        return this.metadata;
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public final Source newSource() {
        synchronized (this) {
            RandomAccessFile randomAccessFile = this.getFile();
            if (randomAccessFile == null) {
                return null;
            }
            this.setSourceCount(this.getSourceCount() + 1);
            return (Source)new RelaySource(this);
        }
    }

    public final void setComplete(boolean bl) {
        this.complete = bl;
    }

    public final void setFile(RandomAccessFile randomAccessFile) {
        this.file = randomAccessFile;
    }

    public final void setSourceCount(int n) {
        this.sourceCount = n;
    }

    public final void setUpstream(Source source) {
        this.upstream = source;
    }

    public final void setUpstreamPos(long l) {
        this.upstreamPos = l;
    }

    public final void setUpstreamReader(Thread thread) {
        this.upstreamReader = thread;
    }
}
