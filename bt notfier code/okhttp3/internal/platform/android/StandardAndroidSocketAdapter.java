/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  okhttp3.internal.Util
 *  okhttp3.internal.platform.android.AndroidSocketAdapter
 *  okhttp3.internal.platform.android.StandardAndroidSocketAdapter$Companion
 */
package okhttp3.internal.platform.android;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;
import okhttp3.internal.platform.android.AndroidSocketAdapter;
import okhttp3.internal.platform.android.StandardAndroidSocketAdapter;

@Metadata(d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB1\u0012\u000e\u0010\u0002\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00040\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00060\u0003\u0012\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u0003\u00a2\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0006H\u0016J\u0012\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000b\u001a\u00020\u0006H\u0016R\u0012\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00060\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2={"Lokhttp3/internal/platform/android/StandardAndroidSocketAdapter;", "Lokhttp3/internal/platform/android/AndroidSocketAdapter;", "sslSocketClass", "Ljava/lang/Class;", "Ljavax/net/ssl/SSLSocket;", "sslSocketFactoryClass", "Ljavax/net/ssl/SSLSocketFactory;", "paramClass", "(Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/Class;)V", "matchesSocketFactory", "", "sslSocketFactory", "trustManager", "Ljavax/net/ssl/X509TrustManager;", "Companion", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public final class StandardAndroidSocketAdapter
extends AndroidSocketAdapter {
    public static final Companion Companion = new Companion(null);
    private final Class<?> paramClass;
    private final Class<? super SSLSocketFactory> sslSocketFactoryClass;

    public StandardAndroidSocketAdapter(Class<? super SSLSocket> clazz, Class<? super SSLSocketFactory> clazz2, Class<?> clazz3) {
        Intrinsics.checkNotNullParameter(clazz, (String)"sslSocketClass");
        Intrinsics.checkNotNullParameter(clazz2, (String)"sslSocketFactoryClass");
        Intrinsics.checkNotNullParameter(clazz3, (String)"paramClass");
        super(clazz);
        this.sslSocketFactoryClass = clazz2;
        this.paramClass = clazz3;
    }

    public boolean matchesSocketFactory(SSLSocketFactory sSLSocketFactory) {
        Intrinsics.checkNotNullParameter((Object)sSLSocketFactory, (String)"sslSocketFactory");
        return this.sslSocketFactoryClass.isInstance(sSLSocketFactory);
    }

    public X509TrustManager trustManager(SSLSocketFactory object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"sslSocketFactory");
        Object object2 = Util.readFieldOrNull((Object)object, this.paramClass, (String)"sslParameters");
        Intrinsics.checkNotNull((Object)object2);
        X509TrustManager x509TrustManager = (X509TrustManager)Util.readFieldOrNull((Object)object2, X509TrustManager.class, (String)"x509TrustManager");
        object = x509TrustManager;
        if (x509TrustManager != null) return object;
        object = (X509TrustManager)Util.readFieldOrNull((Object)object2, X509TrustManager.class, (String)"trustManager");
        return object;
    }
}
