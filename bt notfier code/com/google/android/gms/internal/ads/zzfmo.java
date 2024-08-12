/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfmp
 *  com.google.android.gms.internal.ads.zzfmq
 *  com.google.android.gms.internal.ads.zzfnd
 *  com.google.android.gms.internal.ads.zzfpe
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfmp;
import com.google.android.gms.internal.ads.zzfmq;
import com.google.android.gms.internal.ads.zzfnd;
import com.google.android.gms.internal.ads.zzfpe;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

final class zzfmo
extends zzfpe {
    final zzfmq zza;

    zzfmo(zzfmq zzfmq2) {
        this.zza = zzfmq2;
    }

    public final boolean contains(@CheckForNull Object object) {
        boolean bl;
        Set set = this.zza.zza.entrySet();
        if (set == null) throw null;
        try {
            bl = set.contains(object);
        }
        catch (ClassCastException | NullPointerException runtimeException) {
            bl = false;
        }
        return bl;
    }

    public final Iterator<Map.Entry> iterator() {
        return new zzfmp(this.zza);
    }

    public final boolean remove(@CheckForNull Object object) {
        if (!this.contains(object)) {
            return false;
        }
        object = (Map.Entry)object;
        object.getClass();
        zzfnd.zzm((zzfnd)this.zza.zzb, object.getKey());
        return true;
    }

    final Map zza() {
        return this.zza;
    }
}
