/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.measurement.zzgd
 *  com.google.android.gms.internal.measurement.zzgr
 *  com.google.android.gms.internal.measurement.zzhz
 *  com.google.android.gms.internal.measurement.zzig
 *  com.google.android.gms.internal.measurement.zzka
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzgd;
import com.google.android.gms.internal.measurement.zzgr;
import com.google.android.gms.internal.measurement.zzhz;
import com.google.android.gms.internal.measurement.zzig;
import com.google.android.gms.internal.measurement.zzka;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

public final class zzif
extends zzgd<String>
implements RandomAccess,
zzig {
    public static final zzig zza;
    private static final zzif zzb;
    private final List<Object> zzc;

    static {
        zzif zzif2;
        zzb = zzif2 = new zzif(10);
        zzif2.zzb();
        zza = zzb;
    }

    public zzif() {
        this(10);
    }

    public zzif(int n) {
        ArrayList<Object> arrayList = new ArrayList<Object>(n);
        this.zzc = arrayList;
    }

    private zzif(ArrayList<Object> arrayList) {
        this.zzc = arrayList;
    }

    private static String zzj(Object object) {
        if (object instanceof String) {
            return (String)object;
        }
        if (!(object instanceof zzgr)) return zzhz.zzd((byte[])((byte[])object));
        return ((zzgr)object).zzl(zzhz.zza);
    }

    public final boolean addAll(int n, Collection<? extends String> list) {
        this.zzbL();
        List list2 = list;
        if (list instanceof zzig) {
            list2 = ((zzig)list).zzh();
        }
        boolean bl = this.zzc.addAll(n, list2);
        ++this.modCount;
        return bl;
    }

    public final boolean addAll(Collection<? extends String> collection) {
        return this.addAll(this.size(), collection);
    }

    public final void clear() {
        this.zzbL();
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
        if (object instanceof zzgr) {
            object = (zzgr)object;
            String string = object.zzl(zzhz.zza);
            if (!object.zzh()) return string;
            this.zzc.set(n, string);
            return string;
        }
        object = (byte[])object;
        String string = zzhz.zzd((byte[])object);
        if (!zzhz.zzc((byte[])object)) return string;
        this.zzc.set(n, string);
        return string;
    }

    public final void zzf(zzgr zzgr2) {
        this.zzbL();
        this.zzc.add(zzgr2);
        ++this.modCount;
    }

    public final Object zzg(int n) {
        return this.zzc.get(n);
    }

    public final List<?> zzh() {
        return Collections.unmodifiableList(this.zzc);
    }

    public final zzig zzi() {
        if (!this.zza()) return this;
        return new zzka((zzig)this);
    }
}
