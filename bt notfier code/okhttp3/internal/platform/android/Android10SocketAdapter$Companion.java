/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  okhttp3.internal.platform.Platform
 *  okhttp3.internal.platform.android.Android10SocketAdapter
 *  okhttp3.internal.platform.android.SocketAdapter
 */
package okhttp3.internal.platform.android;

import android.os.Build;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import okhttp3.internal.platform.Platform;
import okhttp3.internal.platform.android.Android10SocketAdapter;
import okhttp3.internal.platform.android.SocketAdapter;

@Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0087\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0007"}, d2={"Lokhttp3/internal/platform/android/Android10SocketAdapter$Companion;", "", "()V", "buildIfSupported", "Lokhttp3/internal/platform/android/SocketAdapter;", "isSupported", "", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public static final class Android10SocketAdapter.Companion {
    private Android10SocketAdapter.Companion() {
    }

    public /* synthetic */ Android10SocketAdapter.Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public final SocketAdapter buildIfSupported() {
        SocketAdapter socketAdapter = this.isSupported() ? (SocketAdapter)new Android10SocketAdapter() : null;
        return socketAdapter;
    }

    public final boolean isSupported() {
        boolean bl = Platform.Companion.isAndroid() && Build.VERSION.SDK_INT >= 29;
        return bl;
    }
}
