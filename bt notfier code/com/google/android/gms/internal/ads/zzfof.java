/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfne
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfne;
import java.io.Serializable;

final class zzfof<K, V>
extends zzfne<K, V>
implements Serializable {
    final K zza;
    final V zzb;

    zzfof(K k, V v) {
        this.zza = k;
        this.zzb = v;
    }

    public final K getKey() {
        return this.zza;
    }

    public final V getValue() {
        return this.zzb;
    }

    public final V setValue(V v) {
        throw new UnsupportedOperationException();
    }
}
