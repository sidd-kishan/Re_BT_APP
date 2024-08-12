/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzflt
 *  com.google.android.gms.internal.ads.zzfne
 *  com.google.android.gms.internal.ads.zzfns
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzflt;
import com.google.android.gms.internal.ads.zzfne;
import com.google.android.gms.internal.ads.zzfns;
import java.util.Map;

final class zzfnp
extends zzfne {
    final zzfns zza;
    private final Object zzb;
    private int zzc;

    zzfnp(zzfns zzfns2, int n) {
        this.zza = zzfns2;
        this.zzb = zzfns.zzs((zzfns)zzfns2, (int)n);
        this.zzc = n;
    }

    private final void zza() {
        int n = this.zzc;
        if (n != -1 && n < this.zza.size()) {
            if (zzflt.zza((Object)this.zzb, (Object)zzfns.zzs((zzfns)this.zza, (int)this.zzc))) return;
        }
        this.zzc = zzfns.zzj((zzfns)this.zza, (Object)this.zzb);
    }

    public final Object getKey() {
        return this.zzb;
    }

    public final Object getValue() {
        Map map = this.zza.zzg();
        if (map != null) {
            return map.get(this.zzb);
        }
        this.zza();
        int n = this.zzc;
        if (n != -1) return zzfns.zzt((zzfns)this.zza, (int)n);
        return null;
    }

    public final Object setValue(Object object) {
        Object object2 = this.zza.zzg();
        if (object2 != null) {
            return object2.put(this.zzb, object);
        }
        this.zza();
        int n = this.zzc;
        if (n == -1) {
            this.zza.put(this.zzb, object);
            return null;
        }
        object2 = zzfns.zzt((zzfns)this.zza, (int)n);
        zzfns.zzu((zzfns)this.zza, (int)this.zzc, (Object)object);
        return object2;
    }
}
