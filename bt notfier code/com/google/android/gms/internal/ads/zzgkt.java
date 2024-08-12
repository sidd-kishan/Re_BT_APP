/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzxo
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzxo;
import java.nio.ByteBuffer;

public final class zzgkt {
    public static final zzgkt zzj = new zzgkt(1.0, 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, 0.0);
    public static final zzgkt zzk = new zzgkt(0.0, 1.0, -1.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0);
    public static final zzgkt zzl = new zzgkt(-1.0, 0.0, 0.0, -1.0, 0.0, 0.0, 1.0, 0.0, 0.0);
    public static final zzgkt zzm = new zzgkt(0.0, -1.0, 1.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0);
    public final double zza;
    public final double zzb;
    public final double zzc;
    public final double zzd;
    public final double zze;
    public final double zzf;
    public final double zzg;
    public final double zzh;
    public final double zzi;

    public zzgkt(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9) {
        this.zza = d5;
        this.zzb = d6;
        this.zzc = d7;
        this.zzd = d;
        this.zze = d2;
        this.zzf = d3;
        this.zzg = d4;
        this.zzh = d8;
        this.zzi = d9;
    }

    public static zzgkt zza(ByteBuffer byteBuffer) {
        double d = zzxo.zze((ByteBuffer)byteBuffer);
        double d2 = zzxo.zze((ByteBuffer)byteBuffer);
        double d3 = zzxo.zzf((ByteBuffer)byteBuffer);
        double d4 = zzxo.zze((ByteBuffer)byteBuffer);
        double d5 = zzxo.zze((ByteBuffer)byteBuffer);
        double d6 = zzxo.zzf((ByteBuffer)byteBuffer);
        double d7 = zzxo.zze((ByteBuffer)byteBuffer);
        double d8 = zzxo.zze((ByteBuffer)byteBuffer);
        return new zzgkt(d, d2, d4, d5, d3, d6, zzxo.zzf((ByteBuffer)byteBuffer), d7, d8);
    }

    public final boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) return false;
        if (this.getClass() != object.getClass()) {
            return false;
        }
        object = (zzgkt)object;
        if (Double.compare(((zzgkt)object).zzd, this.zzd) != 0) {
            return false;
        }
        if (Double.compare(((zzgkt)object).zze, this.zze) != 0) {
            return false;
        }
        if (Double.compare(((zzgkt)object).zzf, this.zzf) != 0) {
            return false;
        }
        if (Double.compare(((zzgkt)object).zzg, this.zzg) != 0) {
            return false;
        }
        if (Double.compare(((zzgkt)object).zzh, this.zzh) != 0) {
            return false;
        }
        if (Double.compare(((zzgkt)object).zzi, this.zzi) != 0) {
            return false;
        }
        if (Double.compare(((zzgkt)object).zza, this.zza) != 0) {
            return false;
        }
        if (Double.compare(((zzgkt)object).zzb, this.zzb) != 0) {
            return false;
        }
        if (Double.compare(((zzgkt)object).zzc, this.zzc) == 0) return true;
        return false;
    }

    public final int hashCode() {
        long l = Double.doubleToLongBits(this.zza);
        long l2 = Double.doubleToLongBits(this.zzb);
        long l3 = Double.doubleToLongBits(this.zzc);
        long l4 = Double.doubleToLongBits(this.zzd);
        long l5 = Double.doubleToLongBits(this.zze);
        long l6 = Double.doubleToLongBits(this.zzf);
        long l7 = Double.doubleToLongBits(this.zzg);
        long l8 = Double.doubleToLongBits(this.zzh);
        long l9 = Double.doubleToLongBits(this.zzi);
        return ((((((((int)(l ^ l >>> 32) * 31 + (int)(l2 ^ l2 >>> 32)) * 31 + (int)(l3 >>> 32 ^ l3)) * 31 + (int)(l4 >>> 32 ^ l4)) * 31 + (int)(l5 >>> 32 ^ l5)) * 31 + (int)(l6 >>> 32 ^ l6)) * 31 + (int)(l7 >>> 32 ^ l7)) * 31 + (int)(l8 ^ l8 >>> 32)) * 31 + (int)(l9 >>> 32 ^ l9);
    }

    public final String toString() {
        if (this.equals(zzj)) {
            return "Rotate 0\u00b0";
        }
        if (this.equals(zzk)) {
            return "Rotate 90\u00b0";
        }
        if (this.equals(zzl)) {
            return "Rotate 180\u00b0";
        }
        if (this.equals(zzm)) {
            return "Rotate 270\u00b0";
        }
        double d = this.zza;
        double d2 = this.zzb;
        double d3 = this.zzc;
        double d4 = this.zzd;
        double d5 = this.zze;
        double d6 = this.zzf;
        double d7 = this.zzg;
        double d8 = this.zzh;
        double d9 = this.zzi;
        StringBuilder stringBuilder = new StringBuilder(260);
        stringBuilder.append("Matrix{u=");
        stringBuilder.append(d);
        stringBuilder.append(", v=");
        stringBuilder.append(d2);
        stringBuilder.append(", w=");
        stringBuilder.append(d3);
        stringBuilder.append(", a=");
        stringBuilder.append(d4);
        stringBuilder.append(", b=");
        stringBuilder.append(d5);
        stringBuilder.append(", c=");
        stringBuilder.append(d6);
        stringBuilder.append(", d=");
        stringBuilder.append(d7);
        stringBuilder.append(", tx=");
        stringBuilder.append(d8);
        stringBuilder.append(", ty=");
        stringBuilder.append(d9);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
