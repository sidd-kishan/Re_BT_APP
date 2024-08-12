/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.measurement.zzhy
 *  com.google.android.gms.internal.measurement.zzif
 *  com.google.android.gms.internal.measurement.zzig
 *  com.google.android.gms.internal.measurement.zzih
 *  com.google.android.gms.internal.measurement.zzik
 *  com.google.android.gms.internal.measurement.zzjd
 *  com.google.android.gms.internal.measurement.zzka
 *  com.google.android.gms.internal.measurement.zzkf
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzhy;
import com.google.android.gms.internal.measurement.zzif;
import com.google.android.gms.internal.measurement.zzig;
import com.google.android.gms.internal.measurement.zzih;
import com.google.android.gms.internal.measurement.zzik;
import com.google.android.gms.internal.measurement.zzjd;
import com.google.android.gms.internal.measurement.zzka;
import com.google.android.gms.internal.measurement.zzkf;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

final class zzii
extends zzik {
    private static final Class<?> zza = Collections.unmodifiableList(Collections.emptyList()).getClass();

    private zzii() {
        super(null);
    }

    /* synthetic */ zzii(zzih zzih2) {
        super(null);
    }

    final void zza(Object object, long l) {
        List list = (List)zzkf.zzn((Object)object, (long)l);
        if (list instanceof zzig) {
            list = ((zzig)list).zzi();
        } else {
            if (zza.isAssignableFrom(list.getClass())) {
                return;
            }
            if (list instanceof zzjd && list instanceof zzhy) {
                object = (zzhy)list;
                if (!object.zza()) return;
                object.zzb();
                return;
            }
            list = Collections.unmodifiableList(list);
        }
        zzkf.zzo((Object)object, (long)l, (Object)list);
    }

    final <E> void zzb(Object object, Object object2, long l) {
        List list = (List)zzkf.zzn((Object)object2, (long)l);
        int n = list.size();
        List list2 = (List)zzkf.zzn((Object)object, (long)l);
        if (list2.isEmpty()) {
            object2 = list2 instanceof zzig ? new zzif(n) : (list2 instanceof zzjd && list2 instanceof zzhy ? ((zzhy)list2).zze(n) : new ArrayList(n));
            zzkf.zzo((Object)object, (long)l, object2);
        } else if (zza.isAssignableFrom(list2.getClass())) {
            object2 = new ArrayList(list2.size() + n);
            object2.addAll(list2);
            zzkf.zzo((Object)object, (long)l, (Object)object2);
        } else if (list2 instanceof zzka) {
            object2 = new zzif(list2.size() + n);
            list2 = (zzka)list2;
            object2.addAll(object2.size(), (Collection)list2);
            zzkf.zzo((Object)object, (long)l, (Object)object2);
        } else {
            object2 = list2;
            if (list2 instanceof zzjd) {
                object2 = list2;
                if (list2 instanceof zzhy) {
                    zzhy zzhy2 = (zzhy)list2;
                    object2 = list2;
                    if (!zzhy2.zza()) {
                        object2 = zzhy2.zze(list2.size() + n);
                        zzkf.zzo((Object)object, (long)l, (Object)object2);
                    }
                }
            }
        }
        int n2 = object2.size();
        n = list.size();
        if (n2 > 0 && n > 0) {
            object2.addAll(list);
        }
        if (n2 <= 0) {
            object2 = list;
        }
        zzkf.zzo((Object)object, (long)l, (Object)object2);
    }
}
