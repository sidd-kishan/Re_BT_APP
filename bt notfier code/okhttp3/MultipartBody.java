/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.DeprecationLevel
 *  kotlin.Metadata
 *  kotlin.ReplaceWith
 *  kotlin.jvm.internal.Intrinsics
 *  okhttp3.Headers
 *  okhttp3.MediaType
 *  okhttp3.MultipartBody$Companion
 *  okhttp3.MultipartBody$Part
 *  okhttp3.RequestBody
 *  okio.Buffer
 *  okio.BufferedSink
 *  okio.ByteString
 */
package okhttp3;

import java.io.IOException;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okio.Buffer;
import okio.BufferedSink;
import okio.ByteString;

@Metadata(d1={"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 #2\u00020\u0001:\u0003\"#$B%\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\u0002\u0010\tJ\r\u0010\n\u001a\u00020\u000bH\u0007\u00a2\u0006\u0002\b\u0015J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0005H\u0016J\u000e\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0012J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0007\u00a2\u0006\u0002\b\u0018J\r\u0010\u0011\u001a\u00020\u0012H\u0007\u00a2\u0006\u0002\b\u0019J\r\u0010\u0004\u001a\u00020\u0005H\u0007\u00a2\u0006\u0002\b\u001aJ\u001a\u0010\u001b\u001a\u00020\u000e2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0010\u0010 \u001a\u00020!2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016R\u0011\u0010\n\u001a\u00020\u000b8G\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0019\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u00128G\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0013R\u0013\u0010\u0004\u001a\u00020\u00058\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0014\u00a8\u0006%"}, d2={"Lokhttp3/MultipartBody;", "Lokhttp3/RequestBody;", "boundaryByteString", "Lokio/ByteString;", "type", "Lokhttp3/MediaType;", "parts", "", "Lokhttp3/MultipartBody$Part;", "(Lokio/ByteString;Lokhttp3/MediaType;Ljava/util/List;)V", "boundary", "", "()Ljava/lang/String;", "contentLength", "", "contentType", "()Ljava/util/List;", "size", "", "()I", "()Lokhttp3/MediaType;", "-deprecated_boundary", "part", "index", "-deprecated_parts", "-deprecated_size", "-deprecated_type", "writeOrCountBytes", "sink", "Lokio/BufferedSink;", "countBytes", "", "writeTo", "", "Builder", "Companion", "Part", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public final class MultipartBody
extends RequestBody {
    public static final MediaType ALTERNATIVE;
    private static final byte[] COLONSPACE;
    private static final byte[] CRLF;
    public static final Companion Companion;
    private static final byte[] DASHDASH;
    public static final MediaType DIGEST;
    public static final MediaType FORM;
    public static final MediaType MIXED;
    public static final MediaType PARALLEL;
    private final ByteString boundaryByteString;
    private long contentLength;
    private final MediaType contentType;
    private final List<Part> parts;
    private final MediaType type;

    static {
        Companion = new Companion(null);
        MIXED = MediaType.Companion.get("multipart/mixed");
        ALTERNATIVE = MediaType.Companion.get("multipart/alternative");
        DIGEST = MediaType.Companion.get("multipart/digest");
        PARALLEL = MediaType.Companion.get("multipart/parallel");
        FORM = MediaType.Companion.get("multipart/form-data");
        COLONSPACE = new byte[]{(byte)58, (byte)32};
        CRLF = new byte[]{(byte)13, (byte)10};
        byte by = (byte)45;
        DASHDASH = new byte[]{by, by};
    }

    public MultipartBody(ByteString object, MediaType mediaType, List<Part> list) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"boundaryByteString");
        Intrinsics.checkNotNullParameter((Object)mediaType, (String)"type");
        Intrinsics.checkNotNullParameter(list, (String)"parts");
        this.boundaryByteString = object;
        this.type = mediaType;
        this.parts = list;
        mediaType = MediaType.Companion;
        object = new StringBuilder();
        ((StringBuilder)object).append(this.type);
        ((StringBuilder)object).append("; boundary=");
        ((StringBuilder)object).append(this.boundary());
        this.contentType = mediaType.get(((StringBuilder)object).toString());
        this.contentLength = -1L;
    }

    private final long writeOrCountBytes(BufferedSink bufferedSink, boolean bl) throws IOException {
        long l;
        Buffer buffer;
        if (bl) {
            buffer = new Buffer();
            bufferedSink = (BufferedSink)buffer;
        } else {
            buffer = null;
        }
        int n = this.parts.size();
        long l2 = l = 0L;
        if (n > 0) {
            int n2 = 0;
            l2 = l;
            while (true) {
                int n3;
                int n4 = n2 + 1;
                Part part = this.parts.get(n2);
                Headers headers = part.headers();
                part = part.body();
                Intrinsics.checkNotNull((Object)bufferedSink);
                bufferedSink.write(DASHDASH);
                bufferedSink.write(this.boundaryByteString);
                bufferedSink.write(CRLF);
                if (headers != null && (n3 = headers.size()) > 0) {
                    n2 = 0;
                    while (true) {
                        int n5 = n2 + 1;
                        bufferedSink.writeUtf8(headers.name(n2)).write(COLONSPACE).writeUtf8(headers.value(n2)).write(CRLF);
                        if (n5 >= n3) break;
                        n2 = n5;
                    }
                }
                if ((headers = part.contentType()) != null) {
                    bufferedSink.writeUtf8("Content-Type: ").writeUtf8(headers.toString()).write(CRLF);
                }
                if ((l = part.contentLength()) != -1L) {
                    bufferedSink.writeUtf8("Content-Length: ").writeDecimalLong(l).write(CRLF);
                } else if (bl) {
                    Intrinsics.checkNotNull((Object)buffer);
                    buffer.clear();
                    return -1L;
                }
                bufferedSink.write(CRLF);
                if (bl) {
                    l2 += l;
                } else {
                    part.writeTo(bufferedSink);
                }
                bufferedSink.write(CRLF);
                if (n4 >= n) break;
                n2 = n4;
            }
        }
        Intrinsics.checkNotNull((Object)bufferedSink);
        bufferedSink.write(DASHDASH);
        bufferedSink.write(this.boundaryByteString);
        bufferedSink.write(DASHDASH);
        bufferedSink.write(CRLF);
        l = l2;
        if (!bl) return l;
        Intrinsics.checkNotNull((Object)buffer);
        l = l2 + buffer.size();
        buffer.clear();
        return l;
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="boundary", imports={}))
    public final String _deprecated_boundary() {
        return this.boundary();
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="parts", imports={}))
    public final List<Part> _deprecated_parts() {
        return this.parts;
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="size", imports={}))
    public final int _deprecated_size() {
        return this.size();
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="type", imports={}))
    public final MediaType _deprecated_type() {
        return this.type;
    }

    public final String boundary() {
        return this.boundaryByteString.utf8();
    }

    public long contentLength() throws IOException {
        long l;
        long l2 = l = this.contentLength;
        if (l != -1L) return l2;
        this.contentLength = l2 = this.writeOrCountBytes(null, true);
        return l2;
    }

    public MediaType contentType() {
        return this.contentType;
    }

    public final Part part(int n) {
        return this.parts.get(n);
    }

    public final List<Part> parts() {
        return this.parts;
    }

    public final int size() {
        return this.parts.size();
    }

    public final MediaType type() {
        return this.type;
    }

    public void writeTo(BufferedSink bufferedSink) throws IOException {
        Intrinsics.checkNotNullParameter((Object)bufferedSink, (String)"sink");
        this.writeOrCountBytes(bufferedSink, false);
    }
}
