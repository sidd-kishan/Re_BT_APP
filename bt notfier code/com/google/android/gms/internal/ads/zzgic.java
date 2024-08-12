/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzgfq
 *  com.google.android.gms.internal.ads.zzgik
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgfq;
import com.google.android.gms.internal.ads.zzgik;
import java.util.Collections;
import java.util.List;
import java.util.Map;

final class zzgic
extends zzgik {
    zzgic(int n) {
        super(n, null);
    }

    public final void zza() {
        if (!this.zzd()) {
            for (int i = 0; i < this.zze(); ++i) {
                Map.Entry entry = this.zzf(i);
                if (!((zzgfq)entry.getKey()).zzc()) continue;
                entry.setValue(Collections.unmodifiableList((List)entry.getValue()));
            }
            for (Map.Entry entry : this.zzg()) {
                if (!((zzgfq)entry.getKey()).zzc()) continue;
                entry.setValue(Collections.unmodifiableList((List)entry.getValue()));
            }
        }
        super.zza();
    }
}
