/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.jvm.internal.ContinuationImpl
 *  kotlin.coroutines.jvm.internal.DebugMetadata
 *  okio.internal._FileSystemKt
 */
package okio.internal;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import okio.internal._FileSystemKt;

/*
 * Exception performing whole class analysis ignored.
 */
@Metadata(k=3, mv={1, 5, 1}, xi=48)
@DebugMetadata(c="okio.internal._FileSystemKt", f="-FileSystem.kt", i={0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1}, l={113, 132, 142}, m="collectRecursively", n={"$this$collectRecursively", "fileSystem", "stack", "path", "followSymlinks", "postorder", "$this$collectRecursively", "fileSystem", "stack", "path", "followSymlinks", "postorder"}, s={"L$0", "L$1", "L$2", "L$3", "Z$0", "Z$1", "L$0", "L$1", "L$2", "L$3", "Z$0", "Z$1"})
static final class _FileSystemKt.collectRecursively.1
extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    boolean Z$0;
    boolean Z$1;
    int label;
    Object result;

    _FileSystemKt.collectRecursively.1(Continuation<? super _FileSystemKt.collectRecursively.1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object object) {
        this.result = object;
        this.label |= Integer.MIN_VALUE;
        return _FileSystemKt.collectRecursively(null, null, null, null, (boolean)false, (boolean)false, (Continuation)((Continuation)this));
    }
}
