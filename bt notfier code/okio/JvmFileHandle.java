/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  okio.FileHandle
 */
package okio;

import java.io.RandomAccessFile;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.FileHandle;

@Metadata(d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0014J\b\u0010\t\u001a\u00020\bH\u0014J(\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000bH\u0014J\u0010\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\rH\u0014J\b\u0010\u0014\u001a\u00020\rH\u0014J(\u0010\u0015\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000bH\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2={"Lokio/JvmFileHandle;", "Lokio/FileHandle;", "readWrite", "", "randomAccessFile", "Ljava/io/RandomAccessFile;", "(ZLjava/io/RandomAccessFile;)V", "protectedClose", "", "protectedFlush", "protectedRead", "", "fileOffset", "", "array", "", "arrayOffset", "byteCount", "protectedResize", "size", "protectedSize", "protectedWrite", "okio"}, k=1, mv={1, 5, 1}, xi=48)
public final class JvmFileHandle
extends FileHandle {
    private final RandomAccessFile randomAccessFile;

    public JvmFileHandle(boolean bl, RandomAccessFile randomAccessFile) {
        Intrinsics.checkNotNullParameter((Object)randomAccessFile, (String)"randomAccessFile");
        super(bl);
        this.randomAccessFile = randomAccessFile;
    }

    protected void protectedClose() {
        synchronized (this) {
            this.randomAccessFile.close();
            return;
        }
    }

    protected void protectedFlush() {
        synchronized (this) {
            this.randomAccessFile.getFD().sync();
            return;
        }
    }

    /*
     * Enabled unnecessary exception pruning
     */
    protected int protectedRead(long l, byte[] byArray, int n, int n2) {
        synchronized (this) {
            Intrinsics.checkNotNullParameter((Object)byArray, (String)"array");
            this.randomAccessFile.seek(l);
            int n3 = 0;
            while (n3 < n2) {
                int n4 = this.randomAccessFile.read(byArray, n, n2 - n3);
                if (n4 == -1) {
                    if (n3 != 0) return n3;
                    return -1;
                }
                n3 += n4;
            }
            return n3;
        }
    }

    /*
     * Enabled unnecessary exception pruning
     */
    protected void protectedResize(long l) {
        synchronized (this) {
            long l2 = this.size();
            long l3 = l - l2;
            if (l3 > 0L) {
                int n = (int)l3;
                this.protectedWrite(l2, new byte[n], 0, n);
            } else {
                this.randomAccessFile.setLength(l);
            }
            return;
        }
    }

    protected long protectedSize() {
        synchronized (this) {
            long l = this.randomAccessFile.length();
            return l;
        }
    }

    protected void protectedWrite(long l, byte[] byArray, int n, int n2) {
        synchronized (this) {
            Intrinsics.checkNotNullParameter((Object)byArray, (String)"array");
            this.randomAccessFile.seek(l);
            this.randomAccessFile.write(byArray, n, n2);
            return;
        }
    }
}
