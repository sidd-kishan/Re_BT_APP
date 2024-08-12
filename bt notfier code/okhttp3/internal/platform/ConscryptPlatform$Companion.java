/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  okhttp3.internal.platform.ConscryptPlatform
 *  org.conscrypt.Conscrypt
 *  org.conscrypt.Conscrypt$Version
 */
package okhttp3.internal.platform;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import okhttp3.internal.platform.ConscryptPlatform;
import org.conscrypt.Conscrypt;

/*
 * Exception performing whole class analysis ignored.
 */
@Metadata(d1={"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\"\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\bJ\b\u0010\u000b\u001a\u0004\u0018\u00010\fR\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0005\u00a8\u0006\r"}, d2={"Lokhttp3/internal/platform/ConscryptPlatform$Companion;", "", "()V", "isSupported", "", "()Z", "atLeastVersion", "major", "", "minor", "patch", "buildIfSupported", "Lokhttp3/internal/platform/ConscryptPlatform;", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public static final class ConscryptPlatform.Companion {
    private ConscryptPlatform.Companion() {
    }

    public /* synthetic */ ConscryptPlatform.Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public static /* synthetic */ boolean atLeastVersion$default(ConscryptPlatform.Companion companion, int n, int n2, int n3, int n4, Object object) {
        if ((n4 & 2) != 0) {
            n2 = 0;
        }
        if ((n4 & 4) == 0) return companion.atLeastVersion(n, n2, n3);
        n3 = 0;
        return companion.atLeastVersion(n, n2, n3);
    }

    public final boolean atLeastVersion(int n, int n2, int n3) {
        Conscrypt.Version version = Conscrypt.version();
        boolean bl = false;
        boolean bl2 = false;
        boolean bl3 = false;
        if (version == null) {
            return false;
        }
        if (version.major() != n) {
            bl2 = bl3;
            if (version.major() <= n) return bl2;
            bl2 = true;
            return bl2;
        }
        if (version.minor() != n2) {
            bl2 = bl;
            if (version.minor() <= n2) return bl2;
            bl2 = true;
            return bl2;
        }
        if (version.patch() < n3) return bl2;
        bl2 = true;
        return bl2;
    }

    public final ConscryptPlatform buildIfSupported() {
        boolean bl = this.isSupported();
        ConscryptPlatform conscryptPlatform = null;
        if (!bl) return conscryptPlatform;
        conscryptPlatform = new ConscryptPlatform(null);
        return conscryptPlatform;
    }

    public final boolean isSupported() {
        return ConscryptPlatform.access$isSupported$cp();
    }
}
