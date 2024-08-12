/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzamf
 *  com.google.android.gms.internal.ads.zznt
 *  com.google.android.gms.internal.ads.zzox
 *  com.google.android.gms.internal.ads.zzpq
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzamf;
import com.google.android.gms.internal.ads.zznt;
import com.google.android.gms.internal.ads.zzox;
import com.google.android.gms.internal.ads.zzpq;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

final class zzpo
extends zzpq {
    private long zzb = -9223372036854775807L;
    private long[] zzc = new long[0];
    private long[] zzd = new long[0];

    public zzpo() {
        super((zzox)new zznt());
    }

    private static Double zzg(zzamf zzamf2) {
        return Double.longBitsToDouble(zzamf2.zzx());
    }

    private static String zzh(zzamf zzamf2) {
        int n = zzamf2.zzo();
        int n2 = zzamf2.zzg();
        zzamf2.zzk(n);
        return new String(zzamf2.zzi(), n2, n);
    }

    private static HashMap<String, Object> zzi(zzamf zzamf2) {
        int n = zzamf2.zzB();
        HashMap<String, Object> hashMap = new HashMap<String, Object>(n);
        int n2 = 0;
        while (n2 < n) {
            String string = zzpo.zzh(zzamf2);
            Object object = zzpo.zzj(zzamf2, zzamf2.zzn());
            if (object != null) {
                hashMap.put(string, object);
            }
            ++n2;
        }
        return hashMap;
    }

    private static Object zzj(zzamf zzamf2, int n) {
        if (n == 0) return zzpo.zzg(zzamf2);
        boolean bl = false;
        int n2 = 0;
        if (n == 1) {
            if (zzamf2.zzn() != 1) return bl;
            bl = true;
            return bl;
        }
        if (n == 2) return zzpo.zzh(zzamf2);
        if (n != 3) {
            if (n == 8) return zzpo.zzi(zzamf2);
            if (n != 10) {
                if (n != 11) {
                    return null;
                }
                Date date = new Date((long)zzpo.zzg(zzamf2).doubleValue());
                zzamf2.zzk(2);
                return date;
            }
            int n3 = zzamf2.zzB();
            ArrayList<Object> arrayList = new ArrayList<Object>(n3);
            n = n2;
            while (n < n3) {
                Object object = zzpo.zzj(zzamf2, zzamf2.zzn());
                if (object != null) {
                    arrayList.add(object);
                }
                ++n;
            }
            return arrayList;
        }
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        while (true) {
            String string = zzpo.zzh(zzamf2);
            n = zzamf2.zzn();
            if (n == 9) {
                return hashMap;
            }
            Object object = zzpo.zzj(zzamf2, n);
            if (object == null) continue;
            hashMap.put(string, object);
        }
    }

    protected final boolean zza(zzamf zzamf2) {
        return true;
    }

    protected final boolean zzb(zzamf object, long l) {
        block5: {
            double d;
            if (object.zzn() != 2) {
                return false;
            }
            if (!"onMetaData".equals(zzpo.zzh((zzamf)object))) return false;
            if (object.zzn() != 8) {
                return false;
            }
            HashMap<String, Object> hashMap = zzpo.zzi((zzamf)object);
            if ((object = hashMap.get("duration")) instanceof Double && (d = ((Double)object).doubleValue()) > 0.0) {
                this.zzb = (long)(d * 1000000.0);
            }
            if (!((object = hashMap.get("keyframes")) instanceof Map)) return false;
            hashMap = (Map)object;
            object = hashMap.get("filepositions");
            hashMap = hashMap.get("times");
            if (!(object instanceof List)) return false;
            if (!(hashMap instanceof List)) return false;
            object = (List)object;
            List list = (List)((Object)hashMap);
            int n = list.size();
            this.zzc = new long[n];
            this.zzd = new long[n];
            int n2 = 0;
            while (n2 < n) {
                hashMap = object.get(n2);
                Object e = list.get(n2);
                if (e instanceof Double && hashMap instanceof Double) {
                    this.zzc[n2] = (long)((Double)e * 1000000.0);
                    this.zzd[n2] = ((Double)((Object)hashMap)).longValue();
                    ++n2;
                    continue;
                }
                break block5;
            }
            return false;
        }
        this.zzc = new long[0];
        this.zzd = new long[0];
        return false;
    }

    public final long zzc() {
        return this.zzb;
    }

    public final long[] zzd() {
        return this.zzc;
    }

    public final long[] zze() {
        return this.zzd;
    }
}
