/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzflt
 *  com.google.android.gms.internal.ads.zzfni
 *  com.google.android.gms.internal.ads.zzfpi
 *  com.google.android.gms.internal.ads.zzfqg
 *  com.google.android.gms.internal.ads.zzfqh
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzflt;
import com.google.android.gms.internal.ads.zzfni;
import com.google.android.gms.internal.ads.zzfpi;
import com.google.android.gms.internal.ads.zzfqg;
import com.google.android.gms.internal.ads.zzfqh;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

abstract class zzfpe<K, V>
extends zzfqg<Map.Entry<K, V>> {
    zzfpe() {
    }

    public final void clear() {
        this.zza().clear();
    }

    public boolean contains(@CheckForNull Object object) {
        boolean bl;
        boolean bl2 = object instanceof Map.Entry;
        boolean bl3 = bl = false;
        if (!bl2) return bl3;
        Map.Entry entry = (Map.Entry)object;
        Object k = entry.getKey();
        object = zzfpi.zza(this.zza(), k);
        bl3 = bl;
        if (!zzflt.zza((Object)object, entry.getValue())) return bl3;
        if (object == null) {
            if (this.zza().containsKey(k)) return true;
            bl3 = bl;
        } else {
            bl3 = true;
        }
        return bl3;
    }

    public final boolean isEmpty() {
        return this.zza().isEmpty();
    }

    public boolean remove(@CheckForNull Object object) {
        if (!this.contains(object)) return false;
        if (!(object instanceof Map.Entry)) return false;
        object = (Map.Entry)object;
        return this.zza().keySet().remove(object.getKey());
    }

    public final boolean removeAll(Collection<?> collection) {
        if (collection == null) throw null;
        try {
            return zzfqh.zzc((Set)((Object)this), collection);
        }
        catch (UnsupportedOperationException unsupportedOperationException) {
            return zzfqh.zzb((Set)((Object)this), collection.iterator());
        }
    }

    public final boolean retainAll(Collection<?> collection) {
        if (collection == null) throw null;
        try {
            return super.retainAll(collection);
        }
        catch (UnsupportedOperationException unsupportedOperationException) {
            int n = collection.size();
            if (n < 3) {
                zzfni.zzb((int)n, (String)"expectedSize");
                ++n;
            } else {
                n = n < 0x40000000 ? (int)((float)n / 0.75f + 1.0f) : Integer.MAX_VALUE;
            }
            HashSet hashSet = new HashSet(n);
            Iterator<?> iterator = collection.iterator();
            while (iterator.hasNext()) {
                collection = iterator.next();
                if (!this.contains(collection) || !(collection instanceof Map.Entry)) continue;
                hashSet.add(((Map.Entry)((Object)collection)).getKey());
            }
            return this.zza().keySet().retainAll(hashSet);
        }
    }

    public final int size() {
        return this.zza().size();
    }

    abstract Map<K, V> zza();
}
