/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.NumbersKt__FloorDivModKt
 *  kotlin.jvm.internal.DoubleCompanionObject
 *  kotlin.jvm.internal.FloatCompanionObject
 */
package kotlin;

import kotlin.Metadata;
import kotlin.NumbersKt__FloorDivModKt;
import kotlin.jvm.internal.DoubleCompanionObject;
import kotlin.jvm.internal.FloatCompanionObject;

@Metadata(d1={"\u0000*\n\u0000\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u0087\b\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0087\b\u001a\r\u0010\u0003\u001a\u00020\u0001*\u00020\u0001H\u0087\b\u001a\r\u0010\u0003\u001a\u00020\u0001*\u00020\u0002H\u0087\b\u001a\r\u0010\u0004\u001a\u00020\u0001*\u00020\u0001H\u0087\b\u001a\r\u0010\u0004\u001a\u00020\u0001*\u00020\u0002H\u0087\b\u001a\u0015\u0010\u0005\u001a\u00020\u0006*\u00020\u00072\u0006\u0010\b\u001a\u00020\u0002H\u0087\b\u001a\u0015\u0010\u0005\u001a\u00020\t*\u00020\n2\u0006\u0010\b\u001a\u00020\u0001H\u0087\b\u001a\r\u0010\u000b\u001a\u00020\f*\u00020\u0006H\u0087\b\u001a\r\u0010\u000b\u001a\u00020\f*\u00020\tH\u0087\b\u001a\r\u0010\r\u001a\u00020\f*\u00020\u0006H\u0087\b\u001a\r\u0010\r\u001a\u00020\f*\u00020\tH\u0087\b\u001a\r\u0010\u000e\u001a\u00020\f*\u00020\u0006H\u0087\b\u001a\r\u0010\u000e\u001a\u00020\f*\u00020\tH\u0087\b\u001a\u0015\u0010\u000f\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u0001H\u0087\b\u001a\u0015\u0010\u000f\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0001H\u0087\b\u001a\u0015\u0010\u0011\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u0001H\u0087\b\u001a\u0015\u0010\u0011\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0001H\u0087\b\u001a\r\u0010\u0012\u001a\u00020\u0001*\u00020\u0001H\u0087\b\u001a\r\u0010\u0012\u001a\u00020\u0002*\u00020\u0002H\u0087\b\u001a\r\u0010\u0013\u001a\u00020\u0001*\u00020\u0001H\u0087\b\u001a\r\u0010\u0013\u001a\u00020\u0002*\u00020\u0002H\u0087\b\u001a\r\u0010\u0014\u001a\u00020\u0002*\u00020\u0006H\u0087\b\u001a\r\u0010\u0014\u001a\u00020\u0001*\u00020\tH\u0087\b\u001a\r\u0010\u0015\u001a\u00020\u0002*\u00020\u0006H\u0087\b\u001a\r\u0010\u0015\u001a\u00020\u0001*\u00020\tH\u0087\b\u00a8\u0006\u0016"}, d2={"countLeadingZeroBits", "", "", "countOneBits", "countTrailingZeroBits", "fromBits", "", "Lkotlin/Double$Companion;", "bits", "", "Lkotlin/Float$Companion;", "isFinite", "", "isInfinite", "isNaN", "rotateLeft", "bitCount", "rotateRight", "takeHighestOneBit", "takeLowestOneBit", "toBits", "toRawBits", "kotlin-stdlib"}, k=5, mv={1, 5, 1}, xi=1, xs="kotlin/NumbersKt")
class NumbersKt__NumbersJVMKt
extends NumbersKt__FloorDivModKt {
    private static final int countLeadingZeroBits(int n) {
        return Integer.numberOfLeadingZeros(n);
    }

    private static final int countLeadingZeroBits(long l) {
        return Long.numberOfLeadingZeros(l);
    }

    private static final int countOneBits(int n) {
        return Integer.bitCount(n);
    }

    private static final int countOneBits(long l) {
        return Long.bitCount(l);
    }

    private static final int countTrailingZeroBits(int n) {
        return Integer.numberOfTrailingZeros(n);
    }

    private static final int countTrailingZeroBits(long l) {
        return Long.numberOfTrailingZeros(l);
    }

    private static final double fromBits(DoubleCompanionObject doubleCompanionObject, long l) {
        return Double.longBitsToDouble(l);
    }

    private static final float fromBits(FloatCompanionObject floatCompanionObject, int n) {
        return Float.intBitsToFloat(n);
    }

    private static final boolean isFinite(double d) {
        boolean bl = !Double.isInfinite(d) && !Double.isNaN(d);
        return bl;
    }

    private static final boolean isFinite(float f) {
        boolean bl = !Float.isInfinite(f) && !Float.isNaN(f);
        return bl;
    }

    private static final boolean isInfinite(double d) {
        return Double.isInfinite(d);
    }

    private static final boolean isInfinite(float f) {
        return Float.isInfinite(f);
    }

    private static final boolean isNaN(double d) {
        return Double.isNaN(d);
    }

    private static final boolean isNaN(float f) {
        return Float.isNaN(f);
    }

    private static final int rotateLeft(int n, int n2) {
        return Integer.rotateLeft(n, n2);
    }

    private static final long rotateLeft(long l, int n) {
        return Long.rotateLeft(l, n);
    }

    private static final int rotateRight(int n, int n2) {
        return Integer.rotateRight(n, n2);
    }

    private static final long rotateRight(long l, int n) {
        return Long.rotateRight(l, n);
    }

    private static final int takeHighestOneBit(int n) {
        return Integer.highestOneBit(n);
    }

    private static final long takeHighestOneBit(long l) {
        return Long.highestOneBit(l);
    }

    private static final int takeLowestOneBit(int n) {
        return Integer.lowestOneBit(n);
    }

    private static final long takeLowestOneBit(long l) {
        return Long.lowestOneBit(l);
    }

    private static final int toBits(float f) {
        return Float.floatToIntBits(f);
    }

    private static final long toBits(double d) {
        return Double.doubleToLongBits(d);
    }

    private static final int toRawBits(float f) {
        return Float.floatToRawIntBits(f);
    }

    private static final long toRawBits(double d) {
        return Double.doubleToRawLongBits(d);
    }
}
