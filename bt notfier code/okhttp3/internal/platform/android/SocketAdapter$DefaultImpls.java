/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  okhttp3.internal.platform.android.SocketAdapter
 */
package okhttp3.internal.platform.android;

import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.platform.android.SocketAdapter;

@Metadata(k=3, mv={1, 5, 1}, xi=48)
public static final class SocketAdapter.DefaultImpls {
    public static boolean matchesSocketFactory(SocketAdapter socketAdapter, SSLSocketFactory sSLSocketFactory) {
        Intrinsics.checkNotNullParameter((Object)socketAdapter, (String)"this");
        Intrinsics.checkNotNullParameter((Object)sSLSocketFactory, (String)"sslSocketFactory");
        return false;
    }

    public static X509TrustManager trustManager(SocketAdapter socketAdapter, SSLSocketFactory sSLSocketFactory) {
        Intrinsics.checkNotNullParameter((Object)socketAdapter, (String)"this");
        Intrinsics.checkNotNullParameter((Object)sSLSocketFactory, (String)"sslSocketFactory");
        return null;
    }
}
