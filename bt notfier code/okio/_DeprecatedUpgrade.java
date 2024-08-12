/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  okio._DeprecatedOkio
 *  okio._DeprecatedUtf8
 */
package okio;

import kotlin.Metadata;
import okio._DeprecatedOkio;
import okio._DeprecatedUtf8;

@Metadata(d1={"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0011\u0010\u0000\u001a\u00020\u0001\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2={"Okio", "Lokio/-DeprecatedOkio;", "getOkio", "()Lokio/-DeprecatedOkio;", "Utf8", "Lokio/-DeprecatedUtf8;", "getUtf8", "()Lokio/-DeprecatedUtf8;", "okio"}, k=2, mv={1, 5, 1}, xi=48)
public final class _DeprecatedUpgrade {
    private static final _DeprecatedOkio Okio = _DeprecatedOkio.INSTANCE;
    private static final _DeprecatedUtf8 Utf8 = _DeprecatedUtf8.INSTANCE;

    public static final _DeprecatedOkio getOkio() {
        return Okio;
    }

    public static final _DeprecatedUtf8 getUtf8() {
        return Utf8;
    }
}
