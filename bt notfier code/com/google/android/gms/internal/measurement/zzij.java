/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.measurement.zzhy
 *  com.google.android.gms.internal.measurement.zzih
 *  com.google.android.gms.internal.measurement.zzik
 *  com.google.android.gms.internal.measurement.zzkf
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzhy;
import com.google.android.gms.internal.measurement.zzih;
import com.google.android.gms.internal.measurement.zzik;
import com.google.android.gms.internal.measurement.zzkf;
import java.util.Collection;

final class zzij
extends zzik {
    private zzij() {
        super(null);
    }

    /* synthetic */ zzij(zzih zzih2) {
        super(null);
    }

    final void zza(Object object, long l) {
        ((zzhy)zzkf.zzn((Object)object, (long)l)).zzb();
    }

    final <E> void zzb(Object object, Object object2, long l) {
        zzhy zzhy2 = (zzhy)zzkf.zzn((Object)object, (long)l);
        zzhy zzhy3 = (zzhy)zzkf.zzn((Object)object2, (long)l);
        int n = zzhy2.size();
        int n2 = zzhy3.size();
        object2 = zzhy2;
        if (n > 0) {
            object2 = zzhy2;
            if (n2 > 0) {
                object2 = zzhy2;
                if (!zzhy2.zza()) {
                    object2 = zzhy2.zze(n2 + n);
                }
                object2.addAll((Collection)zzhy3);
            }
        }
        if (n <= 0) {
            object2 = zzhy3;
        }
        zzkf.zzo((Object)object, (long)l, (Object)object2);
    }
}
