/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.ExceptionsKt
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.text.StringsKt
 *  okhttp3.Interceptor
 *  okhttp3.Interceptor$Chain
 *  okhttp3.Response
 *  okhttp3.internal.Util
 *  okhttp3.internal.http.HttpMethod
 *  okhttp3.internal.http.RealInterceptorChain
 *  okhttp3.internal.http2.ConnectionShutdownException
 *  okio.BufferedSink
 *  okio.Okio
 *  okio.Sink
 */
package okhttp3.internal.http;

import java.io.IOException;
import java.net.ProtocolException;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.Interceptor;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.http.HttpMethod;
import okhttp3.internal.http.RealInterceptorChain;
import okhttp3.internal.http2.ConnectionShutdownException;
import okio.BufferedSink;
import okio.Okio;
import okio.Sink;

@Metadata(d1={"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2={"Lokhttp3/internal/http/CallServerInterceptor;", "Lokhttp3/Interceptor;", "forWebSocket", "", "(Z)V", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public final class CallServerInterceptor
implements Interceptor {
    private final boolean forWebSocket;

    public CallServerInterceptor(boolean bl) {
        this.forWebSocket = bl;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public Response intercept(Interceptor.Chain var1_1) throws IOException {
        block30: {
            block29: {
                block26: {
                    block28: {
                        block27: {
                            block25: {
                                Intrinsics.checkNotNullParameter((Object)var1_1 /* !! */ , (String)"chain");
                                var1_1 /* !! */  = (RealInterceptorChain)var1_1 /* !! */ ;
                                var10_6 = var1_1 /* !! */ .getExchange$okhttp();
                                Intrinsics.checkNotNull((Object)var10_6);
                                var11_7 = var1_1 /* !! */ .getRequest$okhttp();
                                var12_8 = var11_7.body();
                                var5_9 = System.currentTimeMillis();
                                var9_10 = null;
                                try {
                                    var10_6.writeRequestHeaders(var11_7);
                                    if (HttpMethod.permitsRequestBody((String)var11_7.method()) && var12_8 != null) {
                                        if (!StringsKt.equals((String)"100-continue", (String)var11_7.header("Expect"), (boolean)true)) break block25;
                                        var10_6.flushRequest();
                                        var7_11 /* !! */  = var10_6.readResponseHeaders(true);
                                    }
                                    ** GOTO lbl-1000
                                }
                                catch (IOException var1_4) {
                                    var7_11 /* !! */  = null;
                                    break block26;
                                }
                                try {
                                    var10_6.responseHeadersStart();
                                    var2_12 = 0;
                                    break block27;
                                }
                                catch (IOException var1_2) {
                                    break block26;
                                }
                            }
                            var7_11 /* !! */  = null;
                            var2_12 = 1;
                        }
                        if (var7_11 /* !! */  != null) ** GOTO lbl56
                        var8_13 = var7_11 /* !! */ ;
                        var4_14 = var2_12;
                        try {
                            if (var12_8.isDuplex()) {
                                var8_13 = var7_11 /* !! */ ;
                                var4_14 = var2_12;
                                var10_6.flushRequest();
                                var8_13 = var7_11 /* !! */ ;
                                var4_14 = var2_12;
                                var12_8.writeTo(Okio.buffer((Sink)var10_6.createRequestBody(var11_7, true)));
                                var1_1 /* !! */  = var7_11 /* !! */ ;
                                var3_15 = var2_12;
                            } else {
                                var8_13 = var7_11 /* !! */ ;
                                var4_14 = var2_12;
                                var1_1 /* !! */  = Okio.buffer((Sink)var10_6.createRequestBody(var11_7, false));
                                var8_13 = var7_11 /* !! */ ;
                                var4_14 = var2_12;
                                var12_8.writeTo((BufferedSink)var1_1 /* !! */ );
                                var8_13 = var7_11 /* !! */ ;
                                var4_14 = var2_12;
                                var1_1 /* !! */ .close();
                                var1_1 /* !! */  = var7_11 /* !! */ ;
                                var3_15 = var2_12;
                            }
                            break block28;
lbl56:
                            // 1 sources

                            var8_13 = var7_11 /* !! */ ;
                            var4_14 = var2_12;
                            var10_6.noRequestBody();
                            var1_1 /* !! */  = var7_11 /* !! */ ;
                            var3_15 = var2_12;
                            var8_13 = var7_11 /* !! */ ;
                            var4_14 = var2_12;
                            if (!var10_6.getConnection$okhttp().isMultiplexed$okhttp()) {
                                var8_13 = var7_11 /* !! */ ;
                                var4_14 = var2_12;
                                var10_6.noNewExchangesOnConnection();
                                var1_1 /* !! */  = var7_11 /* !! */ ;
                                var3_15 = var2_12;
                            }
                            break block28;
                        }
                        catch (IOException var1_3) {
                            var7_11 /* !! */  = var8_13;
                            var3_15 = var4_14;
                            break block29;
                        }
lbl-1000:
                        // 1 sources

                        {
                            var10_6.noRequestBody();
                            var1_1 /* !! */  = null;
                            var3_15 = 1;
                        }
                    }
                    if (var12_8 == null) ** GOTO lbl82
                    var8_13 = var1_1 /* !! */ ;
                    var4_14 = var3_15;
                    {
                        block31: {
                            if (var12_8.isDuplex()) break block31;
lbl82:
                            // 2 sources

                            var8_13 = var1_1 /* !! */ ;
                            var4_14 = var3_15;
                            var10_6.finishRequest();
                        }
                        var8_13 = null;
                        var7_11 /* !! */  = var1_1 /* !! */ ;
                        break block30;
                    }
                }
                var3_15 = 1;
            }
            if (var1_1 /* !! */  instanceof ConnectionShutdownException != false) throw var1_1 /* !! */ ;
            if (var10_6.getHasFailure$okhttp() == false) throw var1_1 /* !! */ ;
            var8_13 = var1_1 /* !! */ ;
        }
        var1_1 /* !! */  = var7_11 /* !! */ ;
        var2_12 = var3_15;
        if (var7_11 /* !! */  != null) ** GOTO lbl108
        try {
            var7_11 /* !! */  = var10_6.readResponseHeaders(false);
            Intrinsics.checkNotNull((Object)var7_11 /* !! */ );
            var1_1 /* !! */  = var7_11 /* !! */ ;
            var2_12 = var3_15;
            if (var3_15 != 0) {
                var10_6.responseHeadersStart();
                var2_12 = 0;
                var1_1 /* !! */  = var7_11 /* !! */ ;
            }
lbl108:
            // 4 sources

            var1_1 /* !! */  = var1_1 /* !! */ .request(var11_7).handshake(var10_6.getConnection$okhttp().handshake()).sentRequestAtMillis(var5_9).receivedResponseAtMillis(System.currentTimeMillis()).build();
            var3_15 = var4_14 = var1_1 /* !! */ .code();
            if (var4_14 == 100) {
                var1_1 /* !! */  = var10_6.readResponseHeaders(false);
                Intrinsics.checkNotNull((Object)var1_1 /* !! */ );
                if (var2_12 != 0) {
                    var10_6.responseHeadersStart();
                }
                var1_1 /* !! */  = var1_1 /* !! */ .request(var11_7).handshake(var10_6.getConnection$okhttp().handshake()).sentRequestAtMillis(var5_9).receivedResponseAtMillis(System.currentTimeMillis()).build();
                var3_15 = var1_1 /* !! */ .code();
            }
            var10_6.responseHeadersEnd((Response)var1_1 /* !! */ );
            var1_1 /* !! */  = this.forWebSocket != false && var3_15 == 101 ? var1_1 /* !! */ .newBuilder().body(Util.EMPTY_RESPONSE).build() : var1_1 /* !! */ .newBuilder().body(var10_6.openResponseBody((Response)var1_1 /* !! */ )).build();
            if (StringsKt.equals((String)"close", (String)var1_1 /* !! */ .request().header("Connection"), (boolean)true) || StringsKt.equals((String)"close", (String)Response.header$default((Response)var1_1 /* !! */ , (String)"Connection", null, (int)2, null), (boolean)true)) {
                var10_6.noNewExchangesOnConnection();
            }
            if (var3_15 != 204) {
                if (var3_15 != 205) return var1_1 /* !! */ ;
            }
            var5_9 = (var7_11 /* !! */  = var1_1 /* !! */ .body()) == null ? -1L : var7_11 /* !! */ .contentLength();
            if (var5_9 <= 0L) return var1_1 /* !! */ ;
            var10_6 = new StringBuilder();
            var10_6.append("HTTP ");
            var10_6.append(var3_15);
            var10_6.append(" had non-zero Content-Length: ");
            var1_1 /* !! */  = var1_1 /* !! */ .body();
            var1_1 /* !! */  = var1_1 /* !! */  == null ? var9_10 : Long.valueOf(var1_1 /* !! */ .contentLength());
            var10_6.append(var1_1 /* !! */ );
            var7_11 /* !! */  = new ProtocolException(var10_6.toString());
            throw var7_11 /* !! */ ;
        }
        catch (IOException var1_5) {
            if (var8_13 == null) throw var1_5;
            ExceptionsKt.addSuppressed((Throwable)((Throwable)var8_13), (Throwable)var1_5);
            throw var8_13;
        }
    }
}
