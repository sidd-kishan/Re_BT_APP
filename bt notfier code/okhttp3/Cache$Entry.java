/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.io.CloseableKt
 *  kotlin.jvm.internal.Intrinsics
 *  okhttp3.Cache
 *  okhttp3.Cache$CacheResponseBody
 *  okhttp3.Cache$Entry$Companion
 *  okhttp3.CipherSuite
 *  okhttp3.Handshake
 *  okhttp3.Headers
 *  okhttp3.Headers$Builder
 *  okhttp3.HttpUrl
 *  okhttp3.Protocol
 *  okhttp3.Request
 *  okhttp3.Request$Builder
 *  okhttp3.Response
 *  okhttp3.Response$Builder
 *  okhttp3.ResponseBody
 *  okhttp3.TlsVersion
 *  okhttp3.internal.cache.DiskLruCache$Editor
 *  okhttp3.internal.cache.DiskLruCache$Snapshot
 *  okhttp3.internal.http.StatusLine
 *  okhttp3.internal.platform.Platform
 *  okio.Buffer
 *  okio.BufferedSink
 *  okio.BufferedSource
 *  okio.ByteString
 *  okio.ByteString$Companion
 *  okio.Okio
 *  okio.Sink
 *  okio.Source
 */
package okhttp3;

import java.io.Closeable;
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Cache;
import okhttp3.CipherSuite;
import okhttp3.Handshake;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.TlsVersion;
import okhttp3.internal.cache.DiskLruCache;
import okhttp3.internal.http.StatusLine;
import okhttp3.internal.platform.Platform;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;
import okio.Sink;
import okio.Source;

