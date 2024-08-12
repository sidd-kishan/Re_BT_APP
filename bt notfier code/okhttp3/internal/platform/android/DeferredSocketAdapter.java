/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  okhttp3.Protocol
 *  okhttp3.internal.platform.android.DeferredSocketAdapter$Factory
 *  okhttp3.internal.platform.android.SocketAdapter
 *  okhttp3.internal.platform.android.SocketAdapter$DefaultImpls
 */
package okhttp3.internal.platform.android;

import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Protocol;
import okhttp3.internal.platform.android.DeferredSocketAdapter;
import okhttp3.internal.platform.android.SocketAdapter;

@Metadata(d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0014B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J(\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u00012\u0006\u0010\b\u001a\u00020\tH\u0002J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\b\u001a\u00020\tH\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0001X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2={"Lokhttp3/internal/platform/android/DeferredSocketAdapter;", "Lokhttp3/internal/platform/android/SocketAdapter;", "socketAdapterFactory", "Lokhttp3/internal/platform/android/DeferredSocketAdapter$Factory;", "(Lokhttp3/internal/platform/android/DeferredSocketAdapter$Factory;)V", "delegate", "configureTlsExtensions", "", "sslSocket", "Ljavax/net/ssl/SSLSocket;", "hostname", "", "protocols", "", "Lokhttp3/Protocol;", "getDelegate", "getSelectedProtocol", "isSupported", "", "matchesSocket", "Factory", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public final class DeferredSocketAdapter
implements SocketAdapter {
    private SocketAdapter delegate;
    private final Factory socketAdapterFactory;

    public DeferredSocketAdapter(Factory factory) {
        Intrinsics.checkNotNullParameter((Object)factory, (String)"socketAdapterFactory");
        this.socketAdapterFactory = factory;
    }

    private final SocketAdapter getDelegate(SSLSocket sSLSocket) {
        synchronized (this) {
            if (this.delegate == null && this.socketAdapterFactory.matchesSocket(sSLSocket)) {
                this.delegate = this.socketAdapterFactory.create(sSLSocket);
            }
            sSLSocket = this.delegate;
            return sSLSocket;
        }
    }

    public void configureTlsExtensions(SSLSocket sSLSocket, String string, List<? extends Protocol> list) {
        Intrinsics.checkNotNullParameter((Object)sSLSocket, (String)"sslSocket");
        Intrinsics.checkNotNullParameter(list, (String)"protocols");
        SocketAdapter socketAdapter = this.getDelegate(sSLSocket);
        if (socketAdapter == null) return;
        socketAdapter.configureTlsExtensions(sSLSocket, string, list);
    }

    public String getSelectedProtocol(SSLSocket object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"sslSocket");
        SocketAdapter socketAdapter = this.getDelegate((SSLSocket)object);
        object = socketAdapter == null ? null : socketAdapter.getSelectedProtocol((SSLSocket)object);
        return object;
    }

    public boolean isSupported() {
        return true;
    }

    public boolean matchesSocket(SSLSocket sSLSocket) {
        Intrinsics.checkNotNullParameter((Object)sSLSocket, (String)"sslSocket");
        return this.socketAdapterFactory.matchesSocket(sSLSocket);
    }

    public boolean matchesSocketFactory(SSLSocketFactory sSLSocketFactory) {
        return SocketAdapter.DefaultImpls.matchesSocketFactory((SocketAdapter)this, (SSLSocketFactory)sSLSocketFactory);
    }

    public X509TrustManager trustManager(SSLSocketFactory sSLSocketFactory) {
        return SocketAdapter.DefaultImpls.trustManager((SocketAdapter)this, (SSLSocketFactory)sSLSocketFactory);
    }
}
