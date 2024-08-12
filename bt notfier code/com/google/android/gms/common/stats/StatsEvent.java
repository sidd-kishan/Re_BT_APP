/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.common.internal.ReflectedParcelable
 *  com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable
 */
package com.google.android.gms.common.stats;

import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

@Deprecated
public abstract class StatsEvent
extends AbstractSafeParcelable
implements ReflectedParcelable {
    public final String toString() {
        long l = this.zza();
        int n = this.zzb();
        long l2 = this.zzc();
        String string = this.zzd();
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(string).length() + 53);
        stringBuilder.append(l);
        stringBuilder.append("\t");
        stringBuilder.append(n);
        stringBuilder.append("\t");
        stringBuilder.append(l2);
        stringBuilder.append(string);
        return stringBuilder.toString();
    }

    public abstract long zza();

    public abstract int zzb();

    public abstract long zzc();

    public abstract String zzd();
}