@Metadata(d1={"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u0000 -2\u00020\u0001:\u0001-B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004B\u000f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\u0016\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0005\u001a\u00020\u0006J\u0016\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e2\u0006\u0010 \u001a\u00020!H\u0002J\u0012\u0010\u0005\u001a\u00020\u00062\n\u0010\"\u001a\u00060#R\u00020$J\u001e\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eH\u0002J\u0012\u0010*\u001a\u00020&2\n\u0010+\u001a\u00060,R\u00020$R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0014X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006."}, d2={"Lokhttp3/Cache$Entry;", "", "rawSource", "Lokio/Source;", "(Lokio/Source;)V", "response", "Lokhttp3/Response;", "(Lokhttp3/Response;)V", "code", "", "handshake", "Lokhttp3/Handshake;", "message", "", "protocol", "Lokhttp3/Protocol;", "receivedResponseMillis", "", "requestMethod", "responseHeaders", "Lokhttp3/Headers;", "sentRequestMillis", "url", "Lokhttp3/HttpUrl;", "varyHeaders", "matches", "", "request", "Lokhttp3/Request;", "readCertificateList", "", "Ljava/security/cert/Certificate;", "source", "Lokio/BufferedSource;", "snapshot", "Lokhttp3/internal/cache/DiskLruCache$Snapshot;", "Lokhttp3/internal/cache/DiskLruCache;", "writeCertList", "", "sink", "Lokio/BufferedSink;", "certificates", "writeTo", "editor", "Lokhttp3/internal/cache/DiskLruCache$Editor;", "Companion", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
private static final class Cache.Entry {
    public static final Companion Companion = new Companion(null);
    private static final String RECEIVED_MILLIS;
    private static final String SENT_MILLIS;
    private final int code;
    private final Handshake handshake;
    private final String message;
    private final Protocol protocol;
    private final long receivedResponseMillis;
    private final String requestMethod;
    private final Headers responseHeaders;
    private final long sentRequestMillis;
    private final HttpUrl url;
    private final Headers varyHeaders;

    static {
        SENT_MILLIS = Intrinsics.stringPlus((String)Platform.Companion.get().getPrefix(), (Object)"-Sent-Millis");
        RECEIVED_MILLIS = Intrinsics.stringPlus((String)Platform.Companion.get().getPrefix(), (Object)"-Received-Millis");
    }

    public Cache.Entry(Response response) {
        Intrinsics.checkNotNullParameter((Object)response, (String)"response");
        this.url = response.request().url();
        this.varyHeaders = Cache.Companion.varyHeaders(response);
        this.requestMethod = response.request().method();
        this.protocol = response.protocol();
        this.code = response.code();
        this.message = response.message();
        this.responseHeaders = response.headers();
        this.handshake = response.handshake();
        this.sentRequestMillis = response.sentRequestAtMillis();
        this.receivedResponseMillis = response.receivedResponseAtMillis();
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public Cache.Entry(Source object) throws IOException {
        String string;
        Throwable throwable;
        block12: {
            Intrinsics.checkNotNullParameter((Object)object, (String)"rawSource");
            Closeable closeable = (Closeable)object;
            throwable = null;
            try {
                int n;
                int n2;
                Source source = (Source)closeable;
                object = Okio.buffer((Source)object);
                string = object.readUtf8LineStrict();
                HttpUrl httpUrl = HttpUrl.Companion.parse(string);
                if (httpUrl == null) break block12;
                this.url = httpUrl;
                this.requestMethod = object.readUtf8LineStrict();
                Headers.Builder builder = new Headers.Builder();
                int n3 = Cache.Companion.readInt$okhttp((BufferedSource)object);
                int n4 = 1;
                if (n3 > 0) {
                    n2 = 0;
                    do {
                        n = n2 + 1;
                        builder.addLenient$okhttp(object.readUtf8LineStrict());
                        n2 = n;
                    } while (n < n3);
                }
                this.varyHeaders = builder.build();
                StatusLine statusLine = StatusLine.Companion.parse(object.readUtf8LineStrict());
                this.protocol = statusLine.protocol;
                this.code = statusLine.code;
                this.message = statusLine.message;
                Headers.Builder builder2 = new Headers.Builder();
                n3 = Cache.Companion.readInt$okhttp((BufferedSource)object);
                if (n3 > 0) {
                    n2 = 0;
                    do {
                        n = n2 + 1;
                        builder2.addLenient$okhttp(object.readUtf8LineStrict());
                        n2 = n;
                    } while (n < n3);
                }
                String string2 = builder2.get(SENT_MILLIS);
                String string3 = builder2.get(RECEIVED_MILLIS);
                builder2.removeAll(SENT_MILLIS);
                builder2.removeAll(RECEIVED_MILLIS);
                long l = 0L;
                long l2 = string2 == null ? 0L : Long.parseLong(string2);
                this.sentRequestMillis = l2;
                l2 = string3 == null ? l : Long.parseLong(string3);
                this.receivedResponseMillis = l2;
                this.responseHeaders = builder2.build();
                if (this.url.isHttps()) {
                    String string4 = object.readUtf8LineStrict();
                    n2 = ((CharSequence)string4).length() > 0 ? n4 : 0;
                    if (n2 != 0) {
                        object = new StringBuilder();
                        ((StringBuilder)object).append("expected \"\" but was \"");
                        ((StringBuilder)object).append(string4);
                        ((StringBuilder)object).append('\"');
                        super(((StringBuilder)object).toString());
                        throw throwable;
                    }
                    String string5 = object.readUtf8LineStrict();
                    CipherSuite cipherSuite = CipherSuite.Companion.forJavaName(string5);
                    List<Certificate> list = this.readCertificateList((BufferedSource)object);
                    List<Certificate> list2 = this.readCertificateList((BufferedSource)object);
                    object = !object.exhausted() ? TlsVersion.Companion.forJavaName(object.readUtf8LineStrict()) : TlsVersion.SSL_3_0;
                    this.handshake = Handshake.Companion.get((TlsVersion)object, cipherSuite, list, list2);
                } else {
                    this.handshake = null;
                }
                object = Unit.INSTANCE;
            }
            catch (Throwable throwable2) {
                try {
                    throw throwable2;
                }
                catch (Throwable throwable3) {
                    CloseableKt.closeFinally((Closeable)closeable, (Throwable)throwable2);
                    throw throwable3;
                }
            }
            CloseableKt.closeFinally((Closeable)closeable, (Throwable)throwable);
            return;
        }
        object = new IOException(Intrinsics.stringPlus((String)"Cache corruption for ", (Object)string));
        Platform.Companion.get().log("cache corruption", 5, (Throwable)object);
        throwable = Unit.INSTANCE;
        throw (Throwable)object;
    }

    private final List<Certificate> readCertificateList(BufferedSource object) throws IOException {
        int n = Cache.Companion.readInt$okhttp(object);
        if (n == -1) {
            return CollectionsKt.emptyList();
        }
        try {
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            ArrayList<Certificate> arrayList = new ArrayList<Certificate>(n);
            int n2 = 0;
            if (n > 0) {
                int n3;
                do {
                    n3 = n2 + 1;
                    String string = object.readUtf8LineStrict();
                    Buffer buffer = new Buffer();
                    string = ByteString.Companion.decodeBase64(string);
                    Intrinsics.checkNotNull((Object)string);
                    buffer.write((ByteString)string);
                    arrayList.add(certificateFactory.generateCertificate(buffer.inputStream()));
                    n2 = n3;
                } while (n3 < n);
            }
            object = arrayList;
            return object;
        }
        catch (CertificateException certificateException) {
            IOException iOException = new IOException(certificateException.getMessage());
            throw iOException;
        }
    }

    private final void writeCertList(BufferedSink bufferedSink, List<? extends Certificate> object) throws IOException {
        try {
            bufferedSink.writeDecimalLong((long)object.size()).writeByte(10);
            object = object.iterator();
            while (object.hasNext()) {
                byte[] byArray = ((Certificate)object.next()).getEncoded();
                ByteString.Companion companion = ByteString.Companion;
                Intrinsics.checkNotNullExpressionValue((Object)byArray, (String)"bytes");
                bufferedSink.writeUtf8(ByteString.Companion.of$default((ByteString.Companion)companion, (byte[])byArray, (int)0, (int)0, (int)3, null).base64()).writeByte(10);
            }
            return;
        }
        catch (CertificateEncodingException certificateEncodingException) {
            IOException iOException = new IOException(certificateEncodingException.getMessage());
            throw iOException;
        }
    }

    public final boolean matches(Request request, Response response) {
        Intrinsics.checkNotNullParameter((Object)request, (String)"request");
        Intrinsics.checkNotNullParameter((Object)response, (String)"response");
        boolean bl = Intrinsics.areEqual((Object)this.url, (Object)request.url()) && Intrinsics.areEqual((Object)this.requestMethod, (Object)request.method()) && Cache.Companion.varyMatches(response, this.varyHeaders, request);
        return bl;
    }

    public final Response response(DiskLruCache.Snapshot snapshot) {
        Intrinsics.checkNotNullParameter((Object)snapshot, (String)"snapshot");
        String string = this.responseHeaders.get("Content-Type");
        String string2 = this.responseHeaders.get("Content-Length");
        Request request = new Request.Builder().url(this.url).method(this.requestMethod, null).headers(this.varyHeaders).build();
        return new Response.Builder().request(request).protocol(this.protocol).code(this.code).message(this.message).headers(this.responseHeaders).body((ResponseBody)new Cache.CacheResponseBody(snapshot, string, string2)).handshake(this.handshake).sentRequestAtMillis(this.sentRequestMillis).receivedResponseAtMillis(this.receivedResponseMillis).build();
    }

    public final void writeTo(DiskLruCache.Editor object) throws IOException {
        Intrinsics.checkNotNullParameter((Object)object, (String)"editor");
        int n = 0;
        object = (Closeable)Okio.buffer((Sink)object.newSink(0));
        Throwable throwable = null;
        try {
            int n2;
            int n3;
            BufferedSink bufferedSink = (BufferedSink)object;
            bufferedSink.writeUtf8(this.url.toString()).writeByte(10);
            bufferedSink.writeUtf8(this.requestMethod).writeByte(10);
            bufferedSink.writeDecimalLong((long)this.varyHeaders.size()).writeByte(10);
            int n4 = this.varyHeaders.size();
            if (n4 > 0) {
                n3 = 0;
                while (true) {
                    n2 = n3 + 1;
                    bufferedSink.writeUtf8(this.varyHeaders.name(n3)).writeUtf8(": ").writeUtf8(this.varyHeaders.value(n3)).writeByte(10);
                    if (n2 >= n4) break;
                    n3 = n2;
                }
            }
            StatusLine statusLine = new StatusLine(this.protocol, this.code, this.message);
            bufferedSink.writeUtf8(statusLine.toString()).writeByte(10);
            bufferedSink.writeDecimalLong((long)(this.responseHeaders.size() + 2)).writeByte(10);
            n2 = this.responseHeaders.size();
            if (n2 > 0) {
                n3 = n;
                while (true) {
                    n = n3 + 1;
                    bufferedSink.writeUtf8(this.responseHeaders.name(n3)).writeUtf8(": ").writeUtf8(this.responseHeaders.value(n3)).writeByte(10);
                    if (n >= n2) break;
                    n3 = n;
                }
            }
            bufferedSink.writeUtf8(SENT_MILLIS).writeUtf8(": ").writeDecimalLong(this.sentRequestMillis).writeByte(10);
            bufferedSink.writeUtf8(RECEIVED_MILLIS).writeUtf8(": ").writeDecimalLong(this.receivedResponseMillis).writeByte(10);
            if (this.url.isHttps()) {
                bufferedSink.writeByte(10);
                statusLine = this.handshake;
                Intrinsics.checkNotNull((Object)statusLine);
                bufferedSink.writeUtf8(statusLine.cipherSuite().javaName()).writeByte(10);
                this.writeCertList(bufferedSink, this.handshake.peerCertificates());
                this.writeCertList(bufferedSink, this.handshake.localCertificates());
                bufferedSink.writeUtf8(this.handshake.tlsVersion().javaName()).writeByte(10);
            }
            bufferedSink = Unit.INSTANCE;
        }
        catch (Throwable throwable2) {
            try {
                throw throwable2;
            }
            catch (Throwable throwable3) {
                CloseableKt.closeFinally((Closeable)object, (Throwable)throwable2);
                throw throwable3;
            }
        }
        CloseableKt.closeFinally((Closeable)object, (Throwable)throwable);
    }
}
