/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.internal.ads;

import java.lang.reflect.Field;
import sun.misc.Unsafe;

abstract class zzgix {
    final Unsafe zza;

    zzgix(Unsafe unsafe) {
        this.zza = unsafe;
    }

    public abstract void zza(Object var1, long var2, byte var4);

    public abstract boolean zzb(Object var1, long var2);

    public abstract void zzc(Object var1, long var2, boolean var4);

    public abstract float zzd(Object var1, long var2);

    public abstract void zze(Object var1, long var2, float var4);

    public abstract double zzf(Object var1, long var2);

    public abstract void zzg(Object var1, long var2, double var4);

    public abstract byte zzh(long var1);

    public abstract void zzi(long var1, byte[] var3, long var4, long var6);

    public final long zzj(Field field) {
        return this.zza.objectFieldOffset(field);
    }

    public final int zzk(Class<?> clazz) {
        return this.zza.arrayBaseOffset(clazz);
    }

    public final int zzl(Class<?> clazz) {
        return this.zza.arrayIndexScale(clazz);
    }

    public final int zzm(Object object, long l) {
        return this.zza.getInt(object, l);
    }

    public final void zzn(Object object, long l, int n) {
        this.zza.putInt(object, l, n);
    }

    public final long zzo(Object object, long l) {
        return this.zza.getLong(object, l);
    }

    public final void zzp(Object object, long l, long l2) {
        this.zza.putLong(object, l, l2);
    }

    public final Object zzq(Object object, long l) {
        return this.zza.getObject(object, l);
    }

    public final void zzr(Object object, long l, Object object2) {
        this.zza.putObject(object, l, object2);
    }
}
