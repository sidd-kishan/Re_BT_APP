/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.NoWhenBranchMatchedException
 *  kotlin.collections.AbstractIterator
 *  kotlin.io.FileTreeWalk
 *  kotlin.io.FileTreeWalk$DirectoryState
 *  kotlin.io.FileTreeWalk$FileTreeWalkIterator$BottomUpDirectoryState
 *  kotlin.io.FileTreeWalk$FileTreeWalkIterator$SingleFileState
 *  kotlin.io.FileTreeWalk$FileTreeWalkIterator$TopDownDirectoryState
 *  kotlin.io.FileTreeWalk$FileTreeWalkIterator$WhenMappings
 *  kotlin.io.FileTreeWalk$WalkState
 *  kotlin.io.FileWalkDirection
 *  kotlin.jvm.internal.Intrinsics
 */
package kotlin.io;

import java.io.File;
import java.util.ArrayDeque;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.AbstractIterator;
import kotlin.io.FileTreeWalk;
import kotlin.io.FileWalkDirection;
import kotlin.jvm.internal.Intrinsics;

/*
 * Exception performing whole class analysis ignored.
 */
@Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0082\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\r\u000e\u000fB\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0007\u001a\u00020\bH\u0014J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0002H\u0002J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0082\u0010R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2={"Lkotlin/io/FileTreeWalk$FileTreeWalkIterator;", "Lkotlin/collections/AbstractIterator;", "Ljava/io/File;", "(Lkotlin/io/FileTreeWalk;)V", "state", "Ljava/util/ArrayDeque;", "Lkotlin/io/FileTreeWalk$WalkState;", "computeNext", "", "directoryState", "Lkotlin/io/FileTreeWalk$DirectoryState;", "root", "gotoNext", "BottomUpDirectoryState", "SingleFileState", "TopDownDirectoryState", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
private final class FileTreeWalk.FileTreeWalkIterator
extends AbstractIterator<File> {
    private final ArrayDeque<FileTreeWalk.WalkState> state;
    final FileTreeWalk this$0;

    public FileTreeWalk.FileTreeWalkIterator(FileTreeWalk fileTreeWalk) {
        this.this$0 = fileTreeWalk;
        this.state = new ArrayDeque();
        if (FileTreeWalk.access$getStart$p((FileTreeWalk)fileTreeWalk).isDirectory()) {
            this.state.push((FileTreeWalk.WalkState)this.directoryState(FileTreeWalk.access$getStart$p((FileTreeWalk)fileTreeWalk)));
        } else if (FileTreeWalk.access$getStart$p((FileTreeWalk)fileTreeWalk).isFile()) {
            this.state.push((FileTreeWalk.WalkState)new SingleFileState(this, FileTreeWalk.access$getStart$p((FileTreeWalk)fileTreeWalk)));
        } else {
            this.done();
        }
    }

    private final FileTreeWalk.DirectoryState directoryState(File file) {
        FileWalkDirection fileWalkDirection = FileTreeWalk.access$getDirection$p((FileTreeWalk)this.this$0);
        int n = WhenMappings.$EnumSwitchMapping$0[fileWalkDirection.ordinal()];
        if (n != 1) {
            if (n != 2) throw new NoWhenBranchMatchedException();
            file = (FileTreeWalk.DirectoryState)new BottomUpDirectoryState(this, file);
        } else {
            file = (FileTreeWalk.DirectoryState)new TopDownDirectoryState(this, file);
        }
        return file;
    }

    private final File gotoNext() {
        FileTreeWalk.WalkState walkState;
        while ((walkState = this.state.peek()) != null) {
            File file = walkState.step();
            if (file == null) {
                this.state.pop();
                continue;
            }
            if (Intrinsics.areEqual((Object)file, (Object)walkState.getRoot())) return file;
            if (!file.isDirectory()) return file;
            if (this.state.size() >= FileTreeWalk.access$getMaxDepth$p((FileTreeWalk)this.this$0)) {
                return file;
            }
            this.state.push((FileTreeWalk.WalkState)this.directoryState(file));
        }
        return null;
    }

    protected void computeNext() {
        File file = this.gotoNext();
        if (file != null) {
            this.setNext(file);
        } else {
            this.done();
        }
    }
}
