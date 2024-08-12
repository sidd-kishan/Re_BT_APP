/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfpw
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfpw;
import java.io.Serializable;
import java.util.Comparator;
import javax.annotation.CheckForNull;

final class zzfnu<T>
extends zzfpw<T>
implements Serializable {
    final Comparator<T> zza;

    zzfnu(Comparator<T> comparator) {
        if (comparator == null) throw null;
        this.zza = comparator;
    }

    public final int compare(T t, T t2) {
        return this.zza.compare(t, t2);
    }

    public final boolean equals(@CheckForNull Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof zzfnu)) return false;
        object = (zzfnu)object;
        return this.zza.equals(((zzfnu)object).zza);
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final String toString() {
        return this.zza.toString();
    }
}
