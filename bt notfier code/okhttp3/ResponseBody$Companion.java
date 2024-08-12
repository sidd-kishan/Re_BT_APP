/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.DeprecationLevel
 *  kotlin.Metadata
 *  kotlin.ReplaceWith
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.text.Charsets
 *  okhttp3.MediaType
 *  okhttp3.ResponseBody
 *  okio.Buffer
 *  okio.BufferedSource
 *  okio.ByteString
 */
package okhttp3;

import java.nio.charset.Charset;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;

@Metadata(d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\"\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u000bH\u0007J\u001a\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\fH\u0007J\u001a\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\rH\u0007J'\u0010\u000e\u001a\u00020\u0004*\u00020\u000b2\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\t\u001a\u00020\nH\u0007\u00a2\u0006\u0002\b\u0003J\u001d\u0010\u000f\u001a\u00020\u0004*\u00020\b2\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007\u00a2\u0006\u0002\b\u0003J\u001d\u0010\u000f\u001a\u00020\u0004*\u00020\f2\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007\u00a2\u0006\u0002\b\u0003J\u001d\u0010\u000f\u001a\u00020\u0004*\u00020\r2\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007\u00a2\u0006\u0002\b\u0003\u00a8\u0006\u0010"}, d2={"Lokhttp3/ResponseBody$Companion;", "", "()V", "create", "Lokhttp3/ResponseBody;", "contentType", "Lokhttp3/MediaType;", "content", "", "contentLength", "", "Lokio/BufferedSource;", "", "Lokio/ByteString;", "asResponseBody", "toResponseBody", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public static final class ResponseBody.Companion {
    private ResponseBody.Companion() {
    }

    public /* synthetic */ ResponseBody.Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public static /* synthetic */ ResponseBody create$default(ResponseBody.Companion companion, String string, MediaType mediaType, int n, Object object) {
        if ((n & 1) == 0) return companion.create(string, mediaType);
        mediaType = null;
        return companion.create(string, mediaType);
    }

    public static /* synthetic */ ResponseBody create$default(ResponseBody.Companion companion, BufferedSource bufferedSource, MediaType mediaType, long l, int n, Object object) {
        if ((n & 1) != 0) {
            mediaType = null;
        }
        if ((n & 2) == 0) return companion.create(bufferedSource, mediaType, l);
        l = -1L;
        return companion.create(bufferedSource, mediaType, l);
    }

    public static /* synthetic */ ResponseBody create$default(ResponseBody.Companion companion, ByteString byteString, MediaType mediaType, int n, Object object) {
        if ((n & 1) == 0) return companion.create(byteString, mediaType);
        mediaType = null;
        return companion.create(byteString, mediaType);
    }

    public static /* synthetic */ ResponseBody create$default(ResponseBody.Companion companion, byte[] byArray, MediaType mediaType, int n, Object object) {
        if ((n & 1) == 0) return companion.create(byArray, mediaType);
        mediaType = null;
        return companion.create(byArray, mediaType);
    }

    @JvmStatic
    public final ResponseBody create(String string, MediaType mediaType) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"<this>");
        Charset charset = Charsets.UTF_8;
        MediaType mediaType2 = mediaType;
        if (mediaType != null) {
            Object object = MediaType.charset$default((MediaType)mediaType, null, (int)1, null);
            charset = object;
            mediaType2 = mediaType;
            if (object == null) {
                charset = Charsets.UTF_8;
                mediaType2 = MediaType.Companion;
                object = new StringBuilder();
                ((StringBuilder)object).append(mediaType);
                ((StringBuilder)object).append("; charset=utf-8");
                mediaType2 = mediaType2.parse(((StringBuilder)object).toString());
            }
        }
        string = new Buffer().writeString(string, charset);
        return this.create((BufferedSource)string, mediaType2, string.size());
    }

    @Deprecated(level=DeprecationLevel.WARNING, message="Moved to extension function. Put the 'content' argument first to fix Java", replaceWith=@ReplaceWith(expression="content.asResponseBody(contentType, contentLength)", imports={"okhttp3.ResponseBody.Companion.asResponseBody"}))
    @JvmStatic
    public final ResponseBody create(MediaType mediaType, long l, BufferedSource bufferedSource) {
        Intrinsics.checkNotNullParameter((Object)bufferedSource, (String)"content");
        return this.create(bufferedSource, mediaType, l);
    }

    @Deprecated(level=DeprecationLevel.WARNING, message="Moved to extension function. Put the 'content' argument first to fix Java", replaceWith=@ReplaceWith(expression="content.toResponseBody(contentType)", imports={"okhttp3.ResponseBody.Companion.toResponseBody"}))
    @JvmStatic
    public final ResponseBody create(MediaType mediaType, String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"content");
        return this.create(string, mediaType);
    }

    @Deprecated(level=DeprecationLevel.WARNING, message="Moved to extension function. Put the 'content' argument first to fix Java", replaceWith=@ReplaceWith(expression="content.toResponseBody(contentType)", imports={"okhttp3.ResponseBody.Companion.toResponseBody"}))
    @JvmStatic
    public final ResponseBody create(MediaType mediaType, ByteString byteString) {
        Intrinsics.checkNotNullParameter((Object)byteString, (String)"content");
        return this.create(byteString, mediaType);
    }

    @Deprecated(level=DeprecationLevel.WARNING, message="Moved to extension function. Put the 'content' argument first to fix Java", replaceWith=@ReplaceWith(expression="content.toResponseBody(contentType)", imports={"okhttp3.ResponseBody.Companion.toResponseBody"}))
    @JvmStatic
    public final ResponseBody create(MediaType mediaType, byte[] byArray) {
        Intrinsics.checkNotNullParameter((Object)byArray, (String)"content");
        return this.create(byArray, mediaType);
    }

    @JvmStatic
    public final ResponseBody create(BufferedSource bufferedSource, MediaType mediaType, long l) {
        Intrinsics.checkNotNullParameter((Object)bufferedSource, (String)"<this>");
        return (ResponseBody)new /* Unavailable Anonymous Inner Class!! */;
    }

    @JvmStatic
    public final ResponseBody create(ByteString byteString, MediaType mediaType) {
        Intrinsics.checkNotNullParameter((Object)byteString, (String)"<this>");
        return this.create((BufferedSource)new Buffer().write(byteString), mediaType, byteString.size());
    }

    @JvmStatic
    public final ResponseBody create(byte[] byArray, MediaType mediaType) {
        Intrinsics.checkNotNullParameter((Object)byArray, (String)"<this>");
        return this.create((BufferedSource)new Buffer().write(byArray), mediaType, byArray.length);
    }
}
