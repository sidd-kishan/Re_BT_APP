/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.Intrinsics
 *  okio.FileHandle
 *  okio.FileMetadata
 *  okio.FileSystem
 *  okio.JvmFileHandle
 *  okio.Okio
 *  okio.Path
 *  okio.Path$Companion
 *  okio.Sink
 *  okio.Source
 */
package okio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import okio.FileHandle;
import okio.FileMetadata;
import okio.FileSystem;
import okio.JvmFileHandle;
import okio.Okio;
import okio.Path;
import okio.Sink;
import okio.Source;

@Metadata(d1={"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0010\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006H\u0016J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006H\u0016J\u0018\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\bH\u0016J\u0018\u0010\u0012\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006H\u0016J\u0018\u0010\u0013\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00060\u00152\u0006\u0010\u0010\u001a\u00020\u0006H\u0016J \u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00152\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\bH\u0002J\u0018\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00152\u0006\u0010\u0010\u001a\u00020\u0006H\u0016J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u000e\u001a\u00020\u0006H\u0016J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J \u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\bH\u0016J\u0010\u0010\u000b\u001a\u00020\u001e2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u001f\u001a\u00020 H\u0016J\f\u0010!\u001a\u00020\n*\u00020\u0006H\u0002J\f\u0010\"\u001a\u00020\n*\u00020\u0006H\u0002\u00a8\u0006#"}, d2={"Lokio/JvmSystemFileSystem;", "Lokio/FileSystem;", "()V", "appendingSink", "Lokio/Sink;", "file", "Lokio/Path;", "mustExist", "", "atomicMove", "", "source", "target", "canonicalize", "path", "createDirectory", "dir", "mustCreate", "createSymlink", "delete", "list", "", "throwOnFailure", "listOrNull", "metadataOrNull", "Lokio/FileMetadata;", "openReadOnly", "Lokio/FileHandle;", "openReadWrite", "sink", "Lokio/Source;", "toString", "", "requireCreate", "requireExist", "okio"}, k=1, mv={1, 5, 1}, xi=48)
public class JvmSystemFileSystem
extends FileSystem {
    private final List<Path> list(Path object, boolean bl) {
        Object object2 = object.toFile();
        String[] stringArray = ((File)object2).list();
        if (stringArray == null) {
            if (!bl) return null;
            if (((File)object2).exists()) throw new IOException(Intrinsics.stringPlus((String)"failed to list ", (Object)object));
            throw new FileNotFoundException(Intrinsics.stringPlus((String)"no such file: ", (Object)object));
        }
        object2 = new ArrayList();
        int n = stringArray.length;
        int n2 = 0;
        while (true) {
            if (n2 >= n) {
                object = (List)object2;
                CollectionsKt.sort((List)object);
                return object;
            }
            String string = stringArray[n2];
            Intrinsics.checkNotNullExpressionValue((Object)string, (String)"it");
            object2.add(object.resolve(string));
            ++n2;
        }
    }

    private final void requireCreate(Path path) {
        if (!this.exists(path)) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(path);
        stringBuilder.append(" already exists.");
        throw new IOException(stringBuilder.toString());
    }

    private final void requireExist(Path path) {
        if (this.exists(path)) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(path);
        stringBuilder.append(" doesn't exist.");
        throw new IOException(stringBuilder.toString());
    }

    public Sink appendingSink(Path path, boolean bl) {
        Intrinsics.checkNotNullParameter((Object)path, (String)"file");
        if (!bl) return Okio.sink((File)path.toFile(), (boolean)true);
        this.requireExist(path);
        return Okio.sink((File)path.toFile(), (boolean)true);
    }

    public void atomicMove(Path path, Path path2) {
        Intrinsics.checkNotNullParameter((Object)path, (String)"source");
        Intrinsics.checkNotNullParameter((Object)path2, (String)"target");
        if (path.toFile().renameTo(path2.toFile())) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("failed to move ");
        stringBuilder.append(path);
        stringBuilder.append(" to ");
        stringBuilder.append(path2);
        throw new IOException(stringBuilder.toString());
    }

    public Path canonicalize(Path object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"path");
        object = object.toFile().getCanonicalFile();
        if (!((File)object).exists()) throw new FileNotFoundException("no such file");
        Path.Companion companion = Path.Companion;
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"canonicalFile");
        return Path.Companion.get$default((Path.Companion)companion, (File)object, (boolean)false, (int)1, null);
    }

    public void createDirectory(Path path, boolean bl) {
        Intrinsics.checkNotNullParameter((Object)path, (String)"dir");
        if (path.toFile().mkdir()) return;
        Object object = this.metadataOrNull(path);
        boolean bl2 = false;
        if (object != null && object.isDirectory()) {
            bl2 = true;
        }
        if (!bl2) throw new IOException(Intrinsics.stringPlus((String)"failed to create directory: ", (Object)path));
        if (!bl) {
            return;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append(path);
        ((StringBuilder)object).append(" already exist.");
        throw new IOException(((StringBuilder)object).toString());
    }

    public void createSymlink(Path path, Path path2) {
        Intrinsics.checkNotNullParameter((Object)path, (String)"source");
        Intrinsics.checkNotNullParameter((Object)path2, (String)"target");
        throw new IOException("unsupported");
    }

    public void delete(Path path, boolean bl) {
        Intrinsics.checkNotNullParameter((Object)path, (String)"path");
        File file = path.toFile();
        if (file.delete()) return;
        if (file.exists()) throw new IOException(Intrinsics.stringPlus((String)"failed to delete ", (Object)path));
        if (bl) throw new FileNotFoundException(Intrinsics.stringPlus((String)"no such file: ", (Object)path));
    }

    public List<Path> list(Path object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"dir");
        object = this.list((Path)object, true);
        Intrinsics.checkNotNull((Object)object);
        return object;
    }

    public List<Path> listOrNull(Path path) {
        Intrinsics.checkNotNullParameter((Object)path, (String)"dir");
        return this.list(path, false);
    }

    public FileMetadata metadataOrNull(Path object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"path");
        object = object.toFile();
        boolean bl = ((File)object).isFile();
        boolean bl2 = ((File)object).isDirectory();
        long l = ((File)object).lastModified();
        long l2 = ((File)object).length();
        if (bl) return new FileMetadata(bl, bl2, null, Long.valueOf(l2), null, Long.valueOf(l), null, null, 128, null);
        if (bl2) return new FileMetadata(bl, bl2, null, Long.valueOf(l2), null, Long.valueOf(l), null, null, 128, null);
        if (l != 0L) return new FileMetadata(bl, bl2, null, Long.valueOf(l2), null, Long.valueOf(l), null, null, 128, null);
        if (l2 != 0L) return new FileMetadata(bl, bl2, null, Long.valueOf(l2), null, Long.valueOf(l), null, null, 128, null);
        if (((File)object).exists()) return new FileMetadata(bl, bl2, null, Long.valueOf(l2), null, Long.valueOf(l), null, null, 128, null);
        return null;
    }

    public FileHandle openReadOnly(Path path) {
        Intrinsics.checkNotNullParameter((Object)path, (String)"file");
        return (FileHandle)new JvmFileHandle(false, new RandomAccessFile(path.toFile(), "r"));
    }

    public FileHandle openReadWrite(Path path, boolean bl, boolean bl2) {
        Intrinsics.checkNotNullParameter((Object)path, (String)"file");
        boolean bl3 = !bl || !bl2;
        if (!bl3) throw (Throwable)new IllegalArgumentException("Cannot require mustCreate and mustExist at the same time.".toString());
        if (bl) {
            this.requireCreate(path);
        }
        if (!bl2) return (FileHandle)new JvmFileHandle(true, new RandomAccessFile(path.toFile(), "rw"));
        this.requireExist(path);
        return (FileHandle)new JvmFileHandle(true, new RandomAccessFile(path.toFile(), "rw"));
    }

    public Sink sink(Path path, boolean bl) {
        Intrinsics.checkNotNullParameter((Object)path, (String)"file");
        if (!bl) return Okio.sink$default((File)path.toFile(), (boolean)false, (int)1, null);
        this.requireCreate(path);
        return Okio.sink$default((File)path.toFile(), (boolean)false, (int)1, null);
    }

    public Source source(Path path) {
        Intrinsics.checkNotNullParameter((Object)path, (String)"file");
        return Okio.source((File)path.toFile());
    }

    public String toString() {
        return "JvmSystemFileSystem";
    }
}
