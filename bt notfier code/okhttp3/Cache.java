/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.DeprecationLevel
 *  kotlin.Metadata
 *  kotlin.ReplaceWith
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.Intrinsics
 *  okhttp3.Cache$CacheResponseBody
 *  okhttp3.Cache$Companion
 *  okhttp3.Cache$Entry
 *  okhttp3.Cache$RealCacheRequest
 *  okhttp3.HttpUrl
 *  okhttp3.Request
 *  okhttp3.Response
 *  okhttp3.internal.Util
 *  okhttp3.internal.cache.CacheRequest
 *  okhttp3.internal.cache.CacheStrategy
 *  okhttp3.internal.cache.DiskLruCache
 *  okhttp3.internal.cache.DiskLruCache$Editor
 *  okhttp3.internal.cache.DiskLruCache$Snapshot
 *  okhttp3.internal.concurrent.TaskRunner
 *  okhttp3.internal.http.HttpMethod
 *  okio.FileSystem
 *  okio.Path
 *  okio.Path$Companion
 */
package okhttp3;

import java.io.Closeable;
import java.io.File;
import java.io.Flushable;
import java.io.IOException;
import java.util.Iterator;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Cache;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.cache.CacheRequest;
import okhttp3.internal.cache.CacheStrategy;
import okhttp3.internal.cache.DiskLruCache;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.http.HttpMethod;
import okio.FileSystem;
import okio.Path;

