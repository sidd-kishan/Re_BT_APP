/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  okhttp3.Interceptor
 *  okhttp3.Interceptor$Chain
 *  okhttp3.Response
 *  okhttp3.internal.connection.Exchange
 *  okhttp3.internal.http.RealInterceptorChain
 */
package okhttp3.internal.connection;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.Response;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.http.RealInterceptorChain;

@Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016\u00a8\u0006\u0007"}, d2={"Lokhttp3/internal/connection/ConnectInterceptor;", "Lokhttp3/Interceptor;", "()V", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public final class ConnectInterceptor
implements Interceptor {
    public static final ConnectInterceptor INSTANCE = new ConnectInterceptor();

    private ConnectInterceptor() {
    }

    public Response intercept(Interceptor.Chain chain) throws IOException {
        Intrinsics.checkNotNullParameter((Object)chain, (String)"chain");
        chain = (RealInterceptorChain)chain;
        return RealInterceptorChain.copy$okhttp$default((RealInterceptorChain)chain, (int)0, (Exchange)chain.getCall$okhttp().initExchange$okhttp((RealInterceptorChain)chain), null, (int)0, (int)0, (int)0, (int)61, null).proceed(chain.getRequest$okhttp());
    }
}
