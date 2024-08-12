/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzflt
 *  com.google.android.gms.internal.ads.zzfob
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzflt;
import com.google.android.gms.internal.ads.zzfob;
import javax.annotation.CheckForNull;

final class zzfnt {
    static Object zza(int n) {
        if (n >= 2 && n <= 0x40000000 && Integer.highestOneBit(n) == n) {
            if (n <= 256) {
                return new byte[n];
            }
            if (n > 65536) return new int[n];
            return new short[n];
        }
        StringBuilder stringBuilder = new StringBuilder(52);
        stringBuilder.append("must be power of 2 between 2^1 and 2^30: ");
        stringBuilder.append(n);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    static int zzb(Object object, int n) {
        if (object instanceof byte[]) {
            return ((byte[])object)[n] & 0xFF;
        }
        if (!(object instanceof short[])) return ((int[])object)[n];
        return (char)((short[])object)[n];
    }

    static void zzc(Object object, int n, int n2) {
        if (object instanceof byte[]) {
            ((byte[])object)[n] = (byte)n2;
            return;
        }
        if (object instanceof short[]) {
            ((short[])object)[n] = (short)n2;
            return;
        }
        ((int[])object)[n] = n2;
    }

    static int zzd(int n) {
        int n2 = n < 32 ? 4 : 2;
        return n2 * (n + 1);
    }

    static int zze(@CheckForNull Object object, @CheckForNull Object object2, int n, Object object3, int[] nArray, Object[] objectArray, @CheckForNull Object[] objectArray2) {
        int n2 = zzfob.zzb((Object)object);
        int n3 = n2 & n;
        int n4 = zzfnt.zzb(object3, n3);
        if (n4 == 0) return -1;
        int n5 = ~n;
        int n6 = -1;
        while (true) {
            int n7;
            if (((n7 = nArray[--n4]) & n5) == (n2 & n5) && zzflt.zza((Object)object, (Object)objectArray[n4]) && (objectArray2 == null || zzflt.zza((Object)object2, (Object)objectArray2[n4]))) {
                n7 &= n;
                if (n6 == -1) {
                    zzfnt.zzc(object3, n3, n7);
                    break;
                }
                nArray[n6] = n7 & n | nArray[n6] & n5;
                break;
            }
            if ((n7 &= n) == 0) return -1;
            n6 = n4;
            n4 = n7;
        }
        return n4;
    }
}
