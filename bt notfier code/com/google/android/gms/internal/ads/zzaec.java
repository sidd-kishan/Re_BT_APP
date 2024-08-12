/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzaeb
 *  com.google.android.gms.internal.ads.zzaeg
 *  com.google.android.gms.internal.ads.zzahf
 *  com.google.android.gms.internal.ads.zzahv
 *  com.google.android.gms.internal.ads.zzaku
 *  com.google.android.gms.internal.ads.zzalp
 *  com.google.android.gms.internal.ads.zzamh
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzaeb;
import com.google.android.gms.internal.ads.zzaeg;
import com.google.android.gms.internal.ads.zzahf;
import com.google.android.gms.internal.ads.zzahv;
import com.google.android.gms.internal.ads.zzaku;
import com.google.android.gms.internal.ads.zzalp;
import com.google.android.gms.internal.ads.zzamh;

final class zzaec
implements zzalp {
    private final zzamh zza;
    private final zzaeb zzb;
    private zzahv zzc;
    private zzalp zzd;
    private boolean zze;
    private boolean zzf;

    public zzaec(zzaeb zzaeb2, zzaku zzaku2) {
        this.zzb = zzaeb2;
        this.zza = new zzamh(zzaku2);
        this.zze = true;
    }

    public final zzahf zzA() {
        zzalp zzalp2 = this.zzd;
        zzalp2 = zzalp2 != null ? zzalp2.zzA() : this.zza.zzA();
        return zzalp2;
    }

    public final void zza() {
        this.zzf = true;
        this.zza.zza();
    }

    public final void zzb() {
        this.zzf = false;
        this.zza.zzb();
    }

    public final void zzc(long l) {
        this.zza.zzc(l);
    }

    public final void zzd(zzahv zzahv2) throws zzaeg {
        zzalp zzalp2 = zzahv2.zzi();
        if (zzalp2 == null) return;
        zzalp zzalp3 = this.zzd;
        if (zzalp2 == zzalp3) return;
        if (zzalp3 != null) throw zzaeg.zzc((RuntimeException)new IllegalStateException("Multiple renderer media clocks enabled."), (int)1000);
        this.zzd = zzalp2;
        this.zzc = zzahv2;
        zzalp2.zzz(this.zza.zzA());
    }

    public final void zze(zzahv zzahv2) {
        if (zzahv2 != this.zzc) return;
        this.zzd = null;
        this.zzc = null;
        this.zze = true;
    }

    /*
     * Unable to fully structure code
     */
    public final long zzf(boolean var1_1) {
        block8: {
            block7: {
                var4_2 = this.zzc;
                if (var4_2 == null || var4_2.zzw() || !this.zzc.zzx() && (var1_1 || this.zzc.zzak())) break block7;
                var4_2 = this.zzd;
                if (var4_2 == null) throw null;
                var2_3 = var4_2.zzy();
                if (!this.zze) ** GOTO lbl13
                if (var2_3 < this.zza.zzy()) {
                    this.zza.zzb();
                } else {
                    this.zze = false;
                    if (this.zzf) {
                        this.zza.zza();
                    }
lbl13:
                    // 4 sources

                    this.zza.zzc(var2_3);
                    var4_2 = var4_2.zzA();
                    if (!var4_2.equals((Object)this.zza.zzA())) {
                        this.zza.zzz((zzahf)var4_2);
                        this.zzb.zzb((zzahf)var4_2);
                    }
                }
                break block8;
            }
            this.zze = true;
            if (this.zzf) {
                this.zza.zza();
            }
        }
        if (this.zze) {
            var2_3 = this.zza.zzy();
        } else {
            var4_2 = this.zzd;
            if (var4_2 == null) throw null;
            var2_3 = var4_2.zzy();
        }
        return var2_3;
    }

    public final long zzy() {
        throw null;
    }

    public final void zzz(zzahf zzahf2) {
        zzalp zzalp2 = this.zzd;
        zzahf zzahf3 = zzahf2;
        if (zzalp2 != null) {
            zzalp2.zzz(zzahf2);
            zzahf3 = this.zzd.zzA();
        }
        this.zza.zzz(zzahf3);
    }
}
