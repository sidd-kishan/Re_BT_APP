/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.measurement.zzgr
 *  com.google.android.gms.internal.measurement.zzgy
 *  com.google.android.gms.internal.measurement.zzgz
 *  com.google.android.gms.internal.measurement.zzhe
 *  com.google.android.gms.internal.measurement.zzhh
 *  com.google.android.gms.internal.measurement.zzhr
 *  com.google.android.gms.internal.measurement.zzhs
 *  com.google.android.gms.internal.measurement.zzhv
 *  com.google.android.gms.internal.measurement.zzie
 *  com.google.android.gms.internal.measurement.zzig
 *  com.google.android.gms.internal.measurement.zzil
 *  com.google.android.gms.internal.measurement.zzir
 *  com.google.android.gms.internal.measurement.zziw
 *  com.google.android.gms.internal.measurement.zzjh
 *  com.google.android.gms.internal.measurement.zzjv
 *  com.google.android.gms.internal.measurement.zzjx
 *  com.google.android.gms.internal.measurement.zzkf
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzgr;
import com.google.android.gms.internal.measurement.zzgy;
import com.google.android.gms.internal.measurement.zzgz;
import com.google.android.gms.internal.measurement.zzhe;
import com.google.android.gms.internal.measurement.zzhh;
import com.google.android.gms.internal.measurement.zzhr;
import com.google.android.gms.internal.measurement.zzhs;
import com.google.android.gms.internal.measurement.zzhv;
import com.google.android.gms.internal.measurement.zzie;
import com.google.android.gms.internal.measurement.zzig;
import com.google.android.gms.internal.measurement.zzil;
import com.google.android.gms.internal.measurement.zzir;
import com.google.android.gms.internal.measurement.zziw;
import com.google.android.gms.internal.measurement.zzjh;
import com.google.android.gms.internal.measurement.zzjv;
import com.google.android.gms.internal.measurement.zzjx;
import com.google.android.gms.internal.measurement.zzkf;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

final class zzjj {
    private static final Class<?> zza;
    private static final zzjv<?, ?> zzb;
    private static final zzjv<?, ?> zzc;
    private static final zzjv<?, ?> zzd;

    static {
        Class<?> clazz;
        try {
            clazz = Class.forName("com.google.protobuf.GeneratedMessage");
        }
        catch (Throwable throwable) {
            clazz = null;
        }
        zza = clazz;
        zzb = zzjj.zzab(false);
        zzc = zzjj.zzab(true);
        zzd = new zzjx();
    }

    public static zzjv<?, ?> zzA() {
        return zzb;
    }

    public static zzjv<?, ?> zzB() {
        return zzc;
    }

    public static zzjv<?, ?> zzC() {
        return zzd;
    }

    static boolean zzD(Object object, Object object2) {
        boolean bl = false;
        if (object != object2) {
            if (object == null) return bl;
            if (!object.equals(object2)) return false;
        }
        bl = true;
        return bl;
    }

    static <T, FT extends zzhh<FT>> void zzE(zzhe<FT> zzhe2, T t, T t2) {
        zzhe2.zzb(t2);
        throw null;
    }

    static <T, UT, UB> void zzF(zzjv<UT, UB> zzjv2, T t, T t2) {
        zzjv2.zzc(t, zzjv2.zzf(zzjv2.zzd(t), zzjv2.zzd(t2)));
    }

    static <UT, UB> UB zzG(int n, List<Integer> list, zzhv zzhv2, UB UB, zzjv<UT, UB> zzjv2) {
        int n2;
        int n3;
        if (zzhv2 == null) {
            return UB;
        }
        if (list instanceof RandomAccess) {
            n3 = list.size();
            n2 = 0;
        } else {
            Iterator<Integer> iterator = list.iterator();
            while (true) {
                list = UB;
                if (!iterator.hasNext()) return (UB)list;
                int n4 = iterator.next();
                if (zzhv2.zza(n4)) continue;
                UB = zzjj.zzH(n, n4, UB, zzjv2);
                iterator.remove();
            }
        }
        for (int i = 0; i < n3; ++i) {
            int n5 = list.get(i);
            if (zzhv2.zza(n5)) {
                if (i != n2) {
                    list.set(n2, n5);
                }
                ++n2;
                continue;
            }
            UB = zzjj.zzH(n, n5, UB, zzjv2);
        }
        if (n2 == n3) {
            list = UB;
            return (UB)list;
        }
        list.subList(n2, n3).clear();
        return UB;
    }

