/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.collections.ArraysKt
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.text.StringsKt
 *  okio.Buffer
 *  okio.ByteString
 *  okio._Base64Kt
 *  okio._JvmPlatformKt
 *  okio._UtilKt
 */
package okio.internal;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okio.Buffer;
import okio.ByteString;
import okio._Base64Kt;
import okio._JvmPlatformKt;
import okio._UtilKt;

@Metadata(d1={"\u0000R\n\u0000\n\u0002\u0010\u0019\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007H\u0002\u001a\u0011\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\tH\u0080\b\u001a\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0010H\u0002\u001a\r\u0010\u0011\u001a\u00020\u0012*\u00020\fH\u0080\b\u001a\r\u0010\u0013\u001a\u00020\u0012*\u00020\fH\u0080\b\u001a\u0015\u0010\u0014\u001a\u00020\u0007*\u00020\f2\u0006\u0010\u0015\u001a\u00020\fH\u0080\b\u001a-\u0010\u0016\u001a\u00020\u0017*\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0007H\u0080\b\u001a\u000f\u0010\u001c\u001a\u0004\u0018\u00010\f*\u00020\u0012H\u0080\b\u001a\r\u0010\u001d\u001a\u00020\f*\u00020\u0012H\u0080\b\u001a\r\u0010\u001e\u001a\u00020\f*\u00020\u0012H\u0080\b\u001a\u0015\u0010\u001f\u001a\u00020 *\u00020\f2\u0006\u0010!\u001a\u00020\tH\u0080\b\u001a\u0015\u0010\u001f\u001a\u00020 *\u00020\f2\u0006\u0010!\u001a\u00020\fH\u0080\b\u001a\u0017\u0010\"\u001a\u00020 *\u00020\f2\b\u0010\u0015\u001a\u0004\u0018\u00010#H\u0080\b\u001a\u0015\u0010$\u001a\u00020%*\u00020\f2\u0006\u0010&\u001a\u00020\u0007H\u0080\b\u001a\r\u0010'\u001a\u00020\u0007*\u00020\fH\u0080\b\u001a\r\u0010(\u001a\u00020\u0007*\u00020\fH\u0080\b\u001a\r\u0010)\u001a\u00020\u0012*\u00020\fH\u0080\b\u001a\u001d\u0010*\u001a\u00020\u0007*\u00020\f2\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010+\u001a\u00020\u0007H\u0080\b\u001a\r\u0010,\u001a\u00020\t*\u00020\fH\u0080\b\u001a\u001d\u0010-\u001a\u00020\u0007*\u00020\f2\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010+\u001a\u00020\u0007H\u0080\b\u001a\u001d\u0010-\u001a\u00020\u0007*\u00020\f2\u0006\u0010\u0015\u001a\u00020\f2\u0006\u0010+\u001a\u00020\u0007H\u0080\b\u001a-\u0010.\u001a\u00020 *\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010/\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0007H\u0080\b\u001a-\u0010.\u001a\u00020 *\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\f2\u0006\u0010/\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0007H\u0080\b\u001a\u0015\u00100\u001a\u00020 *\u00020\f2\u0006\u00101\u001a\u00020\tH\u0080\b\u001a\u0015\u00100\u001a\u00020 *\u00020\f2\u0006\u00101\u001a\u00020\fH\u0080\b\u001a\u001d\u00102\u001a\u00020\f*\u00020\f2\u0006\u00103\u001a\u00020\u00072\u0006\u00104\u001a\u00020\u0007H\u0080\b\u001a\r\u00105\u001a\u00020\f*\u00020\fH\u0080\b\u001a\r\u00106\u001a\u00020\f*\u00020\fH\u0080\b\u001a\r\u00107\u001a\u00020\t*\u00020\fH\u0080\b\u001a\u001d\u00108\u001a\u00020\f*\u00020\t2\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0007H\u0080\b\u001a\r\u00109\u001a\u00020\u0012*\u00020\fH\u0080\b\u001a\r\u0010:\u001a\u00020\u0012*\u00020\fH\u0080\b\u001a$\u0010;\u001a\u00020\u0017*\u00020\f2\u0006\u0010<\u001a\u00020=2\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0007H\u0000\"\u001c\u0010\u0000\u001a\u00020\u00018\u0000X\u0081\u0004\u00a2\u0006\u000e\n\u0000\u0012\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005\u00a8\u0006>"}, d2={"HEX_DIGIT_CHARS", "", "getHEX_DIGIT_CHARS$annotations", "()V", "getHEX_DIGIT_CHARS", "()[C", "codePointIndexToCharIndex", "", "s", "", "codePointCount", "commonOf", "Lokio/ByteString;", "data", "decodeHexDigit", "c", "", "commonBase64", "", "commonBase64Url", "commonCompareTo", "other", "commonCopyInto", "", "offset", "target", "targetOffset", "byteCount", "commonDecodeBase64", "commonDecodeHex", "commonEncodeUtf8", "commonEndsWith", "", "suffix", "commonEquals", "", "commonGetByte", "", "pos", "commonGetSize", "commonHashCode", "commonHex", "commonIndexOf", "fromIndex", "commonInternalArray", "commonLastIndexOf", "commonRangeEquals", "otherOffset", "commonStartsWith", "prefix", "commonSubstring", "beginIndex", "endIndex", "commonToAsciiLowercase", "commonToAsciiUppercase", "commonToByteArray", "commonToByteString", "commonToString", "commonUtf8", "commonWrite", "buffer", "Lokio/Buffer;", "okio"}, k=2, mv={1, 5, 1}, xi=48)
public final class _ByteStringKt {
    private static final char[] HEX_DIGIT_CHARS = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /*
     * Unable to fully structure code
     */
    private static final int codePointIndexToCharIndex(byte[] var0, int var1_1) {
        var8_2 = var0.length;
        var2_3 = 0;
        var3_4 = 0;
        var4_5 = 0;
        block0: while (true) {
            if (var2_3 >= var8_2) return var3_4;
            var6_7 = var0[var2_3];
            if (var6_7 >= 0) {
                var5_6 = var4_5 + 1;
                if (var4_5 == var1_1) {
                    return var3_4;
                }
                if (var6_7 != 10 && var6_7 != 13) {
                    var4_5 = var6_7 >= 0 && var6_7 <= 31 ? 1 : 0;
                    var4_5 = var4_5 == 0 && (var4_5 = 127 <= var6_7 && var6_7 <= 159 ? 1 : 0) == 0 ? 0 : 1;
                    if (var4_5 != 0) return -1;
                }
                if (var6_7 == 65533) {
                    return -1;
                }
            } else {
                if (var6_7 >> 5 == -2) {
                    var5_6 = var2_3 + 1;
                    if (var8_2 <= var5_6) {
                        if (var4_5 != var1_1) return -1;
                        return var3_4;
                    }
                    var6_7 = var0[var2_3];
                    var7_8 = var0[var5_6];
                    if ((var5_6 = (var7_8 & 192) == 128 ? 1 : 0) == 0) {
                        if (var4_5 != var1_1) return -1;
                        return var3_4;
                    }
                    if ((var6_7 = var7_8 ^ 3968 ^ var6_7 << 6) < 128) {
                        if (var4_5 != var1_1) return -1;
                        return var3_4;
                    }
                    var5_6 = var4_5 + 1;
                    if (var4_5 == var1_1) {
                        return var3_4;
                    }
                    if (var6_7 != 10 && var6_7 != 13) {
                        var4_5 = var6_7 >= 0 && var6_7 <= 31 ? 1 : 0;
                        var4_5 = var4_5 == 0 && (var4_5 = 127 <= var6_7 && var6_7 <= 159 ? 1 : 0) == 0 ? 0 : 1;
                        if (var4_5 != 0) return -1;
                    }
                    if (var6_7 == 65533) {
                        return -1;
                    }
                    var4_5 = var6_7 < 65536 ? 1 : 2;
                    var3_4 += var4_5;
                    var11_11 = Unit.INSTANCE;
                    var2_3 += 2;
                    var4_5 = var5_6;
                    continue;
                }
                if (var6_7 >> 4 == -2) {
                    var9_9 = var2_3 + 2;
                    if (var8_2 <= var9_9) {
                        if (var4_5 != var1_1) return -1;
                        return var3_4;
                    }
                    var6_7 = var0[var2_3];
                    var7_8 = var0[var2_3 + 1];
                    var5_6 = (var7_8 & 192) == 128 ? 1 : 0;
                    if (var5_6 == 0) {
                        if (var4_5 != var1_1) return -1;
                        return var3_4;
                    }
                    var5_6 = ((var9_9 = var0[var9_9]) & 192) == 128 ? 1 : 0;
                    if (var5_6 == 0) {
                        if (var4_5 != var1_1) return -1;
                        return var3_4;
                    }
                    if ((var6_7 = var9_9 ^ -123008 ^ var7_8 << 6 ^ var6_7 << 12) < 2048) {
                        if (var4_5 != var1_1) return -1;
                        return var3_4;
                    }
                    var5_6 = 55296 <= var6_7 && var6_7 <= 57343 ? 1 : 0;
                    if (var5_6 != 0) {
                        if (var4_5 != var1_1) return -1;
                        return var3_4;
                    }
                    var5_6 = var4_5 + 1;
                    if (var4_5 == var1_1) {
                        return var3_4;
                    }
                    if (var6_7 != 10 && var6_7 != 13) {
                        var4_5 = var6_7 >= 0 && var6_7 <= 31 ? 1 : 0;
                        var4_5 = var4_5 == 0 && (var4_5 = 127 <= var6_7 && var6_7 <= 159 ? 1 : 0) == 0 ? 0 : 1;
                        if (var4_5 != 0) return -1;
                    }
                    if (var6_7 == 65533) {
                        return -1;
                    }
                    var4_5 = var6_7 < 65536 ? 1 : 2;
                    var3_4 += var4_5;
                    var11_11 = Unit.INSTANCE;
                    var2_3 += 3;
                    var4_5 = var5_6;
                    continue;
                }
                if (var6_7 >> 3 != -2) {
                    if (var4_5 != var1_1) return -1;
                    return var3_4;
                }
                var10_10 = var2_3 + 3;
                if (var8_2 <= var10_10) {
                    if (var4_5 != var1_1) return -1;
                    return var3_4;
                }
                var6_7 = var0[var2_3];
                var7_8 = var0[var2_3 + 1];
                var5_6 = (var7_8 & 192) == 128 ? 1 : 0;
                if (var5_6 == 0) {
                    if (var4_5 != var1_1) return -1;
                    return var3_4;
                }
                var9_9 = var0[var2_3 + 2];
                var5_6 = (var9_9 & 192) == 128 ? 1 : 0;
                if (var5_6 == 0) {
                    if (var4_5 != var1_1) return -1;
                    return var3_4;
                }
                var5_6 = ((var10_10 = var0[var10_10]) & 192) == 128 ? 1 : 0;
                if (var5_6 == 0) {
                    if (var4_5 != var1_1) return -1;
                    return var3_4;
                }
                if ((var6_7 = var10_10 ^ 3678080 ^ var9_9 << 6 ^ var7_8 << 12 ^ var6_7 << 18) > 0x10FFFF) {
                    if (var4_5 != var1_1) return -1;
                    return var3_4;
                }
                var5_6 = 55296 <= var6_7 && var6_7 <= 57343 ? 1 : 0;
                if (var5_6 != 0) {
                    if (var4_5 != var1_1) return -1;
                    return var3_4;
                }
                if (var6_7 < 65536) {
                    if (var4_5 != var1_1) return -1;
                    return var3_4;
                }
                var5_6 = var4_5 + 1;
                if (var4_5 == var1_1) {
                    return var3_4;
                }
                if (var6_7 != 10 && var6_7 != 13) {
                    var4_5 = var6_7 >= 0 && var6_7 <= 31 ? 1 : 0;
                    var4_5 = var4_5 == 0 && (var4_5 = 127 <= var6_7 && var6_7 <= 159 ? 1 : 0) == 0 ? 0 : 1;
                    if (var4_5 != 0) return -1;
                }
                if (var6_7 == 65533) {
                    return -1;
                }
                var4_5 = var6_7 < 65536 ? 1 : 2;
                var3_4 += var4_5;
                var11_11 = Unit.INSTANCE;
                var2_3 += 4;
                var4_5 = var5_6;
                continue;
            }
            var4_5 = var6_7 < 65536 ? 1 : 2;
            var6_7 = var2_3 + 1;
            var2_3 = var5_6;
            var5_6 = var3_4 += var4_5;
            while (true) {
                var7_8 = var2_3;
                var2_3 = var6_7;
                var3_4 = var5_6;
                var4_5 = var7_8;
                if (var6_7 >= var8_2) continue block0;
                var2_3 = var6_7;
                var3_4 = var5_6;
                var4_5 = var7_8;
                if (var0[var6_7] < 0) ** break;
                var4_5 = var0[var6_7];
                var3_4 = var7_8 + 1;
                if (var7_8 == var1_1) {
                    return var5_6;
                }
                if (var4_5 != 10 && var4_5 != 13) {
                    var2_3 = var4_5 >= 0 && var4_5 <= 31 ? 1 : 0;
                    var2_3 = var2_3 == 0 && (var2_3 = 127 <= var4_5 && var4_5 <= 159 ? 1 : 0) == 0 ? 0 : 1;
                    if (var2_3 != 0) return -1;
                }
                if (var4_5 == 65533) {
                    return -1;
                }
                var2_3 = var4_5 < 65536 ? 1 : 2;
                var5_6 += var2_3;
                ++var6_7;
                var2_3 = var3_4;
            }
            break;
        }
    }

