/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  okhttp3.Cookie
 *  okhttp3.CookieJar$Companion
 *  okhttp3.CookieJar$Companion$NoCookies
 *  okhttp3.HttpUrl
 */
package okhttp3;

import java.util.List;
import kotlin.Metadata;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;

@Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u0000 \n2\u00020\u0001:\u0001\nJ\u0016\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u001e\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&\u00a8\u0006\u000b"}, d2={"Lokhttp3/CookieJar;", "", "loadForRequest", "", "Lokhttp3/Cookie;", "url", "Lokhttp3/HttpUrl;", "saveFromResponse", "", "cookies", "Companion", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public interface CookieJar {
    public static final Companion Companion = okhttp3.CookieJar$Companion.$$INSTANCE;
    public static final CookieJar NO_COOKIES = (CookieJar)new Companion.NoCookies();

    public List<Cookie> loadForRequest(HttpUrl var1);

    public void saveFromResponse(HttpUrl var1, List<Cookie> var2);
}
