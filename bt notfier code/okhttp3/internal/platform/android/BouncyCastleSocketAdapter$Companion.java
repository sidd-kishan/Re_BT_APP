/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  okhttp3.internal.platform.android.BouncyCastleSocketAdapter
 *  okhttp3.internal.platform.android.DeferredSocketAdapter$Factory
 */
package okhttp3.internal.platform.android;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import okhttp3.internal.platform.android.BouncyCastleSocketAdapter;
import okhttp3.internal.platform.android.DeferredSocketAdapter;

/*
 * Exception performing whole class analysis ignored.
 */
@Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2={"Lokhttp3/internal/platform/android/BouncyCastleSocketAdapter$Companion;", "", "()V", "factory", "Lokhttp3/internal/platform/android/DeferredSocketAdapter$Factory;", "getFactory", "()Lokhttp3/internal/platform/android/DeferredSocketAdapter$Factory;", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public static final class BouncyCastleSocketAdapter.Companion {
    private BouncyCastleSocketAdapter.Companion() {
    }

    public /* synthetic */ BouncyCastleSocketAdapter.Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public final DeferredSocketAdapter.Factory getFactory() {
        return BouncyCastleSocketAdapter.access$getFactory$cp();
    }
}
