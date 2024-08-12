/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  okhttp3.internal.http2.ErrorCode
 *  okhttp3.internal.http2.Header
 *  okhttp3.internal.http2.PushObserver$Companion
 *  okhttp3.internal.http2.PushObserver$Companion$PushObserverCancel
 *  okio.BufferedSource
 */
package okhttp3.internal.http2;

import java.io.IOException;
import java.util.List;
import kotlin.Metadata;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.Header;
import okhttp3.internal.http2.PushObserver;
import okio.BufferedSource;

@Metadata(d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0003H&J&\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\t\u001a\u00020\u0003H&J\u001e\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\r0\fH&J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0013H&\u00a8\u0006\u0015"}, d2={"Lokhttp3/internal/http2/PushObserver;", "", "onData", "", "streamId", "", "source", "Lokio/BufferedSource;", "byteCount", "last", "onHeaders", "responseHeaders", "", "Lokhttp3/internal/http2/Header;", "onRequest", "requestHeaders", "onReset", "", "errorCode", "Lokhttp3/internal/http2/ErrorCode;", "Companion", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public interface PushObserver {
    public static final PushObserver CANCEL;
    public static final Companion Companion;

    static {
        Companion = okhttp3.internal.http2.PushObserver$Companion.$$INSTANCE;
        CANCEL = (PushObserver)new Companion.PushObserverCancel();
    }

    public boolean onData(int var1, BufferedSource var2, int var3, boolean var4) throws IOException;

    public boolean onHeaders(int var1, List<Header> var2, boolean var3);

    public boolean onRequest(int var1, List<Header> var2);

    public void onReset(int var1, ErrorCode var2);
}
