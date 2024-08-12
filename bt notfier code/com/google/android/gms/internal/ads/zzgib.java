/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzgex
 *  com.google.android.gms.internal.ads.zzgfh
 *  com.google.android.gms.internal.ads.zzgfi
 *  com.google.android.gms.internal.ads.zzgfn
 *  com.google.android.gms.internal.ads.zzgfq
 *  com.google.android.gms.internal.ads.zzgga
 *  com.google.android.gms.internal.ads.zzggb
 *  com.google.android.gms.internal.ads.zzgge
 *  com.google.android.gms.internal.ads.zzggq
 *  com.google.android.gms.internal.ads.zzggs
 *  com.google.android.gms.internal.ads.zzggx
 *  com.google.android.gms.internal.ads.zzghd
 *  com.google.android.gms.internal.ads.zzghi
 *  com.google.android.gms.internal.ads.zzghz
 *  com.google.android.gms.internal.ads.zzgio
 *  com.google.android.gms.internal.ads.zzgiq
 *  com.google.android.gms.internal.ads.zzgiy
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgex;
import com.google.android.gms.internal.ads.zzgfh;
import com.google.android.gms.internal.ads.zzgfi;
import com.google.android.gms.internal.ads.zzgfn;
import com.google.android.gms.internal.ads.zzgfq;
import com.google.android.gms.internal.ads.zzgga;
import com.google.android.gms.internal.ads.zzggb;
import com.google.android.gms.internal.ads.zzgge;
import com.google.android.gms.internal.ads.zzggq;
import com.google.android.gms.internal.ads.zzggs;
import com.google.android.gms.internal.ads.zzggx;
import com.google.android.gms.internal.ads.zzghd;
import com.google.android.gms.internal.ads.zzghi;
import com.google.android.gms.internal.ads.zzghz;
import com.google.android.gms.internal.ads.zzgio;
import com.google.android.gms.internal.ads.zzgiq;
import com.google.android.gms.internal.ads.zzgiy;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

final class zzgib {
    private static final Class<?> zza;
    private static final zzgio<?, ?> zzb;
    private static final zzgio<?, ?> zzc;
    private static final zzgio<?, ?> zzd;

    static {
        Class<?> clazz;
        try {
            clazz = Class.forName("com.google.protobuf.GeneratedMessage");
        }
        catch (Throwable throwable) {
            clazz = null;
        }
        zza = clazz;
        zzb = zzgib.zzab(false);
        zzc = zzgib.zzab(true);
        zzd = new zzgiq();
    }

    public static zzgio<?, ?> zzA() {
        return zzb;
    }

    public static zzgio<?, ?> zzB() {
        return zzc;
    }

    public static zzgio<?, ?> zzC() {
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

    static <T, FT extends zzgfq<FT>> void zzE(zzgfn<FT> zzgfn2, T t, T t2) {
        zzgfn2.zzb(t2);
        throw null;
    }

    static <T, UT, UB> void zzF(zzgio<UT, UB> zzgio2, T t, T t2) {
        zzgio2.zzi(t, zzgio2.zzo(zzgio2.zzj(t), zzgio2.zzj(t2)));
    }

    static <UT, UB> UB zzG(int n, List<Integer> list, zzgge zzgge2, UB UB, zzgio<UT, UB> zzgio2) {
        int n2;
        int n3;
        if (zzgge2 == null) {
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
                if (zzgge2.zza(n4)) continue;
                UB = zzgib.zzH(n, n4, UB, zzgio2);
                iterator.remove();
            }
        }
        for (int i = 0; i < n3; ++i) {
            int n5 = list.get(i);
            if (zzgge2.zza(n5)) {
                if (i != n2) {
                    list.set(n2, n5);
                }
                ++n2;
                continue;
            }
            UB = zzgib.zzH(n, n5, UB, zzgio2);
        }
        if (n2 == n3) {
            list = UB;
            return (UB)list;
        }
        list.subList(n2, n3).clear();
        return UB;
    }

