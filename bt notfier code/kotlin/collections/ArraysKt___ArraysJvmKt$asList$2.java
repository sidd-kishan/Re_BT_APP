/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.AbstractList
 *  kotlin.collections.ArraysKt
 */
package kotlin.collections;

import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.collections.AbstractList;
import kotlin.collections.ArraysKt;

@Metadata(d1={"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00060\u0003j\u0002`\u0004J\u0011\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0002H\u0096\u0002J\u0016\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0006H\u0096\u0002\u00a2\u0006\u0002\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J\b\u0010\u0010\u001a\u00020\nH\u0016J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0002H\u0016R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\u0012"}, d2={"kotlin/collections/ArraysKt___ArraysJvmKt$asList$2", "Lkotlin/collections/AbstractList;", "", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "size", "", "getSize", "()I", "contains", "", "element", "get", "index", "(I)Ljava/lang/Short;", "indexOf", "isEmpty", "lastIndexOf", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public static final class ArraysKt___ArraysJvmKt.asList.2
extends AbstractList<Short>
implements RandomAccess {
    final short[] $this_asList;

    ArraysKt___ArraysJvmKt.asList.2(short[] sArray) {
        this.$this_asList = sArray;
    }

    public boolean contains(short s) {
        return ArraysKt.contains((short[])this.$this_asList, (short)s);
    }

    public Short get(int n) {
        return this.$this_asList[n];
    }

    public int getSize() {
        return this.$this_asList.length;
    }

    public int indexOf(short s) {
        return ArraysKt.indexOf((short[])this.$this_asList, (short)s);
    }

    public boolean isEmpty() {
        boolean bl = this.$this_asList.length == 0;
        return bl;
    }

    public int lastIndexOf(short s) {
        return ArraysKt.lastIndexOf((short[])this.$this_asList, (short)s);
    }
}