    public static final String commonBase64(ByteString byteString) {
        Intrinsics.checkNotNullParameter((Object)byteString, (String)"<this>");
        return _Base64Kt.encodeBase64$default((byte[])byteString.getData$okio(), null, (int)1, null);
    }

    public static final String commonBase64Url(ByteString byteString) {
        Intrinsics.checkNotNullParameter((Object)byteString, (String)"<this>");
        return _Base64Kt.encodeBase64((byte[])byteString.getData$okio(), (byte[])_Base64Kt.getBASE64_URL_SAFE());
    }

    public static final int commonCompareTo(ByteString byteString, ByteString byteString2) {
        int n;
        int n2;
        int n3;
        block2: {
            int n4;
            int n5;
            Intrinsics.checkNotNullParameter((Object)byteString, (String)"<this>");
            Intrinsics.checkNotNullParameter((Object)byteString2, (String)"other");
            n3 = byteString.size();
            n2 = byteString2.size();
            int n6 = Math.min(n3, n2);
            int n7 = 0;
            while (true) {
                n = -1;
                if (n7 >= n6) break block2;
                n5 = byteString.getByte(n7) & 0xFF;
                if (n5 != (n4 = byteString2.getByte(n7) & 0xFF)) break;
                ++n7;
            }
            if (n5 < n4) return n;
            n = 1;
            return n;
        }
        if (n3 == n2) {
            return 0;
        }
        if (n3 < n2) return n;
        n = 1;
        return n;
    }

