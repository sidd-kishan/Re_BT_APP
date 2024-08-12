/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.internal.ads.zzbpr
 *  com.google.android.gms.internal.ads.zzbqg
 *  com.google.android.gms.internal.ads.zzccl
 *  com.google.android.gms.internal.ads.zzcml
 */
package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.internal.ads.zzbpr;
import com.google.android.gms.internal.ads.zzbqg;
import com.google.android.gms.internal.ads.zzccl;
import com.google.android.gms.internal.ads.zzcml;
import java.util.Map;

public final class zzbqh
implements zzbpr<Object> {
    private final zzbqg zza;

    public zzbqh(zzbqg zzbqg2) {
        this.zza = zzbqg2;
    }

    public static void zzb(zzcml zzcml2, zzbqg zzbqg2) {
        zzcml2.zzab("/reward", (zzbpr)new zzbqh(zzbqg2));
    }

    public final void zza(Object object, Map<String, String> object2) {
        object = object2.get("action");
        if ("grant".equals(object)) {
            Object var4_4 = null;
            try {
                int n = Integer.parseInt(object2.get("amount"));
                object2 = object2.get("type");
                object = var4_4;
                if (!TextUtils.isEmpty((CharSequence)object2)) {
                    object = new zzccl((String)object2, n);
                }
            }
            catch (NumberFormatException numberFormatException) {
                zze.zzj((String)"Unable to parse reward amount.", (Throwable)numberFormatException);
                object = var4_4;
            }
            this.zza.zzb((zzccl)object);
            return;
        }
        if ("video_start".equals(object)) {
            this.zza.zza();
            return;
        }
        if (!"video_complete".equals(object)) return;
        this.zza.zzc();
    }
}
