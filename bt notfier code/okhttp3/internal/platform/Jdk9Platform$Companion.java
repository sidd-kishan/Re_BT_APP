/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  okhttp3.internal.platform.Jdk9Platform
 */
package okhttp3.internal.platform;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import okhttp3.internal.platform.Jdk9Platform;

/*
 * Exception performing whole class analysis ignored.
 */
@Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u0004\u0018\u00010\fR\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0005R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\t\u00a8\u0006\r"}, d2={"Lokhttp3/internal/platform/Jdk9Platform$Companion;", "", "()V", "isAvailable", "", "()Z", "majorVersion", "", "getMajorVersion", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "buildIfSupported", "Lokhttp3/internal/platform/Jdk9Platform;", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public static final class Jdk9Platform.Companion {
    private Jdk9Platform.Companion() {
    }

    public /* synthetic */ Jdk9Platform.Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public final Jdk9Platform buildIfSupported() {
        Jdk9Platform jdk9Platform = this.isAvailable() ? new Jdk9Platform() : null;
        return jdk9Platform;
    }

    public final Integer getMajorVersion() {
        return Jdk9Platform.access$getMajorVersion$cp();
    }

    public final boolean isAvailable() {
        return Jdk9Platform.access$isAvailable$cp();
    }
}
