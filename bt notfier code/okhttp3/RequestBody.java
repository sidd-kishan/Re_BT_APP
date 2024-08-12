/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.DeprecationLevel
 *  kotlin.Metadata
 *  kotlin.ReplaceWith
 *  kotlin.jvm.JvmStatic
 *  okhttp3.MediaType
 *  okhttp3.RequestBody$Companion
 *  okio.BufferedSink
 *  okio.ByteString
 */
package okhttp3;

import java.io.File;
import java.io.FileDescriptor;
import java.io.IOException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmStatic;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.BufferedSink;
import okio.ByteString;

@Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0006H&J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH&\u00a8\u0006\u000f"}, d2={"Lokhttp3/RequestBody;", "", "()V", "contentLength", "", "contentType", "Lokhttp3/MediaType;", "isDuplex", "", "isOneShot", "writeTo", "", "sink", "Lokio/BufferedSink;", "Companion", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class RequestBody {
    public static final Companion Companion = new Companion(null);

    @JvmStatic
    public static final RequestBody create(File file, MediaType mediaType) {
        return Companion.create(file, mediaType);
    }

    @JvmStatic
    public static final RequestBody create(FileDescriptor fileDescriptor, MediaType mediaType) {
        return Companion.create(fileDescriptor, mediaType);
    }

    @JvmStatic
    public static final RequestBody create(String string, MediaType mediaType) {
        return Companion.create(string, mediaType);
    }

    @Deprecated(level=DeprecationLevel.WARNING, message="Moved to extension function. Put the 'file' argument first to fix Java", replaceWith=@ReplaceWith(expression="file.asRequestBody(contentType)", imports={"okhttp3.RequestBody.Companion.asRequestBody"}))
    @JvmStatic
    public static final RequestBody create(MediaType mediaType, File file) {
        return Companion.create(mediaType, file);
    }

    @Deprecated(level=DeprecationLevel.WARNING, message="Moved to extension function. Put the 'content' argument first to fix Java", replaceWith=@ReplaceWith(expression="content.toRequestBody(contentType)", imports={"okhttp3.RequestBody.Companion.toRequestBody"}))
    @JvmStatic
    public static final RequestBody create(MediaType mediaType, String string) {
        return Companion.create(mediaType, string);
    }

    @Deprecated(level=DeprecationLevel.WARNING, message="Moved to extension function. Put the 'content' argument first to fix Java", replaceWith=@ReplaceWith(expression="content.toRequestBody(contentType)", imports={"okhttp3.RequestBody.Companion.toRequestBody"}))
    @JvmStatic
    public static final RequestBody create(MediaType mediaType, ByteString byteString) {
        return Companion.create(mediaType, byteString);
    }

    @Deprecated(level=DeprecationLevel.WARNING, message="Moved to extension function. Put the 'content' argument first to fix Java", replaceWith=@ReplaceWith(expression="content.toRequestBody(contentType, offset, byteCount)", imports={"okhttp3.RequestBody.Companion.toRequestBody"}))
    @JvmStatic
    public static final RequestBody create(MediaType mediaType, byte[] byArray) {
        return Companion.create(mediaType, byArray);
    }

    @Deprecated(level=DeprecationLevel.WARNING, message="Moved to extension function. Put the 'content' argument first to fix Java", replaceWith=@ReplaceWith(expression="content.toRequestBody(contentType, offset, byteCount)", imports={"okhttp3.RequestBody.Companion.toRequestBody"}))
    @JvmStatic
    public static final RequestBody create(MediaType mediaType, byte[] byArray, int n) {
        return Companion.create(mediaType, byArray, n);
    }

    @Deprecated(level=DeprecationLevel.WARNING, message="Moved to extension function. Put the 'content' argument first to fix Java", replaceWith=@ReplaceWith(expression="content.toRequestBody(contentType, offset, byteCount)", imports={"okhttp3.RequestBody.Companion.toRequestBody"}))
    @JvmStatic
    public static final RequestBody create(MediaType mediaType, byte[] byArray, int n, int n2) {
        return Companion.create(mediaType, byArray, n, n2);
    }

    @JvmStatic
    public static final RequestBody create(ByteString byteString, MediaType mediaType) {
        return Companion.create(byteString, mediaType);
    }

    @JvmStatic
    public static final RequestBody create(byte[] byArray) {
        return Companion.create(byArray);
    }

    @JvmStatic
    public static final RequestBody create(byte[] byArray, MediaType mediaType) {
        return Companion.create(byArray, mediaType);
    }

    @JvmStatic
    public static final RequestBody create(byte[] byArray, MediaType mediaType, int n) {
        return Companion.create(byArray, mediaType, n);
    }

    @JvmStatic
    public static final RequestBody create(byte[] byArray, MediaType mediaType, int n, int n2) {
        return Companion.create(byArray, mediaType, n, n2);
    }

    public long contentLength() throws IOException {
        return -1L;
    }

    public abstract MediaType contentType();

    public boolean isDuplex() {
        return false;
    }

    public boolean isOneShot() {
        return false;
    }

    public abstract void writeTo(BufferedSink var1) throws IOException;
}
