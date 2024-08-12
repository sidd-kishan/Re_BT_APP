/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzvl
 *  com.google.android.gms.internal.ads.zzvy
 *  com.google.android.gms.internal.ads.zzwc
 *  com.google.android.gms.internal.ads.zzwg
 *  com.google.android.gms.internal.ads.zzwh
 *  com.google.android.gms.internal.ads.zzwi
 *  com.google.android.gms.internal.ads.zzwz
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzvl;
import com.google.android.gms.internal.ads.zzvy;
import com.google.android.gms.internal.ads.zzwc;
import com.google.android.gms.internal.ads.zzwg;
import com.google.android.gms.internal.ads.zzwh;
import com.google.android.gms.internal.ads.zzwi;
import com.google.android.gms.internal.ads.zzwz;
import java.io.UnsupportedEncodingException;

public class zzxh
extends zzwc<String> {
    private final Object zza = new Object();
    private final zzwh<String> zzb;

    public zzxh(int n, String string, zzwh<String> zzwh2, zzwg zzwg2) {
        super(n, string, zzwg2);
        this.zzb = zzwh2;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    protected final zzwi<String> zzs(zzvy var1_1) {
        block9: {
            block8: {
                try {
                    var6_3 = var1_1.zzb;
                    var3_4 /* !! */  = var1_1.zzc;
                    var5_6 = "ISO-8859-1";
                    if (var3_4 /* !! */  == null) {
                        var3_4 /* !! */  = var5_6;
                    } else {
                        var7_7 = (String[])var3_4 /* !! */ .get("Content-Type");
                        var3_4 /* !! */  = var5_6;
                        if (var7_7 != null) {
                            var7_7 = var7_7.split(";", 0);
                            var2_8 = 1;
lbl13:
                            // 2 sources

                            while (true) {
                                var3_4 /* !! */  = var5_6;
                                if (var2_8 < var7_7.length) {
                                    var3_4 /* !! */  = var7_7[var2_8].trim().split("=", 0);
                                    if (var3_4 /* !! */ .length != 2 || !var3_4 /* !! */ [0].equals("charset")) break block8;
                                }
                                ** GOTO lbl-1000
                                break;
                            }
                        }
                    }
                    ** GOTO lbl-1000
                }
                catch (UnsupportedEncodingException var3_5) {
                    var3_4 /* !! */  = new String(var1_1.zzb);
                    break block9;
                }
                var3_4 /* !! */  = var3_4 /* !! */ [1];
                ** GOTO lbl-1000
            }
            ++var2_8;
            ** while (true)
lbl-1000:
            // 4 sources

            {
                var4_2 = new String(var6_3, (String)var3_4 /* !! */ );
                var3_4 /* !! */  = var4_2;
            }
        }
        return zzwi.zza((Object)var3_4 /* !! */ , (zzvl)zzwz.zza((zzvy)var1_1));
    }

    /*
     * Enabled unnecessary exception pruning
     */
    protected void zzz(String string) {
        zzwh<String> zzwh2;
        Object object = this.zza;
        synchronized (object) {
            zzwh2 = this.zzb;
        }
        zzwh2.zza((Object)string);
    }
}
