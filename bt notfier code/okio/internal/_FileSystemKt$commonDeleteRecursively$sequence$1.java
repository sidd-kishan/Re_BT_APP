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
@DebugMetadata(c="okio.internal._FileSystemKt$commonDeleteRecursively$sequence$1", f="-FileSystem.kt", i={}, l={72}, m="invokeSuspend", n={}, s={})
static final class _FileSystemKt.commonDeleteRecursively.sequence.1
extends RestrictedSuspendLambda
implements Function2<SequenceScope<? super Path>, Continuation<? super Unit>, Object> {
    final Path $fileOrDirectory;
    final FileSystem $this_commonDeleteRecursively;
    private Object L$0;
    int label;

    _FileSystemKt.commonDeleteRecursively.sequence.1(FileSystem fileSystem, Path path, Continuation<? super _FileSystemKt.commonDeleteRecursively.sequence.1> continuation) {
        this.$this_commonDeleteRecursively = fileSystem;
        this.$fileOrDirectory = path;
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

    public final Object invokeSuspend(Object object) {
        Object object2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int n = this.label;
        if (n != 0) {
            if (n != 1) throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            ResultKt.throwOnFailure((Object)object);
            return Unit.INSTANCE;
        }
        ResultKt.throwOnFailure((Object)object);
        SequenceScope sequenceScope = (SequenceScope)this.L$0;
        FileSystem fileSystem = this.$this_commonDeleteRecursively;
        ArrayDeque arrayDeque = new ArrayDeque();
        object = this.$fileOrDirectory;
        Continuation continuation = (Continuation)this;
        this.label = 1;
        if (_FileSystemKt.collectRecursively((SequenceScope)sequenceScope, (FileSystem)fileSystem, (ArrayDeque)arrayDeque, (Path)object, (boolean)false, (boolean)true, (Continuation)continuation) != object2) return Unit.INSTANCE;
        return object2;
    }
}
