/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  okhttp3.Request
 *  okhttp3.WebSocket
 *  okhttp3.WebSocketListener
 */
package okhttp3;

import kotlin.Metadata;
import okhttp3.Request;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;

@Metadata(d1={"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00e6\u0080\u0001\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&\u00a8\u0006\b"}, d2={"Lokhttp3/WebSocket$Factory;", "", "newWebSocket", "Lokhttp3/WebSocket;", "request", "Lokhttp3/Request;", "listener", "Lokhttp3/WebSocketListener;", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public static interface WebSocket.Factory {
    public WebSocket newWebSocket(Request var1, WebSocketListener var2);
}
