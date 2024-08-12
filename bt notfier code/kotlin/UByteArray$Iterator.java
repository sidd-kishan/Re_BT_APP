/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.UByte
 *  kotlin.collections.UByteIterator
 *  kotlin.jvm.internal.Intrinsics
 */
package kotlin;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.collections.UByteIterator;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\bH\u0096\u0002J\u0015\u0010\t\u001a\u00020\nH\u0016\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u000b\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!\u00a8\u0006\r"}, d2={"Lkotlin/UByteArray$Iterator;", "Lkotlin/collections/UByteIterator;", "array", "", "([B)V", "index", "", "hasNext", "", "nextUByte", "Lkotlin/UByte;", "nextUByte-w2LRezQ", "()B", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
private static final class UByteArray.Iterator
extends UByteIterator {
    private final byte[] array;
    private int index;

    public UByteArray.Iterator(byte[] byArray) {
        Intrinsics.checkNotNullParameter((Object)byArray, (String)"array");
        this.array = byArray;
    }

    public boolean hasNext() {
        boolean bl = this.index < this.array.length;
        return bl;
    }

    public byte nextUByte_w2LRezQ() {
        int n = this.index;
        byte[] byArray = this.array;
        if (n >= byArray.length) throw (Throwable)new NoSuchElementException(String.valueOf(this.index));
        this.index = n + 1;
        return UByte.constructor_impl((byte)byArray[n]);
    }
}
