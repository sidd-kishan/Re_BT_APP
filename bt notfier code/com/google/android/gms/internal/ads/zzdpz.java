/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzawc
 *  com.google.android.gms.internal.ads.zzawd
 *  com.google.android.gms.internal.ads.zzcml
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzawc;
import com.google.android.gms.internal.ads.zzawd;
import com.google.android.gms.internal.ads.zzcml;
import java.util.HashMap;

final class zzdpz
implements zzawd {
    private final zzcml zza;

    zzdpz(zzcml zzcml2) {
        this.zza = zzcml2;
    }

    public final void zzc(zzawc object) {
        zzcml zzcml2 = this.zza;
        HashMap<String, zzawc> hashMap = new HashMap<String, zzawc>();
        object = true != object.zzj ? "0" : "1";
        hashMap.put("isVisible", (zzawc)object);
        zzcml2.zze("onAdVisibilityChanged", hashMap);
    }
}
