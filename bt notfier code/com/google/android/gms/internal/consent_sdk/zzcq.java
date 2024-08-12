/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.consent_sdk.zzcr
 *  com.google.android.gms.internal.consent_sdk.zzct
 *  com.google.android.gms.internal.consent_sdk.zzcu
 */
package com.google.android.gms.internal.consent_sdk;

import com.google.android.gms.internal.consent_sdk.zzcr;
import com.google.android.gms.internal.consent_sdk.zzct;
import com.google.android.gms.internal.consent_sdk.zzcu;

public final class zzcq<T>
implements zzct<T> {
    private static final Object zza = new Object();
    private volatile zzct<T> zzb;
    private volatile Object zzc = zza;

    private zzcq(zzct<T> zzct2) {
        this.zzb = zzct2;
    }

    public static <P extends zzct<T>, T> zzct<T> zza(P p) {
        zzcu.zza(p);
        if (!(p instanceof zzcq)) return new zzcq<T>(p);
        return p;
    }

    public final T zza() {
        Object object;
        Object object2 = object = this.zzc;
        if (object != zza) return (T)object2;
        synchronized (this) {
            block5: {
                int n;
                Object object3;
                block4: {
                    object2 = object = this.zzc;
                    if (object != zza) return (T)object2;
                    object2 = this.zzb.zza();
                    object3 = this.zzc;
                    n = object3 != zza && !(object3 instanceof zzcr) ? 1 : 0;
                    if (n != 0 && object3 != object2) break block4;
                    break block5;
                }
                object3 = String.valueOf(object3);
                String string = String.valueOf(object2);
                n = String.valueOf(object3).length();
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
