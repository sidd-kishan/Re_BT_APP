/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.security.NetworkSecurityPolicy
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.Intrinsics
 *  okhttp3.Protocol
 *  okhttp3.internal.platform.AndroidPlatform$Companion
 *  okhttp3.internal.platform.AndroidPlatform$CustomTrustRootIndex
 *  okhttp3.internal.platform.Platform
 *  okhttp3.internal.platform.android.AndroidCertificateChainCleaner
 *  okhttp3.internal.platform.android.AndroidSocketAdapter
 *  okhttp3.internal.platform.android.BouncyCastleSocketAdapter
 *  okhttp3.internal.platform.android.ConscryptSocketAdapter
 *  okhttp3.internal.platform.android.DeferredSocketAdapter
 *  okhttp3.internal.platform.android.SocketAdapter
 *  okhttp3.internal.platform.android.StandardAndroidSocketAdapter
 *  okhttp3.internal.platform.android.StandardAndroidSocketAdapter$Companion
 *  okhttp3.internal.tls.CertificateChainCleaner
 *  okhttp3.internal.tls.TrustRootIndex
 */
package okhttp3.internal.platform;

import android.os.Build;
import android.security.NetworkSecurityPolicy;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.cert.X509Certificate;
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
import okhttp3.internal.platform.AndroidPlatform;
import okhttp3.internal.platform.Platform;
import okhttp3.internal.platform.android.AndroidCertificateChainCleaner;
import okhttp3.internal.platform.android.AndroidSocketAdapter;
import okhttp3.internal.platform.android.BouncyCastleSocketAdapter;
import okhttp3.internal.platform.android.ConscryptSocketAdapter;
import okhttp3.internal.platform.android.DeferredSocketAdapter;
import okhttp3.internal.platform.android.SocketAdapter;
import okhttp3.internal.platform.android.StandardAndroidSocketAdapter;
import okhttp3.internal.tls.CertificateChainCleaner;
import okhttp3.internal.tls.TrustRootIndex;

@Metadata(d1={"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 !2\u00020\u0001:\u0002!\"B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\tH\u0016J-\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0011\u0010\u0012\u001a\r\u0012\t\u0012\u00070\u0013\u00a2\u0006\u0002\b\u00140\u0004H\u0016J \u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0012\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001f\u001a\u00020 H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006#"}, d2={"Lokhttp3/internal/platform/AndroidPlatform;", "Lokhttp3/internal/platform/Platform;", "()V", "socketAdapters", "", "Lokhttp3/internal/platform/android/SocketAdapter;", "buildCertificateChainCleaner", "Lokhttp3/internal/tls/CertificateChainCleaner;", "trustManager", "Ljavax/net/ssl/X509TrustManager;", "buildTrustRootIndex", "Lokhttp3/internal/tls/TrustRootIndex;", "configureTlsExtensions", "", "sslSocket", "Ljavax/net/ssl/SSLSocket;", "hostname", "", "protocols", "Lokhttp3/Protocol;", "Lkotlin/jvm/JvmSuppressWildcards;", "connectSocket", "socket", "Ljava/net/Socket;", "address", "Ljava/net/InetSocketAddress;", "connectTimeout", "", "getSelectedProtocol", "isCleartextTrafficPermitted", "", "sslSocketFactory", "Ljavax/net/ssl/SSLSocketFactory;", "Companion", "CustomTrustRootIndex", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public final class AndroidPlatform
extends Platform {
    public static final Companion Companion = new Companion(null);
    private static final boolean isSupported;
    private final List<SocketAdapter> socketAdapters;

    static {
        boolean bl = Platform.Companion.isAndroid();
        boolean bl2 = true;
        boolean bl3 = false;
        if (!bl || Build.VERSION.SDK_INT >= 30) {
            bl2 = false;
        } else {
            if (Build.VERSION.SDK_INT >= 21) {
                bl3 = true;
            }
            if (!bl3) {
                Throwable throwable = new IllegalStateException(Intrinsics.stringPlus((String)"Expected Android API level 21+ but was ", (Object)Build.VERSION.SDK_INT).toString());
                throw throwable;
            }
        }
        isSupported = bl2;
    }

    public AndroidPlatform() {
        Object object = CollectionsKt.listOfNotNull((Object[])new SocketAdapter[]{StandardAndroidSocketAdapter.Companion.buildIfSupported$default((StandardAndroidSocketAdapter.Companion)StandardAndroidSocketAdapter.Companion, null, (int)1, null), (SocketAdapter)new DeferredSocketAdapter(AndroidSocketAdapter.Companion.getPlayProviderFactory()), (SocketAdapter)new DeferredSocketAdapter(ConscryptSocketAdapter.Companion.getFactory()), (SocketAdapter)new DeferredSocketAdapter(BouncyCastleSocketAdapter.Companion.getFactory())});
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

    public TrustRootIndex buildTrustRootIndex(X509TrustManager x509TrustManager) {
        Intrinsics.checkNotNullParameter((Object)x509TrustManager, (String)"trustManager");
        try {
            Method method = x509TrustManager.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", X509Certificate.class);
            method.setAccessible(true);
            Intrinsics.checkNotNullExpressionValue((Object)method, (String)"method");
            CustomTrustRootIndex customTrustRootIndex = new CustomTrustRootIndex(x509TrustManager, method);
            customTrustRootIndex = (TrustRootIndex)customTrustRootIndex;
            x509TrustManager = customTrustRootIndex;
        }
        catch (NoSuchMethodException noSuchMethodException) {
            x509TrustManager = super.buildTrustRootIndex(x509TrustManager);
        }
        return x509TrustManager;
    }

    public void configureTlsExtensions(SSLSocket sSLSocket, String string, List<Protocol> list) {
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

    public void connectSocket(Socket socket, InetSocketAddress inetSocketAddress, int n) throws IOException {
        Intrinsics.checkNotNullParameter((Object)socket, (String)"socket");
        Intrinsics.checkNotNullParameter((Object)inetSocketAddress, (String)"address");
        try {
            socket.connect(inetSocketAddress, n);
            return;
        }
        catch (ClassCastException classCastException) {
            if (Build.VERSION.SDK_INT != 26) throw classCastException;
            throw new IOException("Exception in connect", classCastException);
        }
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

    public boolean isCleartextTrafficPermitted(String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"hostname");
        boolean bl = Build.VERSION.SDK_INT >= 24 ? NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted(string) : (Build.VERSION.SDK_INT >= 23 ? NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted() : true);
        return bl;
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
