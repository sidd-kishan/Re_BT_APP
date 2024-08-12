/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.internal.ads;

public final class zzou {
    public static final zzou zza = new zzou(0L, 0L);
    public final long zzb;
    public final long zzc;

    public zzou(long l, long l2) {
        this.zzb = l;
        this.zzc = l2;
    }

    public final boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) return false;
        if (this.getClass() != object.getClass()) {
            return false;
        }
        object = (zzou)object;
        if (this.zzb != ((zzou)object).zzb) return false;
        if (this.zzc != ((zzou)object).zzc) return false;
        return true;
    }

    public final int hashCode() {
        return (int)this.zzb * 31 + (int)this.zzc;
    }

    public final String toString() {
        long l = this.zzb;
        long l2 = this.zzc;
        StringBuilder stringBuilder = new StringBuilder(60);
        stringBuilder.append("[timeUs=");
        stringBuilder.append(l);
        stringBuilder.append(", position=");
        stringBuilder.append(l2);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
