/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.markers.KMappedMarker
 *  kotlin.text.StringsKt
 */
package kotlin.text;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.text.StringsKt;

@Metadata(d1={"\u0000\u0011\n\u0000\n\u0002\u0010\u001c\n\u0000\n\u0002\u0010(\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u000f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0096\u0002\u00a8\u0006\u0004\u00b8\u0006\u0000"}, d2={"kotlin/collections/CollectionsKt__IterablesKt$Iterable$1", "", "iterator", "", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public static final class StringsKt___StringsKt$asIterable$.inlined.Iterable.1
implements Iterable<Character>,
KMappedMarker {
    final CharSequence $this_asIterable$inlined;

    public StringsKt___StringsKt$asIterable$.inlined.Iterable.1(CharSequence charSequence) {
        this.$this_asIterable$inlined = charSequence;
    }

    @Override
    public Iterator<Character> iterator() {
        return (Iterator)StringsKt.iterator((CharSequence)this.$this_asIterable$inlined);
    }
}
