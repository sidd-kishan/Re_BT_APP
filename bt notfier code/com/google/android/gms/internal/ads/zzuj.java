/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.SparseArray
 *  android.util.SparseBooleanArray
 *  android.util.SparseIntArray
 *  com.google.android.gms.internal.ads.zzamf
 *  com.google.android.gms.internal.ads.zzamn
 *  com.google.android.gms.internal.ads.zznp
 *  com.google.android.gms.internal.ads.zznu
 *  com.google.android.gms.internal.ads.zznv
 *  com.google.android.gms.internal.ads.zznx
 *  com.google.android.gms.internal.ads.zzoa
 *  com.google.android.gms.internal.ads.zzoq
 *  com.google.android.gms.internal.ads.zzos
 *  com.google.android.gms.internal.ads.zzot
 *  com.google.android.gms.internal.ads.zzsy
 *  com.google.android.gms.internal.ads.zzua
 *  com.google.android.gms.internal.ads.zzub
 *  com.google.android.gms.internal.ads.zzue
 *  com.google.android.gms.internal.ads.zzuf
 *  com.google.android.gms.internal.ads.zzug
 *  com.google.android.gms.internal.ads.zzuh
 *  com.google.android.gms.internal.ads.zzum
 *  com.google.android.gms.internal.ads.zzuo
 *  com.google.android.gms.internal.ads.zzup
 */
package com.google.android.gms.internal.ads;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import com.google.android.gms.internal.ads.zzamf;
import com.google.android.gms.internal.ads.zzamn;
import com.google.android.gms.internal.ads.zznp;
import com.google.android.gms.internal.ads.zznu;
import com.google.android.gms.internal.ads.zznv;
import com.google.android.gms.internal.ads.zznx;
import com.google.android.gms.internal.ads.zzoa;
import com.google.android.gms.internal.ads.zzoq;
import com.google.android.gms.internal.ads.zzos;
import com.google.android.gms.internal.ads.zzot;
import com.google.android.gms.internal.ads.zzsy;
import com.google.android.gms.internal.ads.zzua;
import com.google.android.gms.internal.ads.zzub;
import com.google.android.gms.internal.ads.zzue;
import com.google.android.gms.internal.ads.zzuf;
import com.google.android.gms.internal.ads.zzug;
import com.google.android.gms.internal.ads.zzuh;
import com.google.android.gms.internal.ads.zzum;
import com.google.android.gms.internal.ads.zzuo;
import com.google.android.gms.internal.ads.zzup;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

