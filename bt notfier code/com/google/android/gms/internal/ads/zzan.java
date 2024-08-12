/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  com.google.android.gms.internal.ads.zzakt
 *  com.google.android.gms.internal.ads.zzam
 */
package com.google.android.gms.internal.ads;

import android.net.Uri;
import com.google.android.gms.internal.ads.zzakt;
import com.google.android.gms.internal.ads.zzam;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class zzan {
    public final Uri zza;
    public final int zzb;
    public final byte[] zzc;
    public final Map<String, String> zzd;
    @Deprecated
    public final long zze;
    public final long zzf;
    public final long zzg;
    public final String zzh;
    public final int zzi;

    private zzan(Uri uri, long l, int n, byte[] byArray, Map<String, String> map, long l2, long l3, String string, int n2, Object object) {
        boolean bl;
        block3: {
            block2: {
                boolean bl2 = false;
                bl = (l += l2) >= 0L;
                zzakt.zza((boolean)bl);
                bl = l2 >= 0L;
                zzakt.zza((boolean)bl);
                if (l3 > 0L) break block2;
                bl = bl2;
                if (l3 != -1L) break block3;
            }
            bl = true;
        }
        zzakt.zza((boolean)bl);
        this.zza = uri;
        this.zzb = 1;
        this.zzc = null;
        this.zzd = Collections.unmodifiableMap(new HashMap<String, String>(map));
        this.zzf = l2;
        this.zze = l;
        this.zzg = l3;
        this.zzh = null;
        this.zzi = n2;
    }

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    /* synthetic */ zzan(Uri uri, long l, int n, byte[] byArray, Map map, long l2, long l3, String string, int n2, Object object, zzam zzam2) {
        this(uri, 0L, 1, null, map, l2, -1L, null, n2, null);
    }

    @Deprecated
    public zzan(Uri uri, byte[] byArray, long l, long l2, long l3, String string, int n) {
        this(uri, l - l2, 1, null, Collections.emptyMap(), l2, l3, null, n, null);
    }

    public static String zza(int n) {
        return "GET";
    }

    public final String toString() {
        String string = zzan.zza(1);
        String string2 = String.valueOf(this.zza);
        long l = this.zzf;
        long l2 = this.zzg;
        int n = this.zzi;
        int n2 = String.valueOf(string2).length();
        StringBuilder stringBuilder = new StringBuilder(string.length() + 70 + n2 + 4);
        stringBuilder.append("DataSpec[");
        stringBuilder.append(string);
        stringBuilder.append(" ");
        stringBuilder.append(string2);
        stringBuilder.append(", ");
        stringBuilder.append(l);
        stringBuilder.append(", ");
        stringBuilder.append(l2);
        stringBuilder.append(", null, ");
        stringBuilder.append(n);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public final boolean zzb(int n) {
        if ((this.zzi & n) != n) return false;
        return true;
    }
}
