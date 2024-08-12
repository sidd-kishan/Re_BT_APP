/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  okio.Timeout
 */
package okio;

import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.Timeout;

@Metadata(d1={"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016\u00a8\u0006\t"}, d2={"okio/Timeout$Companion$NONE$1", "Lokio/Timeout;", "deadlineNanoTime", "", "throwIfReached", "", "timeout", "unit", "Ljava/util/concurrent/TimeUnit;", "okio"}, k=1, mv={1, 5, 1}, xi=48)
public static final class Timeout.Companion.NONE.1
extends Timeout {
    Timeout.Companion.NONE.1() {
    }

    public Timeout deadlineNanoTime(long l) {
        return this;
    }

    public void throwIfReached() {
    }

    public Timeout timeout(long l, TimeUnit timeUnit) {
        Intrinsics.checkNotNullParameter((Object)((Object)timeUnit), (String)"unit");
        return this;
    }
}
