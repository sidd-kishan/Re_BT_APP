/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.Lambda
 *  okhttp3.internal.http2.ErrorCode
 *  okhttp3.internal.http2.Header
 *  okhttp3.internal.http2.Http2Connection
 */
package okhttp3.internal.http2;

import java.io.IOException;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.Header;
import okhttp3.internal.http2.Http2Connection;

@Metadata(d1={"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
static final class Http2Connection.pushHeadersLater.1
extends Lambda
implements Function0<Unit> {
    final boolean $inFinished;
    final List<Header> $requestHeaders;
    final int $streamId;
    final Http2Connection this$0;

    Http2Connection.pushHeadersLater.1(Http2Connection http2Connection, int n, List<Header> list, boolean bl) {
        this.this$0 = http2Connection;
        this.$streamId = n;
        this.$requestHeaders = list;
        this.$inFinished = bl;
        super(0);
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled force condition propagation
     */
    public final void invoke() {
        var2_1 = Http2Connection.access$getPushObserver$p((Http2Connection)this.this$0).onHeaders(this.$streamId, this.$requestHeaders, this.$inFinished);
        var4_2 = this.this$0;
        var1_4 = this.$streamId;
        var3_5 = this.$inFinished;
        if (!var2_1) ** GOTO lbl8
        var4_2.getWriter().rstStream(var1_4, ErrorCode.CANCEL);
lbl8:
        // 2 sources

        if (!var2_1) {
            if (var3_5 == false) return;
        }
        synchronized (var4_2) {
        }
        {
            catch (IOException var4_3) {
                return;
            }
            {
                try {
                    Http2Connection.access$getCurrentPushRequests$p((Http2Connection)var4_2).remove(var1_4);
                    return;
                }
                catch (Throwable var5_6) {}
                {
                    throw var5_6;
                }
            }
        }
    }
}
