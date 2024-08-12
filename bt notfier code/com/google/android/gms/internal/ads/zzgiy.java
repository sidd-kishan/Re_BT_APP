/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzgei
 *  com.google.android.gms.internal.ads.zzgiu
 *  com.google.android.gms.internal.ads.zzgiv
 *  com.google.android.gms.internal.ads.zzgiw
 *  com.google.android.gms.internal.ads.zzgix
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgei;
import com.google.android.gms.internal.ads.zzgiu;
import com.google.android.gms.internal.ads.zzgiv;
import com.google.android.gms.internal.ads.zzgiw;
import com.google.android.gms.internal.ads.zzgix;
import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

final class zzgiy {
    static final long zza;
    static final boolean zzb;
    private static final Unsafe zzc;
    private static final Class<?> zzd;
    private static final boolean zze;
    private static final boolean zzf;
    private static final zzgix zzg;
    private static final boolean zzh;
    private static final boolean zzi;
    private static final long zzj;

    static {
        long l;
        boolean bl;
        Object object;
        Object object2;
        boolean bl2;
        block13: {
            block12: {
                block11: {
                    zzc = zzgiy.zzt();
                    zzd = zzgei.zza();
                    zze = zzgiy.zzu(Long.TYPE);
                    zzf = bl2 = zzgiy.zzu(Integer.TYPE);
                    object2 = zzc;
                    object = null;
                    if (object2 != null) {
                        if (zze) {
                            object = new zzgiw((Unsafe)object2);
                        } else if (bl2) {
                            object = new zzgiv((Unsafe)object2);
                        }
                    }
                    zzg = object;
                    bl = true;
                    if (object != null && (object = ((zzgix)object).zza) != null) {
                        try {
                            object = object.getClass();
                            ((Class)object).getMethod("objectFieldOffset", Field.class);
                            ((Class)object).getMethod("getLong", Object.class, Long.TYPE);
                            object = zzgiy.zzE();
                            if (object == null) break block11;
                            bl2 = true;
                            break block12;
                        }
                        catch (Throwable throwable) {
                            zzgiy.zzB(throwable);
                        }
                    }
                }
                bl2 = false;
            }
            zzh = bl2;
            object = zzg;
            if (object != null && (object = ((zzgix)object).zza) != null) {
                try {
                    object = object.getClass();
                    ((Class)object).getMethod("objectFieldOffset", Field.class);
                    ((Class)object).getMethod("arrayBaseOffset", Class.class);
                    ((Class)object).getMethod("arrayIndexScale", Class.class);
                    ((Class)object).getMethod("getInt", Object.class, Long.TYPE);
                    ((Class)object).getMethod("putInt", Object.class, Long.TYPE, Integer.TYPE);
                    ((Class)object).getMethod("getLong", Object.class, Long.TYPE);
                    ((Class)object).getMethod("putLong", Object.class, Long.TYPE, Long.TYPE);
                    ((Class)object).getMethod("getObject", Object.class, Long.TYPE);
                    ((Class)object).getMethod("putObject", Object.class, Long.TYPE, Object.class);
                    bl2 = true;
                    break block13;
                }
                catch (Throwable throwable) {
                    zzgiy.zzB(throwable);
                }
            }
            bl2 = false;
        }
        zzi = bl2;
        zza = zzgiy.zzC(byte[].class);
        zzgiy.zzC(boolean[].class);
        zzgiy.zzD(boolean[].class);
        zzgiy.zzC(int[].class);
        zzgiy.zzD(int[].class);
        zzgiy.zzC(long[].class);
        zzgiy.zzD(long[].class);
        zzgiy.zzC(float[].class);
        zzgiy.zzD(float[].class);
        zzgiy.zzC(double[].class);
        zzgiy.zzD(double[].class);
        zzgiy.zzC(Object[].class);
        zzgiy.zzD(Object[].class);
        object2 = zzgiy.zzE();
        long l2 = l = -1L;
        if (object2 != null) {
            object = zzg;
            l2 = object == null ? l : object.zzj((Field)object2);
        }
        zzj = l2;
        bl2 = ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN ? bl : false;
        zzb = bl2;
    }

    private zzgiy() {
    }

    static /* synthetic */ void zzA(Object object, long l, boolean bl) {
        zzgiy.zzH(object, l, (byte)(bl ? 1 : 0));
    }

    static /* synthetic */ void zzB(Throwable throwable) {
        Logger.getLogger(zzgiy.class.getName()).logp(Level.WARNING, "com.google.protobuf.UnsafeUtil", "logMissingMethod", "platform method missing - proto runtime falling back to safer methods: ".concat(((Object)throwable).toString()));
    }

    private static int zzC(Class<?> clazz) {
        if (!zzi) return -1;
        return zzg.zzk(clazz);
    }

    private static int zzD(Class<?> clazz) {
        if (!zzi) return -1;
        return zzg.zzl(clazz);
    }

    private static Field zzE() {
        Field field;
        int n = zzgei.zza;
        Field field2 = field = zzgiy.zzF(Buffer.class, "effectiveDirectAddress");
        if (field != null) return field2;
        field2 = zzgiy.zzF(Buffer.class, "address");
        if (field2 != null && field2.getType() == Long.TYPE) {
            return field2;
        }
        field2 = null;
        return field2;
    }

