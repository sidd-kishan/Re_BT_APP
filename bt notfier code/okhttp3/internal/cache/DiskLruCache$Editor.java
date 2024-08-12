/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  okhttp3.internal.cache.DiskLruCache
 *  okhttp3.internal.cache.DiskLruCache$Editor$newSink$1$1
 *  okhttp3.internal.cache.DiskLruCache$Entry
 *  okhttp3.internal.cache.FaultHidingSink
 *  okio.Okio
 *  okio.Path
 *  okio.Sink
 *  okio.Source
 */
package okhttp3.internal.cache;

import java.io.FileNotFoundException;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.cache.DiskLruCache;
import okhttp3.internal.cache.FaultHidingSink;
import okio.Okio;
import okio.Path;
import okio.Sink;
import okio.Source;

/*
 * Exception performing whole class analysis ignored.
 */
@Metadata(d1={"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0018\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0013\b\u0000\u0012\n\u0010\u0002\u001a\u00060\u0003R\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\u000fJ\r\u0010\u0011\u001a\u00020\u000fH\u0000\u00a2\u0006\u0002\b\u0012J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0015\u001a\u00020\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0018\u0010\u0002\u001a\u00060\u0003R\u00020\u0004X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0019"}, d2={"Lokhttp3/internal/cache/DiskLruCache$Editor;", "", "entry", "Lokhttp3/internal/cache/DiskLruCache$Entry;", "Lokhttp3/internal/cache/DiskLruCache;", "(Lokhttp3/internal/cache/DiskLruCache;Lokhttp3/internal/cache/DiskLruCache$Entry;)V", "done", "", "getEntry$okhttp", "()Lokhttp3/internal/cache/DiskLruCache$Entry;", "written", "", "getWritten$okhttp", "()[Z", "abort", "", "commit", "detach", "detach$okhttp", "newSink", "Lokio/Sink;", "index", "", "newSource", "Lokio/Source;", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public final class DiskLruCache.Editor {
    private boolean done;
    private final DiskLruCache.Entry entry;
    final DiskLruCache this$0;
    private final boolean[] written;

    public DiskLruCache.Editor(DiskLruCache object, DiskLruCache.Entry entry) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"this$0");
        Intrinsics.checkNotNullParameter((Object)entry, (String)"entry");
        this.this$0 = object;
        this.entry = entry;
        object = entry.getReadable$okhttp() ? null : (Object)new boolean[this.this$0.getValueCount$okhttp()];
        this.written = (boolean[])object;
    }

    public final void abort() throws IOException {
        DiskLruCache diskLruCache = this.this$0;
        synchronized (diskLruCache) {
            if (!(this.done ^ true)) {
                IllegalStateException illegalStateException = new IllegalStateException("Check failed.".toString());
                throw (Throwable)illegalStateException;
            }
            if (Intrinsics.areEqual((Object)this.getEntry$okhttp().getCurrentEditor$okhttp(), (Object)this)) {
                diskLruCache.completeEdit$okhttp(this, false);
            }
            this.done = true;
            Unit unit = Unit.INSTANCE;
            return;
        }
    }

    public final void commit() throws IOException {
        DiskLruCache diskLruCache = this.this$0;
        synchronized (diskLruCache) {
            if (!(this.done ^ true)) {
                IllegalStateException illegalStateException = new IllegalStateException("Check failed.".toString());
                throw (Throwable)illegalStateException;
            }
            if (Intrinsics.areEqual((Object)this.getEntry$okhttp().getCurrentEditor$okhttp(), (Object)this)) {
                diskLruCache.completeEdit$okhttp(this, true);
            }
            this.done = true;
            Unit unit = Unit.INSTANCE;
            return;
        }
    }

    public final void detach$okhttp() {
        if (!Intrinsics.areEqual((Object)this.entry.getCurrentEditor$okhttp(), (Object)this)) return;
        if (DiskLruCache.access$getCivilizedFileSystem$p((DiskLruCache)this.this$0)) {
            this.this$0.completeEdit$okhttp(this, false);
        } else {
            this.entry.setZombie$okhttp(true);
        }
    }

    public final DiskLruCache.Entry getEntry$okhttp() {
        return this.entry;
    }

    public final boolean[] getWritten$okhttp() {
        return this.written;
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public final Sink newSink(int n) {
        DiskLruCache diskLruCache = this.this$0;
        synchronized (diskLruCache) {
            Sink sink;
            if (!(this.done ^ true)) {
                IllegalStateException illegalStateException = new IllegalStateException("Check failed.".toString());
                throw (Throwable)illegalStateException;
            }
            if (!Intrinsics.areEqual((Object)this.getEntry$okhttp().getCurrentEditor$okhttp(), (Object)this)) {
                return Okio.blackhole();
            }
            if (!this.getEntry$okhttp().getReadable$okhttp()) {
                boolean[] blArray = this.getWritten$okhttp();
                Intrinsics.checkNotNull((Object)blArray);
                blArray[n] = true;
            }
            Path path = (Path)this.getEntry$okhttp().getDirtyFiles$okhttp().get(n);
            try {
                sink = diskLruCache.getFileSystem$okhttp().sink(path);
            }
            catch (FileNotFoundException fileNotFoundException) {
                return Okio.blackhole();
            }
            newSink.1.1 var3_6 = new /* Unavailable Anonymous Inner Class!! */;
            FaultHidingSink faultHidingSink = new FaultHidingSink(sink, (Function1)var3_6);
            return (Sink)faultHidingSink;
        }
    }

    public final Source newSource(int n) {
        DiskLruCache diskLruCache = this.this$0;
        synchronized (diskLruCache) {
            if (this.done ^ true) {
                Source source;
                if (!this.getEntry$okhttp().getReadable$okhttp()) return null;
                if (!Intrinsics.areEqual((Object)this.getEntry$okhttp().getCurrentEditor$okhttp(), (Object)this)) return null;
                boolean bl = this.getEntry$okhttp().getZombie$okhttp();
                if (bl) {
                    return null;
                }
                try {
                    source = diskLruCache.getFileSystem$okhttp().source((Path)this.getEntry$okhttp().getCleanFiles$okhttp().get(n));
                }
                catch (FileNotFoundException fileNotFoundException) {
                    source = null;
                }
                return source;
            }
            IllegalStateException illegalStateException = new IllegalStateException("Check failed.".toString());
            throw (Throwable)illegalStateException;
        }
    }
}
