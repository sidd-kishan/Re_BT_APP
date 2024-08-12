/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.oracle.svm.core.annotate.Substitute
 *  com.oracle.svm.core.annotate.TargetClass
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  okhttp3.internal.platform.Jdk9Platform
 *  okhttp3.internal.platform.Platform
 *  okhttp3.internal.platform.Platform$Companion
 */
package okhttp3.internal.graal;

import com.oracle.svm.core.annotate.Substitute;
import com.oracle.svm.core.annotate.TargetClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.platform.Jdk9Platform;
import okhttp3.internal.platform.Platform;

@TargetClass(value=Platform.Companion.class)
@Metadata(d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007\u00a8\u0006\u0005"}, d2={"Lokhttp3/internal/graal/TargetPlatform;", "", "()V", "findPlatform", "Lokhttp3/internal/platform/Platform;", "okhttp"}, k=1, mv={1, 5, 1}, xi=48)
public final class TargetPlatform {
    @Substitute
    public final Platform findPlatform() {
        Jdk9Platform jdk9Platform = Jdk9Platform.Companion.buildIfSupported();
        Intrinsics.checkNotNull((Object)jdk9Platform);
        return (Platform)jdk9Platform;
    }
}
