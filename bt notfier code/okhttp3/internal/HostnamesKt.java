/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 *  kotlin.jvm.internal.Intrinsics
 *  kotlin.text.StringsKt
 *  okhttp3.internal.Util
 *  okio.Buffer
 */
package okhttp3.internal;

import java.net.IDN;
import java.net.InetAddress;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.internal.Util;
import okio.Buffer;

@Metadata(d1={"\u0000&\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a0\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0005H\u0002\u001a\"\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0002\u001a\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0002\u001a\f\u0010\r\u001a\u00020\u0001*\u00020\u0003H\u0002\u001a\f\u0010\u000e\u001a\u0004\u0018\u00010\u0003*\u00020\u0003\u00a8\u0006\u000f"}, d2={"decodeIpv4Suffix", "", "input", "", "pos", "", "limit", "address", "", "addressOffset", "decodeIpv6", "Ljava/net/InetAddress;", "inet6AddressToAscii", "containsInvalidHostnameAsciiCodes", "toCanonicalHost", "okhttp"}, k=2, mv={1, 5, 1}, xi=48)
public final class HostnamesKt {
    private static final boolean containsInvalidHostnameAsciiCodes(String string) {
        int n = string.length();
        if (n <= 0) return false;
        int n2 = 0;
        while (true) {
            int n3 = n2 + 1;
            char c = string.charAt(n2);
            if (Intrinsics.compare((int)c, (int)31) <= 0) return true;
            if (Intrinsics.compare((int)c, (int)127) >= 0) {
                return true;
            }
            if (StringsKt.indexOf$default((CharSequence)" #%/:?@[\\]", (char)c, (int)0, (boolean)false, (int)6, null) != -1) {
                return true;
            }
            if (n3 >= n) {
                return false;
            }
            n2 = n3;
        }
    }

    private static final boolean decodeIpv4Suffix(String string, int n, int n2, byte[] byArray, int n3) {
        int n4 = n3;
        int n5 = n;
        while (true) {
            char c;
            boolean bl = false;
            if (n5 >= n2) {
                if (n4 != n3 + 4) return bl;
                bl = true;
                return bl;
            }
            if (n4 == byArray.length) {
                return false;
            }
            n = n5;
            if (n4 != n3) {
                if (string.charAt(n5) != '.') {
                    return false;
                }
                n = n5 + 1;
            }
            int n6 = 0;
            for (n5 = n; n5 < n2 && Intrinsics.compare((int)(c = string.charAt(n5)), (int)48) >= 0 && Intrinsics.compare((int)c, (int)57) <= 0; ++n5) {
                if (n6 == 0 && n != n5) {
                    return false;
                }
                if ((n6 = n6 * 10 + c - 48) <= 255) continue;
                return false;
            }
            if (n5 - n == 0) {
                return false;
            }
            byArray[n4] = (byte)n6;
            ++n4;
        }
    }

    private static final InetAddress decodeIpv6(String string, int n, int n2) {
        byte[] byArray = new byte[16];
        int n3 = 0;
        int n4 = -1;
        int n5 = -1;
        int n6 = n;
        while (true) {
            int n7;
            block12: {
                block7: {
                    block10: {
                        block11: {
                            block8: {
                                block9: {
                                    n = n3;
                                    n7 = n4;
                                    if (n6 >= n2) break block7;
                                    if (n3 == 16) {
                                        return null;
                                    }
                                    n7 = n6 + 2;
                                    if (n7 > n2 || !StringsKt.startsWith$default((String)string, (String)"::", (int)n6, (boolean)false, (int)4, null)) break block8;
                                    if (n4 != -1) {
                                        return null;
                                    }
                                    n = n3 + 2;
                                    if (n7 != n2) break block9;
                                    n7 = n;
                                    break block7;
                                }
                                n6 = n7;
                                n4 = n;
                                n3 = n;
                                n = n6;
                                break block10;
                            }
                            n = n6;
                            if (n3 == 0) break block10;
                            if (StringsKt.startsWith$default((String)string, (String)":", (int)n6, (boolean)false, (int)4, null)) break block11;
                            if (!StringsKt.startsWith$default((String)string, (String)".", (int)n6, (boolean)false, (int)4, null)) return null;
                            if (!HostnamesKt.decodeIpv4Suffix(string, n5, n2, byArray, n3 - 2)) {
                                return null;
                            }
                            n = n3 + 2;
                            n7 = n4;
                            break block7;
                        }
                        n = n6 + 1;
                    }
                    n5 = 0;
                    break block12;
                }
                if (n == 16) return InetAddress.getByAddress(byArray);
                if (n7 == -1) {
                    return null;
                }
                n2 = n - n7;
                System.arraycopy(byArray, n7, byArray, 16 - n2, n2);
                Arrays.fill(byArray, n7, 16 - n + n7, (byte)0);
                return InetAddress.getByAddress(byArray);
            }
            for (n6 = n; n6 < n2 && (n7 = Util.parseHexDigit((char)string.charAt(n6))) != -1; ++n6) {
                n5 = (n5 << 4) + n7;
            }
            n7 = n6 - n;
            if (n7 == 0) return null;
            if (n7 > 4) {
                return null;
            }
            n7 = n3 + 1;
            byArray[n3] = (byte)(n5 >>> 8 & 0xFF);
            n3 = n7 + 1;
            byArray[n7] = (byte)(n5 & 0xFF);
            n5 = n;
        }
    }

