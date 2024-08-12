/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.Lambda
 *  kotlin.jvm.internal.Ref$ObjectRef
 *  okhttp3.internal.http2.Http2Connection
 *  okhttp3.internal.http2.Settings
 */
package okhttp3.internal.http2;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import okhttp3.internal.http2.Http2Connection;
import okhttp3.internal.http2.Settings;

@Metadata(d1={"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
static final class Http2Connection.ReaderRunnable.applyAndAckSettings.1.1.2
extends Lambda
implements Function0<Unit> {
    final Ref.ObjectRef<Settings> $newPeerSettings;
    final Http2Connection this$0;

    Http2Connection.ReaderRunnable.applyAndAckSettings.1.1.2(Http2Connection http2Connection, Ref.ObjectRef<Settings> objectRef) {
        this.this$0 = http2Connection;
        this.$newPeerSettings = objectRef;
        super(0);
    }

    public final void invoke() {
        this.this$0.getListener$okhttp().onSettings(this.this$0, (Settings)this.$newPeerSettings.element);
    }
}
