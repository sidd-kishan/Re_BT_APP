/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.KotlinNothingValueException
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  okhttp3.internal.Util
 *  okhttp3.internal.cache.DiskLruCache
 *  okhttp3.internal.cache.DiskLruCache$Editor
 *  okhttp3.internal.cache.DiskLruCache$Snapshot
 *  okio.BufferedSink
 *  okio.Path
 *  okio.Source
 */
package okhttp3.internal.cache;

import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;
import okhttp3.internal.cache.DiskLruCache;
import okio.BufferedSink;
import okio.Path;
import okio.Source;

/*
 * Exception performing whole class analysis ignored.
 */
@Metadata(d1={"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0016\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0080\u0004\u0018\u00002\u00020\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010.\u001a\u00020/2\f\u00100\u001a\b\u0012\u0004\u0012\u00020\u000301H\u0002J\u0010\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\u001aH\u0002J\u001b\u00105\u001a\u0002062\f\u00100\u001a\b\u0012\u0004\u0012\u00020\u000301H\u0000\u00a2\u0006\u0002\b7J\u0013\u00108\u001a\b\u0018\u000109R\u00020\fH\u0000\u00a2\u0006\u0002\b:J\u0015\u0010;\u001a\u0002062\u0006\u0010<\u001a\u00020=H\u0000\u00a2\u0006\u0002\b>R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR \u0010\n\u001a\b\u0018\u00010\u000bR\u00020\fX\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\tR\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u0016X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u001aX\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020 X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010%\u001a\u00020&X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001a\u0010+\u001a\u00020 X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\"\"\u0004\b-\u0010$\u00a8\u0006?"}, d2={"Lokhttp3/internal/cache/DiskLruCache$Entry;", "", "key", "", "(Lokhttp3/internal/cache/DiskLruCache;Ljava/lang/String;)V", "cleanFiles", "", "Lokio/Path;", "getCleanFiles$okhttp", "()Ljava/util/List;", "currentEditor", "Lokhttp3/internal/cache/DiskLruCache$Editor;", "Lokhttp3/internal/cache/DiskLruCache;", "getCurrentEditor$okhttp", "()Lokhttp3/internal/cache/DiskLruCache$Editor;", "setCurrentEditor$okhttp", "(Lokhttp3/internal/cache/DiskLruCache$Editor;)V", "dirtyFiles", "getDirtyFiles$okhttp", "getKey$okhttp", "()Ljava/lang/String;", "lengths", "", "getLengths$okhttp", "()[J", "lockingSourceCount", "", "getLockingSourceCount$okhttp", "()I", "setLockingSourceCount$okhttp", "(I)V", "readable", "", "getReadable$okhttp", "()Z", "setReadable$okhttp", "(Z)V", "sequenceNumber", "", "getSequenceNumber$okhttp", "()J", "setSequenceNumber$okhttp", "(J)V", "zombie", "getZombie$okhttp", "setZombie$okhttp", "invalidLengths", "", "strings", "", "newSource", "Lokio/Source;", "index", "setLengths", "", "setLengths$okhttp", "snapshot", "Lokhttp3/internal/cache/DiskLruCache$Snapshot;", "snapshot$okhttp", "writeLengths", "writer", "Lokio/BufferedSink;", "writeLengths$okhttp", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public final class DiskLruCache.Entry {
    private final List<Path> cleanFiles;
    private DiskLruCache.Editor currentEditor;
    private final List<Path> dirtyFiles;
    private final String key;
    private final long[] lengths;
    private int lockingSourceCount;
    private boolean readable;
    private long sequenceNumber;
    final DiskLruCache this$0;
    private boolean zombie;

    public DiskLruCache.Entry(DiskLruCache object, String object2) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"this$0");
        Intrinsics.checkNotNullParameter((Object)object2, (String)"key");
        this.this$0 = object;
        this.key = object2;
        this.lengths = new long[this.this$0.getValueCount$okhttp()];
        this.cleanFiles = new ArrayList();
        this.dirtyFiles = new ArrayList();
        object = new StringBuilder(this.key);
        ((StringBuilder)object).append('.');
        int n = ((StringBuilder)object).length();
        int n2 = this.this$0.getValueCount$okhttp();
        if (n2 <= 0) return;
        int n3 = 0;
        while (true) {
            int n4 = n3 + 1;
            ((StringBuilder)object).append(n3);
            Collection collection = this.cleanFiles;
            Object object3 = this.this$0.getDirectory();
            object2 = ((StringBuilder)object).toString();
            Intrinsics.checkNotNullExpressionValue((Object)object2, (String)"fileBuilder.toString()");
            collection.add(object3.resolve((String)object2));
            ((StringBuilder)object).append(".tmp");
            object2 = this.dirtyFiles;
            collection = this.this$0.getDirectory();
            object3 = ((StringBuilder)object).toString();
            Intrinsics.checkNotNullExpressionValue((Object)object3, (String)"fileBuilder.toString()");
            object2.add(collection.resolve((String)object3));
            ((StringBuilder)object).setLength(n);
            if (n4 >= n2) {
                return;
            }
            n3 = n4;
        }
    }

    private final Void invalidLengths(List<String> list) throws IOException {
        throw new IOException(Intrinsics.stringPlus((String)"unexpected journal line: ", list));
    }

    private final Source newSource(int n) {
        Source source = this.this$0.getFileSystem$okhttp().source(this.cleanFiles.get(n));
        if (DiskLruCache.access$getCivilizedFileSystem$p((DiskLruCache)this.this$0)) {
            return source;
        }
        ++this.lockingSourceCount;
        return (Source)new /* Unavailable Anonymous Inner Class!! */;
    }

    public final List<Path> getCleanFiles$okhttp() {
        return this.cleanFiles;
    }

    public final DiskLruCache.Editor getCurrentEditor$okhttp() {
        return this.currentEditor;
    }

    public final List<Path> getDirtyFiles$okhttp() {
        return this.dirtyFiles;
    }

    public final String getKey$okhttp() {
        return this.key;
    }

    public final long[] getLengths$okhttp() {
        return this.lengths;
    }

    public final int getLockingSourceCount$okhttp() {
        return this.lockingSourceCount;
    }

    public final boolean getReadable$okhttp() {
        return this.readable;
    }

    public final long getSequenceNumber$okhttp() {
        return this.sequenceNumber;
    }

    public final boolean getZombie$okhttp() {
        return this.zombie;
    }

    public final void setCurrentEditor$okhttp(DiskLruCache.Editor editor) {
        this.currentEditor = editor;
    }

    public final void setLengths$okhttp(List<String> kotlinNothingValueException) throws IOException {
        Intrinsics.checkNotNullParameter(kotlinNothingValueException, (String)"strings");
        if (kotlinNothingValueException.size() != this.this$0.getValueCount$okhttp()) {
            this.invalidLengths((List<String>)kotlinNothingValueException);
            kotlinNothingValueException = new KotlinNothingValueException();
            throw kotlinNothingValueException;
        }
        int n = 0;
        try {
            int n2 = kotlinNothingValueException.size() - 1;
            if (n2 < 0) return;
            while (true) {
                int n3 = n + 1;
                this.lengths[n] = Long.parseLong((String)kotlinNothingValueException.get(n));
                if (n3 > n2) {
                    return;
                }
                n = n3;
            }
        }
        catch (NumberFormatException numberFormatException) {
            this.invalidLengths((List<String>)kotlinNothingValueException);
            throw new KotlinNothingValueException();
        }
    }

    public final void setLockingSourceCount$okhttp(int n) {
        this.lockingSourceCount = n;
    }

    public final void setReadable$okhttp(boolean bl) {
        this.readable = bl;
    }

    public final void setSequenceNumber$okhttp(long l) {
        this.sequenceNumber = l;
    }

    public final void setZombie$okhttp(boolean bl) {
        this.zombie = bl;
    }

    /*
     * Enabled force condition propagation
     */
    public final DiskLruCache.Snapshot snapshot$okhttp() {
        DiskLruCache diskLruCache = this.this$0;
        if (Util.assertionsEnabled && !Thread.holdsLock(diskLruCache)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Thread ");
            stringBuilder.append((Object)Thread.currentThread().getName());
            stringBuilder.append(" MUST hold lock on ");
            stringBuilder.append(diskLruCache);
            throw new AssertionError((Object)stringBuilder.toString());
        }
        if (!this.readable) {
            return null;
        }
        if (!DiskLruCache.access$getCivilizedFileSystem$p((DiskLruCache)this.this$0)) {
            if (this.currentEditor != null) return null;
            if (this.zombie) {
                return null;
            }
        }
        Object object = new ArrayList();
        long[] lArray = (long[])this.lengths.clone();
        int n = 0;
        try {
            int n2 = this.this$0.getValueCount$okhttp();
            if (n2 <= 0) return new DiskLruCache.Snapshot(this.this$0, this.key, this.sequenceNumber, (List)object, lArray);
            while (true) {
                int n3 = n + 1;
                ((Collection)object).add(this.newSource(n));
                if (n3 >= n2) return new DiskLruCache.Snapshot(this.this$0, this.key, this.sequenceNumber, (List)object, lArray);
                n = n3;
            }
        }
        catch (FileNotFoundException fileNotFoundException) {
            object = object.iterator();
            while (object.hasNext()) {
                Util.closeQuietly((Closeable)((Closeable)((Source)object.next())));
            }
            try {
                this.this$0.removeEntry$okhttp(this);
                return null;
            }
            catch (IOException iOException) {
                return null;
            }
        }
    }

    public final void writeLengths$okhttp(BufferedSink bufferedSink) throws IOException {
        Intrinsics.checkNotNullParameter((Object)bufferedSink, (String)"writer");
        long[] lArray = this.lengths;
        int n = lArray.length;
        int n2 = 0;
        while (n2 < n) {
            long l = lArray[n2];
            ++n2;
            bufferedSink.writeByte(32).writeDecimalLong(l);
        }
    }
}