    static <UT, UB> UB zzH(int n, int n2, UB UB, zzjv<UT, UB> zzjv2) {
        Object object = UB;
        if (UB == null) {
            object = zzjv2.zzb();
        }
        zzjv2.zza(object, n, (long)n2);
        return object;
    }

    static <T> void zzI(zzir zzir2, T t, T t2, long l) {
        zzkf.zzo(t, (long)l, (Object)zzir.zzb((Object)zzkf.zzn(t, (long)l), (Object)zzkf.zzn(t2, (long)l)));
    }

    public static void zzJ(int n, List<Double> list, zzgz zzgz2, boolean bl) throws IOException {
        if (list == null) return;
        if (list.isEmpty()) return;
        zzgz2.zzB(n, list, bl);
    }

    public static void zzK(int n, List<Float> list, zzgz zzgz2, boolean bl) throws IOException {
        if (list == null) return;
        if (list.isEmpty()) return;
        zzgz2.zzA(n, list, bl);
    }

    public static void zzL(int n, List<Long> list, zzgz zzgz2, boolean bl) throws IOException {
        if (list == null) return;
        if (list.isEmpty()) return;
        zzgz2.zzx(n, list, bl);
    }

    public static void zzM(int n, List<Long> list, zzgz zzgz2, boolean bl) throws IOException {
        if (list == null) return;
        if (list.isEmpty()) return;
        zzgz2.zzy(n, list, bl);
    }

    public static void zzN(int n, List<Long> list, zzgz zzgz2, boolean bl) throws IOException {
        if (list == null) return;
        if (list.isEmpty()) return;
        zzgz2.zzK(n, list, bl);
    }

    public static void zzO(int n, List<Long> list, zzgz zzgz2, boolean bl) throws IOException {
        if (list == null) return;
        if (list.isEmpty()) return;
        zzgz2.zzz(n, list, bl);
    }

    public static void zzP(int n, List<Long> list, zzgz zzgz2, boolean bl) throws IOException {
        if (list == null) return;
        if (list.isEmpty()) return;
        zzgz2.zzI(n, list, bl);
    }

    public static void zzQ(int n, List<Integer> list, zzgz zzgz2, boolean bl) throws IOException {
        if (list == null) return;
        if (list.isEmpty()) return;
        zzgz2.zzv(n, list, bl);
    }

    public static void zzR(int n, List<Integer> list, zzgz zzgz2, boolean bl) throws IOException {
        if (list == null) return;
        if (list.isEmpty()) return;
        zzgz2.zzG(n, list, bl);
    }

    public static void zzS(int n, List<Integer> list, zzgz zzgz2, boolean bl) throws IOException {
        if (list == null) return;
        if (list.isEmpty()) return;
        zzgz2.zzJ(n, list, bl);
    }

    public static void zzT(int n, List<Integer> list, zzgz zzgz2, boolean bl) throws IOException {
        if (list == null) return;
        if (list.isEmpty()) return;
        zzgz2.zzw(n, list, bl);
    }

    public static void zzU(int n, List<Integer> list, zzgz zzgz2, boolean bl) throws IOException {
        if (list == null) return;
        if (list.isEmpty()) return;
        zzgz2.zzH(n, list, bl);
    }

    public static void zzV(int n, List<Integer> list, zzgz zzgz2, boolean bl) throws IOException {
        if (list == null) return;
        if (list.isEmpty()) return;
        zzgz2.zzC(n, list, bl);
    }

    public static void zzW(int n, List<Boolean> list, zzgz zzgz2, boolean bl) throws IOException {
        if (list == null) return;
        if (list.isEmpty()) return;
        zzgz2.zzD(n, list, bl);
    }

