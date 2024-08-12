/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.measurement.zzhh
 *  com.google.android.gms.internal.measurement.zzjr
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzhh;
import com.google.android.gms.internal.measurement.zzjr;
import java.util.Collections;
import java.util.List;
import java.util.Map;

final class zzjk
extends zzjr {
    zzjk(int n) {
        super(n, null);
    }

    public final void zza() {
        if (!this.zzb()) {
            for (int i = 0; i < this.zzc(); ++i) {
                Map.Entry entry = this.zzd(i);
                if (!((zzhh)entry.getKey()).zzc()) continue;
                entry.setValue(Collections.unmodifiableList((List)entry.getValue()));
            }
            for (Map.Entry entry : this.zze()) {
                if (!((zzhh)entry.getKey()).zzc()) continue;
                entry.setValue(Collections.unmodifiableList((List)entry.getValue()));
            }
        }
        super.zza();
    }
}