    private static final String inet6AddressToAscii(byte[] byArray) {
        int n;
        int n2 = 0;
        int n3 = -1;
        int n4 = 0;
        int n5 = 0;
        while (n4 < byArray.length) {
            for (n = n4; n < 16 && byArray[n] == 0 && byArray[n + 1] == 0; n += 2) {
            }
            int n6 = n - n4;
            int n7 = n3;
            int n8 = n5;
            if (n6 > n5) {
                n7 = n3;
                n8 = n5;
                if (n6 >= 4) {
                    n8 = n6;
                    n7 = n4;
                }
            }
            n4 = n + 2;
            n3 = n7;
            n5 = n8;
        }
        Buffer buffer = new Buffer();
        n4 = n2;
        while (n4 < byArray.length) {
            if (n4 == n3) {
                buffer.writeByte(58);
                n4 = n = n4 + n5;
                if (n != 16) continue;
                buffer.writeByte(58);
                n4 = n;
                continue;
            }
            if (n4 > 0) {
                buffer.writeByte(58);
            }
            buffer.writeHexadecimalUnsignedLong((long)(Util.and((byte)byArray[n4], (int)255) << 8 | Util.and((byte)byArray[n4 + 1], (int)255)));
            n4 += 2;
        }
        return buffer.readUtf8();
    }

    public static final String toCanonicalHost(String object) {
        Intrinsics.checkNotNullParameter((Object)object, (String)"<this>");
        Object object2 = (CharSequence)object;
        Object object3 = ":";
        boolean bl = false;
        if (StringsKt.contains$default((CharSequence)object2, (CharSequence)object3, (boolean)false, (int)2, null)) {
            object3 = StringsKt.startsWith$default((String)object, (String)"[", (boolean)false, (int)2, null) && StringsKt.endsWith$default((String)object, (String)"]", (boolean)false, (int)2, null) ? HostnamesKt.decodeIpv6((String)object, 1, ((String)object).length() - 1) : HostnamesKt.decodeIpv6((String)object, 0, ((String)object).length());
            if (object3 == null) {
                return null;
            }
            object2 = ((InetAddress)object3).getAddress();
            if (((Object)object2).length == 16) {
                Intrinsics.checkNotNullExpressionValue((Object)object2, (String)"address");
                return HostnamesKt.inet6AddressToAscii((byte[])object2);
            }
            if (((Object)object2).length == 4) {
                return ((InetAddress)object3).getHostAddress();
            }
            object3 = new StringBuilder();
            ((StringBuilder)object3).append("Invalid IPv6 address: '");
            ((StringBuilder)object3).append((String)object);
            ((StringBuilder)object3).append('\'');
            throw new AssertionError((Object)((StringBuilder)object3).toString());
        }
        try {
            object3 = IDN.toASCII((String)object);
            Intrinsics.checkNotNullExpressionValue((Object)object3, (String)"toASCII(host)");
            object = Locale.US;
            Intrinsics.checkNotNullExpressionValue((Object)object, (String)"US");
            object3 = ((String)object3).toLowerCase((Locale)object);
            Intrinsics.checkNotNullExpressionValue((Object)object3, (String)"(this as java.lang.String).toLowerCase(locale)");
            if (((CharSequence)object3).length() == 0) {
                bl = true;
            }
            if (bl) {
                return null;
            }
            object = object3;
            if (!HostnamesKt.containsInvalidHostnameAsciiCodes((String)object3)) return object;
            object = null;
            return object;
        }
        catch (IllegalArgumentException illegalArgumentException) {
            return null;
        }
    }
}
