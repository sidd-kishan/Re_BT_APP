/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzahz
 *  com.google.android.gms.internal.ads.zzakt
 *  com.google.android.gms.internal.ads.zzgr
 *  com.google.android.gms.internal.ads.zzgs
 *  com.google.android.gms.internal.ads.zzhd
 *  com.google.android.gms.internal.ads.zzhe
 *  com.google.android.gms.internal.ads.zzhr
 *  com.google.android.gms.internal.ads.zziu
 *  com.google.android.gms.internal.ads.zziw
 *  com.google.android.gms.internal.ads.zzjg
 *  com.google.android.gms.internal.ads.zzq
 *  com.google.android.gms.internal.ads.zzs
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzahz;
import com.google.android.gms.internal.ads.zzakt;
import com.google.android.gms.internal.ads.zzgr;
import com.google.android.gms.internal.ads.zzgs;
import com.google.android.gms.internal.ads.zzhd;
import com.google.android.gms.internal.ads.zzhe;
import com.google.android.gms.internal.ads.zzhr;
import com.google.android.gms.internal.ads.zziu;
import com.google.android.gms.internal.ads.zziw;
import com.google.android.gms.internal.ads.zzjg;
import com.google.android.gms.internal.ads.zzq;
import com.google.android.gms.internal.ads.zzs;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;

