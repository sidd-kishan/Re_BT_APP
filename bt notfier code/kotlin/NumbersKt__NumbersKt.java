/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.NumbersKt__NumbersJVMKt
 */
package kotlin;

import kotlin.Metadata;
import kotlin.NumbersKt__NumbersJVMKt;

@Metadata(d1={"\u0000\u0012\n\u0000\n\u0002\u0010\b\n\u0002\u0010\u0005\n\u0002\u0010\n\n\u0002\b\b\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0087\b\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0003H\u0087\b\u001a\r\u0010\u0004\u001a\u00020\u0001*\u00020\u0002H\u0087\b\u001a\r\u0010\u0004\u001a\u00020\u0001*\u00020\u0003H\u0087\b\u001a\r\u0010\u0005\u001a\u00020\u0001*\u00020\u0002H\u0087\b\u001a\r\u0010\u0005\u001a\u00020\u0001*\u00020\u0003H\u0087\b\u001a\u0014\u0010\u0006\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0001H\u0007\u001a\u0014\u0010\u0006\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0001H\u0007\u001a\u0014\u0010\b\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0001H\u0007\u001a\u0014\u0010\b\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0001H\u0007\u001a\r\u0010\t\u001a\u00020\u0002*\u00020\u0002H\u0087\b\u001a\r\u0010\t\u001a\u00020\u0003*\u00020\u0003H\u0087\b\u001a\r\u0010\n\u001a\u00020\u0002*\u00020\u0002H\u0087\b\u001a\r\u0010\n\u001a\u00020\u0003*\u00020\u0003H\u0087\b\u00a8\u0006\u000b"}, d2={"countLeadingZeroBits", "", "", "", "countOneBits", "countTrailingZeroBits", "rotateLeft", "bitCount", "rotateRight", "takeHighestOneBit", "takeLowestOneBit", "kotlin-stdlib"}, k=5, mv={1, 5, 1}, xi=1, xs="kotlin/NumbersKt")
class NumbersKt__NumbersKt
extends NumbersKt__NumbersJVMKt {
    private static final int countLeadingZeroBits(byte by) {
        return Integer.numberOfLeadingZeros(by & 0xFF) - 24;
    }

    private static final int countLeadingZeroBits(short s) {
        return Integer.numberOfLeadingZeros(s & 0xFFFF) - 16;
    }

    private static final int countOneBits(byte by) {
        return Integer.bitCount(by & 0xFF);
    }

    private static final int countOneBits(short s) {
        return Integer.bitCount(s & 0xFFFF);
    }

    private static final int countTrailingZeroBits(byte by) {
        return Integer.numberOfTrailingZeros(by | 0x100);
    }

    private static final int countTrailingZeroBits(short s) {
        return Integer.numberOfTrailingZeros(s | 0x10000);
    }

    public static final byte rotateLeft(byte by, int n) {
        return (byte)((by & 0xFF) >>> 8 - (n &= 7) | by << n);
    }

    public static final short rotateLeft(short s, int n) {
        return (short)((s & 0xFFFF) >>> 16 - (n &= 0xF) | s << n);
    }

    public static final byte rotateRight(byte by, int n) {
        return (byte)((by & 0xFF) >>> (n &= 7) | by << 8 - n);
    }

    public static final short rotateRight(short s, int n) {
        return (short)((s & 0xFFFF) >>> (n &= 0xF) | s << 16 - n);
    }

    private static final byte takeHighestOneBit(byte by) {
        return (byte)Integer.highestOneBit(by & 0xFF);
    }

    private static final short takeHighestOneBit(short s) {
        return (short)Integer.highestOneBit(s & 0xFFFF);
    }

    private static final byte takeLowestOneBit(byte by) {
        return (byte)Integer.lowestOneBit(by);
    }

    private static final short takeLowestOneBit(short s) {
        return (short)Integer.lowestOneBit(s);
    }
}
