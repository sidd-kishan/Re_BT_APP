/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  okhttp3.Headers
 *  okhttp3.MediaType
 *  okhttp3.MultipartBody
 *  okhttp3.MultipartBody$Part
 *  okhttp3.RequestBody
 *  okhttp3.internal.Util
 *  okio.ByteString
 */
package okhttp3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.internal.Util;
import okio.ByteString;

@Metadata(d1={"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u000b\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0003J \u0010\u000b\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000f\u001a\u00020\u0010J\u0018\u0010\u0011\u001a\u00020\u00002\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\bJ\u000e\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010\u0017\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0002\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2={"Lokhttp3/MultipartBody$Builder;", "", "boundary", "", "(Ljava/lang/String;)V", "Lokio/ByteString;", "parts", "", "Lokhttp3/MultipartBody$Part;", "type", "Lokhttp3/MediaType;", "addFormDataPart", "name", "value", "filename", "body", "Lokhttp3/RequestBody;", "addPart", "headers", "Lokhttp3/Headers;", "part", "build", "Lokhttp3/MultipartBody;", "setType", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public static final class MultipartBody.Builder {
    private final ByteString boundary;
    private final List<MultipartBody.Part> parts;
    private MediaType type;

    public MultipartBody.Builder() {
        this(null, 1, null);
    }

    public MultipartBody.Builder(String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"boundary");
        this.boundary = ByteString.Companion.encodeUtf8(string);
        this.type = MultipartBody.MIXED;
        this.parts = new ArrayList();
    }

    public /* synthetic */ MultipartBody.Builder(String string, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 1) != 0) {
            string = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue((Object)string, (String)"randomUUID().toString()");
        }
        this(string);
    }

    public final MultipartBody.Builder addFormDataPart(String string, String string2) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"name");
        Intrinsics.checkNotNullParameter((Object)string2, (String)"value");
        MultipartBody.Builder builder = this;
        builder.addPart(MultipartBody.Part.Companion.createFormData(string, string2));
        return builder;
    }

    public final MultipartBody.Builder addFormDataPart(String string, String string2, RequestBody requestBody) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"name");
        Intrinsics.checkNotNullParameter((Object)requestBody, (String)"body");
        MultipartBody.Builder builder = this;
        builder.addPart(MultipartBody.Part.Companion.createFormData(string, string2, requestBody));
        return builder;
    }

    public final MultipartBody.Builder addPart(Headers headers, RequestBody requestBody) {
        Intrinsics.checkNotNullParameter((Object)requestBody, (String)"body");
        MultipartBody.Builder builder = this;
        builder.addPart(MultipartBody.Part.Companion.create(headers, requestBody));
        return builder;
    }

    public final MultipartBody.Builder addPart(MultipartBody.Part part) {
        Intrinsics.checkNotNullParameter((Object)part, (String)"part");
        MultipartBody.Builder builder = this;
        ((Collection)builder.parts).add(part);
        return builder;
    }

    public final MultipartBody.Builder addPart(RequestBody requestBody) {
        Intrinsics.checkNotNullParameter((Object)requestBody, (String)"body");
        MultipartBody.Builder builder = this;
        builder.addPart(MultipartBody.Part.Companion.create(requestBody));
        return builder;
    }

    public final MultipartBody build() {
        if (!(((Collection)this.parts).isEmpty() ^ true)) throw (Throwable)new IllegalStateException("Multipart body must have at least one part.".toString());
        return new MultipartBody(this.boundary, this.type, Util.toImmutableList(this.parts));
    }

    public final MultipartBody.Builder setType(MediaType mediaType) {
        Intrinsics.checkNotNullParameter((Object)mediaType, (String)"type");
        MultipartBody.Builder builder = this;
        if (!Intrinsics.areEqual((Object)mediaType.type(), (Object)"multipart")) throw (Throwable)new IllegalArgumentException(Intrinsics.stringPlus((String)"multipart != ", (Object)mediaType).toString());
        builder.type = mediaType;
        return builder;
    }
}
