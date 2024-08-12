/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.measurement.zzge
 *  com.google.android.gms.internal.measurement.zzgi
 *  com.google.android.gms.internal.measurement.zzgk
 *  com.google.android.gms.internal.measurement.zzgp
 *  com.google.android.gms.internal.measurement.zzgq
 *  com.google.android.gms.internal.measurement.zzhz
 *  com.google.android.gms.internal.measurement.zzjt
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzge;
import com.google.android.gms.internal.measurement.zzgi;
import com.google.android.gms.internal.measurement.zzgk;
import com.google.android.gms.internal.measurement.zzgp;
import com.google.android.gms.internal.measurement.zzgq;
import com.google.android.gms.internal.measurement.zzhz;
import com.google.android.gms.internal.measurement.zzjt;
import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Comparator;
import java.util.Locale;

public abstract class zzgr
implements Iterable<Byte>,
Serializable {
    public static final zzgr zzb = new zzgp(zzhz.zzc);
    private static final Comparator<zzgr> zzc;
    private static final zzgq zzd;
    private int zza = 0;

    static {
        int n = zzge.zza;
        zzd = new zzgq(null);
        zzc = new zzgk();
    }

    zzgr() {
    }

    public static zzgr zzj(byte[] byArray, int n, int n2) {
        zzgr.zzn(n, n + n2, byArray.length);
        byte[] byArray2 = new byte[n2];
        System.arraycopy(byArray, n, byArray2, 0, n2);
        return new zzgp(byArray2);
    }

    public static zzgr zzk(String string) {
        return new zzgp(string.getBytes(zzhz.zza));
    }

    static int zzn(int n, int n2, int n3) {
        int n4 = n2 - n;
        if ((n | n2 | n4 | n3 - n2) >= 0) return n4;
        if (n < 0) {
            StringBuilder stringBuilder = new StringBuilder(32);
            stringBuilder.append("Beginning index: ");
            stringBuilder.append(n);
            stringBuilder.append(" < 0");
            throw new IndexOutOfBoundsException(stringBuilder.toString());
        }
        if (n2 < n) {
            StringBuilder stringBuilder = new StringBuilder(66);
            stringBuilder.append("Beginning index larger than ending index: ");
            stringBuilder.append(n);
            stringBuilder.append(", ");
            stringBuilder.append(n2);
            throw new IndexOutOfBoundsException(stringBuilder.toString());
        }
        StringBuilder stringBuilder = new StringBuilder(37);
        stringBuilder.append("End index: ");
        stringBuilder.append(n2);
        stringBuilder.append(" >= ");
        stringBuilder.append(n3);
        throw new IndexOutOfBoundsException(stringBuilder.toString());
    }

    public abstract boolean equals(Object var1);

    public final int hashCode() {
        int n;
        int n2 = n = this.zza;
        if (n != 0) return n2;
        n2 = this.zzc();
        n2 = n = this.zzi(n2, 0, n2);
        if (n == 0) {
            n2 = 1;
        }
        this.zza = n2;
        return n2;
    }

    public final String toString() {
        Locale locale = Locale.ROOT;
        String string = Integer.toHexString(System.identityHashCode(this));
        int n = this.zzc();
        String string2 = this.zzc() <= 50 ? zzjt.zza((zzgr)this) : String.valueOf(zzjt.zza((zzgr)this.zze(0, 47))).concat("...");
        return String.format(locale, "<ByteString@%s size=%d contents=\"%s\">", string, n, string2);
    }

    public abstract byte zza(int var1);

    abstract byte zzb(int var1);

    public abstract int zzc();

    public abstract zzgr zze(int var1, int var2);

    abstract void zzf(zzgi var1) throws IOException;

    protected abstract String zzg(Charset var1);

    public abstract boolean zzh();

    protected abstract int zzi(int var1, int var2, int var3);

    public final String zzl(Charset object) {
        object = this.zzc() == 0 ? "" : this.zzg((Charset)object);
        return object;
    }

    protected final int zzm() {
        return this.zza;
    }
}
