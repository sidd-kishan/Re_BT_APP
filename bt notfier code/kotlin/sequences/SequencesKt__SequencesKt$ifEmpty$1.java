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
 *  kotlin.jvm.functions.Function0
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
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequenceScope;

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u008a@\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2={"<anonymous>", "", "T", "Lkotlin/sequences/SequenceScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k=3, mv={1, 5, 1})
@DebugMetadata(c="kotlin.sequences.SequencesKt__SequencesKt$ifEmpty$1", f="Sequences.kt", i={}, l={69, 71}, m="invokeSuspend", n={}, s={})
static final class SequencesKt__SequencesKt.ifEmpty.1
extends RestrictedSuspendLambda
implements Function2<SequenceScope<? super T>, Continuation<? super Unit>, Object> {
    final Function0 $defaultValue;
    final Sequence $this_ifEmpty;
    private Object L$0;
    int label;

    SequencesKt__SequencesKt.ifEmpty.1(Sequence sequence, Function0 function0, Continuation continuation) {
        this.$this_ifEmpty = sequence;
        this.$defaultValue = function0;
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
        Object object2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int n = this.label;
        if (n != 0) {
            if (n != 1) {
                if (n != 2) throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure((Object)object);
            return Unit.INSTANCE;
        }
        ResultKt.throwOnFailure((Object)object);
        object = (SequenceScope)this.L$0;
        Iterator iterator = this.$this_ifEmpty.iterator();
        if (iterator.hasNext()) {
            this.label = 1;
            if (object.yieldAll(iterator, (Continuation)this) != object2) return Unit.INSTANCE;
            return object2;
        }
        iterator = (Sequence)this.$defaultValue.invoke();
        this.label = 2;
        if (object.yieldAll((Sequence)iterator, (Continuation)this) != object2) return Unit.INSTANCE;
        return object2;
    }
}
