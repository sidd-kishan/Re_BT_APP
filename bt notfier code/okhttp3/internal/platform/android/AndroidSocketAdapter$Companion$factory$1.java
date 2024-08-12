/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.text.StringsKt
 *  okhttp3.internal.platform.android.AndroidSocketAdapter
 *  okhttp3.internal.platform.android.AndroidSocketAdapter$Companion
 *  okhttp3.internal.platform.android.DeferredSocketAdapter$Factory
 *  okhttp3.internal.platform.android.SocketAdapter
 */
package okhttp3.internal.platform.android;

import javax.net.ssl.SSLSocket;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.internal.platform.android.AndroidSocketAdapter;
import okhttp3.internal.platform.android.DeferredSocketAdapter;
import okhttp3.internal.platform.android.SocketAdapter;

/*
 * Exception performing whole class analysis ignored.
 */
@Metadata(d1={"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005H\u0016\u00a8\u0006\b"}, d2={"okhttp3/internal/platform/android/AndroidSocketAdapter$Companion$factory$1", "Lokhttp3/internal/platform/android/DeferredSocketAdapter$Factory;", "create", "Lokhttp3/internal/platform/android/SocketAdapter;", "sslSocket", "Ljavax/net/ssl/SSLSocket;", "matchesSocket", "", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public static final class AndroidSocketAdapter.Companion.factory.1
implements DeferredSocketAdapter.Factory {
    final String $packageName;

    AndroidSocketAdapter.Companion.factory.1(String string) {
        this.$packageName = string;
    }

    public SocketAdapter create(SSLSocket sSLSocket) {
        Intrinsics.checkNotNullParameter((Object)sSLSocket, (String)"sslSocket");
        return (SocketAdapter)AndroidSocketAdapter.Companion.access$build((AndroidSocketAdapter.Companion)AndroidSocketAdapter.Companion, sSLSocket.getClass());
    }

    public boolean matchesSocket(SSLSocket object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"sslSocket");
        object = object.getClass().getName();
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"sslSocket.javaClass.name");
        return StringsKt.startsWith$default((String)object, (String)Intrinsics.stringPlus((String)this.$packageName, (Object)"."), (boolean)false, (int)2, null);
    }
}
