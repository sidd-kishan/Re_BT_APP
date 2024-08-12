/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfnu
 *  com.google.android.gms.internal.ads.zzfpu
 *  com.google.android.gms.internal.ads.zzfqf
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfnu;
import com.google.android.gms.internal.ads.zzfpu;
import com.google.android.gms.internal.ads.zzfqf;
import java.util.Comparator;

public abstract class zzfpw<T>
implements Comparator<T> {
    protected zzfpw() {
    }

    public static <C extends Comparable> zzfpw<C> zzb() {
        return zzfpu.zza;
    }

    public static <T> zzfpw<T> zzc(Comparator<T> zzfpw2) {
        zzfpw2 = zzfpw2 instanceof zzfpw ? (zzfpw<T>)zzfpw2 : new zzfnu((Comparator)zzfpw2);
        return zzfpw2;
    }

    @Override
    public abstract int compare(T var1, T var2);

    public <S extends T> zzfpw<S> zza() {
        return new zzfqf(this);
    }
}
