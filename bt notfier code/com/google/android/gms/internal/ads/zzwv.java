/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzvl
 *  com.google.android.gms.internal.ads.zzvu
 *  com.google.android.gms.internal.ads.zzww
 *  com.google.android.gms.internal.ads.zzwy
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzvl;
import com.google.android.gms.internal.ads.zzvu;
import com.google.android.gms.internal.ads.zzww;
import com.google.android.gms.internal.ads.zzwy;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

final class zzwv {
    long zza;
    final String zzb;
    final String zzc;
    final long zzd;
    final long zze;
    final long zzf;
    final long zzg;
    final List<zzvu> zzh;

    zzwv(String string, zzvl object) {
        String string2 = ((zzvl)object).zzb;
        long l = ((zzvl)object).zzc;
        long l2 = ((zzvl)object).zzd;
        long l3 = ((zzvl)object).zze;
        long l4 = ((zzvl)object).zzf;
        ArrayList<zzvu> arrayList = ((zzvl)object).zzh;
        if (arrayList != null) {
            object = arrayList;
        } else {
            object = ((zzvl)object).zzg;
            arrayList = new ArrayList<zzvu>(object.size());
            Iterator iterator = object.entrySet().iterator();
            while (true) {
                object = arrayList;
                if (!iterator.hasNext()) break;
                object = iterator.next();
                arrayList.add(new zzvu((String)object.getKey(), (String)object.getValue()));
            }
        }
        this(string, string2, l, l2, l3, l4, (List<zzvu>)object);
    }

    private zzwv(String string, String string2, long l, long l2, long l3, long l4, List<zzvu> list) {
        this.zzb = string;
        if ("".equals(string2)) {
            string2 = null;
        }
        this.zzc = string2;
        this.zzd = l;
        this.zze = l2;
        this.zzf = l3;
        this.zzg = l4;
        this.zzh = list;
    }

    static zzwv zza(zzww object) throws IOException {
        if (zzwy.zzi((InputStream)object) != 538247942) {
            object = new IOException();
            throw object;
        }
        String string = zzwy.zzm((zzww)object);
        String string2 = zzwy.zzm((zzww)object);
        long l = zzwy.zzk((InputStream)object);
        long l2 = zzwy.zzk((InputStream)object);
        long l3 = zzwy.zzk((InputStream)object);
        long l4 = zzwy.zzk((InputStream)object);
        int n = zzwy.zzi((InputStream)object);
        if (n < 0) {
            object = new StringBuilder(31);
            ((StringBuilder)object).append("readHeaderList size=");
            ((StringBuilder)object).append(n);
            throw new IOException(((StringBuilder)object).toString());
        }
        List<Object> list = n == 0 ? Collections.emptyList() : new ArrayList();
        int n2 = 0;
        while (n2 < n) {
            list.add(new zzvu(zzwy.zzm((zzww)object).intern(), zzwy.zzm((zzww)object).intern()));
            ++n2;
        }
        return new zzwv(string, string2, l, l2, l3, l4, list);
    }
}
