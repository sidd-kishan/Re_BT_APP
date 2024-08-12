/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 */
package kotlin.collections;

import java.util.Collection;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0010\u001e\n\u0002\b\u0002\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J%\u0010\u0003\u001a\u00020\u00042\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00062\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u0006H\u0000\u00a2\u0006\u0002\b\bJ\u0019\u0010\t\u001a\u00020\n2\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u000bH\u0000\u00a2\u0006\u0002\b\f\u00a8\u0006\r"}, d2={"Lkotlin/collections/AbstractSet$Companion;", "", "()V", "setEquals", "", "c", "", "other", "setEquals$kotlin_stdlib", "unorderedHashCode", "", "", "unorderedHashCode$kotlin_stdlib", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public static final class AbstractSet.Companion {
    private AbstractSet.Companion() {
    }

    public /* synthetic */ AbstractSet.Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public final boolean setEquals$kotlin_stdlib(Set<?> set, Set<?> set2) {
        Intrinsics.checkNotNullParameter(set, (String)"c");
        Intrinsics.checkNotNullParameter(set2, (String)"other");
        if (set.size() == set2.size()) return ((Collection)set).containsAll((Collection)set2);
        return false;
    }

    public final int unorderedHashCode$kotlin_stdlib(Collection<?> object) {
        Intrinsics.checkNotNullParameter(object, (String)"c");
        object = object.iterator();
        int n = 0;
        while (object.hasNext()) {
            Object e = object.next();
            int n2 = e != null ? e.hashCode() : 0;
            n += n2;
        }
        return n;
    }
}
