/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.ExceptionsKt
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.collections.ArrayDeque
 *  kotlin.coroutines.Continuation
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.sequences.Sequence
 *  kotlin.sequences.SequenceScope
 *  kotlin.sequences.SequencesKt
 *  okio.BufferedSink
 *  okio.FileMetadata
 *  okio.FileSystem
 *  okio.Okio
 *  okio.Path
 *  okio.Sink
 *  okio.Source
 */
package okio.internal;

import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequenceScope;
import kotlin.sequences.SequencesKt;
import okio.BufferedSink;
import okio.FileMetadata;
import okio.FileSystem;
import okio.Okio;
import okio.Path;
import okio.Sink;
import okio.Source;

@Metadata(d1={"\u00004\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aI\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00072\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0080@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\f\u001a\u001c\u0010\r\u001a\u00020\u0001*\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0003H\u0000\u001a\u001c\u0010\u0010\u001a\u00020\u0001*\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\nH\u0000\u001a\u001c\u0010\u0013\u001a\u00020\u0001*\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\nH\u0000\u001a\u0014\u0010\u0016\u001a\u00020\n*\u00020\u00052\u0006\u0010\b\u001a\u00020\u0003H\u0000\u001a\"\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\u0018*\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0000\u001a\u0014\u0010\u0019\u001a\u00020\u001a*\u00020\u00052\u0006\u0010\b\u001a\u00020\u0003H\u0000\u001a\u0016\u0010\u001b\u001a\u0004\u0018\u00010\u0003*\u00020\u00052\u0006\u0010\b\u001a\u00020\u0003H\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001c"}, d2={"collectRecursively", "", "Lkotlin/sequences/SequenceScope;", "Lokio/Path;", "fileSystem", "Lokio/FileSystem;", "stack", "Lkotlin/collections/ArrayDeque;", "path", "followSymlinks", "", "postorder", "(Lkotlin/sequences/SequenceScope;Lokio/FileSystem;Lkotlin/collections/ArrayDeque;Lokio/Path;ZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "commonCopy", "source", "target", "commonCreateDirectories", "dir", "mustCreate", "commonDeleteRecursively", "fileOrDirectory", "mustExist", "commonExists", "commonListRecursively", "Lkotlin/sequences/Sequence;", "commonMetadata", "Lokio/FileMetadata;", "symlinkTarget", "okio"}, k=2, mv={1, 5, 1}, xi=48)
public final class _FileSystemKt {
    /*
     * Exception decompiling
     */
    public static final Object collectRecursively(SequenceScope<? super Path> var0, FileSystem var1_2, ArrayDeque<Path> var2_4, Path var3_5, boolean var4_6, boolean var5_7, Continuation<? super Unit> var6_8) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 2[TRYBLOCK] [2 : 488->613)] java.lang.Throwable
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs.insertExceptionBlocks(Op02WithProcessedDataAndRefs.java:2283)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:415)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
         *     at org.benf.cfr.reader.Driver.doClass(Driver.java:84)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:78)
         *     at the.bytecode.club.bytecodeviewer.decompilers.impl.CFRDecompiler.decompile(CFRDecompiler.java:91)
         *     at the.bytecode.club.bytecodeviewer.decompilers.impl.CFRDecompiler.decompileToZip(CFRDecompiler.java:122)
         *     at the.bytecode.club.bytecodeviewer.resources.ResourceDecompiling.decompileSaveAll(ResourceDecompiling.java:262)
         *     at the.bytecode.club.bytecodeviewer.resources.ResourceDecompiling.lambda$decompileSaveAll$0(ResourceDecompiling.java:127)
         *     at java.lang.Thread.run(Unknown Source)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public static final void commonCopy(FileSystem var0, Path var1_3, Path var2_4) throws IOException {
        block11: {
            Intrinsics.checkNotNullParameter((Object)var0 /* !! */ , (String)"<this>");
            Intrinsics.checkNotNullParameter((Object)var1_3 /* !! */ , (String)"source");
            Intrinsics.checkNotNullParameter((Object)var2_4, (String)"target");
            var6_7 = (Closeable)var0 /* !! */ .source(var1_3 /* !! */ );
            var5_8 = null;
            var1_3 /* !! */  = (Source)var6_7;
            var2_4 = (Closeable)Okio.buffer((Sink)var0 /* !! */ .sink((Path)var2_4));
            {
                block12: {
                    catch (Throwable var0_2) {
                        var1_3 /* !! */  = null;
                        break block11;
                    }
                    try {
                        var3_9 = ((BufferedSink)var2_4).writeAll((Source)var1_3 /* !! */ );
                    }
                    catch (Throwable var0_1) {
                        var1_3 /* !! */  = null;
                        break block12;
                    }
                    var1_3 /* !! */  = Long.valueOf(var3_9);
                    var0 /* !! */  = null;
                }
                if (var2_4 == null) ** GOTO lbl31
                try {
                    var2_4.close();
                    ** GOTO lbl31
                }
                catch (Throwable var2_5) {}
                if (var0 /* !! */  != null) ** GOTO lbl-1000
                var0 /* !! */  = var2_5;
                ** GOTO lbl31
lbl-1000:
                // 1 sources

                {
                    ExceptionsKt.addSuppressed((Throwable)var0 /* !! */ , (Throwable)var2_5);
lbl31:
                    // 4 sources

                    if (var0 /* !! */  != null) throw var0 /* !! */ ;
                    Intrinsics.checkNotNull((Object)var1_3 /* !! */ );
                    var1_3 /* !! */  = Long.valueOf(((Number)var1_3 /* !! */ ).longValue());
                    var0 /* !! */  = var5_8;
                }
            }
        }
        if (var6_7 != null) {
            try {
                var6_7.close();
            }
            catch (Throwable var2_6) {
                if (var0 /* !! */  == null) {
                    var0 /* !! */  = var2_6;
                }
                ExceptionsKt.addSuppressed((Throwable)var0 /* !! */ , (Throwable)var2_6);
            }
        }
        if (var0 /* !! */  != null) throw var0 /* !! */ ;
        Intrinsics.checkNotNull((Object)var1_3 /* !! */ );
    }

    public static final void commonCreateDirectories(FileSystem object, Path object2, boolean bl) throws IOException {
        Intrinsics.checkNotNullParameter((Object)object, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)object2, (String)"dir");
        ArrayDeque arrayDeque = new ArrayDeque();
        for (Path path = object2; path != null && !object.exists(path); path = path.parent()) {
            arrayDeque.addFirst((Object)path);
        }
        if (bl && arrayDeque.isEmpty()) {
            object = new StringBuilder();
            ((StringBuilder)object).append(object2);
            ((StringBuilder)object).append(" already exist.");
            throw new IOException(((StringBuilder)object).toString());
        }
        object2 = arrayDeque.iterator();
        while (object2.hasNext()) {
            object.createDirectory((Path)object2.next());
        }
    }

    public static final void commonDeleteRecursively(FileSystem fileSystem, Path object, boolean bl) throws IOException {
        Intrinsics.checkNotNullParameter((Object)fileSystem, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)object, (String)"fileOrDirectory");
        object = SequencesKt.sequence((Function2)((Function2)new /* Unavailable Anonymous Inner Class!! */)).iterator();
        while (object.hasNext()) {
            Path path = (Path)object.next();
            boolean bl2 = bl && !object.hasNext();
            fileSystem.delete(path, bl2);
        }
    }

    public static final boolean commonExists(FileSystem fileSystem, Path path) throws IOException {
        Intrinsics.checkNotNullParameter((Object)fileSystem, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)path, (String)"path");
        boolean bl = fileSystem.metadataOrNull(path) != null;
        return bl;
    }

    public static final Sequence<Path> commonListRecursively(FileSystem fileSystem, Path path, boolean bl) throws IOException {
        Intrinsics.checkNotNullParameter((Object)fileSystem, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)path, (String)"dir");
        return SequencesKt.sequence((Function2)((Function2)new /* Unavailable Anonymous Inner Class!! */));
    }

    public static final FileMetadata commonMetadata(FileSystem fileSystem, Path path) throws IOException {
        Intrinsics.checkNotNullParameter((Object)fileSystem, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)path, (String)"path");
        fileSystem = fileSystem.metadataOrNull(path);
        if (fileSystem == null) throw new FileNotFoundException(Intrinsics.stringPlus((String)"no such file: ", (Object)path));
        return fileSystem;
    }

    public static final Path symlinkTarget(FileSystem fileSystem, Path path) throws IOException {
        Intrinsics.checkNotNullParameter((Object)fileSystem, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)path, (String)"path");
        fileSystem = fileSystem.metadata(path).getSymlinkTarget();
        if (fileSystem == null) {
            return null;
        }
        path = path.parent();
        Intrinsics.checkNotNull((Object)path);
        return path.resolve((Path)fileSystem);
    }
}