    static <UT, UB> UB zzH(int n, int n2, UB UB, zzgio<UT, UB> zzgio2) {
        Object object = UB;
        if (UB == null) {
            object = zzgio2.zzg();
        }
        zzgio2.zzb(object, n, (long)n2);
        return object;
    }

    static <T> void zzI(zzghd zzghd2, T t, T t2, long l) {
        zzgiy.zzo(t, (long)l, (Object)zzghd.zzc((Object)zzgiy.zzn(t, (long)l), (Object)zzgiy.zzn(t2, (long)l)));
    }

    public static void zzJ(int n, List<Double> list, zzgfi zzgfi2, boolean bl) throws IOException {
        if (list == null) return;
        if (list.isEmpty()) return;
        zzgfi2.zzB(n, list, bl);
    }

    public static void zzK(int n, List<Float> list, zzgfi zzgfi2, boolean bl) throws IOException {
        if (list == null) return;
        if (list.isEmpty()) return;
        zzgfi2.zzA(n, list, bl);
    }

    public static void zzL(int n, List<Long> list, zzgfi zzgfi2, boolean bl) throws IOException {
        if (list == null) return;
        if (list.isEmpty()) return;
        zzgfi2.zzx(n, list, bl);
    }

    public static void zzM(int n, List<Long> list, zzgfi zzgfi2, boolean bl) throws IOException {
        if (list == null) return;
        if (list.isEmpty()) return;
        zzgfi2.zzy(n, list, bl);
    }

    public static void zzN(int n, List<Long> list, zzgfi zzgfi2, boolean bl) throws IOException {
        if (list == null) return;
        if (list.isEmpty()) return;
        zzgfi2.zzK(n, list, bl);
    }

    public static void zzO(int n, List<Long> list, zzgfi zzgfi2, boolean bl) throws IOException {
        if (list == null) return;
        if (list.isEmpty()) return;
        zzgfi2.zzz(n, list, bl);
    }

    public static void zzP(int n, List<Long> list, zzgfi zzgfi2, boolean bl) throws IOException {
        if (list == null) return;
        if (list.isEmpty()) return;
        zzgfi2.zzI(n, list, bl);
    }

    public static void zzQ(int n, List<Integer> list, zzgfi zzgfi2, boolean bl) throws IOException {
        if (list == null) return;
        if (list.isEmpty()) return;
        zzgfi2.zzv(n, list, bl);
    }

    public static void zzR(int n, List<Integer> list, zzgfi zzgfi2, boolean bl) throws IOException {
        if (list == null) return;
        if (list.isEmpty()) return;
        zzgfi2.zzG(n, list, bl);
    }

    public static void zzS(int n, List<Integer> list, zzgfi zzgfi2, boolean bl) throws IOException {
        if (list == null) return;
        if (list.isEmpty()) return;
        zzgfi2.zzJ(n, list, bl);
    }

    public static void zzT(int n, List<Integer> list, zzgfi zzgfi2, boolean bl) throws IOException {
        if (list == null) return;
        if (list.isEmpty()) return;
        zzgfi2.zzw(n, list, bl);
    }

    public static void zzU(int n, List<Integer> list, zzgfi zzgfi2, boolean bl) throws IOException {
        if (list == null) return;
        if (list.isEmpty()) return;
        zzgfi2.zzH(n, list, bl);
    }

    public static void zzV(int n, List<Integer> list, zzgfi zzgfi2, boolean bl) throws IOException {
        if (list == null) return;
        if (list.isEmpty()) return;
        zzgfi2.zzC(n, list, bl);
    }

    public static void zzW(int n, List<Boolean> list, zzgfi zzgfi2, boolean bl) throws IOException {
        if (list == null) return;
        if (list.isEmpty()) return;
        zzgfi2.zzD(n, list, bl);
    }

    public static void zzX(int n, List<String> list, zzgfi zzgfi2) throws IOException {
        if (list == null) return;
        if (list.isEmpty()) return;
        zzgfi2.zzE(n, list);
    }

