/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  okhttp3.internal.platform.BouncyCastlePlatform
 */
package okhttp3.internal.platform;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import okhttp3.internal.platform.BouncyCastlePlatform;

/*
 * Exception performing whole class analysis ignored.
 */
@Metadata(d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0005\u00a8\u0006\b"}, d2={"Lokhttp3/internal/platform/BouncyCastlePlatform$Companion;", "", "()V", "isSupported", "", "()Z", "buildIfSupported", "Lokhttp3/internal/platform/BouncyCastlePlatform;", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public static final class BouncyCastlePlatform.Companion {
    private BouncyCastlePlatform.Companion() {
    }

    public /* synthetic */ BouncyCastlePlatform.Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public final BouncyCastlePlatform buildIfSupported() {
        boolean bl = this.isSupported();
        BouncyCastlePlatform bouncyCastlePlatform = null;
        if (!bl) return bouncyCastlePlatform;
        bouncyCastlePlatform = new BouncyCastlePlatform(null);
        return bouncyCastlePlatform;
    }

    public final boolean isSupported() {
        return BouncyCastlePlatform.access$isSupported$cp();
    }
}
