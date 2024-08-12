/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfpw
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfpw;
import java.io.Serializable;
import javax.annotation.CheckForNull;

final class zzfqf<T>
extends zzfpw<T>
implements Serializable {
    final zzfpw<? super T> zza;

    zzfqf(zzfpw<? super T> zzfpw2) {
        this.zza = zzfpw2;
    }

    public final int compare(T t, T t2) {
        return this.zza.compare(t2, t);
    }

    public final boolean equals(@CheckForNull Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof zzfqf)) return false;
        object = (zzfqf)object;
        return this.zza.equals(((zzfqf)object).zza);
    }

    public final int hashCode() {
        return -this.zza.hashCode();
    }

    public final String toString() {
        return this.zza.toString().concat(".reverse()");
    }

    public final <S extends T> zzfpw<S> zza() {
        return this.zza;
    }
}
