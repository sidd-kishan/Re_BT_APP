/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  okhttp3.internal.platform.Platform
 *  okhttp3.internal.platform.android.SocketAdapter
 *  okhttp3.internal.platform.android.StandardAndroidSocketAdapter
 */
package okhttp3.internal.platform.android;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.platform.Platform;
import okhttp3.internal.platform.android.SocketAdapter;
import okhttp3.internal.platform.android.StandardAndroidSocketAdapter;

@Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0007"}, d2={"Lokhttp3/internal/platform/android/StandardAndroidSocketAdapter$Companion;", "", "()V", "buildIfSupported", "Lokhttp3/internal/platform/android/SocketAdapter;", "packageName", "", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public static final class StandardAndroidSocketAdapter.Companion {
    private StandardAndroidSocketAdapter.Companion() {
    }

    public /* synthetic */ StandardAndroidSocketAdapter.Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public static /* synthetic */ SocketAdapter buildIfSupported$default(StandardAndroidSocketAdapter.Companion companion, String string, int n, Object object) {
        if ((n & 1) == 0) return companion.buildIfSupported(string);
        string = "com.android.org.conscrypt";
        return companion.buildIfSupported(string);
    }

    public final SocketAdapter buildIfSupported(String socketAdapter) {
        Intrinsics.checkNotNullParameter((Object)socketAdapter, (String)"packageName");
        try {
            Class<?> clazz = Class.forName(Intrinsics.stringPlus((String)socketAdapter, (Object)".OpenSSLSocketImpl"));
            if (clazz == null) {
                socketAdapter = new NullPointerException("null cannot be cast to non-null type java.lang.Class<in javax.net.ssl.SSLSocket>");
                throw socketAdapter;
            }
            Class<?> clazz2 = Class.forName(Intrinsics.stringPlus((String)socketAdapter, (Object)".OpenSSLSocketFactoryImpl"));
            if (clazz2 == null) {
                socketAdapter = new NullPointerException("null cannot be cast to non-null type java.lang.Class<in javax.net.ssl.SSLSocketFactory>");
                throw socketAdapter;
            }
            socketAdapter = Class.forName(Intrinsics.stringPlus((String)socketAdapter, (Object)".SSLParametersImpl"));
            Intrinsics.checkNotNullExpressionValue(socketAdapter, (String)"paramsClass");
            StandardAndroidSocketAdapter standardAndroidSocketAdapter = new StandardAndroidSocketAdapter(clazz, clazz2, socketAdapter);
            socketAdapter = (SocketAdapter)standardAndroidSocketAdapter;
        }
        catch (Exception exception) {
            Platform.Companion.get().log("unable to load android socket classes", 5, (Throwable)exception);
            socketAdapter = null;
        }
        return socketAdapter;
    }
}
