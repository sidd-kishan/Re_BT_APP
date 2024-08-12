/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function0
 *  kotlin.jvm.internal.Lambda
 *  kotlin.text.StringsKt
 */
package kotlin.text;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

@Metadata(d1={"\u0000\f\n\u0000\n\u0002\u0010(\n\u0002\u0010\f\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n\u00a2\u0006\u0002\b\u0003"}, d2={"<anonymous>", "", "", "invoke"}, k=3, mv={1, 5, 1})
static final class StringsKt___StringsKt.withIndex.1
extends Lambda
implements Function0<Iterator<? extends Character>> {
    final CharSequence $this_withIndex;

    StringsKt___StringsKt.withIndex.1(CharSequence charSequence) {
        this.$this_withIndex = charSequence;
        super(0);
    }

    public final Iterator<Character> invoke() {
        return (Iterator)StringsKt.iterator((CharSequence)this.$this_withIndex);
    }
}
