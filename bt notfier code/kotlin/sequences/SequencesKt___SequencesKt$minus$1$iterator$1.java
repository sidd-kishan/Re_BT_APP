/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Lambda
 *  kotlin.jvm.internal.Ref$BooleanRef
 *  kotlin.sequences.SequencesKt___SequencesKt$minus$1
 */
package kotlin.sequences;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlin.sequences.SequencesKt___SequencesKt;

@Metadata(d1={"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2={"<anonymous>", "", "T", "it", "invoke", "(Ljava/lang/Object;)Z"}, k=3, mv={1, 5, 1})
static final class SequencesKt___SequencesKt.minus.iterator.1
extends Lambda
implements Function1<T, Boolean> {
    final Ref.BooleanRef $removed;
    final SequencesKt___SequencesKt.minus.1 this$0;

    SequencesKt___SequencesKt.minus.iterator.1(SequencesKt___SequencesKt.minus.1 var1_1, Ref.BooleanRef booleanRef) {
        this.this$0 = var1_1;
        this.$removed = booleanRef;
        super(1);
    }

    public final boolean invoke(T t) {
        boolean bl;
        boolean bl2 = this.$removed.element;
        boolean bl3 = bl = true;
        if (bl2) return bl3;
        bl3 = bl;
        if (!Intrinsics.areEqual(t, (Object)this.this$0.$element)) return bl3;
        this.$removed.element = true;
        bl3 = false;
        return bl3;
    }
}
