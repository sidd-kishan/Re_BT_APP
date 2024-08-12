/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.internal.Intrinsics
 *  okio.Buffer
 *  okio.FileHandle
 *  okio.Sink
 *  okio.Timeout
 */
package okio;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.FileHandle;
import okio.Sink;
import okio.Timeout;

/*
 * Exception performing whole class analysis ignored.
 */
@Metadata(d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u0018\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0005H\u0016R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012\u00a8\u0006\u001c"}, d2={"Lokio/FileHandle$FileHandleSink;", "Lokio/Sink;", "fileHandle", "Lokio/FileHandle;", "position", "", "(Lokio/FileHandle;J)V", "closed", "", "getClosed", "()Z", "setClosed", "(Z)V", "getFileHandle", "()Lokio/FileHandle;", "getPosition", "()J", "setPosition", "(J)V", "close", "", "flush", "timeout", "Lokio/Timeout;", "write", "source", "Lokio/Buffer;", "byteCount", "okio"}, k=1, mv={1, 5, 1}, xi=48)
private static final class FileHandle.FileHandleSink
implements Sink {
    private boolean closed;
    private final FileHandle fileHandle;
    private long position;

    public FileHandle.FileHandleSink(FileHandle fileHandle, long l) {
        Intrinsics.checkNotNullParameter((Object)fileHandle, (String)"fileHandle");
        this.fileHandle = fileHandle;
        this.position = l;
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public void close() {
        if (this.closed) {
            return;
        }
        this.closed = true;
        FileHandle fileHandle = this.fileHandle;
        synchronized (fileHandle) {
            FileHandle fileHandle2 = this.getFileHandle();
            FileHandle.access$setOpenStreamCount$p((FileHandle)fileHandle2, (int)(FileHandle.access$getOpenStreamCount$p((FileHandle)fileHandle2) - 1));
            if (FileHandle.access$getOpenStreamCount$p((FileHandle)this.getFileHandle()) != 0) return;
            if (!FileHandle.access$getClosed$p((FileHandle)this.getFileHandle())) {
                return;
            }
            fileHandle2 = Unit.INSTANCE;
        }
        this.fileHandle.protectedClose();
    }

    public void flush() {
        if (!(this.closed ^ true)) throw (Throwable)new IllegalStateException("closed".toString());
        this.fileHandle.protectedFlush();
    }

    public final boolean getClosed() {
        return this.closed;
    }

    public final FileHandle getFileHandle() {
        return this.fileHandle;
    }

    public final long getPosition() {
        return this.position;
    }

    public final void setClosed(boolean bl) {
        this.closed = bl;
    }

    public final void setPosition(long l) {
        this.position = l;
    }

    public Timeout timeout() {
        return Timeout.NONE;
    }

    public void write(Buffer buffer, long l) {
        Intrinsics.checkNotNullParameter((Object)buffer, (String)"source");
        if (!(this.closed ^ true)) throw (Throwable)new IllegalStateException("closed".toString());
        FileHandle.access$writeNoCloseCheck((FileHandle)this.fileHandle, (long)this.position, (Buffer)buffer, (long)l);
        this.position += l;
    }
}
