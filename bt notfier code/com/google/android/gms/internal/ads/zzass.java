/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzasd
 *  com.google.android.gms.internal.ads.zzaso
 *  com.google.android.gms.internal.ads.zzasp
 *  com.google.android.gms.internal.ads.zzatb
 *  com.google.android.gms.internal.ads.zzatd
 *  com.google.android.gms.internal.ads.zzatf
 *  com.google.android.gms.internal.ads.zzatg
 *  com.google.android.gms.internal.ads.zzatk
 *  com.google.android.gms.internal.ads.zzaup
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzasd;
import com.google.android.gms.internal.ads.zzaso;
import com.google.android.gms.internal.ads.zzasp;
import com.google.android.gms.internal.ads.zzatb;
import com.google.android.gms.internal.ads.zzatd;
import com.google.android.gms.internal.ads.zzatf;
import com.google.android.gms.internal.ads.zzatg;
import com.google.android.gms.internal.ads.zzatk;
import com.google.android.gms.internal.ads.zzaup;
import java.io.IOException;
import java.util.ArrayList;
import java.util.IdentityHashMap;

final class zzass
implements zzasp,
zzaso {
    public final zzasp[] zza;
    private final IdentityHashMap<zzatb, Integer> zzb;
    private zzaso zzc;
    private int zzd;
    private zzatg zze;
    private zzasp[] zzf;
    private zzatd zzg;

    public zzass(zzasp ... zzaspArray) {
        this.zza = zzaspArray;
        this.zzb = new IdentityHashMap();
    }

    public final long zzB(zzatk[] zzatkArray, boolean[] blArray, zzatb[] zzatbArray, boolean[] blArray2, long l) {
        zzatf zzatf2;
        int n;
        zzatb zzatb2;
        int n2;
        int n3 = zzatkArray.length;
        int[] nArray = new int[n3];
        int[] nArray2 = new int[n3];
        n3 = 0;
        while (true) {
            if (n3 >= (n2 = zzatkArray.length)) break;
            zzatb2 = zzatbArray[n3];
            n = zzatb2 == null ? -1 : this.zzb.get(zzatb2);
            nArray[n3] = n;
            nArray2[n3] = -1;
            zzatb2 = zzatkArray[n3];
            if (zzatb2 != null) {
                zzatf2 = zzatb2.zza();
                for (n = 0; n < ((zzasp[])(zzatb2 = this.zza)).length; ++n) {
                    if (zzatb2[n].zzn().zzb(zzatf2) == -1) continue;
                    nArray2[n3] = n;
                    break;
                }
            }
            ++n3;
        }
        this.zzb.clear();
        zzatb[] zzatbArray2 = new zzatb[n2];
        zzatb[] zzatbArray3 = new zzatb[n2];
        zzatf2 = new zzatk[n2];
        zzatb2 = new ArrayList(this.zza.length);
        n3 = 0;
        while (true) {
            zzatb zzatb3;
            int n4;
            if (n3 >= this.zza.length) {
                System.arraycopy(zzatbArray2, 0, zzatbArray, 0, n2);
                zzatkArray = new zzasp[zzatb2.size()];
                this.zzf = zzatkArray;
                zzatb2.toArray(zzatkArray);
                this.zzg = new zzasd((zzatd[])this.zzf);
                return l;
            }
            for (n = 0; n < zzatkArray.length; ++n) {
                n4 = nArray[n];
                Object var18_20 = null;
                zzatb3 = n4 == n3 ? zzatbArray[n] : null;
                zzatbArray3[n] = zzatb3;
                zzatb3 = var18_20;
                if (nArray2[n] == n3) {
                    zzatb3 = zzatkArray[n];
                }
                zzatf2[n] = zzatb3;
            }
            long l2 = this.zza[n3].zzB((zzatk[])zzatf2, blArray, zzatbArray3, blArray2, l);
            if (n3 == 0) {
                l = l2;
            } else if (l2 != l) throw new IllegalStateException("Children enabled at different positions");
            n4 = 0;
            for (n = 0; n < zzatkArray.length; ++n) {
                int n5 = nArray2[n];
                boolean bl = true;
                if (n5 == n3) {
                    bl = zzatbArray3[n] != null;
                    zzaup.zzd((boolean)bl);
                    zzatbArray2[n] = zzatb3 = zzatbArray3[n];
                    this.zzb.put(zzatb3, n3);
                    n5 = 1;
                } else {
                    n5 = n4;
                    if (nArray[n] == n3) {
                        if (zzatbArray3[n] != null) {
                            bl = false;
                        }
                        zzaup.zzd((boolean)bl);
                        n5 = n4;
                    }
                }
                n4 = n5;
            }
            if (n4 != 0) {
                zzatb2.add(this.zza[n3]);
            }
            ++n3;
        }
    }

    public final long zza() {
        return this.zzg.zza();
    }

    public final boolean zzb(long l) {
        return this.zzg.zzb(l);
    }

    public final void zzj(zzasp zzaspArray) {
        int n;
        int n2;
        this.zzd = n2 = this.zzd - 1;
        if (n2 > 0) {
            return;
        }
        zzaspArray = this.zza;
        int n3 = zzaspArray.length;
        n2 = 0;
        for (n = 0; n < n3; n2 += zzaspArray[n].zzn().zzb, ++n) {
        }
        zzaspArray = new zzatf[n2];
        zzasp[] zzaspArray2 = this.zza;
        int n4 = zzaspArray2.length;
        n2 = 0;
        n = 0;
        while (true) {
            if (n2 >= n4) {
                this.zze = new zzatg((zzatf[])zzaspArray);
                this.zzc.zzj((zzasp)this);
                return;
            }
            zzatg zzatg2 = zzaspArray2[n2].zzn();
            int n5 = zzatg2.zzb;
            for (n3 = 0; n3 < n5; ++n3, ++n) {
                zzaspArray[n] = zzatg2.zza(n3);
            }
            ++n2;
        }
    }

    public final void zzl(zzaso zzaspArray, long l) {
        int n;
        this.zzc = zzaspArray;
        zzaspArray = this.zza;
        this.zzd = n = zzaspArray.length;
        int n2 = 0;
        while (n2 < n) {
            zzaspArray[n2].zzl((zzaso)this, l);
            ++n2;
        }
    }

    public final void zzm() throws IOException {
        zzasp[] zzaspArray = this.zza;
        int n = zzaspArray.length;
        int n2 = 0;
        while (n2 < n) {
            zzaspArray[n2].zzm();
            ++n2;
        }
    }

    public final zzatg zzn() {
        return this.zze;
    }

    public final void zzo(long l) {
        zzasp[] zzaspArray = this.zzf;
        int n = zzaspArray.length;
        int n2 = 0;
        while (n2 < n) {
            zzaspArray[n2].zzo(l);
            ++n2;
        }
    }

    public final long zzp() {
        zzasp zzasp2;
        int n;
        long l = this.zza[0].zzp();
        for (n = 1; n < ((zzasp[])(zzasp2 = this.zza)).length; ++n) {
            if (zzasp2[n].zzp() != -9223372036854775807L) throw new IllegalStateException("Child reported discontinuity");
        }
        if (l == -9223372036854775807L) return l;
        zzasp[] zzaspArray = this.zzf;
        int n2 = zzaspArray.length;
        n = 0;
        while (n < n2) {
            zzasp2 = zzaspArray[n];
            if (zzasp2 != this.zza[0]) {
                if (zzasp2.zzr(l) != l) throw new IllegalStateException("Children seeked to different positions");
            }
            ++n;
        }
        return l;
    }

    public final long zzq() {
        zzasp[] zzaspArray = this.zzf;
        int n = zzaspArray.length;
        int n2 = 0;
        long l = Long.MAX_VALUE;
        while (true) {
            if (n2 >= n) {
                if (l != Long.MAX_VALUE) return l;
                return Long.MIN_VALUE;
            }
            long l2 = zzaspArray[n2].zzq();
            long l3 = l;
            if (l2 != Long.MIN_VALUE) {
                l3 = Math.min(l, l2);
            }
            ++n2;
            l = l3;
        }
    }

    public final long zzr(long l) {
        zzasp[] zzaspArray;
        l = this.zzf[0].zzr(l);
        int n = 1;
        while (n < (zzaspArray = this.zzf).length) {
            if (zzaspArray[n].zzr(l) != l) throw new IllegalStateException("Children seeked to different positions");
            ++n;
        }
        return l;
    }
}
