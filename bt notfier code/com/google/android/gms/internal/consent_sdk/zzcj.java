/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.consent_sdk.zzci
 *  com.google.android.gms.internal.consent_sdk.zzcj$zza
 *  com.google.android.gms.internal.consent_sdk.zzcm
 *  com.google.android.gms.internal.consent_sdk.zzco
 */
package com.google.android.gms.internal.consent_sdk;

import com.google.android.gms.internal.consent_sdk.zzci;
import com.google.android.gms.internal.consent_sdk.zzcj;
import com.google.android.gms.internal.consent_sdk.zzcm;
import com.google.android.gms.internal.consent_sdk.zzco;

public final class zzcj {
    private static final zzci zza;
    private static final int zzb;

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    static {
        block9: {
            block8: {
                var0 = 1;
                try {
                    var2_1 = zzcj.zza();
                    if (var2_1 != null) {
                    }
                    ** GOTO lbl-1000
                }
                catch (Throwable var1_4) {
                    var2_1 = null;
                    break block8;
                }
                try {
                    if (var2_1 >= 19) {
                        var1_2 /* !! */  = new zzco();
                    } else lbl-1000:
                    // 2 sources

                    {
                        var1_2 /* !! */  = Boolean.getBoolean("com.google.devtools.build.android.desugar.runtime.twr_disable_mimic") ^ true ? new zzcm() : new zza();
                    }
                    break block9;
                }
                catch (Throwable var1_3) {}
            }
            var4_5 = System.err;
            var3_6 = zza.class.getName();
            var5_7 = new StringBuilder(String.valueOf(var3_6).length() + 133);
            var5_7.append("An error has occurred when initializing the try-with-resources desuguring strategy. The default strategy ");
            var5_7.append(var3_6);
            var5_7.append("will be used. The error is: ");
            var4_5.println(var5_7.toString());
            var1_2 /* !! */ .printStackTrace(System.err);
            var1_2 /* !! */  = new zza();
        }
        zzcj.zza = var1_2 /* !! */ ;
        if (var2_1 != null) {
            var0 = var2_1;
        }
        zzcj.zzb = var0;
    }

    private static Integer zza() {
        try {
            Integer n = (Integer)Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null);
            return n;
        }
        catch (Exception exception) {
            System.err.println("Failed to retrieve value from android.os.Build$VERSION.SDK_INT due to the following exception.");
            exception.printStackTrace(System.err);
            return null;
        }
    }

    public static void zza(Throwable throwable, Throwable throwable2) {
        zza.zza(throwable, throwable2);
    }
}
