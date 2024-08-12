/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.text.StringsKt
 *  okio.Buffer$UnsafeCursor
 *  okio.ByteString
 *  okio.internal._ByteStringKt
 */
package okio;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okio.Buffer;
import okio.ByteString;
import okio.internal._ByteStringKt;

@Metadata(d1={"\u0000N\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a0\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u0001H\u0000\u001a \u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020\u0015H\u0000\u001a\u0019\u0010\u0017\u001a\u00020\u00152\u0006\u0010\f\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0015H\u0080\b\u001a\u0019\u0010\u0017\u001a\u00020\u00152\u0006\u0010\f\u001a\u00020\u00152\u0006\u0010\u000f\u001a\u00020\u0001H\u0080\b\u001a\u0010\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0005H\u0000\u001a\u0015\u0010\u001a\u001a\u00020\u0001*\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0001H\u0080\f\u001a\u0015\u0010\u001a\u001a\u00020\u0015*\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0015H\u0080\f\u001a\u0015\u0010\u001a\u001a\u00020\u0015*\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u0015H\u0080\f\u001a\u0015\u0010\u001d\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u001e\u001a\u00020\u0001H\u0080\f\u001a\u0014\u0010\u0018\u001a\u00020\u0001*\u00020\u001f2\u0006\u0010 \u001a\u00020\u0001H\u0000\u001a\f\u0010!\u001a\u00020\u0001*\u00020\u0001H\u0000\u001a\f\u0010!\u001a\u00020\u0015*\u00020\u0015H\u0000\u001a\f\u0010!\u001a\u00020\"*\u00020\"H\u0000\u001a\u0015\u0010#\u001a\u00020\u0015*\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u0001H\u0080\f\u001a\u0015\u0010$\u001a\u00020\u0001*\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0001H\u0080\f\u001a\u0015\u0010%\u001a\u00020\u0001*\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0001H\u0080\f\u001a\f\u0010&\u001a\u00020'*\u00020\u001bH\u0000\u001a\f\u0010&\u001a\u00020'*\u00020\u0001H\u0000\u001a\f\u0010&\u001a\u00020'*\u00020\u0015H\u0000\u001a\u0015\u0010(\u001a\u00020\u001b*\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001bH\u0080\f\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u001c\u0010\u0004\u001a\u00020\u00058\u0000X\u0081\u0004\u00a2\u0006\u000e\n\u0000\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\u00a8\u0006)"}, d2={"DEFAULT__ByteString_size", "", "getDEFAULT__ByteString_size", "()I", "DEFAULT__new_UnsafeCursor", "Lokio/Buffer$UnsafeCursor;", "getDEFAULT__new_UnsafeCursor$annotations", "()V", "getDEFAULT__new_UnsafeCursor", "()Lokio/Buffer$UnsafeCursor;", "arrayRangeEquals", "", "a", "", "aOffset", "b", "bOffset", "byteCount", "checkOffsetAndCount", "", "size", "", "offset", "minOf", "resolveDefaultParameter", "unsafeCursor", "and", "", "other", "leftRotate", "bitCount", "Lokio/ByteString;", "position", "reverseBytes", "", "rightRotate", "shl", "shr", "toHexString", "", "xor", "okio"}, k=2, mv={1, 5, 1}, xi=48)
public final class _UtilKt {
    private static final int DEFAULT__ByteString_size;
    private static final Buffer.UnsafeCursor DEFAULT__new_UnsafeCursor;

    static {
        DEFAULT__new_UnsafeCursor = new Buffer.UnsafeCursor();
        DEFAULT__ByteString_size = -1234567890;
    }

    public static final int and(byte by, int n) {
        return by & n;
    }

    public static final long and(byte by, long l) {
        return l & (long)by;
    }

    public static final long and(int n, long l) {
        return l & (long)n;
    }

