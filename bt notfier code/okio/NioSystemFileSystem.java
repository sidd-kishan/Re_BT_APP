/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  okio.FileMetadata
 *  okio.JvmSystemFileSystem
 *  okio.Path
 *  okio.Path$Companion
 */
package okio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileSystemException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.NoSuchFileException;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.FileTime;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.FileMetadata;
import okio.JvmSystemFileSystem;
import okio.Path;

@Metadata(d1={"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0012\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\u0006H\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f*\u00020\u0010H\u0002\u00a2\u0006\u0002\u0010\u0011\u00a8\u0006\u0012"}, d2={"Lokio/NioSystemFileSystem;", "Lokio/JvmSystemFileSystem;", "()V", "atomicMove", "", "source", "Lokio/Path;", "target", "createSymlink", "metadataOrNull", "Lokio/FileMetadata;", "path", "toString", "", "zeroToNull", "", "Ljava/nio/file/attribute/FileTime;", "(Ljava/nio/file/attribute/FileTime;)Ljava/lang/Long;", "okio"}, k=1, mv={1, 5, 1}, xi=48)
public final class NioSystemFileSystem
extends JvmSystemFileSystem {
    private final Long zeroToNull(FileTime comparable) {
        boolean bl = ((Number)((Object)(comparable = Long.valueOf(comparable.toMillis())))).longValue() != 0L;
        if (bl) return comparable;
        comparable = null;
        return comparable;
    }

    public void atomicMove(Path path, Path path2) {
        Intrinsics.checkNotNullParameter((Object)path, (String)"source");
        Intrinsics.checkNotNullParameter((Object)path2, (String)"target");
        try {
            Files.move(path.toNioPath(), path2.toNioPath(), StandardCopyOption.ATOMIC_MOVE, StandardCopyOption.REPLACE_EXISTING);
            return;
        }
        catch (UnsupportedOperationException unsupportedOperationException) {
            throw new IOException("atomic move not supported");
        }
        catch (NoSuchFileException noSuchFileException) {
            throw new FileNotFoundException(noSuchFileException.getMessage());
        }
    }

    public void createSymlink(Path path, Path path2) {
        Intrinsics.checkNotNullParameter((Object)path, (String)"source");
        Intrinsics.checkNotNullParameter((Object)path2, (String)"target");
        Files.createSymbolicLink(path.toNioPath(), path2.toNioPath(), new FileAttribute[0]);
    }

    public FileMetadata metadataOrNull(Path object) {
        Object object2;
        Long l;
        block3: {
            block2: {
                Intrinsics.checkNotNullParameter((Object)object, (String)"path");
                object = object.toNioPath();
                l = null;
                try {
                    object2 = Files.readAttributes((java.nio.file.Path)object, BasicFileAttributes.class, LinkOption.NOFOLLOW_LINKS);
                    if (!object2.isSymbolicLink()) break block2;
                }
                catch (FileSystemException | NoSuchFileException fileSystemException) {
                    return null;
                }
                object = Files.readSymbolicLink((java.nio.file.Path)object);
                break block3;
            }
            object = null;
        }
        boolean bl = object2.isRegularFile();
        boolean bl2 = object2.isDirectory();
        object = object == null ? null : Path.Companion.get$default((Path.Companion)Path.Companion, (java.nio.file.Path)object, (boolean)false, (int)1, null);
        long l2 = object2.size();
        Comparable<FileTime> comparable = object2.creationTime();
        comparable = comparable == null ? null : this.zeroToNull((FileTime)comparable);
        Comparable<FileTime> comparable2 = object2.lastModifiedTime();
        comparable2 = comparable2 == null ? null : this.zeroToNull((FileTime)comparable2);
        object2 = object2.lastAccessTime();
        if (object2 == null) return new FileMetadata(bl, bl2, object, Long.valueOf(l2), (Long)comparable, (Long)comparable2, l, null, 128, null);
        l = this.zeroToNull((FileTime)object2);
        return new FileMetadata(bl, bl2, object, Long.valueOf(l2), (Long)comparable, (Long)comparable2, l, null, 128, null);
    }

    public String toString() {
        return "NioSystemFileSystem";
    }
}
