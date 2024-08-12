/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.internal.ads.zzazm
 *  com.google.android.gms.internal.ads.zzazn
 *  com.google.android.gms.internal.ads.zzazo
 *  com.google.android.gms.internal.ads.zzazq
 *  com.google.android.gms.internal.ads.zzazr
 *  com.google.android.gms.internal.ads.zzazs
 *  com.google.android.gms.internal.ads.zzazt
 *  com.google.android.gms.internal.ads.zzazu
 *  com.google.android.gms.internal.ads.zzbdg
 *  com.google.android.gms.internal.ads.zzbdr
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzcbn
 *  com.google.android.gms.internal.ads.zzfcb
 *  com.google.android.gms.internal.ads.zzfcc
 *  com.google.android.gms.internal.ads.zzfcf
 *  com.google.android.gms.internal.ads.zzfcj
 *  com.google.android.gms.internal.ads.zzfcl
 *  com.google.android.gms.internal.ads.zzfcm
 *  com.google.android.gms.internal.ads.zzfcn
 *  com.google.android.gms.internal.ads.zzfcz
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzazm;
import com.google.android.gms.internal.ads.zzazn;
import com.google.android.gms.internal.ads.zzazo;
import com.google.android.gms.internal.ads.zzazq;
import com.google.android.gms.internal.ads.zzazr;
import com.google.android.gms.internal.ads.zzazs;
import com.google.android.gms.internal.ads.zzazt;
import com.google.android.gms.internal.ads.zzazu;
import com.google.android.gms.internal.ads.zzbdg;
import com.google.android.gms.internal.ads.zzbdr;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzcbn;
import com.google.android.gms.internal.ads.zzfcb;
import com.google.android.gms.internal.ads.zzfcc;
import com.google.android.gms.internal.ads.zzfcf;
import com.google.android.gms.internal.ads.zzfcj;
import com.google.android.gms.internal.ads.zzfcl;
import com.google.android.gms.internal.ads.zzfcm;
import com.google.android.gms.internal.ads.zzfcn;
import com.google.android.gms.internal.ads.zzfcz;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

