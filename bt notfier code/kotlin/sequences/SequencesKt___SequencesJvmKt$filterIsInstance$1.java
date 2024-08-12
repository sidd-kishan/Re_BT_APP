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

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\n\u00a2\u0006\u0002\b\u0005"}, d2={"<anonymous>", "", "R", "it", "", "invoke"}, k=3, mv={1, 5, 1})
static final class SequencesKt___SequencesJvmKt.filterIsInstance.1
extends Lambda
implements Function1<Object, Boolean> {
    final Class $klass;

    SequencesKt___SequencesJvmKt.filterIsInstance.1(Class clazz) {
        this.$klass = clazz;
        super(1);
    }

    public final boolean invoke(Object object) {
        return this.$klass.isInstance(object);
    }
}
