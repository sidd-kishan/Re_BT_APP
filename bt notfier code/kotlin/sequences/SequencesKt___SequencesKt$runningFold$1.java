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
@DebugMetadata(c="kotlin.sequences.SequencesKt___SequencesKt$runningFold$1", f="_Sequences.kt", i={0, 1}, l={2115, 2119}, m="invokeSuspend", n={"$this$sequence", "$this$sequence"}, s={"L$0", "L$0"})
static final class SequencesKt___SequencesKt.runningFold.1
extends RestrictedSuspendLambda
implements Function2<SequenceScope<? super R>, Continuation<? super Unit>, Object> {
    final Object $initial;
    final Function2 $operation;
    final Sequence $this_runningFold;
    private Object L$0;
    Object L$1;
    Object L$2;
    int label;

    SequencesKt___SequencesKt.runningFold.1(Sequence sequence, Object object, Function2 function2, Continuation continuation) {
        this.$this_runningFold = sequence;
        this.$initial = object;
        this.$operation = function2;
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
        Object object3;
        Object object4;
        Object object5;
        block4: {
            block5: {
                block2: {
                    block3: {
                        object5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int n = this.label;
                        if (n == 0) break block2;
                        if (n == 1) break block3;
                        if (n != 2) throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        object4 = (Iterator)this.L$2;
                        object3 = this.L$1;
                        object2 = (SequenceScope)this.L$0;
                        ResultKt.throwOnFailure((Object)object);
                        object = object3;
                        break block4;
                    }
                    object2 = (SequenceScope)this.L$0;
                    ResultKt.throwOnFailure((Object)object);
                    object = object2;
                    break block5;
                }
                ResultKt.throwOnFailure((Object)object);
                object2 = (SequenceScope)this.L$0;
                object4 = this.$initial;
                this.L$0 = object2;
                this.label = 1;
                object = object2;
                if (object2.yield(object4, (Continuation)this) == object5) {
                    return object5;
                }
            }
            object3 = this.$initial;
            object4 = this.$this_runningFold.iterator();
            object2 = object;
            object = object3;
        }
        do {
            if (!object4.hasNext()) return Unit.INSTANCE;
            object3 = object4.next();
            object3 = this.$operation.invoke(object, object3);
            this.L$0 = object2;
            this.L$1 = object3;
            this.L$2 = object4;
            this.label = 2;
            object = object3;
        } while (object2.yield(object3, (Continuation)this) != object5);
        return object5;
    }
}
