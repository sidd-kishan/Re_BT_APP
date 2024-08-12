/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzgku
 *  com.google.android.gms.internal.ads.zzgln
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgku;
import com.google.android.gms.internal.ads.zzgln;

public final class zzgkz<T>
implements zzgln,
zzgku {
    private static final Object zza = new Object();
    private volatile zzgln<T> zzb;
    private volatile Object zzc = zza;

    private zzgkz(zzgln<T> zzgln2) {
        this.zzb = zzgln2;
    }

    public static <P extends zzgln<T>, T> zzgln<T> zza(P p) {
        if (p == null) throw null;
        if (!(p instanceof zzgkz)) return new zzgkz<T>(p);
        return p;
    }

    public static <P extends zzgln<T>, T> zzgku<T> zzc(P p) {
        if (p instanceof zzgku) {
            return (zzgku)p;
        }
        if (p == null) throw null;
        return new zzgkz<T>(p);
    }

    public final T zzb() {
        Object object;
        Object object2 = object = this.zzc;
        if (object != zza) return (T)object2;
        synchronized (this) {
            block5: {
                Object object3;
                block4: {
                    object2 = object = this.zzc;
                    if (object != zza) return (T)object2;
                    object2 = this.zzb.zzb();
                    object3 = this.zzc;
                    if (object3 != zza && object3 != object2) break block4;
                    break block5;
                }
                object3 = String.valueOf(object3);
                String string = String.valueOf(object2);
                int n = String.valueOf(object3).length();
                int n2 = String.valueOf(string).length();
                object2 = new StringBuilder(n + 118 + n2);
                ((StringBuilder)object2).append("Scoped provider was invoked recursively returning different results: ");
                ((StringBuilder)object2).append((String)object3);
                ((StringBuilder)object2).append(" & ");
                ((StringBuilder)object2).append(string);
                ((StringBuilder)object2).append(". This is likely due to a circular dependency.");
                object = new IllegalStateException(((StringBuilder)object2).toString());
                throw object;
            }
            this.zzc = object2;
            this.zzb = null;
        }
        return (T)object2;
    }
}
