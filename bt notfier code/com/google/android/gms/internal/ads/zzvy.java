/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzvu
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzvu;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public final class zzvy {
    public final int zza;
    public final byte[] zzb;
    public final Map<String, String> zzc;
    public final List<zzvu> zzd;
    public final boolean zze;

    private zzvy(int n, byte[] object, Map<String, String> map, List<zzvu> list, boolean bl, long l) {
        this.zza = n;
        this.zzb = object;
        this.zzc = map;
        object = list == null ? null : (Object)Collections.unmodifiableList(list);
        this.zzd = object;
        this.zze = bl;
    }

    @Deprecated
    public zzvy(int n, byte[] byArray, Map<String, String> map, boolean bl, long l) {
        this(n, byArray, map, zzvy.zza(map), bl, l);
    }

    public zzvy(int n, byte[] byArray, boolean bl, long l, List<zzvu> list) {
        zzvu zzvu2;
        if (list == null) {
            zzvu2 = null;
        } else if (list.isEmpty()) {
            zzvu2 = Collections.emptyMap();
        } else {
            TreeMap<String, String> treeMap = new TreeMap<String, String>(String.CASE_INSENSITIVE_ORDER);
            Iterator<zzvu> iterator = list.iterator();
            while (true) {
                zzvu2 = treeMap;
                if (!iterator.hasNext()) break;
                zzvu2 = iterator.next();
                treeMap.put(zzvu2.zza(), zzvu2.zzb());
            }
        }
        this(n, byArray, (Map<String, String>)zzvu2, list, bl, l);
    }

    @Deprecated
    public zzvy(byte[] byArray, Map<String, String> map) {
        this(200, byArray, map, zzvy.zza(map), false, 0L);
    }

    private static List<zzvu> zza(Map<String, String> object) {
        if (object == null) {
            return null;
        }
        if (object.isEmpty()) {
            return Collections.emptyList();
        }
        ArrayList<zzvu> arrayList = new ArrayList<zzvu>(object.size());
        Iterator<Map.Entry<String, String>> iterator = object.entrySet().iterator();
        while (iterator.hasNext()) {
            object = iterator.next();
            arrayList.add(new zzvu((String)object.getKey(), (String)object.getValue()));
        }
        return arrayList;
    }
}