    public static void zzY(int n, List<zzgex> list, zzgfi zzgfi2) throws IOException {
        if (list == null) return;
        if (list.isEmpty()) return;
        zzgfi2.zzF(n, list);
    }

    public static void zzZ(int n, List<?> list, zzgfi zzgfi2, zzghz zzghz2) throws IOException {
        if (list == null) return;
        if (list.isEmpty()) return;
        int n2 = 0;
        while (n2 < list.size()) {
            zzgfi2.zzr(n, list.get(n2), zzghz2);
            ++n2;
        }
    }

    public static void zza(Class<?> clazz) {
        if (zzgga.class.isAssignableFrom(clazz)) return;
        Class<?> clazz2 = zza;
        if (clazz2 == null) return;
        if (!clazz2.isAssignableFrom(clazz)) throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
    }

    public static void zzaa(int n, List<?> list, zzgfi zzgfi2, zzghz zzghz2) throws IOException {
        if (list == null) return;
        if (list.isEmpty()) return;
        int n2 = 0;
        while (n2 < list.size()) {
            zzgfi2.zzs(n, list.get(n2), zzghz2);
            ++n2;
        }
    }

    private static zzgio<?, ?> zzab(boolean bl) {
        zzgio zzgio2;
        try {
            zzgio2 = Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        }
        catch (Throwable throwable) {
            zzgio2 = null;
        }
        if (zzgio2 == null) {
            return null;
        }
        try {
            zzgio2 = (zzgio)zzgio2.getConstructor(Boolean.TYPE).newInstance(bl);
            return zzgio2;
        }
        catch (Throwable throwable) {
            return null;
        }
    }

    static int zzb(List<Long> zzggx2) {
        int n = zzggx2.size();
        int n2 = 0;
        int n3 = 0;
        if (n == 0) {
            return 0;
        }
        if (zzggx2 instanceof zzggx) {
            zzggx2 = zzggx2;
            int n4 = 0;
            while (true) {
                n2 = n4;
                if (n3 >= n) return n2;
                n4 += zzgfh.zzy((long)zzggx2.zzf(n3));
                ++n3;
            }
        }
        int n5 = 0;
        n3 = n2;
        while (true) {
            n2 = n5;
            if (n3 >= n) return n2;
            n5 += zzgfh.zzy((long)((Long)zzggx2.get(n3)));
            ++n3;
        }
    }

    static int zzc(int n, List<Long> list, boolean bl) {
        if (list.size() != 0) return zzgib.zzb(list) + list.size() * zzgfh.zzv((int)n);
        return 0;
    }

    static int zzd(List<Long> zzggx2) {
        int n = zzggx2.size();
        int n2 = 0;
        int n3 = 0;
        if (n == 0) {
            return 0;
        }
        if (zzggx2 instanceof zzggx) {
            zzggx2 = zzggx2;
            int n4 = 0;
            while (true) {
                n2 = n4;
                if (n3 >= n) return n2;
                n4 += zzgfh.zzy((long)zzggx2.zzf(n3));
                ++n3;
            }
        }
        int n5 = 0;
        n3 = n2;
        while (true) {
            n2 = n5;
            if (n3 >= n) return n2;
            n5 += zzgfh.zzy((long)((Long)zzggx2.get(n3)));
            ++n3;
        }
    }

    static int zze(int n, List<Long> list, boolean bl) {
        int n2 = list.size();
        if (n2 != 0) return zzgib.zzd(list) + n2 * zzgfh.zzv((int)n);
        return 0;
    }

    static int zzf(List<Long> zzggx2) {
        int n = zzggx2.size();
        int n2 = 0;
        int n3 = 0;
        if (n == 0) {
            return 0;
        }
        if (zzggx2 instanceof zzggx) {
            zzggx2 = zzggx2;
            int n4 = 0;
            while (true) {
                n2 = n4;
                if (n3 >= n) return n2;
                long l = zzggx2.zzf(n3);
                n4 += zzgfh.zzy((long)(l >> 63 ^ l + l));
                ++n3;
            }
        }
        int n5 = 0;
        n3 = n2;
        while (true) {
            n2 = n5;
            if (n3 >= n) return n2;
            long l = (Long)zzggx2.get(n3);
            n5 += zzgfh.zzy((long)(l >> 63 ^ l + l));
            ++n3;
        }
    }

