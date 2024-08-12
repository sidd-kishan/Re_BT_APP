/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzgei
 *  com.google.android.gms.internal.ads.zzggm
 *  com.google.android.gms.internal.ads.zzgiy
 *  com.google.android.gms.internal.ads.zzgja
 *  com.google.android.gms.internal.ads.zzgjb
 *  com.google.android.gms.internal.ads.zzgjc
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgei;
import com.google.android.gms.internal.ads.zzggm;
import com.google.android.gms.internal.ads.zzgiy;
import com.google.android.gms.internal.ads.zzgja;
import com.google.android.gms.internal.ads.zzgjb;
import com.google.android.gms.internal.ads.zzgjc;
import java.nio.ByteBuffer;

final class zzgjd {
    private static final zzgja zza;

    static {
        if (zzgiy.zza() && zzgiy.zzb()) {
            int n = zzgei.zza;
        }
        zza = new zzgjb();
    }

    public static boolean zza(byte[] byArray) {
        return zza.zza(byArray, 0, byArray.length);
    }

    public static boolean zzb(byte[] byArray, int n, int n2) {
        return zza.zza(byArray, n, n2);
    }

    public static int zzc(int n, byte[] byArray, int n2, int n3) {
        return zza.zzb(n, byArray, n2, n3);
    }

    static /* synthetic */ int zzd(int n, int n2) {
        return zzgjd.zzk(n, n2);
    }

    static /* synthetic */ int zze(int n, int n2, int n3) {
        return zzgjd.zzl(n, n2, n3);
    }

    static /* synthetic */ int zzf(byte[] byArray, int n, int n2) {
        int n3 = byArray[n - 1];
        if ((n2 -= n) != 0) {
            if (n2 != 1) {
                if (n2 != 2) throw new AssertionError();
                n = zzgjd.zzl(n3, byArray[n], byArray[n + 1]);
            } else {
                n = zzgjd.zzk(n3, byArray[n]);
            }
        } else {
            n = n3;
            if (n3 <= -12) return n;
            n = -1;
        }
        return n;
    }

    static int zzg(CharSequence object) {
        int n;
        int n2;
        block8: {
            int n3;
            n2 = object.length();
            int n4 = 0;
            for (n3 = 0; n3 < n2 && object.charAt(n3) < '\u0080'; ++n3) {
            }
            int n5 = n2;
            while (true) {
                n = n5;
                if (n3 >= n2) break block8;
                n = object.charAt(n3);
                if (n >= 2048) break;
                n5 += 127 - n >>> 31;
                ++n3;
            }
            int n6 = object.length();
            n = n4;
            while (n3 < n6) {
                char c = object.charAt(n3);
                if (c < '\u0800') {
                    n += 127 - c >>> 31;
                    n4 = n3;
                } else {
                    int n7;
                    n = n7 = n + 2;
                    n4 = n3;
                    if (c >= '\ud800') {
                        n = n7;
                        n4 = n3;
                        if (c <= '\udfff') {
                            if (Character.codePointAt((CharSequence)object, n3) < 65536) throw new zzgjc(n3, n6);
                            n4 = n3 + 1;
                            n = n7;
                        }
                    }
                }
                n3 = n4 + 1;
            }
            n = n5 + n;
        }
        if (n >= n2) {
            return n;
        }
        object = new StringBuilder(54);
        ((StringBuilder)object).append("UTF-8 length does not fit in int: ");
        ((StringBuilder)object).append((long)n + 0x100000000L);
        object = new IllegalArgumentException(((StringBuilder)object).toString());
        throw object;
    }