    public static void zzX(int n, List<String> list, zzgz zzgz2) throws IOException {
        if (list == null) return;
        if (list.isEmpty()) return;
        zzgz2.zzE(n, list);
    }

    public static void zzY(int n, List<zzgr> list, zzgz zzgz2) throws IOException {
        if (list == null) return;
        if (list.isEmpty()) return;
        zzgz2.zzF(n, list);
    }

    public static void zzZ(int n, List<?> list, zzgz zzgz2, zzjh zzjh2) throws IOException {
        if (list == null) return;
        if (list.isEmpty()) return;
        int n2 = 0;
        while (n2 < list.size()) {
            zzgz2.zzr(n, list.get(n2), zzjh2);
            ++n2;
        }
    }

    public static void zza(Class<?> clazz) {
        if (zzhr.class.isAssignableFrom(clazz)) return;
        Class<?> clazz2 = zza;
        if (clazz2 == null) return;
        if (!clazz2.isAssignableFrom(clazz)) throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
    }

    public static void zzaa(int n, List<?> list, zzgz zzgz2, zzjh zzjh2) throws IOException {
        if (list == null) return;
        if (list.isEmpty()) return;
        int n2 = 0;
        while (n2 < list.size()) {
            zzgz2.zzs(n, list.get(n2), zzjh2);
            ++n2;
        }
    }

    private static zzjv<?, ?> zzab(boolean bl) {
        zzjv zzjv2;
        try {
            zzjv2 = Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        }
        catch (Throwable throwable) {
            zzjv2 = null;
        }
        if (zzjv2 == null) {
            return null;
        }
        try {
            zzjv2 = (zzjv)zzjv2.getConstructor(Boolean.TYPE).newInstance(bl);
            return zzjv2;
        }
        catch (Throwable throwable) {
            return null;
        }
    }

    static int zzb(List<Long> zzil2) {
        int n = zzil2.size();
        int n2 = 0;
        int n3 = 0;
        if (n == 0) {
            return 0;
        }
        if (zzil2 instanceof zzil) {
            zzil2 = zzil2;
            int n4 = 0;
            n2 = n3;
            while (true) {
                n3 = n4;
                if (n2 >= n) return n3;
                n4 += zzgy.zzx((long)zzil2.zzc(n2));
                ++n2;
            }
        }
        int n5 = 0;
        while (true) {
            n3 = n5;
            if (n2 >= n) return n3;
            n5 += zzgy.zzx((long)((Long)zzil2.get(n2)));
            ++n2;
        }
    }

    static int zzc(int n, List<Long> list, boolean bl) {
        if (list.size() != 0) return zzjj.zzb(list) + list.size() * zzgy.zzu((int)n);
        return 0;
    }

    static int zzd(List<Long> zzil2) {
        int n = zzil2.size();
        int n2 = 0;
        int n3 = 0;
        if (n == 0) {
            return 0;
        }
        if (zzil2 instanceof zzil) {
            zzil2 = zzil2;
            int n4 = 0;
            n2 = n3;
            while (true) {
                n3 = n4;
                if (n2 >= n) return n3;
                n4 += zzgy.zzx((long)zzil2.zzc(n2));
                ++n2;
            }
        }
        int n5 = 0;
        while (true) {
            n3 = n5;
            if (n2 >= n) return n3;
            n5 += zzgy.zzx((long)((Long)zzil2.get(n2)));
            ++n2;
        }
    }

    static int zze(int n, List<Long> list, boolean bl) {
        int n2 = list.size();
        if (n2 != 0) return zzjj.zzd(list) + n2 * zzgy.zzu((int)n);
        return 0;
    }

    static int zzf(List<Long> zzil2) {
        int n = zzil2.size();
        int n2 = 0;
        int n3 = 0;
        if (n == 0) {
            return 0;
        }
        if (zzil2 instanceof zzil) {
            zzil2 = zzil2;
            int n4 = 0;
            while (true) {
                n2 = n4;
                if (n3 >= n) return n2;
                long l = zzil2.zzc(n3);
                n4 += zzgy.zzx((long)(l >> 63 ^ l + l));
                ++n3;
            }
        }
        int n5 = 0;
        n3 = n2;
        while (true) {
            n2 = n5;
            if (n3 >= n) return n2;
            long l = (Long)zzil2.get(n3);
            n5 += zzgy.zzx((long)(l >> 63 ^ l + l));
            ++n3;
        }
    }

