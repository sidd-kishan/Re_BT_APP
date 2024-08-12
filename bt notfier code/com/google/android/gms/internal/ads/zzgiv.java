/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzgix
 *  com.google.android.gms.internal.ads.zzgiy
 *  libcore.io.Memory
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgix;
import com.google.android.gms.internal.ads.zzgiy;
import libcore.io.Memory;
import sun.misc.Unsafe;

final class zzgiv
extends zzgix {
    zzgiv(Unsafe unsafe) {
        super(unsafe);
    }

    public final void zza(Object object, long l, byte by) {
        if (zzgiy.zzb) {
            zzgiy.zzv((Object)object, (long)l, (byte)by);
            return;
        }
        zzgiy.zzw((Object)object, (long)l, (byte)by);
    }

    public final boolean zzb(Object object, long l) {
        if (!zzgiy.zzb) return zzgiy.zzy((Object)object, (long)l);
        return zzgiy.zzx((Object)object, (long)l);
    }

    public final void zzc(Object object, long l, boolean bl) {
        if (zzgiy.zzb) {
            zzgiy.zzz((Object)object, (long)l, (boolean)bl);
            return;
        }
        zzgiy.zzA((Object)object, (long)l, (boolean)bl);
    }

    public final float zzd(Object object, long l) {
        return Float.intBitsToFloat(this.zzm(object, l));
    }

    public final void zze(Object object, long l, float f) {
        this.zzn(object, l, Float.floatToIntBits(f));
    }

    public final double zzf(Object object, long l) {
        return Double.longBitsToDouble(this.zzo(object, l));
    }

    public final void zzg(Object object, long l, double d) {
        this.zzp(object, l, Double.doubleToLongBits(d));
    }

    public final byte zzh(long l) {
        return Memory.peekByte((int)((int)l));
    }

    public final void zzi(long l, byte[] byArray, long l2, long l3) {
        Memory.peekByteArray((int)((int)l), (byte[])byArray, (int)((int)l2), (int)((int)l3));
    }
}
