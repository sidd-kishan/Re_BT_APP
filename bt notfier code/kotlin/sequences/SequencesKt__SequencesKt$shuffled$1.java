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
 *  kotlin.coroutines.jvm.internal.DebugMetadata
 *  kotlin.coroutines.jvm.internal.RestrictedSuspendLambda
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.random.Random
 *  kotlin.sequences.Sequence
 *  kotlin.sequences.SequenceScope
 *  kotlin.sequences.SequencesKt
 */
package kotlin.sequences;

import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequenceScope;
import kotlin.sequences.SequencesKt;

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u008a@\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2={"<anonymous>", "", "T", "Lkotlin/sequences/SequenceScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k=3, mv={1, 5, 1})
@DebugMetadata(c="kotlin.sequences.SequencesKt__SequencesKt$shuffled$1", f="Sequences.kt", i={}, l={145}, m="invokeSuspend", n={}, s={})
static final class SequencesKt__SequencesKt.shuffled.1
extends RestrictedSuspendLambda
implements Function2<SequenceScope<? super T>, Continuation<? super Unit>, Object> {
    final Random $random;
    final Sequence $this_shuffled;
    private Object L$0;
    Object L$1;
    int label;

    SequencesKt__SequencesKt.shuffled.1(Sequence sequence, Random random, Continuation continuation) {
        this.$this_shuffled = sequence;
        this.$random = random;
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
        Object object2;
        Object object3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int n = this.label;
        if (n != 0) {
            if (n != 1) throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            object2 = (List)this.L$1;
            sequenceScope = (SequenceScope)this.L$0;
            ResultKt.throwOnFailure((Object)object);
            object = object2;
        } else {
            ResultKt.throwOnFailure((Object)object);
            sequenceScope = (SequenceScope)this.L$0;
            object = SequencesKt.toMutableList((Sequence)this.$this_shuffled);
        }
        do {
            Object object4;
            if (!(((Collection)object).isEmpty() ^ true)) return Unit.INSTANCE;
            n = this.$random.nextInt(object.size());
            object2 = object4 = CollectionsKt.removeLast((List)object);
            if (n < object.size()) {
                object2 = object.set(n, object4);
            }
            this.L$0 = sequenceScope;
            this.L$1 = object;
            this.label = 1;
        } while (sequenceScope.yield(object2, (Continuation)this) != object3);
        return object3;
    }
}
