/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.collections.BooleanIterator
 *  kotlin.collections.ByteIterator
 *  kotlin.collections.CharIterator
 *  kotlin.collections.DoubleIterator
 *  kotlin.collections.FloatIterator
 *  kotlin.collections.IntIterator
 *  kotlin.collections.LongIterator
 *  kotlin.collections.ShortIterator
 *  kotlin.jvm.internal.ArrayBooleanIterator
 *  kotlin.jvm.internal.ArrayByteIterator
 *  kotlin.jvm.internal.ArrayCharIterator
 *  kotlin.jvm.internal.ArrayDoubleIterator
 *  kotlin.jvm.internal.ArrayFloatIterator
 *  kotlin.jvm.internal.ArrayIntIterator
 *  kotlin.jvm.internal.ArrayLongIterator
 *  kotlin.jvm.internal.ArrayShortIterator
 *  kotlin.jvm.internal.Intrinsics
 */
package kotlin.jvm.internal;

import kotlin.Metadata;
import kotlin.collections.BooleanIterator;
import kotlin.collections.ByteIterator;
import kotlin.collections.CharIterator;
import kotlin.collections.DoubleIterator;
import kotlin.collections.FloatIterator;
import kotlin.collections.IntIterator;
import kotlin.collections.LongIterator;
import kotlin.collections.ShortIterator;
import kotlin.jvm.internal.ArrayBooleanIterator;
import kotlin.jvm.internal.ArrayByteIterator;
import kotlin.jvm.internal.ArrayCharIterator;
import kotlin.jvm.internal.ArrayDoubleIterator;
import kotlin.jvm.internal.ArrayFloatIterator;
import kotlin.jvm.internal.ArrayIntIterator;
import kotlin.jvm.internal.ArrayLongIterator;
import kotlin.jvm.internal.ArrayShortIterator;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000F\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0019\n\u0002\u0018\u0002\n\u0002\u0010\u0013\n\u0002\u0018\u0002\n\u0002\u0010\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0002\u0018\u0002\n\u0002\u0010\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0017\n\u0000\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u000e\u0010\u0000\u001a\u00020\u00042\u0006\u0010\u0002\u001a\u00020\u0005\u001a\u000e\u0010\u0000\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u0007\u001a\u000e\u0010\u0000\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\t\u001a\u000e\u0010\u0000\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\u000b\u001a\u000e\u0010\u0000\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\r\u001a\u000e\u0010\u0000\u001a\u00020\u000e2\u0006\u0010\u0002\u001a\u00020\u000f\u001a\u000e\u0010\u0000\u001a\u00020\u00102\u0006\u0010\u0002\u001a\u00020\u0011\u00a8\u0006\u0012"}, d2={"iterator", "Lkotlin/collections/BooleanIterator;", "array", "", "Lkotlin/collections/ByteIterator;", "", "Lkotlin/collections/CharIterator;", "", "Lkotlin/collections/DoubleIterator;", "", "Lkotlin/collections/FloatIterator;", "", "Lkotlin/collections/IntIterator;", "", "Lkotlin/collections/LongIterator;", "", "Lkotlin/collections/ShortIterator;", "", "kotlin-stdlib"}, k=2, mv={1, 5, 1})
public final class ArrayIteratorsKt {
    public static final BooleanIterator iterator(boolean[] blArray) {
        Intrinsics.checkNotNullParameter((Object)blArray, (String)"array");
        return (BooleanIterator)new ArrayBooleanIterator(blArray);
    }

    public static final ByteIterator iterator(byte[] byArray) {
        Intrinsics.checkNotNullParameter((Object)byArray, (String)"array");
        return (ByteIterator)new ArrayByteIterator(byArray);
    }

    public static final CharIterator iterator(char[] cArray) {
        Intrinsics.checkNotNullParameter((Object)cArray, (String)"array");
        return (CharIterator)new ArrayCharIterator(cArray);
    }

    public static final DoubleIterator iterator(double[] dArray) {
        Intrinsics.checkNotNullParameter((Object)dArray, (String)"array");
        return (DoubleIterator)new ArrayDoubleIterator(dArray);
    }

    public static final FloatIterator iterator(float[] fArray) {
        Intrinsics.checkNotNullParameter((Object)fArray, (String)"array");
        return (FloatIterator)new ArrayFloatIterator(fArray);
    }

    public static final IntIterator iterator(int[] nArray) {
        Intrinsics.checkNotNullParameter((Object)nArray, (String)"array");
        return (IntIterator)new ArrayIntIterator(nArray);
    }

    public static final LongIterator iterator(long[] lArray) {
        Intrinsics.checkNotNullParameter((Object)lArray, (String)"array");
        return (LongIterator)new ArrayLongIterator(lArray);
    }

    public static final ShortIterator iterator(short[] sArray) {
        Intrinsics.checkNotNullParameter((Object)sArray, (String)"array");
        return (ShortIterator)new ArrayShortIterator(sArray);
    }
}