    public static final boolean arrayRangeEquals(byte[] byArray, int n, byte[] byArray2, int n2, int n3) {
        Intrinsics.checkNotNullParameter((Object)byArray, (String)"a");
        Intrinsics.checkNotNullParameter((Object)byArray2, (String)"b");
        if (n3 <= 0) return true;
        int n4 = 0;
        while (true) {
            int n5 = n4 + 1;
            if (byArray[n4 + n] != byArray2[n4 + n2]) {
                return false;
            }
            if (n5 >= n3) {
                return true;
            }
            n4 = n5;
        }
    }

    public static final void checkOffsetAndCount(long l, long l2, long l3) {
        if ((l2 | l3) >= 0L && l2 <= l && l - l2 >= l3) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("size=");
        stringBuilder.append(l);
        stringBuilder.append(" offset=");
        stringBuilder.append(l2);
        stringBuilder.append(" byteCount=");
        stringBuilder.append(l3);
        throw new ArrayIndexOutOfBoundsException(stringBuilder.toString());
    }

    public static final int getDEFAULT__ByteString_size() {
        return DEFAULT__ByteString_size;
    }

    public static final Buffer.UnsafeCursor getDEFAULT__new_UnsafeCursor() {
        return DEFAULT__new_UnsafeCursor;
    }

    public static /* synthetic */ void getDEFAULT__new_UnsafeCursor$annotations() {
    }

    public static final int leftRotate(int n, int n2) {
        return n >>> 32 - n2 | n << n2;
    }

    public static final long minOf(int n, long l) {
        return Math.min((long)n, l);
    }

    public static final long minOf(long l, int n) {
        return Math.min(l, (long)n);
    }

    public static final int resolveDefaultParameter(ByteString byteString, int n) {
        Intrinsics.checkNotNullParameter((Object)byteString, (String)"<this>");
        if (n != DEFAULT__ByteString_size) return n;
        return byteString.size();
    }

    public static final Buffer.UnsafeCursor resolveDefaultParameter(Buffer.UnsafeCursor unsafeCursor) {
        Intrinsics.checkNotNullParameter((Object)unsafeCursor, (String)"unsafeCursor");
        Buffer.UnsafeCursor unsafeCursor2 = unsafeCursor;
        if (unsafeCursor != DEFAULT__new_UnsafeCursor) return unsafeCursor2;
        unsafeCursor2 = new Buffer.UnsafeCursor();
        return unsafeCursor2;
    }

    public static final int reverseBytes(int n) {
        return (n & 0xFF) << 24 | ((0xFF000000 & n) >>> 24 | (0xFF0000 & n) >>> 8 | (0xFF00 & n) << 8);
    }

    public static final long reverseBytes(long l) {
        return (l & 0xFFL) << 56 | ((0xFF00000000000000L & l) >>> 56 | (0xFF000000000000L & l) >>> 40 | (0xFF0000000000L & l) >>> 24 | (0xFF00000000L & l) >>> 8 | (0xFF000000L & l) << 8 | (0xFF0000L & l) << 24 | (0xFF00L & l) << 40);
    }

    public static final short reverseBytes(short s) {
        s = (short)(s & 0xFFFF);
        return (short)((s & 0xFF) << 8 | (0xFF00 & s) >>> 8);
    }

    public static final long rightRotate(long l, int n) {
        return l << 64 - n | l >>> n;
    }

    public static final int shl(byte by, int n) {
        return by << n;
    }

    public static final int shr(byte by, int n) {
        return by >> n;
    }

    public static final String toHexString(byte by) {
        return StringsKt.concatToString((char[])new char[]{_ByteStringKt.getHEX_DIGIT_CHARS()[by >> 4 & 0xF], _ByteStringKt.getHEX_DIGIT_CHARS()[by & 0xF]});
    }

