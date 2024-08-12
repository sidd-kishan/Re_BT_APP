/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzges
 *  com.google.android.gms.internal.ads.zzgex
 *  com.google.android.gms.internal.ads.zzghw
 *  com.google.android.gms.internal.ads.zzghy
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzges;
import com.google.android.gms.internal.ads.zzgex;
import com.google.android.gms.internal.ads.zzghw;
import com.google.android.gms.internal.ads.zzghy;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.NoSuchElementException;

final class zzghx
implements Iterator<zzges> {
    private final ArrayDeque<zzghy> zza;
    private zzges zzb;

    /* synthetic */ zzghx(zzgex zzgex2, zzghw object) {
        if (zzgex2 instanceof zzghy) {
            zzgex2 = (zzghy)zzgex2;
            this.zza = object = new ArrayDeque(zzgex2.zzf());
            ((ArrayDeque)object).push(zzgex2);
            this.zzb = this.zzb(zzghy.zzd((zzghy)zzgex2));
            return;
        }
        this.zza = null;
        this.zzb = (zzges)zzgex2;
    }

    private final zzges zzb(zzgex zzgex2) {
        while (zzgex2 instanceof zzghy) {
            zzgex2 = (zzghy)zzgex2;
            this.zza.push((zzghy)zzgex2);
            zzgex2 = zzghy.zzd((zzghy)zzgex2);
        }
        return (zzges)zzgex2;
    }

    @Override
    public final boolean hasNext() {
        if (this.zzb == null) return false;
        return true;
    }

    @Override
    public final void remove() {
        throw new UnsupportedOperationException();
    }

    public final zzges zza() {
        zzges zzges2;
        zzges zzges3 = this.zzb;
        if (zzges3 == null) {
            NoSuchElementException noSuchElementException = new NoSuchElementException();
            throw noSuchElementException;
        }
        do {
            zzges zzges4;
            ArrayDeque<zzghy> arrayDeque = this.zza;
            zzges2 = zzges4 = null;
            if (arrayDeque == null) break;
            if (!arrayDeque.isEmpty()) continue;
            zzges2 = zzges4;
            break;
        } while ((zzges2 = this.zzb(zzghy.zzh((zzghy)this.zza.pop()))).zzr());
        this.zzb = zzges2;
        return zzges3;
    }
}
