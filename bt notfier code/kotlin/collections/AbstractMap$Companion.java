/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.DefaultConstructorMarker
 *  kotlin.jvm.internal.Intrinsics
 */
package kotlin.collections;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010&\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J'\u0010\u0003\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001H\u0000\u00a2\u0006\u0002\b\bJ\u001d\u0010\t\u001a\u00020\n2\u000e\u0010\u0005\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0006H\u0000\u00a2\u0006\u0002\b\u000bJ\u001d\u0010\f\u001a\u00020\r2\u000e\u0010\u0005\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0006H\u0000\u00a2\u0006\u0002\b\u000e\u00a8\u0006\u000f"}, d2={"Lkotlin/collections/AbstractMap$Companion;", "", "()V", "entryEquals", "", "e", "", "other", "entryEquals$kotlin_stdlib", "entryHashCode", "", "entryHashCode$kotlin_stdlib", "entryToString", "", "entryToString$kotlin_stdlib", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public static final class AbstractMap.Companion {
    private AbstractMap.Companion() {
    }

    public /* synthetic */ AbstractMap.Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public final boolean entryEquals$kotlin_stdlib(Map.Entry<?, ?> entry, Object object) {
        Intrinsics.checkNotNullParameter(entry, (String)"e");
        boolean bl = object instanceof Map.Entry;
        boolean bl2 = false;
        if (!bl) {
            return false;
        }
        Object obj = entry.getKey();
        object = (Map.Entry)object;
        bl = bl2;
        if (!Intrinsics.areEqual(obj, object.getKey())) return bl;
        bl = bl2;
        if (!Intrinsics.areEqual(entry.getValue(), object.getValue())) return bl;
        bl = true;
        return bl;
    }

    public final int entryHashCode$kotlin_stdlib(Map.Entry<?, ?> entry) {
        Intrinsics.checkNotNullParameter(entry, (String)"e");
        Object obj = entry.getKey();
        int n = 0;
        int n2 = obj != null ? obj.hashCode() : 0;
        entry = entry.getValue();
        if (entry == null) return n2 ^ n;
        n = ((Object)entry).hashCode();
        return n2 ^ n;
    }

    public final String entryToString$kotlin_stdlib(Map.Entry<?, ?> entry) {
        Intrinsics.checkNotNullParameter(entry, (String)"e");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(entry.getKey());
        stringBuilder.append('=');
        stringBuilder.append(entry.getValue());
        return stringBuilder.toString();
    }
}
