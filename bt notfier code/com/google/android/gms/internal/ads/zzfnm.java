/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzflt
 *  com.google.android.gms.internal.ads.zzfnk
 *  com.google.android.gms.internal.ads.zzfns
 *  com.google.android.gms.internal.ads.zzfnt
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzflt;
import com.google.android.gms.internal.ads.zzfnk;
import com.google.android.gms.internal.ads.zzfns;
import com.google.android.gms.internal.ads.zzfnt;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.CheckForNull;

final class zzfnm
extends AbstractSet<Map.Entry> {
    final zzfns zza;

    zzfnm(zzfns zzfns2) {
        this.zza = zzfns2;
    }

    @Override
    public final void clear() {
        this.zza.clear();
    }

    @Override
    public final boolean contains(@CheckForNull Object object) {
        Map map = this.zza.zzg();
        if (map != null) {
            return map.entrySet().contains(object);
        }
        if (!(object instanceof Map.Entry)) return false;
        int n = zzfns.zzj((zzfns)this.zza, (object = (Map.Entry)object).getKey());
        if (n == -1) return false;
        if (!zzflt.zza((Object)zzfns.zzt((zzfns)this.zza, (int)n), object.getValue())) return false;
        return true;
    }

    @Override
    public final Iterator<Map.Entry> iterator() {
        Object object = this.zza;
        Map map = object.zzg();
        object = map != null ? map.entrySet().iterator() : new zzfnk(object);
        return object;
    }

    @Override
    public final boolean remove(@CheckForNull Object object) {
        Map map = this.zza.zzg();
        if (map != null) {
            return map.entrySet().remove(object);
        }
        if (!(object instanceof Map.Entry)) return false;
        object = (Map.Entry)object;
        if (this.zza.zzf()) {
            return false;
        }
        int n = zzfns.zzh((zzfns)this.zza);
        int n2 = zzfnt.zze(object.getKey(), object.getValue(), (int)n, (Object)zzfns.zzo((zzfns)this.zza), (int[])zzfns.zzp((zzfns)this.zza), (Object[])zzfns.zzq((zzfns)this.zza), (Object[])zzfns.zzr((zzfns)this.zza));
        if (n2 == -1) {
            return false;
        }
        this.zza.zzl(n2, n);
        object = this.zza;
        zzfns.zzd((zzfns)object, (int)(zzfns.zzc((zzfns)object) - 1));
        this.zza.zzi();
        return true;
    }

    @Override
    public final int size() {
        return this.zza.size();
    }
}
