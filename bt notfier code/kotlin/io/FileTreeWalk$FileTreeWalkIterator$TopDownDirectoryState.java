/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.io.AccessDeniedException
 *  kotlin.io.FileTreeWalk
 *  kotlin.io.FileTreeWalk$DirectoryState
 *  kotlin.io.FileTreeWalk$FileTreeWalkIterator
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 */
package kotlin.io;

import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.AccessDeniedException;
import kotlin.io.FileTreeWalk;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/*
 * Exception performing whole class analysis ignored.
 */
@Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\n\u0010\f\u001a\u0004\u0018\u00010\u0003H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0018\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2={"Lkotlin/io/FileTreeWalk$FileTreeWalkIterator$TopDownDirectoryState;", "Lkotlin/io/FileTreeWalk$DirectoryState;", "rootDir", "Ljava/io/File;", "(Lkotlin/io/FileTreeWalk$FileTreeWalkIterator;Ljava/io/File;)V", "fileIndex", "", "fileList", "", "[Ljava/io/File;", "rootVisited", "", "step", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
private final class FileTreeWalk.FileTreeWalkIterator.TopDownDirectoryState
extends FileTreeWalk.DirectoryState {
    private int fileIndex;
    private File[] fileList;
    private boolean rootVisited;
    final FileTreeWalk.FileTreeWalkIterator this$0;

    public FileTreeWalk.FileTreeWalkIterator.TopDownDirectoryState(FileTreeWalk.FileTreeWalkIterator fileTreeWalkIterator, File file) {
        Intrinsics.checkNotNullParameter((Object)file, (String)"rootDir");
        this.this$0 = fileTreeWalkIterator;
        super(file);
    }

    public File step() {
        int n;
        Function2 function2;
        block8: {
            block9: {
                if (!this.rootVisited) {
                    Function1 function1 = FileTreeWalk.access$getOnEnter$p((FileTreeWalk)this.this$0.this$0);
                    if (function1 != null && !((Boolean)function1.invoke((Object)this.getRoot())).booleanValue()) {
                        return null;
                    }
                    this.rootVisited = true;
                    return this.getRoot();
                }
                function2 = this.fileList;
                if (function2 != null) {
                    n = this.fileIndex;
                    Intrinsics.checkNotNull((Object)function2);
                    if (n >= ((File[])function2).length) {
                        function2 = FileTreeWalk.access$getOnLeave$p((FileTreeWalk)this.this$0.this$0);
                        if (function2 == null) return null;
                        function2 = (Unit)function2.invoke((Object)this.getRoot());
                        return null;
                    }
                }
                if (this.fileList != null) break block8;
                function2 = this.getRoot().listFiles();
                this.fileList = function2;
                if (function2 == null && (function2 = FileTreeWalk.access$getOnFail$p((FileTreeWalk)this.this$0.this$0)) != null) {
                    function2 = (Unit)function2.invoke((Object)this.getRoot(), (Object)new AccessDeniedException(this.getRoot(), null, "Cannot list files in a directory", 2, null));
                }
                if ((function2 = this.fileList) == null) break block9;
                Intrinsics.checkNotNull((Object)function2);
                if (((Function2)function2).length != 0) break block8;
            }
            if ((function2 = FileTreeWalk.access$getOnLeave$p((FileTreeWalk)this.this$0.this$0)) == null) return null;
            function2 = (Unit)function2.invoke((Object)this.getRoot());
            return null;
        }
        function2 = this.fileList;
        Intrinsics.checkNotNull((Object)function2);
        n = this.fileIndex;
        this.fileIndex = n + 1;
        return function2[n];
    }
}