    private static Field zzF(Class<?> annotatedElement, String string) {
        try {
            annotatedElement = annotatedElement.getDeclaredField(string);
        }
        catch (Throwable throwable) {
            annotatedElement = null;
        }
        return annotatedElement;
    }

    private static void zzG(Object object, long l, byte by) {
        long l2 = 0xFFFFFFFFFFFFFFFCL & l;
        int n = zzg.zzm(object, l2);
        int n2 = (~((int)l) & 3) << 3;
        zzg.zzn(object, l2, (by & 0xFF) << n2 | n & ~(255 << n2));
    }

    private static void zzH(Object object, long l, byte by) {
        long l2 = 0xFFFFFFFFFFFFFFFCL & l;
        int n = zzg.zzm(object, l2);
        int n2 = ((int)l & 3) << 3;
        zzg.zzn(object, l2, (by & 0xFF) << n2 | n & ~(255 << n2));
    }

    static boolean zza() {
        return zzi;
    }

    static boolean zzb() {
        return zzh;
    }

    static <T> T zzc(Class<T> object) {
        try {
            object = zzc.allocateInstance((Class<?>)object);
        }
        catch (InstantiationException instantiationException) {
            throw new IllegalStateException(instantiationException);
        }
        return (T)object;
    }

    static int zzd(Object object, long l) {
        return zzg.zzm(object, l);
    }

    static void zze(Object object, long l, int n) {
        zzg.zzn(object, l, n);
    }

    static long zzf(Object object, long l) {
        return zzg.zzo(object, l);
    }

    static void zzg(Object object, long l, long l2) {
        zzg.zzp(object, l, l2);
    }

    static boolean zzh(Object object, long l) {
        return zzg.zzb(object, l);
    }

    static void zzi(Object object, long l, boolean bl) {
        zzg.zzc(object, l, bl);
    }

    static float zzj(Object object, long l) {
        return zzg.zzd(object, l);
    }

    static void zzk(Object object, long l, float f) {
        zzg.zze(object, l, f);
    }

    static double zzl(Object object, long l) {
        return zzg.zzf(object, l);
    }

    static void zzm(Object object, long l, double d) {
        zzg.zzg(object, l, d);
    }

    static Object zzn(Object object, long l) {
        return zzg.zzq(object, l);
    }

    static void zzo(Object object, long l, Object object2) {
        zzg.zzr(object, l, object2);
    }

    static void zzp(byte[] byArray, long l, byte by) {
        zzg.zza((Object)byArray, zza + l, by);
    }

    static void zzq(long l, byte[] byArray, long l2, long l3) {
        zzg.zzi(l, byArray, l2, l3);
    }

    static byte zzr(long l) {
        return zzg.zzh(l);
    }

    static long zzs(ByteBuffer byteBuffer) {
        return zzg.zzo((Object)byteBuffer, zzj);
    }

    static Unsafe zzt() {
        Object object;
        try {
            object = new zzgiu();
            object = (Unsafe)AccessController.doPrivileged(object);
        }
        catch (Throwable throwable) {
            object = null;
        }
        return object;
    }

    static boolean zzu(Class<?> clazz) {
        int n = zzgei.zza;
        try {
            Class<?> clazz2 = zzd;
            clazz2.getMethod("peekLong", clazz, Boolean.TYPE);
            clazz2.getMethod("pokeLong", clazz, Long.TYPE, Boolean.TYPE);
            clazz2.getMethod("pokeInt", clazz, Integer.TYPE, Boolean.TYPE);
            clazz2.getMethod("peekInt", clazz, Boolean.TYPE);
            clazz2.getMethod("pokeByte", clazz, Byte.TYPE);
            clazz2.getMethod("peekByte", clazz);
            clazz2.getMethod("pokeByteArray", clazz, byte[].class, Integer.TYPE, Integer.TYPE);
            clazz2.getMethod("peekByteArray", clazz, byte[].class, Integer.TYPE, Integer.TYPE);
            return true;
        }
        catch (Throwable throwable) {
            return false;
        }
    }

    static /* synthetic */ void zzv(Object object, long l, byte by) {
        zzgiy.zzG(object, l, by);
    }

    static /* synthetic */ void zzw(Object object, long l, byte by) {
        zzgiy.zzH(object, l, by);
    }

    static /* synthetic */ boolean zzx(Object object, long l) {
        if ((byte)(zzg.zzm(object, 0xFFFFFFFFFFFFFFFCL & l) >>> (int)(((l ^ 0xFFFFFFFFFFFFFFFFL) & 3L) << 3) & 0xFF) == 0) return false;
        return true;
    }

    static /* synthetic */ boolean zzy(Object object, long l) {
        if ((byte)(zzg.zzm(object, 0xFFFFFFFFFFFFFFFCL & l) >>> (int)((l & 3L) << 3) & 0xFF) == 0) return false;
        return true;
    }

    static /* synthetic */ void zzz(Object object, long l, boolean bl) {
        zzgiy.zzG(object, l, (byte)(bl ? 1 : 0));
    }
}
