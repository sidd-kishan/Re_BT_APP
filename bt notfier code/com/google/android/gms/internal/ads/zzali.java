/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzalj
 *  com.google.android.gms.internal.ads.zzall
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzalj;
import com.google.android.gms.internal.ads.zzall;
import java.util.concurrent.CopyOnWriteArraySet;

final class zzali
implements Runnable {
    private final CopyOnWriteArraySet zza;
    private final int zzb;
    private final zzalj zzc;

    zzali(CopyOnWriteArraySet copyOnWriteArraySet, int n, zzalj zzalj2) {
        this.zza = copyOnWriteArraySet;
        this.zzb = n;
        this.zzc = zzalj2;
    }

    @Override
    public final void run() {
        Object object = this.zza;
        int n = this.zzb;
        zzalj zzalj2 = this.zzc;
        object = ((CopyOnWriteArraySet)object).iterator();
        while (object.hasNext()) {
            ((zzall)object.next()).zzb(n, zzalj2);
        }
    }
}
