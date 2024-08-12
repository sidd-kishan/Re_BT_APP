/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  com.google.android.gms.internal.ads.zzfgg
 *  com.google.android.gms.internal.ads.zzfgr
 *  com.google.android.gms.internal.ads.zzfgu
 *  com.google.android.gms.internal.ads.zzfhl
 *  com.google.android.gms.internal.ads.zzfhm
 */
package com.google.android.gms.internal.ads;

import android.view.View;
import com.google.android.gms.internal.ads.zzfgg;
import com.google.android.gms.internal.ads.zzfgr;
import com.google.android.gms.internal.ads.zzfgu;
import com.google.android.gms.internal.ads.zzfhl;
import com.google.android.gms.internal.ads.zzfhm;
import java.util.HashMap;
import java.util.HashSet;

public final class zzfhn {
    private final HashMap<View, String> zza = new HashMap();
    private final HashMap<View, zzfhm> zzb = new HashMap();
    private final HashMap<String, View> zzc = new HashMap();
    private final HashSet<View> zzd = new HashSet();
    private final HashSet<String> zze = new HashSet();
    private final HashSet<String> zzf = new HashSet();
    private final HashMap<String, String> zzg = new HashMap();
    private boolean zzh;

    public final HashSet<String> zza() {
        return this.zze;
    }

    public final HashSet<String> zzb() {
        return this.zzf;
    }

    public final String zzc(String string) {
        return this.zzg.get(string);
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public final void zzd() {
        var2_1 /* !! */  = zzfgr.zza();
        if (var2_1 /* !! */  == null) return;
        var6_2 = var2_1 /* !! */ .zzf().iterator();
        while (true) {
            block7: {
                block10: {
                    block8: {
                        block9: {
                            if (var6_2.hasNext() == false) return;
                            var7_7 = (zzfgg)var6_2.next();
                            var3_4 = var7_7.zzi();
                            if (!var7_7.zzj()) continue;
                            var8_8 = var7_7.zzh();
                            if (var3_4 == null) break block8;
                            var1_3 = var3_4.hasWindowFocus();
                            var4_5 = null;
                            if (var1_3) break block9;
                            var2_1 /* !! */  = "noWindowFocus";
                            break block7;
                        }
                        var9_9 = new HashSet<zzfgr>();
                        var2_1 /* !! */  = var3_4;
                        break block10;
                    }
                    this.zzf.add(var8_8);
                    this.zzg.put(var8_8, "noAdView");
                    continue;
                }
                while (var2_1 /* !! */  != null) {
                    var5_6 = zzfhl.zzb((View)var2_1 /* !! */ );
                    if (var5_6 != null) {
                        var2_1 /* !! */  = var5_6;
                        break block7;
                    }
                    var9_9.add(var2_1 /* !! */ );
                    var2_1 /* !! */  = var2_1 /* !! */ .getParent();
                    if (var2_1 /* !! */  instanceof View) {
                        var2_1 /* !! */  = (View)var2_1 /* !! */ ;
                        continue;
                    }
                    var2_1 /* !! */  = null;
                }
                this.zzd.addAll(var9_9);
                var2_1 /* !! */  = var4_5;
            }
            if (var2_1 /* !! */  != null) {
                this.zzf.add(var8_8);
                this.zzc.put(var8_8, var3_4);
                this.zzg.put(var8_8, (String)var2_1 /* !! */ );
                continue;
            }
            this.zze.add(var8_8);
            this.zza.put(var3_4, var8_8);
            var4_5 = var7_7.zzf().iterator();
            while (true) {
                if (!var4_5.hasNext()) ** break;
                var3_4 = (zzfgu)var4_5.next();
                var2_1 /* !! */  = (View)var3_4.zza().get();
                if (var2_1 /* !! */  == null) continue;
                var5_6 = this.zzb.get(var2_1 /* !! */ );
                if (var5_6 != null) {
                    var5_6.zza(var7_7.zzh());
                    continue;
                }
                this.zzb.put((View)var2_1 /* !! */ , new zzfhm((zzfgu)var3_4, var7_7.zzh()));
            }
            break;
        }
    }

    public final void zze() {
        this.zza.clear();
        this.zzb.clear();
        this.zzc.clear();
        this.zzd.clear();
        this.zze.clear();
        this.zzf.clear();
        this.zzg.clear();
        this.zzh = false;
    }

    public final void zzf() {
        this.zzh = true;
    }

    public final String zzg(View view) {
        if (this.zza.size() == 0) {
            return null;
        }
        String string = this.zza.get(view);
        if (string == null) return string;
        this.zza.remove(view);
        return string;
    }

    public final View zzh(String string) {
        return this.zzc.get(string);
    }

    public final zzfhm zzi(View view) {
        zzfhm zzfhm2 = this.zzb.get(view);
        if (zzfhm2 == null) return zzfhm2;
        this.zzb.remove(view);
        return zzfhm2;
    }

    public final int zzj(View view) {
        if (this.zzd.contains(view)) {
            return 1;
        }
        if (!this.zzh) return 3;
        return 2;
    }
}
