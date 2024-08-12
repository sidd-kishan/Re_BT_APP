/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  okhttp3.Dns$Companion
 *  okhttp3.Dns$Companion$DnsSystem
 */
package okhttp3;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import kotlin.Metadata;
import okhttp3.Dns;

@Metadata(d1={"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u00e6\u0080\u0001\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007J\u0016\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&\u00a8\u0006\b"}, d2={"Lokhttp3/Dns;", "", "lookup", "", "Ljava/net/InetAddress;", "hostname", "", "Companion", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public interface Dns {
    public static final Companion Companion = okhttp3.Dns$Companion.$$INSTANCE;
    public static final Dns SYSTEM = (Dns)new Companion.DnsSystem();

    public List<InetAddress> lookup(String var1) throws UnknownHostException;
}
