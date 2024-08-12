/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.internal.ads;

public final class zzflf {
    public static String zza(String object) {
        int n = ((String)object).length();
        int n2 = 0;
        while (n2 < n) {
            if (zzflf.zzd(((String)object).charAt(n2))) {
                object = ((String)object).toCharArray();
                while (n2 < n) {
                    Object object2 = object[n2];
                    if (zzflf.zzd((char)object2)) {
                        object[n2] = (char)(object2 ^ 0x20);
                    }
                    ++n2;
                }
                return String.valueOf((char[])object);
            }
            ++n2;
        }
        return object;
    }

    public static String zzb(String object) {
        int n = ((String)object).length();
        int n2 = 0;
        while (n2 < n) {
            if (zzflf.zzc(((String)object).charAt(n2))) {
                object = ((String)object).toCharArray();
                while (n2 < n) {
                    Object object2 = object[n2];
                    if (zzflf.zzc((char)object2)) {
                        object[n2] = (char)(object2 ^ 0x20);
                    }
                    ++n2;
                }
                return String.valueOf((char[])object);
            }
            ++n2;
        }
        return object;
    }

    public static boolean zzc(char c) {
        if (c < 'a') return false;
        if (c > 'z') return false;
        return true;
    }

    public static boolean zzd(char c) {
        if (c < 'A') return false;
        if (c > 'Z') return false;
        return true;
    }

    public static boolean zze(CharSequence charSequence, CharSequence charSequence2) {
        int n = "content-length".length();
        if (charSequence2 == "content-length") {
            return true;
        }
        if (n != charSequence2.length()) return false;
        int n2 = 0;
        while (n2 < n) {
            char c;
            char c2 = "content-length".charAt(n2);
            if (c2 != (c = charSequence2.charAt(n2))) {
                int n3 = zzflf.zzf(c2);
                if (n3 >= 26) return false;
                if (n3 != zzflf.zzf(c)) {
                    return false;
                }
            }
            ++n2;
        }
        return true;
    }

    private static int zzf(char c) {
        return (char)((c | 0x20) - 97);
    }
}
