/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.common.internal.Preconditions
 *  com.google.android.gms.common.internal.zzag
 */
package com.google.android.gms.common.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.zzag;
import java.util.ArrayList;
import java.util.List;

public static final class Objects.ToStringHelper {
    private final List<String> zza;
    private final Object zzb;

    /* synthetic */ Objects.ToStringHelper(Object object, zzag zzag2) {
        Preconditions.checkNotNull((Object)object);
        this.zzb = object;
        this.zza = new ArrayList<String>();
    }

    public Objects.ToStringHelper add(String string, Object object) {
        List<String> list = this.zza;
        Preconditions.checkNotNull((Object)string);
        String string2 = String.valueOf(object);
        object = new StringBuilder(string.length() + 1 + String.valueOf(string2).length());
        ((StringBuilder)object).append(string);
        ((StringBuilder)object).append("=");
        ((StringBuilder)object).append(string2);
        list.add(((StringBuilder)object).toString());
        return this;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(100);
        stringBuilder.append(this.zzb.getClass().getSimpleName());
        stringBuilder.append('{');
        int n = this.zza.size();
        int n2 = 0;
        while (true) {
            if (n2 >= n) {
                stringBuilder.append('}');
                return stringBuilder.toString();
            }
            stringBuilder.append(this.zza.get(n2));
            if (n2 < n - 1) {
                stringBuilder.append(", ");
            }
            ++n2;
        }
    }
}