    static int zzg(int n, List<Long> list, boolean bl) {
        int n2 = list.size();
        if (n2 != 0) return zzgib.zzf(list) + n2 * zzgfh.zzv((int)n);
        return 0;
    }

    static int zzh(List<Integer> zzggb2) {
        int n = zzggb2.size();
        int n2 = 0;
        int n3 = 0;
        if (n == 0) {
            return 0;
        }
        if (zzggb2 instanceof zzggb) {
            zzggb2 = zzggb2;
            int n4 = 0;
            n2 = n3;
            while (true) {
                n3 = n4;
                if (n2 >= n) return n3;
                n4 += zzgfh.zzw((int)zzggb2.zzg(n2));
                ++n2;
            }
        }
        int n5 = 0;
        while (true) {
            n3 = n5;
            if (n2 >= n) return n3;
            n5 += zzgfh.zzw((int)((Integer)zzggb2.get(n2)));
            ++n2;
        }
    }

    static int zzi(int n, List<Integer> list, boolean bl) {
        int n2 = list.size();
        if (n2 != 0) return zzgib.zzh(list) + n2 * zzgfh.zzv((int)n);
        return 0;
    }

    static int zzj(List<Integer> zzggb2) {
        int n = zzggb2.size();
        int n2 = 0;
        int n3 = 0;
        if (n == 0) {
            return 0;
        }
        if (zzggb2 instanceof zzggb) {
            zzggb2 = zzggb2;
            int n4 = 0;
            while (true) {
                n2 = n4;
                if (n3 >= n) return n2;
                n4 += zzgfh.zzw((int)zzggb2.zzg(n3));
                ++n3;
            }
        }
        int n5 = 0;
        n3 = n2;
        while (true) {
            n2 = n5;
            if (n3 >= n) return n2;
            n5 += zzgfh.zzw((int)((Integer)zzggb2.get(n3)));
            ++n3;
        }
    }

    static int zzk(int n, List<Integer> list, boolean bl) {
        int n2 = list.size();
        if (n2 != 0) return zzgib.zzj(list) + n2 * zzgfh.zzv((int)n);
        return 0;
    }

    static int zzl(List<Integer> zzggb2) {
        int n = zzggb2.size();
        int n2 = 0;
        int n3 = 0;
        if (n == 0) {
            return 0;
        }
        if (zzggb2 instanceof zzggb) {
            zzggb2 = zzggb2;
            int n4 = 0;
            while (true) {
                n2 = n4;
                if (n3 >= n) return n2;
                n4 += zzgfh.zzx((int)zzggb2.zzg(n3));
                ++n3;
            }
        }
        int n5 = 0;
        n3 = n2;
        while (true) {
            n2 = n5;
            if (n3 >= n) return n2;
            n5 += zzgfh.zzx((int)((Integer)zzggb2.get(n3)));
            ++n3;
        }
    }

    static int zzm(int n, List<Integer> list, boolean bl) {
        int n2 = list.size();
        if (n2 != 0) return zzgib.zzl(list) + n2 * zzgfh.zzv((int)n);
        return 0;
    }

    static int zzn(List<Integer> zzggb2) {
        int n = zzggb2.size();
        int n2 = 0;
        int n3 = 0;
        if (n == 0) {
            return 0;
        }
        if (zzggb2 instanceof zzggb) {
            zzggb2 = zzggb2;
            int n4 = 0;
            while (true) {
                n2 = n4;
                if (n3 >= n) return n2;
                n2 = zzggb2.zzg(n3);
                n4 += zzgfh.zzx((int)(n2 >> 31 ^ n2 + n2));
                ++n3;
            }
        }
        int n5 = 0;
        n3 = n2;
        while (true) {
            n2 = n5;
            if (n3 >= n) return n2;
            n2 = (Integer)zzggb2.get(n3);
            n5 += zzgfh.zzx((int)(n2 >> 31 ^ n2 + n2));
            ++n3;
        }
    }

