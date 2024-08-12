/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.internal.Intrinsics
 *  okhttp3.internal.Util
 *  okhttp3.internal.cache2.FileOperator
 *  okhttp3.internal.cache2.Relay
 *  okio.Buffer
 *  okio.Source
 *  okio.Timeout
 */
package okhttp3.internal.cache2;

import java.io.Closeable;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;
import okhttp3.internal.cache2.FileOperator;
import okhttp3.internal.cache2.Relay;
import okio.Buffer;
import okio.Source;
import okio.Timeout;

@Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0080\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2={"Lokhttp3/internal/cache2/Relay$RelaySource;", "Lokio/Source;", "(Lokhttp3/internal/cache2/Relay;)V", "fileOperator", "Lokhttp3/internal/cache2/FileOperator;", "sourcePos", "", "timeout", "Lokio/Timeout;", "close", "", "read", "sink", "Lokio/Buffer;", "byteCount", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public final class Relay.RelaySource
implements Source {
    private FileOperator fileOperator;
    private long sourcePos;
    final Relay this$0;
    private final Timeout timeout;

    public Relay.RelaySource(Relay object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"this$0");
        this.this$0 = object;
        this.timeout = new Timeout();
        object = this.this$0.getFile();
        Intrinsics.checkNotNull((Object)object);
        object = ((RandomAccessFile)object).getChannel();
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"file!!.channel");
        this.fileOperator = new FileOperator((FileChannel)object);
    }

    public void close() throws IOException {
        block6: {
            RandomAccessFile randomAccessFile;
            block5: {
                if (this.fileOperator == null) {
                    return;
                }
                randomAccessFile = null;
                this.fileOperator = null;
                Relay relay = this.this$0;
                synchronized (relay) {
                    relay.setSourceCount(relay.getSourceCount() - 1);
                    if (relay.getSourceCount() == 0) {
                        randomAccessFile = relay.getFile();
                        relay.setFile(null);
                    }
                    Unit unit = Unit.INSTANCE;
                    // MONITOREXIT @DISABLED, blocks:[0, 1] lbl13 : MonitorExitStatement: MONITOREXIT : var2_3
                    if (randomAccessFile != null) break block5;
                    break block6;
                }
            }
            Util.closeQuietly((Closeable)randomAccessFile);
        }
    }

    /*
     * Enabled unnecessary exception pruning
     * Converted monitor instructions to comments
     */
    public long read(Buffer object, long l) throws IOException {
        long l2;
        long l3;
        FileOperator fileOperator;
        block23: {
            int n;
            block22: {
                Intrinsics.checkNotNullParameter((Object)object, (String)"sink");
                fileOperator = this.fileOperator;
                int n2 = 1;
                n = fileOperator != null ? 1 : 0;
                if (n == 0) {
                    object = new IllegalStateException("Check failed.".toString());
                    throw object;
                }
                fileOperator = this.this$0;
                // MONITORENTER : fileOperator
                while (true) {
                    if (this.sourcePos != (l3 = fileOperator.getUpstreamPos())) {
                        l3 = fileOperator.getUpstreamPos() - fileOperator.getBuffer().size();
                        if (this.sourcePos >= l3) {
                            l2 = Math.min(l2, fileOperator.getUpstreamPos() - this.sourcePos);
                            fileOperator.getBuffer().copyTo(object, this.sourcePos - l3, l2);
                            this.sourcePos += l2;
                            // MONITOREXIT : fileOperator
                            return l2;
                        }
                        n = 2;
                        break block22;
                    }
                    boolean bl = fileOperator.getComplete();
                    if (bl) {
                        // MONITOREXIT : fileOperator
                        return -1L;
                    }
                    if (fileOperator.getUpstreamReader() == null) break;
                    this.timeout.waitUntilNotified((Object)fileOperator);
                }
                fileOperator.setUpstreamReader(Thread.currentThread());
                n = n2;
            }
            // MONITOREXIT : fileOperator
            if (n == 2) {
                l2 = Math.min(l2, this.this$0.getUpstreamPos() - this.sourcePos);
                fileOperator = this.fileOperator;
                Intrinsics.checkNotNull((Object)fileOperator);
                fileOperator.read(this.sourcePos + 32L, object, l2);
                this.sourcePos += l2;
                return l2;
            }
            try {
                fileOperator = this.this$0.getUpstream();
                Intrinsics.checkNotNull((Object)fileOperator);
                l3 = fileOperator.read(this.this$0.getUpstreamBuffer(), this.this$0.getBufferMaxSize());
                if (l3 != -1L) break block23;
                this.this$0.commit(this.this$0.getUpstreamPos());
                object = this.this$0;
            }
            catch (Throwable throwable) {
                object = this.this$0;
                // MONITORENTER : object
                object.setUpstreamReader(null);
                ((Object)object).notifyAll();
                Unit unit = Unit.INSTANCE;
                // MONITOREXIT : object
                throw throwable;
            }
            object.setUpstreamReader(null);
            ((Object)object).notifyAll();
            fileOperator = Unit.INSTANCE;
            // MONITOREXIT : object
            return -1L;
        }
        l2 = Math.min(l3, l2);
        this.this$0.getUpstreamBuffer().copyTo(object, 0L, l2);
        this.sourcePos += l2;
        object = this.fileOperator;
        Intrinsics.checkNotNull((Object)object);
        object.write(this.this$0.getUpstreamPos() + 32L, this.this$0.getUpstreamBuffer().clone(), l3);
        object = this.this$0;
        fileOperator = this.this$0;
        // MONITORENTER : object
        fileOperator.getBuffer().write(fileOperator.getUpstreamBuffer(), l3);
        if (fileOperator.getBuffer().size() > fileOperator.getBufferMaxSize()) {
            fileOperator.getBuffer().skip(fileOperator.getBuffer().size() - fileOperator.getBufferMaxSize());
        }
        fileOperator.setUpstreamPos(fileOperator.getUpstreamPos() + l3);
        fileOperator = Unit.INSTANCE;
        // MONITOREXIT : object
        object = this.this$0;
        // MONITORENTER : object
        object.setUpstreamReader(null);
        ((Object)object).notifyAll();
        fileOperator = Unit.INSTANCE;
        // MONITOREXIT : object
        return l2;
    }

    public Timeout timeout() {
        return this.timeout;
    }
}
