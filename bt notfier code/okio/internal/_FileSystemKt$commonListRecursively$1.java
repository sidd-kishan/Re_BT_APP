/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.collections.ArrayDeque
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.coroutines.jvm.internal.DebugMetadata
 *  kotlin.coroutines.jvm.internal.RestrictedSuspendLambda
 *  kotlin.jvm.functions.Function2
 *  kotlin.sequences.SequenceScope
 *  okio.FileSystem
 *  okio.Path
 *  okio.internal._FileSystemKt
 */
package okio.internal;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.SequenceScope;
import okio.FileSystem;
import okio.Path;
import okio.internal._FileSystemKt;

/*
 * Exception performing whole class analysis ignored.
 */
@Metadata(d1={"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u008a@"}, d2={"<anonymous>", "", "Lkotlin/sequences/SequenceScope;", "Lokio/Path;"}, k=3, mv={1, 5, 1}, xi=48)
@DebugMetadata(c="okio.internal._FileSystemKt$commonListRecursively$1", f="-FileSystem.kt", i={0, 0}, l={93}, m="invokeSuspend", n={"$this$sequence", "stack"}, s={"L$0", "L$1"})
static final class _FileSystemKt.commonListRecursively.1
extends RestrictedSuspendLambda
implements Function2<SequenceScope<? super Path>, Continuation<? super Unit>, Object> {
    final Path $dir;
    final boolean $followSymlinks;
    final FileSystem $this_commonListRecursively;
    private Object L$0;
    Object L$1;
    Object L$2;
    int label;

    _FileSystemKt.commonListRecursively.1(Path path, FileSystem fileSystem, boolean bl, Continuation<? super _FileSystemKt.commonListRecursively.1> continuation) {
        this.$dir = path;
        this.$this_commonListRecursively = fileSystem;
        this.$followSymlinks = bl;
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object object, Continuation<?> object2) {
        object2 = new /* invalid duplicate definition of identical inner class */;
        object2.L$0 = object;
        return object2;
    }

    public final Object invoke(SequenceScope<? super Path> sequenceScope, Continuation<? super Unit> continuation) {
        return (this.create(sequenceScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object iterator) {
        Continuation continuation;
        boolean bl;
        FileSystem fileSystem;
        SequenceScope sequenceScope;
        ArrayDeque arrayDeque;
        Iterator iterator2;
        Object object = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int n = this.label;
        if (n != 0) {
            if (n != 1) throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            iterator2 = (Iterator)this.L$2;
            arrayDeque = (ArrayDeque)this.L$1;
            sequenceScope = (SequenceScope)this.L$0;
            ResultKt.throwOnFailure((Object)iterator);
            iterator = iterator2;
        } else {
            ResultKt.throwOnFailure((Object)iterator);
            sequenceScope = (SequenceScope)this.L$0;
            arrayDeque = new ArrayDeque();
            arrayDeque.addLast((Object)this.$dir);
            iterator = this.$this_commonListRecursively.list(this.$dir).iterator();
        }
        do {
            if (!iterator.hasNext()) return Unit.INSTANCE;
            iterator2 = (Path)iterator.next();
            fileSystem = this.$this_commonListRecursively;
            bl = this.$followSymlinks;
            continuation = (Continuation)this;
            this.L$0 = sequenceScope;
            this.L$1 = arrayDeque;
            this.L$2 = iterator;
            this.label = 1;
        } while (_FileSystemKt.collectRecursively((SequenceScope)sequenceScope, (FileSystem)fileSystem, (ArrayDeque)arrayDeque, (Path)iterator2, (boolean)bl, (boolean)false, (Continuation)continuation) != object);
        return object;
    }
}