    static int zzo(int n, List<Integer> list, boolean bl) {
        int n2 = list.size();
        if (n2 != 0) return zzgib.zzn(list) + n2 * zzgfh.zzv((int)n);
        return 0;
    }

    static int zzp(List<?> list) {
        return list.size() * 4;
    }

    static int zzq(int n, List<?> list, boolean bl) {
        int n2 = list.size();
        if (n2 != 0) return n2 * (zzgfh.zzx((int)(n << 3)) + 4);
        return 0;
    }

    static int zzr(List<?> list) {
        return list.size() * 8;
    }

    static int zzs(int n, List<?> list, boolean bl) {
        int n2 = list.size();
        if (n2 != 0) return n2 * (zzgfh.zzx((int)(n << 3)) + 8);
        return 0;
    }

    static int zzt(List<?> list) {
        return list.size();
    }

    static int zzu(int n, List<?> list, boolean bl) {
        int n2 = list.size();
        if (n2 != 0) return n2 * (zzgfh.zzx((int)(n << 3)) + 1);
        return 0;
    }

    static int zzv(int n, List<?> object) {
        int n2;
        int n3 = object.size();
        int n4 = 0;
        int n5 = 0;
        if (n3 == 0) {
            return 0;
        }
        n = n2 = zzgfh.zzv((int)n) * n3;
        if (object instanceof zzggs) {
            zzggs zzggs2 = (zzggs)object;
            n = n2;
            n4 = n5;
            while (true) {
                n2 = n;
                if (n4 >= n3) return n2;
                object = zzggs2.zzg(n4);
                n2 = object instanceof zzgex ? zzgfh.zzB((zzgex)((zzgex)object)) : zzgfh.zzz((String)((String)object));
                n += n2;
                ++n4;
            }
        }
        while (true) {
            n2 = n;
            if (n4 >= n3) return n2;
            Object obj = object.get(n4);
            n2 = obj instanceof zzgex ? zzgfh.zzB((zzgex)((zzgex)obj)) : zzgfh.zzz((String)((String)obj));
            n += n2;
            ++n4;
        }
    }

    static int zzw(int n, Object object, zzghz zzghz2) {
        if (object instanceof zzggq) {
            object = (zzggq)object;
            n = zzgfh.zzx((int)(n << 3));
            int n2 = object.zza();
            return n + (zzgfh.zzx((int)n2) + n2);
        }
        object = (zzghi)object;
        return zzgfh.zzx((int)(n << 3)) + zzgfh.zzC((zzghi)object, (zzghz)zzghz2);
    }

    static int zzx(int n, List<?> list, zzghz zzghz2) {
        int n2 = list.size();
        int n3 = 0;
        if (n2 == 0) {
            return 0;
        }
        int n4 = zzgfh.zzv((int)n) * n2;
        n = n3;
        while (n < n2) {
            Object obj = list.get(n);
            n3 = obj instanceof zzggq ? zzgfh.zzA((zzggq)((zzggq)obj)) : zzgfh.zzC((zzghi)((zzghi)obj), (zzghz)zzghz2);
            n4 += n3;
            ++n;
        }
        return n4;
    }

    static int zzy(int n, List<zzgex> list) {
        int n2 = list.size();
        int n3 = 0;
        if (n2 == 0) {
            return 0;
        }
        n2 *= zzgfh.zzv((int)n);
        n = n3;
        n3 = n2;
        while (n < list.size()) {
            n3 += zzgfh.zzB((zzgex)list.get(n));
            ++n;
        }
        return n3;
    }

    static int zzz(int n, List<zzghi> list, zzghz zzghz2) {
        int n2 = list.size();
        int n3 = 0;
        if (n2 == 0) return 0;
        int n4 = 0;
        while (n3 < n2) {
            n4 += zzgfh.zzF((int)n, (zzghi)list.get(n3), (zzghz)zzghz2);
            ++n3;
        }
        return n4;
    }
}
