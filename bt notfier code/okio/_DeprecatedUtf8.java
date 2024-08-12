/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Deprecated
 *  kotlin.DeprecationLevel
 *  kotlin.Metadata
 *  kotlin.ReplaceWith
 *  kotlin.jvm.internal.Intrinsics
 *  okio.Utf8
 */
package okio;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import okio.Utf8;

@Deprecated(message="changed in Okio 2.x")
@Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0007\u00a8\u0006\n"}, d2={"Lokio/-DeprecatedUtf8;", "", "()V", "size", "", "string", "", "beginIndex", "", "endIndex", "okio"}, k=1, mv={1, 5, 1}, xi=48)
public final class _DeprecatedUtf8 {
    public static final _DeprecatedUtf8 INSTANCE = new _DeprecatedUtf8();

    private _DeprecatedUtf8() {
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to extension function", replaceWith=@ReplaceWith(expression="string.utf8Size()", imports={"okio.utf8Size"}))
    public final long size(String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"string");
        return Utf8.size$default((String)string, (int)0, (int)0, (int)3, null);
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="moved to extension function", replaceWith=@ReplaceWith(expression="string.utf8Size(beginIndex, endIndex)", imports={"okio.utf8Size"}))
    public final long size(String string, int n, int n2) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"string");
        return Utf8.size((String)string, (int)n, (int)n2);
    }
}
