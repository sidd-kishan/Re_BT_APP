/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  com.google.android.gms.internal.ads.zzaup
 */
package com.google.android.gms.internal.ads;

import android.net.Uri;
import com.google.android.gms.internal.ads.zzaup;
import java.util.Arrays;

public final class zzaub {
    public final Uri zza;
    public final long zzb;
    public final long zzc;
    public final long zzd;

    public zzaub(Uri uri, byte[] byArray, long l, long l2, long l3, String string, int n) {
        boolean bl;
        block3: {
            block2: {
                boolean bl2 = false;
                bl = l >= 0L;
                zzaup.zza((boolean)bl);
                bl = l2 >= 0L;
                zzaup.zza((boolean)bl);
                if (l3 > 0L) break block2;
                bl = bl2;
                if (l3 != -1L) break block3;
            }
            bl = true;
        }
        zzaup.zza((boolean)bl);
        this.zza = uri;
        this.zzb = l;
        this.zzc = l2;
        this.zzd = l3;
    }

    public final String toString() {
        String string = String.valueOf(this.zza);
        String string2 = Arrays.toString(null);
        long l = this.zzb;
        long l2 = this.zzc;
        long l3 = this.zzd;
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(string).length() + 93 + String.valueOf(string2).length() + 4);
        stringBuilder.append("DataSpec[");
        stringBuilder.append(string);
        stringBuilder.append(", ");
        stringBuilder.append(string2);
        stringBuilder.append(", ");
        stringBuilder.append(l);
        stringBuilder.append(", ");
        stringBuilder.append(l2);
        stringBuilder.append(", ");
        stringBuilder.append(l3);
        stringBuilder.append(", null, 0]");
        return stringBuilder.toString();
    }
}
