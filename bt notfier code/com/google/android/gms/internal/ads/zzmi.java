/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.Surface
 *  com.google.android.gms.internal.ads.zzamq
 *  com.google.android.gms.internal.ads.zzlu
 *  com.google.android.gms.internal.ads.zzlw
 *  com.google.android.gms.internal.ads.zzmb
 *  com.google.android.gms.internal.ads.zzmc
 *  com.google.android.gms.internal.ads.zzmd
 *  com.google.android.gms.internal.ads.zzme
 *  com.google.android.gms.internal.ads.zzmf
 *  com.google.android.gms.internal.ads.zzmg
 *  com.google.android.gms.internal.ads.zzmh
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.Surface;
import com.google.android.gms.internal.ads.zzamq;
import com.google.android.gms.internal.ads.zzlu;
import com.google.android.gms.internal.ads.zzlw;
import com.google.android.gms.internal.ads.zzmb;
import com.google.android.gms.internal.ads.zzmc;
import com.google.android.gms.internal.ads.zzmd;
import com.google.android.gms.internal.ads.zzme;
import com.google.android.gms.internal.ads.zzmf;
import com.google.android.gms.internal.ads.zzmg;
import com.google.android.gms.internal.ads.zzmh;

public final class zzmi {
    private final zzlw zza = new zzlw();
    private final zzme zzb;
    private final zzmh zzc;
    private boolean zzd;
    private Surface zze;
    private float zzf;
    private float zzg;
    private float zzh;
    private float zzi;
    private int zzj;
    private long zzk;
    private long zzl;
    private long zzm;
    private long zzn;
    private long zzo;
    private long zzp;
    private long zzq;

    public zzmi(Context context) {
        zzme zzme2;
        zzme zzme3 = null;
        if (context != null) {
            Context context2 = context.getApplicationContext();
            zzme2 = zzamq.zza >= 17 ? zzmg.zzc((Context)context2) : null;
            context = zzme2;
            if (zzme2 == null) {
                context = zzmf.zzc((Context)context2);
            }
        } else {
            context = null;
        }
        this.zzb = context;
        zzme2 = zzme3;
        if (context != null) {
            zzme2 = zzmh.zza();
        }
        this.zzc = zzme2;
        this.zzk = -9223372036854775807L;
        this.zzl = -9223372036854775807L;
        this.zzf = -1.0f;
        this.zzi = 1.0f;
        this.zzj = 0;
    }

    private final void zzm() {
        this.zzm = 0L;
        this.zzp = -1L;
        this.zzn = -1L;
    }

    private final void zzn() {
        float f;
        block9: {
            boolean bl;
            block8: {
                block7: {
                    block6: {
                        float f2;
                        float f3;
                        if (zzamq.zza < 30) return;
                        if (this.zze == null) return;
                        f = this.zza.zzc() ? this.zza.zzg() : this.zzf;
                        if (f == (f3 = this.zzg)) {
                            return;
                        }
                        bl = true;
                        if (f == -1.0f || f3 == -1.0f) break block6;
                        boolean bl2 = this.zza.zzc();
                        f3 = f2 = 1.0f;
                        if (bl2) {
                            f3 = f2;
                            if (this.zza.zze() >= 5000000000L) {
                                f3 = 0.02f;
                            }
                        }
                        if (!(Math.abs(f - this.zzg) >= f3)) break block7;
                        break block8;
                    }
                    if (f != -1.0f) break block9;
                    if (this.zza.zzd() >= 30) break block8;
                }
                bl = false;
            }
            if (!bl) return;
        }
        this.zzg = f;
        this.zzo(false);
    }

    private final void zzo(boolean bl) {
        float f;
        if (zzamq.zza < 30) return;
        Surface surface = this.zze;
        if (surface == null) return;
        if (this.zzj == Integer.MIN_VALUE) return;
        boolean bl2 = this.zzd;
        float f2 = f = 0.0f;
        if (bl2) {
            float f3 = this.zzg;
            f2 = f;
            if (f3 != -1.0f) {
                f2 = this.zzi * f3;
            }
        }
        if (!bl && this.zzh == f2) {
            return;
        }
        this.zzh = f2;
        zzmc.zza((Surface)surface, (float)f2);
    }

    private final void zzp() {
        if (zzamq.zza < 30) return;
        Surface surface = this.zze;
        if (surface == null) return;
        if (this.zzj == Integer.MIN_VALUE) return;
        if (this.zzh == 0.0f) return;
        this.zzh = 0.0f;
        zzmc.zza((Surface)surface, (float)0.0f);
    }

    public final void zza(int n) {
        if (this.zzj == n) {
            return;
        }
        this.zzj = n;
        this.zzo(true);
    }

    public final void zzb() {
        if (this.zzb == null) return;
        zzmh zzmh2 = this.zzc;
        if (zzmh2 == null) throw null;
        zzmh2.zzb();
        this.zzb.zza((zzmd)new zzmb(this));
    }

    public final void zzc() {
        this.zzd = true;
        this.zzm();
        this.zzo(false);
    }

    public final void zzd(Surface surface) {
        Surface surface2 = surface;
        if (surface instanceof zzlu) {
            surface2 = null;
        }
        if (this.zze == surface2) {
            return;
        }
        this.zzp();
        this.zze = surface2;
        this.zzo(true);
    }

    public final void zze() {
        this.zzm();
    }

    public final void zzf(float f) {
        this.zzi = f;
        this.zzm();
        this.zzo(false);
    }

    public final void zzg(float f) {
        this.zzf = f;
        this.zza.zza();
        this.zzn();
    }

    public final void zzh(long l) {
        long l2 = this.zzn;
        if (l2 != -1L) {
            this.zzp = l2;
            this.zzq = this.zzo;
        }
        ++this.zzm;
        this.zza.zzb(l * 1000L);
        this.zzn();
    }

    public final void zzi() {
        this.zzd = false;
        this.zzp();
    }

    public final void zzj() {
        zzme zzme2 = this.zzb;
        if (zzme2 == null) return;
        zzme2.zzb();
        zzme2 = this.zzc;
        if (zzme2 == null) throw null;
        zzme2.zzc();
    }

    public final long zzk(long l) {
        long l2;
        long l3 = l;
        if (this.zzp != -1L) {
            l3 = l;
            if (this.zza.zzc() && Math.abs(l - (l3 = this.zzq + (long)((float)((l2 = this.zza.zzf()) * (this.zzm - this.zzp)) / this.zzi))) > 20000000L) {
                this.zzm();
                l3 = l;
            }
        }
        this.zzn = this.zzm;
        this.zzo = l3;
        zzmh zzmh2 = this.zzc;
        if (zzmh2 == null) return l3;
        if (this.zzk == -9223372036854775807L) {
            return l3;
        }
        l = zzmh2.zza;
        if (l == -9223372036854775807L) {
            return l3;
        }
        l2 = this.zzk;
        if (l3 <= (l += (l3 - l) / l2 * l2)) {
            l2 = l - l2;
        } else {
            long l4 = l2 + l;
            l2 = l;
            l = l4;
        }
        if (l - l3 < l3 - l2) return l - this.zzl;
        l = l2;
        return l - this.zzl;
    }
}