    static int zzg(int n, List<Long> list, boolean bl) {
        int n2 = list.size();
        if (n2 != 0) return zzjj.zzf(list) + n2 * zzgy.zzu((int)n);
        return 0;
    }

    static int zzh(List<Integer> zzhs2) {
        int n = zzhs2.size();
        int n2 = 0;
        int n3 = 0;
        if (n == 0) {
            return 0;
        }
        if (zzhs2 instanceof zzhs) {
            zzhs2 = zzhs2;
            int n4 = 0;
            n2 = n3;
            while (true) {
                n3 = n4;
                if (n2 >= n) return n3;
                n4 += zzgy.zzv((int)zzhs2.zzg(n2));
                ++n2;
            }
        }
        int n5 = 0;
        while (true) {
            n3 = n5;
            if (n2 >= n) return n3;
            n5 += zzgy.zzv((int)((Integer)zzhs2.get(n2)));
            ++n2;
        }
    }

    static int zzi(int n, List<Integer> list, boolean bl) {
        int n2 = list.size();
        if (n2 != 0) return zzjj.zzh(list) + n2 * zzgy.zzu((int)n);
        return 0;
    }

    static int zzj(List<Integer> zzhs2) {
        int n = zzhs2.size();
        int n2 = 0;
        int n3 = 0;
        if (n == 0) {
            return 0;
        }
        if (zzhs2 instanceof zzhs) {
            zzhs2 = zzhs2;
            int n4 = 0;
            while (true) {
                n2 = n4;
                if (n3 >= n) return n2;
                n4 += zzgy.zzv((int)zzhs2.zzg(n3));
                ++n3;
            }
        }
        int n5 = 0;
        n3 = n2;
        while (true) {
            n2 = n5;
            if (n3 >= n) return n2;
            n5 += zzgy.zzv((int)((Integer)zzhs2.get(n3)));
            ++n3;
        }
    }

    static int zzk(int n, List<Integer> list, boolean bl) {
        int n2 = list.size();
        if (n2 != 0) return zzjj.zzj(list) + n2 * zzgy.zzu((int)n);
        return 0;
    }

    static int zzl(List<Integer> zzhs2) {
        int n = zzhs2.size();
        int n2 = 0;
        int n3 = 0;
        if (n == 0) {
            return 0;
        }
        if (zzhs2 instanceof zzhs) {
            zzhs2 = zzhs2;
            int n4 = 0;
            while (true) {
                n2 = n4;
                if (n3 >= n) return n2;
                n4 += zzgy.zzw((int)zzhs2.zzg(n3));
                ++n3;
            }
        }
        int n5 = 0;
        n3 = n2;
        while (true) {
            n2 = n5;
            if (n3 >= n) return n2;
            n5 += zzgy.zzw((int)((Integer)zzhs2.get(n3)));
            ++n3;
        }
    }

    static int zzm(int n, List<Integer> list, boolean bl) {
        int n2 = list.size();
        if (n2 != 0) return zzjj.zzl(list) + n2 * zzgy.zzu((int)n);
        return 0;
    }

    static int zzn(List<Integer> zzhs2) {
        int n = zzhs2.size();
        int n2 = 0;
        int n3 = 0;
        if (n == 0) {
            return 0;
        }
        if (zzhs2 instanceof zzhs) {
            zzhs2 = zzhs2;
            int n4 = 0;
            n2 = n3;
            while (true) {
                n3 = n4;
                if (n2 >= n) return n3;
                n3 = zzhs2.zzg(n2);
                n4 += zzgy.zzw((int)(n3 >> 31 ^ n3 + n3));
                ++n2;
            }
        }
        int n5 = 0;
        while (true) {
            n3 = n5;
            if (n2 >= n) return n3;
            n3 = (Integer)zzhs2.get(n2);
            n5 += zzgy.zzw((int)(n3 >> 31 ^ n3 + n3));
            ++n2;
        }
    }

