/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfoe
 *  com.google.android.gms.internal.ads.zzfpb
 *  com.google.android.gms.internal.ads.zzfrd
 *  com.google.android.gms.internal.ads.zzfrm
 *  com.google.android.gms.internal.ads.zzfsm
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfoe;
import com.google.android.gms.internal.ads.zzfpb;
import com.google.android.gms.internal.ads.zzfrd;
import com.google.android.gms.internal.ads.zzfrm;
import com.google.android.gms.internal.ads.zzfsm;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.CheckForNull;

abstract class zzfrn<V, C>
extends zzfrd<V, C> {
    @CheckForNull
    private List<zzfrm<V>> zza;

    zzfrn(zzfoe<? extends zzfsm<? extends V>> zzfoe2, boolean bl) {
        super(zzfoe2, true, true);
        ArrayList arrayList = zzfoe2.isEmpty() ? Collections.emptyList() : zzfpb.zza((int)zzfoe2.size());
        int n = 0;
        while (true) {
            if (n >= zzfoe2.size()) {
                this.zza = arrayList;
                return;
            }
            arrayList.add(null);
            ++n;
        }
    }

    final void zzA() {
        List<zzfrm<V>> list = this.zza;
        if (list == null) return;
        this.zzp(this.zzJ(list));
    }

    final void zzB(int n) {
        super.zzB(n);
        this.zza = null;
    }

    abstract C zzJ(List<zzfrm<V>> var1);

    final void zzz(int n, V v) {
        List<zzfrm<V>> list = this.zza;
        if (list == null) return;
        list.set(n, new zzfrm(v));
    }
}
