/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  okhttp3.Handshake
 *  okhttp3.Protocol
 *  okhttp3.Route
 */
package okhttp3;

import java.net.Socket;
import kotlin.Metadata;
import okhttp3.Handshake;
import okhttp3.Protocol;
import okhttp3.Route;

@Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\tH&\u00a8\u0006\n"}, d2={"Lokhttp3/Connection;", "", "handshake", "Lokhttp3/Handshake;", "protocol", "Lokhttp3/Protocol;", "route", "Lokhttp3/Route;", "socket", "Ljava/net/Socket;", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public interface Connection {
    public Handshake handshake();

    public Protocol protocol();

    public Route route();

    public Socket socket();
}