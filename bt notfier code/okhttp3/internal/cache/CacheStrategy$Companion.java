/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  okhttp3.Request
 *  okhttp3.Response
 */
package okhttp3.internal.cache;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Request;
import okhttp3.Response;

@Metadata(d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b\u00a8\u0006\t"}, d2={"Lokhttp3/internal/cache/CacheStrategy$Companion;", "", "()V", "isCacheable", "", "response", "Lokhttp3/Response;", "request", "Lokhttp3/Request;", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public static final class CacheStrategy.Companion {
    private CacheStrategy.Companion() {
    }

    public /* synthetic */ CacheStrategy.Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /*
     * Unable to fully structure code
     */
    public final boolean isCacheable(Response var1_1, Request var2_2) {
        block6: {
            Intrinsics.checkNotNullParameter((Object)var1_1, (String)"response");
            Intrinsics.checkNotNullParameter((Object)var2_2, (String)"request");
            var3_3 = var1_1.code();
            var5_4 = false;
            if (var3_3 == 200 || var3_3 == 410 || var3_3 == 414 || var3_3 == 501 || var3_3 == 203 || var3_3 == 204) break block6;
            if (var3_3 == 307) ** GOTO lbl-1000
            if (var3_3 == 308 || var3_3 == 404 || var3_3 == 405) break block6;
            switch (var3_3) {
                default: {
                    return false;
                }
                case 302: lbl-1000:
                // 2 sources

                {
                    if (Response.header$default((Response)var1_1, (String)"Expires", null, (int)2, null) != null || var1_1.cacheControl().maxAgeSeconds() != -1 || var1_1.cacheControl().isPublic() || var1_1.cacheControl().isPrivate()) break;
                    return false;
                }
                case 300: 
                case 301: 
            }
        }
        var4_5 = var5_4;
        if (var1_1.cacheControl().noStore() != false) return var4_5;
        var4_5 = var5_4;
        if (var2_2.cacheControl().noStore() != false) return var4_5;
        var4_5 = true;
        return var4_5;
    }
}
