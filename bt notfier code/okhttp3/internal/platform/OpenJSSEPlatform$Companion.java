/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  okhttp3.internal.platform.OpenJSSEPlatform
 */
package okhttp3.internal.platform;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import okhttp3.internal.platform.OpenJSSEPlatform;

/*
 * Exception performing whole class analysis ignored.
 */
@Metadata(d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0005\u00a8\u0006\b"}, d2={"Lokhttp3/internal/platform/OpenJSSEPlatform$Companion;", "", "()V", "isSupported", "", "()Z", "buildIfSupported", "Lokhttp3/internal/platform/OpenJSSEPlatform;", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public static final class OpenJSSEPlatform.Companion {
    private OpenJSSEPlatform.Companion() {
    }

    public /* synthetic */ OpenJSSEPlatform.Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public final OpenJSSEPlatform buildIfSupported() {
        boolean bl = this.isSupported();
        OpenJSSEPlatform openJSSEPlatform = null;
        if (!bl) return openJSSEPlatform;
        openJSSEPlatform = new OpenJSSEPlatform(null);
        return openJSSEPlatform;
    }

    public final boolean isSupported() {
        return OpenJSSEPlatform.access$isSupported$cp();
    }
}
