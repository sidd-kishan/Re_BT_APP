/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzaeg
 *  com.google.android.gms.internal.ads.zzaf
 *  com.google.android.gms.internal.ads.zzaft
 *  com.google.android.gms.internal.ads.zzafv
 *  com.google.android.gms.internal.ads.zzafw
 *  com.google.android.gms.internal.ads.zzahv
 *  com.google.android.gms.internal.ads.zzahw
 *  com.google.android.gms.internal.ads.zzahx
 *  com.google.android.gms.internal.ads.zzakt
 *  com.google.android.gms.internal.ads.zzalp
 *  com.google.android.gms.internal.ads.zziu
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzaeg;
import com.google.android.gms.internal.ads.zzaf;
import com.google.android.gms.internal.ads.zzaft;
import com.google.android.gms.internal.ads.zzafv;
import com.google.android.gms.internal.ads.zzafw;
import com.google.android.gms.internal.ads.zzahv;
import com.google.android.gms.internal.ads.zzahw;
import com.google.android.gms.internal.ads.zzahx;
import com.google.android.gms.internal.ads.zzakt;
import com.google.android.gms.internal.ads.zzalp;
import com.google.android.gms.internal.ads.zziu;
import java.io.IOException;

public abstract class zzadv
implements zzahv,
zzahw {
    private final int zza;
    private final zzafw zzb;
    private zzahx zzc;
    private int zzd;
    private int zze;
    private zziu zzf;
    private zzafv[] zzg;
    private long zzh;
    private long zzi;
    private boolean zzj;
    private boolean zzk;

    public zzadv(int n) {
        this.zza = n;
        this.zzb = new zzafw();
        this.zzi = Long.MIN_VALUE;
    }

    public void zzE(int n, Object object) throws zzaeg {
    }

    public int zzG() throws zzaeg {
        return 0;
    }

    protected void zzL(zzafv[] zzafvArray, long l, long l2) throws zzaeg {
        throw null;
    }

    public void zzM(float f, float f2) throws zzaeg {
    }

    public final int zzac() {
        return this.zza;
    }

    public final zzahw zzad() {
        return this;
    }

    public final void zzae(int n) {
        this.zzd = n;
    }

    public final int zzaf() {
        return this.zze;
    }

    public final void zzag(zzahx zzahx2, zzafv[] zzafvArray, zziu zziu2, long l, boolean bl, boolean bl2, long l2, long l3) throws zzaeg {
        boolean bl3 = this.zze == 0;
        zzakt.zzd((boolean)bl3);
        this.zzc = zzahx2;
        this.zze = 1;
        this.zzq(bl, bl2);
        this.zzai(zzafvArray, zziu2, l2, l3);
        this.zzr(l, bl);
    }

    public final void zzah() throws zzaeg {
        int n = this.zze;
        boolean bl = true;
        if (n != 1) {
            bl = false;
        }
        zzakt.zzd((boolean)bl);
        this.zze = 2;
        this.zzs();
    }

    public final void zzai(zzafv[] zzafvArray, zziu zziu2, long l, long l2) throws zzaeg {
        zzakt.zzd((boolean)(this.zzj ^ true));
        this.zzf = zziu2;
        if (this.zzi == Long.MIN_VALUE) {
            this.zzi = l;
        }
        this.zzg = zzafvArray;
        this.zzh = l2;
        this.zzL(zzafvArray, l, l2);
    }

    public final zziu zzaj() {
        return this.zzf;
    }

    public final boolean zzak() {
        if (this.zzi != Long.MIN_VALUE) return false;
        return true;
    }

    public final long zzal() {
        return this.zzi;
    }

    public final void zzam() {
        this.zzj = true;
    }

    public final boolean zzan() {
        return this.zzj;
    }

    public final void zzao() throws IOException {
        zziu zziu2 = this.zzf;
        if (zziu2 == null) throw null;
        zziu2.zzc();
    }

    public final void zzap(long l) throws zzaeg {
        this.zzj = false;
        this.zzi = l;
        this.zzr(l, false);
    }

    public final void zzaq() {
        boolean bl = this.zze == 2;
        zzakt.zzd((boolean)bl);
        this.zze = 1;
        this.zzt();
    }

    public final void zzar() {
        int n = this.zze;
        boolean bl = true;
        if (n != 1) {
            bl = false;
        }
        zzakt.zzd((boolean)bl);
        zzafw zzafw2 = this.zzb;
        zzafw2.zzb = null;
        zzafw2.zza = null;
        this.zze = 0;
        this.zzf = null;
        this.zzg = null;
        this.zzj = false;
        this.zzu();
    }

    public final void zzas() {
        boolean bl = this.zze == 0;
        zzakt.zzd((boolean)bl);
        zzafw zzafw2 = this.zzb;
        zzafw2.zzb = null;
        zzafw2.zza = null;
        this.zzv();
    }

    protected final zzafw zzat() {
        zzafw zzafw2 = this.zzb;
        zzafw2.zzb = null;
        zzafw2.zza = null;
        return zzafw2;
    }

    protected final zzafv[] zzau() {
        zzafv[] zzafvArray = this.zzg;
        if (zzafvArray == null) throw null;
        return zzafvArray;
    }

    protected final zzahx zzav() {
        zzahx zzahx2 = this.zzc;
        if (zzahx2 == null) throw null;
        return zzahx2;
    }

    protected final zzaeg zzaw(Throwable throwable, zzafv zzafv2, boolean bl, int n) {
        int n2;
        block5: {
            if (zzafv2 != null && !this.zzk) {
                this.zzk = true;
                try {
                    n2 = this.zzH(zzafv2);
                    n2 &= 7;
                    break block5;
                }
                catch (zzaeg zzaeg2) {
                    this.zzk = false;
                }
                finally {
                    this.zzk = false;
                }
            }
            n2 = 4;
        }
        return zzaeg.zzb((Throwable)throwable, (String)this.zzc(), (int)this.zzd, (zzafv)zzafv2, (int)n2, (boolean)bl, (int)n);
    }

    protected final int zzax(zzafw zzafw2, zzaf zzaf2, int n) {
        long l;
        zziu zziu2 = this.zzf;
        if (zziu2 == null) throw null;
        if ((n = zziu2.zzd(zzafw2, zzaf2, n)) != -4) {
            if (n != -5) return n;
            zziu2 = zzafw2.zza;
            if (zziu2 == null) throw null;
            if (zziu2.zzp == Long.MAX_VALUE) return n;
            zzaf2 = new zzaft((zzafv)zziu2, null);
            zzaf2.zzR(zziu2.zzp + this.zzh);
            zzafw2.zza = new zzafv((zzaft)zzaf2, null);
            return -5;
        }
        if (zzaf2.zzc()) {
            this.zzi = Long.MIN_VALUE;
            if (!this.zzj) return -3;
            return -4;
        }
        zzaf2.zzd = l = zzaf2.zzd + this.zzh;
        this.zzi = Math.max(this.zzi, l);
        return n;
    }

    protected final int zzay(long l) {
        zziu zziu2 = this.zzf;
        if (zziu2 == null) throw null;
        return zziu2.zze(l - this.zzh);
    }

    protected final boolean zzaz() {
        boolean bl;
        if (this.zzak()) {
            bl = this.zzj;
        } else {
            zziu zziu2 = this.zzf;
            if (zziu2 == null) throw null;
            bl = zziu2.zzb();
        }
        return bl;
    }

    public zzalp zzi() {
        return null;
    }

    protected void zzq(boolean bl, boolean bl2) throws zzaeg {
    }

    protected void zzr(long l, boolean bl) throws zzaeg {
        throw null;
    }

    protected void zzs() throws zzaeg {
    }

    protected void zzt() {
    }

    protected void zzu() {
        throw null;
    }

    protected void zzv() {
    }
}
