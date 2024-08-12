/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  okhttp3.internal.platform.android.AndroidSocketAdapter
 *  okhttp3.internal.platform.android.DeferredSocketAdapter$Factory
 */
package okhttp3.internal.platform.android;

import javax.net.ssl.SSLSocket;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.platform.android.AndroidSocketAdapter;
import okhttp3.internal.platform.android.DeferredSocketAdapter;

/*
 * Exception performing whole class analysis ignored.
 */
@Metadata(d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0007\u001a\u00020\b2\u000e\u0010\t\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u000b0\nH\u0002J\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000eR\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u000f"}, d2={"Lokhttp3/internal/platform/android/AndroidSocketAdapter$Companion;", "", "()V", "playProviderFactory", "Lokhttp3/internal/platform/android/DeferredSocketAdapter$Factory;", "getPlayProviderFactory", "()Lokhttp3/internal/platform/android/DeferredSocketAdapter$Factory;", "build", "Lokhttp3/internal/platform/android/AndroidSocketAdapter;", "actualSSLSocketClass", "Ljava/lang/Class;", "Ljavax/net/ssl/SSLSocket;", "factory", "packageName", "", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public static final class AndroidSocketAdapter.Companion {
    private AndroidSocketAdapter.Companion() {
    }

    public /* synthetic */ AndroidSocketAdapter.Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public static final /* synthetic */ AndroidSocketAdapter access$build(AndroidSocketAdapter.Companion companion, Class clazz) {
        return companion.build(clazz);
    }

    private final AndroidSocketAdapter build(Class<? super SSLSocket> clazz) {
        Class<? super SSLSocket> clazz2 = clazz;
        while (clazz2 != null && !Intrinsics.areEqual((Object)clazz2.getSimpleName(), (Object)"OpenSSLSocketImpl")) {
            if ((clazz2 = clazz2.getSuperclass()) == null) throw new AssertionError((Object)Intrinsics.stringPlus((String)"No OpenSSLSocketImpl superclass of socket of type ", clazz));
        }
        Intrinsics.checkNotNull(clazz2);
        return new AndroidSocketAdapter(clazz2);
    }

    public final DeferredSocketAdapter.Factory factory(String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"packageName");
        return (DeferredSocketAdapter.Factory)new /* Unavailable Anonymous Inner Class!! */;
    }

    public final DeferredSocketAdapter.Factory getPlayProviderFactory() {
        return AndroidSocketAdapter.access$getPlayProviderFactory$cp();
    }
}