    public static final String toHexString(int n) {
        if (n == 0) {
            return "0";
        }
        char[] cArray = new char[8];
        char c = _ByteStringKt.getHEX_DIGIT_CHARS()[n >> 28 & 0xF];
        int n2 = 0;
        cArray[0] = c;
        cArray[1] = _ByteStringKt.getHEX_DIGIT_CHARS()[n >> 24 & 0xF];
        cArray[2] = _ByteStringKt.getHEX_DIGIT_CHARS()[n >> 20 & 0xF];
        cArray[3] = _ByteStringKt.getHEX_DIGIT_CHARS()[n >> 16 & 0xF];
        cArray[4] = _ByteStringKt.getHEX_DIGIT_CHARS()[n >> 12 & 0xF];
        cArray[5] = _ByteStringKt.getHEX_DIGIT_CHARS()[n >> 8 & 0xF];
        cArray[6] = _ByteStringKt.getHEX_DIGIT_CHARS()[n >> 4 & 0xF];
        cArray[7] = _ByteStringKt.getHEX_DIGIT_CHARS()[n & 0xF];
        n = n2;
        while (n < 8) {
            if (cArray[n] != '0') {
                return StringsKt.concatToString((char[])cArray, (int)n, (int)8);
            }
            ++n;
        }
        return StringsKt.concatToString((char[])cArray, (int)n, (int)8);
    }

    public static final String toHexString(long l) {
        if (l == 0L) {
            return "0";
        }
        char[] cArray = new char[16];
        char c = _ByteStringKt.getHEX_DIGIT_CHARS()[(int)(l >> 60 & 0xFL)];
        int n = 0;
        cArray[0] = c;
        cArray[1] = _ByteStringKt.getHEX_DIGIT_CHARS()[(int)(l >> 56 & 0xFL)];
        cArray[2] = _ByteStringKt.getHEX_DIGIT_CHARS()[(int)(l >> 52 & 0xFL)];
        cArray[3] = _ByteStringKt.getHEX_DIGIT_CHARS()[(int)(l >> 48 & 0xFL)];
        cArray[4] = _ByteStringKt.getHEX_DIGIT_CHARS()[(int)(l >> 44 & 0xFL)];
        cArray[5] = _ByteStringKt.getHEX_DIGIT_CHARS()[(int)(l >> 40 & 0xFL)];
        cArray[6] = _ByteStringKt.getHEX_DIGIT_CHARS()[(int)(l >> 36 & 0xFL)];
        cArray[7] = _ByteStringKt.getHEX_DIGIT_CHARS()[(int)(l >> 32 & 0xFL)];
        cArray[8] = _ByteStringKt.getHEX_DIGIT_CHARS()[(int)(l >> 28 & 0xFL)];
        cArray[9] = _ByteStringKt.getHEX_DIGIT_CHARS()[(int)(l >> 24 & 0xFL)];
        cArray[10] = _ByteStringKt.getHEX_DIGIT_CHARS()[(int)(l >> 20 & 0xFL)];
        cArray[11] = _ByteStringKt.getHEX_DIGIT_CHARS()[(int)(l >> 16 & 0xFL)];
        cArray[12] = _ByteStringKt.getHEX_DIGIT_CHARS()[(int)(l >> 12 & 0xFL)];
        cArray[13] = _ByteStringKt.getHEX_DIGIT_CHARS()[(int)(l >> 8 & 0xFL)];
        cArray[14] = _ByteStringKt.getHEX_DIGIT_CHARS()[(int)(l >> 4 & 0xFL)];
        cArray[15] = _ByteStringKt.getHEX_DIGIT_CHARS()[(int)(l & 0xFL)];
        while (n < 16) {
            if (cArray[n] != '0') {
                return StringsKt.concatToString((char[])cArray, (int)n, (int)16);
            }
            ++n;
        }
        return StringsKt.concatToString((char[])cArray, (int)n, (int)16);
    }

    public static final byte xor(byte by, byte by2) {
        return (byte)(by ^ by2);
    }
}