    static int zzo(int n, List<Integer> list, boolean bl) {
        int n2 = list.size();
        if (n2 != 0) return zzjj.zzn(list) + n2 * zzgy.zzu((int)n);
        return 0;
    }

    static int zzp(List<?> list) {
        return list.size() * 4;
    }

    static int zzq(int n, List<?> list, boolean bl) {
        int n2 = list.size();
        if (n2 != 0) return n2 * (zzgy.zzw((int)(n << 3)) + 4);
        return 0;
    }

    static int zzr(List<?> list) {
        return list.size() * 8;
    }

    static int zzs(int n, List<?> list, boolean bl) {
        int n2 = list.size();
        if (n2 != 0) return n2 * (zzgy.zzw((int)(n << 3)) + 8);
        return 0;
    }

    static int zzt(List<?> list) {
        return list.size();
    }

    static int zzu(int n, List<?> list, boolean bl) {
        int n2 = list.size();
        if (n2 != 0) return n2 * (zzgy.zzw((int)(n << 3)) + 1);
        return 0;
    }

    static int zzv(int n, List<?> zzig2) {
        int n2;
        int n3 = zzig2.size();
        int n4 = 0;
        int n5 = 0;
        if (n3 == 0) {
            return 0;
        }
        n = n2 = zzgy.zzu((int)n) * n3;
        if (zzig2 instanceof zzig) {
            zzig2 = zzig2;
            n = n2;
            n4 = n5;
            while (true) {
                n2 = n;
                if (n4 >= n3) return n2;
                Object object = zzig2.zzg(n4);
                n2 = object instanceof zzgr ? zzgy.zzA((zzgr)((zzgr)object)) : zzgy.zzy((String)((String)object));
                n += n2;
                ++n4;
            }
        }
        while (true) {
            n2 = n;
            if (n4 >= n3) return n2;
            Object e = zzig2.get(n4);
            n2 = e instanceof zzgr ? zzgy.zzA((zzgr)((zzgr)e)) : zzgy.zzy((String)((String)e));
            n += n2;
            ++n4;
        }
    }

    static int zzw(int n, Object object, zzjh zzjh2) {
        if (object instanceof zzie) {
            object = (zzie)object;
            n = zzgy.zzw((int)(n << 3));
            int n2 = object.zza();
            return n + (zzgy.zzw((int)n2) + n2);
        }
        object = (zziw)object;
        return zzgy.zzw((int)(n << 3)) + zzgy.zzB((zziw)object, (zzjh)zzjh2);
    }

    static int zzx(int n, List<?> list, zzjh zzjh2) {
        int n2 = list.size();
        int n3 = 0;
        if (n2 == 0) {
            return 0;
        }
        n = zzgy.zzu((int)n) * n2;
        while (n3 < n2) {
            Object obj = list.get(n3);
            int n4 = obj instanceof zzie ? zzgy.zzz((zzie)((zzie)obj)) : zzgy.zzB((zziw)((zziw)obj), (zzjh)zzjh2);
            n += n4;
            ++n3;
        }
        return n;
    }

    static int zzy(int n, List<zzgr> list) {
        int n2 = list.size();
        int n3 = 0;
        if (n2 == 0) {
            return 0;
        }
        n2 *= zzgy.zzu((int)n);
        n = n3;
        n3 = n2;
        while (n < list.size()) {
            n3 += zzgy.zzA((zzgr)list.get(n));
            ++n;
        }
        return n3;
    }

    static int zzz(int n, List<zziw> list, zzjh zzjh2) {
        int n2 = list.size();
        int n3 = 0;
        if (n2 == 0) return 0;
        int n4 = 0;
        while (n3 < n2) {
            n4 += zzgy.zzE((int)n, (zziw)list.get(n3), (zzjh)zzjh2);
            ++n3;
        }
        return n4;
    }
}
