/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Lambda
 */
package kotlin.sequences;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u0001H\u0002H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2={"<anonymous>", "", "T", "", "it", "invoke", "(Ljava/lang/Object;)Z"}, k=3, mv={1, 5, 1})
static final class SequencesKt___SequencesKt.filterNotNull.1
extends Lambda
implements Function1<T, Boolean> {
    public static final SequencesKt___SequencesKt.filterNotNull.1 INSTANCE = new /* invalid duplicate definition of identical inner class */;

    SequencesKt___SequencesKt.filterNotNull.1() {
    }

    public final boolean invoke(T t) {
        boolean bl = t == null;
        return bl;
    }
}
