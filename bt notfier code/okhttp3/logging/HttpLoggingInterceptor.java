/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.DeprecationLevel
 *  kotlin.Metadata
 *  kotlin.ReplaceWith
 *  kotlin.collections.CollectionsKt
 *  kotlin.collections.SetsKt
 *  kotlin.io.CloseableKt
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.StringCompanionObject
 *  kotlin.text.StringsKt
 *  okhttp3.Headers
 *  okhttp3.Interceptor
 *  okhttp3.Interceptor$Chain
 *  okhttp3.Request
 *  okhttp3.RequestBody
 *  okhttp3.Response
 *  okhttp3.internal.http.HttpHeaders
 *  okhttp3.logging.HttpLoggingInterceptor$Level
 *  okhttp3.logging.HttpLoggingInterceptor$Logger
 *  okhttp3.logging.internal.Utf8Kt
 *  okio.Buffer
 *  okio.BufferedSink
 *  okio.GzipSource
 *  okio.Source
 */
package okhttp3.logging;

import java.io.Closeable;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.logging.internal.Utf8Kt;
import okio.Buffer;
import okio.BufferedSink;
import okio.GzipSource;
import okio.Source;

@Metadata(d1={"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0002\u001e\u001fB\u0011\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\r\u0010\u000b\u001a\u00020\tH\u0007\u00a2\u0006\u0002\b\u0012J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u000e\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u0007J\u000e\u0010\u001d\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\tR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R$\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t@GX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\n\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006 "}, d2={"Lokhttp3/logging/HttpLoggingInterceptor;", "Lokhttp3/Interceptor;", "logger", "Lokhttp3/logging/HttpLoggingInterceptor$Logger;", "(Lokhttp3/logging/HttpLoggingInterceptor$Logger;)V", "headersToRedact", "", "", "<set-?>", "Lokhttp3/logging/HttpLoggingInterceptor$Level;", "level", "getLevel", "()Lokhttp3/logging/HttpLoggingInterceptor$Level;", "(Lokhttp3/logging/HttpLoggingInterceptor$Level;)V", "bodyHasUnknownEncoding", "", "headers", "Lokhttp3/Headers;", "-deprecated_level", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "logHeader", "", "i", "", "redactHeader", "name", "setLevel", "Level", "Logger", "okhttp-logging-interceptor"}, k=1, mv={1, 5, 1}, xi=48)
public final class HttpLoggingInterceptor
implements Interceptor {
    private volatile Set<String> headersToRedact;
    private volatile Level level;
    private final Logger logger;

    public HttpLoggingInterceptor() {
        this(null, 1, null);
    }

    public HttpLoggingInterceptor(Logger logger) {
        Intrinsics.checkNotNullParameter((Object)logger, (String)"logger");
        this.logger = logger;
        this.headersToRedact = SetsKt.emptySet();
        this.level = Level.NONE;
    }

    public /* synthetic */ HttpLoggingInterceptor(Logger logger, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 1) != 0) {
            logger = Logger.DEFAULT;
        }
        this(logger);
    }

    private final boolean bodyHasUnknownEncoding(Headers object) {
        object = object.get("Content-Encoding");
        boolean bl = false;
        if (object == null) {
            return false;
        }
        boolean bl2 = bl;
        if (StringsKt.equals((String)object, (String)"identity", (boolean)true)) return bl2;
        bl2 = bl;
        if (StringsKt.equals((String)object, (String)"gzip", (boolean)true)) return bl2;
        bl2 = true;
        return bl2;
    }

    private final void logHeader(Headers headers, int n) {
        String string = this.headersToRedact.contains(headers.name(n)) ? "\u2588\u2588" : headers.value(n);
        Logger logger = this.logger;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(headers.name(n));
        stringBuilder.append(": ");
        stringBuilder.append(string);
        logger.log(stringBuilder.toString());
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to var", replaceWith=@ReplaceWith(expression="level", imports={}))
    public final Level _deprecated_level() {
        return this.level;
    }

    public final Level getLevel() {
        return this.level;
    }

    public Response intercept(Interceptor.Chain object) throws IOException {
        Object object2;
        Buffer buffer;
        int n;
        int n2;
        Intrinsics.checkNotNullParameter((Object)object, (String)"chain");
        Object object3 = this.level;
        Request request = object.request();
        if (object3 == Level.NONE) {
            return object.proceed(request);
        }
        boolean bl = object3 == Level.BODY;
        int n3 = !bl && object3 != Level.HEADERS ? 0 : 1;
        RequestBody requestBody = request.body();
        object3 = object.connection();
        Object object4 = new StringBuilder();
        ((StringBuilder)object4).append("--> ");
        ((StringBuilder)object4).append(request.method());
        ((StringBuilder)object4).append(' ');
        ((StringBuilder)object4).append(request.url());
        object3 = object3 != null ? Intrinsics.stringPlus((String)" ", (Object)object3.protocol()) : "";
        ((StringBuilder)object4).append((String)object3);
        object3 = object4 = ((StringBuilder)object4).toString();
        if (n3 == 0) {
            object3 = object4;
            if (requestBody != null) {
                object3 = new StringBuilder();
                ((StringBuilder)object3).append((String)object4);
                ((StringBuilder)object3).append(" (");
                ((StringBuilder)object3).append(requestBody.contentLength());
                ((StringBuilder)object3).append("-byte body)");
                object3 = ((StringBuilder)object3).toString();
            }
        }
        this.logger.log((String)object3);
        Logger logger = null;
        if (n3 != 0) {
            int n4;
            object4 = request.headers();
            if (requestBody != null) {
                object3 = requestBody.contentType();
                if (object3 != null && object4.get("Content-Type") == null) {
                    this.logger.log(Intrinsics.stringPlus((String)"Content-Type: ", (Object)object3));
                }
                if (requestBody.contentLength() != -1L && object4.get("Content-Length") == null) {
                    this.logger.log(Intrinsics.stringPlus((String)"Content-Length: ", (Object)requestBody.contentLength()));
                }
            }
            if ((n4 = object4.size()) > 0) {
                n2 = 0;
                while (true) {
                    n = n2 + 1;
                    this.logHeader((Headers)object4, n2);
                    if (n >= n4) break;
                    n2 = n;
                }
            }
            if (bl && requestBody != null) {
                if (this.bodyHasUnknownEncoding(request.headers())) {
                    object4 = this.logger;
                    object3 = new StringBuilder();
                    ((StringBuilder)object3).append("--> END ");
                    ((StringBuilder)object3).append(request.method());
                    ((StringBuilder)object3).append(" (encoded body omitted)");
                    object4.log(((StringBuilder)object3).toString());
                } else if (requestBody.isDuplex()) {
                    object4 = this.logger;
                    object3 = new StringBuilder();
                    ((StringBuilder)object3).append("--> END ");
                    ((StringBuilder)object3).append(request.method());
                    ((StringBuilder)object3).append(" (duplex request body omitted)");
                    object4.log(((StringBuilder)object3).toString());
                } else if (requestBody.isOneShot()) {
                    object4 = this.logger;
                    object3 = new StringBuilder();
                    ((StringBuilder)object3).append("--> END ");
                    ((StringBuilder)object3).append(request.method());
                    ((StringBuilder)object3).append(" (one-shot body omitted)");
                    object4.log(((StringBuilder)object3).toString());
                } else {
                    buffer = new Buffer();
                    requestBody.writeTo((BufferedSink)buffer);
                    object3 = requestBody.contentType();
                    object3 = object3 == null ? null : object3.charset(StandardCharsets.UTF_8);
                    object4 = object3;
                    if (object3 == null) {
                        object4 = StandardCharsets.UTF_8;
                        Intrinsics.checkNotNullExpressionValue((Object)object4, (String)"UTF_8");
                    }
                    this.logger.log("");
                    if (Utf8Kt.isProbablyUtf8((Buffer)buffer)) {
                        this.logger.log(buffer.readString((Charset)object4));
                        object3 = this.logger;
                        object4 = new StringBuilder();
                        ((StringBuilder)object4).append("--> END ");
                        ((StringBuilder)object4).append(request.method());
                        ((StringBuilder)object4).append(" (");
                        ((StringBuilder)object4).append(requestBody.contentLength());
                        ((StringBuilder)object4).append("-byte body)");
                        object3.log(((StringBuilder)object4).toString());
                    } else {
                        object3 = this.logger;
                        object4 = new StringBuilder();
                        ((StringBuilder)object4).append("--> END ");
                        ((StringBuilder)object4).append(request.method());
                        ((StringBuilder)object4).append(" (binary ");
                        ((StringBuilder)object4).append(requestBody.contentLength());
                        ((StringBuilder)object4).append("-byte body omitted)");
                        object3.log(((StringBuilder)object4).toString());
                    }
                }
            } else {
                this.logger.log(Intrinsics.stringPlus((String)"--> END ", (Object)request.method()));
            }
        }
        long l = System.nanoTime();
        try {
            request = object.proceed(request);
            l = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - l);
        }
        catch (Exception exception) {
            this.logger.log(Intrinsics.stringPlus((String)"<-- HTTP FAILED: ", (Object)exception));
            throw exception;
        }
        requestBody = request.body();
        Intrinsics.checkNotNull((Object)requestBody);
        long l2 = requestBody.contentLength();
        if (l2 != -1L) {
            object = new StringBuilder();
            ((StringBuilder)object).append(l2);
            ((StringBuilder)object).append("-byte");
            object = ((StringBuilder)object).toString();
        } else {
            object = "unknown-length";
        }
        buffer = this.logger;
        object4 = new StringBuilder();
        ((StringBuilder)object4).append("<-- ");
        ((StringBuilder)object4).append(request.code());
        n2 = ((CharSequence)request.message()).length() == 0 ? 1 : 0;
        if (n2 != 0) {
            object3 = "";
        } else {
            object2 = request.message();
            object3 = new StringBuilder();
            ((StringBuilder)object3).append(String.valueOf(' '));
            ((StringBuilder)object3).append((String)object2);
            object3 = ((StringBuilder)object3).toString();
        }
        ((StringBuilder)object4).append((String)object3);
        ((StringBuilder)object4).append(' ');
        ((StringBuilder)object4).append(request.request().url());
        ((StringBuilder)object4).append(" (");
        ((StringBuilder)object4).append(l);
        ((StringBuilder)object4).append("ms");
        if (n3 == 0) {
            object3 = new StringBuilder();
            ((StringBuilder)object3).append(", ");
            ((StringBuilder)object3).append((String)object);
            ((StringBuilder)object3).append(" body");
            object = ((StringBuilder)object3).toString();
        } else {
            object = "";
        }
        ((StringBuilder)object4).append((String)object);
        ((StringBuilder)object4).append(')');
        buffer.log(((StringBuilder)object4).toString());
        if (n3 == 0) return request;
        object = request.headers();
        n = object.size();
        if (n > 0) {
            n3 = 0;
            while (true) {
                n2 = n3 + 1;
                this.logHeader((Headers)object, n3);
                if (n2 >= n) break;
                n3 = n2;
            }
        }
        if (bl && HttpHeaders.promisesBody((Response)request)) {
            if (this.bodyHasUnknownEncoding(request.headers())) {
                this.logger.log("<-- END HTTP (encoded body omitted)");
            } else {
                object3 = requestBody.source();
                object3.request(Long.MAX_VALUE);
                object3 = object3.getBuffer();
                if (StringsKt.equals((String)"gzip", (String)object.get("Content-Encoding"), (boolean)true)) {
                    object4 = object3.size();
                    object = (Closeable)new GzipSource((Source)object3.clone());
                    object2 = null;
                    try {
                        buffer = (GzipSource)object;
                        object3 = new Buffer();
                        object3.writeAll((Source)buffer);
                    }
                    catch (Throwable throwable) {
                        try {
                            throw throwable;
                        }
                        catch (Throwable throwable2) {
                            CloseableKt.closeFinally((Closeable)object, (Throwable)throwable);
                            throw throwable2;
                        }
                    }
                    CloseableKt.closeFinally((Closeable)object, (Throwable)object2);
                } else {
                    object4 = null;
                }
                object = requestBody.contentType();
                object = object == null ? logger : object.charset(StandardCharsets.UTF_8);
                if (object == null) {
                    object = StandardCharsets.UTF_8;
                    Intrinsics.checkNotNullExpressionValue((Object)object, (String)"UTF_8");
                }
                if (!Utf8Kt.isProbablyUtf8((Buffer)object3)) {
                    this.logger.log("");
                    object = this.logger;
                    object4 = new StringBuilder();
                    ((StringBuilder)object4).append("<-- END HTTP (binary ");
                    ((StringBuilder)object4).append(object3.size());
                    ((StringBuilder)object4).append("-byte body omitted)");
                    object.log(((StringBuilder)object4).toString());
                    return request;
                }
                if (l2 != 0L) {
                    this.logger.log("");
                    this.logger.log(object3.clone().readString((Charset)object));
                }
                if (object4 != null) {
                    logger = this.logger;
                    object = new StringBuilder();
                    ((StringBuilder)object).append("<-- END HTTP (");
                    ((StringBuilder)object).append(object3.size());
                    ((StringBuilder)object).append("-byte, ");
                    ((StringBuilder)object).append(object4);
                    ((StringBuilder)object).append("-gzipped-byte body)");
                    logger.log(((StringBuilder)object).toString());
                } else {
                    object4 = this.logger;
                    object = new StringBuilder();
                    ((StringBuilder)object).append("<-- END HTTP (");
                    ((StringBuilder)object).append(object3.size());
                    ((StringBuilder)object).append("-byte body)");
                    object4.log(((StringBuilder)object).toString());
                }
            }
        } else {
            this.logger.log("<-- END HTTP");
        }
        return request;
    }

    public final void level(Level level) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"<set-?>");
        this.level = level;
    }

    public final void redactHeader(String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"name");
        TreeSet treeSet = new TreeSet(StringsKt.getCASE_INSENSITIVE_ORDER((StringCompanionObject)StringCompanionObject.INSTANCE));
        Collection collection = treeSet;
        CollectionsKt.addAll((Collection)collection, (Iterable)this.headersToRedact);
        collection.add(string);
        this.headersToRedact = treeSet;
    }

    public final HttpLoggingInterceptor setLevel(Level level) {
        Intrinsics.checkNotNullParameter((Object)level, (String)"level");
        HttpLoggingInterceptor httpLoggingInterceptor = this;
        httpLoggingInterceptor.level(level);
        return httpLoggingInterceptor;
    }
}
