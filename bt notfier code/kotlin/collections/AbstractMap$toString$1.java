/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.AbstractMap
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.jvm.internal.Lambda
 */
package kotlin.collections;

import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.AbstractMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/*
 * Exception performing whole class analysis ignored.
 */
@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010&\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0006\b\u0001\u0010\u0003 \u00012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0005H\n\u00a2\u0006\u0002\b\u0006"}, d2={"<anonymous>", "", "K", "V", "it", "", "invoke"}, k=3, mv={1, 5, 1})
static final class AbstractMap.toString.1
extends Lambda
implements Function1<Map.Entry<? extends K, ? extends V>, CharSequence> {
    final AbstractMap this$0;

    AbstractMap.toString.1(AbstractMap abstractMap) {
        this.this$0 = abstractMap;
        super(1);
    }

    public final CharSequence invoke(Map.Entry<? extends K, ? extends V> entry) {
        Intrinsics.checkNotNullParameter(entry, (String)"it");
        return AbstractMap.access$toString((AbstractMap)this.this$0, entry);
    }
}
