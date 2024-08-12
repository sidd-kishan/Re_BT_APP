/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzanp
 *  com.google.android.gms.internal.ads.zzapn
 *  com.google.android.gms.internal.ads.zzapy
 *  com.google.android.gms.internal.ads.zzaqc
 *  com.google.android.gms.internal.ads.zzaqf
 *  com.google.android.gms.internal.ads.zzaqh
 *  com.google.android.gms.internal.ads.zzaup
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzanp;
import com.google.android.gms.internal.ads.zzapn;
import com.google.android.gms.internal.ads.zzapy;
import com.google.android.gms.internal.ads.zzaqc;
import com.google.android.gms.internal.ads.zzaqf;
import com.google.android.gms.internal.ads.zzaqh;
import com.google.android.gms.internal.ads.zzaup;
import java.io.IOException;
import java.util.Stack;

final class zzaqa {
    private final byte[] zza = new byte[8];
    private final Stack<zzapy> zzb = new Stack();
    private final zzaqh zzc = new zzaqh();
    private int zzd;
    private int zze;
    private long zzf;
    private zzaqc zzg;

    zzaqa() {
    }

    private final long zzd(zzapn zzapn2, int n) throws IOException, InterruptedException {
        byte[] byArray = this.zza;
        int n2 = 0;
        zzapn2.zzb(byArray, 0, n, false);
        long l = 0L;
        while (n2 < n) {
            l = l << 8 | (long)(this.zza[n2] & 0xFF);
            ++n2;
        }
        return l;
    }

    public final void zza() {
        this.zzd = 0;
        this.zzb.clear();
        this.zzc.zza();
    }

    public final void zzb(zzaqc zzaqc2) {
        this.zzg = zzaqc2;
    }

    public final boolean zzc(zzapn object) throws IOException, InterruptedException {
        boolean bl = this.zzg != null;
        zzaup.zzd((boolean)bl);
        while (true) {
            zzaqc zzaqc2;
            int n;
            long l;
            long l2;
            int n2;
            block19: {
                block20: {
                    block17: {
                        block18: {
                            block16: {
                                if (!this.zzb.isEmpty() && object.zzh() >= zzapy.zzb((zzapy)this.zzb.peek())) {
                                    object = this.zzg;
                                    n2 = zzapy.zza((zzapy)this.zzb.pop());
                                    ((zzaqc)object).zza.zzc(n2);
                                    return true;
                                }
                                n2 = this.zzd;
                                if (n2 != 0) break block16;
                                l = l2 = this.zzc.zze((zzapn)object, true, false, 4);
                                if (l2 != -2L) break block17;
                                break block18;
                            }
                            if (n2 != 1) break block19;
                            break block20;
                        }
                        object.zzg();
                        while (true) {
                            object.zze(this.zza, 0, 4, false);
                            n = zzaqh.zzc((int)this.zza[0]);
                            if (n != -1 && n <= 4) {
                                n2 = (int)zzaqh.zzd((byte[])this.zza, (int)n, (boolean)false);
                                zzaqc2 = this.zzg.zza;
                                if (zzaqf.zzm((int)n2)) {
                                    object.zzd(n, false);
                                    l = n2;
                                    break;
                                }
                            }
                            object.zzd(1, false);
                        }
                    }
                    if (l == -1L) {
                        return false;
                    }
                    this.zze = (int)l;
                    this.zzd = 1;
                }
                this.zzf = this.zzc.zze((zzapn)object, false, true, 8);
                this.zzd = 2;
            }
            zzaqc2 = this.zzg;
            n2 = this.zze;
            zzaqc2 = zzaqc2.zza;
            if ((n2 = zzaqf.zzl((int)n2)) != 0) {
                if (n2 == 1) {
                    l = object.zzh();
                    l2 = this.zzf;
                    this.zzb.add(new zzapy(this.zze, l2 + l, null));
                    object = this.zzg;
                    n2 = this.zze;
                    l2 = this.zzf;
                    ((zzaqc)object).zza.zzb(n2, l, l2);
                    this.zzd = 0;
                    return true;
                }
                if (n2 != 2) {
                    if (n2 != 3) {
                        if (n2 == 4) {
                            zzaqc2 = this.zzg;
                            n2 = this.zze;
                            l = this.zzf;
                            zzaqc2.zza.zzk(n2, (int)l, (zzapn)object);
                            this.zzd = 0;
                            return true;
                        }
                        l = this.zzf;
                        if (l != 4L && l != 8L) {
                            object = new StringBuilder(40);
                            ((StringBuilder)object).append("Invalid float size: ");
                            ((StringBuilder)object).append(l);
                            throw new zzanp(((StringBuilder)object).toString());
                        }
                        zzaqc2 = this.zzg;
                        n = this.zze;
                        n2 = (int)l;
                        l = this.zzd((zzapn)object, n2);
                        double d = n2 == 4 ? (double)Float.intBitsToFloat((int)l) : Double.longBitsToDouble(l);
                        zzaqc2.zza.zzi(n, d);
                        this.zzd = 0;
                        return true;
                    }
                    l = this.zzf;
                    if (l > Integer.MAX_VALUE) {
                        object = new StringBuilder(41);
                        ((StringBuilder)object).append("String element size: ");
                        ((StringBuilder)object).append(l);
                        throw new zzanp(((StringBuilder)object).toString());
                    }
                    zzaqc2 = this.zzg;
                    n = this.zze;
                    n2 = (int)l;
                    if (n2 == 0) {
                        object = "";
                    } else {
                        byte[] byArray = new byte[n2];
                        object.zzb(byArray, 0, n2, false);
                        object = new String(byArray);
                    }
                    zzaqc2.zza.zzj(n, (String)object);
                    this.zzd = 0;
                    return true;
                }
                l = this.zzf;
                if (l <= 8L) {
                    zzaqc2 = this.zzg;
                    n2 = this.zze;
                    l = this.zzd((zzapn)object, (int)l);
                    zzaqc2.zza.zzh(n2, l);
                    this.zzd = 0;
                    return true;
                }
                object = new StringBuilder(42);
                ((StringBuilder)object).append("Invalid integer size: ");
                ((StringBuilder)object).append(l);
                throw new zzanp(((StringBuilder)object).toString());
            }
            object.zzd((int)this.zzf, false);
            this.zzd = 0;
        }
    }
}
