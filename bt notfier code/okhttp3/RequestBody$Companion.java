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
 *  okhttp3.RequestBody
 *  okhttp3.internal.Util
 *  okio.ByteString
 */
package okhttp3;

import java.io.File;
import java.io.FileDescriptor;
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
import okhttp3.RequestBody;
import okhttp3.internal.Util;
import okio.ByteString;

@Metadata(d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J.\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\fH\u0007J\u001a\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\u000eH\u0007J\u001a\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\u000fH\u0007J\u001d\u0010\u0010\u001a\u00020\u0004*\u00020\b2\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007\u00a2\u0006\u0002\b\u0003J\u001d\u0010\u0011\u001a\u00020\u0004*\u00020\u00122\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007\u00a2\u0006\u0002\b\u0003J1\u0010\u0011\u001a\u00020\u0004*\u00020\n2\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\fH\u0007\u00a2\u0006\u0002\b\u0003J\u001d\u0010\u0011\u001a\u00020\u0004*\u00020\u000e2\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007\u00a2\u0006\u0002\b\u0003J\u001d\u0010\u0011\u001a\u00020\u0004*\u00020\u000f2\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007\u00a2\u0006\u0002\b\u0003\u00a8\u0006\u0013"}, d2={"Lokhttp3/RequestBody$Companion;", "", "()V", "create", "Lokhttp3/RequestBody;", "contentType", "Lokhttp3/MediaType;", "file", "Ljava/io/File;", "content", "", "offset", "", "byteCount", "", "Lokio/ByteString;", "asRequestBody", "toRequestBody", "Ljava/io/FileDescriptor;", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public static final class RequestBody.Companion {
    private RequestBody.Companion() {
    }

    public /* synthetic */ RequestBody.Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public static /* synthetic */ RequestBody create$default(RequestBody.Companion companion, File file, MediaType mediaType, int n, Object object) {
        if ((n & 1) == 0) return companion.create(file, mediaType);
        mediaType = null;
        return companion.create(file, mediaType);
    }

    public static /* synthetic */ RequestBody create$default(RequestBody.Companion companion, FileDescriptor fileDescriptor, MediaType mediaType, int n, Object object) {
        if ((n & 1) == 0) return companion.create(fileDescriptor, mediaType);
        mediaType = null;
        return companion.create(fileDescriptor, mediaType);
    }

    public static /* synthetic */ RequestBody create$default(RequestBody.Companion companion, String string, MediaType mediaType, int n, Object object) {
        if ((n & 1) == 0) return companion.create(string, mediaType);
        mediaType = null;
        return companion.create(string, mediaType);
    }

    public static /* synthetic */ RequestBody create$default(RequestBody.Companion companion, MediaType mediaType, byte[] byArray, int n, int n2, int n3, Object object) {
        if ((n3 & 4) != 0) {
            n = 0;
        }
        if ((n3 & 8) == 0) return companion.create(mediaType, byArray, n, n2);
        n2 = byArray.length;
        return companion.create(mediaType, byArray, n, n2);
    }

    public static /* synthetic */ RequestBody create$default(RequestBody.Companion companion, ByteString byteString, MediaType mediaType, int n, Object object) {
        if ((n & 1) == 0) return companion.create(byteString, mediaType);
        mediaType = null;
        return companion.create(byteString, mediaType);
    }

    public static /* synthetic */ RequestBody create$default(RequestBody.Companion companion, byte[] byArray, MediaType mediaType, int n, int n2, int n3, Object object) {
        if ((n3 & 1) != 0) {
            mediaType = null;
        }
        if ((n3 & 2) != 0) {
            n = 0;
        }
        if ((n3 & 4) == 0) return companion.create(byArray, mediaType, n, n2);
        n2 = byArray.length;
        return companion.create(byArray, mediaType, n, n2);
    }

    @JvmStatic
    public final RequestBody create(File file, MediaType mediaType) {
        Intrinsics.checkNotNullParameter((Object)file, (String)"<this>");
        return (RequestBody)new /* Unavailable Anonymous Inner Class!! */;
    }

    @JvmStatic
    public final RequestBody create(FileDescriptor fileDescriptor, MediaType mediaType) {
        Intrinsics.checkNotNullParameter((Object)fileDescriptor, (String)"<this>");
        return (RequestBody)new /* Unavailable Anonymous Inner Class!! */;
    }

    @JvmStatic
    public final RequestBody create(String object, MediaType mediaType) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"<this>");
        Charset charset = Charsets.UTF_8;
        Object object2 = mediaType;
        if (mediaType != null) {
            Charset charset2;
            charset = charset2 = MediaType.charset$default((MediaType)mediaType, null, (int)1, null);
            object2 = mediaType;
            if (charset2 == null) {
                charset = Charsets.UTF_8;
                charset2 = MediaType.Companion;
                object2 = new StringBuilder();
                ((StringBuilder)object2).append(mediaType);
                ((StringBuilder)object2).append("; charset=utf-8");
                object2 = charset2.parse(((StringBuilder)object2).toString());
            }
        }
        object = ((String)object).getBytes(charset);
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"(this as java.lang.String).getBytes(charset)");
        return this.create((byte[])object, (MediaType)object2, 0, ((Object)object).length);
    }

    @Deprecated(level=DeprecationLevel.WARNING, message="Moved to extension function. Put the 'file' argument first to fix Java", replaceWith=@ReplaceWith(expression="file.asRequestBody(contentType)", imports={"okhttp3.RequestBody.Companion.asRequestBody"}))
    @JvmStatic
    public final RequestBody create(MediaType mediaType, File file) {
        Intrinsics.checkNotNullParameter((Object)file, (String)"file");
        return this.create(file, mediaType);
    }

    @Deprecated(level=DeprecationLevel.WARNING, message="Moved to extension function. Put the 'content' argument first to fix Java", replaceWith=@ReplaceWith(expression="content.toRequestBody(contentType)", imports={"okhttp3.RequestBody.Companion.toRequestBody"}))
    @JvmStatic
    public final RequestBody create(MediaType mediaType, String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"content");
        return this.create(string, mediaType);
    }

    @Deprecated(level=DeprecationLevel.WARNING, message="Moved to extension function. Put the 'content' argument first to fix Java", replaceWith=@ReplaceWith(expression="content.toRequestBody(contentType)", imports={"okhttp3.RequestBody.Companion.toRequestBody"}))
    @JvmStatic
    public final RequestBody create(MediaType mediaType, ByteString byteString) {
        Intrinsics.checkNotNullParameter((Object)byteString, (String)"content");
        return this.create(byteString, mediaType);
    }

    @Deprecated(level=DeprecationLevel.WARNING, message="Moved to extension function. Put the 'content' argument first to fix Java", replaceWith=@ReplaceWith(expression="content.toRequestBody(contentType, offset, byteCount)", imports={"okhttp3.RequestBody.Companion.toRequestBody"}))
    @JvmStatic
    public final RequestBody create(MediaType mediaType, byte[] byArray) {
        Intrinsics.checkNotNullParameter((Object)byArray, (String)"content");
        return RequestBody.Companion.create$default(this, mediaType, byArray, 0, 0, 12, null);
    }

    @Deprecated(level=DeprecationLevel.WARNING, message="Moved to extension function. Put the 'content' argument first to fix Java", replaceWith=@ReplaceWith(expression="content.toRequestBody(contentType, offset, byteCount)", imports={"okhttp3.RequestBody.Companion.toRequestBody"}))
    @JvmStatic
    public final RequestBody create(MediaType mediaType, byte[] byArray, int n) {
        Intrinsics.checkNotNullParameter((Object)byArray, (String)"content");
        return RequestBody.Companion.create$default(this, mediaType, byArray, n, 0, 8, null);
    }

    @Deprecated(level=DeprecationLevel.WARNING, message="Moved to extension function. Put the 'content' argument first to fix Java", replaceWith=@ReplaceWith(expression="content.toRequestBody(contentType, offset, byteCount)", imports={"okhttp3.RequestBody.Companion.toRequestBody"}))
    @JvmStatic
    public final RequestBody create(MediaType mediaType, byte[] byArray, int n, int n2) {
        Intrinsics.checkNotNullParameter((Object)byArray, (String)"content");
        return this.create(byArray, mediaType, n, n2);
    }

    @JvmStatic
    public final RequestBody create(ByteString byteString, MediaType mediaType) {
        Intrinsics.checkNotNullParameter((Object)byteString, (String)"<this>");
        return (RequestBody)new /* Unavailable Anonymous Inner Class!! */;
    }

    @JvmStatic
    public final RequestBody create(byte[] byArray) {
        Intrinsics.checkNotNullParameter((Object)byArray, (String)"<this>");
        return RequestBody.Companion.create$default(this, byArray, null, 0, 0, 7, null);
    }

    @JvmStatic
    public final RequestBody create(byte[] byArray, MediaType mediaType) {
        Intrinsics.checkNotNullParameter((Object)byArray, (String)"<this>");
        return RequestBody.Companion.create$default(this, byArray, mediaType, 0, 0, 6, null);
    }

    @JvmStatic
    public final RequestBody create(byte[] byArray, MediaType mediaType, int n) {
        Intrinsics.checkNotNullParameter((Object)byArray, (String)"<this>");
        return RequestBody.Companion.create$default(this, byArray, mediaType, n, 0, 4, null);
    }

    @JvmStatic
    public final RequestBody create(byte[] byArray, MediaType mediaType, int n, int n2) {
        Intrinsics.checkNotNullParameter((Object)byArray, (String)"<this>");
        Util.checkOffsetAndCount((long)byArray.length, (long)n, (long)n2);
        return (RequestBody)new /* Unavailable Anonymous Inner Class!! */;
    }
}
