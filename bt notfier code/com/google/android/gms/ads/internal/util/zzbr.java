/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.google.android.gms.ads.internal.util.zzba
 *  com.google.android.gms.ads.internal.util.zzbj
 *  com.google.android.gms.ads.internal.util.zzbk
 *  com.google.android.gms.ads.internal.util.zzbl
 *  com.google.android.gms.ads.internal.util.zzbm
 *  com.google.android.gms.ads.internal.util.zzbo
 *  com.google.android.gms.ads.internal.util.zzbq
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.common.util.ClientLibraryUtils
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzcgs
 *  com.google.android.gms.internal.ads.zzchl
 *  com.google.android.gms.internal.ads.zzfsm
 *  com.google.android.gms.internal.ads.zzvk
 *  com.google.android.gms.internal.ads.zzvy
 *  com.google.android.gms.internal.ads.zzwc
 *  com.google.android.gms.internal.ads.zzwf
 *  com.google.android.gms.internal.ads.zzwg
 *  com.google.android.gms.internal.ads.zzwh
 *  com.google.android.gms.internal.ads.zzxj
 */
package com.google.android.gms.ads.internal.util;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zzba;
import com.google.android.gms.ads.internal.util.zzbj;
import com.google.android.gms.ads.internal.util.zzbk;
import com.google.android.gms.ads.internal.util.zzbl;
import com.google.android.gms.ads.internal.util.zzbm;
import com.google.android.gms.ads.internal.util.zzbo;
import com.google.android.gms.ads.internal.util.zzbq;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.common.util.ClientLibraryUtils;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzcgs;
import com.google.android.gms.internal.ads.zzchl;
import com.google.android.gms.internal.ads.zzfsm;
import com.google.android.gms.internal.ads.zzvk;
import com.google.android.gms.internal.ads.zzvy;
import com.google.android.gms.internal.ads.zzwc;
import com.google.android.gms.internal.ads.zzwf;
import com.google.android.gms.internal.ads.zzwg;
import com.google.android.gms.internal.ads.zzwh;
import com.google.android.gms.internal.ads.zzxj;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public final class zzbr {
    @Deprecated
    public static final zzbm<Void> zza;
    private static zzwf zzb;
    private static final Object zzc;

    static {
        zzc = new Object();
        zza = new zzbj();
    }

    /*
     * Unable to fully structure code
     */
    public zzbr(Context var1_1) {
        super();
        if (var1_1.getApplicationContext() != null) {
            var1_1 = var1_1.getApplicationContext();
        }
        var2_3 = zzbr.zzc;
        synchronized (var2_3) {
            if (zzbr.zzb != null) return;
            zzbjl.zza((Context)var1_1);
            if (ClientLibraryUtils.isPackageSide()) ** GOTO lbl-1000
            var3_4 = zzbjl.zzcQ;
            if (((Boolean)zzbet.zzc().zzc(var3_4)).booleanValue()) {
                var1_1 = zzba.zzb((Context)var1_1);
            } else lbl-1000:
            // 2 sources

            {
                var1_1 = zzxj.zza((Context)var1_1, null);
            }
            zzbr.zzb = var1_1;
            return;
        }
    }

    public final zzfsm<zzvy> zza(String string) {
        zzchl zzchl2 = new zzchl();
        zzb.zzb((zzwc)new zzbq(string, null, zzchl2));
        return zzchl2;
    }

    public final zzfsm<String> zzb(int n, String string, Map<String, String> zzbl2, byte[] byArray) {
        zzbo zzbo2 = new zzbo(null);
        zzbk zzbk2 = new zzbk(this, string, zzbo2);
        zzcgs zzcgs2 = new zzcgs(null);
        zzbl2 = new zzbl(this, n, string, (zzwh)zzbo2, (zzwg)zzbk2, byArray, zzbl2, zzcgs2);
        if (zzcgs.zzj()) {
            try {
                zzcgs2.zzb(string, "GET", zzbl2.zzn(), zzbl2.zzo());
            }
            catch (zzvk zzvk2) {
                zze.zzi((String)zzvk2.getMessage());
            }
        }
        zzb.zzb((zzwc)zzbl2);
        return zzbo2;
    }
}
