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

@Metadata(d1={"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00060\u0003j\u0002`\u0004J\u0011\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0002H\u0096\u0002J\u0016\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0002H\u0096\u0002\u00a2\u0006\u0002\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002H\u0016J\b\u0010\u000f\u001a\u00020\tH\u0016J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002H\u0016R\u0014\u0010\u0005\u001a\u00020\u00028VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u0011"}, d2={"kotlin/collections/ArraysKt___ArraysJvmKt$asList$3", "Lkotlin/collections/AbstractList;", "", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "size", "getSize", "()I", "contains", "", "element", "get", "index", "(I)Ljava/lang/Integer;", "indexOf", "isEmpty", "lastIndexOf", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public static final class ArraysKt___ArraysJvmKt.asList.3
extends AbstractList<Integer>
implements RandomAccess {
    final int[] $this_asList;

    ArraysKt___ArraysJvmKt.asList.3(int[] nArray) {
        this.$this_asList = nArray;
    }

    public boolean contains(int n) {
        return ArraysKt.contains((int[])this.$this_asList, (int)n);
    }

    public Integer get(int n) {
        return this.$this_asList[n];
    }

    public int getSize() {
        return this.$this_asList.length;
    }

    public int indexOf(int n) {
        return ArraysKt.indexOf((int[])this.$this_asList, (int)n);
    }

    public boolean isEmpty() {
        boolean bl = this.$this_asList.length == 0;
        return bl;
    }

    public int lastIndexOf(int n) {
        return ArraysKt.lastIndexOf((int[])this.$this_asList, (int)n);
    }
}
