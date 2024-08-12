/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.measurement.zzgr
 *  com.google.android.gms.internal.measurement.zzhh
 *  com.google.android.gms.internal.measurement.zzht
 *  com.google.android.gms.internal.measurement.zzhz
 *  com.google.android.gms.internal.measurement.zzid
 *  com.google.android.gms.internal.measurement.zziw
 *  com.google.android.gms.internal.measurement.zzjk
 *  com.google.android.gms.internal.measurement.zzjr
 *  com.google.android.gms.internal.measurement.zzkl
 *  com.google.android.gms.internal.measurement.zzkm
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzgr;
import com.google.android.gms.internal.measurement.zzhh;
import com.google.android.gms.internal.measurement.zzht;
import com.google.android.gms.internal.measurement.zzhz;
import com.google.android.gms.internal.measurement.zzid;
import com.google.android.gms.internal.measurement.zziw;
import com.google.android.gms.internal.measurement.zzjk;
import com.google.android.gms.internal.measurement.zzjr;
import com.google.android.gms.internal.measurement.zzkl;
import com.google.android.gms.internal.measurement.zzkm;
import java.util.ArrayList;
import java.util.List;

final class zzhi<T extends zzhh<T>> {
    private static final zzhi zzd = new zzhi(true);
    final zzjr<T, Object> zza;
    private boolean zzb;
    private boolean zzc;

    private zzhi() {
        this.zza = new zzjk(16);
    }

    private zzhi(boolean bl) {
        zzjk zzjk2 = new zzjk(0);
        this.zza = zzjk2;
        this.zzb();
        this.zzb();
    }

    public static <T extends zzhh<T>> zzhi<T> zza() {
        throw null;
    }

    private static final void zzd(T t, Object object) {
        block11: {
            block12: {
                boolean bl;
                zzkl zzkl2 = t.zzb();
                zzhz.zza((Object)object);
                zzkl zzkl3 = zzkl.zza;
                zzkl3 = zzkm.zza;
                switch (zzkl2.zza().ordinal()) {
                    default: {
                        break block11;
                    }
                    case 8: {
                        if (object instanceof zziw) return;
                        if (!(object instanceof zzid)) throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", t.zza(), t.zzb().zza(), object.getClass().getName()));
                        break block12;
                    }
                    case 7: {
                        if (object instanceof Integer) return;
                        if (!(object instanceof zzht)) throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", t.zza(), t.zzb().zza(), object.getClass().getName()));
                        break block12;
                    }
                    case 6: {
                        if (object instanceof zzgr) return;
                        if (!(object instanceof byte[])) throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", t.zza(), t.zzb().zza(), object.getClass().getName()));
                        break block12;
                    }
                    case 5: {
                        bl = object instanceof String;
                        break;
                    }
                    case 4: {
                        bl = object instanceof Boolean;
                        break;
                    }
                    case 3: {
                        bl = object instanceof Double;
                        break;
                    }
                    case 2: {
                        bl = object instanceof Float;
                        break;
                    }
                    case 1: {
                        bl = object instanceof Long;
                        break;
                    }
                    case 0: {
                        bl = object instanceof Integer;
                    }
                }
                if (!bl) throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", t.zza(), t.zzb().zza(), object.getClass().getName()));
            }
            return;
        }
        throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", t.zza(), t.zzb().zza(), object.getClass().getName()));
    }

    public final boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof zzhi)) {
            return false;
        }
        object = (zzhi)object;
        return this.zza.equals(((zzhi)object).zza);
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final void zzb() {
        if (this.zzb) {
            return;
        }
        this.zza.zza();
        this.zzb = true;
    }

    public final void zzc(T t, Object arrayList) {
        if (t.zzc()) {
            if (!(arrayList instanceof List)) throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            ArrayList arrayList2 = new ArrayList();
            arrayList2.addAll(arrayList);
            int n = arrayList2.size();
            for (int i = 0; i < n; ++i) {
                zzhi.zzd(t, arrayList2.get(i));
            }
            arrayList = arrayList2;
        } else {
            zzhi.zzd(t, arrayList);
        }
        if (arrayList instanceof zzid) {
            this.zzc = true;
        }
        this.zza.zzf(t, (Object)arrayList);
    }
}