final class zzht
implements zzhe,
zzhd {
    private final zzhe[] zza;
    private final IdentityHashMap<zziu, Integer> zzb;
    private final ArrayList<zzhe> zzc;
    private zzhd zzd;
    private zzs zze;
    private zzhe[] zzf;
    private zziw zzg;
    private final zzgs zzh;

    public zzht(zzgs zzgs2, long[] lArray, zzhe[] zzheArray, byte ... byArray) {
        this.zzh = zzgs2;
        this.zza = zzheArray;
        this.zzc = new ArrayList();
        int n = 0;
        this.zzg = new zzgr(new zziw[0]);
        this.zzb = new IdentityHashMap();
        this.zzf = new zzhe[0];
        while (n < zzheArray.length) {
            long l = lArray[n];
            if (l != 0L) {
                this.zza[n] = new zzhr(zzheArray[n], l);
            }
            ++n;
        }
    }

    public final zzhe zza(int n) {
        zzhe zzhe2;
        zzhe zzhe3 = zzhe2 = this.zza[n];
        if (!(zzhe2 instanceof zzhr)) return zzhe3;
        zzhe3 = zzhr.zza((zzhr)((zzhr)zzhe2));
        return zzhe3;
    }

    public final void zzb(zzhd zzheArray, long l) {
        this.zzd = zzheArray;
        Collections.addAll(this.zzc, this.zza);
        zzheArray = this.zza;
        int n = zzheArray.length;
        int n2 = 0;
        while (n2 < n) {
            zzheArray[n2].zzb((zzhd)this, l);
            ++n2;
        }
    }

    public final void zzc() throws IOException {
        zzhe[] zzheArray = this.zza;
        int n = zzheArray.length;
        int n2 = 0;
        while (n2 < n) {
            zzheArray[n2].zzc();
            ++n2;
        }
    }

    public final zzs zzd() {
        zzs zzs2 = this.zze;
        if (zzs2 == null) throw null;
        return zzs2;
    }

    public final void zze(long l, boolean bl) {
        zzhe[] zzheArray = this.zzf;
        int n = zzheArray.length;
        int n2 = 0;
        while (n2 < n) {
            zzheArray[n2].zze(l, false);
            ++n2;
        }
    }

    public final void zzf(long l) {
        this.zzg.zzf(l);
    }

    public final long zzg() {
        zzhe[] zzheArray = this.zzf;
        int n = zzheArray.length;
        long l = -9223372036854775807L;
        int n2 = 0;
        while (n2 < n) {
            long l2;
            block5: {
                zzhe zzhe2;
                int n3;
                zzhe[] zzheArray2;
                zzhe zzhe3;
                block4: {
                    block2: {
                        block3: {
                            zzhe3 = zzheArray[n2];
                            l2 = zzhe3.zzg();
                            if (l2 == -9223372036854775807L) break block2;
                            if (l != -9223372036854775807L) break block3;
                            zzheArray2 = this.zzf;
                            n3 = zzheArray2.length;
                            break block4;
                        }
                        if (l2 != l) throw new IllegalStateException("Conflicting discontinuities.");
                        l2 = l;
                        break block5;
                    }
                    l2 = l;
                    if (l == -9223372036854775807L) break block5;
                    if (zzhe3.zzi(l) != l) throw new IllegalStateException("Unexpected child seekToUs result.");
                    l2 = l;
                    break block5;
                }
                for (int i = 0; i < n3 && (zzhe2 = zzheArray2[i]) != zzhe3; ++i) {
                    if (zzhe2.zzi(l2) != l2) throw new IllegalStateException("Unexpected child seekToUs result.");
                }
            }
            ++n2;
            l = l2;
        }
        return l;
    }

    public final long zzh() {
        return this.zzg.zzh();
    }

    public final long zzi(long l) {
        zzhe[] zzheArray;
        l = this.zzf[0].zzi(l);
        int n = 1;
        while (n < (zzheArray = this.zzf).length) {
            if (zzheArray[n].zzi(l) != l) throw new IllegalStateException("Unexpected child seekToUs result.");
            ++n;
        }
        return l;
    }

    public final long zzj(long l, zzahz zzahz2) {
        zzhe zzhe2 = this.zzf;
        zzhe2 = ((zzhe[])zzhe2).length > 0 ? zzhe2[0] : this.zza[0];
        return zzhe2.zzj(l, zzahz2);
    }

    public final long zzk() {
        return this.zzg.zzk();
    }

    public final boolean zzl(long l) {
        if (this.zzc.isEmpty()) return this.zzg.zzl(l);
        int n = this.zzc.size();
        int n2 = 0;
        while (n2 < n) {
            this.zzc.get(n2).zzl(l);
            ++n2;
        }
        return false;
    }

    public final boolean zzm() {
        return this.zzg.zzm();
    }

    public final void zzn(zzhe zzs2) {
        int n;
        this.zzc.remove(zzs2);
        if (!this.zzc.isEmpty()) {
            return;
        }
        zzs2 = this.zza;
        int n2 = ((zzhe[])zzs2).length;
        int n3 = 0;
        for (n = 0; n < n2; n3 += zzs2[n].zzd().zzb, ++n) {
        }
        zzq[] zzqArray = new zzq[n3];
        zzhe[] zzheArray = this.zza;
        int n4 = zzheArray.length;
        n3 = 0;
        n = 0;
        while (true) {
            if (n3 >= n4) {
                this.zze = new zzs(zzqArray);
                zzs2 = this.zzd;
                if (zzs2 == null) throw null;
                zzs2.zzn((zzhe)this);
                return;
            }
            zzs2 = zzheArray[n3].zzd();
            int n5 = zzs2.zzb;
            for (n2 = 0; n2 < n5; ++n2, ++n) {
                zzqArray[n] = zzs2.zza(n2);
            }
            ++n3;
        }
    }

    public final long zzq(zzjg[] zzjgArray, boolean[] blArray, zziu[] zziuArray, boolean[] blArray2, long l) {
        int n;
        zziu[] zziuArray2;
        zzjg zzjg2;
        int n2;
        int n3 = zzjgArray.length;
        int[] nArray = new int[n3];
        int[] nArray2 = new int[n3];
        n3 = 0;
        while (true) {
            n2 = zzjgArray.length;
            zzjg2 = null;
            if (n3 >= n2) break;
            zziuArray2 = zziuArray[n3];
            if (zziuArray2 != null) {
                zzjg2 = this.zzb.get(zziuArray2);
            }
            n = zzjg2 == null ? -1 : zzjg2.intValue();
            nArray[n3] = n;
            nArray2[n3] = -1;
            zzjg2 = zzjgArray[n3];
            if (zzjg2 != null) {
                zzjg2 = zzjg2.zzb();
                for (n = 0; n < (zziuArray2 = this.zza).length; ++n) {
                    if (zziuArray2[n].zzd().zzb((zzq)zzjg2) == -1) continue;
                    nArray2[n3] = n;
                    break;
                }
            }
            ++n3;
        }
        this.zzb.clear();
        zziu[] zziuArray3 = new zziu[n2];
        zziuArray2 = new zziu[n2];
        zzjg2 = new zzjg[n2];
        ArrayList<zzhe> arrayList = new ArrayList<zzhe>(this.zza.length);
        n3 = 0;
        while (true) {
            Object object;
            if (n3 >= this.zza.length) {
                System.arraycopy(zziuArray3, 0, zziuArray, 0, n2);
                zzjgArray = arrayList.toArray(new zzhe[0]);
                this.zzf = zzjgArray;
                this.zzg = new zzgr((zziw[])zzjgArray);
                return l;
            }
            for (n = 0; n < zzjgArray.length; ++n) {
                object = nArray[n] == n3 ? zziuArray[n] : null;
                zziuArray2[n] = object;
                object = nArray2[n] == n3 ? zzjgArray[n] : null;
                zzjg2[n] = object;
            }
            long l2 = this.zza[n3].zzq((zzjg[])zzjg2, blArray, zziuArray2, blArray2, l);
            if (n3 == 0) {
                l = l2;
            } else if (l2 != l) throw new IllegalStateException("Children enabled at different positions.");
            n = 0;
            for (int i = 0; i < zzjgArray.length; ++i) {
                int n4 = nArray2[i];
                boolean bl = true;
                if (n4 == n3) {
                    object = zziuArray2[i];
                    if (object == null) throw null;
                    zziuArray3[i] = object;
                    this.zzb.put((zziu)object, n3);
                    n4 = 1;
                } else {
                    n4 = n;
                    if (nArray[i] == n3) {
                        if (zziuArray2[i] != null) {
                            bl = false;
                        }
                        zzakt.zzd((boolean)bl);
                        n4 = n;
                    }
                }
                n = n4;
            }
            if (n != 0) {
                arrayList.add(this.zza[n3]);
            }
            ++n3;
        }
    }
}
