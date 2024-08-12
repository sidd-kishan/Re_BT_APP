/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.internal.ads.zzaxi
 *  com.google.android.gms.internal.ads.zzaxl
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.internal.ads.zzaxi;
import com.google.android.gms.internal.ads.zzaxl;
import java.util.PriorityQueue;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public final class zzaxm {
    public static void zza(String[] stringArray, int n, int n2, PriorityQueue<zzaxl> priorityQueue) {
        int n3;
        n2 = stringArray.length;
        if (n2 < 6) {
            zzaxm.zzb(n, zzaxm.zze(stringArray, 0, n2), zzaxm.zzc(stringArray, 0, n2), n2, priorityQueue);
            return;
        }
        long l = zzaxm.zze(stringArray, 0, 6);
        zzaxm.zzb(n, l, zzaxm.zzc(stringArray, 0, 6), 6, priorityQueue);
        long l2 = zzaxm.zzd(0x1001FFFL, 5);
        n2 = 1;
        while (n2 < (n3 = stringArray.length) - 5) {
            l = ((l + 0x4000FFFFL - ((long)zzaxi.zza((String)stringArray[n2 - 1]) + Integer.MAX_VALUE) % 0x4000FFFFL * l2 % 0x4000FFFFL) % 0x4000FFFFL * 0x1001FFFL % 0x4000FFFFL + ((long)zzaxi.zza((String)stringArray[n2 + 5]) + Integer.MAX_VALUE) % 0x4000FFFFL) % 0x4000FFFFL;
            zzaxm.zzb(n, l, zzaxm.zzc(stringArray, n2, 6), n3, priorityQueue);
            ++n2;
        }
    }

    static void zzb(int n, long l, String string, int n2, PriorityQueue<zzaxl> priorityQueue) {
        string = new zzaxl(l, string, n2);
        if (priorityQueue.size() == n) {
            if (priorityQueue.peek().zzc > ((zzaxl)string).zzc) return;
            if (priorityQueue.peek().zza > ((zzaxl)string).zza) return;
        }
        if (priorityQueue.contains(string)) {
            return;
        }
        priorityQueue.add((zzaxl)string);
        if (priorityQueue.size() <= n) return;
        priorityQueue.poll();
    }

    static String zzc(String[] stringArray, int n, int n2) {
        if (stringArray.length < (n2 += n)) {
            zze.zzf((String)"Unable to construct shingle");
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (true) {
            int n3;
            if (n >= (n3 = n2 - 1)) {
                stringBuilder.append(stringArray[n3]);
                return stringBuilder.toString();
            }
            stringBuilder.append(stringArray[n]);
            stringBuilder.append(' ');
            ++n;
        }
    }

    static long zzd(long l, int n) {
        if (n == 1) {
            return l;
        }
        l = (n & 1) == 0 ? zzaxm.zzd(l * l % 0x4000FFFFL, n >> 1) : (l *= zzaxm.zzd(l * l % 0x4000FFFFL, n >> 1) % 0x4000FFFFL);
        return l % 0x4000FFFFL;
    }

    private static long zze(String[] stringArray, int n, int n2) {
        long l = ((long)zzaxi.zza((String)stringArray[0]) + Integer.MAX_VALUE) % 0x4000FFFFL;
        n = 1;
        while (n < n2) {
            l = (l * 0x1001FFFL % 0x4000FFFFL + ((long)zzaxi.zza((String)stringArray[n]) + Integer.MAX_VALUE) % 0x4000FFFFL) % 0x4000FFFFL;
            ++n;
        }
        return l;
    }
}
