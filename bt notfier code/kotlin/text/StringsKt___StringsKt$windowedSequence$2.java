/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.Lambda
 */
package kotlin.text;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1={"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2={"<anonymous>", "R", "index", "", "invoke", "(I)Ljava/lang/Object;"}, k=3, mv={1, 5, 1})
static final class StringsKt___StringsKt.windowedSequence.2
extends Lambda
implements Function1<Integer, R> {
    final int $size;
    final CharSequence $this_windowedSequence;
    final Function1 $transform;

    StringsKt___StringsKt.windowedSequence.2(CharSequence charSequence, int n, Function1 function1) {
        this.$this_windowedSequence = charSequence;
        this.$size = n;
        this.$transform = function1;
        super(1);
    }

    public final R invoke(int n) {
        int n2;
        int n3 = this.$size + n;
        if (n3 >= 0) {
            n2 = n3;
            if (n3 <= this.$this_windowedSequence.length()) return this.$transform.invoke((Object)this.$this_windowedSequence.subSequence(n, n2));
        }
        n2 = this.$this_windowedSequence.length();
        return this.$transform.invoke((Object)this.$this_windowedSequence.subSequence(n, n2));
    }
}
