/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  okio.ByteString
 *  okio._JvmPlatformKt
 */
package okio;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;
import okio._JvmPlatformKt;

@Metadata(d1={"\u0000\u0012\n\u0000\n\u0002\u0010\u0012\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u000e\u0010\t\u001a\u0004\u0018\u00010\u0001*\u00020\nH\u0000\u001a\u0016\u0010\u000b\u001a\u00020\n*\u00020\u00012\b\b\u0002\u0010\f\u001a\u00020\u0001H\u0000\"\u001c\u0010\u0000\u001a\u00020\u00018\u0000X\u0081\u0004\u00a2\u0006\u000e\n\u0000\u0012\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005\"\u001c\u0010\u0006\u001a\u00020\u00018\u0000X\u0081\u0004\u00a2\u0006\u000e\n\u0000\u0012\u0004\b\u0007\u0010\u0003\u001a\u0004\b\b\u0010\u0005\u00a8\u0006\r"}, d2={"BASE64", "", "getBASE64$annotations", "()V", "getBASE64", "()[B", "BASE64_URL_SAFE", "getBASE64_URL_SAFE$annotations", "getBASE64_URL_SAFE", "decodeBase64ToArray", "", "encodeBase64", "map", "okio"}, k=2, mv={1, 5, 1}, xi=48)
public final class _Base64Kt {
    private static final byte[] BASE64 = ByteString.Companion.encodeUtf8("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/").getData$okio();
    private static final byte[] BASE64_URL_SAFE = ByteString.Companion.encodeUtf8("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_").getData$okio();

    public static final byte[] decodeBase64ToArray(String object) {
        int n;
        int n2;
        byte[] byArray;
        int n3;
        int n4;
        block10: {
            int n5;
            block9: {
                Intrinsics.checkNotNullParameter((Object)object, (String)"<this>");
                for (n5 = ((String)object).length(); n5 > 0 && ((n4 = ((String)object).charAt(n5 - 1)) == 61 || n4 == 10 || n4 == 13 || n4 == 32 || n4 == 9); --n5) {
                }
                n3 = (int)((long)n5 * 6L / 8L);
                byArray = new byte[n3];
                if (n5 > 0) break block9;
                n2 = 0;
                n4 = 0;
                n = 0;
                break block10;
            }
            int n6 = 0;
            int n7 = 0;
            int n8 = 0;
            int n9 = 0;
            while (true) {
                int n10;
                block17: {
                    block12: {
                        block15: {
                            block16: {
                                block14: {
                                    block13: {
                                        block11: {
                                            n10 = n6 + 1;
                                            n4 = 65 <= (n6 = (int)((String)object).charAt(n6)) && n6 <= 90 ? 1 : 0;
                                            if (n4 == 0) break block11;
                                            n4 = n6 - 65;
                                            break block12;
                                        }
                                        n4 = 97 <= n6 && n6 <= 122 ? 1 : 0;
                                        if (n4 == 0) break block13;
                                        n4 = n6 - 71;
                                        break block12;
                                    }
                                    n4 = 48 <= n6 && n6 <= 57 ? 1 : 0;
                                    if (n4 == 0) break block14;
                                    n4 = n6 + 4;
                                    break block12;
                                }
                                if (n6 == 43 || n6 == 45) break block15;
                                if (n6 == 47 || n6 == 95) break block16;
                                n4 = n7;
                                n2 = n8;
                                n = n9;
                                if (n6 == 10) break block17;
                                n4 = n7;
                                n2 = n8;
                                n = n9;
                                if (n6 != 13) {
                                    n4 = n7;
                                    n2 = n8;
                                    n = n9;
                                    if (n6 != 32) {
                                        if (n6 != 9) return null;
                                        n4 = n7;
                                        n2 = n8;
                                        n = n9;
                                    }
                                }
                                break block17;
                            }
                            n4 = 63;
                            break block12;
                        }
                        n4 = 62;
                    }
                    n9 = n9 << 6 | n4;
                    n4 = n7;
                    n2 = ++n8;
                    n = n9;
                    if (n8 % 4 == 0) {
                        n4 = n7 + 1;
                        byArray[n7] = (byte)(n9 >> 16);
                        n = n4 + 1;
                        byArray[n4] = (byte)(n9 >> 8);
                        n4 = n + 1;
                        byArray[n] = (byte)n9;
                        n = n9;
                        n2 = n8;
                    }
                }
                if (n10 >= n5) break;
                n6 = n10;
                n7 = n4;
                n8 = n2;
                n9 = n;
            }
        }
        if ((n2 %= 4) == 1) return null;
        if (n2 != 2) {
            if (n2 == 3) {
                n2 = n4 + '\u0001';
                byArray[n4] = (byte)((n <<= 6) >> 16);
                n4 = n2 + 1;
                byArray[n2] = (byte)(n >> 8);
            }
        } else {
            byArray[n4] = (byte)(n << 12 >> 16);
            ++n4;
        }
        if (n4 == n3) {
            return byArray;
        }
        object = Arrays.copyOf(byArray, n4);
        Intrinsics.checkNotNullExpressionValue((Object)object, (String)"java.util.Arrays.copyOf(this, newSize)");
        return object;
    }

