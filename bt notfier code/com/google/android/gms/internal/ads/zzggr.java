/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzgeh
 *  com.google.android.gms.internal.ads.zzgex
 *  com.google.android.gms.internal.ads.zzggk
 *  com.google.android.gms.internal.ads.zzggs
 *  com.google.android.gms.internal.ads.zzgit
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgeh;
import com.google.android.gms.internal.ads.zzgex;
import com.google.android.gms.internal.ads.zzggk;
import com.google.android.gms.internal.ads.zzggs;
import com.google.android.gms.internal.ads.zzgit;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

public final class zzggr
extends zzgeh<String>
implements RandomAccess,
zzggs {
    public static final zzggs zza;
    private static final zzggr zzb;
    private final List<Object> zzc;

    static {
        zzggr zzggr2;
        zzb = zzggr2 = new zzggr(10);
        zzggr2.zzb();
        zza = zzb;
    }

    public zzggr() {
        this(10);
    }

    public zzggr(int n) {
        ArrayList<Object> arrayList = new ArrayList<Object>(n);
        this.zzc = arrayList;
    }

    private zzggr(ArrayList<Object> arrayList) {
        this.zzc = arrayList;
    }

    private static String zzj(Object object) {
        if (object instanceof String) {
            return (String)object;
        }
        if (!(object instanceof zzgex)) return zzggk.zzd((byte[])((byte[])object));
        return ((zzgex)object).zzA(zzggk.zza);
    }

    public final boolean addAll(int n, Collection<? extends String> list) {
        this.zzbH();
        List list2 = list;
        if (list instanceof zzggs) {
            list2 = ((zzggs)list).zzh();
        }
        boolean bl = this.zzc.addAll(n, list2);
        ++this.modCount;
        return bl;
    }

    public final boolean addAll(Collection<? extends String> collection) {
        return this.addAll(this.size(), collection);
    }

    public final void clear() {
        this.zzbH();
        this.zzc.clear();
        ++this.modCount;
    }

    public final int size() {
        return this.zzc.size();
    }

    public final String zzd(int n) {
        Object object = this.zzc.get(n);
        if (object instanceof String) {
            return (String)object;
        }
        if (object instanceof zzgex) {
            zzgex zzgex2 = (zzgex)object;
            object = zzgex2.zzA(zzggk.zza);
            if (!zzgex2.zzm()) return object;
            this.zzc.set(n, object);
            return object;
        }
        byte[] byArray = (byte[])object;
        object = zzggk.zzd((byte[])byArray);
        if (!zzggk.zzc((byte[])byArray)) return object;
        this.zzc.set(n, object);
        return object;
    }

    public final void zzf(zzgex zzgex2) {
        this.zzbH();
        this.zzc.add(zzgex2);
        ++this.modCount;
    }

    public final Object zzg(int n) {
        return this.zzc.get(n);
    }

    public final List<?> zzh() {
        return Collections.unmodifiableList(this.zzc);
    }

    public final zzggs zzi() {
        if (!this.zza()) return this;
        return new zzgit((zzggs)this);
    }
}
