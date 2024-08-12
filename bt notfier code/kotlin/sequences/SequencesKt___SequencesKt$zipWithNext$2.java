/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.ResultKt
 *  kotlin.Unit
 *  kotlin.coroutines.Continuation
 *  kotlin.coroutines.intrinsics.IntrinsicsKt
 *  kotlin.coroutines.jvm.internal.DebugMetadata
 *  kotlin.coroutines.jvm.internal.RestrictedSuspendLambda
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.sequences.Sequence
 *  kotlin.sequences.SequenceScope
 */
package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequenceScope;

@Metadata(d1={"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u0004H\u008a@\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2={"<anonymous>", "", "T", "R", "Lkotlin/sequences/SequenceScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k=3, mv={1, 5, 1})
@DebugMetadata(c="kotlin.sequences.SequencesKt___SequencesKt$zipWithNext$2", f="_Sequences.kt", i={0}, l={2690}, m="invokeSuspend", n={"next"}, s={"L$2"})
static final class SequencesKt___SequencesKt.zipWithNext.2
extends RestrictedSuspendLambda
implements Function2<SequenceScope<? super R>, Continuation<? super Unit>, Object> {
    final Sequence $this_zipWithNext;
    final Function2 $transform;
    private Object L$0;
    Object L$1;
    Object L$2;
    int label;

    SequencesKt___SequencesKt.zipWithNext.2(Sequence sequence, Function2 function2, Continuation continuation) {
        this.$this_zipWithNext = sequence;
        this.$transform = function2;
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
        SequenceScope sequenceScope;
        Iterator iterator;
        Object object2;
        Object object3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int n = this.label;
        if (n != 0) {
            if (n != 1) throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            object2 = this.L$2;
            iterator = (Iterator)this.L$1;
            sequenceScope = (SequenceScope)this.L$0;
            ResultKt.throwOnFailure((Object)object);
            object = object2;
        } else {
            ResultKt.throwOnFailure((Object)object);
            sequenceScope = (SequenceScope)this.L$0;
            iterator = this.$this_zipWithNext.iterator();
            if (!iterator.hasNext()) {
                return Unit.INSTANCE;
            }
            object = iterator.next();
        }
        while (iterator.hasNext()) {
            object2 = iterator.next();
            object = this.$transform.invoke(object, object2);
            this.L$0 = sequenceScope;
            this.L$1 = iterator;
            this.L$2 = object2;
            this.label = 1;
            if (sequenceScope.yield(object, (Continuation)this) == object3) {
                return object3;
            }
            object = object2;
        }
        return Unit.INSTANCE;
    }
}
