/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.security.NetworkSecurityPolicy
 *  android.util.CloseGuard
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.Intrinsics
 *  okhttp3.Protocol
 *  okhttp3.internal.platform.Android10Platform$Companion
 *  okhttp3.internal.platform.Platform
 *  okhttp3.internal.platform.android.Android10SocketAdapter
 *  okhttp3.internal.platform.android.AndroidCertificateChainCleaner
 *  okhttp3.internal.platform.android.AndroidSocketAdapter
 *  okhttp3.internal.platform.android.BouncyCastleSocketAdapter
 *  okhttp3.internal.platform.android.ConscryptSocketAdapter
 *  okhttp3.internal.platform.android.DeferredSocketAdapter
 *  okhttp3.internal.platform.android.SocketAdapter
 *  okhttp3.internal.tls.CertificateChainCleaner
 */
package okhttp3.internal.platform;

import android.os.Build;
import android.security.NetworkSecurityPolicy;
import android.util.CloseGuard;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Protocol;
import okhttp3.internal.platform.Android10Platform;
import okhttp3.internal.platform.Platform;
import okhttp3.internal.platform.android.Android10SocketAdapter;
import okhttp3.internal.platform.android.AndroidCertificateChainCleaner;
import okhttp3.internal.platform.android.AndroidSocketAdapter;
import okhttp3.internal.platform.android.BouncyCastleSocketAdapter;
import okhttp3.internal.platform.android.ConscryptSocketAdapter;
import okhttp3.internal.platform.android.DeferredSocketAdapter;
import okhttp3.internal.platform.android.SocketAdapter;
import okhttp3.internal.tls.CertificateChainCleaner;

@Metadata(d1={"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J(\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u0004H\u0016J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u000fH\u0016J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u000e\u001a\u00020\u000fH\u0017J\u001a\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u000f2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0014H\u0016J\u0012\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001e"}, d2={"Lokhttp3/internal/platform/Android10Platform;", "Lokhttp3/internal/platform/Platform;", "()V", "socketAdapters", "", "Lokhttp3/internal/platform/android/SocketAdapter;", "buildCertificateChainCleaner", "Lokhttp3/internal/tls/CertificateChainCleaner;", "trustManager", "Ljavax/net/ssl/X509TrustManager;", "configureTlsExtensions", "", "sslSocket", "Ljavax/net/ssl/SSLSocket;", "hostname", "", "protocols", "Lokhttp3/Protocol;", "getSelectedProtocol", "getStackTraceForCloseable", "", "closer", "isCleartextTrafficPermitted", "", "logCloseableLeak", "message", "stackTrace", "sslSocketFactory", "Ljavax/net/ssl/SSLSocketFactory;", "Companion", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public final class Android10Platform
extends Platform {
    public static final Companion Companion = new Companion(null);
    private static final boolean isSupported;
    private final List<SocketAdapter> socketAdapters;

    static {
        boolean bl = Platform.Companion.isAndroid() && Build.VERSION.SDK_INT >= 29;
        isSupported = bl;
    }

    public Android10Platform() {
        Object object = CollectionsKt.listOfNotNull((Object[])new SocketAdapter[]{Android10SocketAdapter.Companion.buildIfSupported(), (SocketAdapter)new DeferredSocketAdapter(AndroidSocketAdapter.Companion.getPlayProviderFactory()), (SocketAdapter)new DeferredSocketAdapter(ConscryptSocketAdapter.Companion.getFactory()), (SocketAdapter)new DeferredSocketAdapter(BouncyCastleSocketAdapter.Companion.getFactory())});
        Collection collection = new ArrayList();
        object = object.iterator();
        while (true) {
            if (!object.hasNext()) {
                this.socketAdapters = (List)collection;
                return;
            }
            Object e = object.next();
            if (!((SocketAdapter)e).isSupported()) continue;
            collection.add(e);
        }
    }

    public static final /* synthetic */ boolean access$isSupported$cp() {
        return isSupported;
    }

    public CertificateChainCleaner buildCertificateChainCleaner(X509TrustManager x509TrustManager) {
        Intrinsics.checkNotNullParameter((Object)x509TrustManager, (String)"trustManager");
        AndroidCertificateChainCleaner androidCertificateChainCleaner = AndroidCertificateChainCleaner.Companion.buildIfSupported(x509TrustManager);
        x509TrustManager = androidCertificateChainCleaner == null ? super.buildCertificateChainCleaner(x509TrustManager) : (CertificateChainCleaner)androidCertificateChainCleaner;
        return x509TrustManager;
    }

    public void configureTlsExtensions(SSLSocket sSLSocket, String string, List<? extends Protocol> list) {
        SocketAdapter socketAdapter2;
        block1: {
            Intrinsics.checkNotNullParameter((Object)sSLSocket, (String)"sslSocket");
            Intrinsics.checkNotNullParameter(list, (String)"protocols");
            for (SocketAdapter socketAdapter2 : (Iterable)this.socketAdapters) {
                if (!((SocketAdapter)socketAdapter2).matchesSocket(sSLSocket)) continue;
                break block1;
            }
            socketAdapter2 = null;
        }
        socketAdapter2 = socketAdapter2;
        if (socketAdapter2 == null) return;
        socketAdapter2.configureTlsExtensions(sSLSocket, string, list);
    }

    public String getSelectedProtocol(SSLSocket object) {
        Object var4_5;
        SocketAdapter socketAdapter;
        block2: {
            block1: {
                Intrinsics.checkNotNullParameter((Object)object, (String)"sslSocket");
                Iterator iterator = ((Iterable)this.socketAdapters).iterator();
                do {
                    boolean bl = iterator.hasNext();
                    var4_5 = null;
                    if (!bl) break block1;
                } while (!((SocketAdapter)(socketAdapter = (SocketAdapter)iterator.next())).matchesSocket((SSLSocket)object));
                break block2;
            }
            socketAdapter = null;
        }
        socketAdapter = socketAdapter;
        object = socketAdapter == null ? var4_5 : socketAdapter.getSelectedProtocol((SSLSocket)object);
        return object;
    }

    public Object getStackTraceForCloseable(String object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"closer");
        if (Build.VERSION.SDK_INT >= 30) {
            CloseGuard closeGuard = new CloseGuard();
            closeGuard.open((String)object);
            object = closeGuard;
        } else {
            object = super.getStackTraceForCloseable((String)object);
        }
        return object;
    }

    public boolean isCleartextTrafficPermitted(String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"hostname");
        return NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted(string);
    }

    public void logCloseableLeak(String string, Object object) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"message");
        if (Build.VERSION.SDK_INT >= 30) {
            if (object == null) throw new NullPointerException("null cannot be cast to non-null type android.util.CloseGuard");
            ((CloseGuard)object).warnIfOpen();
        } else {
            super.logCloseableLeak(string, object);
        }
    }

    public X509TrustManager trustManager(SSLSocketFactory object) {
        Object var4_5;
        SocketAdapter socketAdapter;
        block2: {
            block1: {
                Intrinsics.checkNotNullParameter((Object)object, (String)"sslSocketFactory");
                Iterator iterator = ((Iterable)this.socketAdapters).iterator();
                do {
                    boolean bl = iterator.hasNext();
                    var4_5 = null;
                    if (!bl) break block1;
                } while (!((SocketAdapter)(socketAdapter = (SocketAdapter)iterator.next())).matchesSocketFactory((SSLSocketFactory)object));
                break block2;
            }
            socketAdapter = null;
        }
        socketAdapter = socketAdapter;
        object = socketAdapter == null ? var4_5 : socketAdapter.trustManager((SSLSocketFactory)object);
        return object;
    }
}
