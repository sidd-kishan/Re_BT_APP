/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.AbstractCollection
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Lambda
 */
package kotlin.collections;

import kotlin.Metadata;
import kotlin.collections.AbstractCollection;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1={"\u0000\n\n\u0000\n\u0002\u0010\r\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002 \u00012\u0006\u0010\u0003\u001a\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2={"<anonymous>", "", "E", "it", "invoke", "(Ljava/lang/Object;)Ljava/lang/CharSequence;"}, k=3, mv={1, 5, 1})
static final class AbstractCollection.toString.1
extends Lambda
implements Function1<E, CharSequence> {
    final AbstractCollection this$0;

    AbstractCollection.toString.1(AbstractCollection abstractCollection) {
        this.this$0 = abstractCollection;
        super(1);
    }

    public final CharSequence invoke(E object) {
        object = object == this.this$0 ? "(this Collection)" : String.valueOf(object);
        return (CharSequence)object;
    }
}
