/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.UByte
 *  kotlin.UByteArray
 *  kotlin.collections.AbstractList
 *  kotlin.collections.ArraysKt
 */
package kotlin.collections.unsigned;

import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UByteArray;
import kotlin.collections.AbstractList;
import kotlin.collections.ArraysKt;

@Metadata(d1={"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00060\u0003j\u0002`\u0004J\u001b\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0002H\u0096\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b\f\u0010\rJ\u001e\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0006H\u0096\u0002\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0002H\u0016\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0015\u001a\u00020\nH\u0016J\u001a\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0002H\u0016\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0017\u0010\u0014R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\b\u00f8\u0001\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!\u00a8\u0006\u0018"}, d2={"kotlin/collections/unsigned/UArraysKt___UArraysJvmKt$asList$3", "Lkotlin/collections/AbstractList;", "Lkotlin/UByte;", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "size", "", "getSize", "()I", "contains", "", "element", "contains-7apg3OU", "(B)Z", "get", "index", "get-w2LRezQ", "(I)B", "indexOf", "indexOf-7apg3OU", "(B)I", "isEmpty", "lastIndexOf", "lastIndexOf-7apg3OU", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public static final class UArraysKt___UArraysJvmKt.asList.3
extends AbstractList<UByte>
implements RandomAccess {
    final byte[] $this_asList;

    UArraysKt___UArraysJvmKt.asList.3(byte[] byArray) {
        this.$this_asList = byArray;
    }

    public boolean contains_7apg3OU(byte by) {
        return UByteArray.contains_7apg3OU((byte[])this.$this_asList, (byte)by);
    }

    public byte get_w2LRezQ(int n) {
        return UByteArray.get_w2LRezQ((byte[])this.$this_asList, (int)n);
    }

    public int getSize() {
        return UByteArray.getSize_impl((byte[])this.$this_asList);
    }

    public int indexOf_7apg3OU(byte by) {
        return ArraysKt.indexOf((byte[])this.$this_asList, (byte)by);
    }

    public boolean isEmpty() {
        return UByteArray.isEmpty_impl((byte[])this.$this_asList);
    }

    public int lastIndexOf_7apg3OU(byte by) {
        return ArraysKt.lastIndexOf((byte[])this.$this_asList, (byte)by);
    }
}