    public static final void commonCopyInto(ByteString byteString, int n, byte[] byArray, int n2, int n3) {
        Intrinsics.checkNotNullParameter((Object)byteString, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)byArray, (String)"target");
        ArraysKt.copyInto((byte[])byteString.getData$okio(), (byte[])byArray, (int)n2, (int)n, (int)(n3 + n));
    }

    public static final ByteString commonDecodeBase64(String object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"<this>");
        object = _Base64Kt.decodeBase64ToArray((String)object);
        object = object != null ? new ByteString((byte[])object) : null;
        return object;
    }

    public static final ByteString commonDecodeHex(String object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"<this>");
        int n = ((String)object).length();
        int n2 = 0;
        n = n % 2 == 0 ? 1 : 0;
        if (n == 0) {
            object = new IllegalArgumentException(Intrinsics.stringPlus((String)"Unexpected hex string: ", (Object)object).toString());
            throw object;
        }
        n = ((String)object).length() / 2;
        byte[] byArray = new byte[n];
        int n3 = n - 1;
        if (n3 < 0) return new ByteString(byArray);
        n = n2;
        while (true) {
            n2 = n + 1;
            int n4 = n * 2;
            byArray[n] = (byte)((_ByteStringKt.decodeHexDigit(((String)object).charAt(n4)) << 4) + _ByteStringKt.decodeHexDigit(((String)object).charAt(n4 + 1)));
            if (n2 > n3) {
                return new ByteString(byArray);
            }
            n = n2;
        }
    }

    public static final ByteString commonEncodeUtf8(String string) {
        Intrinsics.checkNotNullParameter((Object)string, (String)"<this>");
        ByteString byteString = new ByteString(_JvmPlatformKt.asUtf8ToByteArray((String)string));
        byteString.setUtf8$okio(string);
        return byteString;
    }

    public static final boolean commonEndsWith(ByteString byteString, ByteString byteString2) {
        Intrinsics.checkNotNullParameter((Object)byteString, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)byteString2, (String)"suffix");
        return byteString.rangeEquals(byteString.size() - byteString2.size(), byteString2, 0, byteString2.size());
    }

    public static final boolean commonEndsWith(ByteString byteString, byte[] byArray) {
        Intrinsics.checkNotNullParameter((Object)byteString, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)byArray, (String)"suffix");
        return byteString.rangeEquals(byteString.size() - byArray.length, byArray, 0, byArray.length);
    }

    public static final boolean commonEquals(ByteString byteString, Object object) {
        Intrinsics.checkNotNullParameter((Object)byteString, (String)"<this>");
        boolean bl = true;
        if (object == byteString || object instanceof ByteString && (object = (ByteString)object).size() == byteString.getData$okio().length && object.rangeEquals(0, byteString.getData$okio(), 0, byteString.getData$okio().length)) return bl;
        bl = false;
        return bl;
    }

    public static final byte commonGetByte(ByteString byteString, int n) {
        Intrinsics.checkNotNullParameter((Object)byteString, (String)"<this>");
        return byteString.getData$okio()[n];
    }

    public static final int commonGetSize(ByteString byteString) {
        Intrinsics.checkNotNullParameter((Object)byteString, (String)"<this>");
        return byteString.getData$okio().length;
    }

    public static final int commonHashCode(ByteString byteString) {
        Intrinsics.checkNotNullParameter((Object)byteString, (String)"<this>");
        int n = byteString.getHashCode$okio();
        if (n != 0) {
            return n;
        }
        n = Arrays.hashCode(byteString.getData$okio());
        byteString.setHashCode$okio(n);
        return n;
    }

    public static final String commonHex(ByteString object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"<this>");
        char[] cArray = new char[object.getData$okio().length * 2];
        object = object.getData$okio();
        int n = ((ByteString)object).length;
        int n2 = 0;
        int n3 = 0;
        while (n2 < n) {
            ByteString byteString = object[n2];
            ++n2;
            int n4 = n3 + 1;
            cArray[n3] = _ByteStringKt.getHEX_DIGIT_CHARS()[byteString >> 4 & 0xF];
            n3 = n4 + 1;
            cArray[n4] = _ByteStringKt.getHEX_DIGIT_CHARS()[byteString & 0xF];
        }
        return StringsKt.concatToString((char[])cArray);
    }

    public static final int commonIndexOf(ByteString byteString, byte[] byArray, int n) {
        Intrinsics.checkNotNullParameter((Object)byteString, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)byArray, (String)"other");
        int n2 = byteString.getData$okio().length - byArray.length;
        n = Math.max(n, 0);
        if (n > n2) return -1;
        while (!_UtilKt.arrayRangeEquals((byte[])byteString.getData$okio(), (int)n, (byte[])byArray, (int)0, (int)byArray.length)) {
            if (n == n2) {
                return -1;
            }
            ++n;
        }
        return n;
    }

    public static final byte[] commonInternalArray(ByteString byteString) {
        Intrinsics.checkNotNullParameter((Object)byteString, (String)"<this>");
        return byteString.getData$okio();
    }

    public static final int commonLastIndexOf(ByteString byteString, ByteString byteString2, int n) {
        Intrinsics.checkNotNullParameter((Object)byteString, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)byteString2, (String)"other");
        return byteString.lastIndexOf(byteString2.internalArray$okio(), n);
    }

    public static final int commonLastIndexOf(ByteString byteString, byte[] byArray, int n) {
        Intrinsics.checkNotNullParameter((Object)byteString, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)byArray, (String)"other");
        n = Math.min(_UtilKt.resolveDefaultParameter((ByteString)byteString, (int)n), byteString.getData$okio().length - byArray.length);
        if (n < 0) return -1;
        while (true) {
            int n2 = n - 1;
            if (_UtilKt.arrayRangeEquals((byte[])byteString.getData$okio(), (int)n, (byte[])byArray, (int)0, (int)byArray.length)) {
                return n;
            }
            if (n2 < 0) {
                return -1;
            }
            n = n2;
        }
    }

    public static final ByteString commonOf(byte[] byArray) {
        Intrinsics.checkNotNullParameter((Object)byArray, (String)"data");
        byArray = Arrays.copyOf(byArray, byArray.length);
        Intrinsics.checkNotNullExpressionValue((Object)byArray, (String)"java.util.Arrays.copyOf(this, size)");
        return new ByteString(byArray);
    }

    public static final boolean commonRangeEquals(ByteString byteString, int n, ByteString byteString2, int n2, int n3) {
        Intrinsics.checkNotNullParameter((Object)byteString, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)byteString2, (String)"other");
        return byteString2.rangeEquals(n2, byteString.getData$okio(), n, n3);
    }

    public static final boolean commonRangeEquals(ByteString byteString, int n, byte[] byArray, int n2, int n3) {
        Intrinsics.checkNotNullParameter((Object)byteString, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)byArray, (String)"other");
        boolean bl = n >= 0 && n <= byteString.getData$okio().length - n3 && n2 >= 0 && n2 <= byArray.length - n3 && _UtilKt.arrayRangeEquals((byte[])byteString.getData$okio(), (int)n, (byte[])byArray, (int)n2, (int)n3);
        return bl;
    }

    public static final boolean commonStartsWith(ByteString byteString, ByteString byteString2) {
        Intrinsics.checkNotNullParameter((Object)byteString, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)byteString2, (String)"prefix");
        return byteString.rangeEquals(0, byteString2, 0, byteString2.size());
    }

    public static final boolean commonStartsWith(ByteString byteString, byte[] byArray) {
        Intrinsics.checkNotNullParameter((Object)byteString, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)byArray, (String)"prefix");
        return byteString.rangeEquals(0, byArray, 0, byArray.length);
    }

    public static final ByteString commonSubstring(ByteString byteString, int n, int n2) {
        Intrinsics.checkNotNullParameter((Object)byteString, (String)"<this>");
        int n3 = _UtilKt.resolveDefaultParameter((ByteString)byteString, (int)n2);
        int n4 = 1;
        n2 = n >= 0 ? 1 : 0;
        if (n2 == 0) throw (Throwable)new IllegalArgumentException("beginIndex < 0".toString());
        n2 = n3 <= byteString.getData$okio().length ? 1 : 0;
        if (n2 == 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("endIndex > length(");
            stringBuilder.append(byteString.getData$okio().length);
            stringBuilder.append(')');
            throw (Throwable)new IllegalArgumentException(stringBuilder.toString().toString());
        }
        n2 = n3 - n >= 0 ? n4 : 0;
        if (n2 == 0) throw (Throwable)new IllegalArgumentException("endIndex < beginIndex".toString());
        if (n != 0) return new ByteString(ArraysKt.copyOfRange((byte[])byteString.getData$okio(), (int)n, (int)n3));
        if (n3 != byteString.getData$okio().length) return new ByteString(ArraysKt.copyOfRange((byte[])byteString.getData$okio(), (int)n, (int)n3));
        return byteString;
    }

    public static final ByteString commonToAsciiLowercase(ByteString object) {
        byte by;
        byte by2;
        byte by3;
        int n;
        block4: {
            Intrinsics.checkNotNullParameter((Object)object, (String)"<this>");
            n = 0;
            while (n < object.getData$okio().length) {
                by3 = object.getData$okio()[n];
                if (by3 < (by2 = (byte)65) || by3 > (by = (byte)90)) {
                    ++n;
                    continue;
                }
                break block4;
            }
            return object;
        }
        object = object.getData$okio();
        object = Arrays.copyOf((byte[])object, ((ByteString)object).length);
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"java.util.Arrays.copyOf(this, size)");
        Object object2 = n + 1;
        object[n] = (ByteString)((byte)(by3 + 32));
        n = object2;
        while (n < ((ByteString)object).length) {
            object2 = object[n];
            if (object2 >= by2 && object2 <= by) {
                object[n] = (ByteString)((byte)(object2 + 32));
            }
            ++n;
        }
        return new ByteString((byte[])object);
    }

    public static final ByteString commonToAsciiUppercase(ByteString object) {
        byte by;
        byte by2;
        byte by3;
        int n;
        block4: {
            Intrinsics.checkNotNullParameter((Object)object, (String)"<this>");
            n = 0;
            while (n < object.getData$okio().length) {
                by3 = object.getData$okio()[n];
                if (by3 < (by2 = (byte)97) || by3 > (by = (byte)122)) {
                    ++n;
                    continue;
                }
                break block4;
            }
            return object;
        }
        object = object.getData$okio();
        object = Arrays.copyOf((byte[])object, ((ByteString)object).length);
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"java.util.Arrays.copyOf(this, size)");
        Object object2 = n + 1;
        object[n] = (ByteString)((byte)(by3 - 32));
        n = object2;
        while (n < ((ByteString)object).length) {
            object2 = object[n];
            if (object2 >= by2 && object2 <= by) {
                object[n] = (ByteString)((byte)(object2 - 32));
            }
            ++n;
        }
        return new ByteString((byte[])object);
    }

    public static final byte[] commonToByteArray(ByteString object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"<this>");
        object = object.getData$okio();
        object = Arrays.copyOf((byte[])object, ((ByteString)object).length);
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"java.util.Arrays.copyOf(this, size)");
        return object;
    }

    public static final ByteString commonToByteString(byte[] byArray, int n, int n2) {
        Intrinsics.checkNotNullParameter((Object)byArray, (String)"<this>");
        _UtilKt.checkOffsetAndCount((long)byArray.length, (long)n, (long)n2);
        return new ByteString(ArraysKt.copyOfRange((byte[])byArray, (int)n, (int)(n2 + n)));
    }

    public static final String commonToString(ByteString object) {
        Object object2 = object;
        Intrinsics.checkNotNullParameter((Object)object2, (String)"<this>");
        int n = object.getData$okio().length;
        int n2 = 1;
        n = n == 0 ? 1 : 0;
        if (n != 0) {
            return "[size=0]";
        }
        n = _ByteStringKt.codePointIndexToCharIndex(object.getData$okio(), 64);
        if (n == -1) {
            if (object.getData$okio().length <= 64) {
                object2 = new StringBuilder();
                ((StringBuilder)object2).append("[hex=");
                ((StringBuilder)object2).append(object.hex());
                ((StringBuilder)object2).append(']');
                object = ((StringBuilder)object2).toString();
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("[size=");
                stringBuilder.append(object.getData$okio().length);
                stringBuilder.append(" hex=");
                int n3 = _UtilKt.resolveDefaultParameter((ByteString)object2, (int)64);
                n = n3 <= object.getData$okio().length ? 1 : 0;
                if (n == 0) {
                    object2 = new StringBuilder();
                    ((StringBuilder)object2).append("endIndex > length(");
                    ((StringBuilder)object2).append(object.getData$okio().length);
                    ((StringBuilder)object2).append(')');
                    throw (Throwable)new IllegalArgumentException(((StringBuilder)object2).toString().toString());
                }
                n = n3 + 0 >= 0 ? n2 : 0;
                if (n == 0) throw (Throwable)new IllegalArgumentException("endIndex < beginIndex".toString());
                if (n3 != object.getData$okio().length) {
                    object2 = new ByteString(ArraysKt.copyOfRange((byte[])object.getData$okio(), (int)0, (int)n3));
                }
                stringBuilder.append(object2.hex());
                stringBuilder.append("\u2026]");
                object = stringBuilder.toString();
            }
            return object;
        }
        CharSequence charSequence = object.utf8();
        if (charSequence == null) throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        object2 = ((String)charSequence).substring(0, n);
        Intrinsics.checkNotNullExpressionValue((Object)object2, (String)"(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
        object2 = StringsKt.replace$default((String)StringsKt.replace$default((String)StringsKt.replace$default((String)object2, (String)"\\", (String)"\\\\", (boolean)false, (int)4, null), (String)"\n", (String)"\\n", (boolean)false, (int)4, null), (String)"\r", (String)"\\r", (boolean)false, (int)4, null);
        if (n < ((String)charSequence).length()) {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append("[size=");
            ((StringBuilder)charSequence).append(object.getData$okio().length);
            ((StringBuilder)charSequence).append(" text=");
            ((StringBuilder)charSequence).append((String)object2);
            ((StringBuilder)charSequence).append("\u2026]");
            object = ((StringBuilder)charSequence).toString();
        } else {
            object = new StringBuilder();
            ((StringBuilder)object).append("[text=");
            ((StringBuilder)object).append((String)object2);
            ((StringBuilder)object).append(']');
            object = ((StringBuilder)object).toString();
        }
        return object;
    }

    public static final String commonUtf8(ByteString byteString) {
        String string;
        Intrinsics.checkNotNullParameter((Object)byteString, (String)"<this>");
        String string2 = string = byteString.getUtf8$okio();
        if (string != null) return string2;
        string2 = _JvmPlatformKt.toUtf8String((byte[])byteString.internalArray$okio());
        byteString.setUtf8$okio(string2);
        return string2;
    }

    public static final void commonWrite(ByteString byteString, Buffer buffer, int n, int n2) {
        Intrinsics.checkNotNullParameter((Object)byteString, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)buffer, (String)"buffer");
        buffer.write(byteString.getData$okio(), n, n2);
    }

    private static final int decodeHexDigit(char c) {
        int n = 1;
        int n2 = '0' <= c && c <= '9' ? 1 : 0;
        if (n2 != 0) {
            n2 = c - 48;
        } else {
            int n3 = 97;
            n2 = 'a' <= c && c <= 'f' ? 1 : 0;
            if (n2 != 0) {
                n2 = n3;
            } else {
                n3 = 65;
                n2 = 'A' <= c && c <= 'F' ? n : 0;
                if (n2 == 0) {
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException(Intrinsics.stringPlus((String)"Unexpected hex digit: ", (Object)Character.valueOf(c)));
                    throw illegalArgumentException;
                }
                n2 = n3;
            }
            n2 = c - n2 + 10;
        }
        return n2;
    }

    public static final char[] getHEX_DIGIT_CHARS() {
        return HEX_DIGIT_CHARS;
    }

    public static /* synthetic */ void getHEX_DIGIT_CHARS$annotations() {
    }
}
