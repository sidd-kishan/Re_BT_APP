/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Lambda
 *  okio.internal.ZipEntry
 */
package okio.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import okio.internal.ZipEntry;

@Metadata(d1={"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2={"<anonymous>", "", "it", "Lokio/internal/ZipEntry;"}, k=3, mv={1, 5, 1}, xi=48)
static final class ZipKt.openZip.1
extends Lambda
implements Function1<ZipEntry, Boolean> {
    public static final ZipKt.openZip.1 INSTANCE = new /* invalid duplicate definition of identical inner class */;

    ZipKt.openZip.1() {
    }

    public final Boolean invoke(ZipEntry zipEntry) {
        Intrinsics.checkNotNullParameter((Object)zipEntry, (String)"it");
        return true;
    }
}
