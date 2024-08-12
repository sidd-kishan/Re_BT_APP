/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  okhttp3.internal.platform.BouncyCastlePlatform
 *  okhttp3.internal.platform.android.BouncyCastleSocketAdapter
 *  okhttp3.internal.platform.android.DeferredSocketAdapter$Factory
 *  okhttp3.internal.platform.android.SocketAdapter
 *  org.bouncycastle.jsse.BCSSLSocket
 */
package okhttp3.internal.platform.android;

import javax.net.ssl.SSLSocket;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.platform.BouncyCastlePlatform;
import okhttp3.internal.platform.android.BouncyCastleSocketAdapter;
import okhttp3.internal.platform.android.DeferredSocketAdapter;
import okhttp3.internal.platform.android.SocketAdapter;
import org.bouncycastle.jsse.BCSSLSocket;

@Metadata(d1={"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005H\u0016\u00a8\u0006\b"}, d2={"okhttp3/internal/platform/android/BouncyCastleSocketAdapter$Companion$factory$1", "Lokhttp3/internal/platform/android/DeferredSocketAdapter$Factory;", "create", "Lokhttp3/internal/platform/android/SocketAdapter;", "sslSocket", "Ljavax/net/ssl/SSLSocket;", "matchesSocket", "", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public static final class BouncyCastleSocketAdapter.Companion.factory.1
implements DeferredSocketAdapter.Factory {
    BouncyCastleSocketAdapter.Companion.factory.1() {
    }

    public SocketAdapter create(SSLSocket sSLSocket) {
        Intrinsics.checkNotNullParameter((Object)sSLSocket, (String)"sslSocket");
        return (SocketAdapter)new BouncyCastleSocketAdapter();
    }

    public boolean matchesSocket(SSLSocket sSLSocket) {
        Intrinsics.checkNotNullParameter((Object)sSLSocket, (String)"sslSocket");
        boolean bl = BouncyCastlePlatform.Companion.isSupported() && sSLSocket instanceof BCSSLSocket;
        return bl;
    }
}