    public static final String encodeBase64(byte[] byArray, byte[] byArray2) {
        int n;
        int n2;
        Intrinsics.checkNotNullParameter((Object)byArray, (String)"<this>");
        Intrinsics.checkNotNullParameter((Object)byArray2, (String)"map");
        byte[] byArray3 = new byte[(byArray.length + 2) / 3 * 4];
        int n3 = byArray.length - byArray.length % 3;
        int n4 = 0;
        for (n2 = 0; n2 < n3; ++n2) {
            n = n2 + 1;
            int n5 = byArray[n2];
            n2 = n + 1;
            byte by = byArray[n];
            n = byArray[n2];
            int n6 = n4 + 1;
            byArray3[n4] = byArray2[(n5 & 0xFF) >> 2];
            n4 = n6 + 1;
            byArray3[n6] = byArray2[(n5 & 3) << 4 | (by & 0xFF) >> 4];
            n5 = n4 + 1;
            byArray3[n4] = byArray2[(by & 0xF) << 2 | (n & 0xFF) >> 6];
            n4 = n5 + 1;
            byArray3[n5] = byArray2[n & 0x3F];
        }
        if ((n3 = byArray.length - n3) != 1) {
            if (n3 != 2) return _JvmPlatformKt.toUtf8String((byte[])byArray3);
            n3 = byArray[n2];
            n2 = byArray[n2 + 1];
            n = n4 + 1;
            byArray3[n4] = byArray2[(n3 & 0xFF) >> 2];
            n4 = n + 1;
            byArray3[n] = byArray2[(n3 & 3) << 4 | (n2 & 0xFF) >> 4];
            byArray3[n4] = byArray2[(n2 & 0xF) << 2];
            byArray3[n4 + 1] = (byte)61;
        } else {
            byte by;
            n3 = byArray[n2];
            n2 = n4 + 1;
            byArray3[n4] = byArray2[(n3 & 0xFF) >> 2];
            n4 = n2 + 1;
            byArray3[n2] = byArray2[(n3 & 3) << 4];
            byArray3[n4] = by = (byte)61;
            byArray3[n4 + 1] = by;
        }
        return _JvmPlatformKt.toUtf8String((byte[])byArray3);
    }

    public static /* synthetic */ String encodeBase64$default(byte[] byArray, byte[] byArray2, int n, Object object) {
        if ((n & 1) == 0) return _Base64Kt.encodeBase64(byArray, byArray2);
        byArray2 = BASE64;
        return _Base64Kt.encodeBase64(byArray, byArray2);
    }

    public static final byte[] getBASE64() {
        return BASE64;
    }

    public static /* synthetic */ void getBASE64$annotations() {
    }

    public static final byte[] getBASE64_URL_SAFE() {
        return BASE64_URL_SAFE;
    }

    public static /* synthetic */ void getBASE64_URL_SAFE$annotations() {
    }
}
