/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.Intrinsics
 */
package okhttp3.internal.http;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007\u00a8\u0006\u000b"}, d2={"Lokhttp3/internal/http/HttpMethod;", "", "()V", "invalidatesCache", "", "method", "", "permitsRequestBody", "redirectsToGet", "redirectsWithBody", "requiresRequestBody", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public final class HttpMethod {
    public static final HttpMethod INSTANCE = new HttpMethod();

    private HttpMethod() {
    }

    @JvmStatic
    public static final boolean permitsRequestBody(String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"method");
        boolean bl = !Intrinsics.areEqual((Object)string, (Object)"GET") && !Intrinsics.areEqual((Object)string, (Object)"HEAD");
        return bl;
    }

    @JvmStatic
    public static final boolean requiresRequestBody(String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"method");
        boolean bl = Intrinsics.areEqual((Object)string, (Object)"POST") || Intrinsics.areEqual((Object)string, (Object)"PUT") || Intrinsics.areEqual((Object)string, (Object)"PATCH") || Intrinsics.areEqual((Object)string, (Object)"PROPPATCH") || Intrinsics.areEqual((Object)string, (Object)"REPORT");
        return bl;
    }

    public final boolean invalidatesCache(String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"method");
        boolean bl = Intrinsics.areEqual((Object)string, (Object)"POST") || Intrinsics.areEqual((Object)string, (Object)"PATCH") || Intrinsics.areEqual((Object)string, (Object)"PUT") || Intrinsics.areEqual((Object)string, (Object)"DELETE") || Intrinsics.areEqual((Object)string, (Object)"MOVE");
        return bl;
    }

    public final boolean redirectsToGet(String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"method");
        return Intrinsics.areEqual((Object)string, (Object)"PROPFIND") ^ true;
    }

    public final boolean redirectsWithBody(String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"method");
        return Intrinsics.areEqual((Object)string, (Object)"PROPFIND");
    }
}
