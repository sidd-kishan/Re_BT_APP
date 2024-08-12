/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.AbstractList
 */
package kotlin.collections;

import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.collections.AbstractList;

@Metadata(d1={"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00060\u0003j\u0002`\u0004J\u0011\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0002H\u0096\u0002J\u0016\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0006H\u0096\u0002\u00a2\u0006\u0002\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J\b\u0010\u0010\u001a\u00020\nH\u0016J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0002H\u0016R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\u0012"}, d2={"kotlin/collections/ArraysKt___ArraysJvmKt$asList$6", "Lkotlin/collections/AbstractList;", "", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "size", "", "getSize", "()I", "contains", "", "element", "get", "index", "(I)Ljava/lang/Double;", "indexOf", "isEmpty", "lastIndexOf", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public static final class ArraysKt___ArraysJvmKt.asList.6
extends AbstractList<Double>
implements RandomAccess {
    final double[] $this_asList;

    ArraysKt___ArraysJvmKt.asList.6(double[] dArray) {
        this.$this_asList = dArray;
    }

    public boolean contains(double d) {
        double[] dArray = this.$this_asList;
        int n = dArray.length;
        boolean bl = false;
        int n2 = 0;
        while (true) {
            boolean bl2 = bl;
            if (n2 >= n) return bl2;
            boolean bl3 = Double.doubleToLongBits(dArray[n2]) == Double.doubleToLongBits(d);
            if (bl3) {
                bl2 = true;
                return bl2;
            }
            ++n2;
        }
    }

    public Double get(int n) {
        return this.$this_asList[n];
    }

    public int getSize() {
        return this.$this_asList.length;
    }

    public int indexOf(double d) {
        int n;
        double[] dArray = this.$this_asList;
        int n2 = dArray.length;
        for (n = 0; n < n2; ++n) {
            boolean bl = Double.doubleToLongBits(dArray[n]) == Double.doubleToLongBits(d);
            if (bl) return n;
        }
        n = -1;
        return n;
    }

    public boolean isEmpty() {
        boolean bl = this.$this_asList.length == 0;
        return bl;
    }

    public int lastIndexOf(double d) {
        double[] dArray = this.$this_asList;
        int n = dArray.length;
        int n2 = -1;
        --n;
        while (true) {
            int n3 = n2;
            if (n < 0) return n3;
            n3 = Double.doubleToLongBits(dArray[n]) == Double.doubleToLongBits(d) ? 1 : 0;
            if (n3 != 0) {
                n3 = n;
                return n3;
            }
            --n;
        }
    }
}
