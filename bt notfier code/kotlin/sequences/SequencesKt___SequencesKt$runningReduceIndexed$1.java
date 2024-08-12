/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.collections.CollectionsKt
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.coroutines.jvm.internal.Boxing
 *  kotlin.coroutines.jvm.internal.DebugMetadata
 *  kotlin.coroutines.jvm.internal.RestrictedSuspendLambda
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.functions.Function3
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.sequences.Sequence
 *  kotlin.sequences.SequenceScope
 */
package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequenceScope;

@Metadata(d1={"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\b\b\u0001\u0010\u0003*\u0002H\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u008a@\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2={"<anonymous>", "", "S", "T", "Lkotlin/sequences/SequenceScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k=3, mv={1, 5, 1})
@DebugMetadata(c="kotlin.sequences.SequencesKt___SequencesKt$runningReduceIndexed$1", f="_Sequences.kt", i={0, 0, 0}, l={2202, 2206}, m="invokeSuspend", n={"$this$sequence", "iterator", "accumulator"}, s={"L$0", "L$1", "L$2"})
static final class SequencesKt___SequencesKt.runningReduceIndexed.1
extends RestrictedSuspendLambda
implements Function2<SequenceScope<? super S>, Continuation<? super Unit>, Object> {
    final Function3 $operation;
    final Sequence $this_runningReduceIndexed;
    int I$0;
    private Object L$0;
    Object L$1;
    Object L$2;
    int label;

    SequencesKt___SequencesKt.runningReduceIndexed.1(Sequence sequence, Function3 function3, Continuation continuation) {
        this.$this_runningReduceIndexed = sequence;
        this.$operation = function3;
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object object, Continuation<?> object2) {
        Intrinsics.checkNotNullParameter(object2, (String)"completion");
        object2 = new /* invalid duplicate definition of identical inner class */;
        object2.L$0 = object;
        return object2;
    }

    public final Object invoke(Object object, Object object2) {
        return (this.create(object, (Continuation)object2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object object) {
        Object object2;
        Iterator iterator;
        Object object3;
        Object object4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int n = this.label;
        int n2 = 1;
        if (n != 0) {
            if (n != 1) {
                if (n != 2) throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                n2 = this.I$0;
                object3 = this.L$2;
                iterator = (Iterator)this.L$1;
                object2 = (SequenceScope)this.L$0;
                ResultKt.throwOnFailure((Object)object);
                object = object3;
            } else {
                object3 = this.L$2;
                iterator = (Iterator)this.L$1;
                object2 = (SequenceScope)this.L$0;
                ResultKt.throwOnFailure((Object)object);
                object = object3;
            }
        } else {
            ResultKt.throwOnFailure((Object)object);
            object3 = (SequenceScope)this.L$0;
            iterator = this.$this_runningReduceIndexed.iterator();
            if (!iterator.hasNext()) return Unit.INSTANCE;
            Object e = iterator.next();
            this.L$0 = object3;
            this.L$1 = iterator;
            this.L$2 = e;
            this.label = 1;
            object = e;
            object2 = object3;
            if (object3.yield(e, (Continuation)this) == object4) {
                return object4;
            }
        }
        while (iterator.hasNext()) {
            object3 = this.$operation;
            n = n2 + 1;
            if (n2 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            object = object3.invoke((Object)Boxing.boxInt((int)n2), object, iterator.next());
            this.L$0 = object2;
            this.L$1 = iterator;
            this.L$2 = object;
            this.I$0 = n;
            this.label = 2;
            if (object2.yield(object, (Continuation)this) == object4) {
                return object4;
            }
            n2 = n;
        }
        return Unit.INSTANCE;
    }
}
