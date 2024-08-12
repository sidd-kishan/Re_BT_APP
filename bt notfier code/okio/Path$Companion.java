/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.JvmStatic
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  okio.Path
 *  okio.internal._PathKt
 */
package okio;

import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okio.Path;
import okio.internal._PathKt;

@Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001b\u0010\u0005\u001a\u00020\u0006*\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u0007\u00a2\u0006\u0002\b\nJ\u001b\u0010\u0005\u001a\u00020\u0006*\u00020\u000b2\b\b\u0002\u0010\b\u001a\u00020\tH\u0007\u00a2\u0006\u0002\b\nJ\u001b\u0010\f\u001a\u00020\u0006*\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\tH\u0007\u00a2\u0006\u0002\b\nR\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2={"Lokio/Path$Companion;", "", "()V", "DIRECTORY_SEPARATOR", "", "toOkioPath", "Lokio/Path;", "Ljava/io/File;", "normalize", "", "get", "Ljava/nio/file/Path;", "toPath", "okio"}, k=1, mv={1, 5, 1}, xi=48)
public static final class Path.Companion {
    private Path.Companion() {
    }

    public /* synthetic */ Path.Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public static /* synthetic */ Path get$default(Path.Companion companion, File file, boolean bl, int n, Object object) {
        if ((n & 1) == 0) return companion.get(file, bl);
        bl = false;
        return companion.get(file, bl);
    }

    public static /* synthetic */ Path get$default(Path.Companion companion, String string, boolean bl, int n, Object object) {
        if ((n & 1) == 0) return companion.get(string, bl);
        bl = false;
        return companion.get(string, bl);
    }

    public static /* synthetic */ Path get$default(Path.Companion companion, java.nio.file.Path path, boolean bl, int n, Object object) {
        if ((n & 1) == 0) return companion.get(path, bl);
        bl = false;
        return companion.get(path, bl);
    }

    @JvmStatic
    public final Path get(File file) {
        Intrinsics.checkNotNullParameter((Object)file, (String)"<this>");
        return Path.Companion.get$default(this, file, false, 1, null);
    }

    @JvmStatic
    public final Path get(File object, boolean bl) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"<this>");
        object = ((File)object).toString();
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"toString()");
        return this.get((String)object, bl);
    }

    @JvmStatic
    public final Path get(String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"<this>");
        return Path.Companion.get$default(this, string, false, 1, null);
    }

    @JvmStatic
    public final Path get(String string, boolean bl) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"<this>");
        return _PathKt.commonToPath((String)string, (boolean)bl);
    }

    @JvmStatic
    public final Path get(java.nio.file.Path path) {
        Intrinsics.checkNotNullParameter((Object)path, (String)"<this>");
        return Path.Companion.get$default(this, path, false, 1, null);
    }

    @JvmStatic
    public final Path get(java.nio.file.Path path, boolean bl) {
        Intrinsics.checkNotNullParameter((Object)path, (String)"<this>");
        return this.get(((Object)path).toString(), bl);
    }
}
