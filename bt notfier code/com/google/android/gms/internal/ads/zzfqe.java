/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfpu
 *  com.google.android.gms.internal.ads.zzfpw
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfpu;
import com.google.android.gms.internal.ads.zzfpw;
import java.io.Serializable;

final class zzfqe
extends zzfpw<Comparable<?>>
implements Serializable {
    static final zzfqe zza = new zzfqe();

    private zzfqe() {
    }

    public final String toString() {
        return "Ordering.natural().reverse()";
    }

    public final <S extends Comparable> zzfpw<S> zza() {
        return zzfpu.zza;
    }
}
