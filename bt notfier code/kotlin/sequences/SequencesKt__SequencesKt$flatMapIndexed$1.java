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
 *  kotlin.jvm.functions.Function1
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
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequenceScope;

@Metadata(d1={"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u0005H\u008a@\u00a2\u0006\u0004\b\u0006\u0010\u0007"}, d2={"<anonymous>", "", "T", "C", "R", "Lkotlin/sequences/SequenceScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k=3, mv={1, 5, 1})
@DebugMetadata(c="kotlin.sequences.SequencesKt__SequencesKt$flatMapIndexed$1", f="Sequences.kt", i={}, l={332}, m="invokeSuspend", n={}, s={})
static final class SequencesKt__SequencesKt.flatMapIndexed.1
extends RestrictedSuspendLambda
implements Function2<SequenceScope<? super R>, Continuation<? super Unit>, Object> {
    final Function1 $iterator;
    final Sequence $source;
    final Function2 $transform;
    int I$0;
    private Object L$0;
    Object L$1;
    int label;

    SequencesKt__SequencesKt.flatMapIndexed.1(Sequence sequence, Function2 function2, Function1 function1, Continuation continuation) {
        this.$source = sequence;
        this.$transform = function2;
        this.$iterator = function1;
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
            n = this.I$0;
            object2 = (Iterator)this.L$1;
            sequenceScope = (SequenceScope)this.L$0;
            ResultKt.throwOnFailure((Object)object);
            object = object2;
        } else {
            ResultKt.throwOnFailure((Object)object);
            sequenceScope = (SequenceScope)this.L$0;
            n = 0;
            object = this.$source.iterator();
        }
        while (object.hasNext()) {
            Object e = object.next();
            object2 = this.$transform;
            int n2 = n + 1;
            if (n < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            object2 = object2.invoke((Object)Boxing.boxInt((int)n), e);
            object2 = (Iterator)this.$iterator.invoke(object2);
            this.L$0 = sequenceScope;
            this.L$1 = object;
            this.I$0 = n2;
            this.label = 1;
            if (sequenceScope.yieldAll((Iterator)object2, (Continuation)this) == object3) {
                return object3;
            }
            n = n2;
        }
        return Unit.INSTANCE;
    }
}
