/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  okhttp3.Authenticator$Companion
 *  okhttp3.Authenticator$Companion$AuthenticatorNone
 *  okhttp3.Request
 *  okhttp3.Response
 *  okhttp3.Route
 *  okhttp3.internal.authenticator.JavaNetAuthenticator
 */
package okhttp3;

import java.io.IOException;
import kotlin.Metadata;
import okhttp3.Authenticator;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;
import okhttp3.internal.authenticator.JavaNetAuthenticator;

@Metadata(d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00e6\u0080\u0001\u0018\u0000 \b2\u00020\u0001:\u0001\bJ\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&\u00a8\u0006\t"}, d2={"Lokhttp3/Authenticator;", "", "authenticate", "Lokhttp3/Request;", "route", "Lokhttp3/Route;", "response", "Lokhttp3/Response;", "Companion", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public interface Authenticator {
    public static final Companion Companion = okhttp3.Authenticator$Companion.$$INSTANCE;
    public static final Authenticator JAVA_NET_AUTHENTICATOR;
    public static final Authenticator NONE;

    static {
        NONE = (Authenticator)new Companion.AuthenticatorNone();
        JAVA_NET_AUTHENTICATOR = (Authenticator)new JavaNetAuthenticator(null, 1, null);
    }

    public Request authenticate(Route var1, Response var2) throws IOException;
}
