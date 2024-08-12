/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Lazy
 *  kotlin.LazyKt
 *  kotlin.Metadata
 *  kotlin.Pair
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.Intrinsics
 *  okio.FileHandle
 *  okio.FileMetadata
 *  okio.FileSystem
 *  okio.Path
 *  okio.Path$Companion
 *  okio.Sink
 *  okio.Source
 *  okio.internal.ResourceFileSystem$Companion
 */
package okio.internal;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import okio.FileHandle;
import okio.FileMetadata;
import okio.FileSystem;
import okio.Path;
import okio.Sink;
import okio.Source;
import okio.internal.ResourceFileSystem;

/*
 * Exception performing whole class analysis ignored.
 */
@Metadata(d1={"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u0000 *2\u00020\u0001:\u0001*B\u0017\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0005H\u0016J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\nH\u0016J\u0010\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\nH\u0016J\u0010\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\nH\u0002J\u0018\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u0005H\u0016J\u0018\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\nH\u0016J\u0018\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0005H\u0016J\u0016\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\n0\b2\u0006\u0010\u001b\u001a\u00020\nH\u0016J\u0018\u0010 \u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\b2\u0006\u0010\u001b\u001a\u00020\nH\u0016J\u0012\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010\u0018\u001a\u00020\nH\u0016J\u0010\u0010#\u001a\u00020$2\u0006\u0010\u0011\u001a\u00020\nH\u0016J \u0010%\u001a\u00020$2\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0005H\u0016J\u0018\u0010&\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u0005H\u0016J\u0010\u0010\u0015\u001a\u00020'2\u0006\u0010\u0011\u001a\u00020\nH\u0016J\f\u0010(\u001a\u00020)*\u00020\nH\u0002R-\u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\n0\t0\b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f\u00a8\u0006+"}, d2={"Lokio/internal/ResourceFileSystem;", "Lokio/FileSystem;", "classLoader", "Ljava/lang/ClassLoader;", "indexEagerly", "", "(Ljava/lang/ClassLoader;Z)V", "roots", "", "Lkotlin/Pair;", "Lokio/Path;", "getRoots", "()Ljava/util/List;", "roots$delegate", "Lkotlin/Lazy;", "appendingSink", "Lokio/Sink;", "file", "mustExist", "atomicMove", "", "source", "target", "canonicalize", "path", "canonicalizeInternal", "createDirectory", "dir", "mustCreate", "createSymlink", "delete", "list", "listOrNull", "metadataOrNull", "Lokio/FileMetadata;", "openReadOnly", "Lokio/FileHandle;", "openReadWrite", "sink", "Lokio/Source;", "toRelativePath", "", "Companion", "okio"}, k=1, mv={1, 5, 1}, xi=48)
public final class ResourceFileSystem
extends FileSystem {
    private static final Companion Companion = new Companion(null);
    @Deprecated
    private static final Path ROOT = Path.Companion.get$default((Path.Companion)Path.Companion, (String)"/", (boolean)false, (int)1, null);
    private final Lazy roots$delegate;

    public ResourceFileSystem(ClassLoader classLoader, boolean bl) {
        Intrinsics.checkNotNullParameter((Object)classLoader, (String)"classLoader");
        this.roots$delegate = LazyKt.lazy((Function0)((Function0)new /* Unavailable Anonymous Inner Class!! */));
        if (!bl) return;
        this.getRoots().size();
    }

    public static final /* synthetic */ Companion access$getCompanion$p() {
        return Companion;
    }

    public static final /* synthetic */ Path access$getROOT$cp() {
        return ROOT;
    }

    private final Path canonicalizeInternal(Path path) {
        return ROOT.resolve(path, true);
    }

    private final List<Pair<FileSystem, Path>> getRoots() {
        return (List)this.roots$delegate.getValue();
    }

    private final String toRelativePath(Path path) {
        return this.canonicalizeInternal(path).relativeTo(ROOT).toString();
    }

    public Sink appendingSink(Path object, boolean bl) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"file");
        object = new StringBuilder();
        ((StringBuilder)object).append((Object)this);
        ((StringBuilder)object).append(" is read-only");
        throw new IOException(((StringBuilder)object).toString());
    }

    public void atomicMove(Path object, Path path) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"source");
        Intrinsics.checkNotNullParameter((Object)path, (String)"target");
        object = new StringBuilder();
        ((StringBuilder)object).append((Object)this);
        ((StringBuilder)object).append(" is read-only");
        throw new IOException(((StringBuilder)object).toString());
    }

    public Path canonicalize(Path path) {
        Intrinsics.checkNotNullParameter((Object)path, (String)"path");
        return this.canonicalizeInternal(path);
    }

    public void createDirectory(Path object, boolean bl) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"dir");
        object = new StringBuilder();
        ((StringBuilder)object).append((Object)this);
        ((StringBuilder)object).append(" is read-only");
        throw new IOException(((StringBuilder)object).toString());
    }

    public void createSymlink(Path object, Path path) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"source");
        Intrinsics.checkNotNullParameter((Object)path, (String)"target");
        object = new StringBuilder();
        ((StringBuilder)object).append((Object)this);
        ((StringBuilder)object).append(" is read-only");
        throw new IOException(((StringBuilder)object).toString());
    }

    public void delete(Path object, boolean bl) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"path");
        object = new StringBuilder();
        ((StringBuilder)object).append((Object)this);
        ((StringBuilder)object).append(" is read-only");
        throw new IOException(((StringBuilder)object).toString());
    }

    public List<Path> list(Path object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"dir");
        String string = this.toRelativePath((Path)object);
        Set set = new LinkedHashSet();
        Iterator<Pair<FileSystem, Path>> iterator = this.getRoots().iterator();
        boolean bl = false;
        while (iterator.hasNext()) {
            Object object2 = iterator.next();
            Object object3 = (FileSystem)object2.component1();
            Path path = (Path)object2.component2();
            try {
                Path path2;
                object2 = set;
                Object object4 = object3.list(path.resolve(string));
                object3 = new ArrayList();
                object3 = (Collection)object3;
                Iterator iterator2 = object4.iterator();
                while (iterator2.hasNext()) {
                    object4 = iterator2.next();
                    path2 = (Path)object4;
                    if (!okio.internal.ResourceFileSystem$Companion.access$keepPath((Companion)Companion, (Path)path2)) continue;
                    object3.add(object4);
                }
                object4 = (List)object3;
                object3 = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)object4, (int)10));
                object3 = (Collection)object3;
                object4 = object4.iterator();
                while (object4.hasNext()) {
                    path2 = (Path)object4.next();
                    object3.add(Companion.removeBase(path2, path));
                }
                CollectionsKt.addAll(object2, (Iterable)((List)object3));
                bl = true;
            }
            catch (IOException iOException) {}
        }
        if (bl) {
            return CollectionsKt.toList((Iterable)set);
        }
        object = new FileNotFoundException(Intrinsics.stringPlus((String)"file not found: ", (Object)object));
        throw object;
    }

    public List<Path> listOrNull(Path object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"dir");
        String string = this.toRelativePath((Path)object);
        Set set = new LinkedHashSet();
        Iterator<Pair<FileSystem, Path>> iterator = this.getRoots().iterator();
        boolean bl = false;
        while (true) {
            boolean bl2 = iterator.hasNext();
            Path path = null;
            object = null;
            if (!bl2) {
                object = path;
                if (!bl) return object;
                object = CollectionsKt.toList((Iterable)set);
                return object;
            }
            path = iterator.next();
            Object object2 = (FileSystem)path.component1();
            if ((object2 = object2.listOrNull((path = (Path)path.component2()).resolve(string))) != null) {
                Object object3;
                object2 = (Iterable)object2;
                object = new ArrayList();
                Iterator iterator2 = object2.iterator();
                while (iterator2.hasNext()) {
                    object3 = iterator2.next();
                    object2 = (Path)object3;
                    if (!okio.internal.ResourceFileSystem$Companion.access$keepPath((Companion)Companion, (Path)object2)) continue;
                    object.add(object3);
                }
                object2 = (List)object;
                object = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)object2, (int)10));
                object3 = object2.iterator();
                while (object3.hasNext()) {
                    object2 = (Path)object3.next();
                    object.add(Companion.removeBase((Path)object2, path));
                }
                object = (List)object;
            }
            if (object == null) continue;
            CollectionsKt.addAll((Collection)set, (Iterable)((Iterable)object));
            bl = true;
        }
    }

    public FileMetadata metadataOrNull(Path object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"path");
        if (!okio.internal.ResourceFileSystem$Companion.access$keepPath((Companion)Companion, (Path)object)) {
            return null;
        }
        String string = this.toRelativePath((Path)object);
        object = this.getRoots().iterator();
        while (object.hasNext()) {
            Pair pair = (Pair)object.next();
            if ((pair = ((FileSystem)pair.component1()).metadataOrNull(((Path)pair.component2()).resolve(string))) != null) return pair;
        }
        return null;
    }

    public FileHandle openReadOnly(Path object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"file");
        if (!okio.internal.ResourceFileSystem$Companion.access$keepPath((Companion)Companion, (Path)object)) {
            object = new FileNotFoundException(Intrinsics.stringPlus((String)"file not found: ", (Object)object));
            throw object;
        }
        String string = this.toRelativePath((Path)object);
        Iterator<Pair<FileSystem, Path>> iterator = this.getRoots().iterator();
        while (iterator.hasNext()) {
            Path path = iterator.next();
            FileSystem fileSystem = (FileSystem)path.component1();
            path = (Path)path.component2();
            try {
                fileSystem = fileSystem.openReadOnly(path.resolve(string));
                return fileSystem;
            }
            catch (FileNotFoundException fileNotFoundException) {
            }
        }
        throw new FileNotFoundException(Intrinsics.stringPlus((String)"file not found: ", (Object)object));
    }

    public FileHandle openReadWrite(Path path, boolean bl, boolean bl2) {
        Intrinsics.checkNotNullParameter((Object)path, (String)"file");
        throw new IOException("resources are not writable");
    }

    public Sink sink(Path object, boolean bl) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"file");
        object = new StringBuilder();
        ((StringBuilder)object).append((Object)this);
        ((StringBuilder)object).append(" is read-only");
        throw new IOException(((StringBuilder)object).toString());
    }

    public Source source(Path object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"file");
        if (!okio.internal.ResourceFileSystem$Companion.access$keepPath((Companion)Companion, (Path)object)) {
            object = new FileNotFoundException(Intrinsics.stringPlus((String)"file not found: ", (Object)object));
            throw object;
        }
        String string = this.toRelativePath((Path)object);
        Iterator<Pair<FileSystem, Path>> iterator = this.getRoots().iterator();
        while (iterator.hasNext()) {
            Path path = iterator.next();
            FileSystem fileSystem = (FileSystem)path.component1();
            path = (Path)path.component2();
            try {
                fileSystem = fileSystem.source(path.resolve(string));
                return fileSystem;
            }
            catch (FileNotFoundException fileNotFoundException) {
            }
        }
        throw new FileNotFoundException(Intrinsics.stringPlus((String)"file not found: ", (Object)object));
    }
}
