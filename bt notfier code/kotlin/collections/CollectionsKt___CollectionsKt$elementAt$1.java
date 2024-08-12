/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Lambda
 */
package kotlin.collections;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1={"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2={"<anonymous>", "T", "it", "", "invoke", "(I)Ljava/lang/Object;"}, k=3, mv={1, 5, 1})
static final class CollectionsKt___CollectionsKt.elementAt.1
extends Lambda
implements Function1<Integer, T> {
    final int $index;

    CollectionsKt___CollectionsKt.elementAt.1(int n) {
        this.$index = n;
        super(1);
    }

    public final T invoke(int n) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Collection doesn't contain element at index ");
        stringBuilder.append(this.$index);
        stringBuilder.append('.');
        throw (Throwable)new IndexOutOfBoundsException(stringBuilder.toString());
    }
}
