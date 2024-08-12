/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.Lambda
 *  okhttp3.internal.ws.RealWebSocket
 */
package okhttp3.internal.ws;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import okhttp3.internal.ws.RealWebSocket;

@Metadata(d1={"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
static final class RealWebSocket.writeOneFrame.1.1
extends Lambda
implements Function0<Unit> {
    final RealWebSocket this$0;

    RealWebSocket.writeOneFrame.1.1(RealWebSocket realWebSocket) {
        this.this$0 = realWebSocket;
        super(0);
    }

    public final void invoke() {
        this.this$0.cancel();
    }
}
