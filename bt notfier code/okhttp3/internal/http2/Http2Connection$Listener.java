/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  okhttp3.internal.http2.Http2Connection
 *  okhttp3.internal.http2.Http2Connection$Listener$Companion
 *  okhttp3.internal.http2.Http2Stream
 *  okhttp3.internal.http2.Settings
 */
package okhttp3.internal.http2;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.http2.Http2Connection;
import okhttp3.internal.http2.Http2Stream;
import okhttp3.internal.http2.Settings;

@Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH&\u00a8\u0006\r"}, d2={"Lokhttp3/internal/http2/Http2Connection$Listener;", "", "()V", "onSettings", "", "connection", "Lokhttp3/internal/http2/Http2Connection;", "settings", "Lokhttp3/internal/http2/Settings;", "onStream", "stream", "Lokhttp3/internal/http2/Http2Stream;", "Companion", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public static abstract class Http2Connection.Listener {
    public static final Companion Companion = new Companion(null);
    public static final Http2Connection.Listener REFUSE_INCOMING_STREAMS = (Http2Connection.Listener)new /* Unavailable Anonymous Inner Class!! */;

    public void onSettings(Http2Connection http2Connection, Settings settings) {
        Intrinsics.checkNotNullParameter((Object)http2Connection, (String)"connection");
        Intrinsics.checkNotNullParameter((Object)settings, (String)"settings");
    }

    public abstract void onStream(Http2Stream var1) throws IOException;
}
