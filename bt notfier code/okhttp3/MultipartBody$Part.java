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
 *  okhttp3.Headers
 *  okhttp3.MultipartBody$Part$Companion
 *  okhttp3.RequestBody
 */
package okhttp3;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import okhttp3.Headers;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

@Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0019\b\u0002\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\r\u0010\u0004\u001a\u00020\u0005H\u0007\u00a2\u0006\u0002\b\tJ\u000f\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0007\u00a2\u0006\u0002\b\nR\u0013\u0010\u0004\u001a\u00020\u00058\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0007R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\b\u00a8\u0006\f"}, d2={"Lokhttp3/MultipartBody$Part;", "", "headers", "Lokhttp3/Headers;", "body", "Lokhttp3/RequestBody;", "(Lokhttp3/Headers;Lokhttp3/RequestBody;)V", "()Lokhttp3/RequestBody;", "()Lokhttp3/Headers;", "-deprecated_body", "-deprecated_headers", "Companion", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public static final class MultipartBody.Part {
    public static final Companion Companion = new Companion(null);
    private final RequestBody body;
    private final Headers headers;

    private MultipartBody.Part(Headers headers, RequestBody requestBody) {
        this.headers = headers;
        this.body = requestBody;
    }

    public /* synthetic */ MultipartBody.Part(Headers headers, RequestBody requestBody, DefaultConstructorMarker defaultConstructorMarker) {
        this(headers, requestBody);
    }

    @JvmStatic
    public static final MultipartBody.Part create(Headers headers, RequestBody requestBody) {
        return Companion.create(headers, requestBody);
    }

    @JvmStatic
    public static final MultipartBody.Part create(RequestBody requestBody) {
        return Companion.create(requestBody);
    }

    @JvmStatic
    public static final MultipartBody.Part createFormData(String string, String string2) {
        return Companion.createFormData(string, string2);
    }

    @JvmStatic
    public static final MultipartBody.Part createFormData(String string, String string2, RequestBody requestBody) {
        return Companion.createFormData(string, string2, requestBody);
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="body", imports={}))
    public final RequestBody _deprecated_body() {
        return this.body;
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="headers", imports={}))
    public final Headers _deprecated_headers() {
        return this.headers;
    }

    public final RequestBody body() {
        return this.body;
    }

    public final Headers headers() {
        return this.headers;
    }
}