final class zzfcd
implements zzfcc {
    private final ConcurrentHashMap<zzfcm, zzfcb> zza;
    private final zzfcj zzb;
    private final zzfcf zzc;

    public zzfcd(zzfcj zzfcj2) {
        this.zza = new ConcurrentHashMap(zzfcj2.zzd);
        this.zzb = zzfcj2;
        this.zzc = new zzfcf();
    }

    private final void zzf() {
        int n;
        Object object = zzfcj.CREATOR;
        object = zzbjl.zzeG;
        if ((Boolean)zzbet.zzc().zzc((zzbjd)object) == false) return;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.zzb.zzb);
        stringBuilder.append(" PoolCollection");
        stringBuilder.append(this.zzc.zzg());
        object = this.zza.entrySet().iterator();
        int n2 = 0;
        while (true) {
            n = n2;
            if (!object.hasNext()) break;
            Map.Entry entry = (Map.Entry)object.next();
            n = n2 + 1;
            stringBuilder.append(n);
            stringBuilder.append(". ");
            stringBuilder.append(entry.getValue());
            stringBuilder.append("#");
            stringBuilder.append(((zzfcm)entry.getKey()).hashCode());
            stringBuilder.append("    ");
            for (n2 = 0; n2 < ((zzfcb)entry.getValue()).zzc(); ++n2) {
                stringBuilder.append("[O]");
            }
            for (n2 = ((zzfcb)entry.getValue()).zzc(); n2 < this.zzb.zzd; ++n2) {
                stringBuilder.append("[ ]");
            }
            stringBuilder.append("\n");
            stringBuilder.append(((zzfcb)entry.getValue()).zzg());
            stringBuilder.append("\n");
            n2 = n;
        }
        while (true) {
            if (n >= this.zzb.zzc) {
                zze.zzd((String)stringBuilder.toString());
                return;
            }
            stringBuilder.append(++n);
            stringBuilder.append(".\n");
        }
    }

    public final zzfcl<?, ?> zza(zzfcm zzfcm2) {
        synchronized (this) {
            zzfcb zzfcb2 = this.zza.get(zzfcm2);
            if (zzfcb2 != null) {
                zzfcm2 = zzfcb2.zzb();
                if (zzfcm2 == null) {
                    this.zzc.zzb();
                }
                zzfcz zzfcz2 = zzfcb2.zzh();
                if (zzfcm2 != null) {
                    zzazo zzazo2 = zzazu.zza();
                    zzfcb2 = zzazn.zza();
                    zzfcb2.zzd(2);
                    zzazq zzazq2 = zzazr.zza();
                    zzazq2.zza(zzfcz2.zza);
                    zzazq2.zzb(zzfcz2.zzb);
                    zzfcb2.zzb(zzazq2);
                    zzazo2.zza((zzazm)zzfcb2);
                    zzfcb2 = (zzazu)zzazo2.zzah();
                    zzfcm2.zza.zzP().zze().zzc((zzazu)zzfcb2);
                }
                this.zzf();
            } else {
                this.zzc.zza();
                this.zzf();
                zzfcm2 = null;
            }
            return zzfcm2;
        }
    }

    /*
     * WARNING - void declaration
     * Enabled unnecessary exception pruning
     */
    public final boolean zzb(zzfcm zzfcm2, zzfcl<?, ?> zzfcl2) {
        synchronized (this) {
            void var8_20;
            Object object;
            Object object2;
            zzfcb zzfcb2;
            block12: {
                block13: {
                    block16: {
                        void var8_15;
                        long l;
                        block14: {
                            void var8_12;
                            block15: {
                                zzfcb2 = this.zza.get(zzfcm2);
                                zzfcl2.zzd = zzt.zzj().currentTimeMillis();
                                zzfcb zzfcb3 = zzfcb2;
                                if (zzfcb2 != null) break block12;
                                zzfcj zzfcj2 = this.zzb;
                                zzfcb2 = new zzfcb(zzfcj2.zzd, zzfcj2.zze * 1000);
                                int n = this.zza.size();
                                zzfcj zzfcj3 = this.zzb;
                                if (n != zzfcj3.zzc) break block13;
                                int n2 = zzfcj3.zzg;
                                n = n2 - 1;
                                object2 = null;
                                object = null;
                                Object var8_8 = null;
                                if (n2 == 0) throw null;
                                l = Long.MAX_VALUE;
                                if (n == 0) break block14;
                                if (n == 1) break block15;
                                if (n == 2) {
                                    void var8_9;
                                    object2 = this.zza.entrySet().iterator();
                                    n = Integer.MAX_VALUE;
                                    while (object2.hasNext()) {
                                        object = (Map.Entry)object2.next();
                                        if (((zzfcb)object.getValue()).zzf() >= n) continue;
                                        n = ((zzfcb)object.getValue()).zzf();
                                        zzfcm zzfcm3 = (zzfcm)object.getKey();
                                    }
                                    if (var8_9 != null) {
                                        this.zza.remove(var8_9);
                                    }
                                }
                                break block16;
                            }
                            object = this.zza.entrySet().iterator();
                            Object object3 = object2;
                            while (object.hasNext()) {
                                object2 = (Map.Entry)object.next();
                                if (((zzfcb)object2.getValue()).zze() >= l) continue;
                                l = ((zzfcb)object2.getValue()).zze();
                                zzfcm zzfcm4 = (zzfcm)object2.getKey();
                            }
                            if (var8_12 != null) {
                                this.zza.remove(var8_12);
                            }
                            break block16;
                        }
                        object2 = this.zza.entrySet().iterator();
                        zzazs zzazs2 = object;
                        while (object2.hasNext()) {
                            object = (Map.Entry)object2.next();
                            if (((zzfcb)object.getValue()).zzd() >= l) continue;
                            l = ((zzfcb)object.getValue()).zzd();
                            zzfcm zzfcm5 = (zzfcm)object.getKey();
                        }
                        if (var8_15 != null) {
                            this.zza.remove(var8_15);
                        }
                    }
                    this.zzc.zzd();
                }
                this.zza.put(zzfcm2, zzfcb2);
                this.zzc.zzc();
                zzfcb zzfcb4 = zzfcb2;
            }
            boolean bl = var8_20.zza(zzfcl2);
            this.zzc.zze();
            zzfcm2 = this.zzc.zzf();
            zzfcb2 = var8_20.zzh();
            if (zzfcl2 != null) {
                object2 = zzazu.zza();
                zzazm zzazm2 = zzazn.zza();
                zzazm2.zzd(2);
                object = zzazt.zza();
                object.zza(zzfcm2.zza);
                object.zzb(zzfcm2.zzb);
                object.zzc(zzfcb2.zzb);
                zzazm2.zzc((zzazs)object);
                object2.zza(zzazm2);
                zzfcm2 = (zzazu)object2.zzah();
                zzfcl2.zza.zzP().zze().zzd((zzazu)zzfcm2);
            }
            this.zzf();
            return bl;
        }
    }

    public final boolean zzc(zzfcm zzfcm2) {
        synchronized (this) {
            int n;
            zzfcm2 = this.zza.get(zzfcm2);
            if (zzfcm2 == null) return true;
            int n2 = zzfcm2.zzc();
            if (n2 >= (n = this.zzb.zzd)) return false;
            return true;
        }
    }

    @Deprecated
    public final zzfcm zzd(zzbdg zzbdg2, String string, zzbdr zzbdr2) {
        return new zzfcn(zzbdg2, string, new zzcbn((Context)this.zzb.zza).zza().zzk, this.zzb.zzf, zzbdr2);
    }

    public final zzfcj zze() {
        return this.zzb;
    }
}
