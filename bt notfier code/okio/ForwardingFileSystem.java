/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Reflection
 *  kotlin.sequences.Sequence
 *  kotlin.sequences.SequencesKt
 *  okio.FileHandle
 *  okio.FileMetadata
 *  okio.FileSystem
 *  okio.Path
 *  okio.Sink
 *  okio.Source
 */
package okio;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import okio.FileHandle;
import okio.FileMetadata;
import okio.FileSystem;
import okio.Path;
import okio.Sink;
import okio.Source;

@Metadata(d1={"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u00a2\u0006\u0002\u0010\u0003J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\bH\u0016J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\bH\u0016J\u0018\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\nH\u0016J\u0018\u0010\u0014\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\bH\u0016J\u0018\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0016\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\b0\u00172\u0006\u0010\u0012\u001a\u00020\bH\u0016J\u0018\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00172\u0006\u0010\u0012\u001a\u00020\bH\u0016J\u001e\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\b0\u001a2\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\nH\u0016J\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u0010\u001a\u00020\bH\u0016J \u0010\u001e\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020 H\u0016J\u0018\u0010\"\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0010\u0010#\u001a\u00020$2\u0006\u0010\u0007\u001a\u00020\bH\u0016J \u0010%\u001a\u00020$2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010&\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\nH\u0016J\u0010\u0010\r\u001a\u00020'2\u0006\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010(\u001a\u00020 H\u0016R\u0013\u0010\u0002\u001a\u00020\u00018\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0004\u00a8\u0006)"}, d2={"Lokio/ForwardingFileSystem;", "Lokio/FileSystem;", "delegate", "(Lokio/FileSystem;)V", "()Lokio/FileSystem;", "appendingSink", "Lokio/Sink;", "file", "Lokio/Path;", "mustExist", "", "atomicMove", "", "source", "target", "canonicalize", "path", "createDirectory", "dir", "mustCreate", "createSymlink", "delete", "list", "", "listOrNull", "listRecursively", "Lkotlin/sequences/Sequence;", "followSymlinks", "metadataOrNull", "Lokio/FileMetadata;", "onPathParameter", "functionName", "", "parameterName", "onPathResult", "openReadOnly", "Lokio/FileHandle;", "openReadWrite", "sink", "Lokio/Source;", "toString", "okio"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class ForwardingFileSystem
extends FileSystem {
    private final FileSystem delegate;

    public ForwardingFileSystem(FileSystem fileSystem) {
        Intrinsics.checkNotNullParameter((Object)fileSystem, (String)"delegate");
        this.delegate = fileSystem;
    }

    public Sink appendingSink(Path path, boolean bl) throws IOException {
        Intrinsics.checkNotNullParameter((Object)path, (String)"file");
        path = this.onPathParameter(path, "appendingSink", "file");
        return this.delegate.appendingSink(path, bl);
    }

    public void atomicMove(Path path, Path path2) throws IOException {
        Intrinsics.checkNotNullParameter((Object)path, (String)"source");
        Intrinsics.checkNotNullParameter((Object)path2, (String)"target");
        path = this.onPathParameter(path, "atomicMove", "source");
        path2 = this.onPathParameter(path2, "atomicMove", "target");
        this.delegate.atomicMove(path, path2);
    }

    public Path canonicalize(Path path) throws IOException {
        Intrinsics.checkNotNullParameter((Object)path, (String)"path");
        path = this.onPathParameter(path, "canonicalize", "path");
        return this.onPathResult(this.delegate.canonicalize(path), "canonicalize");
    }

    public void createDirectory(Path path, boolean bl) throws IOException {
        Intrinsics.checkNotNullParameter((Object)path, (String)"dir");
        path = this.onPathParameter(path, "createDirectory", "dir");
        this.delegate.createDirectory(path, bl);
    }

    public void createSymlink(Path path, Path path2) throws IOException {
        Intrinsics.checkNotNullParameter((Object)path, (String)"source");
        Intrinsics.checkNotNullParameter((Object)path2, (String)"target");
        path = this.onPathParameter(path, "createSymlink", "source");
        path2 = this.onPathParameter(path2, "createSymlink", "target");
        this.delegate.createSymlink(path, path2);
    }

    public final FileSystem delegate() {
        return this.delegate;
    }

    public void delete(Path path, boolean bl) throws IOException {
        Intrinsics.checkNotNullParameter((Object)path, (String)"path");
        path = this.onPathParameter(path, "delete", "path");
        this.delegate.delete(path, bl);
    }

    public List<Path> list(Path object) throws IOException {
        Intrinsics.checkNotNullParameter((Object)object, (String)"dir");
        object = this.onPathParameter((Path)object, "list", "dir");
        Object object2 = this.delegate.list(object);
        object = new ArrayList();
        object2 = object2.iterator();
        while (true) {
            if (!object2.hasNext()) {
                object = (List)object;
                CollectionsKt.sort((List)object);
                return object;
            }
            object.add(this.onPathResult((Path)object2.next(), "list"));
        }
    }

    public List<Path> listOrNull(Path object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"dir");
        object = this.onPathParameter((Path)object, "listOrNull", "dir");
        object = this.delegate.listOrNull(object);
        if (object == null) {
            return null;
        }
        Object object2 = (Iterable)object;
        object = new ArrayList();
        object2 = object2.iterator();
        while (true) {
            if (!object2.hasNext()) {
                object = (List)object;
                CollectionsKt.sort((List)object);
                return object;
            }
            object.add(this.onPathResult((Path)object2.next(), "listOrNull"));
        }
    }

    public Sequence<Path> listRecursively(Path path, boolean bl) {
        Intrinsics.checkNotNullParameter((Object)path, (String)"dir");
        path = this.onPathParameter(path, "listRecursively", "dir");
        return SequencesKt.map((Sequence)this.delegate.listRecursively(path, bl), (Function1)((Function1)new /* Unavailable Anonymous Inner Class!! */));
    }

    public FileMetadata metadataOrNull(Path path) throws IOException {
        Intrinsics.checkNotNullParameter((Object)path, (String)"path");
        path = this.onPathParameter(path, "metadataOrNull", "path");
        path = this.delegate.metadataOrNull(path);
        if (path == null) {
            return null;
        }
        if (path.getSymlinkTarget() != null) return FileMetadata.copy$default((FileMetadata)path, (boolean)false, (boolean)false, (Path)this.onPathResult(path.getSymlinkTarget(), "metadataOrNull"), null, null, null, null, null, (int)251, null);
        return path;
    }

    public Path onPathParameter(Path path, String string, String string2) {
        Intrinsics.checkNotNullParameter((Object)path, (String)"path");
        Intrinsics.checkNotNullParameter((Object)string, (String)"functionName");
        Intrinsics.checkNotNullParameter((Object)string2, (String)"parameterName");
        return path;
    }

    public Path onPathResult(Path path, String string) {
        Intrinsics.checkNotNullParameter((Object)path, (String)"path");
        Intrinsics.checkNotNullParameter((Object)string, (String)"functionName");
        return path;
    }

    public FileHandle openReadOnly(Path path) throws IOException {
        Intrinsics.checkNotNullParameter((Object)path, (String)"file");
        path = this.onPathParameter(path, "openReadOnly", "file");
        return this.delegate.openReadOnly(path);
    }

    public FileHandle openReadWrite(Path path, boolean bl, boolean bl2) throws IOException {
        Intrinsics.checkNotNullParameter((Object)path, (String)"file");
        path = this.onPathParameter(path, "openReadWrite", "file");
        return this.delegate.openReadWrite(path, bl, bl2);
    }

    public Sink sink(Path path, boolean bl) throws IOException {
        Intrinsics.checkNotNullParameter((Object)path, (String)"file");
        path = this.onPathParameter(path, "sink", "file");
        return this.delegate.sink(path, bl);
    }

    public Source source(Path path) throws IOException {
        Intrinsics.checkNotNullParameter((Object)path, (String)"file");
        path = this.onPathParameter(path, "source", "file");
        return this.delegate.source(path);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append((Object)Reflection.getOrCreateKotlinClass(((Object)((Object)this)).getClass()).getSimpleName());
        stringBuilder.append('(');
        stringBuilder.append(this.delegate);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}
