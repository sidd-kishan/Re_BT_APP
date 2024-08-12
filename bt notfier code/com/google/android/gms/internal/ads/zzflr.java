/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzflp
 *  com.google.android.gms.internal.ads.zzflq
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzflp;
import com.google.android.gms.internal.ads.zzflq;
import java.util.Arrays;
import javax.annotation.CheckForNull;

public final class zzflr {
    private final String zza;
    private final zzflq zzb;
    private zzflq zzc;

    /* synthetic */ zzflr(String string, zzflp zzflp2) {
        zzflp2 = new zzflq(null);
        this.zzb = zzflp2;
        this.zzc = zzflp2;
        if (string == null) throw null;
        this.zza = string;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder(32);
        stringBuilder.append(this.zza);
        stringBuilder.append('{');
        zzflq zzflq2 = this.zzb.zzb;
        String string = "";
        while (true) {
            if (zzflq2 == null) {
                stringBuilder.append('}');
                return stringBuilder.toString();
            }
            Object object = zzflq2.zza;
            stringBuilder.append(string);
            if (object != null && object.getClass().isArray()) {
                string = Arrays.deepToString(new Object[]{object});
                stringBuilder.append(string, 1, string.length() - 1);
            } else {
                stringBuilder.append(object);
            }
            zzflq2 = zzflq2.zzb;
            string = ", ";
        }
    }

    public final zzflr zza(@CheckForNull Object object) {
        zzflq zzflq2;
        this.zzc.zzb = zzflq2 = new zzflq(null);
        this.zzc = zzflq2;
        zzflq2.zza = object;
        return this;
    }
}
