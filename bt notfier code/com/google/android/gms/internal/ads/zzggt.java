/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzggj
 *  com.google.android.gms.internal.ads.zzggr
 *  com.google.android.gms.internal.ads.zzggs
 *  com.google.android.gms.internal.ads.zzggv
 *  com.google.android.gms.internal.ads.zzggw
 *  com.google.android.gms.internal.ads.zzghp
 *  com.google.android.gms.internal.ads.zzgit
 *  com.google.android.gms.internal.ads.zzgiy
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzggj;
import com.google.android.gms.internal.ads.zzggr;
import com.google.android.gms.internal.ads.zzggs;
import com.google.android.gms.internal.ads.zzggv;
import com.google.android.gms.internal.ads.zzggw;
import com.google.android.gms.internal.ads.zzghp;
import com.google.android.gms.internal.ads.zzgit;
import com.google.android.gms.internal.ads.zzgiy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

final class zzggt
extends zzggw {
    private static final Class<?> zza = Collections.unmodifiableList(Collections.emptyList()).getClass();

    private zzggt() {
        super(null);
    }

    /* synthetic */ zzggt(zzggv zzggv2) {
        super(null);
    }

    /*
     * WARNING - void declaration
     * Enabled force condition propagation
     */
    private static <L> List<L> zzf(Object object, long l, int n) {
        void var4_17;
        List list;
        block11: {
            block10: {
                block9: {
                    list = (List)zzgiy.zzn((Object)object, (long)l);
                    if (list.isEmpty()) {
                        void var4_7;
                        if (list instanceof zzggs) {
                            zzggr zzggr2 = new zzggr(n);
                        } else if (list instanceof zzghp && list instanceof zzggj) {
                            zzggj zzggj2 = ((zzggj)list).zze(n);
                        } else {
                            ArrayList arrayList = new ArrayList(n);
                        }
                        zzgiy.zzo((Object)object, (long)l, (Object)var4_7);
                        return var4_17;
                    }
                    if (!zza.isAssignableFrom(list.getClass())) break block9;
                    ArrayList arrayList = new ArrayList(list.size() + n);
                    arrayList.addAll(list);
                    zzgiy.zzo((Object)object, (long)l, arrayList);
                    object = arrayList;
                    break block10;
                }
                if (!(list instanceof zzgit)) break block11;
                zzggr zzggr3 = new zzggr(list.size() + n);
                list = (zzgit)list;
                zzggr3.addAll(zzggr3.size(), (Collection)list);
                zzgiy.zzo((Object)object, (long)l, (Object)zzggr3);
                object = zzggr3;
            }
            Object object2 = object;
            return var4_17;
        }
        List list2 = list;
        if (!(list instanceof zzghp)) return var4_17;
        List list3 = list;
        if (!(list instanceof zzggj)) return var4_17;
        zzggj zzggj3 = (zzggj)list;
        if (zzggj3.zza()) {
            List list4 = list;
            return var4_17;
        }
        zzggj zzggj4 = zzggj3.zze(list.size() + n);
        zzgiy.zzo((Object)object, (long)l, (Object)zzggj4);
        return zzggj4;
    }

    final <L> List<L> zza(Object object, long l) {
        return zzggt.zzf(object, l, 10);
    }

    final void zzb(Object object, long l) {
        List list = (List)zzgiy.zzn((Object)object, (long)l);
        if (list instanceof zzggs) {
            list = ((zzggs)list).zzi();
        } else {
            if (zza.isAssignableFrom(list.getClass())) {
                return;
            }
            if (list instanceof zzghp && list instanceof zzggj) {
                object = (zzggj)list;
                if (!object.zza()) return;
                object.zzb();
                return;
            }
            list = Collections.unmodifiableList(list);
        }
        zzgiy.zzo((Object)object, (long)l, (Object)list);
    }

    final <E> void zzc(Object object, Object list, long l) {
        list = (List)zzgiy.zzn((Object)list, (long)l);
        List list2 = zzggt.zzf(object, l, list.size());
        int n = list2.size();
        int n2 = list.size();
        if (n > 0 && n2 > 0) {
            list2.addAll(list);
        }
        if (n > 0) {
            list = list2;
        }
        zzgiy.zzo((Object)object, (long)l, list);
    }
}
