/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.ExceptionsKt
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.sequences.Sequence
 *  okio.BufferedSink
 *  okio.BufferedSource
 *  okio.FileHandle
 *  okio.FileMetadata
 *  okio.FileSystem$Companion
 *  okio.JvmSystemFileSystem
 *  okio.NioSystemFileSystem
 *  okio.Okio
 *  okio.Path
 *  okio.Path$Companion
 *  okio.Sink
 *  okio.Source
 *  okio.internal.ResourceFileSystem
 *  okio.internal._FileSystemKt
 */
package okio;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.FileHandle;
import okio.FileMetadata;
import okio.FileSystem;
import okio.JvmSystemFileSystem;
import okio.NioSystemFileSystem;
import okio.Okio;
import okio.Path;
import okio.Sink;
import okio.Source;
import okio.internal.ResourceFileSystem;
import okio.internal._FileSystemKt;

@Metadata(d1={"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000 42\u00020\u0001:\u00014B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bH&J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006H&J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006H&J\u0018\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006H\u0016J\u000e\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0006J\u0018\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00062\b\b\u0002\u0010\u0012\u001a\u00020\bJ\u000e\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0006J\u001a\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00062\b\b\u0002\u0010\u0012\u001a\u00020\bH&J\u0018\u0010\u0014\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006H&J\u000e\u0010\u0015\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u0006J\u001a\u0010\u0015\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bH&J\u000e\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u0006J\u001a\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0016J\u000e\u0010\u0018\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u0006J\u0016\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00060\u001a2\u0006\u0010\u0011\u001a\u00020\u0006H&J\u0018\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u001a2\u0006\u0010\u0011\u001a\u00020\u0006H&J\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00060\u001d2\u0006\u0010\u0011\u001a\u00020\u0006J \u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00060\u001d2\u0006\u0010\u0011\u001a\u00020\u00062\b\b\u0002\u0010\u001e\u001a\u00020\bH\u0016J\u000e\u0010\u001f\u001a\u00020 2\u0006\u0010\u000e\u001a\u00020\u0006J\u0012\u0010!\u001a\u0004\u0018\u00010 2\u0006\u0010\u000e\u001a\u00020\u0006H&J\u0010\u0010\"\u001a\u00020#2\u0006\u0010\u0005\u001a\u00020\u0006H&J\u000e\u0010$\u001a\u00020#2\u0006\u0010\u0005\u001a\u00020\u0006J$\u0010$\u001a\u00020#2\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0012\u001a\u00020\b2\b\b\u0002\u0010\u0007\u001a\u00020\bH&J:\u0010%\u001a\u0002H&\"\u0004\b\u0000\u0010&2\u0006\u0010\u0005\u001a\u00020\u00062\u0017\u0010'\u001a\u0013\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u0002H&0(\u00a2\u0006\u0002\b*H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b+\u0010,J\u000e\u0010-\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u001a\u0010-\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0012\u001a\u00020\bH&J\u0010\u0010\u000b\u001a\u00020.2\u0006\u0010\u0005\u001a\u00020\u0006H&JD\u0010/\u001a\u0002H&\"\u0004\b\u0000\u0010&2\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0012\u001a\u00020\b2\u0017\u00100\u001a\u0013\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u0002H&0(\u00a2\u0006\u0002\b*H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b2\u00103\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u00065"}, d2={"Lokio/FileSystem;", "", "()V", "appendingSink", "Lokio/Sink;", "file", "Lokio/Path;", "mustExist", "", "atomicMove", "", "source", "target", "canonicalize", "path", "copy", "createDirectories", "dir", "mustCreate", "createDirectory", "createSymlink", "delete", "deleteRecursively", "fileOrDirectory", "exists", "list", "", "listOrNull", "listRecursively", "Lkotlin/sequences/Sequence;", "followSymlinks", "metadata", "Lokio/FileMetadata;", "metadataOrNull", "openReadOnly", "Lokio/FileHandle;", "openReadWrite", "read", "T", "readerAction", "Lkotlin/Function1;", "Lokio/BufferedSource;", "Lkotlin/ExtensionFunctionType;", "-read", "(Lokio/Path;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "sink", "Lokio/Source;", "write", "writerAction", "Lokio/BufferedSink;", "-write", "(Lokio/Path;ZLkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Companion", "okio"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class FileSystem {
    public static final Companion Companion;
    public static final FileSystem RESOURCES;
    public static final FileSystem SYSTEM;
    public static final Path SYSTEM_TEMPORARY_DIRECTORY;

    public static /* synthetic */ Object _write$default(FileSystem object, Path object2, boolean bl, Function1 function1, int n, Object object3) throws IOException {
        if (object3 != null) throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: write");
        if ((n & 2) != 0) {
            bl = false;
        }
        Intrinsics.checkNotNullParameter((Object)object2, (String)"file");
        Intrinsics.checkNotNullParameter((Object)function1, (String)"writerAction");
        object3 = (Closeable)Okio.buffer((Sink)((FileSystem)object).sink((Path)object2, bl));
        object = null;
        try {
            object2 = function1.invoke((Object)((BufferedSink)object3));
        }
        catch (Throwable throwable) {
            object2 = null;
        }
        if (object3 != null) {
            try {
                object3.close();
            }
            catch (Throwable throwable) {
                if (object == null) {
                    object = throwable;
                }
                ExceptionsKt.addSuppressed((Throwable)object, (Throwable)throwable);
            }
        }
        if (object != null) throw object;
        Intrinsics.checkNotNull((Object)object2);
        return object2;
    }

    static {
        Object object;
        Companion = new Companion(null);
        try {
            Class.forName("java.nio.file.Files");
            object = new NioSystemFileSystem();
            object = (JvmSystemFileSystem)object;
        }
        catch (ClassNotFoundException classNotFoundException) {
            object = new JvmSystemFileSystem();
        }
        SYSTEM = (FileSystem)object;
        Path.Companion companion = Path.Companion;
        object = System.getProperty("java.io.tmpdir");
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"getProperty(\"java.io.tmpdir\")");
        SYSTEM_TEMPORARY_DIRECTORY = Path.Companion.get$default((Path.Companion)companion, (String)object, (boolean)false, (int)1, null);
        object = ResourceFileSystem.class.getClassLoader();
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"ResourceFileSystem::class.java.classLoader");
        RESOURCES = (FileSystem)new ResourceFileSystem((ClassLoader)object, false);
    }

    public static /* synthetic */ Sink appendingSink$default(FileSystem fileSystem, Path path, boolean bl, int n, Object object) throws IOException {
        if (object != null) throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: appendingSink");
        if ((n & 2) == 0) return fileSystem.appendingSink(path, bl);
        bl = false;
        return fileSystem.appendingSink(path, bl);
    }

    public static /* synthetic */ void createDirectories$default(FileSystem fileSystem, Path path, boolean bl, int n, Object object) throws IOException {
        if (object != null) throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createDirectories");
        if ((n & 2) != 0) {
            bl = false;
        }
        fileSystem.createDirectories(path, bl);
    }

    public static /* synthetic */ void createDirectory$default(FileSystem fileSystem, Path path, boolean bl, int n, Object object) throws IOException {
        if (object != null) throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createDirectory");
        if ((n & 2) != 0) {
            bl = false;
        }
        fileSystem.createDirectory(path, bl);
    }

    public static /* synthetic */ void delete$default(FileSystem fileSystem, Path path, boolean bl, int n, Object object) throws IOException {
        if (object != null) throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: delete");
        if ((n & 2) != 0) {
            bl = false;
        }
        fileSystem.delete(path, bl);
    }

    public static /* synthetic */ void deleteRecursively$default(FileSystem fileSystem, Path path, boolean bl, int n, Object object) throws IOException {
        if (object != null) throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: deleteRecursively");
        if ((n & 2) != 0) {
            bl = false;
        }
        fileSystem.deleteRecursively(path, bl);
    }

    public static /* synthetic */ Sequence listRecursively$default(FileSystem fileSystem, Path path, boolean bl, int n, Object object) {
        if (object != null) throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: listRecursively");
        if ((n & 2) == 0) return fileSystem.listRecursively(path, bl);
        bl = false;
        return fileSystem.listRecursively(path, bl);
    }

    public static /* synthetic */ FileHandle openReadWrite$default(FileSystem fileSystem, Path path, boolean bl, boolean bl2, int n, Object object) throws IOException {
        if (object != null) throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: openReadWrite");
        if ((n & 2) != 0) {
            bl = false;
        }
        if ((n & 4) == 0) return fileSystem.openReadWrite(path, bl, bl2);
        bl2 = false;
        return fileSystem.openReadWrite(path, bl, bl2);
    }

    public static /* synthetic */ Sink sink$default(FileSystem fileSystem, Path path, boolean bl, int n, Object object) throws IOException {
        if (object != null) throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sink");
        if ((n & 2) == 0) return fileSystem.sink(path, bl);
        bl = false;
        return fileSystem.sink(path, bl);
    }

    public final <T> T _read(Path object, Function1<? super BufferedSource, ? extends T> object2) throws IOException {
        Intrinsics.checkNotNullParameter((Object)object, (String)"file");
        Intrinsics.checkNotNullParameter(object2, (String)"readerAction");
        Closeable closeable = (Closeable)Okio.buffer((Source)this.source((Path)object));
        object = null;
        try {
            object2 = object2.invoke((Object)((BufferedSource)closeable));
        }
        catch (Throwable throwable) {
            object2 = null;
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
        Intrinsics.checkNotNull(object2);
        return (T)object2;
    }

    public final <T> T _write(Path object, boolean bl, Function1<? super BufferedSink, ? extends T> object2) throws IOException {
        Intrinsics.checkNotNullParameter((Object)object, (String)"file");
        Intrinsics.checkNotNullParameter(object2, (String)"writerAction");
        Closeable closeable = (Closeable)Okio.buffer((Sink)this.sink((Path)object, bl));
        object = null;
        try {
            object2 = object2.invoke((Object)((BufferedSink)closeable));
        }
        catch (Throwable throwable) {
            object2 = null;
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
        Intrinsics.checkNotNull(object2);
        return (T)object2;
    }

    public final Sink appendingSink(Path path) throws IOException {
        Intrinsics.checkNotNullParameter((Object)path, (String)"file");
        return this.appendingSink(path, false);
    }

    public abstract Sink appendingSink(Path var1, boolean var2) throws IOException;

    public abstract void atomicMove(Path var1, Path var2) throws IOException;

    public abstract Path canonicalize(Path var1) throws IOException;

    public void copy(Path path, Path path2) throws IOException {
        Intrinsics.checkNotNullParameter((Object)path, (String)"source");
        Intrinsics.checkNotNullParameter((Object)path2, (String)"target");
        _FileSystemKt.commonCopy((FileSystem)this, (Path)path, (Path)path2);
    }

    public final void createDirectories(Path path) throws IOException {
        Intrinsics.checkNotNullParameter((Object)path, (String)"dir");
        this.createDirectories(path, false);
    }

    public final void createDirectories(Path path, boolean bl) throws IOException {
        Intrinsics.checkNotNullParameter((Object)path, (String)"dir");
        _FileSystemKt.commonCreateDirectories((FileSystem)this, (Path)path, (boolean)bl);
    }

    public final void createDirectory(Path path) throws IOException {
        Intrinsics.checkNotNullParameter((Object)path, (String)"dir");
        this.createDirectory(path, false);
    }

    public abstract void createDirectory(Path var1, boolean var2) throws IOException;

    public abstract void createSymlink(Path var1, Path var2) throws IOException;

    public final void delete(Path path) throws IOException {
        Intrinsics.checkNotNullParameter((Object)path, (String)"path");
        this.delete(path, false);
    }

    public abstract void delete(Path var1, boolean var2) throws IOException;

    public final void deleteRecursively(Path path) throws IOException {
        Intrinsics.checkNotNullParameter((Object)path, (String)"fileOrDirectory");
        this.deleteRecursively(path, false);
    }

    public void deleteRecursively(Path path, boolean bl) throws IOException {
        Intrinsics.checkNotNullParameter((Object)path, (String)"fileOrDirectory");
        _FileSystemKt.commonDeleteRecursively((FileSystem)this, (Path)path, (boolean)bl);
    }

    public final boolean exists(Path path) throws IOException {
        Intrinsics.checkNotNullParameter((Object)path, (String)"path");
        return _FileSystemKt.commonExists((FileSystem)this, (Path)path);
    }

    public abstract List<Path> list(Path var1) throws IOException;

    public abstract List<Path> listOrNull(Path var1);

    public final Sequence<Path> listRecursively(Path path) {
        Intrinsics.checkNotNullParameter((Object)path, (String)"dir");
        return this.listRecursively(path, false);
    }

    public Sequence<Path> listRecursively(Path path, boolean bl) {
        Intrinsics.checkNotNullParameter((Object)path, (String)"dir");
        return _FileSystemKt.commonListRecursively((FileSystem)this, (Path)path, (boolean)bl);
    }

    public final FileMetadata metadata(Path path) throws IOException {
        Intrinsics.checkNotNullParameter((Object)path, (String)"path");
        return _FileSystemKt.commonMetadata((FileSystem)this, (Path)path);
    }

    public abstract FileMetadata metadataOrNull(Path var1) throws IOException;

    public abstract FileHandle openReadOnly(Path var1) throws IOException;

    public final FileHandle openReadWrite(Path path) throws IOException {
        Intrinsics.checkNotNullParameter((Object)path, (String)"file");
        return this.openReadWrite(path, false, false);
    }

    public abstract FileHandle openReadWrite(Path var1, boolean var2, boolean var3) throws IOException;

    public final Sink sink(Path path) throws IOException {
        Intrinsics.checkNotNullParameter((Object)path, (String)"file");
        return this.sink(path, false);
    }

    public abstract Sink sink(Path var1, boolean var2) throws IOException;

    public abstract Source source(Path var1) throws IOException;
}