public final class zzuj
implements zznu {
    public static final zzoa zza = zzug.zza;
    private final List<zzamn> zzb;
    private final zzamf zzc;
    private final SparseIntArray zzd;
    private final zzum zze;
    private final SparseArray<zzuo> zzf;
    private final SparseBooleanArray zzg;
    private final SparseBooleanArray zzh;
    private final zzuf zzi;
    private zzue zzj;
    private zznx zzk;
    private int zzl;
    private boolean zzm;
    private boolean zzn;
    private boolean zzo;
    private int zzp;
    private int zzq;

    public zzuj() {
        this(0);
    }

    public zzuj(int n) {
        this(1, 0, 112800);
    }

    public zzuj(int n, int n2, int n3) {
        zzamn zzamn2 = new zzamn(0L);
        zzsy zzsy2 = new zzsy(0);
        this.zze = zzsy2;
        this.zzb = Collections.singletonList(zzamn2);
        this.zzc = new zzamf(new byte[9400], 0);
        this.zzg = new SparseBooleanArray();
        this.zzh = new SparseBooleanArray();
        this.zzf = new SparseArray();
        this.zzd = new SparseIntArray();
        this.zzi = new zzuf(112800);
        this.zzk = zznx.zza;
        this.zzq = -1;
        this.zzg.clear();
        this.zzf.clear();
        zzamn2 = new SparseArray();
        n2 = zzamn2.size();
        n = 0;
        while (true) {
            if (n >= n2) {
                this.zzf.put(0, (Object)new zzub((zzua)new zzuh(this)));
                return;
            }
            this.zzf.put(zzamn2.keyAt(n), (Object)((zzuo)zzamn2.valueAt(n)));
            ++n;
        }
    }

    static /* synthetic */ List zze(zzuj zzuj2) {
        return zzuj2.zzb;
    }

    static /* synthetic */ zzum zzf(zzuj zzuj2) {
        return zzuj2.zze;
    }

    static /* synthetic */ SparseArray zzg(zzuj zzuj2) {
        return zzuj2.zzf;
    }

    static /* synthetic */ SparseBooleanArray zzh(zzuj zzuj2) {
        return zzuj2.zzg;
    }

    static /* synthetic */ SparseBooleanArray zzi(zzuj zzuj2) {
        return zzuj2.zzh;
    }

    static /* synthetic */ zznx zzj(zzuj zzuj2) {
        return zzuj2.zzk;
    }

    static /* synthetic */ int zzk(zzuj zzuj2) {
        return zzuj2.zzl;
    }

    static /* synthetic */ int zzl(zzuj zzuj2, int n) {
        zzuj2.zzl = n;
        return n;
    }

    static /* synthetic */ boolean zzm(zzuj zzuj2, boolean bl) {
        zzuj2.zzm = true;
        return true;
    }

    static /* synthetic */ int zzn(zzuj zzuj2, int n) {
        zzuj2.zzq = n;
        return n;
    }

    public final boolean zza(zznv zznv2) throws IOException {
        byte[] byArray = this.zzc.zzi();
        zznv2 = (zznp)zznv2;
        zznv2.zzh(byArray, 0, 940, false);
        int n = 0;
        block0: while (n < 188) {
            int n2 = 0;
            while (true) {
                if (n2 >= 5) {
                    zznv2.zzd(n, false);
                    return true;
                }
                if (byArray[n2 * 188 + n] != 71) {
                    ++n;
                    continue block0;
                }
                ++n2;
            }
            break;
        }
        return false;
    }

    public final void zzb(zznx zznx2) {
        this.zzk = zznx2;
    }

    public final int zzc(zznv object, zzoq object2) throws IOException {
        int n;
        block23: {
            long l;
            block22: {
                boolean bl;
                int n2;
                int n3;
                l = object.zzo();
                if (this.zzm) {
                    zzue zzue2;
                    if (l != -1L) {
                        if (!this.zzi.zza()) return this.zzi.zzb(object, object2, this.zzq);
                    }
                    if (!this.zzn) {
                        this.zzn = true;
                        if (this.zzi.zzc() != -9223372036854775807L) {
                            this.zzj = zzue2 = new zzue(this.zzi.zzd(), this.zzi.zzc(), l, this.zzq, 112800);
                            this.zzk.zzD(zzue2.zza());
                        } else {
                            this.zzk.zzD((zzot)new zzos(this.zzi.zzc(), 0L));
                        }
                    }
                    if (this.zzo) {
                        this.zzo = false;
                        this.zzd(0L, 0L);
                        if (object.zzn() != 0L) {
                            object2.zza = 0L;
                            return 1;
                        }
                    }
                    if ((zzue2 = this.zzj) != null) {
                        if (zzue2.zzc()) return this.zzj.zzd(object, object2);
                    }
                }
                object2 = this.zzc.zzi();
                if (9400 - this.zzc.zzg() < 188) {
                    n3 = this.zzc.zzd();
                    if (n3 > 0) {
                        System.arraycopy(object2, this.zzc.zzg(), object2, 0, n3);
                    }
                    this.zzc.zzb((byte[])object2, n3);
                }
                while (this.zzc.zzd() < 188) {
                    n3 = this.zzc.zze();
                    n2 = object.zzg((byte[])object2, n3, 9400 - n3);
                    if (n2 == -1) {
                        return -1;
                    }
                    this.zzc.zzf(n3 + n2);
                }
                n3 = this.zzc.zzg();
                int n4 = this.zzc.zze();
                n2 = zzup.zza((byte[])this.zzc.zzi(), (int)n3, (int)n4);
                this.zzc.zzh(n2);
                n = n2 + 188;
                this.zzp = n > n4 ? (this.zzp += n2 - n3) : 0;
                n4 = this.zzc.zze();
                if (n > n4) {
                    return 0;
                }
                int n5 = this.zzc.zzv();
                if ((0x800000 & n5) != 0) {
                    this.zzc.zzh(n);
                    return 0;
                }
                n3 = (0x400000 & n5) != 0 ? 1 : 0;
                int n6 = n5 >> 8 & 0x1FFF;
                object = (n5 & 0x10) != 0 ? (zzuo)this.zzf.get(n6) : null;
                if (object == null) {
                    this.zzc.zzh(n);
                    return 0;
                }
                int n7 = n5 & 0xF;
                n2 = this.zzd.get(n6, n7 - 1);
                this.zzd.put(n6, n7);
                if (n2 == n7) {
                    this.zzc.zzh(n);
                    return 0;
                }
                if (n7 != (n2 + 1 & 0xF)) {
                    object.zzb();
                }
                n2 = n3;
                if ((n5 & 0x20) != 0) {
                    n5 = this.zzc.zzn();
                    n2 = (this.zzc.zzn() & 0x40) != 0 ? 2 : 0;
                    n2 = n3 | n2;
                    this.zzc.zzk(n5 - 1);
                }
                if (!(bl = this.zzm) && this.zzh.get(n6, false)) break block22;
                this.zzc.zzf(n);
                object.zzc(this.zzc, n2);
                this.zzc.zzf(n4);
                if (bl) break block23;
            }
            if (this.zzm && l != -1L) {
                this.zzo = true;
            }
        }
        this.zzc.zzh(n);
        return 0;
    }

    public final void zzd(long l, long l2) {
        zzamn zzamn2;
        int n;
        int n2 = this.zzb.size();
        for (n = 0; n < n2; ++n) {
            zzamn2 = this.zzb.get(n);
            if (zzamn2.zzc() != -9223372036854775807L && ((l = zzamn2.zza()) == -9223372036854775807L || l == 0L || l == l2)) continue;
            zzamn2.zzd(l2);
        }
        if (l2 != 0L && (zzamn2 = this.zzj) != null) {
            zzamn2.zzb(l2);
        }
        this.zzc.zza(0);
        this.zzd.clear();
        n = 0;
        while (true) {
            if (n >= this.zzf.size()) {
                this.zzp = 0;
                return;
            }
            ((zzuo)this.zzf.valueAt(n)).zzb();
            ++n;
        }
    }
}
