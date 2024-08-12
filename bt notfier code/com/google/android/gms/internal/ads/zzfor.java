/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfnh
 *  com.google.android.gms.internal.ads.zzfoe
 *  com.google.android.gms.internal.ads.zzfon
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfnh;
import com.google.android.gms.internal.ads.zzfoe;
import com.google.android.gms.internal.ads.zzfon;
import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

public class zzfor<K, V>
extends zzfnh<K, V>
implements Serializable {
    final transient zzfon<K, ? extends zzfoe<V>> zzb;
    final transient int zzc;

    zzfor(zzfon<K, ? extends zzfoe<V>> zzfon2, int n) {
        this.zzb = zzfon2;
        this.zzc = n;
    }

    public final int zzg() {
        throw null;
    }

    @Deprecated
    public final boolean zzh(K k, V v) {
        throw null;
    }

    @Deprecated
    public final void zzi() {
        throw null;
    }

    final Set<K> zzk() {
        throw new AssertionError((Object)"unreachable");
    }

    final Map<K, Collection<V>> zzp() {
        throw new AssertionError((Object)"should never be called");
    }

    public final boolean zzr(@CheckForNull Object object) {
        if (object == null) return false;
        if (!super.zzr(object)) return false;
        return true;
    }
}
