/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.measurement.zzge
 *  com.google.android.gms.internal.measurement.zzkb
 *  com.google.android.gms.internal.measurement.zzkc
 *  com.google.android.gms.internal.measurement.zzkd
 *  com.google.android.gms.internal.measurement.zzke
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzge;
import com.google.android.gms.internal.measurement.zzkb;
import com.google.android.gms.internal.measurement.zzkc;
import com.google.android.gms.internal.measurement.zzkd;
import com.google.android.gms.internal.measurement.zzke;
import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

final class zzkf {
    static final long zza;
    static final boolean zzb;
    private static final Unsafe zzc;
    private static final Class<?> zzd;
    private static final boolean zze;
    private static final boolean zzf;
    private static final zzke zzg;
    private static final boolean zzh;
    private static final boolean zzi;

    static {
        boolean bl;
        Object object;
        Object object2;
        boolean bl2;
        block13: {
            block12: {
                block11: {
                    zzc = zzkf.zzq();
                    zzd = zzge.zza();
                    zze = zzkf.zzr(Long.TYPE);
                    zzf = bl2 = zzkf.zzr(Integer.TYPE);
                    object2 = zzc;
                    object = null;
                    if (object2 != null) {
                        if (zze) {
                            object = new zzkd((Unsafe)object2);
                        } else if (bl2) {
                            object = new zzkc((Unsafe)object2);
                        }
                    }
                    zzg = object;
                    bl = true;
                    if (object != null && (object = ((zzke)object).zza) != null) {
                        try {
                            object = object.getClass();
                            ((Class)object).getMethod("objectFieldOffset", Field.class);
                            ((Class)object).getMethod("getLong", Object.class, Long.TYPE);
                            object = zzkf.zzB();
                            if (object == null) break block11;
                            bl2 = true;
                            break block12;
                        }
                        catch (Throwable throwable) {
                            zzkf.zzs(throwable);
                        }
                    }
                }
                bl2 = false;
            }
            zzh = bl2;
            object = zzg;
            if (object != null && (object = ((zzke)object).zza) != null) {
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
                    zzkf.zzs(throwable);
                }
            }
            bl2 = false;
        }
        zzi = bl2;
        zza = zzkf.zzz(byte[].class);
        zzkf.zzz(boolean[].class);
        zzkf.zzA(boolean[].class);
        zzkf.zzz(int[].class);
        zzkf.zzA(int[].class);
        zzkf.zzz(long[].class);
        zzkf.zzA(long[].class);
        zzkf.zzz(float[].class);
        zzkf.zzA(float[].class);
        zzkf.zzz(double[].class);
        zzkf.zzA(double[].class);
        zzkf.zzz(Object[].class);
        zzkf.zzA(Object[].class);
        object2 = zzkf.zzB();
        if (object2 != null && (object = zzg) != null) {
            object.zzh((Field)object2);
        }
        bl2 = ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN ? bl : false;
        zzb = bl2;
    }

    private zzkf() {
    }

    private static int zzA(Class<?> clazz) {
        if (!zzi) return -1;
        return zzg.zzj(clazz);
    }

    private static Field zzB() {
        Field field;
        int n = zzge.zza;
        Field field2 = field = zzkf.zzC(Buffer.class, "effectiveDirectAddress");
        if (field != null) return field2;
        field2 = zzkf.zzC(Buffer.class, "address");
        if (field2 != null && field2.getType() == Long.TYPE) {
            return field2;
        }
        field2 = null;
        return field2;
    }

    private static Field zzC(Class<?> annotatedElement, String string) {
        try {
            annotatedElement = annotatedElement.getDeclaredField(string);
        }
        catch (Throwable throwable) {
            annotatedElement = null;
        }
        return annotatedElement;
    }

    private static void zzD(Object object, long l, byte by) {
        long l2 = 0xFFFFFFFFFFFFFFFCL & l;
        int n = zzg.zzk(object, l2);
        int n2 = (~((int)l) & 3) << 3;
        zzg.zzl(object, l2, (by & 0xFF) << n2 | n & ~(255 << n2));
    }

    private static void zzE(Object object, long l, byte by) {
        long l2 = 0xFFFFFFFFFFFFFFFCL & l;
        int n = zzg.zzk(object, l2);
        int n2 = ((int)l & 3) << 3;
        zzg.zzl(object, l2, (by & 0xFF) << n2 | n & ~(255 << n2));
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
        return zzg.zzk(object, l);
    }

    static void zze(Object object, long l, int n) {
        zzg.zzl(object, l, n);
    }

    static long zzf(Object object, long l) {
        return zzg.zzm(object, l);
    }

    static void zzg(Object object, long l, long l2) {
        zzg.zzn(object, l, l2);
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
        return zzg.zzo(object, l);
    }

    static void zzo(Object object, long l, Object object2) {
        zzg.zzp(object, l, object2);
    }

    static void zzp(byte[] byArray, long l, byte by) {
        zzg.zza((Object)byArray, zza + l, by);
    }

    static Unsafe zzq() {
        Object object;
        try {
            object = new zzkb();
            object = (Unsafe)AccessController.doPrivileged(object);
        }
        catch (Throwable throwable) {
            object = null;
        }
        return object;
    }

    static boolean zzr(Class<?> clazz) {
        int n = zzge.zza;
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

    static /* synthetic */ void zzs(Throwable object) {
        Logger logger = Logger.getLogger(zzkf.class.getName());
        Level level = Level.WARNING;
        object = String.valueOf(object);
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(object).length() + 71);
        stringBuilder.append("platform method missing - proto runtime falling back to safer methods: ");
        stringBuilder.append((String)object);
        logger.logp(level, "com.google.protobuf.UnsafeUtil", "logMissingMethod", stringBuilder.toString());
    }

    static /* synthetic */ void zzt(Object object, long l, byte by) {
        zzkf.zzD(object, l, by);
    }

    static /* synthetic */ void zzu(Object object, long l, byte by) {
        zzkf.zzE(object, l, by);
    }

    static /* synthetic */ boolean zzv(Object object, long l) {
        if ((byte)(zzg.zzk(object, 0xFFFFFFFFFFFFFFFCL & l) >>> (int)(((l ^ 0xFFFFFFFFFFFFFFFFL) & 3L) << 3) & 0xFF) == 0) return false;
        return true;
    }

    static /* synthetic */ boolean zzw(Object object, long l) {
        if ((byte)(zzg.zzk(object, 0xFFFFFFFFFFFFFFFCL & l) >>> (int)((l & 3L) << 3) & 0xFF) == 0) return false;
        return true;
    }

    static /* synthetic */ void zzx(Object object, long l, boolean bl) {
        zzkf.zzD(object, l, (byte)(bl ? 1 : 0));
    }

    static /* synthetic */ void zzy(Object object, long l, boolean bl) {
        zzkf.zzE(object, l, (byte)(bl ? 1 : 0));
    }

    private static int zzz(Class<?> clazz) {
        if (!zzi) return -1;
        return zzg.zzi(clazz);
    }
}
