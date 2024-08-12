/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  okhttp3.internal.http2.ErrorCode
 */
package okhttp3.internal.http2;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import okhttp3.internal.http2.ErrorCode;

/*
 * Exception performing whole class analysis ignored.
 */
@Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0007"}, d2={"Lokhttp3/internal/http2/ErrorCode$Companion;", "", "()V", "fromHttp2", "Lokhttp3/internal/http2/ErrorCode;", "code", "", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public static final class ErrorCode.Companion {
    private ErrorCode.Companion() {
    }

    public /* synthetic */ ErrorCode.Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public final ErrorCode fromHttp2(int n) {
        ErrorCode errorCode2;
        for (ErrorCode errorCode2 : ErrorCode.values()) {
            boolean bl = errorCode2.getHttpCode() == n;
            if (bl) return errorCode2;
        }
        errorCode2 = null;
        return errorCode2;
    }
}
