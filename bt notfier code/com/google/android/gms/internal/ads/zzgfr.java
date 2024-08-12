/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzgex
 *  com.google.android.gms.internal.ads.zzgfq
 *  com.google.android.gms.internal.ads.zzggc
 *  com.google.android.gms.internal.ads.zzggk
 *  com.google.android.gms.internal.ads.zzggp
 *  com.google.android.gms.internal.ads.zzghi
 *  com.google.android.gms.internal.ads.zzgic
 *  com.google.android.gms.internal.ads.zzgik
 *  com.google.android.gms.internal.ads.zzgje
 *  com.google.android.gms.internal.ads.zzgjf
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgex;
import com.google.android.gms.internal.ads.zzgfq;
import com.google.android.gms.internal.ads.zzggc;
import com.google.android.gms.internal.ads.zzggk;
import com.google.android.gms.internal.ads.zzggp;
import com.google.android.gms.internal.ads.zzghi;
import com.google.android.gms.internal.ads.zzgic;
import com.google.android.gms.internal.ads.zzgik;
import com.google.android.gms.internal.ads.zzgje;
import com.google.android.gms.internal.ads.zzgjf;
import java.util.ArrayList;
import java.util.List;

final class zzgfr<T extends zzgfq<T>> {
    private static final zzgfr zzd = new zzgfr(true);
    final zzgik<T, Object> zza;
    private boolean zzb;
    private boolean zzc;

    private zzgfr() {
        this.zza = new zzgic(16);
    }

    private zzgfr(boolean bl) {
        zzgic zzgic2 = new zzgic(0);
        this.zza = zzgic2;
        this.zzb();
        this.zzb();
    }

    public static <T extends zzgfq<T>> zzgfr<T> zza() {
        throw null;
    }

    private static final void zzd(T t, Object object) {
        block11: {
            block12: {
                boolean bl;
                zzgje zzgje2 = t.zzb();
                zzggk.zza((Object)object);
                zzgje zzgje3 = zzgje.zza;
                zzgje3 = zzgjf.zza;
                switch (zzgje2.zza().ordinal()) {
                    default: {
                        break block11;
                    }
                    case 8: {
                        if (object instanceof zzghi) return;
                        if (!(object instanceof zzggp)) throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", t.zza(), t.zzb().zza(), object.getClass().getName()));
                        break block12;
                    }
                    case 7: {
                        if (object instanceof Integer) return;
                        if (!(object instanceof zzggc)) throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", t.zza(), t.zzb().zza(), object.getClass().getName()));
                        break block12;
                    }
                    case 6: {
                        if (object instanceof zzgex) return;
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
        if (!(object instanceof zzgfr)) {
            return false;
        }
        object = (zzgfr)object;
        return this.zza.equals(((zzgfr)object).zza);
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
                zzgfr.zzd(t, arrayList2.get(i));
            }
            arrayList = arrayList2;
        } else {
            zzgfr.zzd(t, arrayList);
        }
        if (arrayList instanceof zzggp) {
            this.zzc = true;
        }
        this.zza.zzh(t, (Object)arrayList);
    }
}
