/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfpw
 *  com.google.android.gms.internal.ads.zzfqe
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfpw;
import com.google.android.gms.internal.ads.zzfqe;
import java.io.Serializable;

final class zzfpu
extends zzfpw<Comparable<?>>
implements Serializable {
    static final zzfpu zza = new zzfpu();

    private zzfpu() {
    }

    public final String toString() {
        return "Ordering.natural()";
    }

    public final <S extends Comparable> zzfpw<S> zza() {
        return zzfqe.zza;
    }
}
