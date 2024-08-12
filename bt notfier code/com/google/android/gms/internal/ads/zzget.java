/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzgem
 *  com.google.android.gms.internal.ads.zzgeq
 *  com.google.android.gms.internal.ads.zzges
 *  com.google.android.gms.internal.ads.zzgex
 *  com.google.android.gms.internal.ads.zzgfc
 *  com.google.android.gms.internal.ads.zzgfe
 *  com.google.android.gms.internal.ads.zzggk
 *  com.google.android.gms.internal.ads.zzgjd
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgem;
import com.google.android.gms.internal.ads.zzgeq;
import com.google.android.gms.internal.ads.zzges;
import com.google.android.gms.internal.ads.zzgex;
import com.google.android.gms.internal.ads.zzgfc;
import com.google.android.gms.internal.ads.zzgfe;
import com.google.android.gms.internal.ads.zzggk;
import com.google.android.gms.internal.ads.zzgjd;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

class zzget
extends zzges {
    protected final byte[] zza;

    zzget(byte[] byArray) {
        if (byArray == null) throw null;
        this.zza = byArray;
    }

    public final boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof zzgex)) {
            return false;
        }
        if (this.zzc() != ((zzgex)object).zzc()) {
            return false;
        }
        if (this.zzc() == 0) {
            return true;
        }
        if (!(object instanceof zzget)) return object.equals((Object)this);
        object = (zzget)((Object)object);
        int n = this.zzC();
        int n2 = object.zzC();
        if (n == 0) return this.zzh((zzgex)object, 0, this.zzc());
        if (n2 == 0) return this.zzh((zzgex)object, 0, this.zzc());
        if (n == n2) return this.zzh((zzgex)object, 0, this.zzc());
        return false;
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

    protected void zze(byte[] byArray, int n, int n2, int n3) {
        System.arraycopy(this.zza, n, byArray, n2, n3);
    }

    final boolean zzh(zzgex object, int n, int n2) {
        if (n2 > object.zzc()) {
            n = this.zzc();
            object = new StringBuilder(40);
            ((StringBuilder)object).append("Length too large: ");
            ((StringBuilder)object).append(n2);
            ((StringBuilder)object).append(n);
            object = new IllegalArgumentException(((StringBuilder)object).toString());
            throw object;
        }
        int n3 = n + n2;
        if (n3 > object.zzc()) {
            n3 = object.zzc();
            object = new StringBuilder(59);
            ((StringBuilder)object).append("Ran off end of other: ");
            ((StringBuilder)object).append(n);
            ((StringBuilder)object).append(", ");
            ((StringBuilder)object).append(n2);
            ((StringBuilder)object).append(", ");
            ((StringBuilder)object).append(n3);
            throw new IllegalArgumentException(((StringBuilder)object).toString());
        }
        if (!(object instanceof zzget)) return object.zzi(n, n3).equals((Object)this.zzi(0, n2));
        zzget zzget2 = (zzget)((Object)object);
        byte[] byArray = this.zza;
        object = zzget2.zza;
        int n4 = this.zzd();
        n3 = this.zzd();
        int n5 = zzget2.zzd() + n;
        n = n3;
        n3 = n5;
        while (n < n4 + n2) {
            if (byArray[n] != object[n3]) {
                return false;
            }
            ++n;
            ++n3;
        }
        return true;
    }

    public final zzgex zzi(int n, int n2) {
        if ((n2 = zzget.zzE((int)n, (int)n2, (int)this.zzc())) != 0) return new zzgeq(this.zza, this.zzd() + n, n2);
        return zzgex.zzb;
    }

    public final ByteBuffer zzj() {
        return ByteBuffer.wrap(this.zza, this.zzd(), this.zzc()).asReadOnlyBuffer();
    }

    final void zzk(zzgem zzgem2) throws IOException {
        byte[] byArray = this.zza;
        int n = this.zzd();
        int n2 = this.zzc();
        ((zzgfe)zzgem2).zzp(byArray, n, n2);
    }

    protected final String zzl(Charset charset) {
        return new String(this.zza, this.zzd(), this.zzc(), charset);
    }

    public final boolean zzm() {
        int n = this.zzd();
        return zzgjd.zzb((byte[])this.zza, (int)n, (int)(this.zzc() + n));
    }

    protected final int zzn(int n, int n2, int n3) {
        n2 = this.zzd() + n2;
        return zzgjd.zzc((int)n, (byte[])this.zza, (int)n2, (int)(n3 + n2));
    }

    protected final int zzo(int n, int n2, int n3) {
        return zzggk.zzh((int)n, (byte[])this.zza, (int)(this.zzd() + n2), (int)n3);
    }

    public final zzgfc zzp() {
        return zzgfc.zzF((byte[])this.zza, (int)this.zzd(), (int)this.zzc(), (boolean)true);
    }
}
