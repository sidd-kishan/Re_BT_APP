/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  com.google.android.gms.internal.ads.zzakt
 *  com.google.android.gms.internal.ads.zzamf
 *  com.google.android.gms.internal.ads.zzamq
 *  com.google.android.gms.internal.ads.zznp
 *  com.google.android.gms.internal.ads.zznv
 *  com.google.android.gms.internal.ads.zzuw
 *  com.google.android.gms.internal.ads.zzux
 */
package com.google.android.gms.internal.ads;

import android.util.Log;
import com.google.android.gms.internal.ads.zzakt;
import com.google.android.gms.internal.ads.zzamf;
import com.google.android.gms.internal.ads.zzamq;
import com.google.android.gms.internal.ads.zznp;
import com.google.android.gms.internal.ads.zznv;
import com.google.android.gms.internal.ads.zzuw;
import com.google.android.gms.internal.ads.zzux;
import java.io.IOException;

final class zzuy {
    public static zzuw zza(zznv object) throws IOException {
        zzamf zzamf2 = new zzamf(16);
        if (zzux.zza((zznv)object, (zzamf)zzamf2).zza != 1380533830) {
            return null;
        }
        Object object2 = zzamf2.zzi();
        zznp zznp2 = (zznp)object;
        zznp2.zzh(object2, 0, 4, false);
        zzamf2.zzh(0);
        int n = zzamf2.zzv();
        if (n != 1463899717) {
            object = new StringBuilder(36);
            object.append("Unsupported RIFF format: ");
            object.append(n);
            Log.e((String)"WavHeaderReader", (String)object.toString());
            return null;
        }
        object2 = zzux.zza((zznv)object, (zzamf)zzamf2);
        while (object2.zza != 1718449184) {
            zznp2.zzj((int)object2.zzb, false);
            object2 = zzux.zza((zznv)object, (zzamf)zzamf2);
        }
        boolean bl = object2.zzb >= 16L;
        zzakt.zzd((boolean)bl);
        zznp2.zzh(zzamf2.zzi(), 0, 16, false);
        zzamf2.zzh(0);
        int n2 = zzamf2.zzp();
        int n3 = zzamf2.zzp();
        n = zzamf2.zzC();
        int n4 = zzamf2.zzC();
        int n5 = zzamf2.zzp();
        int n6 = zzamf2.zzp();
        int n7 = (int)object2.zzb - 16;
        if (n7 > 0) {
            object = new byte[n7];
            zznp2.zzh((byte[])object, 0, n7, false);
        } else {
            object = zzamq.zzf;
        }
        return new zzuw(n2, n3, n, n4, n5, n6, (byte[])object);
    }
}
