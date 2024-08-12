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
 *  kotlin.jvm.internal.Intrinsics
 */
package kotlin.io;

import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.AccessDeniedException;
import kotlin.io.FileTreeWalk;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/*
 * Exception performing whole class analysis ignored.
 */
@Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\n\u0010\r\u001a\u0004\u0018\u00010\u0003H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0018\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\u000bR\u000e\u0010\f\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2={"Lkotlin/io/FileTreeWalk$FileTreeWalkIterator$BottomUpDirectoryState;", "Lkotlin/io/FileTreeWalk$DirectoryState;", "rootDir", "Ljava/io/File;", "(Lkotlin/io/FileTreeWalk$FileTreeWalkIterator;Ljava/io/File;)V", "failed", "", "fileIndex", "", "fileList", "", "[Ljava/io/File;", "rootVisited", "step", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
private final class FileTreeWalk.FileTreeWalkIterator.BottomUpDirectoryState
extends FileTreeWalk.DirectoryState {
    private boolean failed;
    private int fileIndex;
    private File[] fileList;
    private boolean rootVisited;
    final FileTreeWalk.FileTreeWalkIterator this$0;

    public FileTreeWalk.FileTreeWalkIterator.BottomUpDirectoryState(FileTreeWalk.FileTreeWalkIterator fileTreeWalkIterator, File file) {
        Intrinsics.checkNotNullParameter((Object)file, (String)"rootDir");
        this.this$0 = fileTreeWalkIterator;
        super(file);
    }

    public File step() {
        Unit unit;
        if (!this.failed && this.fileList == null) {
            unit = FileTreeWalk.access$getOnEnter$p((FileTreeWalk)this.this$0.this$0);
            if (unit != null && !((Boolean)unit.invoke((Object)this.getRoot())).booleanValue()) {
                return null;
            }
            unit = this.getRoot().listFiles();
            this.fileList = unit;
            if (unit == null) {
                unit = FileTreeWalk.access$getOnFail$p((FileTreeWalk)this.this$0.this$0);
                if (unit != null) {
                    unit = (Unit)unit.invoke((Object)this.getRoot(), (Object)new AccessDeniedException(this.getRoot(), null, "Cannot list files in a directory", 2, null));
                }
                this.failed = true;
            }
        }
        if ((unit = this.fileList) != null) {
            int n = this.fileIndex;
            Intrinsics.checkNotNull((Object)unit);
            if (n < ((Function1)unit).length) {
                unit = this.fileList;
                Intrinsics.checkNotNull((Object)unit);
                n = this.fileIndex;
                this.fileIndex = n + 1;
                return unit[n];
            }
        }
        if (!this.rootVisited) {
            this.rootVisited = true;
            return this.getRoot();
        }
        unit = FileTreeWalk.access$getOnLeave$p((FileTreeWalk)this.this$0.this$0);
        if (unit == null) return null;
        unit = (Unit)unit.invoke((Object)this.getRoot());
        return null;
    }
}
