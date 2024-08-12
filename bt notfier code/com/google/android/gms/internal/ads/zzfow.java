/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzflx
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzflx;
import java.util.Iterator;
import java.util.NoSuchElementException;

final class zzfow
extends Enum<zzfow>
implements Iterator<Object> {
    public static final /* enum */ zzfow zza;
    private static final zzfow[] zzb;

    static {
        zzfow zzfow2;
        zza = zzfow2 = new zzfow();
        zzb = new zzfow[]{zzfow2};
    }

    public static zzfow[] values() {
        return (zzfow[])zzb.clone();
    }

    @Override
    public final boolean hasNext() {
        return false;
    }

    @Override
    public final Object next() {
        throw new NoSuchElementException();
    }

    @Override
    public final void remove() {
        zzflx.zzb((boolean)false, (Object)"no calls to next() since the last call to remove()");
    }
}
