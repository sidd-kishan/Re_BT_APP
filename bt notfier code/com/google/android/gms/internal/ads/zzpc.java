/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzaha
 *  com.google.android.gms.internal.ads.zzamf
 *  com.google.android.gms.internal.ads.zzfll
 *  com.google.android.gms.internal.ads.zzoz
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzaha;
import com.google.android.gms.internal.ads.zzamf;
import com.google.android.gms.internal.ads.zzfll;
import com.google.android.gms.internal.ads.zzoz;

public final class zzpc {
    public static int zza(int n) {
        int n2 = 0;
        while (n > 0) {
            ++n2;
            n >>>= 1;
        }
        return n2;
    }

    public static zzoz zzb(zzamf zzamf2, boolean bl, boolean bl2) throws zzaha {
        int n = 0;
        if (bl) {
            zzpc.zzc(3, zzamf2, false);
        }
        String string = zzamf2.zzE((int)zzamf2.zzu(), zzfll.zzc);
        long l = zzamf2.zzu();
        String[] stringArray = new String[(int)l];
        int n2 = string.length() + 15;
        while (true) {
            String string2;
            if ((long)n >= l) {
                if (!bl2) return new zzoz(string, stringArray, n2 + 1);
                if ((zzamf2.zzn() & 1) == 0) throw zzaha.zzb((String)"framing bit expected to be set", null);
                return new zzoz(string, stringArray, n2 + 1);
            }
            stringArray[n] = string2 = zzamf2.zzE((int)zzamf2.zzu(), zzfll.zzc);
            n2 = n2 + 4 + string2.length();
            ++n;
        }
    }

    public static boolean zzc(int n, zzamf object, boolean bl) throws zzaha {
        if (object.zzd() < 7) {
            if (bl) {
                return false;
            }
            n = object.zzd();
            object = new StringBuilder(29);
            ((StringBuilder)object).append("too short header: ");
            ((StringBuilder)object).append(n);
            throw zzaha.zzb((String)((StringBuilder)object).toString(), null);
        }
        if (object.zzn() != n) {
            if (bl) {
                return false;
            }
            object = String.valueOf(Integer.toHexString(n));
            object = ((String)object).length() != 0 ? "expected header type ".concat((String)object) : new String("expected header type ");
            throw zzaha.zzb((String)object, null);
        }
        if (object.zzn() == 118 && object.zzn() == 111 && object.zzn() == 114 && object.zzn() == 98 && object.zzn() == 105) {
            if (object.zzn() == 115) return true;
        }
        if (!bl) throw zzaha.zzb((String)"expected characters 'vorbis'", null);
        return false;
    }
}
