/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.ExceptionsKt
 *  kotlin.Metadata
 *  kotlin.collections.CollectionsKt
 *  kotlin.jvm.internal.Intrinsics
 *  okio.BufferedSource
 *  okio.FileHandle
 *  okio.FileMetadata
 *  okio.FileSystem
 *  okio.InflaterSource
 *  okio.Okio
 *  okio.Path
 *  okio.Path$Companion
 *  okio.Sink
 *  okio.Source
 *  okio.ZipFileSystem$Companion
 *  okio.internal.FixedLengthSource
 *  okio.internal.ZipEntry
 *  okio.internal.ZipKt
 */
package okio;

import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.zip.Inflater;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import okio.BufferedSource;
import okio.FileHandle;
import okio.FileMetadata;
import okio.FileSystem;
import okio.InflaterSource;
import okio.Okio;
import okio.Path;
import okio.Sink;
import okio.Source;
import okio.ZipFileSystem;
import okio.internal.FixedLengthSource;
import okio.internal.ZipEntry;
import okio.internal.ZipKt;

@Metadata(d1={"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 '2\u00020\u0001:\u0001'B5\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0001\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0002\u0010\nJ\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0003H\u0016J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0003H\u0016J\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0003H\u0002J\u0018\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u000fH\u0016J\u0018\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0003H\u0016J\u0018\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0016\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00030\u001d2\u0006\u0010\u0018\u001a\u00020\u0003H\u0016J \u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001d2\u0006\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u000fH\u0002J\u0018\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001d2\u0006\u0010\u0018\u001a\u00020\u0003H\u0016J\u0012\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\u0015\u001a\u00020\u0003H\u0016J\u0010\u0010\"\u001a\u00020#2\u0006\u0010\r\u001a\u00020\u0003H\u0016J \u0010$\u001a\u00020#2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010%\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u000fH\u0016J\u0010\u0010\u0012\u001a\u00020&2\u0006\u0010\u0015\u001a\u00020\u0003H\u0016R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006("}, d2={"Lokio/ZipFileSystem;", "Lokio/FileSystem;", "zipPath", "Lokio/Path;", "fileSystem", "entries", "", "Lokio/internal/ZipEntry;", "comment", "", "(Lokio/Path;Lokio/FileSystem;Ljava/util/Map;Ljava/lang/String;)V", "appendingSink", "Lokio/Sink;", "file", "mustExist", "", "atomicMove", "", "source", "target", "canonicalize", "path", "canonicalizeInternal", "createDirectory", "dir", "mustCreate", "createSymlink", "delete", "list", "", "throwOnFailure", "listOrNull", "metadataOrNull", "Lokio/FileMetadata;", "openReadOnly", "Lokio/FileHandle;", "openReadWrite", "sink", "Lokio/Source;", "Companion", "okio"}, k=1, mv={1, 5, 1}, xi=48)
public final class ZipFileSystem
extends FileSystem {
    private static final Companion Companion = new Companion(null);
    @Deprecated
    private static final Path ROOT = Path.Companion.get$default((Path.Companion)Path.Companion, (String)"/", (boolean)false, (int)1, null);
    private final String comment;
    private final Map<Path, ZipEntry> entries;
    private final FileSystem fileSystem;
    private final Path zipPath;

    public ZipFileSystem(Path path, FileSystem fileSystem, Map<Path, ZipEntry> map, String string) {
        Intrinsics.checkNotNullParameter((Object)path, (String)"zipPath");
        Intrinsics.checkNotNullParameter((Object)fileSystem, (String)"fileSystem");
        Intrinsics.checkNotNullParameter(map, (String)"entries");
        this.zipPath = path;
        this.fileSystem = fileSystem;
        this.entries = map;
        this.comment = string;
    }

    public static final /* synthetic */ Path access$getROOT$cp() {
        return ROOT;
    }

    private final Path canonicalizeInternal(Path path) {
        return ROOT.resolve(path, true);
    }

    private final List<Path> list(Path path, boolean bl) {
        Path path2 = this.canonicalizeInternal(path);
        if ((path2 = this.entries.get(path2)) != null) return CollectionsKt.toList((Iterable)path2.getChildren());
        if (bl) throw new IOException(Intrinsics.stringPlus((String)"not a directory: ", (Object)path));
        return null;
    }

    public Sink appendingSink(Path path, boolean bl) {
        Intrinsics.checkNotNullParameter((Object)path, (String)"file");
        throw new IOException("zip file systems are read-only");
    }

    public void atomicMove(Path path, Path path2) {
        Intrinsics.checkNotNullParameter((Object)path, (String)"source");
        Intrinsics.checkNotNullParameter((Object)path2, (String)"target");
        throw new IOException("zip file systems are read-only");
    }

    public Path canonicalize(Path path) {
        Intrinsics.checkNotNullParameter((Object)path, (String)"path");
        return this.canonicalizeInternal(path);
    }

    public void createDirectory(Path path, boolean bl) {
        Intrinsics.checkNotNullParameter((Object)path, (String)"dir");
        throw new IOException("zip file systems are read-only");
    }

    public void createSymlink(Path path, Path path2) {
        Intrinsics.checkNotNullParameter((Object)path, (String)"source");
        Intrinsics.checkNotNullParameter((Object)path2, (String)"target");
        throw new IOException("zip file systems are read-only");
    }

    public void delete(Path path, boolean bl) {
        Intrinsics.checkNotNullParameter((Object)path, (String)"path");
        throw new IOException("zip file systems are read-only");
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
        object = this.canonicalizeInternal((Path)object);
        ZipEntry zipEntry = this.entries.get(object);
        ZipEntry zipEntry2 = null;
        if (zipEntry == null) {
            return null;
        }
        boolean bl = zipEntry.isDirectory();
        boolean bl2 = zipEntry.isDirectory();
        object = zipEntry.isDirectory() ? null : Long.valueOf(zipEntry.getSize());
        FileMetadata fileMetadata = new FileMetadata(bl ^ true, bl2, null, (Long)object, null, zipEntry.getLastModifiedAtMillis(), null, null, 128, null);
        if (zipEntry.getOffset() == -1L) {
            return fileMetadata;
        }
        Closeable closeable = (Closeable)this.fileSystem.openReadOnly(this.zipPath);
        try {
            zipEntry = Okio.buffer((Source)((FileHandle)closeable).source(zipEntry.getOffset()));
            object = zipEntry2;
            zipEntry2 = zipEntry;
        }
        catch (Throwable throwable) {
            zipEntry2 = null;
        }
        if (closeable != null) {
            try {
                closeable.close();
            }
            catch (Throwable throwable) {
                if (object == null) {
                    object = throwable;
                }
                ExceptionsKt.addSuppressed((Throwable)object, (Throwable)throwable);
            }
        }
        if (object != null) throw object;
        Intrinsics.checkNotNull((Object)zipEntry2);
        return ZipKt.readLocalHeader((BufferedSource)zipEntry2, (FileMetadata)fileMetadata);
    }

    public FileHandle openReadOnly(Path path) {
        Intrinsics.checkNotNullParameter((Object)path, (String)"file");
        throw new UnsupportedOperationException("not implemented yet!");
    }

    public FileHandle openReadWrite(Path path, boolean bl, boolean bl2) {
        Intrinsics.checkNotNullParameter((Object)path, (String)"file");
        throw new IOException("zip entries are not writable");
    }

    public Sink sink(Path path, boolean bl) {
        Intrinsics.checkNotNullParameter((Object)path, (String)"file");
        throw new IOException("zip file systems are read-only");
    }

    public Source source(Path object) throws IOException {
        Intrinsics.checkNotNullParameter((Object)object, (String)"path");
        Path path = this.canonicalizeInternal((Path)object);
        ZipEntry zipEntry = this.entries.get(path);
        if (zipEntry == null) throw new FileNotFoundException(Intrinsics.stringPlus((String)"no such file: ", (Object)object));
        Closeable closeable = (Closeable)this.fileSystem.openReadOnly(this.zipPath);
        object = null;
        try {
            path = Okio.buffer((Source)((FileHandle)closeable).source(zipEntry.getOffset()));
        }
        catch (Throwable throwable) {
            path = null;
        }
        if (closeable != null) {
            try {
                closeable.close();
            }
            catch (Throwable throwable) {
                if (object == null) {
                    object = throwable;
                }
                ExceptionsKt.addSuppressed((Throwable)object, (Throwable)throwable);
            }
        }
        if (object != null) throw object;
        Intrinsics.checkNotNull((Object)path);
        ZipKt.skipLocalHeader((BufferedSource)path);
        object = zipEntry.getCompressionMethod() == 0 ? (Source)new FixedLengthSource((Source)path, zipEntry.getSize(), true) : (Source)new FixedLengthSource((Source)new InflaterSource((Source)new FixedLengthSource((Source)path, zipEntry.getCompressedSize(), true), new Inflater(true)), zipEntry.getSize(), false);
        return object;
    }
}