    static int zzh(CharSequence charSequence, byte[] byArray, int n, int n2) {
        char c;
        int n3;
        int n4;
        int n5 = charSequence.length();
        int n6 = n2 + n;
        for (n4 = 0; n4 < n5 && (n3 = n4 + n) < n6 && (n2 = (int)charSequence.charAt(n4)) < 128; ++n4) {
            byArray[n3] = (byte)n2;
        }
        if (n4 == n5) {
            n4 = n + n5;
            return n4;
        }
        n2 = n + n4;
        n = n4;
        while (true) {
            n4 = n2;
            if (n >= n5) return n4;
            c = charSequence.charAt(n);
            if (c < '\u0080' && n2 < n6) {
                n4 = n2 + 1;
                byArray[n2] = (byte)c;
                n2 = n4;
            } else if (c < '\u0800' && n2 <= n6 - 2) {
                n4 = n2 + 1;
                byArray[n2] = (byte)(c >>> 6 | 0x3C0);
                n2 = n4 + 1;
                byArray[n4] = (byte)(c & 0x3F | 0x80);
            } else if ((c < '\ud800' || c > '\udfff') && n2 <= n6 - 3) {
                n4 = n2 + 1;
                byArray[n2] = (byte)(c >>> 12 | 0x1E0);
                n3 = n4 + 1;
                byArray[n4] = (byte)(c >>> 6 & 0x3F | 0x80);
                n2 = n3 + 1;
                byArray[n3] = (byte)(c & 0x3F | 0x80);
            } else {
                if (n2 > n6 - 4) break;
                n4 = n + 1;
                if (n4 == charSequence.length()) throw new zzgjc(n - 1, n5);
                char c2 = charSequence.charAt(n4);
                if (!Character.isSurrogatePair(c, c2)) {
                    n = n4;
                    throw new zzgjc(n - 1, n5);
                }
                n = Character.toCodePoint(c, c2);
                n3 = n2 + 1;
                byArray[n2] = (byte)(n >>> 18 | 0xF0);
                n2 = n3 + 1;
                byArray[n3] = (byte)(n >>> 12 & 0x3F | 0x80);
                n3 = n2 + 1;
                byArray[n2] = (byte)(n >>> 6 & 0x3F | 0x80);
                n2 = n3 + 1;
                byArray[n3] = (byte)(n & 0x3F | 0x80);
                n = n4;
            }
            ++n;
        }
        if (c >= '\ud800' && c <= '\udfff') {
            n4 = n + 1;
            if (n4 == charSequence.length()) throw new zzgjc(n, n5);
            if (!Character.isSurrogatePair(c, charSequence.charAt(n4))) {
                throw new zzgjc(n, n5);
            }
        }
        charSequence = new StringBuilder(37);
        ((StringBuilder)charSequence).append("Failed writing ");
        ((StringBuilder)charSequence).append(c);
        ((StringBuilder)charSequence).append(" at index ");
        ((StringBuilder)charSequence).append(n2);
        throw new ArrayIndexOutOfBoundsException(((StringBuilder)charSequence).toString());
    }

    static String zzi(ByteBuffer object, int n, int n2) throws zzggm {
        zzgja zzgja2 = zza;
        if (((ByteBuffer)object).hasArray()) {
            int n3 = ((ByteBuffer)object).arrayOffset();
            object = zzgja2.zzc(((ByteBuffer)object).array(), n3 + n, n2);
        } else {
            object = ((ByteBuffer)object).isDirect() ? zzgjb.zzd((ByteBuffer)object, (int)n, (int)n2) : zzgja.zzd((ByteBuffer)object, (int)n, (int)n2);
        }
        return object;
    }

    static String zzj(byte[] byArray, int n, int n2) throws zzggm {
        return zza.zzc(byArray, n, n2);
    }

    private static int zzk(int n, int n2) {
        if (n > -12) return -1;
        if (n2 <= -65) return n ^ n2 << 8;
        return -1;
    }

    private static int zzl(int n, int n2, int n3) {
        if (n > -12) return -1;
        if (n2 > -65) return -1;
        if (n3 <= -65) return n ^ n2 << 8 ^ n3 << 16;
        return -1;
    }
}
