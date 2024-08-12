/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin._Assertions
 *  kotlin.io.FileTreeWalk$FileTreeWalkIterator
 *  kotlin.io.FileTreeWalk$WalkState
 *  kotlin.jvm.internal.Intrinsics
 */
package kotlin.io;

import java.io.File;
import kotlin.Metadata;
import kotlin._Assertions;
import kotlin.io.FileTreeWalk;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0003H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2={"Lkotlin/io/FileTreeWalk$FileTreeWalkIterator$SingleFileState;", "Lkotlin/io/FileTreeWalk$WalkState;", "rootFile", "Ljava/io/File;", "(Lkotlin/io/FileTreeWalk$FileTreeWalkIterator;Ljava/io/File;)V", "visited", "", "step", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
private final class FileTreeWalk.FileTreeWalkIterator.SingleFileState
extends FileTreeWalk.WalkState {
    final FileTreeWalk.FileTreeWalkIterator this$0;
    private boolean visited;

    public FileTreeWalk.FileTreeWalkIterator.SingleFileState(FileTreeWalk.FileTreeWalkIterator fileTreeWalkIterator, File file) {
        Intrinsics.checkNotNullParameter((Object)file, (String)"rootFile");
        this.this$0 = fileTreeWalkIterator;
        super(file);
        if (!_Assertions.ENABLED) return;
        boolean bl = file.isFile();
        if (!_Assertions.ENABLED) return;
        if (!bl) throw (Throwable)((Object)new AssertionError((Object)"rootFile must be verified to be file beforehand."));
    }

    public File step() {
        if (this.visited) {
            return null;
        }
        this.visited = true;
        return this.getRoot();
    }
}
