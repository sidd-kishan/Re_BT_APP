/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Lambda
 */
package kotlin.io;

import java.io.File;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1={"\u0000\u0014\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n\u00a2\u0006\u0002\b\u0006"}, d2={"<anonymous>", "", "<anonymous parameter 0>", "Ljava/io/File;", "exception", "Ljava/io/IOException;", "invoke"}, k=3, mv={1, 5, 1})
static final class FilesKt__UtilsKt.copyRecursively.1
extends Lambda
implements Function2 {
    public static final FilesKt__UtilsKt.copyRecursively.1 INSTANCE = new /* invalid duplicate definition of identical inner class */;

    FilesKt__UtilsKt.copyRecursively.1() {
    }

    public final Void invoke(File file, IOException iOException) {
        Intrinsics.checkNotNullParameter((Object)file, (String)"<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter((Object)iOException, (String)"exception");
        throw (Throwable)iOException;
    }
}
