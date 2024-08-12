/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.measurement.zzgi
 *  com.google.android.gms.internal.measurement.zzgm
 *  com.google.android.gms.internal.measurement.zzgo
 *  com.google.android.gms.internal.measurement.zzgr
 *  com.google.android.gms.internal.measurement.zzgw
 *  com.google.android.gms.internal.measurement.zzhz
 *  com.google.android.gms.internal.measurement.zzkk
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzgi;
import com.google.android.gms.internal.measurement.zzgm;
import com.google.android.gms.internal.measurement.zzgo;
import com.google.android.gms.internal.measurement.zzgr;
import com.google.android.gms.internal.measurement.zzgw;
import com.google.android.gms.internal.measurement.zzhz;
import com.google.android.gms.internal.measurement.zzkk;
import java.io.IOException;
import java.nio.charset.Charset;

class zzgp
extends zzgo {
    protected final byte[] zza;

    zzgp(byte[] byArray) {
        if (byArray == null) throw null;
        this.zza = byArray;
    }

    public final boolean equals(Object object) {
        boolean bl;
        int n;
        boolean bl2 = true;
        if (object == this) {
            return true;
        }
        if (!(object instanceof zzgr)) {
            return false;
        }
        if (this.zzc() != ((zzgr)object).zzc()) {
            return false;
        }
        if (this.zzc() == 0) {
            return true;
        }
        if (!(object instanceof zzgp)) return object.equals((Object)this);
        object = (zzgp)((Object)object);
        int n2 = this.zzm();
        int n3 = object.zzm();
        if (n2 != 0 && n3 != 0) {
            if (n2 != n3) return false;
        }
        if ((n = this.zzc()) > object.zzc()) {
            n3 = this.zzc();
            object = new StringBuilder(40);
            ((StringBuilder)object).append("Length too large: ");
            ((StringBuilder)object).append(n);
            ((StringBuilder)object).append(n3);
            throw new IllegalArgumentException(((StringBuilder)object).toString());
        }
        if (n > object.zzc()) {
            n3 = object.zzc();
            object = new StringBuilder(59);
            ((StringBuilder)object).append("Ran off end of other: 0, ");
            ((StringBuilder)object).append(n);
            ((StringBuilder)object).append(", ");
            ((StringBuilder)object).append(n3);
            throw new IllegalArgumentException(((StringBuilder)object).toString());
        }
        if (!(object instanceof zzgp)) {
            bl = object.zze(0, n).equals((Object)this.zze(0, n));
        } else {
            byte[] byArray = this.zza;
            byte[] byArray2 = ((zzgp)((Object)object)).zza;
            ((zzgp)((Object)object)).zzd();
            n2 = 0;
            n3 = 0;
            while (true) {
                bl = bl2;
                if (n2 >= n) return bl;
                if (byArray[n2] != byArray2[n3]) {
                    bl = false;
                    break;
                }
                ++n2;
                ++n3;
            }
        }
        return bl;
    }

    public byte zza(int n) {
        return this.zza[n];
    }

    byte zzb(int n) {
        return this.zza[n];
    }

    public int zzc() {
        return this.zza.length;
    }

    protected int zzd() {
        return 0;
    }

    public final zzgr zze(int n, int n2) {
        n = zzgp.zzn((int)0, (int)n2, (int)this.zzc());
        if (n != 0) return new zzgm(this.zza, 0, n);
        return zzgr.zzb;
    }

    final void zzf(zzgi zzgi2) throws IOException {
        byte[] byArray = this.zza;
        int n = this.zzc();
        ((zzgw)zzgi2).zzp(byArray, 0, n);
    }

    protected final String zzg(Charset charset) {
        return new String(this.zza, 0, this.zzc(), charset);
    }

    public final boolean zzh() {
        return zzkk.zzb((byte[])this.zza, (int)0, (int)this.zzc());
    }

    protected final int zzi(int n, int n2, int n3) {
        return zzhz.zzh((int)n, (byte[])this.zza, (int)0, (int)n3);
    }
}
