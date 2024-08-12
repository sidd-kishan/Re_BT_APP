/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzgkk
 *  com.google.android.gms.internal.ads.zzgkm
 *  com.google.android.gms.internal.ads.zzgkr
 *  com.google.android.gms.internal.ads.zzgks
 *  com.google.android.gms.internal.ads.zzxm
 *  com.google.android.gms.internal.ads.zzxp
 *  com.google.android.gms.internal.ads.zzxq
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgkk;
import com.google.android.gms.internal.ads.zzgkm;
import com.google.android.gms.internal.ads.zzgkr;
import com.google.android.gms.internal.ads.zzgks;
import com.google.android.gms.internal.ads.zzxm;
import com.google.android.gms.internal.ads.zzxp;
import com.google.android.gms.internal.ads.zzxq;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class zzgkl
implements Iterator<zzxp>,
Closeable,
zzxq {
    private static final zzxp zza = new zzgkk("eof ");
    private static final zzgks zzb = zzgks.zzb(zzgkl.class);
    protected zzxm zzc;
    protected zzgkm zzd;
    zzxp zze = null;
    long zzf = 0L;
    long zzg = 0L;
    private final List<zzxp> zzh = new ArrayList<zzxp>();

    @Override
    public void close() throws IOException {
    }

    @Override
    public final boolean hasNext() {
        zzxp zzxp2 = this.zze;
        if (zzxp2 == zza) {
            return false;
        }
        if (zzxp2 != null) {
            return true;
        }
        try {
            this.zze = this.zzf();
            return true;
        }
        catch (NoSuchElementException noSuchElementException) {
            this.zze = zza;
            return false;
        }
    }

    @Override
    public final void remove() {
        throw new UnsupportedOperationException();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.getClass().getSimpleName());
        stringBuilder.append("[");
        int n = 0;
        while (true) {
            if (n >= this.zzh.size()) {
                stringBuilder.append("]");
                return stringBuilder.toString();
            }
            if (n > 0) {
                stringBuilder.append(";");
            }
            stringBuilder.append(this.zzh.get(n).toString());
            ++n;
        }
    }

    public final List<zzxp> zzd() {
        if (this.zzd == null) return this.zzh;
        if (this.zze == zza) return this.zzh;
        return new zzgkr(this.zzh, (Iterator)this);
    }

    public final void zze(zzgkm zzgkm2, long l, zzxm zzxm2) throws IOException {
        this.zzd = zzgkm2;
        this.zzf = zzgkm2.zzc();
        zzgkm2.zzd(zzgkm2.zzc() + l);
        this.zzg = zzgkm2.zzc();
        this.zzc = zzxm2;
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public final zzxp zzf() {
        zzxp zzxp2 = this.zze;
        if (zzxp2 != null && zzxp2 != zza) {
            this.zze = null;
            return zzxp2;
        }
        zzxp2 = this.zzd;
        if (zzxp2 != null && this.zzf < this.zzg) {
            try {
                synchronized (zzxp2) {
                }
            }
            catch (IOException iOException) {
                throw new NoSuchElementException();
            }
            catch (EOFException eOFException) {
                throw new NoSuchElementException();
            }
            {
                this.zzd.zzd(this.zzf);
                zzxp zzxp3 = this.zzc.zzb(this.zzd, (zzxq)this);
                this.zzf = this.zzd.zzc();
                return zzxp3;
            }
        }
        this.zze = zza;
        throw new NoSuchElementException();
    }
}
