/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.measurement.zzge
 *  com.google.android.gms.internal.measurement.zzib
 *  com.google.android.gms.internal.measurement.zzkf
 *  com.google.android.gms.internal.measurement.zzkg
 *  com.google.android.gms.internal.measurement.zzkh
 *  com.google.android.gms.internal.measurement.zzki
 *  com.google.android.gms.internal.measurement.zzkj
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzge;
import com.google.android.gms.internal.measurement.zzib;
import com.google.android.gms.internal.measurement.zzkf;
import com.google.android.gms.internal.measurement.zzkg;
import com.google.android.gms.internal.measurement.zzkh;
import com.google.android.gms.internal.measurement.zzki;
import com.google.android.gms.internal.measurement.zzkj;

final class zzkk {
    private static final zzkh zza;

    static {
        if (zzkf.zza() && zzkf.zzb()) {
            int n = zzge.zza;
        }
        zza = new zzki();
    }

    public static boolean zza(byte[] byArray) {
        return zza.zza(byArray, 0, byArray.length);
    }

    public static boolean zzb(byte[] byArray, int n, int n2) {
        return zza.zza(byArray, n, n2);
    }

    static int zzc(CharSequence object) {
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
                            if (Character.codePointAt((CharSequence)object, n3) < 65536) throw new zzkj(n3, n6);
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

    static int zzd(CharSequence charSequence, byte[] byArray, int n, int n2) {
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
                if (n4 == charSequence.length()) throw new zzkj(n - 1, n5);
                char c2 = charSequence.charAt(n4);
                if (!Character.isSurrogatePair(c, c2)) {
                    n = n4;
                    throw new zzkj(n - 1, n5);
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
            if (n4 == charSequence.length()) throw new zzkj(n, n5);
            if (!Character.isSurrogatePair(c, charSequence.charAt(n4))) {
                throw new zzkj(n, n5);
            }
        }
        charSequence = new StringBuilder(37);
        ((StringBuilder)charSequence).append("Failed writing ");
        ((StringBuilder)charSequence).append(c);
        ((StringBuilder)charSequence).append(" at index ");
        ((StringBuilder)charSequence).append(n2);
        throw new ArrayIndexOutOfBoundsException(((StringBuilder)charSequence).toString());
    }

    static String zze(byte[] object, int n, int n2) throws zzib {
        byte by;
        int n3 = ((byte[])object).length;
        if ((n | n2 | n3 - n - n2) < 0) {
            object = new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", n3, n, n2));
            throw object;
        }
        int n4 = n + n2;
        char[] cArray = new char[n2];
        n3 = 0;
        int n5 = n;
        while (true) {
            n = ++n3;
            n2 = ++n5;
            if (n5 >= n4) break;
            by = object[n5];
            if (!zzkg.zza((byte)by)) {
                n = n3;
                n2 = n5;
                break;
            }
            cArray[n3] = (char)by;
        }
        block1: while (n2 < n4) {
            n3 = n2 + 1;
            by = object[n2];
            if (!zzkg.zza((byte)by)) {
                if (by < -32) {
                    if (n3 >= n4) throw zzib.zzf();
                    zzkg.zzb((byte)by, (byte)object[n3], (char[])cArray, (int)n);
                    n2 = n3 + 1;
                    ++n;
                    continue;
                }
                if (by < -16) {
                    if (n3 >= n4 - 1) throw zzib.zzf();
                    n2 = n3 + 1;
                    zzkg.zzc((byte)by, (byte)object[n3], (byte)object[n2], (char[])cArray, (int)n);
                    ++n2;
                    ++n;
                    continue;
                }
                if (n3 >= n4 - 2) throw zzib.zzf();
                n5 = n3 + 1;
                n2 = n5 + 1;
                zzkg.zzd((byte)by, (byte)object[n3], (byte)object[n5], (byte)object[n2], (char[])cArray, (int)n);
                n += 2;
                ++n2;
                continue;
            }
            n2 = n + 1;
            cArray[n] = (char)by;
            n = n2;
            while (true) {
                n = n5 = n;
                n2 = ++n3;
                if (n3 >= n4) continue block1;
                by = object[n3];
                if (!zzkg.zza((byte)by)) {
                    n = n5;
                    n2 = n3;
                    continue block1;
                }
                n = n5 + 1;
                cArray[n5] = (char)by;
            }
            break;
        }
        return new String(cArray, 0, n);
    }

    static /* synthetic */ int zzf(byte[] byArray, int n, int n2) {
        block3: {
            block2: {
                int n3;
                block0: {
                    block1: {
                        n3 = byArray[n - 1];
                        if ((n2 -= n) == 0) break block0;
                        if (n2 == 1) break block1;
                        if (n2 != 2) throw new AssertionError();
                        n2 = byArray[n];
                        n = byArray[n + 1];
                        if (n3 > -12 || n2 > -65 || n > -65) break block2;
                        n = n2 << 8 ^ n3 ^ n << 16;
                        break block3;
                    }
                    n = byArray[n];
                    if (n3 > -12 || n > -65) break block2;
                    n = n3 ^ n << 8;
                    break block3;
                }
                n = n3;
                if (n3 <= -12) return n;
            }
            n = -1;
        }
        return n;
    }
}
