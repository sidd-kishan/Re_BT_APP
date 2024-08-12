/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.internal.Intrinsics
 *  okio.Buffer
 *  okio.FileHandle$FileHandleSink
 *  okio.FileHandle$FileHandleSource
 *  okio.RealBufferedSink
 *  okio.RealBufferedSource
 *  okio.Segment
 *  okio.SegmentPool
 *  okio.Sink
 *  okio.Source
 *  okio._UtilKt
 */
package okio;

import java.io.Closeable;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.FileHandle;
import okio.RealBufferedSink;
import okio.RealBufferedSource;
import okio.Segment;
import okio.SegmentPool;
import okio.Sink;
import okio.Source;
import okio._UtilKt;

@Metadata(d1={"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u00002\u00060\u0001j\u0002`\u0002:\u0002()B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\u000eJ\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\fJ\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0014J\b\u0010\u0015\u001a\u00020\u000eH$J\b\u0010\u0016\u001a\u00020\u000eH$J(\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\bH$J\u0010\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u0011H$J\b\u0010\u001f\u001a\u00020\u0011H$J(\u0010 \u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\bH$J&\u0010!\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\bJ\u001e\u0010!\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\"2\u0006\u0010\u001c\u001a\u00020\u0011J \u0010#\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\"2\u0006\u0010\u001c\u001a\u00020\u0011H\u0002J\u0016\u0010$\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011J\u0016\u0010$\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010%\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u0011J\u0010\u0010\u0012\u001a\u00020\f2\b\b\u0002\u0010\u0018\u001a\u00020\u0011J\u0006\u0010\u001e\u001a\u00020\u0011J\u0010\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0018\u001a\u00020\u0011J&\u0010&\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\bJ\u001e\u0010&\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\"2\u0006\u0010\u001c\u001a\u00020\u0011J \u0010'\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\"2\u0006\u0010\u001c\u001a\u00020\u0011H\u0002R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006*"}, d2={"Lokio/FileHandle;", "Ljava/io/Closeable;", "Lokio/Closeable;", "readWrite", "", "(Z)V", "closed", "openStreamCount", "", "getReadWrite", "()Z", "appendingSink", "Lokio/Sink;", "close", "", "flush", "position", "", "sink", "source", "Lokio/Source;", "protectedClose", "protectedFlush", "protectedRead", "fileOffset", "array", "", "arrayOffset", "byteCount", "protectedResize", "size", "protectedSize", "protectedWrite", "read", "Lokio/Buffer;", "readNoCloseCheck", "reposition", "resize", "write", "writeNoCloseCheck", "FileHandleSink", "FileHandleSource", "okio"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class FileHandle
implements Closeable {
    private boolean closed;
    private int openStreamCount;
    private final boolean readWrite;

    public FileHandle(boolean bl) {
        this.readWrite = bl;
    }

    public static final /* synthetic */ boolean access$getClosed$p(FileHandle fileHandle) {
        return fileHandle.closed;
    }

    public static final /* synthetic */ int access$getOpenStreamCount$p(FileHandle fileHandle) {
        return fileHandle.openStreamCount;
    }

    public static final /* synthetic */ long access$readNoCloseCheck(FileHandle fileHandle, long l, Buffer buffer, long l2) {
        return fileHandle.readNoCloseCheck(l, buffer, l2);
    }

    public static final /* synthetic */ void access$setOpenStreamCount$p(FileHandle fileHandle, int n) {
        fileHandle.openStreamCount = n;
    }

    public static final /* synthetic */ void access$writeNoCloseCheck(FileHandle fileHandle, long l, Buffer buffer, long l2) {
        fileHandle.writeNoCloseCheck(l, buffer, l2);
    }

    private final long readNoCloseCheck(long l, Buffer object, long l2) {
        int n = l2 >= 0L ? 1 : 0;
        if (n == 0) {
            object = new IllegalArgumentException(Intrinsics.stringPlus((String)"byteCount < 0: ", (Object)l2).toString());
            throw object;
        }
        long l3 = l + l2;
        l2 = l;
        while (l2 < l3) {
            Segment segment = object.writableSegment$okio(1);
            n = this.protectedRead(l2, segment.data, segment.limit, (int)Math.min(l3 - l2, (long)(8192 - segment.limit)));
            if (n == -1) {
                if (segment.pos == segment.limit) {
                    object.head = segment.pop();
                    SegmentPool.recycle((Segment)segment);
                }
                if (l != l2) return l2 - l;
                return -1L;
            }
            segment.limit += n;
            long l4 = n;
            l2 += l4;
            object.setSize$okio(object.size() + l4);
        }
        return l2 - l;
    }

    public static /* synthetic */ Sink sink$default(FileHandle fileHandle, long l, int n, Object object) throws IOException {
        if (object != null) throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sink");
        if ((n & 1) == 0) return fileHandle.sink(l);
        l = 0L;
        return fileHandle.sink(l);
    }

    public static /* synthetic */ Source source$default(FileHandle fileHandle, long l, int n, Object object) throws IOException {
        if (object != null) throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: source");
        if ((n & 1) == 0) return fileHandle.source(l);
        l = 0L;
        return fileHandle.source(l);
    }

    private final void writeNoCloseCheck(long l, Buffer buffer, long l2) {
        _UtilKt.checkOffsetAndCount((long)buffer.size(), (long)0L, (long)l2);
        long l3 = l2 + l;
        while (l < l3) {
            Segment segment = buffer.head;
            Intrinsics.checkNotNull((Object)segment);
            int n = (int)Math.min(l3 - l, (long)(segment.limit - segment.pos));
            this.protectedWrite(l, segment.data, segment.pos, n);
            segment.pos += n;
            long l4 = n;
            l2 = l + l4;
            buffer.setSize$okio(buffer.size() - l4);
            l = l2;
            if (segment.pos != segment.limit) continue;
            buffer.head = segment.pop();
            SegmentPool.recycle((Segment)segment);
            l = l2;
        }
    }

    public final Sink appendingSink() throws IOException {
        return this.sink(this.size());
    }

    /*
     * Enabled unnecessary exception pruning
     */
    @Override
    public final void close() throws IOException {
        synchronized (this) {
            boolean bl = this.closed;
            if (bl) {
                return;
            }
            this.closed = true;
            int n = this.openStreamCount;
            if (n != 0) {
                return;
            }
            Unit unit = Unit.INSTANCE;
        }
        this.protectedClose();
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public final void flush() throws IOException {
        if (!this.readWrite) throw (Throwable)new IllegalStateException("file handle is read-only".toString());
        synchronized (this) {
            if (this.closed ^ true) {
                Unit unit = Unit.INSTANCE;
                // MONITOREXIT @DISABLED, blocks:[2, 3] lbl5 : MonitorExitStatement: MONITOREXIT : this
                this.protectedFlush();
                return;
            }
            IllegalStateException illegalStateException = new IllegalStateException("closed".toString());
            throw (Throwable)illegalStateException;
        }
    }

    public final boolean getReadWrite() {
        return this.readWrite;
    }

    public final long position(Sink sink) throws IOException {
        long l;
        Intrinsics.checkNotNullParameter((Object)sink, (String)"sink");
        if (sink instanceof RealBufferedSink) {
            sink = (RealBufferedSink)sink;
            l = sink.bufferField.size();
            sink = sink.sink;
        } else {
            l = 0L;
        }
        boolean bl = sink instanceof FileHandleSink && ((FileHandleSink)sink).getFileHandle() == this;
        if (!bl) throw (Throwable)new IllegalArgumentException("sink was not created by this FileHandle".toString());
        if (!((sink = (FileHandleSink)sink).getClosed() ^ true)) throw (Throwable)new IllegalStateException("closed".toString());
        return sink.getPosition() + l;
    }

    public final long position(Source source) throws IOException {
        long l;
        Intrinsics.checkNotNullParameter((Object)source, (String)"source");
        if (source instanceof RealBufferedSource) {
            source = (RealBufferedSource)source;
            l = source.bufferField.size();
            source = source.source;
        } else {
            l = 0L;
        }
        boolean bl = source instanceof FileHandleSource && ((FileHandleSource)source).getFileHandle() == this;
        if (!bl) throw (Throwable)new IllegalArgumentException("source was not created by this FileHandle".toString());
        if (!((source = (FileHandleSource)source).getClosed() ^ true)) throw (Throwable)new IllegalStateException("closed".toString());
        return source.getPosition() - l;
    }

    protected abstract void protectedClose() throws IOException;

    protected abstract void protectedFlush() throws IOException;

    protected abstract int protectedRead(long var1, byte[] var3, int var4, int var5) throws IOException;

    protected abstract void protectedResize(long var1) throws IOException;

    protected abstract long protectedSize() throws IOException;

    protected abstract void protectedWrite(long var1, byte[] var3, int var4, int var5) throws IOException;

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled force condition propagation
     */
    public final int read(long l, byte[] object, int n, int n2) throws IOException {
        Intrinsics.checkNotNullParameter((Object)object, (String)"array");
        synchronized (this) {
            if (this.closed ^ true) {
                Unit unit = Unit.INSTANCE;
                return this.protectedRead(l, (byte[])object, n, n2);
            }
            {
                object = new IllegalStateException;
                object("closed".toString());
                throw (Throwable)object;
            }
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     */
    public final long read(long l, Buffer object, long l2) throws IOException {
        Intrinsics.checkNotNullParameter((Object)object, (String)"sink");
        synchronized (this) {
            if (this.closed ^ true) {
                Unit unit = Unit.INSTANCE;
                return this.readNoCloseCheck(l, (Buffer)object, l2);
            }
            {
                object = new IllegalStateException("closed".toString());
                throw (Throwable)object;
            }
        }
    }

    public final void reposition(Sink sink, long l) throws IOException {
        Intrinsics.checkNotNullParameter((Object)sink, (String)"sink");
        boolean bl = sink instanceof RealBufferedSink;
        boolean bl2 = false;
        boolean bl3 = false;
        if (bl) {
            sink = (RealBufferedSink)sink;
            Sink sink2 = sink.sink;
            boolean bl4 = bl3;
            if (sink2 instanceof FileHandleSink) {
                bl4 = bl3;
                if (((FileHandleSink)sink2).getFileHandle() == this) {
                    bl4 = true;
                }
            }
            if (!bl4) throw (Throwable)new IllegalArgumentException("sink was not created by this FileHandle".toString());
            if (!((sink2 = (FileHandleSink)sink2).getClosed() ^ true)) throw (Throwable)new IllegalStateException("closed".toString());
            sink.emit();
            sink2.setPosition(l);
        } else {
            boolean bl5 = bl2;
            if (sink instanceof FileHandleSink) {
                bl5 = bl2;
                if (((FileHandleSink)sink).getFileHandle() == this) {
                    bl5 = true;
                }
            }
            if (!bl5) throw (Throwable)new IllegalArgumentException("sink was not created by this FileHandle".toString());
            if (!((sink = (FileHandleSink)sink).getClosed() ^ true)) throw (Throwable)new IllegalStateException("closed".toString());
            sink.setPosition(l);
        }
    }

    public final void reposition(Source source, long l) throws IOException {
        Intrinsics.checkNotNullParameter((Object)source, (String)"source");
        boolean bl = source instanceof RealBufferedSource;
        boolean bl2 = false;
        boolean bl3 = false;
        if (bl) {
            source = (RealBufferedSource)source;
            Source source2 = source.source;
            boolean bl4 = source2 instanceof FileHandleSource && ((FileHandleSource)source2).getFileHandle() == this;
            if (!bl4) throw (Throwable)new IllegalArgumentException("source was not created by this FileHandle".toString());
            if (!((source2 = (FileHandleSource)source2).getClosed() ^ true)) throw (Throwable)new IllegalStateException("closed".toString());
            long l2 = source.bufferField.size();
            long l3 = l - (source2.getPosition() - l2);
            bl4 = bl3;
            if (0L <= l3) {
                bl4 = bl3;
                if (l3 < l2) {
                    bl4 = true;
                }
            }
            if (bl4) {
                source.skip(l3);
            } else {
                source.bufferField.clear();
                source2.setPosition(l);
            }
        } else {
            boolean bl5 = bl2;
            if (source instanceof FileHandleSource) {
                bl5 = bl2;
                if (((FileHandleSource)source).getFileHandle() == this) {
                    bl5 = true;
                }
            }
            if (!bl5) throw (Throwable)new IllegalArgumentException("source was not created by this FileHandle".toString());
            if (!((source = (FileHandleSource)source).getClosed() ^ true)) throw (Throwable)new IllegalStateException("closed".toString());
            source.setPosition(l);
        }
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public final void resize(long l) throws IOException {
        if (!this.readWrite) throw (Throwable)new IllegalStateException("file handle is read-only".toString());
        synchronized (this) {
            if (this.closed ^ true) {
                Unit unit = Unit.INSTANCE;
                // MONITOREXIT @DISABLED, blocks:[2, 3] lbl5 : MonitorExitStatement: MONITOREXIT : this
                this.protectedResize(l);
                return;
            }
            IllegalStateException illegalStateException = new IllegalStateException("closed".toString());
            throw (Throwable)illegalStateException;
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled force condition propagation
     */
    public final Sink sink(long l) throws IOException {
        if (!this.readWrite) throw (Throwable)new IllegalStateException("file handle is read-only".toString());
        synchronized (this) {
            if (this.closed ^ true) {
                ++this.openStreamCount;
                return (Sink)new FileHandleSink(this, l);
            }
            {
                IllegalStateException illegalStateException = new IllegalStateException("closed".toString());
                throw (Throwable)illegalStateException;
            }
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled force condition propagation
     */
    public final long size() throws IOException {
        synchronized (this) {
            if (this.closed ^ true) {
                Unit unit = Unit.INSTANCE;
                return this.protectedSize();
            }
            {
                IllegalStateException illegalStateException = new IllegalStateException("closed".toString());
                throw (Throwable)illegalStateException;
            }
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled force condition propagation
     */
    public final Source source(long l) throws IOException {
        synchronized (this) {
            if (this.closed ^ true) {
                ++this.openStreamCount;
                return (Source)new FileHandleSource(this, l);
            }
            {
                IllegalStateException illegalStateException = new IllegalStateException("closed".toString());
                throw (Throwable)illegalStateException;
            }
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     */
    public final void write(long l, Buffer object, long l2) throws IOException {
        Intrinsics.checkNotNullParameter((Object)object, (String)"source");
        if (!this.readWrite) throw (Throwable)new IllegalStateException("file handle is read-only".toString());
        synchronized (this) {
            if (this.closed ^ true) {
                Unit unit = Unit.INSTANCE;
                // MONITOREXIT @DISABLED, blocks:[0, 2, 4] lbl7 : MonitorExitStatement: MONITOREXIT : this
                this.writeNoCloseCheck(l, (Buffer)object, l2);
                return;
            }
            {
                object = new IllegalStateException("closed".toString());
                throw (Throwable)object;
            }
        }
    }

    /*
     * WARNING - void declaration
     * Enabled unnecessary exception pruning
     */
    public final void write(long l, byte[] object, int n, int n2) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"array");
        if (!this.readWrite) throw (Throwable)new IllegalStateException("file handle is read-only".toString());
        synchronized (this) {
            if (this.closed ^ true) {
                void var5_4;
                void var4_3;
                Unit unit = Unit.INSTANCE;
                // MONITOREXIT @DISABLED, blocks:[2, 3] lbl6 : MonitorExitStatement: MONITOREXIT : this
                this.protectedWrite(l, (byte[])object, (int)var4_3, (int)var5_4);
                return;
            }
            object = new IllegalStateException;
            object("closed".toString());
            throw (Throwable)object;
        }
    }
}
