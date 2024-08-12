/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.Grouping
 *  kotlin.jvm.functions.Function1
 *  kotlin.text.StringsKt
 */
package kotlin.text;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.Grouping;
import kotlin.jvm.functions.Function1;
import kotlin.text.StringsKt;

@Metadata(d1={"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0002\b\u0004\n\u0002\u0010(\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00028\u00000\u0001J\u0015\u0010\u0003\u001a\u00028\u00002\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a2\u0006\u0002\u0010\u0005J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H\u0016\u00a8\u0006\b"}, d2={"kotlin/text/StringsKt___StringsKt$groupingBy$1", "Lkotlin/collections/Grouping;", "", "keyOf", "element", "(C)Ljava/lang/Object;", "sourceIterator", "", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public static final class StringsKt___StringsKt.groupingBy.1
implements Grouping<Character, K> {
    final Function1 $keySelector;
    final CharSequence $this_groupingBy;

    public StringsKt___StringsKt.groupingBy.1(CharSequence charSequence, Function1 function1) {
        this.$this_groupingBy = charSequence;
        this.$keySelector = function1;
    }

    public K keyOf(char c) {
        return this.$keySelector.invoke((Object)Character.valueOf(c));
    }

    public Iterator<Character> sourceIterator() {
        return (Iterator)StringsKt.iterator((CharSequence)this.$this_groupingBy);
    }
}
