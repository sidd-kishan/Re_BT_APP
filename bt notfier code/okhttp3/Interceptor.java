/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  okhttp3.Interceptor$Chain
 *  okhttp3.Interceptor$Companion
 *  okhttp3.Response
 */
package okhttp3;

import java.io.IOException;
import kotlin.Metadata;
import okhttp3.Interceptor;
import okhttp3.Response;

@Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00e6\u0080\u0001\u0018\u0000 \u00072\u00020\u0001:\u0002\u0006\u0007J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\b"}, d2={"Lokhttp3/Interceptor;", "", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "Chain", "Companion", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public interface Interceptor {
    public static final Companion Companion = okhttp3.Interceptor$Companion.$$INSTANCE;

    public Response intercept(Chain var1) throws IOException;
}
