/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.TuplesKt
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.text.StringsKt
 *  okio.FileSystem
 *  okio.Path
 *  okio.Path$Companion
 *  okio.internal.ResourceFileSystem
 *  okio.internal.ResourceFileSystem$Companion$toJarRoot$zip$1
 *  okio.internal.ZipKt
 */
package okio.internal;

import java.io.File;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okio.FileSystem;
import okio.Path;
import okio.internal.ResourceFileSystem;
import okio.internal.ZipKt;

/*
 * Exception performing whole class analysis ignored.
 */
@Metadata(d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u0002J\u0012\u0010\n\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004J\u001c\u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00040\u000e0\r*\u00020\u0010J\u0018\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000e*\u00020\u0012J\u0018\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000e*\u00020\u0012R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0014"}, d2={"Lokio/internal/ResourceFileSystem$Companion;", "", "()V", "ROOT", "Lokio/Path;", "getROOT", "()Lokio/Path;", "keepPath", "", "path", "removeBase", "base", "toClasspathRoots", "", "Lkotlin/Pair;", "Lokio/FileSystem;", "Ljava/lang/ClassLoader;", "toFileRoot", "Ljava/net/URL;", "toJarRoot", "okio"}, k=1, mv={1, 5, 1}, xi=48)
private static final class ResourceFileSystem.Companion {
    private ResourceFileSystem.Companion() {
    }

    public /* synthetic */ ResourceFileSystem.Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public static final /* synthetic */ boolean access$keepPath(ResourceFileSystem.Companion companion, Path path) {
        return companion.keepPath(path);
    }

    private final boolean keepPath(Path path) {
        return StringsKt.endsWith((String)path.name(), (String)".class", (boolean)true) ^ true;
    }

    public final Path getROOT() {
        return ResourceFileSystem.access$getROOT$cp();
    }

    public final Path removeBase(Path path, Path object) {
        Intrinsics.checkNotNullParameter((Object)path, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)object, (String)"base");
        object = object.toString();
        return this.getROOT().resolve(StringsKt.replace$default((String)StringsKt.removePrefix((String)path.toString(), (CharSequence)((CharSequence)object)), (char)'\\', (char)'/', (boolean)false, (int)4, null));
    }

    public final List<Pair<FileSystem, Path>> toClasspathRoots(ClassLoader collection) {
        Object object;
        Object object2;
        Intrinsics.checkNotNullParameter((Object)collection, (String)"<this>");
        Object object3 = ((ClassLoader)((Object)collection)).getResources("");
        Intrinsics.checkNotNullExpressionValue(object3, (String)"getResources(\"\")");
        object3 = Collections.list(object3);
        Intrinsics.checkNotNullExpressionValue((Object)object3, (String)"java.util.Collections.list(this)");
        Iterator iterator = (List)object3;
        object3 = new ArrayList();
        iterator = iterator.iterator();
        while (iterator.hasNext()) {
            object2 = (Pair<FileSystem, Path>)iterator.next();
            object = ResourceFileSystem.access$getCompanion$p();
            Intrinsics.checkNotNullExpressionValue((Object)object2, (String)"it");
            if ((object2 = ((ResourceFileSystem.Companion)object).toFileRoot((URL)object2)) == null) continue;
            object3.add(object2);
        }
        object3 = (List)object3;
        collection = ((ClassLoader)((Object)collection)).getResources("META-INF/MANIFEST.MF");
        Intrinsics.checkNotNullExpressionValue((Object)collection, (String)"getResources(\"META-INF/MANIFEST.MF\")");
        collection = Collections.list(collection);
        Intrinsics.checkNotNullExpressionValue(collection, (String)"java.util.Collections.list(this)");
        iterator = (List)collection;
        collection = new ArrayList();
        iterator = iterator.iterator();
        while (iterator.hasNext()) {
            object = (URL)iterator.next();
            object2 = ResourceFileSystem.access$getCompanion$p();
            Intrinsics.checkNotNullExpressionValue((Object)object, (String)"it");
            if ((object2 = ((ResourceFileSystem.Companion)object2).toJarRoot((URL)object)) == null) continue;
            collection.add(object2);
        }
        return CollectionsKt.plus((Collection)object3, (Iterable)((List)collection));
    }

    public final Pair<FileSystem, Path> toFileRoot(URL uRL) {
        Intrinsics.checkNotNullParameter((Object)uRL, (String)"<this>");
        if (Intrinsics.areEqual((Object)uRL.getProtocol(), (Object)"file")) return TuplesKt.to((Object)FileSystem.SYSTEM, (Object)Path.Companion.get$default((Path.Companion)Path.Companion, (File)new File(uRL.toURI()), (boolean)false, (int)1, null));
        return null;
    }

    public final Pair<FileSystem, Path> toJarRoot(URL uRL) {
        Intrinsics.checkNotNullParameter((Object)uRL, (String)"<this>");
        String string = uRL.toString();
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"toString()");
        if (!StringsKt.startsWith$default((String)string, (String)"jar:file:", (boolean)false, (int)2, null)) {
            return null;
        }
        int n = StringsKt.lastIndexOf$default((CharSequence)string, (String)"!", (int)0, (boolean)false, (int)6, null);
        if (n == -1) {
            return null;
        }
        uRL = Path.Companion;
        string = string.substring(4, n);
        Intrinsics.checkNotNullExpressionValue((Object)string, (String)"(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
        return TuplesKt.to((Object)ZipKt.openZip((Path)Path.Companion.get$default((Path.Companion)uRL, (File)new File(URI.create(string)), (boolean)false, (int)1, null), (FileSystem)FileSystem.SYSTEM, (Function1)((Function1)toJarRoot.zip.1.INSTANCE)), (Object)this.getROOT());
    }
}
