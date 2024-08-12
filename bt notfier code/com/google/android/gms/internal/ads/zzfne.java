/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzflt
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzflt;
import java.util.Map;
import javax.annotation.CheckForNull;

abstract class zzfne<K, V>
implements Map.Entry<K, V> {
    zzfne() {
    }

    @Override
    public final boolean equals(@CheckForNull Object object) {
        if (!(object instanceof Map.Entry)) return false;
        object = (Map.Entry)object;
        if (!zzflt.zza(this.getKey(), object.getKey())) return false;
        if (!zzflt.zza(this.getValue(), object.getValue())) return false;
        return true;
    }

    @Override
    public abstract K getKey();

    @Override
    public abstract V getValue();

    @Override
    public final int hashCode() {
        K k = this.getKey();
        V v = this.getValue();
        int n = 0;
        int n2 = k == null ? 0 : k.hashCode();
        if (v == null) return n2 ^ n;
        n = v.hashCode();
        return n2 ^ n;
    }

    @Override
    public V setValue(V v) {
        throw new UnsupportedOperationException();
    }

    public final String toString() {
        String string = String.valueOf(this.getKey());
        String string2 = String.valueOf(this.getValue());
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(string).length() + 1 + String.valueOf(string2).length());
        stringBuilder.append(string);
        stringBuilder.append("=");
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }
}
