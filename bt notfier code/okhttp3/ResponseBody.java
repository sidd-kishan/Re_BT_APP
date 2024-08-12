/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.DeprecationLevel
 *  kotlin.Metadata
 *  kotlin.ReplaceWith
 *  kotlin.io.CloseableKt
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.InlineMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.text.Charsets
 *  okhttp3.MediaType
 *  okhttp3.ResponseBody$BomAwareReader
 *  okhttp3.ResponseBody$Companion
 *  okhttp3.internal.Util
 *  okio.BufferedSource
 *  okio.ByteString
 */
package okhttp3;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.nio.charset.Charset;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okhttp3.internal.Util;
import okio.BufferedSource;
import okio.ByteString;

@Metadata(d1={"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b&\u0018\u0000 !2\u00020\u0001:\u0002 !B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006J\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\u0004J\b\u0010\f\u001a\u00020\rH\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016J@\u0010\u0010\u001a\u0002H\u0011\"\b\b\u0000\u0010\u0011*\u00020\u00122\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u0002H\u00110\u00142\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u00020\u00170\u0014H\u0082\b\u00a2\u0006\u0002\u0010\u0018J\b\u0010\u0019\u001a\u00020\u001aH&J\n\u0010\u001b\u001a\u0004\u0018\u00010\u001cH&J\b\u0010\u001d\u001a\u00020\u0015H&J\u0006\u0010\u001e\u001a\u00020\u001fR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\""}, d2={"Lokhttp3/ResponseBody;", "Ljava/io/Closeable;", "()V", "reader", "Ljava/io/Reader;", "byteStream", "Ljava/io/InputStream;", "byteString", "Lokio/ByteString;", "bytes", "", "charStream", "charset", "Ljava/nio/charset/Charset;", "close", "", "consumeSource", "T", "", "consumer", "Lkotlin/Function1;", "Lokio/BufferedSource;", "sizeMapper", "", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "contentLength", "", "contentType", "Lokhttp3/MediaType;", "source", "string", "", "BomAwareReader", "Companion", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class ResponseBody
implements Closeable {
    public static final Companion Companion = new Companion(null);
    private Reader reader;

    private final Charset charset() {
        Object object = this.contentType();
        object = object == null ? null : object.charset(Charsets.UTF_8);
        Object object2 = object;
        if (object != null) return object2;
        object2 = Charsets.UTF_8;
        return object2;
    }

    private final <T> T consumeSource(Function1<? super BufferedSource, ? extends T> object, Function1<? super T, Integer> function1) {
        long l = this.contentLength();
        if (l > Integer.MAX_VALUE) throw new IOException(Intrinsics.stringPlus((String)"Cannot buffer entire body for content length: ", (Object)l));
        Closeable closeable = (Closeable)this.source();
        Throwable throwable = null;
        try {
            object = object.invoke((Object)closeable);
        }
        catch (Throwable throwable2) {
            try {
                throw throwable2;
            }
            catch (Throwable throwable3) {
                InlineMarker.finallyStart((int)1);
                CloseableKt.closeFinally((Closeable)closeable, (Throwable)throwable2);
                InlineMarker.finallyEnd((int)1);
                throw throwable3;
            }
        }
        InlineMarker.finallyStart((int)1);
        CloseableKt.closeFinally((Closeable)closeable, (Throwable)throwable);
        InlineMarker.finallyEnd((int)1);
        int n = ((Number)function1.invoke(object)).intValue();
        if (l == -1L) return (T)object;
        if (l == (long)n) {
            return (T)object;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("Content-Length (");
        ((StringBuilder)object).append(l);
        ((StringBuilder)object).append(") and stream length (");
        ((StringBuilder)object).append(n);
        ((StringBuilder)object).append(") disagree");
        throw new IOException(((StringBuilder)object).toString());
    }

    @JvmStatic
    public static final ResponseBody create(String string, MediaType mediaType) {
        return Companion.create(string, mediaType);
    }

    @Deprecated(level=DeprecationLevel.WARNING, message="Moved to extension function. Put the 'content' argument first to fix Java", replaceWith=@ReplaceWith(expression="content.asResponseBody(contentType, contentLength)", imports={"okhttp3.ResponseBody.Companion.asResponseBody"}))
    @JvmStatic
    public static final ResponseBody create(MediaType mediaType, long l, BufferedSource bufferedSource) {
        return Companion.create(mediaType, l, bufferedSource);
    }

    @Deprecated(level=DeprecationLevel.WARNING, message="Moved to extension function. Put the 'content' argument first to fix Java", replaceWith=@ReplaceWith(expression="content.toResponseBody(contentType)", imports={"okhttp3.ResponseBody.Companion.toResponseBody"}))
    @JvmStatic
    public static final ResponseBody create(MediaType mediaType, String string) {
        return Companion.create(mediaType, string);
    }

    @Deprecated(level=DeprecationLevel.WARNING, message="Moved to extension function. Put the 'content' argument first to fix Java", replaceWith=@ReplaceWith(expression="content.toResponseBody(contentType)", imports={"okhttp3.ResponseBody.Companion.toResponseBody"}))
    @JvmStatic
    public static final ResponseBody create(MediaType mediaType, ByteString byteString) {
        return Companion.create(mediaType, byteString);
    }

    @Deprecated(level=DeprecationLevel.WARNING, message="Moved to extension function. Put the 'content' argument first to fix Java", replaceWith=@ReplaceWith(expression="content.toResponseBody(contentType)", imports={"okhttp3.ResponseBody.Companion.toResponseBody"}))
    @JvmStatic
    public static final ResponseBody create(MediaType mediaType, byte[] byArray) {
        return Companion.create(mediaType, byArray);
    }

    @JvmStatic
    public static final ResponseBody create(BufferedSource bufferedSource, MediaType mediaType, long l) {
        return Companion.create(bufferedSource, mediaType, l);
    }

    @JvmStatic
    public static final ResponseBody create(ByteString byteString, MediaType mediaType) {
        return Companion.create(byteString, mediaType);
    }

    @JvmStatic
    public static final ResponseBody create(byte[] byArray, MediaType mediaType) {
        return Companion.create(byArray, mediaType);
    }

    public final InputStream byteStream() {
        return this.source().inputStream();
    }

    public final ByteString byteString() throws IOException {
        ByteString byteString;
        long l = this.contentLength();
        if (l > Integer.MAX_VALUE) throw new IOException(Intrinsics.stringPlus((String)"Cannot buffer entire body for content length: ", (Object)l));
        Object object = (Closeable)this.source();
        Throwable throwable = null;
        try {
            byteString = ((BufferedSource)object).readByteString();
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
        int n = byteString.size();
        if (l == -1L) return byteString;
        if (l == (long)n) {
            return byteString;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("Content-Length (");
        ((StringBuilder)object).append(l);
        ((StringBuilder)object).append(") and stream length (");
        ((StringBuilder)object).append(n);
        ((StringBuilder)object).append(") disagree");
        throw new IOException(((StringBuilder)object).toString());
    }

    public final byte[] bytes() throws IOException {
        byte[] byArray;
        long l = this.contentLength();
        if (l > Integer.MAX_VALUE) throw new IOException(Intrinsics.stringPlus((String)"Cannot buffer entire body for content length: ", (Object)l));
        Object object = (Closeable)this.source();
        Throwable throwable = null;
        try {
            byArray = ((BufferedSource)object).readByteArray();
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
        int n = byArray.length;
        if (l == -1L) return byArray;
        if (l == (long)n) {
            return byArray;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("Content-Length (");
        ((StringBuilder)object).append(l);
        ((StringBuilder)object).append(") and stream length (");
        ((StringBuilder)object).append(n);
        ((StringBuilder)object).append(") disagree");
        throw new IOException(((StringBuilder)object).toString());
    }

    public final Reader charStream() {
        Reader reader;
        Reader reader2 = reader = this.reader;
        if (reader != null) return reader2;
        this.reader = reader2 = (Reader)new BomAwareReader(this.source(), this.charset());
        return reader2;
    }

    @Override
    public void close() {
        Util.closeQuietly((Closeable)((Closeable)this.source()));
    }

    public abstract long contentLength();

    public abstract MediaType contentType();

    public abstract BufferedSource source();

    public final String string() throws IOException {
        Object object;
        Closeable closeable = (Closeable)this.source();
        Throwable throwable = null;
        try {
            object = (BufferedSource)closeable;
            object = object.readString(Util.readBomAsCharset((BufferedSource)object, (Charset)this.charset()));
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
        return object;
    }
}
