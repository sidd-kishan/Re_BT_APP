/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.ExceptionsKt
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  okhttp3.Call
 *  okhttp3.Callback
 *  okhttp3.Request
 *  okhttp3.Response
 *  okhttp3.internal.Util
 *  okhttp3.internal.connection.RealCall
 *  okhttp3.internal.platform.Platform
 */
package okhttp3.internal.connection;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RealCall;
import okhttp3.internal.platform.Platform;

@Metadata(d1={"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019J\u0012\u0010\u001a\u001a\u00020\u00172\n\u0010\u001b\u001a\u00060\u0000R\u00020\u0006J\b\u0010\u001c\u001a\u00020\u0017H\u0016R\u0011\u0010\u0005\u001a\u00020\u00068F\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u001e\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000f8F\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u00138F\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001d"}, d2={"Lokhttp3/internal/connection/RealCall$AsyncCall;", "Ljava/lang/Runnable;", "responseCallback", "Lokhttp3/Callback;", "(Lokhttp3/internal/connection/RealCall;Lokhttp3/Callback;)V", "call", "Lokhttp3/internal/connection/RealCall;", "getCall", "()Lokhttp3/internal/connection/RealCall;", "<set-?>", "Ljava/util/concurrent/atomic/AtomicInteger;", "callsPerHost", "getCallsPerHost", "()Ljava/util/concurrent/atomic/AtomicInteger;", "host", "", "getHost", "()Ljava/lang/String;", "request", "Lokhttp3/Request;", "getRequest", "()Lokhttp3/Request;", "executeOn", "", "executorService", "Ljava/util/concurrent/ExecutorService;", "reuseCallsPerHostFrom", "other", "run", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public final class RealCall.AsyncCall
implements Runnable {
    private volatile AtomicInteger callsPerHost;
    private final Callback responseCallback;
    final RealCall this$0;

    public RealCall.AsyncCall(RealCall realCall, Callback callback) {
        Intrinsics.checkNotNullParameter((Object)realCall, (String)"this$0");
        Intrinsics.checkNotNullParameter((Object)callback, (String)"responseCallback");
        this.this$0 = realCall;
        this.responseCallback = callback;
        this.callsPerHost = new AtomicInteger(0);
    }

    public final void executeOn(ExecutorService object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"executorService");
        Object object2 = this.this$0.getClient().dispatcher();
        if (Util.assertionsEnabled && Thread.holdsLock(object2)) {
            object = new StringBuilder();
            ((StringBuilder)object).append("Thread ");
            ((StringBuilder)object).append((Object)Thread.currentThread().getName());
            ((StringBuilder)object).append(" MUST NOT hold lock on ");
            ((StringBuilder)object).append(object2);
            throw new AssertionError((Object)((StringBuilder)object).toString());
        }
        try {
            try {
                object.execute(this);
            }
            catch (RejectedExecutionException rejectedExecutionException) {
                object2 = new InterruptedIOException("executor rejected");
                ((Throwable)object2).initCause(rejectedExecutionException);
                this.this$0.noMoreExchanges$okhttp((IOException)object2);
                this.responseCallback.onFailure((Call)this.this$0, (IOException)object2);
                this.this$0.getClient().dispatcher().finished$okhttp(this);
            }
            return;
        }
        catch (Throwable throwable) {}
        this.this$0.getClient().dispatcher().finished$okhttp(this);
        throw throwable;
    }

    public final RealCall getCall() {
        return this.this$0;
    }

    public final AtomicInteger getCallsPerHost() {
        return this.callsPerHost;
    }

    public final String getHost() {
        return this.this$0.getOriginalRequest().url().host();
    }

    public final Request getRequest() {
        return this.this$0.getOriginalRequest();
    }

    public final void reuseCallsPerHostFrom(RealCall.AsyncCall asyncCall) {
        Intrinsics.checkNotNullParameter((Object)asyncCall, (String)"other");
        this.callsPerHost = asyncCall.callsPerHost;
    }

    /*
     * Unable to fully structure code
     * Enabled unnecessary exception pruning
     */
    @Override
    public void run() {
        block17: {
            block18: {
                block15: {
                    var3_1 = Intrinsics.stringPlus((String)"OkHttp ", (Object)this.this$0.redactedUrl$okhttp());
                    var6_9 = this.this$0;
                    var5_10 = Thread.currentThread();
                    var4_11 = var5_10.getName();
                    var5_10.setName(var3_1);
                    try {
                        RealCall.access$getTimeout$p((RealCall)var6_9).enter();
                    }
                    catch (Throwable var3_8) {
                        var5_10.setName(var4_11);
                        throw var3_8;
                    }
                    var3_1 = var6_9.getResponseWithInterceptorChain$okhttp();
                    var1_12 = true;
                    var2_13 = true;
                    this.responseCallback.onResponse((Call)var6_9, (Response)var3_1);
                    var3_1 = var6_9.getClient().dispatcher();
                    break block18;
                    catch (Throwable var3_2) {
                        var1_12 = var2_13;
                        break block15;
                    }
                    catch (IOException var3_3) {
                        ** GOTO lbl37
                    }
                    catch (Throwable var3_4) {
                        var1_12 = false;
                    }
                }
                try {
                    var6_9.cancel();
                    if (var1_12 != false) throw var3_5;
                    var7_14 = new IOException(Intrinsics.stringPlus((String)"canceled due to ", (Object)var3_5));
                    ExceptionsKt.addSuppressed((Throwable)var7_14, (Throwable)var3_5);
                    this.responseCallback.onFailure((Call)var6_9, var7_14);
                    throw var3_5;
                    catch (IOException var3_7) {
                        var1_12 = false;
                    }
lbl37:
                    // 2 sources

                    if (var1_12) {
                        Platform.Companion.get().log(Intrinsics.stringPlus((String)"Callback failure for ", (Object)RealCall.access$toLoggableString((RealCall)var6_9)), 4, (Throwable)var3_1);
                    } else {
                        this.responseCallback.onFailure((Call)var6_9, (IOException)var3_1);
                    }
                }
                catch (Throwable var3_6) {
                    break block17;
                }
                var3_1 = var6_9.getClient().dispatcher();
            }
            var3_1.finished$okhttp(this);
            var5_10.setName(var4_11);
            return;
        }
        var6_9.getClient().dispatcher().finished$okhttp(this);
        throw var3_6;
    }
}
