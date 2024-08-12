/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.ranges.RangesKt
 *  okio.Buffer
 */
package okhttp3.logging.internal;

import java.io.EOFException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import okio.Buffer;

@Metadata(d1={"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u00a8\u0006\u0003"}, d2={"isProbablyUtf8", "", "Lokio/Buffer;", "okhttp-logging-interceptor"}, k=2, mv={1, 5, 1}, xi=48)
public final class Utf8Kt {
    public static final boolean isProbablyUtf8(Buffer buffer) {
        Intrinsics.checkNotNullParameter((Object)buffer, (String)"<this>");
        try {
            int n;
            Buffer buffer2 = new Buffer();
            buffer.copyTo(buffer2, 0L, RangesKt.coerceAtMost((long)buffer.size(), (long)64L));
            int n2 = 0;
            do {
                boolean bl;
                n = n2 + 1;
                if (buffer2.exhausted()) return true;
                n2 = buffer2.readUtf8CodePoint();
                if (Character.isISOControl(n2) && !(bl = Character.isWhitespace(n2))) {
                    return false;
                }
                n2 = n;
            } while (n < 16);
            return true;
        }
        catch (EOFException eOFException) {
            return false;
        }
    }
}
