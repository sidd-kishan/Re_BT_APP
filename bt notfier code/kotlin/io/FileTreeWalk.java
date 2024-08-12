/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.io.FileTreeWalk$FileTreeWalkIterator
 *  kotlin.io.FileWalkDirection
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.sequences.Sequence
 */
package kotlin.io;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.FileTreeWalk;
import kotlin.io.FileWalkDirection;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;

@Metadata(d1={"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010(\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u001a\u001b\u001cB\u0019\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006B\u0089\u0001\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b\u0018\u00010\b\u00128\u0010\f\u001a4\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0011\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0014\u00a2\u0006\u0002\u0010\u0015J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\u0017H\u0096\u0002J\u000e\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0014J\u001a\u0010\u0007\u001a\u00020\u00002\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\bJ \u0010\f\u001a\u00020\u00002\u0018\u0010\u0019\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u000b0\rJ\u001a\u0010\n\u001a\u00020\u00002\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b0\bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R@\u0010\f\u001a4\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0011\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u000b\u0018\u00010\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b\u0018\u00010\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0002X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001d"}, d2={"Lkotlin/io/FileTreeWalk;", "Lkotlin/sequences/Sequence;", "Ljava/io/File;", "start", "direction", "Lkotlin/io/FileWalkDirection;", "(Ljava/io/File;Lkotlin/io/FileWalkDirection;)V", "onEnter", "Lkotlin/Function1;", "", "onLeave", "", "onFail", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "f", "Ljava/io/IOException;", "e", "maxDepth", "", "(Ljava/io/File;Lkotlin/io/FileWalkDirection;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;I)V", "iterator", "", "depth", "function", "DirectoryState", "FileTreeWalkIterator", "WalkState", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public final class FileTreeWalk
implements Sequence<File> {
    private final FileWalkDirection direction;
    private final int maxDepth;
    private final Function1<File, Boolean> onEnter;
    private final Function2<File, IOException, Unit> onFail;
    private final Function1<File, Unit> onLeave;
    private final File start;

    public FileTreeWalk(File file, FileWalkDirection fileWalkDirection) {
        Intrinsics.checkNotNullParameter((Object)file, (String)"start");
        Intrinsics.checkNotNullParameter((Object)fileWalkDirection, (String)"direction");
        this(file, fileWalkDirection, null, null, null, 0, 32, null);
    }

    public /* synthetic */ FileTreeWalk(File file, FileWalkDirection fileWalkDirection, int n, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n & 2) != 0) {
            fileWalkDirection = FileWalkDirection.TOP_DOWN;
        }
        this(file, fileWalkDirection);
    }

    private FileTreeWalk(File file, FileWalkDirection fileWalkDirection, Function1<? super File, Boolean> function1, Function1<? super File, Unit> function12, Function2<? super File, ? super IOException, Unit> function2, int n) {
        this.start = file;
        this.direction = fileWalkDirection;
        this.onEnter = function1;
        this.onLeave = function12;
        this.onFail = function2;
        this.maxDepth = n;
    }

    /* synthetic */ FileTreeWalk(File file, FileWalkDirection fileWalkDirection, Function1 function1, Function1 function12, Function2 function2, int n, int n2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((n2 & 2) != 0) {
            fileWalkDirection = FileWalkDirection.TOP_DOWN;
        }
        if ((n2 & 0x20) != 0) {
            n = Integer.MAX_VALUE;
        }
        this(file, fileWalkDirection, (Function1<? super File, Boolean>)function1, (Function1<? super File, Unit>)function12, (Function2<? super File, ? super IOException, Unit>)function2, n);
    }

    public static final /* synthetic */ FileWalkDirection access$getDirection$p(FileTreeWalk fileTreeWalk) {
        return fileTreeWalk.direction;
    }

    public static final /* synthetic */ int access$getMaxDepth$p(FileTreeWalk fileTreeWalk) {
        return fileTreeWalk.maxDepth;
    }

    public static final /* synthetic */ Function1 access$getOnEnter$p(FileTreeWalk fileTreeWalk) {
        return fileTreeWalk.onEnter;
    }

    public static final /* synthetic */ Function2 access$getOnFail$p(FileTreeWalk fileTreeWalk) {
        return fileTreeWalk.onFail;
    }

    public static final /* synthetic */ Function1 access$getOnLeave$p(FileTreeWalk fileTreeWalk) {
        return fileTreeWalk.onLeave;
    }

    public static final /* synthetic */ File access$getStart$p(FileTreeWalk fileTreeWalk) {
        return fileTreeWalk.start;
    }

    public Iterator<File> iterator() {
        return (Iterator)new FileTreeWalkIterator(this);
    }

    public final FileTreeWalk maxDepth(int n) {
        if (n > 0) {
            return new FileTreeWalk(this.start, this.direction, this.onEnter, this.onLeave, this.onFail, n);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("depth must be positive, but was ");
        stringBuilder.append(n);
        stringBuilder.append('.');
        throw (Throwable)new IllegalArgumentException(stringBuilder.toString());
    }

    public final FileTreeWalk onEnter(Function1<? super File, Boolean> function1) {
        Intrinsics.checkNotNullParameter(function1, (String)"function");
        return new FileTreeWalk(this.start, this.direction, function1, this.onLeave, this.onFail, this.maxDepth);
    }

    public final FileTreeWalk onFail(Function2<? super File, ? super IOException, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, (String)"function");
        return new FileTreeWalk(this.start, this.direction, this.onEnter, this.onLeave, function2, this.maxDepth);
    }

    public final FileTreeWalk onLeave(Function1<? super File, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, (String)"function");
        return new FileTreeWalk(this.start, this.direction, this.onEnter, function1, this.onFail, this.maxDepth);
    }
}
