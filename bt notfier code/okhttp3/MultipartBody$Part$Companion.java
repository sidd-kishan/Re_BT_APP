/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  okhttp3.Headers
 *  okhttp3.Headers$Builder
 *  okhttp3.MultipartBody
 *  okhttp3.MultipartBody$Part
 *  okhttp3.RequestBody
 *  okhttp3.RequestBody$Companion
 */
package okhttp3;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Headers;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

@Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0007J\"\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0007\u001a\u00020\bH\u0007\u00a8\u0006\u000e"}, d2={"Lokhttp3/MultipartBody$Part$Companion;", "", "()V", "create", "Lokhttp3/MultipartBody$Part;", "headers", "Lokhttp3/Headers;", "body", "Lokhttp3/RequestBody;", "createFormData", "name", "", "value", "filename", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public static final class MultipartBody.Part.Companion {
    private MultipartBody.Part.Companion() {
    }

    public /* synthetic */ MultipartBody.Part.Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @JvmStatic
    public final MultipartBody.Part create(Headers headers, RequestBody requestBody) {
        Intrinsics.checkNotNullParameter((Object)requestBody, (String)"body");
        String string = headers == null ? null : headers.get("Content-Type");
        boolean bl = true;
        boolean bl2 = string == null;
        if (!bl2) throw (Throwable)new IllegalArgumentException("Unexpected header: Content-Type".toString());
        string = headers == null ? null : headers.get("Content-Length");
        bl2 = string == null ? bl : false;
        if (!bl2) throw (Throwable)new IllegalArgumentException("Unexpected header: Content-Length".toString());
        return new MultipartBody.Part(headers, requestBody, null);
    }

    @JvmStatic
    public final MultipartBody.Part create(RequestBody requestBody) {
        Intrinsics.checkNotNullParameter((Object)requestBody, (String)"body");
        return this.create(null, requestBody);
    }

    @JvmStatic
    public final MultipartBody.Part createFormData(String string, String string2) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"name");
        Intrinsics.checkNotNullParameter((Object)string2, (String)"value");
        return this.createFormData(string, null, RequestBody.Companion.create$default((RequestBody.Companion)RequestBody.Companion, (String)string2, null, (int)1, null));
    }

    @JvmStatic
    public final MultipartBody.Part createFormData(String string, String string2, RequestBody requestBody) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"name");
        Intrinsics.checkNotNullParameter((Object)requestBody, (String)"body");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("form-data; name=");
        MultipartBody.Companion.appendQuotedString$okhttp(stringBuilder, string);
        if (string2 != null) {
            stringBuilder.append("; filename=");
            MultipartBody.Companion.appendQuotedString$okhttp(stringBuilder, string2);
        }
        string = stringBuilder.toString();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"StringBuilder().apply(builderAction).toString()");
        return this.create(new Headers.Builder().addUnsafeNonAscii("Content-Disposition", string).build(), requestBody);
    }
}
