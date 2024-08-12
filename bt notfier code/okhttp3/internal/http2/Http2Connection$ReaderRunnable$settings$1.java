/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.Lambda
 *  okhttp3.internal.http2.Http2Connection$ReaderRunnable
 *  okhttp3.internal.http2.Settings
 */
package okhttp3.internal.http2;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import okhttp3.internal.http2.Http2Connection;
import okhttp3.internal.http2.Settings;

@Metadata(d1={"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
static final class Http2Connection.ReaderRunnable.settings.1
extends Lambda
implements Function0<Unit> {
    final boolean $clearPrevious;
    final Settings $settings;
    final Http2Connection.ReaderRunnable this$0;

    Http2Connection.ReaderRunnable.settings.1(Http2Connection.ReaderRunnable readerRunnable, boolean bl, Settings settings2) {
        this.this$0 = readerRunnable;
        this.$clearPrevious = bl;
        this.$settings = settings2;
        super(0);
    }

    public final void invoke() {
        this.this$0.applyAndAckSettings(this.$clearPrevious, this.$settings);
    }
}