@Metadata(d1={"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010)\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 F2\u00020\u00012\u00020\u0002:\u0004EFGHB\u0017\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\b\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\n\u00a2\u0006\u0002\u0010\u000bJ\u0016\u0010\"\u001a\u00020#2\f\u0010$\u001a\b\u0018\u00010%R\u00020\rH\u0002J\b\u0010&\u001a\u00020#H\u0016J\u0006\u0010'\u001a\u00020#J\r\u0010\u0003\u001a\u00020\u0004H\u0007\u00a2\u0006\u0002\b(J\u0006\u0010)\u001a\u00020#J\b\u0010*\u001a\u00020#H\u0016J\u0017\u0010+\u001a\u0004\u0018\u00010,2\u0006\u0010-\u001a\u00020.H\u0000\u00a2\u0006\u0002\b/J\u0006\u0010\u0013\u001a\u00020\u0014J\u0006\u00100\u001a\u00020#J\u0006\u0010\u0005\u001a\u00020\u0006J\u0006\u0010\u0018\u001a\u00020\u0014J\u0017\u00101\u001a\u0004\u0018\u0001022\u0006\u00103\u001a\u00020,H\u0000\u00a2\u0006\u0002\b4J\u0015\u00105\u001a\u00020#2\u0006\u0010-\u001a\u00020.H\u0000\u00a2\u0006\u0002\b6J\u0006\u0010\u0019\u001a\u00020\u0014J\u0006\u00107\u001a\u00020\u0006J\r\u00108\u001a\u00020#H\u0000\u00a2\u0006\u0002\b9J\u0015\u0010:\u001a\u00020#2\u0006\u0010;\u001a\u00020<H\u0000\u00a2\u0006\u0002\b=J\u001d\u0010>\u001a\u00020#2\u0006\u0010?\u001a\u00020,2\u0006\u0010@\u001a\u00020,H\u0000\u00a2\u0006\u0002\bAJ\f\u0010B\u001a\b\u0012\u0004\u0012\u00020D0CJ\u0006\u0010\u001a\u001a\u00020\u0014J\u0006\u0010\u001f\u001a\u00020\u0014R\u0014\u0010\f\u001a\u00020\rX\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0003\u001a\u00020\u00048G\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\b8G\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0015\u001a\u00020\u00168F\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u001a\u001a\u00020\u0014X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020\u0014X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001c\"\u0004\b!\u0010\u001e\u00a8\u0006I"}, d2={"Lokhttp3/Cache;", "Ljava/io/Closeable;", "Ljava/io/Flushable;", "directory", "Ljava/io/File;", "maxSize", "", "(Ljava/io/File;J)V", "Lokio/Path;", "fileSystem", "Lokio/FileSystem;", "(Lokio/Path;JLokio/FileSystem;)V", "cache", "Lokhttp3/internal/cache/DiskLruCache;", "getCache$okhttp", "()Lokhttp3/internal/cache/DiskLruCache;", "()Ljava/io/File;", "directoryPath", "()Lokio/Path;", "hitCount", "", "isClosed", "", "()Z", "networkCount", "requestCount", "writeAbortCount", "getWriteAbortCount$okhttp", "()I", "setWriteAbortCount$okhttp", "(I)V", "writeSuccessCount", "getWriteSuccessCount$okhttp", "setWriteSuccessCount$okhttp", "abortQuietly", "", "editor", "Lokhttp3/internal/cache/DiskLruCache$Editor;", "close", "delete", "-deprecated_directory", "evictAll", "flush", "get", "Lokhttp3/Response;", "request", "Lokhttp3/Request;", "get$okhttp", "initialize", "put", "Lokhttp3/internal/cache/CacheRequest;", "response", "put$okhttp", "remove", "remove$okhttp", "size", "trackConditionalCacheHit", "trackConditionalCacheHit$okhttp", "trackResponse", "cacheStrategy", "Lokhttp3/internal/cache/CacheStrategy;", "trackResponse$okhttp", "update", "cached", "network", "update$okhttp", "urls", "", "", "CacheResponseBody", "Companion", "Entry", "RealCacheRequest", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public final class Cache
implements Closeable,
Flushable {
    public static final Companion Companion = new Companion(null);
    private static final int ENTRY_BODY = 1;
    private static final int ENTRY_COUNT = 2;
    private static final int ENTRY_METADATA = 0;
    private static final int VERSION = 201105;
    private final DiskLruCache cache;
    private int hitCount;
    private int networkCount;
    private int requestCount;
    private int writeAbortCount;
    private int writeSuccessCount;

    public Cache(File file, long l) {
        Intrinsics.checkNotNullParameter((Object)file, (String)"directory");
        this(Path.Companion.get$default((Path.Companion)Path.Companion, (File)file, (boolean)false, (int)1, null), l, FileSystem.SYSTEM);
    }

    public Cache(Path path, long l, FileSystem fileSystem) {
        Intrinsics.checkNotNullParameter((Object)path, (String)"directory");
        Intrinsics.checkNotNullParameter((Object)fileSystem, (String)"fileSystem");
        this.cache = new DiskLruCache(fileSystem, path, 201105, 2, l, TaskRunner.INSTANCE);
    }

    /*
     * Enabled force condition propagation
     */
    private final void abortQuietly(DiskLruCache.Editor editor) {
        if (editor == null) {
            return;
        }
        try {
            editor.abort();
            return;
        }
        catch (IOException iOException) {
            return;
        }
    }

    @JvmStatic
    public static final String key(HttpUrl httpUrl) {
        return Companion.key(httpUrl);
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="directory", imports={}))
    public final File _deprecated_directory() {
        return this.cache.getDirectory().toFile();
    }

    @Override
    public void close() throws IOException {
        this.cache.close();
    }

    public final void delete() throws IOException {
        this.cache.delete();
    }

    public final File directory() {
        return this.cache.getDirectory().toFile();
    }

    public final Path directoryPath() {
        return this.cache.getDirectory();
    }

    public final void evictAll() throws IOException {
        this.cache.evictAll();
    }

    @Override
    public void flush() throws IOException {
        this.cache.flush();
    }

    /*
     * Enabled force condition propagation
     */
    public final Response get$okhttp(Request request) {
        DiskLruCache.Snapshot snapshot;
        Intrinsics.checkNotNullParameter((Object)request, (String)"request");
        String string = Companion.key(request.url());
        try {
            snapshot = this.cache.get(string);
            if (snapshot == null) {
                return null;
            }
        }
        catch (IOException iOException) {
            return null;
        }
        try {
            string = new Entry(snapshot.getSource(0));
        }
        catch (IOException iOException) {
            Util.closeQuietly((Closeable)((Closeable)snapshot));
            return null;
        }
        snapshot = string.response(snapshot);
        if (string.matches(request, (Response)snapshot)) return snapshot;
        request = snapshot.body();
        if (request == null) {
            return null;
        }
        Util.closeQuietly((Closeable)((Closeable)request));
        return null;
    }

    public final DiskLruCache getCache$okhttp() {
        return this.cache;
    }

    public final int getWriteAbortCount$okhttp() {
        return this.writeAbortCount;
    }

    public final int getWriteSuccessCount$okhttp() {
        return this.writeSuccessCount;
    }

    public final int hitCount() {
        synchronized (this) {
            int n = this.hitCount;
            return n;
        }
    }

    public final void initialize() throws IOException {
        this.cache.initialize();
    }

    public final boolean isClosed() {
        return this.cache.isClosed();
    }

    public final long maxSize() {
        return this.cache.getMaxSize();
    }

    public final int networkCount() {
        synchronized (this) {
            int n = this.networkCount;
            return n;
        }
    }

    /*
     * Loose catch block
     * Enabled unnecessary exception pruning
     */
    public final CacheRequest put$okhttp(Response response) {
        String string;
        block9: {
            Intrinsics.checkNotNullParameter((Object)response, (String)"response");
            string = response.request().method();
            if (HttpMethod.INSTANCE.invalidatesCache(response.request().method())) {
                this.remove$okhttp(response.request());
                return null;
            }
            if (!Intrinsics.areEqual((Object)string, (Object)"GET")) {
                return null;
            }
            if (Companion.hasVaryAll(response)) {
                return null;
            }
            string = new Entry(response);
            response = DiskLruCache.edit$default((DiskLruCache)this.cache, (String)Companion.key(response.request().url()), (long)0L, (int)2, null);
            if (response != null) break block9;
            return null;
        }
        string.writeTo((DiskLruCache.Editor)response);
        string = new RealCacheRequest(this, (DiskLruCache.Editor)response);
        return (CacheRequest)string;
        {
            catch (IOException iOException) {}
        }
        catch (IOException iOException) {
            block10: {
                response = null;
                break block10;
                catch (IOException iOException2) {
                    return null;
                }
            }
            this.abortQuietly((DiskLruCache.Editor)response);
            return null;
        }
    }

    public final void remove$okhttp(Request request) throws IOException {
        Intrinsics.checkNotNullParameter((Object)request, (String)"request");
        this.cache.remove(Companion.key(request.url()));
    }

    public final int requestCount() {
        synchronized (this) {
            int n = this.requestCount;
            return n;
        }
    }

    public final void setWriteAbortCount$okhttp(int n) {
        this.writeAbortCount = n;
    }

    public final void setWriteSuccessCount$okhttp(int n) {
        this.writeSuccessCount = n;
    }

    public final long size() throws IOException {
        return this.cache.size();
    }

    public final void trackConditionalCacheHit$okhttp() {
        synchronized (this) {
            ++this.hitCount;
            return;
        }
    }

    public final void trackResponse$okhttp(CacheStrategy cacheStrategy) {
        synchronized (this) {
            Intrinsics.checkNotNullParameter((Object)cacheStrategy, (String)"cacheStrategy");
            ++this.requestCount;
            if (cacheStrategy.getNetworkRequest() != null) {
                ++this.networkCount;
            } else {
                if (cacheStrategy.getCacheResponse() == null) return;
                ++this.hitCount;
            }
            return;
        }
    }

    public final void update$okhttp(Response response, Response response2) {
        Intrinsics.checkNotNullParameter((Object)response, (String)"cached");
        Intrinsics.checkNotNullParameter((Object)response2, (String)"network");
        Entry entry = new Entry(response2);
        response = response.body();
        if (response == null) throw new NullPointerException("null cannot be cast to non-null type okhttp3.Cache.CacheResponseBody");
        response2 = ((CacheResponseBody)response).getSnapshot();
        response = null;
        try {
            response2 = response2.edit();
            if (response2 == null) {
                return;
            }
            response = response2;
            entry.writeTo((DiskLruCache.Editor)response2);
            response = response2;
            response2.commit();
        }
        catch (IOException iOException) {
            this.abortQuietly((DiskLruCache.Editor)response);
        }
    }

    public final Iterator<String> urls() throws IOException {
        return (Iterator)new /* Unavailable Anonymous Inner Class!! */;
    }

    public final int writeAbortCount() {
        synchronized (this) {
            int n = this.writeAbortCount;
            return n;
        }
    }

    public final int writeSuccessCount() {
        synchronized (this) {
            int n = this.writeSuccessCount;
            return n;
        }
    }
}
