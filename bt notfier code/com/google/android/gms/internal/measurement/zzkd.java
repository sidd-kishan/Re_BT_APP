/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.measurement.zzke
 *  com.google.android.gms.internal.measurement.zzkf
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzke;
import com.google.android.gms.internal.measurement.zzkf;
import sun.misc.Unsafe;

final class zzkd
extends zzke {
    zzkd(Unsafe unsafe) {
        super(unsafe);
    }

    public final void zza(Object object, long l, byte by) {
        if (zzkf.zzb) {
            zzkf.zzt((Object)object, (long)l, (byte)by);
            return;
        }
        zzkf.zzu((Object)object, (long)l, (byte)by);
    }

    public final boolean zzb(Object object, long l) {
        if (!zzkf.zzb) return zzkf.zzw((Object)object, (long)l);
        return zzkf.zzv((Object)object, (long)l);
    }

    public final void zzc(Object object, long l, boolean bl) {
        if (zzkf.zzb) {
            zzkf.zzx((Object)object, (long)l, (boolean)bl);
            return;
        }
        zzkf.zzy((Object)object, (long)l, (boolean)bl);
    }

    public final float zzd(Object object, long l) {
        return Float.intBitsToFloat(this.zzk(object, l));
    }

    public final void zze(Object object, long l, float f) {
        this.zzl(object, l, Float.floatToIntBits(f));
    }

    public final double zzf(Object object, long l) {
        return Double.longBitsToDouble(this.zzm(object, l));
    }

    public final void zzg(Object object, long l, double d) {
        this.zzn(object, l, Double.doubleToLongBits(d));
    }
}
