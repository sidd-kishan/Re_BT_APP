/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.Intrinsics
 *  okhttp3.Cookie
 *  okhttp3.CookieJar
 *  okhttp3.HttpUrl
 */
package okhttp3;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;

@Metadata(d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001e\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016\u00a8\u0006\u000b"}, d2={"Lokhttp3/CookieJar$Companion$NoCookies;", "Lokhttp3/CookieJar;", "()V", "loadForRequest", "", "Lokhttp3/Cookie;", "url", "Lokhttp3/HttpUrl;", "saveFromResponse", "", "cookies", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
private static final class CookieJar.Companion.NoCookies
implements CookieJar {
    public List<Cookie> loadForRequest(HttpUrl httpUrl) {
        Intrinsics.checkNotNullParameter((Object)httpUrl, (String)"url");
        return CollectionsKt.emptyList();
    }

    public void saveFromResponse(HttpUrl httpUrl, List<Cookie> list) {
        Intrinsics.checkNotNullParameter((Object)httpUrl, (String)"url");
        Intrinsics.checkNotNullParameter(list, (String)"cookies");
    }
}
