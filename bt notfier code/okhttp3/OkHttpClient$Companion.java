/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  okhttp3.ConnectionSpec
 *  okhttp3.OkHttpClient
 *  okhttp3.Protocol
 */
package okhttp3;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import okhttp3.ConnectionSpec;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;

/*
 * Exception performing whole class analysis ignored.
 */
@Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0007\u00a8\u0006\u000b"}, d2={"Lokhttp3/OkHttpClient$Companion;", "", "()V", "DEFAULT_CONNECTION_SPECS", "", "Lokhttp3/ConnectionSpec;", "getDEFAULT_CONNECTION_SPECS$okhttp", "()Ljava/util/List;", "DEFAULT_PROTOCOLS", "Lokhttp3/Protocol;", "getDEFAULT_PROTOCOLS$okhttp", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public static final class OkHttpClient.Companion {
    private OkHttpClient.Companion() {
    }

    public /* synthetic */ OkHttpClient.Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public final List<ConnectionSpec> getDEFAULT_CONNECTION_SPECS$okhttp() {
        return OkHttpClient.access$getDEFAULT_CONNECTION_SPECS$cp();
    }

    public final List<Protocol> getDEFAULT_PROTOCOLS$okhttp() {
        return OkHttpClient.access$getDEFAULT_PROTOCOLS$cp();
    }
}
