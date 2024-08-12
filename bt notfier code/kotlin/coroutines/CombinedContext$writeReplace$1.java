/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.coroutines.CoroutineContext
 *  kotlin.coroutines.CoroutineContext$Element
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Lambda
 *  kotlin.jvm.internal.Ref$IntRef
 */
package kotlin.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

@Metadata(d1={"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2={"<anonymous>", "", "<anonymous parameter 0>", "element", "Lkotlin/coroutines/CoroutineContext$Element;", "invoke", "(Lkotlin/Unit;Lkotlin/coroutines/CoroutineContext$Element;)V"}, k=3, mv={1, 5, 1})
static final class CombinedContext.writeReplace.1
extends Lambda
implements Function2<Unit, CoroutineContext.Element, Unit> {
    final CoroutineContext[] $elements;
    final Ref.IntRef $index;

    CombinedContext.writeReplace.1(CoroutineContext[] coroutineContextArray, Ref.IntRef intRef) {
        this.$elements = coroutineContextArray;
        this.$index = intRef;
        super(2);
    }

    public final void invoke(Unit unit, CoroutineContext.Element element) {
        Intrinsics.checkNotNullParameter((Object)unit, (String)"<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter((Object)element, (String)"element");
        CoroutineContext[] coroutineContextArray = this.$elements;
        unit = this.$index;
        int n = unit.element;
        unit.element = n + 1;
        coroutineContextArray[n] = (CoroutineContext)element;
    }
}
