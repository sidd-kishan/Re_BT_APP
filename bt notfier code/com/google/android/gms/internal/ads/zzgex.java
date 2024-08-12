/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzgei
 *  com.google.android.gms.internal.ads.zzgem
 *  com.google.android.gms.internal.ads.zzgen
 *  com.google.android.gms.internal.ads.zzgeo
 *  com.google.android.gms.internal.ads.zzger
 *  com.google.android.gms.internal.ads.zzget
 *  com.google.android.gms.internal.ads.zzgev
 *  com.google.android.gms.internal.ads.zzgew
 *  com.google.android.gms.internal.ads.zzgfc
 *  com.google.android.gms.internal.ads.zzggk
 *  com.google.android.gms.internal.ads.zzghy
 *  com.google.android.gms.internal.ads.zzgim
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgei;
import com.google.android.gms.internal.ads.zzgem;
import com.google.android.gms.internal.ads.zzgen;
import com.google.android.gms.internal.ads.zzgeo;
import com.google.android.gms.internal.ads.zzger;
import com.google.android.gms.internal.ads.zzget;
import com.google.android.gms.internal.ads.zzgev;
import com.google.android.gms.internal.ads.zzgew;
import com.google.android.gms.internal.ads.zzgfc;
import com.google.android.gms.internal.ads.zzggk;
import com.google.android.gms.internal.ads.zzghy;
import com.google.android.gms.internal.ads.zzgim;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;

public abstract class zzgex
implements Iterable<Byte>,
Serializable {
    public static final zzgex zzb = new zzget(zzggk.zzc);
    private static final Comparator<zzgex> zzc;
    private static final zzgew zzd;
    private int zza = 0;

    static {
        int n = zzgei.zza;
        zzd = new zzgew(null);
        zzc = new zzgeo();
    }

    zzgex() {
    }

    public static zzgev zzB() {
        return new zzgev(128);
    }

    static void zzD(int n, int n2) {
        if ((n2 - (n + 1) | n) >= 0) return;
        if (n < 0) {
            StringBuilder stringBuilder = new StringBuilder(22);
            stringBuilder.append("Index < 0: ");
            stringBuilder.append(n);
            throw new ArrayIndexOutOfBoundsException(stringBuilder.toString());
        }
        StringBuilder stringBuilder = new StringBuilder(40);
        stringBuilder.append("Index > length: ");
        stringBuilder.append(n);
        stringBuilder.append(", ");
        stringBuilder.append(n2);
        throw new ArrayIndexOutOfBoundsException(stringBuilder.toString());
    }

    static int zzE(int n, int n2, int n3) {
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

    private static zzgex zzd(Iterator<zzgex> object, int n) {
        if (n <= 0) {
            throw new IllegalArgumentException(String.format("length (%s) must be >= 1", n));
        }
        if (n == 1) {
            object = object.next();
        } else {
            int n2 = n >>> 1;
            zzgex zzgex2 = zzgex.zzd((Iterator<zzgex>)object, n2);
            object = zzgex.zzd((Iterator<zzgex>)object, n - n2);
            if (Integer.MAX_VALUE - zzgex2.zzc() < ((zzgex)object).zzc()) {
                n = zzgex2.zzc();
                n2 = ((zzgex)object).zzc();
                object = new StringBuilder(53);
                ((StringBuilder)object).append("ByteString would be too long: ");
                ((StringBuilder)object).append(n);
                ((StringBuilder)object).append("+");
                ((StringBuilder)object).append(n2);
                throw new IllegalArgumentException(((StringBuilder)object).toString());
            }
            object = zzghy.zzF((zzgex)zzgex2, (zzgex)object);
        }
        return object;
    }

    public static zzgex zzs(byte[] byArray, int n, int n2) {
        zzgex.zzE(n, n + n2, byArray.length);
        byte[] byArray2 = new byte[n2];
        System.arraycopy(byArray, n, byArray2, 0, n2);
        return new zzget(byArray2);
    }

    public static zzgex zzt(byte[] byArray) {
        return zzgex.zzs(byArray, 0, byArray.length);
    }

    static zzgex zzu(byte[] byArray) {
        return new zzget(byArray);
    }

    public static zzgex zzv(String string) {
        return new zzget(string.getBytes(zzggk.zza));
    }

    public static zzgex zzw(InputStream inputStream) throws IOException {
        ArrayList<zzgex> arrayList = new ArrayList<zzgex>();
        int n = 256;
        while (true) {
            int n2;
            int n3;
            Object object = new byte[n];
            for (n2 = 0; n2 < n && (n3 = inputStream.read((byte[])object, n2, n - n2)) != -1; n2 += n3) {
            }
            object = n2 == 0 ? null : (Object)zzgex.zzs(object, 0, n2);
            if (object == null) {
                return zzgex.zzx(arrayList);
            }
            arrayList.add((zzgex)object);
            n = Math.min(n + n, 8192);
        }
    }

    public static zzgex zzx(Iterable<zzgex> iterable) {
        int n;
        if (!(iterable instanceof Collection)) {
            Iterator<zzgex> iterator = iterable.iterator();
            int n2 = 0;
            while (true) {
                n = n2++;
                if (iterator.hasNext()) {
                    iterator.next();
                    continue;
                }
                break;
            }
        } else {
            n = iterable.size();
        }
        if (n != 0) return zzgex.zzd(iterable.iterator(), n);
        return zzb;
    }

    public abstract boolean equals(Object var1);

    public final int hashCode() {
        int n;
        int n2 = n = this.zza;
        if (n != 0) return n2;
        n2 = this.zzc();
        n2 = n = this.zzo(n2, 0, n2);
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
        String string2 = this.zzc() <= 50 ? zzgim.zza((zzgex)this) : zzgim.zza((zzgex)this.zzi(0, 47)).concat("...");
        return String.format(locale, "<ByteString@%s size=%d contents=\"%s\">", string, n, string2);
    }

    public final String zzA(Charset object) {
        object = this.zzc() == 0 ? "" : this.zzl((Charset)object);
        return object;
    }

    protected final int zzC() {
        return this.zza;
    }

    public abstract byte zza(int var1);

    abstract byte zzb(int var1);

    public abstract int zzc();

    protected abstract void zze(byte[] var1, int var2, int var3, int var4);

    protected abstract int zzf();

    protected abstract boolean zzg();

    public abstract zzgex zzi(int var1, int var2);

    public abstract ByteBuffer zzj();

    abstract void zzk(zzgem var1) throws IOException;

    protected abstract String zzl(Charset var1);

    public abstract boolean zzm();

    protected abstract int zzn(int var1, int var2, int var3);

    protected abstract int zzo(int var1, int var2, int var3);

    public abstract zzgfc zzp();

    public zzger zzq() {
        return new zzgen(this);
    }

    public final boolean zzr() {
        if (this.zzc() != 0) return false;
        return true;
    }

    @Deprecated
    public final void zzy(byte[] byArray, int n, int n2, int n3) {
        zzgex.zzE(0, n3, this.zzc());
        zzgex.zzE(n2, n2 + n3, byArray.length);
        if (n3 <= 0) return;
        this.zze(byArray, 0, n2, n3);
    }

    public final byte[] zzz() {
        int n = this.zzc();
        if (n == 0) {
            return zzggk.zzc;
        }
        byte[] byArray = new byte[n];
        this.zze(byArray, 0, 0, n);
        return byArray;
    }
}
