/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.ArraysKt
 *  kotlin.jvm.internal.Intrinsics
 *  okhttp3.Dns
 */
package okhttp3;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Dns;

@Metadata(d1={"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0016\u00a8\u0006\b"}, d2={"Lokhttp3/Dns$Companion$DnsSystem;", "Lokhttp3/Dns;", "()V", "lookup", "", "Ljava/net/InetAddress;", "hostname", "", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
private static final class Dns.Companion.DnsSystem
implements Dns {
    public List<InetAddress> lookup(String object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"hostname");
        try {
            Object object2 = InetAddress.getAllByName((String)object);
            Intrinsics.checkNotNullExpressionValue((Object)object2, (String)"getAllByName(hostname)");
            object2 = ArraysKt.toList((Object[])object2);
            return object2;
        }
        catch (NullPointerException nullPointerException) {
            object = new UnknownHostException(Intrinsics.stringPlus((String)"Broken system behaviour for dns lookup of ", (Object)object));
            ((Throwable)object).initCause(nullPointerException);
            throw (Throwable)object;
        }
    }
}
