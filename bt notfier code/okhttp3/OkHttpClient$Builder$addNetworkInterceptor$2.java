/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  okhttp3.Interceptor
 *  okhttp3.Interceptor$Chain
 *  okhttp3.Response
 */
package okhttp3;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.Response;

@Metadata(d1={"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2={"<anonymous>", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;"}, k=3, mv={1, 5, 1}, xi=48)
public static final class OkHttpClient.Builder.addNetworkInterceptor.2
implements Interceptor {
    final Function1<Interceptor.Chain, Response> $block;

    public OkHttpClient.Builder.addNetworkInterceptor.2(Function1<? super Interceptor.Chain, Response> function1) {
        this.$block = function1;
    }

    public final Response intercept(Interceptor.Chain chain) {
        Intrinsics.checkNotNullParameter((Object)chain, (String)"chain");
        return (Response)this.$block.invoke((Object)chain);
    }
}
