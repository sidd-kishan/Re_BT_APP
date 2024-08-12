/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  okhttp3.Protocol
 */
package okhttp3;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Protocol;

/*
 * Exception performing whole class analysis ignored.
 */
@Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007\u00a8\u0006\u0007"}, d2={"Lokhttp3/Protocol$Companion;", "", "()V", "get", "Lokhttp3/Protocol;", "protocol", "", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public static final class Protocol.Companion {
    private Protocol.Companion() {
    }

    public /* synthetic */ Protocol.Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @JvmStatic
    public final Protocol get(String string) throws IOException {
        Intrinsics.checkNotNullParameter((Object)string, (String)"protocol");
        if (Intrinsics.areEqual((Object)string, (Object)Protocol.access$getProtocol$p((Protocol)Protocol.HTTP_1_0))) {
            string = Protocol.HTTP_1_0;
        } else if (Intrinsics.areEqual((Object)string, (Object)Protocol.access$getProtocol$p((Protocol)Protocol.HTTP_1_1))) {
            string = Protocol.HTTP_1_1;
        } else if (Intrinsics.areEqual((Object)string, (Object)Protocol.access$getProtocol$p((Protocol)Protocol.H2_PRIOR_KNOWLEDGE))) {
            string = Protocol.H2_PRIOR_KNOWLEDGE;
        } else if (Intrinsics.areEqual((Object)string, (Object)Protocol.access$getProtocol$p((Protocol)Protocol.HTTP_2))) {
            string = Protocol.HTTP_2;
        } else if (Intrinsics.areEqual((Object)string, (Object)Protocol.access$getProtocol$p((Protocol)Protocol.SPDY_3))) {
            string = Protocol.SPDY_3;
        } else {
            if (!Intrinsics.areEqual((Object)string, (Object)Protocol.access$getProtocol$p((Protocol)Protocol.QUIC))) throw new IOException(Intrinsics.stringPlus((String)"Unexpected protocol: ", (Object)string));
            string = Protocol.QUIC;
        }
        return string;
    }
}
